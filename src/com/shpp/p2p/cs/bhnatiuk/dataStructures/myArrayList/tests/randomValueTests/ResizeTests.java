package com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList.tests.randomValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList.MyArrayList;
import com.shpp.p2p.cs.bhnatiuk.dataStructures.testPresets.Randomizer;
import com.shpp.p2p.cs.bhnatiuk.dataStructures.testPresets.TesterConstants;

/**
 * Class with tests for {@link MyArrayList} resize methods, that uses random values for testing.
 */
public class ResizeTests implements TesterConstants {
    /**
     * Main method that runs all the tests of the class.
     */
    public static void main(String[] args) {
        resizingWithStep(TEST_ITERATIONS);
    }

    /**
     * Tests resizing by the random value.
     * @param iterations Number of the executions of the test.
     */
    private static void resizingWithStep(int iterations) {
        for (int i = 0; i < iterations; i++) {
            int subIterations = Randomizer.randInt(1, iterations);
            int expectedArrayLength = Randomizer.randInt(MIN_ARRAY_SIZE, MAX_ARRAY_SIZE / subIterations);

            MyArrayList<Integer> testedArrayList = new MyArrayList<>(expectedArrayLength);

            for (int j = 0; j < subIterations; j++) {
                int expArrayIncrease = Randomizer.randInt(MIN_ARRAY_SIZE, MAX_ARRAY_SIZE / subIterations);
                testedArrayList.resize(expArrayIncrease);
                expectedArrayLength += expArrayIncrease;
            }

            assert testedArrayList.arrayLength() == expectedArrayLength : "Wrong array length";
            assert testedArrayList.isEmpty() : "Wrong size";
        }
    }
}
