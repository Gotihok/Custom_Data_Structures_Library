package com.shpp.p2p.cs.bhnatiuk.dataStructures.myLinkedList.tests.predefinedValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myLinkedList.MyLinkedList;

/**
 * Class with tests for {@link MyLinkedList} constructors, that uses predefined values for testing.
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
        MyLinkedList<Integer> testedLinkedList = new MyLinkedList<>();

        assert testedLinkedList.isEmpty() : "Wrong size";
        assert testedLinkedList.getHead() == null : "Wrong head";
        assert testedLinkedList.getTail() == null : "Wrong tail";
    }

    /**
     * Tests default constructor with initArray passed.
     */
    public static void initArrayConstructorTest() {
        Integer[] initArray = {1, 4, 9, 2, 5, 10, 3};
        MyLinkedList<Integer> testedLinkedList = new MyLinkedList<>(initArray);

        assert testedLinkedList.size() == initArray.length : "Wrong size";
        assert testedLinkedList.getHead().getValue().equals(initArray[0]) : "Wrong head";
        assert testedLinkedList.getTail().getValue().equals(initArray[initArray.length - 1]) : "Wrong tail";

        for (int i = 0; i < initArray.length; i++) {
            assert testedLinkedList.get(i).equals(initArray[i]) : "Wrong content";
        }
    }
}
