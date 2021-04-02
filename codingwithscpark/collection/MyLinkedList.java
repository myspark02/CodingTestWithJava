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

    public void remove(int index) {
        Node<T> tmp = traverse(index);
        if (tmp != null) {
            if (tmp != head) {
                tmp.prev.next = tmp.next;
                tmp.prev = null;
                tmp.next = null;
            } else { // head remove
                head = head.next;
                if (head.next != null) {
                    head.next.prev = null;
                }
            }
            size--;
        }
    }

    public void remove() {
        if (tail != null) {
            Node<T> tmp = tail;
            tail = tail.prev;
            tmp.prev = null;
            if (tail != null) tail.next = null;
            
            size--;
        }
    }

    public T getFirst() {
            if (head == null) return null;
            return head.value;
    }

    public T getLast() {
        if (tail == null) return null;
        return tail.value;
    }

    public void add(int index, T value) {
        Node<T> tmp = traverse(index-1);

        Node<T> newNode = new Node<>();
        newNode.value = value;

        if (tmp != head) {

            tmp.prev.next = newNode;
            
            newNode.next = tmp;
            newNode.prev = tmp.prev;

            tmp.prev = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
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

        list.add(0, 200);
        list.add(0, 300);
        list.add(0, 400);
        list.add(0, 500);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        list.remove(0);
        list.remove(0);
        list.remove(2);

        list.remove();
        list.remove();
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
