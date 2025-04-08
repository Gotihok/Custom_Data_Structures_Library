package com.shpp.p2p.cs.bhnatiuk.dataStructures.myStack.tests.predefinedValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myStack.MyStack;

import java.util.NoSuchElementException;

/**
 * Class with tests for {@link MyStack} getting methods, that uses predefined values for testing.
 */
public class GettingPredefinedTests {
    /**
     * Main method that runs all the tests of the class.
     */
    public static void main(String[] args) {
        topPopTest();
        topPopExceptionTest();
    }

    /**
     * Tests top and pop methods.
     */
    public static void topPopTest() {
        String[] initArray = new String[]{"qwe", "asd", "zxc", "qaz"};
        String[] expectedArray = new String[]{"qaz", "zxc", "asd", "qwe"};
        MyStack<String> testedStack = new MyStack<>(initArray);

        for (String element : expectedArray) {
            assert testedStack.top().equals(element) : "Wrong element top";
            assert testedStack.pop().equals(element) : "Wrong element pop";
        }
    }

    /**
     * Tests top and pop methods exceptions throwing correctness.
     */
    public static void topPopExceptionTest() {
        MyStack<String> testedStack = new MyStack<>();

        try {
            testedStack.top();
            assert false : "NoSuchElementException expected";
        } catch (NoSuchElementException e) {
//            e.printStackTrace();
        }

        try {
            testedStack.pop();
            assert false : "NoSuchElementException expected";
        } catch (NoSuchElementException e) {
//            e.printStackTrace();
        }
    }
}
