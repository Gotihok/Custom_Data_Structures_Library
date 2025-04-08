package com.shpp.p2p.cs.bhnatiuk.dataStructures.myLinkedList.tests.predefinedValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myLinkedList.MyLinkedList;

/**
 * Class with tests for {@link MyLinkedList} clear methods, that uses predefined values for testing.
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
        MyLinkedList<Integer> testedLinkedList = new MyLinkedList<>();
        for (int i = 0; i < elementsNum; i++)
            testedLinkedList.add(i);

        assert testedLinkedList.size() == elementsNum : "Wrong size";

        testedLinkedList.clear();
        assert testedLinkedList.isEmpty() : "Wrong size";

        try {
            testedLinkedList.get(0);
            assert false : "IndexOutOfBoundsException expected";
        } catch (IndexOutOfBoundsException e) {
//            e.printStackTrace();
        }
    }
}
