package com.company.basics.queue;

/**
 * 链表队列
 */
public class LinkedListQueue<T> implements Queue<T>{
    private T element;
    private LinkedListQueue<T> upper;
    private LinkedListQueue<T> lower;
    private Integer size = 0;

    public LinkedListQueue() {
        this.upper = this;
    }
    @Override
    public LinkedListQueue<T> push(T element) {
        LinkedListQueue<T> elementQueue = new LinkedListQueue<T>();
        elementQueue.element = element;
        elementQueue.upper = this.upper;
        this.upper.lower = elementQueue;
        this.upper = elementQueue;
        this.size ++;
        return this;
    }

    @Override
    public LinkedListQueue<T> pop() {
        if(size > 0){
            this.lower = this.lower.lower;
            size--;
        }
        return this;
    }

    @Override
    public T top() {
        if (size > 0)
            return this.lower.element;
        return null;
    }

    @Override
    public Boolean empty() {
        return this.size == 0;
    }

    @Override
    public Integer size() {
        return size;
    }

    @Override
    public LinkedListQueue<T> toAll() {
        LinkedListQueue<T> linkedListQueue = this;
        for(int i = 0; i < size; i++) {
            linkedListQueue = linkedListQueue.lower;
            System.out.print(linkedListQueue.element + "  ");
        }
        System.out.println();
        return this;
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<Integer>();
        linkedListQueue.push(2)
                .toAll()
                .push(5)
                .push(6)
                .push(8)
                .toAll()
                .pop()
                .toAll();

        System.out.println(linkedListQueue.top());
        linkedListQueue.pop()
                .toAll()
                .push(4)
                .toAll();
    }
}
