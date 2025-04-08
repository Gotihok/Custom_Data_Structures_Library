package com.shpp.p2p.cs.bhnatiuk.dataStructures.myStack.tests.predefinedValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myStack.MyStack;

import java.util.Iterator;
import java.lang.IndexOutOfBoundsException;

/**
 * Class with tests for {@link MyStack} iterator implementation, that uses predefined values for testing.
 */
public class IteratorPredefinedTests {
    /**
     * Main method that runs all the tests of the class.
     */
    public static void main(String[] args) {
        iteratorTest();
        iteratorExceptionTestEmpty();
        iteratorExceptionTestFilled();
    }

    /**
     * Tests iterator by firstly adding elements then iterating.
     */
    public static void iteratorTest() {
        MyStack<Integer> testedStack = new MyStack<>();

        int testedNums = 10;
        for (int i = 0; i < testedNums; i++)
            testedStack.push(i);

        for (Integer integer : testedStack) {
            assert testedStack.pop().equals(integer) : "Wrong content";
            testedNums--;
        }
        assert testedNums == 0 : "Incorrect number of elements processed";
    }

    /**
     * Tests iterator exceptions throwing correctness from empty stack.
     */
    public static void iteratorExceptionTestEmpty() {
        MyStack<Integer> testedStack = new MyStack<>();
        Iterator<Integer> testedIterator = testedStack.iterator();
        iteratorExceptionTest(testedIterator);
    }

    /**
     * Tests iterator exceptions throwing correctness from filled stack.
     */
    public static void iteratorExceptionTestFilled() {
        MyStack<Integer> testedStack = new MyStack<>();

        int testedNums = 25;
        for (int i = 0; i < testedNums; i++)
            testedStack.push(i);

        Iterator<Integer> testedIterator = testedStack.iterator();
        while (testedIterator.hasNext())
            testedIterator.next();

        iteratorExceptionTest(testedIterator);
    }

    /**
     * Tests iterator exceptions throwing correctness with given iterator.
     *
     * @param testedIterator The iterator for testing.
     * @param <T> The generic type of the objects of the tested list.
     */
    public static <T> void iteratorExceptionTest(Iterator<T> testedIterator) {
        try {
            testedIterator.next();
            assert false : "IndexOutOfBoundsException expected";
        } catch (IndexOutOfBoundsException e) {
//            System.out.println("Caught");
//            e.printStackTrace();
        }
    }
}
