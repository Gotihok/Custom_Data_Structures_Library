package com.shpp.p2p.cs.bhnatiuk.dataStructures.testPresets;

/**
 * Contains constants used for testing the collections.
 */
public interface TesterConstants {
    /** Maximal array size boundary */
    int MAX_ARRAY_SIZE = Integer.MAX_VALUE / 32;

    /** Minimal array size boundary */
    int MIN_ARRAY_SIZE = 0;

    /** Maximal value boundary, for random number generator */
    int MAX_TESTED_VALUE = Integer.MAX_VALUE / 32;

    /** Minimal value boundary, for random number generator */
    int MIN_TESTED_VALUE = -Integer.MAX_VALUE / 32;

    /** The number of executions of random value tests */
    int TEST_ITERATIONS = 10;
}
