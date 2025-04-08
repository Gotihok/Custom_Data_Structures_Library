package com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList.tests.predefinedValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList.MyArrayList;

/**
 * Class with tests for {@link MyArrayList} constructors, that uses predefined values for testing.
 */
public class ConstructorPredefinedTests {
    /**
     * Main method that runs all the tests of the class.
     */
    public static void main(String[] args) {
        initSizeConstructorTest();
        initSizeStepConstructorTests();
        initArrayConstructorTest();
    }

    /**
     * Tests exceptions with the init array constructors and invalid step.
     */
    public static void initArrayConstructorTest() {
        MyArrayList<Integer> testedArrayList1 = new MyArrayList<>(new Integer[]{});
        assert testedArrayList1.isEmpty() : "Wrong ArrayList size";

        MyArrayList<Integer> testedArrayList2 = new MyArrayList<>(new Integer[]{1, 2, 3}, 4);
        assert testedArrayList2.size() == 3 : "Wrong ArrayList size";
        assert testedArrayList2.step() == 4 : "Wrong ArrayList step";

        try {
            MyArrayList<Integer> testedArrayList = new MyArrayList<>(new Integer[]{1, 2, 3}, -1);
            assert false : "IllegalArgumentException expected";
        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
        }
    }

    /**
     * Tests init size constructor.
     */
    public static void initSizeConstructorTest() {
        MyArrayList<Integer> testedArrayList1 = new MyArrayList<>(0);
        assert testedArrayList1.isEmpty() : "Wrong ArrayList size";
        assert testedArrayList1.arrayLength() == 0 : "Wrong inner array size";

        try {
            MyArrayList<Integer> testedArrayList = new MyArrayList<>(-1);
            assert false : "IllegalArgumentException expected";
        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
        }
    }

    /**
     * Test exceptions with invalid init size and invalid step passed for the constructor
     * with different combinations of both.
     */
    public static void initSizeStepConstructorTests() {
        initSizeStepConstructorTest(-1, 2);
        initSizeStepConstructorTest(2, -2);
        initSizeStepConstructorTest(-1, -2);
    }

    /**
     * Test exceptions with invalid init size and invalid step passed for the constructor.
     *
     * @param initSize The initSize parameter for the constructor.
     * @param step The step parameter for the constructor.
     */
    public static void initSizeStepConstructorTest(int initSize, int step) {
        try {
            MyArrayList<Integer> testedArrayList = new MyArrayList<>(initSize, step);
            assert false : "IllegalArgumentException expected";
        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
        }
    }
}
