/**
 * Author:- Nardos Lemma
 *CMSC 204
 */

package com.example.lemma_project_3;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class SortedDoubleLinkedListTst_Student {


    MyComparator comparator= new MyComparator();

    SortedDoubleLinkedList sortedDoubleLinkedList = new SortedDoubleLinkedList<>(comparator);
    @Test
    public void add() {
        Assert.assertEquals(0,sortedDoubleLinkedList.getSize());
        sortedDoubleLinkedList.add("Nardos");
        Assert.assertEquals(1,sortedDoubleLinkedList.getSize());
        sortedDoubleLinkedList.add("Yohannes");
        Assert.assertEquals(2,sortedDoubleLinkedList.getSize());
    }

    @Test
    public void addToEnd() {
        try {
            sortedDoubleLinkedList.addToEnd("Hello");
        }
        catch (UnsupportedOperationException e)
        {
            assertEquals(e.getMessage(), "Invalid operation for sorted list");
        }
    }

    @Test
    public void addToFront() {
        try {
            sortedDoubleLinkedList.addToFront("Hello");
        }
        catch (UnsupportedOperationException e)
        {
            assertEquals(e.getMessage(), "Invalid operation for sorted list");
        }
    }

    @Test
    public void remove() {
        Assert.assertEquals(0,sortedDoubleLinkedList.getSize());
        sortedDoubleLinkedList.add("Nardos");
        Assert.assertEquals(1,sortedDoubleLinkedList.getSize());
        sortedDoubleLinkedList.add("Yohannes");
        Assert.assertEquals("Yohannes", sortedDoubleLinkedList.remove("Yohannes", comparator).data);
    }

    private class MyComparator implements Comparator<String>
    {
        @Override
        public int compare(String string1, String string2) {
            return string1.compareTo(string2);
        }
    }



}