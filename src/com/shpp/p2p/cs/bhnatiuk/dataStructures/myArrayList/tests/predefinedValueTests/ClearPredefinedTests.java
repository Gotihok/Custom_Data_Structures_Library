package com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList.tests.predefinedValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList.MyArrayList;

import java.util.Arrays;

/**
 * Class with tests for {@link MyArrayList} clear methods, that uses predefined values for testing.
 */
public class ClearPredefinedTests {
    /**
     * Main method that runs all the tests of the class.
     */
    public static void main(String[] args) {
        clearTest();
        clearStrictTest();
    }

    /**
     * Tests the clear method
     */
    public static void clearTest() {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5};
        MyArrayList<Integer> testedArrayList = new MyArrayList<>(arr);

        assert testedArrayList.size() == 5 : "Wrong size";

        testedArrayList.clear();
        assert testedArrayList.isEmpty() : "Wrong size";
        assert testedArrayList.arrayLength() == 5 : "Wrong array length";
        assert Arrays.equals(testedArrayList.getArray(), arr): "Wrong content";
    }

    /**
     * Tests the clearStrict method
     */
    public static void clearStrictTest() {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5};
        MyArrayList<Integer> testedArrayList = new MyArrayList<>(arr);

        assert testedArrayList.size() == 5 : "Wrong size";

        testedArrayList.clearStrict();
        assert testedArrayList.isEmpty() : "Wrong size";
        assert testedArrayList.arrayLength() == MyArrayList.DEFAULT_ARRAY_LENGTH : "Wrong array length";
        assert Arrays.equals(testedArrayList.getArray(), new Integer[MyArrayList.DEFAULT_ARRAY_LENGTH])
                : "Wrong content";
    }
}
