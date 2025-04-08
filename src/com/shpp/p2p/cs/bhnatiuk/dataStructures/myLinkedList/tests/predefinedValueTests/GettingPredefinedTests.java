package com.shpp.p2p.cs.bhnatiuk.dataStructures.myLinkedList.tests.predefinedValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myLinkedList.MyLinkedList;

import java.util.NoSuchElementException;

/**
 * Class with tests for {@link MyLinkedList} getting methods, that uses predefined values for testing.
 */
public class GettingPredefinedTests {
    /**
     * Main method that runs all the tests of the class.
     */
    public static void main(String[] args) {
        getInPositionTest();
        getInPositionExceptionsTests();
        getFirstLastTest();
        getFirstLastExceptionTest();
    }

    /**
     * Tests getFirst and getLast methods.
     */
    public static void getFirstLastTest() {
        MyLinkedList<String> testedLinkedList = new MyLinkedList<>();

        testedLinkedList.add("asd");
        testedLinkedList.add("qwe");
        testedLinkedList.add("zxc");
        testedLinkedList.add("qaz");

        assert testedLinkedList.getFirst().equals("asd") : "getFirst wrong value";
        assert testedLinkedList.getLast().equals("qaz") : "getLast wrong value";
    }

    /**
     * Tests getFirst and getLast methods exceptions throwing correctness.
     */
    public static void getFirstLastExceptionTest() {
        MyLinkedList<String> testedLinkedList = new MyLinkedList<>();

        try {
            testedLinkedList.getFirst();
            assert false : "exception expected: EmptyArray";
        } catch (NoSuchElementException e) {
//            e.printStackTrace();
        }

        try {
            testedLinkedList.getLast();
            assert false : "exception expected: EmptyArray";
        } catch (NoSuchElementException e) {
//            e.printStackTrace();
        }
    }

    /**
     * Tests get method in all the positions of the initArray.
     */
    public static void getInPositionTest() {
        Double[] values = new Double[]{2.5, 3.0, 3.5, 4.0, -9.9, 0.0};
        MyLinkedList<Double> testedLinkedList = new MyLinkedList<>();
        for (Double value : values)
            testedLinkedList.add(value);

        for (int i = 0; i < values.length; i++)
            assert testedLinkedList.get(i).equals(values[i]) : "Element is not equal";
    }

    /**
     * Tests get method exceptions throwing correctness in different positions.
     */
    public static void getInPositionExceptionsTests() {
        MyLinkedList<Integer> testedLinkedList = new MyLinkedList<>();

        for (int i = 0; i < 20; i++)
            testedLinkedList.add(i);

        getInPositionExceptionsTest(testedLinkedList, 50);
        getInPositionExceptionsTest(testedLinkedList, -10);
        getInPositionExceptionsTest(testedLinkedList, 23);
    }

    /**
     * Tests get method exceptions throwing correctness in defined position.
     *
     * @param testedLinkedList The list for testing.
     * @param index The position for trying to get an object.
     * @param <T> The generic type of the objects of the tested list.
     */
    public static <T> void getInPositionExceptionsTest(MyLinkedList<T> testedLinkedList, int index) {
        try {
            testedLinkedList.get(index);
            assert false : "IndexOutOfBoundsException expected";
        } catch (IndexOutOfBoundsException e) {
//            e.getCause();
        }
    }
}
