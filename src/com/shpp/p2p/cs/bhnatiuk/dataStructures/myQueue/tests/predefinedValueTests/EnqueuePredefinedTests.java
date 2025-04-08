package com.shpp.p2p.cs.bhnatiuk.dataStructures.myQueue.tests.predefinedValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myLinkedList.MyLinkedList;
import com.shpp.p2p.cs.bhnatiuk.dataStructures.myQueue.MyQueue;

/**
 * Class with tests for {@link MyQueue} adding method, that uses predefined values for testing.
 */
public class EnqueuePredefinedTests {
    /**
     * Main method that runs all the tests of the class.
     */
    public static void main(String[] args) {
        enqueueTest();
    }

    /**
     * Tests enqueue().
     */
    public static void enqueueTest() {
        MyQueue<Integer> testedQueue = new MyQueue<>();
        Integer[] arr = new Integer[]{1, 2, 3, 9, 87};

        for (Integer integer : arr)
            testedQueue.enqueue(integer);

        MyLinkedList<Integer> innerLinkedList = testedQueue.getList();

        for (int i = 0; i < arr.length; i++)
            assert innerLinkedList.get(i).equals(arr[i]) : "Wrong element";
    }
}
