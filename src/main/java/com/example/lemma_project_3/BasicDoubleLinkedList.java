/**
 * Author:- Nardos Lemma
 *CMSC 204
 */

package com.example.lemma_project_3;

import java.util.*;

public class BasicDoubleLinkedList <T> implements Iterable {

    /**
     * Constructor
     *
     */

    public BasicDoubleLinkedList() {
        this.length = 0;
        this.head = null;
        this.tail = null;
    }

    int length = 0;
    Node head;
    Node tail;

    /**
     *Adds an element to the end of the list and updated the size of the list
     * @param data
     */
    public void addToEnd(T data){
        Node newNode = new Node<>(data);
        if(isEmpty()){
            head = newNode;
            tail = newNode;
            length ++;
        }

        else{
            tail.next = newNode;
            tail.prev = tail;
            tail = newNode;
            length ++;
        }



    }

    /**
     *
     * Adds element to the front of the list and updated the size of the list
     * @param data
     */

    public void addToFront (T data){
        Node newNode = new Node<>(data);
        if(isEmpty()){
            tail = newNode;
            head = newNode;
            length ++;
        }
        else{
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            length ++;
        }
    }

    /**
     * Returns but does not remove the first element from the list.
     * @return
     */
    public T getFirst(){
        if(isEmpty()){
            return null;
        }
        return  (T)head;
    }

    /**
     * Returns but does not remove the last element from the list.
     * @return
     */
    public T getLast(){
        if(isEmpty()){
            return null;
        }
        return  (T)tail;
    }

    /**
     *
     * @returns the length
     */
    public int getSize(){
        return length;
    }

    /**
     *
     * @return doubleLinkListIterator
     */
    public ListIterator<T> iterator() {
        DoubleLinkListIterator doubleLinkListIterator = new DoubleLinkListIterator<>();
        return doubleLinkListIterator;
    }

    /**
     *
     * @return a boolean checking if it is empty or not
     */
    boolean isEmpty (){
        if (length == 0){
            return true;
        }
        return false;
    }

    /**
     * Removes the first instance of the targetData from the lis
     * @param targetData
     * @param comparator
     * @return
     */
    public Node remove(T targetData, Comparator<T> comparator){
        Node currentNode = null;
        currentNode = head;

        while(currentNode != null){
            if(comparator.compare(targetData, (T) currentNode.data) == 0){
                if(currentNode == head){
                    head = head.next;
                    length --;
                    return currentNode;
                }
                if(currentNode == tail){
                    tail = tail.prev;
                    length --;
                    return currentNode;
                }
                else {
                    currentNode.prev.next = currentNode.next;
                    length --;
                    return currentNode;

                }
            }
            currentNode = currentNode.next;

        }
        return null;
    }

    /**
     * Removes and returns the first element from the list
     * @return head
     */
    public T retrieveFirstElement(){
        if(head == null){
            return null;
        }
        Node temp = head;
        head = head.next;
        return (T) temp.data;
    }

    /**
     * Removes and returns the last element from the list.
     * @return the last element
     */
    public T retrieveLastElement(){
        if(head == null){
            return null;
        }
        Node temp = tail;
        tail = tail.prev;
        return (T) temp.data;
    }

    /**
     *Returns an arraylist of all the items in the Double Linked list
     * @return arrayList
     */
    public ArrayList<T> toArrayList(){
        ArrayList <T> arrayList = new ArrayList<>();
        if(!isEmpty()){
            Node currentNode = head;
            while(currentNode != null){
                arrayList.add((T) currentNode.data);
                currentNode = currentNode.next;
            }
        }
        return arrayList;
    }

    /**
     *
     * @param <T>
     */

    class DoubleLinkListIterator<T> implements ListIterator{
        Node currentNode = null;
        Node previousNode = null;
        Node nextNode = null;
        public DoubleLinkListIterator() {
            currentNode = head;
        }

        @Override
        public boolean hasNext() {
            if(currentNode.next != null){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            T temp = null;
            if(!isEmpty()){
                if(currentNode != null){
                    temp = (T) currentNode.data;
                    if(hasNext()){
                        previousNode = currentNode;
                        currentNode = currentNode.next;
                        currentNode.prev = previousNode;
                        return temp;
                    }
                    throw new NoSuchElementException();
                }
            }
            throw new NoSuchElementException();
        }

        /**
         * sees if it has previous
         * @return
         */
        @Override
        public boolean hasPrevious() {
            if(currentNode.prev != null){
                return true;
            }
            return false;
        }

        @Override
        public Object previous() throws NoSuchElementException{
            T temp = null;
            if(!isEmpty()){
                if(currentNode != null){
                    temp = (T) currentNode.data;
                    if(hasPrevious()){
                        nextNode = currentNode;
                        currentNode = currentNode.prev;
                        currentNode.next = nextNode;
                        return temp;
                    }
                    throw new NoSuchElementException();
                }
            }
            throw new NoSuchElementException();
        }

        @Override
        public int nextIndex() throws UnsupportedOperationException{
            throw new UnsupportedOperationException();
        }

        @Override
        public int previousIndex()  throws UnsupportedOperationException{
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove()  throws UnsupportedOperationException{
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(Object o)  throws UnsupportedOperationException{
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(Object o)  throws UnsupportedOperationException{
            throw new UnsupportedOperationException();
        }

    }

    /**
     * A generic inner class Node
     * @param <T>
     */

    class Node<T>{
        T data;
        Node prev;
        Node next;
        public Node(T dataNode) {
            this.data = dataNode;
        }
    }

}
