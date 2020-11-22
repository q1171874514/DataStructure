package com.company.basics.stack;

/**
 * 堆栈接口
 */
public interface Stack<T> {
    //元素入栈
    void push(T element);

    //元素出栈
    void pop();

    //访问栈顶元素
    T top();

    //判断栈是否为空
    Boolean empty();

    //访问栈中的元素个数
    Integer size();

    //输出所有元素
    void toAll();
}
