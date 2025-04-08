package com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList.tests.predefinedValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList.MyArrayList;

/**
 * Class with tests for {@link MyArrayList} resize methods, that uses predefined values for testing.
 */
public class ResizePredefinedTests {
    /**
     * Main method that runs all the tests of the class.
     */
    public static void main(String[] args) {
        resizeTest();
        resizeTestEmpty();
        resizeExceptionTestFilled();
        resizeExceptionTestEmpty();
    }

    /**
     * Tests resizing empty arrayList.
     */
    public static void resizeTestEmpty() {
        int resizeIncrement = 10;
        MyArrayList<Integer> testedArrayList = new MyArrayList<>();
        int arrayLength = testedArrayList.arrayLength();

        testedArrayList.resize(resizeIncrement);
        assert testedArrayList.isEmpty() : "Wrong size";
        assert testedArrayList.arrayLength() == arrayLength + resizeIncrement : "Wrong array length";
    }

    /**
     * Tests resizing filled arrayList.
     */
    public static void resizeTest() {
        int resizeIncrement = 10;
        MyArrayList<Integer> testedArrayList = new MyArrayList<>();

        for (int i = 0; i < resizeIncrement; i++)
            testedArrayList.add(i);

        int arrayLength = testedArrayList.arrayLength();

        testedArrayList.resize(resizeIncrement);
        assert testedArrayList.size() == resizeIncrement : "Wrong size";
        assert testedArrayList.arrayLength() == arrayLength + resizeIncrement : "Wrong array length";

        for (int i = 0; i < resizeIncrement; i++)
            assert testedArrayList.get(i) == i : "Wrong content";
    }

    /**
     * Tests resizing empty arrayList exceptions throwing correctness.
     */
    public static void resizeExceptionTestEmpty() {
        MyArrayList<Integer> testedArrayList = new MyArrayList<>();
        resizeExceptionTest(testedArrayList);
    }

    /**
     * Tests resizing empty arrayList exceptions throwing correctness.
     */
    public static void resizeExceptionTestFilled() {
        int elementsNum = 10;
        MyArrayList<Integer> testedArrayList = new MyArrayList<>();

        for (int i = 0; i < elementsNum; i++)
            testedArrayList.add(i);

        resizeExceptionTest(testedArrayList);
    }

    /**
     * Tests resizing exception throwing correctness for the given arrayList.
     *
     * @param testedArrayList The list for testing.
     */
    public static <T> void resizeExceptionTest(MyArrayList<T> testedArrayList) {
        try {
            testedArrayList.resize(-1);
            assert false : "IllegalArgumentException expected";
        } catch (IllegalArgumentException e) {
            e.getCause();
        }
    }
}
