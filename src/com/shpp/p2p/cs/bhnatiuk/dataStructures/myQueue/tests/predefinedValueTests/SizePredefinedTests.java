package com.shpp.p2p.cs.bhnatiuk.dataStructures.myQueue.tests.predefinedValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myQueue.MyQueue;

/**
 * Class with tests for {@link MyQueue} size handling, that uses predefined values for testing.
 */
public class SizePredefinedTests {
    /**
     * Main method that runs all the tests of the class.
     */
    public static void main(String[] args) {
        sizeTest();
        isEmptyTest();
    }

    /**
     * Tests if size() returns correct values.
     */
    public static void sizeTest() {
        int elementsNum = 20;
        MyQueue<Integer> testedQueue = new MyQueue<>();
        for (int i = 0; i < elementsNum; i++) {
            testedQueue.enqueue(i);
            assert testedQueue.size() == i + 1 : "Wrong size";
        }
    }

    /**
     * Tests if isEmpty() returns correct values.
     */
    public static void isEmptyTest() {
        int elementsNum = 20;
        MyQueue<Integer> testedQueue = new MyQueue<>();
        assert testedQueue.isEmpty() : "Wrong size";

        for (int i = 0; i < elementsNum; i++) {
            testedQueue.enqueue(i);
            assert !testedQueue.isEmpty() : "Wrong size";
        }
    }
}
