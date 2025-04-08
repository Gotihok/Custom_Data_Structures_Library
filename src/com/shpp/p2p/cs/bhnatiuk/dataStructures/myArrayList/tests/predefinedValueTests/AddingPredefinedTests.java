package com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList.tests.predefinedValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList.MyArrayList;

/**
 * Class with tests for {@link MyArrayList} adding methods, that uses predefined values for testing.
 */
public class AddingPredefinedTests {
    /**
     * Main method that runs all the tests of the class.
     */
    public static void main(String[] args) {
        addTest();
        insertInnerTest();
        insertFirstTest();
        insertLastTest();
        addExceptionTestsEmpty();
        addExceptionTestsFilled();
    }

    /**
     * Tests the 2 adding method overloads (object; object + position) of the adding method
     * by sequential adding elements to the end of the list
     */
    public static void addTest() {
        MyArrayList<Integer> testedArrayList1 = new MyArrayList<>();
        MyArrayList<Integer> testedArrayList2 = new MyArrayList<>();
        Integer[] arr = new Integer[]{1, 2, 3, 9, 87};

        for (int i = 0; i < arr.length; i++) {
            testedArrayList1.add(arr[i]);
            testedArrayList2.add(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            assert testedArrayList1.get(i).equals(arr[i]) : "Wrong element";
            assert testedArrayList2.get(i).equals(arr[i]) : "Wrong element";
        }
    }

    /**
     * Tests insertion in the inner position of the list.
     */
    public static void insertInnerTest() {
        int object = 99;
        Integer[] initArr = new Integer[]{1, 2, 3, 4, 5};
        Integer[] expectedArr = new Integer[]{1, 2, object, 3, 4, 5};
        MyArrayList<Integer> testedArrayList = new MyArrayList<>(initArr);

        insertTest(testedArrayList, expectedArr, object, 2);
    }

    /**
     * Tests insertion at the beginning of the list, (index: 0).
     */
    public static void insertFirstTest() {
        int object = 99;
        Integer[] initArr = new Integer[]{1, 2, 3, 4, 5};
        Integer[] expectedArr = new Integer[]{object, 1, 2, 3, 4, 5};
        MyArrayList<Integer> testedArrayList = new MyArrayList<>(initArr);

        insertTest(testedArrayList, expectedArr, object,0);
    }

    /**
     * Tests insertion at the end of the list, (index: size).
     */
    public static void insertLastTest() {
        int object = 99;
        Integer[] initArr = new Integer[]{1, 2, 3, 4, 5};
        Integer[] expectedArr = new Integer[]{1, 2, 3, 4, 5, object};
        MyArrayList<Integer> testedArrayList = new MyArrayList<>(initArr);

        insertTest(testedArrayList, expectedArr, object, initArr.length);
    }

    /**
     * Does the insertion and tests the result by checking conformity of the inner array of the testedArrayList.
     *
     * @param testedArrayList The list for testing.
     * @param expectedArr Expected inner array content.
     * @param object The object to be inserted.
     * @param insertIndex The position for the insertion.
     * @param <T> The generic type of the objects of the tested list.
     */
    public static <T> void insertTest(MyArrayList<T> testedArrayList, T[] expectedArr, T object, int insertIndex) {
        testedArrayList.add(object, insertIndex);
        assert testedArrayList.size() == expectedArr.length : "Wrong size";
        for (int i = 0; i < expectedArr.length; i++)
            assert testedArrayList.get(i).equals(expectedArr[i]) : "Wrong content";
    }

    /**
     * Tests the exceptions throwing correctness by insertion in empty arrayList.
     */
    public static void addExceptionTestsEmpty() {
        MyArrayList<Integer> testedArrayList = new MyArrayList<>();

        addExceptionTest(testedArrayList, 25, -9);
        addExceptionTest(testedArrayList, 25, 2);
        addExceptionTest(testedArrayList, 25, 99);
    }

    /**
     * Tests the exceptions throwing correctness by insertion in filled arrayList.
     */
    public static void addExceptionTestsFilled() {
        MyArrayList<Integer> testedArrayList = new MyArrayList<>();
        int elementsNum = 10;
        for (int i = 0; i < elementsNum; i++)
            testedArrayList.add(i);

        addExceptionTest(testedArrayList, 25, -1);
        addExceptionTest(testedArrayList, 25, elementsNum + 1);
        addExceptionTest(testedArrayList, 25, elementsNum * 2);
    }

    /**
     * Test correctness of the exception throwing when trying to insert the element
     * at the wrong position (out of bounds).
     *
     * @param testedArrayList The list for testing.
     * @param object The object to try to insert.
     * @param index The position for the insertion.
     * @param <T> The generic type of the objects of the tested list.
     */
    public static <T> void addExceptionTest(MyArrayList<T> testedArrayList, T object, int index) {
        try {
            testedArrayList.add(object, index);
            assert false : "IndexOutOfBoundsException expected";
        } catch (IndexOutOfBoundsException e) {
//            e.getCause();
        }
    }
}
