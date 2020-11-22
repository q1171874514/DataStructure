package com.company.basics.stack;

/**
 * 链表堆栈
 */
public class LinkedListStack<T> implements Stack<T>{
    private T levelElement;
    private LinkedListStack<T> lowerStack;
    private Integer size = 0;
    @Override
    public void push(T element) {
        LinkedListStack<T> elementStack = new LinkedListStack<T>();
        elementStack.levelElement = element;
        elementStack.lowerStack = this.lowerStack;
        this.lowerStack = elementStack;
        this.size++;
    }

    @Override
    public void pop() {
        if(size > 0){
            this.lowerStack = this.lowerStack.lowerStack;
            size--;
        }
    }

    @Override
    public T top() {
        if (size > 0)
            return this.lowerStack.levelElement;
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
    public void toAll() {
        LinkedListStack<T> linkedListStack = this;
        for(int i = 0; i < size; i++) {
            linkedListStack = linkedListStack.lowerStack;
            System.out.print(linkedListStack.levelElement + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<Integer>();

        linkedListStack.push(1);
        System.out.println(linkedListStack.top());

        linkedListStack.push(2);
        System.out.println(linkedListStack.top());

        linkedListStack.pop();
        System.out.println(linkedListStack.top());

        linkedListStack.push(3);
        System.out.println(linkedListStack.top());
    }
}
