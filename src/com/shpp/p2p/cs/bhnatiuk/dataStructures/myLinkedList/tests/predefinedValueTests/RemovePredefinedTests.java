package com.shpp.p2p.cs.bhnatiuk.dataStructures.myLinkedList.tests.predefinedValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myLinkedList.MyLinkedList;

/**
 * Class with tests for {@link MyLinkedList} remove method, that uses predefined values for testing.
 */
public class RemovePredefinedTests {
    /**
     * Main method that runs all the tests of the class.
     */
    public static void main(String[] args) {
        removeInnerTest();
        removeFirstTest();
        removeLastTest();
        removeTillEmptyTest();
        removeExceptionTestEmpty();
        removeExceptionTestFilled();
    }

    /**
     * Tests removing in the inner position of the list.
     */
    public static void removeInnerTest() {
        Integer[] initArr = new Integer[]{1, 2, 3, 4, 5};
        Integer[] expectedArr = new Integer[]{1, 2, 4, 5};
        removeTest(initArr, expectedArr, 2);
    }

    /**
     * Tests removing at the beginning of the list, (index: 0).
     */
    public static void removeFirstTest() {
        Integer[] initArr = new Integer[]{1, 2, 3, 4, 5};
        Integer[] expectedArr = new Integer[]{2, 3, 4, 5};
        removeTest(initArr, expectedArr, 0);
    }

    /**
     * Tests removing at the end of the list, (index: size - 1).
     */
    public static void removeLastTest() {
        Integer[] initArr = new Integer[]{1, 2, 3, 4, 5};
        Integer[] expectedArr = new Integer[]{1, 2, 3, 4};
        removeTest(initArr, expectedArr, initArr.length - 1);
    }

    /**
     * Tests removing at the end of the list, until emptying the list.
     */
    public static void removeTillEmptyTest() {
        Integer[] initArr = new Integer[]{1};
        Integer[] expectedArr = new Integer[]{};
        removeTest(initArr, expectedArr, 0);
    }

    /**
     * Does the removing and tests the result by checking conformity
     * of the inner and actual arrays of the testedLinkedList.
     *
     * @param initArr The array to fill the list before testing.
     * @param expectedArr Expected inner array content.
     * @param removeIndex The position for the removing.
     * @param <T> The generic type of the objects of the tested list.
     */
    public static <T> void removeTest(T[] initArr, T[] expectedArr, int removeIndex) {
        MyLinkedList<T> testedLinkedList = new MyLinkedList<>();
        for (T obj : initArr)
            testedLinkedList.add(obj);

        testedLinkedList.remove(removeIndex);
        assert testedLinkedList.size() == expectedArr.length : "Wrong size";
        for (int i = 0; i < expectedArr.length; i++)
            assert testedLinkedList.get(i).equals(expectedArr[i]) : "Wrong content";
    }

    /**
     * Tests the exceptions throwing correctness by removing in empty linkedList.
     */
    public static void removeExceptionTestEmpty() {
        MyLinkedList<Integer> testedArrayList = new MyLinkedList<>();
        removeExceptionTests(testedArrayList);
    }

    /**
     * Tests the exceptions throwing correctness by removing in filled linkedList.
     */
    public static void removeExceptionTestFilled() {
        int elementsNum = 5;
        MyLinkedList<Integer> testedLinkedList = new MyLinkedList<>();
        for (int i = 0; i < elementsNum; i++)
            testedLinkedList.add(i);

        removeExceptionTests(testedLinkedList);
    }

    /**
     * Test correctness of the exception throwing in different scenarios,
     * trying to remove the element at the wrong positions (out of bounds).
     *
     * @param testedLinkedList The list for testing.
     * @param <T> The generic type of the objects of the tested list.
     */
    public static <T> void removeExceptionTests(MyLinkedList<T> testedLinkedList) {
        int size = testedLinkedList.size();

        removeExceptionTest(testedLinkedList, -1);
        removeExceptionTest(testedLinkedList, size);
        removeExceptionTest(testedLinkedList, size + 1);
        removeExceptionTest(testedLinkedList, size + 2);
    }

    /**
     * Test correctness of the exception throwing in defined scenario of the removing.
     *
     * @param testedLinkedList The list for testing.
     * @param index The index for removing.
     * @param <T> The generic type of the objects of the tested list.
     */
    public static <T> void removeExceptionTest(MyLinkedList<T> testedLinkedList, int index) {
        try {
            testedLinkedList.remove(index);
            assert false : "IndexOutOfBoundsException expected";
        } catch (IndexOutOfBoundsException e) {
//            e.printStackTrace();
        }
    }
}
