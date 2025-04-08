package com.shpp.p2p.cs.bhnatiuk.dataStructures.myQueue.tests.predefinedValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myLinkedList.MyLinkedList;
import com.shpp.p2p.cs.bhnatiuk.dataStructures.myQueue.MyQueue;

/**
 * Class with tests for {@link MyQueue} constructors, that uses predefined values for testing.
 */
public class ConstructorPredefinedTests {
    /**
     * Main method that runs all the tests of the class.
     */
    public static void main(String[] args) {
        defaultConstructorTest();
        initArrayConstructorTest();
    }

    /**
     * Tests default constructor.
     */
    public static void defaultConstructorTest() {
        MyQueue<Integer> testedQueue = new MyQueue<>();
        MyLinkedList<Integer> innerLinkedList = testedQueue.getList();

        assert testedQueue.isEmpty() : "Wrong size";

        assert innerLinkedList.isEmpty() : "Wrong size";
        assert innerLinkedList.getHead() == null : "Wrong head";
        assert innerLinkedList.getTail() == null : "Wrong tail";
    }

    /**
     * Tests default constructor with initArray passed.
     */
    public static void initArrayConstructorTest() {
        Integer[] initArray = {1, 4, 9, 2, 5, 10, 3};
        MyQueue<Integer> testedQueue = new MyQueue<>(initArray);
        MyLinkedList<Integer> innerLinkedList = testedQueue.getList();

        assert testedQueue.size() == initArray.length : "Wrong size";

        assert innerLinkedList.size() == initArray.length : "Wrong size";
        assert innerLinkedList.getHead().getValue().equals(initArray[0]) : "Wrong head";
        assert innerLinkedList.getTail().getValue().equals(initArray[initArray.length - 1]) : "Wrong tail";

        for (Integer integer : initArray)
            assert testedQueue.dequeue().equals(integer) : "Wrong content";
    }
}
