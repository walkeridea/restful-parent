package com.walker.restfulapi.common.redis;


public interface Function<T,E> {
    T callback(E e);
}
