package com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList.tests.predefinedValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList.MyArrayList;

import java.util.Arrays;

/**
 * Class with tests for {@link MyArrayList} replace method, that uses predefined values for testing.
 */
public class ReplacePredefinedTests {
    /**
     * Main method that runs all the tests of the class.
     */
    public static void main(String[] args) {
        replaceInnerTest();
        replaceFirstTest();
        replaceLastTest();
        replaceExceptionTestEmpty();
        replaceExceptionTestFilled();
    }

    /**
     * Tests replacing in the inner position of the list.
     */
    public static void replaceInnerTest() {
        Integer[] initArr = new Integer[]{1, 2, 3, 4, 5};
        Integer[] expectedArr = new Integer[]{1, 2, 99, 4, 5};
        MyArrayList<Integer> testedArrayList = new MyArrayList<>(initArr);

        replaceTest(testedArrayList, 99, 2, expectedArr);
    }

    /**
     * Tests replacing at the beginning of the list, (index: 0).
     */
    public static void replaceFirstTest() {
        Integer[] initArr = new Integer[]{1, 2, 3, 4, 5};
        Integer[] expectedArr = new Integer[]{99, 2, 3, 4, 5};
        MyArrayList<Integer> testedArrayList = new MyArrayList<>(initArr);

        replaceTest(testedArrayList, 99, 0, expectedArr);
    }

    /**
     * Tests replacing at the end of the list, (index: size - 1).
     */
    public static void replaceLastTest() {
        Integer[] initArr = new Integer[]{1, 2, 3, 4, 5};
        Integer[] expectedArr = new Integer[]{1, 2, 3, 4, 99};
        MyArrayList<Integer> testedArrayList = new MyArrayList<>(initArr);

        replaceTest(testedArrayList, 99, 4, expectedArr);
    }

    /**
     * Does the replacing and tests the result by checking conformity
     * of the inner and actual arrays of the testedArrayList.
     *
     * @param testedArrayList The list for testing.
     * @param object The object used for replacement replace.
     * @param index The position for the replacement.
     * @param <T> The generic type of the objects of the tested list.
     */
    public static <T> void replaceTest(MyArrayList<T> testedArrayList, T object, int index, T[] expectedArr) {
        testedArrayList.replace(object, index);
        assert testedArrayList.size() == expectedArr.length : "Wrong size";
        assert testedArrayList.arrayLength() == expectedArr.length : "Wrong array length";
        assert Arrays.equals(testedArrayList.getArray(), expectedArr): "Wrong content";

        for (int i = 0; i < expectedArr.length; i++)
            assert testedArrayList.get(i).equals(expectedArr[i]) : "Wrong content";
    }

    /**
     * Tests the exceptions throwing correctness by replacing in empty arrayList.
     */
    public static void replaceExceptionTestEmpty() {
        MyArrayList<Integer> testedArrayList = new MyArrayList<>();
        replaceExceptionTests(testedArrayList);
    }

    /**
     * Tests the exceptions throwing correctness by replacing in filled arrayList.
     */
    public static void replaceExceptionTestFilled() {
        int elementsNum = 5;
        MyArrayList<Integer> testedArrayList = new MyArrayList<>();
        for (int i = 0; i < elementsNum; i++)
            testedArrayList.add(i);

        replaceExceptionTests(testedArrayList);
    }

    /**
     * Test correctness of the exception throwing in different scenarios,
     * trying to replace the element at the wrong positions (out of bounds).
     *
     * @param testedArrayList The list for testing.
     * @param <T> The generic type of the objects of the tested list.
     */
    @SuppressWarnings("unchecked")
    public static <T> void replaceExceptionTests(MyArrayList<T> testedArrayList) {
        int size = testedArrayList.size();
        T object = (T) new Object();

        replaceExceptionTest(testedArrayList, object, -1);
        replaceExceptionTest(testedArrayList, object, size);
        replaceExceptionTest(testedArrayList, object, size + 1);
        replaceExceptionTest(testedArrayList, object, size + 2);
        replaceExceptionTest(testedArrayList, object, testedArrayList.arrayLength() + 1);
    }

    /**
     * Test correctness of the exception throwing in defined scenario of replacement.
     *
     * @param testedArrayList The list for testing.
     * @param index The index for removing.
     * @param <T> The generic type of the objects of the tested list.
     */
    public static <T> void replaceExceptionTest(MyArrayList<T> testedArrayList, T object, int index) {
        try {
            testedArrayList.replace(object, index);
            assert false : "IndexOutOfBoundsException expected";
        } catch (IndexOutOfBoundsException e) {
            e.getCause();
        }
    }
}
