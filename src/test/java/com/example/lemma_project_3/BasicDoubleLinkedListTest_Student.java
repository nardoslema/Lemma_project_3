package com.example.lemma_project_3;
/**
 * Author:- Nardos Lemma
 *CMSC 204
 */
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class BasicDoubleLinkedListTest_Student {
    BasicDoubleLinkedList basicDoubleLinkedList = new BasicDoubleLinkedList();


    MyComparator comparator= new MyComparator();

    @Test
    public void addToEnd() {
        basicDoubleLinkedList.addToEnd("test string 1");
        basicDoubleLinkedList.addToEnd("test string 2");
        basicDoubleLinkedList.addToEnd("test string 3");
        basicDoubleLinkedList.addToFront("test string 4");
        BasicDoubleLinkedList.Node node = (BasicDoubleLinkedList.Node)basicDoubleLinkedList.getLast();
        Assert.assertEquals("test string 3", node.data);
    }

    @Test
    public void addToFront() {
        basicDoubleLinkedList.addToEnd("test string 1");
        basicDoubleLinkedList.addToEnd("test string 2");
        basicDoubleLinkedList.addToEnd("test string 3");
        basicDoubleLinkedList.addToFront("test string 4");
        BasicDoubleLinkedList.Node node = (BasicDoubleLinkedList.Node)basicDoubleLinkedList.getFirst();
        Assert.assertEquals("test string 4", node.data);
    }

    @Test
    public void getFirst() {
        basicDoubleLinkedList.addToEnd("test string 1");
        basicDoubleLinkedList.addToEnd("test string 2");
        basicDoubleLinkedList.addToEnd("test string 3");
        basicDoubleLinkedList.addToFront("test string 4");
        BasicDoubleLinkedList.Node node = (BasicDoubleLinkedList.Node)basicDoubleLinkedList.getFirst();
        Assert.assertEquals("test string 4", node.data);
    }

    @Test
    public void getLast() {
        basicDoubleLinkedList.addToEnd("test string 1");
        basicDoubleLinkedList.addToEnd("test string 2");
        basicDoubleLinkedList.addToEnd("test string 3");
        BasicDoubleLinkedList.Node node = (BasicDoubleLinkedList.Node)basicDoubleLinkedList.getLast();
        Assert.assertEquals("test string 3", node.data);
    }

    @Test
    public void getSize() {
        basicDoubleLinkedList.addToEnd("test string 1");
        basicDoubleLinkedList.addToEnd("test string 2");
        Assert.assertEquals(2, basicDoubleLinkedList.getSize());
    }

    @Test
    public void iterator() {
        Iterator iterator = basicDoubleLinkedList.iterator();
        Assert.assertTrue(iterator != null);
    }

    @Test
    public void isEmpty() {
        Assert.assertEquals(true, basicDoubleLinkedList.isEmpty());
    }

    @Test
    public void remove() {
        basicDoubleLinkedList.addToEnd("test string 1");
        basicDoubleLinkedList.addToEnd("test string 2");
        basicDoubleLinkedList.remove("test string 1", comparator);
        Assert.assertEquals(1, basicDoubleLinkedList.getSize());
    }

    @Test
    public void retrieveFirstElement() {
        basicDoubleLinkedList.addToEnd("test string 1");
        basicDoubleLinkedList.addToEnd("test string 2");
        Assert.assertEquals("test string 1", basicDoubleLinkedList.retrieveFirstElement());
    }

    @Test
    public void retrieveLastElement() {
        basicDoubleLinkedList.addToEnd("test string 1");
        basicDoubleLinkedList.addToEnd("test string 2");
        Assert.assertEquals("test string 2", basicDoubleLinkedList.retrieveLastElement());
    }

    @Test
    public void toArrayList() {
        basicDoubleLinkedList.addToEnd("test string 1");
        basicDoubleLinkedList.addToEnd("test string 2");
        ArrayList<String> myList = new ArrayList<>();
        myList.add("test string 1");
        myList.add("test string 2");
        Assert.assertEquals(myList, basicDoubleLinkedList.toArrayList());

    }


    private class MyComparator implements Comparator<String>
    {
        @Override
        public int compare(String string1, String string2) {
            return string1.compareTo(string2);
        }
    }


}