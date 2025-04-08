package com.shpp.p2p.cs.bhnatiuk.dataStructures.myQueue.tests.predefinedValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myQueue.MyQueue;

import java.util.NoSuchElementException;

/**
 * Class with tests for {@link MyQueue} clear methods, that uses predefined values for testing.
 */
public class ClearPredefinedTests {
    /**
     * Main method that runs all the tests of the class.
     */
    public static void main(String[] args) {
        clearTest();
    }

    /**
     * Tests the clear method.
     */
    public static void clearTest() {
        int elementsNum = 20;
        MyQueue<Integer> testedQueue = new MyQueue<>();
        for (int i = 0; i < elementsNum; i++)
            testedQueue.enqueue(i);

        assert testedQueue.size() == elementsNum : "Wrong size";

        testedQueue.clear();
        assert testedQueue.isEmpty() : "Wrong size";

        try {
            testedQueue.dequeue();
            assert false : "NoSuchElementException expected";
        } catch (NoSuchElementException e) {
//            e.printStackTrace();
        }
    }
}
