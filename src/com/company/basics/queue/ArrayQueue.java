package com.company.basics.queue;

/**
 * 数组队列
 */
public class ArrayQueue<T> implements Queue<T> {
    private T[] data;
    private Integer size;
    private Integer head;

    //初始化
    public ArrayQueue(Integer size) {
        this.data = (T[])new Object[size];
        this.size = 0;
        this.head = 0;
    }

    @Override
    public Queue<T> push(T element) {
        if (this.size < this.data.length) {
            this.data[(this.head + this.size) % this.data.length] = element;
            this.size ++;
        }
        return this;
    }

    @Override
    public Queue<T> pop() {
        if(this.size > 0) {
            this.head = (this.head + 1) % this.data.length;
            this.size--;
        }
        return this;
    }

    @Override
    public T top() {
        return this.data[this.head];
    }

    @Override
    public Boolean empty() {
        return this.size == 0;
    }

    @Override
    public Integer size() {
        return this.size;
    }

    @Override
    public Queue<T> toAll() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.data[(this.head + i) % this.data.length] + "  ");
        }
        System.out.println();
        return this;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<Integer>(10);

        arrayQueue.push(2)
                .push(4)
                .push(5)
                .push(8)
                .toAll()
                .pop()
                .toAll()
                .pop()
                .toAll();
    }
}
