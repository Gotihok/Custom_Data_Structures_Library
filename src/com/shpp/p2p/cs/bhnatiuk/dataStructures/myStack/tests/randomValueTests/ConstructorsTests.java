package com.shpp.p2p.cs.bhnatiuk.dataStructures.myStack.tests.randomValueTests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList.MyArrayList;
import com.shpp.p2p.cs.bhnatiuk.dataStructures.myStack.MyStack;
import com.shpp.p2p.cs.bhnatiuk.dataStructures.testPresets.Randomizer;
import com.shpp.p2p.cs.bhnatiuk.dataStructures.testPresets.TesterConstants;

import java.util.Arrays;

/**
 * Class with tests for {@link MyStack} constructors, that uses random values for testing.
 */
public class ConstructorsTests implements TesterConstants {
    /// Testing fields
    private static Integer[] expectedArray;    //ArrayInside
    private static int expectedSize;           //Starting size (obj quantity)
    private static int expectedStep;           //Step
    private static int expArrayLength;         //Array length ()

    private static MyStack<Integer> testedStack;

    /**
     * Main method that runs all the tests of the class.
     */
    public static void main(String[] args) {
        noParametersConstructor();
        initSizeConstructor(TEST_ITERATIONS);
        initSizeStepConstructor(TEST_ITERATIONS);
        initArrayConstructor(TEST_ITERATIONS);
        initArrayStepConstructor(TEST_ITERATIONS);
//        System.out.println("End");
    }

    /**
     * Sets the default values to the fields and must be called at the beginning of each constructor's testing method.
     */
    private static void setFieldsDefaultValues() {
        expectedArray = new Integer[MyArrayList.DEFAULT_ARRAY_LENGTH];
        expectedSize = 0;
        expectedStep = MyArrayList.DEFAULT_INCREASE_STEP;
        expArrayLength = MyArrayList.DEFAULT_ARRAY_LENGTH;
    }

    /**
     * Tests default constructor without parameters passed.
     */
    private static void noParametersConstructor() {
        setFieldsDefaultValues();

        testedStack = new MyStack<>();
        MyArrayList<Integer> testedArrayList = testedStack.getList();

        testConstructor(testedArrayList, expectedArray, expectedSize, expectedStep, expArrayLength);
    }

    /**
     * Tests constructor with initSize passed.
     * @param iterations Number of the executions of the test.
     */
    private static void initSizeConstructor(int iterations) {
        setFieldsDefaultValues();

        for (int i = 0; i < iterations; i++) {
            expArrayLength = Randomizer.randInt(MIN_ARRAY_SIZE, MAX_ARRAY_SIZE);
            expectedArray = new Integer[expArrayLength];

            testedStack = new MyStack<>(expArrayLength);
            MyArrayList<Integer> testedArrayList = testedStack.getList();

            testConstructor(testedArrayList, expectedArray, expectedSize, expectedStep, expArrayLength);
        }
    }

    /**
     * Tests constructor with initSize and step passed.
     * @param iterations Number of the executions of the test.
     */
    private static void initSizeStepConstructor(int iterations) {
        setFieldsDefaultValues();

        for (int i = 0; i < iterations; i++) {
            expectedStep = Randomizer.randInt(0, MAX_TESTED_VALUE);
            expArrayLength = Randomizer.randInt(MIN_ARRAY_SIZE, MAX_ARRAY_SIZE);
            expectedArray = new Integer[expArrayLength];

            testedStack = new MyStack<>(expArrayLength, expectedStep);
            MyArrayList<Integer> testedArrayList = testedStack.getList();

            testConstructor(testedArrayList, expectedArray, expectedSize, expectedStep, expArrayLength);
        }
    }

    /**
     * Tests constructor with initArray passed.
     * @param iterations Number of the executions of the test.
     */
    private static void initArrayConstructor(int iterations) {
        setFieldsDefaultValues();

        for (int i = 0; i < iterations; i++) {
            expArrayLength = Randomizer.randInt(MIN_ARRAY_SIZE, MAX_ARRAY_SIZE);
            expectedArray = Randomizer.randIntArr(MIN_TESTED_VALUE, MAX_TESTED_VALUE, expArrayLength);

            expectedSize = expArrayLength;

            testedStack = new MyStack<>(expectedArray);
            MyArrayList<Integer> testedArrayList = testedStack.getList();

            testConstructor(testedArrayList, expectedArray, expectedSize, expectedStep, expArrayLength);
        }
    }

    /**
     * Tests constructor with initArray and step passed.
     * @param iterations Number of the executions of the test.
     */
    private static void initArrayStepConstructor(int iterations) {
        setFieldsDefaultValues();

        for (int i = 0; i < iterations; i++) {
            expArrayLength = Randomizer.randInt(MIN_ARRAY_SIZE, MAX_ARRAY_SIZE);
            expectedArray = Randomizer.randIntArr(MIN_TESTED_VALUE, MAX_TESTED_VALUE, expArrayLength);

            expectedSize = expArrayLength;
            expectedStep = Randomizer.randInt(0, MAX_TESTED_VALUE);

            testedStack = new MyStack<>(expectedArray, expectedStep);
            MyArrayList<Integer> testedArrayList = testedStack.getList();

            testConstructor(testedArrayList, expectedArray, expectedSize, expectedStep, expArrayLength);
        }
    }

    /**
     * Test correctness of the constructors values.
     *
     * @param testedArrayList ArrayList for testing.
     * @param expectedArray Expected inner array.
     * @param expectedSize Expected size of the list.
     * @param expectedStep Expected step of the list.
     * @param expArrayLength Expected length of the inner array of the list.
     * @param <T> The generic type of the objects of the tested list.
     */
    private static <T> void testConstructor(MyArrayList<T> testedArrayList, T[] expectedArray, int expectedSize,
                                               int expectedStep, int expArrayLength) {
        assert testedArrayList.size() == expectedSize : "Wrong size";
        assert testedArrayList.step() == expectedStep : "Wrong step";
        assert testedArrayList.arrayLength() == expArrayLength : "Wrong arrayLength";
        assert Arrays.equals(testedArrayList.getArray(), expectedArray) : "Wrong content";
    }
}
