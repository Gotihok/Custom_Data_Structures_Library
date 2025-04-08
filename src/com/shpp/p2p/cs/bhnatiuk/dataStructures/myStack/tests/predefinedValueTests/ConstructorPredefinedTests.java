package com.shpp.p2p.cs.bhnatiuk.dataStructures.myStack.tests.predefinedValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myStack.MyStack;

/**
 * Class with tests for {@link MyStack} constructors, that uses predefined values for testing.
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
        MyStack<Integer> testedStack1 = new MyStack<>(new Integer[]{});
        assert testedStack1.isEmpty() : "Wrong ArrayList size";

        MyStack<Integer> testedStack2 = new MyStack<>(new Integer[]{1, 2, 3}, 4);
        assert testedStack2.size() == 3 : "Wrong ArrayList size";
        assert testedStack2.getList().step() == 4 : "Wrong ArrayList step";

        try {
            new MyStack<>(new Integer[]{1, 2, 3}, -1);
            assert false : "IllegalArgumentException expected";
        } catch (IllegalArgumentException e) {
//            e.getCause();
        }
    }

    /**
     * Tests init size constructor.
     */
    public static void initSizeConstructorTest() {
        MyStack<Integer> testedStack = new MyStack<>(0);
        assert testedStack.isEmpty() : "Wrong ArrayList size";
        assert testedStack.getList().arrayLength() == 0 : "Wrong inner array size";

        try {
            new MyStack<>(-1);
            assert false : "IllegalArgumentException expected";
        } catch (IllegalArgumentException e) {
//            e.getCause();
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
            new MyStack<>(initSize, step);
            assert false : "IllegalArgumentException expected";
        } catch (IllegalArgumentException e) {
//            e.getCause();
        }
    }
}
