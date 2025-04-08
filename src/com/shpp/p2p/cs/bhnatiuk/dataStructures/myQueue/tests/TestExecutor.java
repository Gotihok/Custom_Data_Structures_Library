package com.shpp.p2p.cs.bhnatiuk.dataStructures.myQueue.tests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myQueue.MyQueue;
import com.shpp.p2p.cs.bhnatiuk.dataStructures.myQueue.tests.predefinedValueTests.*;
import com.shpp.p2p.cs.bhnatiuk.dataStructures.myQueue.tests.randomValueTests.AddingRemovingTests;

/**
 * Class that executes all the tests for {@link MyQueue}.
 *
 * <p>Must be called with the assertions enabled</p>
 */
public class TestExecutor {
    public static void main(String[] args) {
        System.out.println("Testing MyQueue\n");
        executePredefinedValuesTests();
        executeRandomValuesTests();
        System.out.println("Testing MyQueue ended\n");
    }

    private static void executeRandomValuesTests() {
        System.out.println("\tStarting random values tests");
        AddingRemovingTests.main(new String[]{});
        System.out.println("\tRandom values tests ended\n");
    }

    private static void executePredefinedValuesTests() {
        System.out.println("\tStarting predefined values tests");
        GettingPredefinedTests.main(new String[]{});
        EnqueuePredefinedTests.main(new String[]{});
        ClearPredefinedTests.main(new String[]{});
        ConstructorPredefinedTests.main(new String[]{});
        IteratorPredefinedTests.main(new String[]{});
        SizePredefinedTests.main(new String[]{});
        System.out.println("\tPredefined values tests ended\n");
    }
}
