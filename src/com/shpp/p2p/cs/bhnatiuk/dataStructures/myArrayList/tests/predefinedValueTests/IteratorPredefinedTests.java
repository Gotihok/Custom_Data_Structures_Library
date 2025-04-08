package com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList.tests.predefinedValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList.MyArrayList;

import java.util.Iterator;

/**
 * Class with tests for {@link MyArrayList} iterator implementation, that uses predefined values for testing.
 */
public class IteratorPredefinedTests {
    /**
     * Main method that runs all the tests of the class.
     */
    public static void main(String[] args) {
        iteratorTest1();
        iteratorTest2();
        iteratorExceptionTestEmpty();
        iteratorExceptionTestFilled();
    }

    /**
     * Tests iterator by firstly adding elements then iterating.
     */
    public static void iteratorTest1() {
        MyArrayList<Integer> testedArrayList = new MyArrayList<>();

        int testedNums = 10;
        for (int i = 0; i < testedNums; i++)
            testedArrayList.add(i);

        int i = 0;
        for (int integer : testedArrayList) {
            assert testedArrayList.get(i).equals(integer) : "Wrong content";
            i++;
        }
    }

    /**
     * Tests iterator by adding and iterating at the same time.
     */
    public static void iteratorTest2() {
        MyArrayList<Integer> testedArrayList = new MyArrayList<>();
        Iterator<Integer> testedIterator = testedArrayList.iterator();

        int testedNums = 10;
        for (int i = 0; i < testedNums; i++) {
            testedArrayList.add(i);
            assert testedArrayList.get(i).equals(testedIterator.next()) : "Wrong content";
        }
    }

    /**
     * Tests iterator exceptions throwing correctness from empty arrayList.
     */
    public static void iteratorExceptionTestEmpty() {
        MyArrayList<Integer> testedArrayList = new MyArrayList<>();
        Iterator<Integer> testedIterator = testedArrayList.iterator();
        iteratorExceptionTest(testedIterator);
    }

    /**
     * Tests iterator exceptions throwing correctness from filled arrayList.
     */
    public static void iteratorExceptionTestFilled() {
        MyArrayList<Integer> testedArrayList = new MyArrayList<>();

        int testedNums = 25;
        for (int i = 0; i < testedNums; i++)
            testedArrayList.add(i);

        Iterator<Integer> testedIterator = testedArrayList.iterator();
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
//            e.getCause();
        }
    }
}
