package com.revature.util;

import com.revature.models.Account;

import java.lang.reflect.InvocationTargetException;

public class GenericLinkedList <T> {

    public Node<T> head = null;
    public Node<T> tail = null;

    private int size;

    public void add(T data) {

        Node<T> newNode = new Node<T>(data);

        if(head == null) {
            //If the list is empty, both the head and tail will point to the first Node
            head = newNode;
            tail = newNode;
        } else {
            //First update the current tail's next reference to this new element/Node.
            tail.next = newNode;
            //Then update the tail to reference this new Node.
            tail = newNode;
        }

        size++;
    }

    public int getSize(){

        return size;
    }

    public T get(int index){

        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index is less that 0 or above the List's size");
        }


        Node<T> iterator = head;

        for (int i = 0; i < index; i++){
            iterator = iterator.next;
        }

        return iterator.data;

    }


    public String toString() {

        String result = "(";

        Node<T> current = head;

        while(current != null) {
            result += current.data;

            if(current != tail) {
                result += ", ";
            }

            current = current.next;
        }

        result += ")";
        return result;
    }

    public T find(int id) {

        Node<T> iterator = head;

        for(int i = 0; i < size; i++){
            T element = iterator.data;
            try{
                if ((int) element.getClass().getMethod("getId").invoke(element) == id ) {
                    return element;
                }
            }catch (NoSuchMethodException e){
                continue;
            }catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
            iterator = iterator.next;
        }
     return null;
    }
}