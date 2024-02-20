/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Model.customer;

/**
 *
 * @author Ravindu Haputhanthri
 */
public class ListCus {

    //---------Inner Class---------

    class Node {

        private customer data;
        private Node next;

        Node(customer data) {
            this.data = data;
        }
    }
    private Node first;

    private boolean isEmpty() {
        return first == null;
    }

    public int size() {
        int count = 0;
        Node temp = first;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void add(customer data) {
        Node n1 = new Node(data);
        if (isEmpty()) {
            first = n1;
        } else {
            Node lastNode = first;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = n1;
        }
    }

    public void add(int index, customer data) {
        Node n1 = new Node(data);
        if (index >= 0 && index <= size()) {
            if (index == 0) {
                first = n1;
            } else {
                int count = 0;
                Node temp = first;
                while (count < index - 1) {
                    temp = temp.next;
                    count++;
                }
                n1.next = temp.next;
                temp.next = n1;
            }
        }
    }

    public customer get(int index) {
        if (index >= 0 && index < size()) {
            int count = 0;
            Node temp = first;
            while (count < index) {
                temp = temp.next;
                count++;
            }
            return temp.data;
        }
        return null;
    }

    public int search(customer data) {
        Node temp = first;
        int index = 0;
        while (temp != null) {
            if (temp.data == data) {
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }

    public boolean contains(customer data) {
        return search(data) != -1;
    }

    public void printList() {
        Node temp = first;
        System.out.print("[");
        while (temp != null) {
            System.out.println(temp.data + ", ");
            temp = temp.next;
        }
        System.out.println(first == null ? "empty]" : "\b\b]");
    }

    public customer[] toArray() {
        customer[] tempArray = new customer[size()];
        int i = 0;
        Node temp = first;
        while (temp != null) {
            tempArray[i++] = temp.data;
            temp = temp.next;
        }
        return tempArray;
    }

    //Removing the first element

    public void remove() {
        if (first != null) {
            first = first.next;
        }
    }

    public void remove(int index) {
        if (index >= 0 && index < size()) {
            Node temp = first;
            int count = 0;
            while (count < index - 1) {
                temp = temp.next;
                count++;
            }
            Node temp2 = temp.next;
            temp = temp2.next;
        }
    }

    public void clear() {
        first = null;
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }
}
