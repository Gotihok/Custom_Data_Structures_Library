package com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList.tests.predefinedValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList.MyArrayList;

import java.util.NoSuchElementException;

/**
 * Class with tests for {@link MyArrayList} getting methods, that uses predefined values for testing.
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
        MyArrayList<String> testedArrayList = new MyArrayList<>();

        testedArrayList.add("asd");
        testedArrayList.add("qwe");
        testedArrayList.add("zxc");
        testedArrayList.add("qaz");

        assert testedArrayList.getFirst().equals("asd") : "getFirst wrong value";
        assert testedArrayList.getLast().equals("qaz") : "getLast wrong value";
    }

    /**
     * Tests getFirst and getLast methods exceptions throwing correctness.
     */
    public static void getFirstLastExceptionTest() {
        MyArrayList<String> testedArrayList = new MyArrayList<>();

        try {
            testedArrayList.getFirst();
            assert false : "exception expected: EmptyArray";
        } catch (NoSuchElementException e) {
//            e.getCause();
        }

        try {
            testedArrayList.getLast();
            assert false : "exception expected: EmptyArray";
        } catch (NoSuchElementException e) {
//            e.getCause();
        }
    }

    /**
     * Tests get method in all the positions of the initArray.
     */
    public static void getInPositionTest() {
        Double[] values = new Double[]{2.5, 3.0, 3.5, 4.0, -9.9, 0.0};
        MyArrayList<Double> testedArrayList = new MyArrayList<>(values);
        for (int i = 0; i < values.length; i++) {
            assert testedArrayList.get(i).equals(values[i]) : "Element is not equal";
        }
    }

    /**
     * Tests get method exceptions throwing correctness in different positions.
     */
    public static void getInPositionExceptionsTests() {
        MyArrayList<Integer> testedArrayList = new MyArrayList<>();

        for (int i = 0; i < 20; i++)
            testedArrayList.add(i);

        getInPositionExceptionsTest(testedArrayList, 50);
        getInPositionExceptionsTest(testedArrayList, -10);
        getInPositionExceptionsTest(testedArrayList, 23);
    }

    /**
     * Tests get method exceptions throwing correctness in defined position.
     *
     * @param testedArrayList The list for testing.
     * @param index The position for trying to get an object.
     * @param <T> The generic type of the objects of the tested list.
     */
    public static <T> void getInPositionExceptionsTest(MyArrayList<T> testedArrayList, int index) {
        try {
            testedArrayList.get(index);
            assert false : "IndexOutOfBoundsException expected";
        } catch (IndexOutOfBoundsException e) {
//            e.getCause();
        }
    }
}
