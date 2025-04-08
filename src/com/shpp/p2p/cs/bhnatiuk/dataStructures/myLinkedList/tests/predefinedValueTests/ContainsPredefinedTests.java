package com.shpp.p2p.cs.bhnatiuk.dataStructures.myLinkedList.tests.predefinedValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myLinkedList.MyLinkedList;

/**
 * Class with tests for {@link MyLinkedList} contains method, that uses predefined values for testing.
 */
public class ContainsPredefinedTests {
    /**
     * Main method that runs all the tests of the class.
     */
    public static void main(String[] args) {
        containsTest();
        containsTestEmpty();
    }

    /**
     * Tests the contains method with filled linkedList
     */
    public static void containsTest() {
        MyLinkedList<Integer> testedLinkedList = new MyLinkedList<>();

        int testedNums = 10;
        for (int i = 0; i < testedNums; i++)
            testedLinkedList.add(i);

        for (int i = 0; i < testedNums; i++)
            assert testedLinkedList.contains(i) : "Should contain the element";

        for (int i = testedNums; i < testedNums * 2; i++)
            assert !testedLinkedList.contains(i) : "Shouldn't contain the element";
    }

    /**
     * Tests the contains method with empty linkedList
     */
    public static void containsTestEmpty() {
        MyLinkedList<Integer> testedLinkedList = new MyLinkedList<>();

        int testedNums = 25;
        for (int i = 0; i < testedNums; i++)
            assert !testedLinkedList.contains(i) : "Shouldn't contain the element";
    }
}
