package com.shpp.p2p.cs.bhnatiuk.dataStructures.myQueue.tests.randomValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myLinkedList.MyLinkedList;
import com.shpp.p2p.cs.bhnatiuk.dataStructures.myQueue.MyQueue;
import com.shpp.p2p.cs.bhnatiuk.dataStructures.testPresets.Randomizer;
import com.shpp.p2p.cs.bhnatiuk.dataStructures.testPresets.TesterConstants;

/**
 * Class with tests for {@link MyLinkedList} adding and removing methods, that uses random values for testing.
 */
public class AddingRemovingTests implements TesterConstants {
    /**
     * Main method that runs all the tests of the class.
     */
    public static void main(String[] args) {
        addingRemovingSequentially(TEST_ITERATIONS);
    }

    /**
     * Tests if enqueue() and dequeue() correctly add and remove the elements.
     * @param iterations Number of the executions of the test.
     */
    private static void addingRemovingSequentially(int iterations) {
        for (int i = 0; i < iterations; i++) {
            int expArrayLength = Randomizer.randInt(MIN_ARRAY_SIZE, MAX_ARRAY_SIZE / 2048);
            Integer[] expectedArray = Randomizer.randIntArr(MIN_TESTED_VALUE, MAX_TESTED_VALUE, expArrayLength);

            MyQueue<Integer> testedQueue = new MyQueue<>();
            for (Integer value : expectedArray)
                testedQueue.enqueue(value);

            for (Integer integer : expectedArray) {
                assert testedQueue.peek().equals(integer) : "Wrong arrayList content";
                assert testedQueue.dequeue().equals(integer) : "Wrong arrayList content";
            }
        }
    }
}
