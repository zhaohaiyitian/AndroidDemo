package com.wj.wjnews.ui.activity.designPattern.singleton;

/**
 * Created by wj on 18-4-16.
 * 单例模式的几种写法
 */

public class SingletonManager {
    private static SingletonManager instance;

    private SingletonManager() {} //让构造函数为private,这样该类就不会被实例化

    /**
     * 双重校验锁(懒汉式) 安全 在多线程情况下能保持高性能
     * @return
     */
    public static SingletonManager getInstance() {
        if (instance==null) {
            synchronized (SingletonManager.class) {
                if (instance==null) {
                    instance=new SingletonManager();
                }
            }
        }
        return instance;
    }

    /**
     * 静态内部类方式 多线程安全
     * 能达到双检锁的功效
     * 利用classloader机制保证初始化instance时只有一个线程
     */
    private static class  SingleHolder {
        public static final SingletonManager instance=new SingletonManager();
    }
    //private SingletonManager(){}
    public static final SingletonManager getInnerInstance() {
        return SingleHolder.instance;
    }

    /**
     * 枚举实现单例 线程安全
     */
    public enum SingleTon {
        INSTANCE;
    }

}
