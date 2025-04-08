package com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList.tests.predefinedValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList.MyArrayList;

/**
 * Class with tests for {@link MyArrayList} contains method, that uses predefined values for testing.
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
     * Tests the contains method with filled arrayList
     */
    public static void containsTest() {
        MyArrayList<Integer> testedArrayList = new MyArrayList<>();

        int testedNums = 10;
        for (int i = 0; i < testedNums; i++)
            testedArrayList.add(i);

        for (int i = 0; i < testedNums; i++)
            assert testedArrayList.contains(i) : "Should contain the element";

        for (int i = testedNums; i < testedNums * 2; i++)
            assert !testedArrayList.contains(i) : "Shouldn't contain the element";
    }

    /**
     * Tests the contains method with empty arrayList
     */
    public static void containsTestEmpty() {
        MyArrayList<Integer> testedArrayList = new MyArrayList<>();

        int testedNums = 25;
        for (int i = 0; i < testedNums; i++)
            assert !testedArrayList.contains(i) : "Shouldn't contain the element";
    }
}
