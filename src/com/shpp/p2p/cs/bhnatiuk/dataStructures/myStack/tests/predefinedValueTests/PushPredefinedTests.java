package com.shpp.p2p.cs.bhnatiuk.dataStructures.myStack.tests.predefinedValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList.MyArrayList;
import com.shpp.p2p.cs.bhnatiuk.dataStructures.myStack.MyStack;

/**
 * Class with tests for {@link MyStack} adding method, that uses predefined values for testing.
 */
public class PushPredefinedTests {
    /**
     * Main method that runs all the tests of the class.
     */
    public static void main(String[] args) {
        pushTest();
    }

    /**
     * Tests push().
     */
    public static void pushTest() {
        MyStack<Integer> testedStack = new MyStack<>();
        Integer[] arr = new Integer[]{1, 2, 3, 9, 87};

        for (Integer integer : arr)
            testedStack.push(integer);

        MyArrayList<Integer> innerArrayList = testedStack.getList();

        for (int i = 0; i < arr.length; i++)
            assert innerArrayList.get(i).equals(arr[i]) : "Wrong element";
    }
}
