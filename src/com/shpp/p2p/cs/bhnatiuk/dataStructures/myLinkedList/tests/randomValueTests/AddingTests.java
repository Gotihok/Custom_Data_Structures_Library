package com.shpp.p2p.cs.bhnatiuk.dataStructures.myLinkedList.tests.randomValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myLinkedList.MyLinkedList;
import com.shpp.p2p.cs.bhnatiuk.dataStructures.testPresets.Randomizer;
import com.shpp.p2p.cs.bhnatiuk.dataStructures.testPresets.TesterConstants;

/**
 * Class with tests for {@link MyLinkedList} adding methods, that uses random values for testing.
 */
public class AddingTests implements TesterConstants {
    /**
     * Main method that runs all the tests of the class.
     */
    public static void main(String[] args) {
        addingElementsSequentially(TEST_ITERATIONS);
        addingElementsAtTheBeginning(TEST_ITERATIONS);
    }

    /**
     * Tests the 2 adding method overloads (object; object + position) of the adding method
     * by sequential adding elements to the end of the list
     * @param iterations Number of the executions of the test.
     */
    private static void addingElementsSequentially(int iterations) {
        for (int i = 0; i < iterations; i++) {
            int expArrayLength = Randomizer.randInt(MIN_ARRAY_SIZE, MAX_ARRAY_SIZE / 2048);
            Integer[] expectedArray = Randomizer.randIntArr(MIN_TESTED_VALUE, MAX_TESTED_VALUE, expArrayLength);

            MyLinkedList<Integer> testedLinkedList1 = new MyLinkedList<>();
            MyLinkedList<Integer> testedLinkedList2 = new MyLinkedList<>();
            for (int j = 0; j < expectedArray.length; j++) {
                testedLinkedList1.add(expectedArray[j]);
                testedLinkedList2.add(expectedArray[j], j);
            }

            for (int j = 0; j < expectedArray.length; j++) {
                assert testedLinkedList1.get(j).equals(expectedArray[j]) : "Wrong arrayList content";
                assert testedLinkedList2.get(j).equals(expectedArray[j]) : "Wrong arrayList content";
            }
        }
    }

    /**
     * Tests insertion at the beginning of the list, (index: 0).
     * @param iterations Number of the executions of the test.
     */
    private static void addingElementsAtTheBeginning(int iterations) {
        for (int i = 0; i < iterations; i++) {
            int expArrayLength = Randomizer.randInt(MIN_ARRAY_SIZE, MAX_ARRAY_SIZE / 2048);
            Integer[] expectedArray = Randomizer.randIntArr(MIN_TESTED_VALUE, MAX_TESTED_VALUE, expArrayLength);

            MyLinkedList<Integer> testedLinkedList = new MyLinkedList<>();
            for (int j = expectedArray.length - 1; j >= 0; j--) {
                testedLinkedList.add(expectedArray[j], 0);
            }

            for (int j = expectedArray.length - 1; j >= 0; j--) {
                assert testedLinkedList.get(j).equals(expectedArray[j]) : "Wrong arrayList content";
            }
        }
    }
}
