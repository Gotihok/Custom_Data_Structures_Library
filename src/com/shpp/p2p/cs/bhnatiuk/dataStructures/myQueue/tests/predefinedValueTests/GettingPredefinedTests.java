package com.shpp.p2p.cs.bhnatiuk.dataStructures.myQueue.tests.predefinedValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myQueue.MyQueue;

import java.util.NoSuchElementException;

/**
 * Class with tests for {@link MyQueue} getting methods, that uses predefined values for testing.
 */
public class GettingPredefinedTests {
    /**
     * Main method that runs all the tests of the class.
     */
    public static void main(String[] args) {
        peekDequeueTest();
        peekDequeueExceptionTest();
    }

    /**
     * Tests peek and dequeue methods.
     */
    public static void peekDequeueTest() {
        String[] initArray = new String[]{"qwe", "asd", "zxc", "qaz"};
        MyQueue<String> testedQueue = new MyQueue<>(initArray);

        for (String element : initArray) {
            assert testedQueue.peek().equals(element) : "Wrong element";
            assert testedQueue.dequeue().equals(element) : "Wrong element";
        }
    }

    /**
     * Tests peek and dequeue methods exceptions throwing correctness.
     */
    public static void peekDequeueExceptionTest() {
        MyQueue<String> testedQueue = new MyQueue<>();

        try {
            testedQueue.peek();
            assert false : "NoSuchElementException expected";
        } catch (NoSuchElementException e) {
//            e.printStackTrace();
        }

        try {
            testedQueue.dequeue();
            assert false : "NoSuchElementException expected";
        } catch (NoSuchElementException e) {
//            e.printStackTrace();
        }
    }
}
