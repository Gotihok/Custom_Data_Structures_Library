package com.shpp.p2p.cs.bhnatiuk.dataStructures.myLinkedList.tests.randomValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList.MyArrayList;
import com.shpp.p2p.cs.bhnatiuk.dataStructures.myLinkedList.MyLinkedList;
import com.shpp.p2p.cs.bhnatiuk.dataStructures.testPresets.Randomizer;
import com.shpp.p2p.cs.bhnatiuk.dataStructures.testPresets.TesterConstants;

/**
 * Class with tests for {@link MyArrayList} replace method, that uses random values for testing.
 */
public class ReplaceTests implements TesterConstants {
    /**
     * Main method that runs all the tests of the class.
     */
    public static void main(String[] args) {
        replaceTest(TEST_ITERATIONS);
    }

    /**
     * Tests replacement in the random position
     * @param iterations Number of the executions of the test.
     */
    private static void replaceTest(int iterations) {
        for (int i = 0; i < iterations; i++) {
            int expArrayLength = Randomizer.randInt(MIN_ARRAY_SIZE, MAX_ARRAY_SIZE / 2048);
            Integer[] expectedArray = Randomizer.randIntArr(MIN_TESTED_VALUE, MAX_TESTED_VALUE, expArrayLength);

            MyLinkedList<Integer> testedLinkedList = new MyLinkedList<>();
            for (int obj : expectedArray)
                testedLinkedList.add(obj);

            for (int j = 0; j < expectedArray.length; j++) {
                int value = Randomizer.randInt(MIN_TESTED_VALUE, MAX_TESTED_VALUE);
                int index = Randomizer.randInt(MIN_ARRAY_SIZE, testedLinkedList.size());

                testedLinkedList.replace(value, index);
                expectedArray[index] = value;
            }

            for (int j = 0; j < expectedArray.length; j++) {
                assert testedLinkedList.get(j).equals(expectedArray[j]) : "Wrong content";
            }
        }
    }
}