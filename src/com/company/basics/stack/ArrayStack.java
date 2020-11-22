package com.company.basics.stack;

import java.util.Vector;

/**
 * 数组堆栈
 */
public class ArrayStack<T> implements Stack<T>{
    private T[] data;
    private Integer size;

    //设置长度
    public ArrayStack(int size) {
        this.data = (T[])new Object[size];
        this.size = 0;
    }

    @Override
    public void push(T element) {
        if(this.data.length > size)
            this.data[size++] = element;
    }

    @Override
    public void pop() {
        if(size > 0)
            size--;
    }

    @Override
    public T top() {
        if(size > 0)
            return this.data[size - 1];
        return null;
    }

    @Override
    public Boolean empty() {
        return size == 0;
    }

    @Override
    public Integer size() {
        return size;
    }

    @Override
    public void toAll() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.data[i] + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack<Integer>(20);

        arrayStack.push(1);
        System.out.println(arrayStack.top());

        arrayStack.push(2);
        System.out.println(arrayStack.top());

        arrayStack.push(3);
        System.out.println(arrayStack.top());

        arrayStack.pop();
        System.out.println(arrayStack.top());

        arrayStack.toAll();
    }
}
