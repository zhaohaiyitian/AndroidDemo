package com.wj.wjnews.framework.ioc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author: jackey
 * date: 18-6-5
 */
@Retention(RetentionPolicy.RUNTIME)//什么时候生效 RUNTIME 运行时检测 CLASS 编译时  SOURCE 源码资源
@Target(ElementType.FIELD)
public @interface ViewById {
    int value();
}
