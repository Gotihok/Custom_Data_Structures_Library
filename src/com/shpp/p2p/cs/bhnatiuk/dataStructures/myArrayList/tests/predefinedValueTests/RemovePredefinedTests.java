package com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList.tests.predefinedValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList.MyArrayList;

import java.util.Arrays;

/**
 * Class with tests for {@link MyArrayList} remove method, that uses predefined values for testing.
 */
public class RemovePredefinedTests {
    /**
     * Main method that runs all the tests of the class.
     */
    public static void main(String[] args) {
        removeInnerTest();
        removeFirstTest();
        removeLastTest();
        removeExceptionTestEmpty();
        removeExceptionTestFilled();
    }

    /**
     * Tests removing in the inner position of the list.
     */
    public static void removeInnerTest() {
        Integer[] initArr = new Integer[]{1, 2, 3, 4, 5};
        Integer[] expectedInnerArr = new Integer[]{1, 2, 4, 5, 5};
        Integer[] expectedActualArr = new Integer[]{1, 2, 4, 5};
        MyArrayList<Integer> testedArrayList = new MyArrayList<>(initArr);

        removeTest(testedArrayList, 2, expectedInnerArr, expectedActualArr);
    }

    /**
     * Tests removing at the beginning of the list, (index: 0).
     */
    public static void removeFirstTest() {
        Integer[] initArr = new Integer[]{1, 2, 3, 4, 5};
        Integer[] expectedInnerArr = new Integer[]{2, 3, 4, 5, 5};
        Integer[] expectedActualArr = new Integer[]{2, 3, 4, 5};
        MyArrayList<Integer> testedArrayList = new MyArrayList<>(initArr);

        removeTest(testedArrayList, 0, expectedInnerArr, expectedActualArr);
    }

    /**
     * Tests removing at the end of the list, (index: size - 1).
     */
    public static void removeLastTest() {
        Integer[] initArr = new Integer[]{1, 2, 3, 4, 5};
        Integer[] expectedInnerArr = new Integer[]{1, 2, 3, 4, 5};
        Integer[] expectedActualArr = new Integer[]{1, 2, 3, 4};
        MyArrayList<Integer> testedArrayList = new MyArrayList<>(initArr);

        removeTest(testedArrayList, 4, expectedInnerArr, expectedActualArr);
    }

    /**
     * Does the removing and tests the result by checking conformity
     * of the inner and actual arrays of the testedArrayList.
     *
     * @param testedArrayList The list for testing.
     * @param expectedInnerArr Expected inner array content.
     * @param expectedActualArr Expected actual array content (accessible elements of the list).
     * @param removeIndex The position for the removing.
     * @param <T> The generic type of the objects of the tested list.
     */
    public static <T> void removeTest(MyArrayList<T> testedArrayList, int removeIndex,
                                      T[] expectedInnerArr, T[] expectedActualArr) {
        testedArrayList.remove(removeIndex);
        assert testedArrayList.size() == expectedActualArr.length : "Wrong size";
        assert testedArrayList.arrayLength() == expectedInnerArr.length : "Wrong array length";
        assert Arrays.equals(testedArrayList.getArray(), expectedInnerArr): "Wrong inner array content";

        for (int i = 0; i < expectedActualArr.length; i++)
            assert testedArrayList.get(i).equals(expectedActualArr[i]) : "Wrong content";
    }

    /**
     * Tests the exceptions throwing correctness by removing in empty arrayList.
     */
    public static void removeExceptionTestEmpty() {
        MyArrayList<Integer> testedArrayList = new MyArrayList<>();
        removeExceptionTests(testedArrayList);
    }

    /**
     * Tests the exceptions throwing correctness by removing in filled arrayList.
     */
    public static void removeExceptionTestFilled() {
        int elementsNum = 5;
        MyArrayList<Integer> testedArrayList = new MyArrayList<>();
        for (int i = 0; i < elementsNum; i++)
            testedArrayList.add(i);

        removeExceptionTests(testedArrayList);
    }

    /**
     * Test correctness of the exception throwing in different scenarios,
     * trying to remove the element at the wrong positions (out of bounds).
     *
     * @param testedArrayList The list for testing.
     * @param <T> The generic type of the objects of the tested list.
     */
    public static <T> void removeExceptionTests(MyArrayList<T> testedArrayList) {
        int size = testedArrayList.size();

        removeExceptionTest(testedArrayList, -1);
        removeExceptionTest(testedArrayList, size);
        removeExceptionTest(testedArrayList, size + 1);
        removeExceptionTest(testedArrayList, size + 2);
        removeExceptionTest(testedArrayList, testedArrayList.arrayLength() + 1);
    }

    /**
     * Test correctness of the exception throwing in defined scenario of the removing.
     *
     * @param testedArrayList The list for testing.
     * @param index The index for removing.
     * @param <T> The generic type of the objects of the tested list.
     */
    public static <T> void removeExceptionTest(MyArrayList<T> testedArrayList, int index) {
        try {
            testedArrayList.remove(index);
            assert false : "IndexOutOfBoundsException expected";
        } catch (IndexOutOfBoundsException e) {
//            e.getCause();
        }
    }
}
