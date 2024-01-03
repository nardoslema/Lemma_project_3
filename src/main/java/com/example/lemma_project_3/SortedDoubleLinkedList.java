/**
 * Author:- Nardos Lemma
 *CMSC 204
 */

package com.example.lemma_project_3;

import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends
        BasicDoubleLinkedList<T> {

    private Comparator<T> comparator = null;

    /**
     * Constructor
     * @param comparator
     */
    public SortedDoubleLinkedList(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    /**
     * Inserts the specified element at the correct position in the sorted list.
     * @param data
     */
    public void add(T data) {
        if (data != null) {
            Node newNode = new Node<>(data);

            if (head == null) {
                head = tail = newNode;
                length++;
            } else {
                if (comparator.compare(data, (T) tail.data) >= 0) {
                    //if data is larger than tail.data
                    tail.next = newNode;
                    tail = newNode;
                    length++;
                } else if (comparator.compare(data, (T) head.data) <= 0) {
                    //if data is less than head.data
                    newNode.next = head;
                    head = newNode;
                    length++;
                } else {
                    Node nextNode = head.next;
                    Node previousNode = head;
                    while (comparator.compare(data, (T) nextNode.data) > 0) {
                        //This while loop will execute until newNode is in the right spot
                        previousNode = nextNode;
                        nextNode = nextNode.next;
                    }
                    //Previous Next
                    //  Node Node Node Node NewNode Node Node
                    previousNode.next = newNode;
                    newNode.next = nextNode;
                    length++;
                }
            }
        }
    }

    /**
     * This operation is invalid for a sorted list.
     * @param data
     * @throws UnsupportedOperationException
     */
    public void addToEnd(T data) throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }

    /**
     * This operation is invalid for a sorted list.
     * @param data
     * @throws UnsupportedOperationException
     */
    public void addToFront(T data) throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }

    /**
     * Implements the remove operation by calling the super class remove method.
     * @param data
     * @param comparator
     * @return
     */
    public Node remove(T data, Comparator<T> comparator){
        return super.remove(data,comparator);
    }

    /**
     * Implements the iterator by calling the super class iterator method.
     * @return
     */

    public ListIterator<T> iterator(){
        return super.iterator();
    }




}
