package com.shpp.p2p.cs.bhnatiuk.dataStructures.myLinkedList.tests.predefinedValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myLinkedList.MyLinkedList;

import java.util.NoSuchElementException;

/**
 * Class with tests for {@link MyLinkedList} adding method, that uses predefined values for testing.
 */
public class GetNodePredefinedTest {
    /**
     * Main method that runs all the tests of the class.
     */
    public static void main(String[] args) {
        getNodeInPositionTest();
        getNodeInPositionExceptionsTests();
        getNodeTest();
        getNodeExceptionTest();
    }

    /**
     * Tests getNode() method at first and last positions of the list.
     */
    public static void getNodeTest() {
        MyLinkedList<String> testedLinkedList = new MyLinkedList<>();

        testedLinkedList.add("asd");
        testedLinkedList.add("qwe");
        testedLinkedList.add("zxc");
        testedLinkedList.add("qaz");

        assert testedLinkedList.getNode(0).getValue().equals("asd") : "getNode wrong value";
        assert testedLinkedList.getNode(3).getValue().equals("qaz") : "getNode wrong value";
    }

    /**
     * Tests getNode() method exceptions throwing correctness at first and last positions of the list.
     */
    public static void getNodeExceptionTest() {
        MyLinkedList<String> testedLinkedList = new MyLinkedList<>();

        try {
            testedLinkedList.getNode(0);
            assert false : "IndexOutOfBoundsException expected";
        } catch (IndexOutOfBoundsException e) {
//            e.printStackTrace();
        }

        try {
            testedLinkedList.getNode(testedLinkedList.size());
            assert false : "IndexOutOfBoundsException expected";
        } catch (IndexOutOfBoundsException e) {
//            e.printStackTrace();
        }
    }

    /**
     * Tests getNode() method iterating through the array.
     */
    public static void getNodeInPositionTest() {
        Double[] values = new Double[]{2.5, 3.0, 3.5, 4.0, -9.9, 0.0};
        MyLinkedList<Double> testedLinkedList = new MyLinkedList<>();
        for (Double value : values)
            testedLinkedList.add(value);

        for (int i = 0; i < values.length; i++)
            assert testedLinkedList.getNode(i).getValue().equals(values[i]) : "Element is not equal";
    }

    /**
     * Tests getNode() method exceptions throwing correctness with filled list.
     */
    public static void getNodeInPositionExceptionsTests() {
        MyLinkedList<Integer> testedLinkedList = new MyLinkedList<>();

        for (int i = 0; i < 20; i++)
            testedLinkedList.add(i);

        getNodeInPositionExceptionsTest(testedLinkedList, 50);
        getNodeInPositionExceptionsTest(testedLinkedList, -10);
        getNodeInPositionExceptionsTest(testedLinkedList, 23);
    }

    /**
     * Tests getNode() exception throwing in specified position.
     *
     * @param testedLinkedList The LinkedList to test.
     * @param index The index of node getting.
     * @param <T> The generic type of the objects of the tested list.
     */
    public static <T> void getNodeInPositionExceptionsTest(MyLinkedList<T> testedLinkedList, int index) {
        try {
            testedLinkedList.getNode(index);
            assert false : "IndexOutOfBoundsException expected";
        } catch (IndexOutOfBoundsException e) {
//            e.printStackTrace();
        }
    }
}
