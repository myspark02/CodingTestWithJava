package codingwithscpark.collection;

import java.util.*;
import java.util.stream.IntStream;

public class MyLinkedList<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    public void add(T value) {
        if (head == null) {
            tail = head = new Node<>();
            head.value = value;
        } else {
            Node<T> tmp = head;
            while(tmp.next != null) {
                tmp = tmp.next;
            }
            Node<T> newNode = new Node<>();
            newNode.value = value;
            tmp.next = newNode;
            newNode.prev = tmp;
            tail = newNode;
        }
        size++;
    }

    public int size() {
        return size;
    }

    private Node<T> traverse(int index) {
        int idx = 0;
        Node<T> tmp = head;
        while(idx<index && tmp != null) {
            tmp = tmp.next;
            idx++;
        }
        return tmp;
    }

    public void add(int index, T value) {
        Node<T> tmp = traverse(index-1);
        if (tmp != head) {
            Node<T> newNode = new Node<>();
            newNode.value = value;

            tmp.prev.next = newNode;
            
            newNode.next = tmp;
            newNode.prev = tmp.prev;

            tmp.prev = newNode;
        } else {

        }

        size++;
       
    }

    public T get(int index) {
        Node<T> tmp = traverse(index);
        if (tmp != null) return tmp.value;
        return null;
    }

    private class Node<T> {
        Node<T> prev;
        T value;
        Node<T> next;
    }

    public static void main(String[] args) {
        // LinkedList<Integer> list = new LinkedList<>();
         MyLinkedList<Integer> list = new MyLinkedList<>();
        IntStream.rangeClosed(1, 10).forEach(i -> list.add(i));


        // for (int i = 0; i < list.size(); i++) {
        //     System.out.println(list.get(i));
        // }

        list.add(4, 100);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
   
    }
}
