package com.shpp.p2p.cs.bhnatiuk.dataStructures.myQueue.tests.predefinedValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myQueue.MyQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class with tests for {@link MyQueue} iterator implementation, that uses predefined values for testing.
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
        MyQueue<Integer> testedQueue = new MyQueue<>();

        int testedNums = 10;
        for (int i = 0; i < testedNums; i++)
            testedQueue.enqueue(i);

        for (Integer integer : testedQueue) {
            assert testedQueue.dequeue().equals(integer) : "Wrong content";
            testedNums--;
        }
        assert testedNums == 0 : "Incorrect number of elements processed";
    }

    /**
     * Tests iterator exceptions throwing correctness from empty queue.
     */
    public static void iteratorExceptionTestEmpty() {
        MyQueue<Integer> testedQueue = new MyQueue<>();
        Iterator<Integer> testedIterator = testedQueue.iterator();
        iteratorExceptionTest(testedIterator);
    }

    /**
     * Tests iterator exceptions throwing correctness from filled queue.
     */
    public static void iteratorExceptionTestFilled() {
        MyQueue<Integer> testedQueue = new MyQueue<>();

        int testedNums = 25;
        for (int i = 0; i < testedNums; i++)
            testedQueue.enqueue(i);

        Iterator<Integer> testedIterator = testedQueue.iterator();
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
            assert false : "NoSuchElementException expected";
        } catch (NoSuchElementException e) {
//            e.printStackTrace();
        }
    }
}
