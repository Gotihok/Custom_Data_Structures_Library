package com.shpp.p2p.cs.bhnatiuk.dataStructures.myStack.tests.predefinedValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myStack.MyStack;

/**
 * Class with tests for {@link MyStack} size handling, that uses predefined values for testing.
 */
public class SizePredefinedTests {
    /**
     * Main method that runs all the tests of the class.
     */
    public static void main(String[] args) {
        sizeTest();
        isEmptyTest();
    }

    /**
     * Tests if size() returns correct values.
     */
    public static void sizeTest() {
        int elementsNum = 20;
        MyStack<Integer> testedStack = new MyStack<>();
        for (int i = 0; i < elementsNum; i++) {
            testedStack.push(i);
            assert testedStack.size() == i + 1 : "Wrong size";
        }
    }

    /**
     * Tests if isEmpty() returns correct values.
     */
    public static void isEmptyTest() {
        int elementsNum = 20;
        MyStack<Integer> testedStack = new MyStack<>();
        assert testedStack.isEmpty() : "Wrong size";

        for (int i = 0; i < elementsNum; i++) {
            testedStack.push(i);
            assert !testedStack.isEmpty() : "Wrong size";
        }
    }
}
