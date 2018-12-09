package com.onlinepay.manage.common.log;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.slf4j.LoggerFactory;

/**
 * TODO:
 * Created by tom on 17/7/5.
 */
public abstract class BaseLog<T> {
    private Class<T> entityClass;

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public BaseLog(){
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        entityClass = (Class) params[0];
    }

    public org.slf4j.Logger log(){
        return LoggerFactory.getLogger(entityClass);
    }
}
