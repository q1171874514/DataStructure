package com.company.basics.queue;

/**
 * 队列接口类
 * @param <T>
 */
public interface Queue<T> {
    //元素入队
    Queue<T> push(T element);

    //元素出队
    Queue<T> pop();

    //访问顶元素
    T top();

    //判断是否为空
    Boolean empty();

    //访问队中的元素个数
    Integer size();

    //输出所有元素
    Queue<T> toAll();
}
