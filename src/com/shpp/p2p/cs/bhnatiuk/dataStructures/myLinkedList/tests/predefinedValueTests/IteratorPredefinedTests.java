package com.shpp.p2p.cs.bhnatiuk.dataStructures.myLinkedList.tests.predefinedValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myLinkedList.MyLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class with tests for {@link MyLinkedList} iterator implementation, that uses predefined values for testing.
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
        MyLinkedList<Integer> testedLinkedList = new MyLinkedList<>();

        int testedNums = 10;
        for (int i = 0; i < testedNums; i++)
            testedLinkedList.add(i);

        int i = 0;
        for (Integer integer : testedLinkedList) {
            assert testedLinkedList.get(i).equals(integer) : "Wrong content";
            i++;
        }
    }

    /**
     * Tests iterator exceptions throwing correctness from empty linkedList.
     */
    public static void iteratorExceptionTestEmpty() {
        MyLinkedList<Integer> testedLinkedList = new MyLinkedList<>();
        Iterator<Integer> testedIterator = testedLinkedList.iterator();
        iteratorExceptionTest(testedIterator);
    }

    /**
     * Tests iterator exceptions throwing correctness from filled linkedList.
     */
    public static void iteratorExceptionTestFilled() {
        MyLinkedList<Integer> testedLinkedList = new MyLinkedList<>();

        int testedNums = 25;
        for (int i = 0; i < testedNums; i++)
            testedLinkedList.add(i);

        Iterator<Integer> testedIterator = testedLinkedList.iterator();
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
