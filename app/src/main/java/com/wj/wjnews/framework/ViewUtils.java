package com.wj.wjnews.framework;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.Toast;

import com.wj.wjnews.framework.ioc.CheckNet;
import com.wj.wjnews.framework.ioc.OnClick;
import com.wj.wjnews.framework.ioc.ViewById;
import com.wj.wjnews.framework.ioc.ViewFinder;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * author: jackey
 * date: 18-6-5
 * View的findViewById的辅助类
 */
public class ViewUtils {

    public static void inject(Activity activity) {
        inject(new ViewFinder(activity),activity);
    }

    public static void inject(View view) {
        inject(new ViewFinder(view),view);
    }
    public static void inject(View view,Object object) {
        inject(new ViewFinder(view),object);
    }

    //object 反射需要执行的类
    public static void inject(ViewFinder viewFinder, Object object) {
        injectField(viewFinder,object);
        injectEvent(viewFinder,object);

    }

    private static void injectEvent(ViewFinder viewFinder, Object object) {
        //1.遍历类里面所有的方法
        Class<?> clazz = object.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            OnClick click = method.getAnnotation(OnClick.class);
            if (click!=null) {
                //2.获取onClick的里面的value值
                int[] viewIds = click.value();
                for (int viewId : viewIds) {
                    //3.findViewById找到view
                    View view = viewFinder.findViewById(viewId);

                    boolean isCheckNet=method.getAnnotation(CheckNet.class)!=null;

                    if (view!=null) {
                        //4.调用setOnclickListener
                        view.setOnClickListener(new DeclaredOnClickListener(method,object,isCheckNet));
                    }
                }

            }
        }
    }

    private static boolean checkNetWorkAvaiable(Context context) {
        //得到连接管理器对象
        ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo!=null&&networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    private static class DeclaredOnClickListener implements View.OnClickListener {
        private Method method;
        private Object object;
        private boolean isChecketNet;
        public DeclaredOnClickListener(Method method, Object object, boolean isCheckNet) {
            this.method=method;
            this.object=object;
            this.isChecketNet=isCheckNet;
        }

        @Override
        public void onClick(View v) {

            if (isChecketNet) {
                if (!checkNetWorkAvaiable(v.getContext())) {
                    Toast.makeText(v.getContext(), "网络不给力", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
           //点击会调用该方法
            try {
                method.setAccessible(true);//暴力反射
                //5.反射调用方法
                method.invoke(object,v);
            } catch (Exception e) {
                try {
                    method.invoke(object,null);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    private static void injectField(ViewFinder viewFinder, Object object) {
        //1.遍历类里面所有的属性
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();//获取所有属性包括公有和私有
        //2.获取ViewById的里面的value值
        for (Field field : fields) {
            ViewById viewById = field.getAnnotation(ViewById.class);
            if (viewById!=null) {
                //获取注解里面的id值
                int value = viewById.value();
                //3.findViewById找到view
                View view = viewFinder.findViewById(value);
                if (view!=null) {
                    field.setAccessible(true);//暴力反射
                    try {
                        //4.动态的注入找到的view
                        field.set(object,view);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
