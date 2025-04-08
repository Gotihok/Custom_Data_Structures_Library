package com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList.tests.randomValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList.MyArrayList;
import com.shpp.p2p.cs.bhnatiuk.dataStructures.testPresets.Randomizer;
import com.shpp.p2p.cs.bhnatiuk.dataStructures.testPresets.TesterConstants;

/**
 * Class with tests for {@link MyArrayList} adding methods, that uses random values for testing.
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

            MyArrayList<Integer> testedArrayList1 = new MyArrayList<>();
            MyArrayList<Integer> testedArrayList2 = new MyArrayList<>();
            for (int j = 0; j < expectedArray.length; j++) {
                testedArrayList1.add(expectedArray[j]);
                testedArrayList2.add(expectedArray[j], j);
            }

            for (int j = 0; j < expectedArray.length; j++) {
                assert testedArrayList1.get(j).equals(expectedArray[j]) : "Wrong arrayList content";
                assert testedArrayList2.get(j).equals(expectedArray[j]) : "Wrong arrayList content";
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

            MyArrayList<Integer> testedArrayList = new MyArrayList<>();
            for (int j = expectedArray.length - 1; j >= 0; j--) {
                testedArrayList.add(expectedArray[j], 0);
            }

            for (int j = expectedArray.length - 1; j >= 0; j--) {
                assert testedArrayList.get(j).equals(expectedArray[j]) : "Wrong arrayList content";
            }
        }
    }
}
