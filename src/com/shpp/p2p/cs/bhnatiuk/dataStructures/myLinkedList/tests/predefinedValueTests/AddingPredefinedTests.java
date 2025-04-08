package com.shpp.p2p.cs.bhnatiuk.dataStructures.myLinkedList.tests.predefinedValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myLinkedList.MyLinkedList;

/**
 * Class with tests for {@link MyLinkedList} adding methods, that uses predefined values for testing.
 */
public class AddingPredefinedTests {
    /**
     * Main method that runs all the tests of the class.
     */
    public static void main(String[] args) {
        addTest();
        addFirstEmptyListTest();
        addLastEmptyListTest();
        addFirstTest();
        addLastTest();
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
        MyLinkedList<Integer> testedLinkedList1 = new MyLinkedList<>();
        MyLinkedList<Integer> testedLinkedList2 = new MyLinkedList<>();
        Integer[] arr = new Integer[]{1, 2, 3, 9, 87};

        for (int i = 0; i < arr.length; i++) {
            testedLinkedList1.add(arr[i]);
            testedLinkedList2.add(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            assert testedLinkedList1.get(i).equals(arr[i]) : "Wrong element";
            assert testedLinkedList2.get(i).equals(arr[i]) : "Wrong element";
        }
    }

    /**
     * Tests addFirst() on empty list
     */
    public static void addFirstEmptyListTest() {
        int object = 99;
        MyLinkedList<Integer> testedLinkedList = new MyLinkedList<>();
        testedLinkedList.addFirst(object);

        assert testedLinkedList.get(0).equals(object) : "Wrong element";
    }

    /**
     * Tests addLast() on empty list
     */
    public static void addLastEmptyListTest() {
        int object = 99;
        MyLinkedList<Integer> testedLinkedList = new MyLinkedList<>();
        testedLinkedList.addLast(object);

        assert testedLinkedList.get(0).equals(object) : "Wrong element";
    }

    /**
     * Tests addFirst() on filled list
     */
    public static void addFirstTest() {
        int object = 99;
        Integer[] initArr = new Integer[]{1, 2, 3, 4, 5};
        Integer[] expectedArr = new Integer[]{object, 1, 2, 3, 4, 5};

        MyLinkedList<Integer> testedLinkedList = new MyLinkedList<>();
        for (Integer obj : initArr)
            testedLinkedList.add(obj);

        testedLinkedList.addFirst(object);
        checkContent(testedLinkedList, expectedArr);
    }

    /**
     * Tests addLast() on filled list
     */
    public static void addLastTest() {
        int object = 99;
        Integer[] initArr = new Integer[]{1, 2, 3, 4, 5};
        Integer[] expectedArr = new Integer[]{1, 2, 3, 4, 5, object};

        MyLinkedList<Integer> testedLinkedList = new MyLinkedList<>();
        for (Integer obj : initArr)
            testedLinkedList.add(obj);

        testedLinkedList.addLast(object);
        checkContent(testedLinkedList, expectedArr);
    }

    /**
     * Tests insertion in the inner position of the list.
     */
    public static void insertInnerTest() {
        int object = 99;
        Integer[] initArr = new Integer[]{1, 2, 3, 4, 5};
        Integer[] expectedArr = new Integer[]{1, 2, object, 3, 4, 5};

        insertTest(initArr, expectedArr, object, 2);
    }

    /**
     * Tests insertion at the beginning of the list, (index: 0).
     */
    public static void insertFirstTest() {
        int object = 99;
        Integer[] initArr = new Integer[]{1, 2, 3, 4, 5};
        Integer[] expectedArr = new Integer[]{object, 1, 2, 3, 4, 5};

        insertTest(initArr, expectedArr, object,0);
    }

    /**
     * Tests insertion at the end of the list, (index: size).
     */
    public static void insertLastTest() {
        int object = 99;
        Integer[] initArr = new Integer[]{1, 2, 3, 4, 5};
        Integer[] expectedArr = new Integer[]{1, 2, 3, 4, 5, object};

        insertTest(initArr, expectedArr, object, initArr.length);
    }

    /**
     * Tests linkedList parameters accordance to the expected.
     *
     * @param initArr Elements to add to linkedList while preparing it to test.
     * @param expectedArr Expected list content.
     * @param object The object to be inserted.
     * @param insertIndex The position for the insertion.
     * @param <T> The generic type of the objects of the tested list.
     */
    public static <T> void insertTest(T[] initArr, T[] expectedArr, T object, int insertIndex) {
        MyLinkedList<T> testedLinkedList = new MyLinkedList<>();
        for (T obj : initArr)
            testedLinkedList.add(obj);

        testedLinkedList.add(object, insertIndex);
        checkContent(testedLinkedList, expectedArr);
    }

    /**
     * Checks the content of the linkedList.
     *
     * @param testedLinkedList linkedList ot test.
     * @param expectedArr Expected list content.
     * @param <T> The generic type of the objects of the tested list.
     */
    private static <T> void checkContent(MyLinkedList<T> testedLinkedList, T[] expectedArr) {
        assert testedLinkedList.size() == expectedArr.length : "Wrong size";
        for (int i = 0; i < expectedArr.length; i++)
            assert testedLinkedList.get(i).equals(expectedArr[i]) : "Wrong content";
    }

    /**
     * Tests the exceptions throwing correctness by insertion in empty arrayList.
     */
    public static void addExceptionTestsEmpty() {
        MyLinkedList<Integer> testedLinkedList = new MyLinkedList<>();

        addExceptionTest(testedLinkedList, 25, -9);
        addExceptionTest(testedLinkedList, 25, 2);
        addExceptionTest(testedLinkedList, 25, 99);
    }

    /**
     * Tests the exceptions throwing correctness by insertion in filled arrayList.
     */
    public static void addExceptionTestsFilled() {
        MyLinkedList<Integer> testedLinkedList = new MyLinkedList<>();
        int elementsNum = 10;
        for (int i = 0; i < elementsNum; i++)
            testedLinkedList.add(i);

        addExceptionTest(testedLinkedList, 25, -1);
        addExceptionTest(testedLinkedList, 25, elementsNum + 1);
        addExceptionTest(testedLinkedList, 25, elementsNum * 2);
    }

    /**
     * Test correctness of the exception throwing when trying to insert the element
     * at the wrong position (out of bounds).
     *
     * @param testedLinkedList The list for testing.
     * @param object The object to try to insert.
     * @param index The position for the insertion.
     * @param <T> The generic type of the objects of the tested list.
     */
    public static <T> void addExceptionTest(MyLinkedList<T> testedLinkedList, T object, int index) {
        try {
            testedLinkedList.add(object, index);
            assert false : "IndexOutOfBoundsException expected";
        } catch (IndexOutOfBoundsException e) {
//            e.printStackTrace();
        }
    }
}
