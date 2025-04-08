package com.shpp.p2p.cs.bhnatiuk.dataStructures.myStack.tests.predefinedValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myStack.MyStack;

import java.util.NoSuchElementException;

/**
 * Class with tests for {@link MyStack} clear methods, that uses predefined values for testing.
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
        MyStack<Integer> testedStack = new MyStack<>();
        for (int i = 0; i < elementsNum; i++)
            testedStack.push(i);

        assert testedStack.size() == elementsNum : "Wrong size";

        testedStack.clear();
        assert testedStack.isEmpty() : "Wrong size";

        try {
            testedStack.pop();
            assert false : "NoSuchElementException expected";
        } catch (NoSuchElementException e) {
//            e.printStackTrace();
        }
    }
}
