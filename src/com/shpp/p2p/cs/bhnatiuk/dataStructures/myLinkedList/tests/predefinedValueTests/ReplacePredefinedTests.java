package com.shpp.p2p.cs.bhnatiuk.dataStructures.myLinkedList.tests.predefinedValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myLinkedList.MyLinkedList;

/**
 * Class with tests for {@link MyLinkedList} replace method, that uses predefined values for testing.
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
        int object = 99;
        Integer[] initArr = new Integer[]{1, 2, 3, 4, 5};
        Integer[] expectedArr = new Integer[]{1, 2, object, 4, 5};
        replaceTest(initArr, expectedArr, object, 2);
    }

    /**
     * Tests replacing at the beginning of the list, (index: 0).
     */
    public static void replaceFirstTest() {
        int object = 99;
        Integer[] initArr = new Integer[]{1, 2, 3, 4, 5};
        Integer[] expectedArr = new Integer[]{99, 2, 3, 4, 5};
        replaceTest(initArr, expectedArr, object, 0);
    }

    /**
     * Tests replacing at the end of the list, (index: size - 1).
     */
    public static void replaceLastTest() {
        int object = 99;
        Integer[] initArr = new Integer[]{1, 2, 3, 4, 5};
        Integer[] expectedArr = new Integer[]{1, 2, 3, 4, 99};
        replaceTest(initArr, expectedArr, object, initArr.length - 1);
    }

    /**
     * Does the replacing and tests the result by checking conformity
     * of the inner and actual arrays of the testedLinkedList.
     *
     * @param initArr Elements to add to linkedList while preparing it to test.
     * @param object The object used for replacement replace.
     * @param index The position for the replacement.
     * @param <T> The generic type of the objects of the tested list.
     */
    public static <T> void replaceTest(T[] initArr, T[] expectedArr, T object, int index) {
        MyLinkedList<T> testedLinkedList = new MyLinkedList<>();
        for (T obj : initArr)
            testedLinkedList.add(obj);

        testedLinkedList.replace(object, index);
        assert testedLinkedList.size() == expectedArr.length : "Wrong size";
        for (int i = 0; i < expectedArr.length; i++)
            assert testedLinkedList.get(i).equals(expectedArr[i]) : "Wrong content";
    }

    /**
     * Tests the exceptions throwing correctness by replacing in empty linkedList.
     */
    public static void replaceExceptionTestEmpty() {
        MyLinkedList<Integer> testedLinkedList = new MyLinkedList<>();
        replaceExceptionTests(testedLinkedList);
    }

    /**
     * Tests the exceptions throwing correctness by replacing in filled arrayList.
     */
    public static void replaceExceptionTestFilled() {
        int elementsNum = 5;
        MyLinkedList<Integer> testedLinkedList = new MyLinkedList<>();
        for (int i = 0; i < elementsNum; i++)
            testedLinkedList.add(i);

        replaceExceptionTests(testedLinkedList);
    }

    /**
     * Test correctness of the exception throwing in different scenarios,
     * trying to replace the element at the wrong positions (out of bounds).
     *
     * @param testedLinkedList The list for testing.
     * @param <T> The generic type of the objects of the tested list.
     */
    @SuppressWarnings("unchecked")
    public static <T> void replaceExceptionTests(MyLinkedList<T> testedLinkedList) {
        int size = testedLinkedList.size();
        T object = (T) new Object();

        replaceExceptionTest(testedLinkedList, object, -1);
        replaceExceptionTest(testedLinkedList, object, size);
        replaceExceptionTest(testedLinkedList, object, size + 1);
        replaceExceptionTest(testedLinkedList, object, size + 2);
    }

    /**
     * Test correctness of the exception throwing in defined scenario of replacement.
     *
     * @param testedLinkedList The list for testing.
     * @param index The index for removing.
     * @param <T> The generic type of the objects of the tested list.
     */
    public static <T> void replaceExceptionTest(MyLinkedList<T> testedLinkedList, T object, int index) {
        try {
            testedLinkedList.replace(object, index);
            assert false : "IndexOutOfBoundsException expected";
        } catch (IndexOutOfBoundsException e) {
//            e.printStackTrace();
        }
    }
}
