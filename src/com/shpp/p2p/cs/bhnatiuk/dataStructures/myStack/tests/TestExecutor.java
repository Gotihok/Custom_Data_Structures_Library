package com.shpp.p2p.cs.bhnatiuk.dataStructures.myStack.tests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myStack.MyStack;
import com.shpp.p2p.cs.bhnatiuk.dataStructures.myStack.tests.predefinedValueTests.*;
import com.shpp.p2p.cs.bhnatiuk.dataStructures.myStack.tests.randomValueTests.ConstructorsTests;

/**
 * Class that executes all the tests for {@link MyStack}.
 *
 * <p>Must be called with the assertions enabled</p>
 */
public class TestExecutor {
    public static void main(String[] args) {
        System.out.println("Testing MyStack\n");
        executePredefinedValuesTests();
        executeRandomValuesTests();
        System.out.println("Testing MyStack ended\n");
    }

    private static void executeRandomValuesTests() {
        System.out.println("\tStarting random values tests");
        ConstructorsTests.main(new String[]{});
        System.out.println("\tRandom values tests ended\n");
    }

    private static void executePredefinedValuesTests() {
        System.out.println("\tStarting predefined values tests");
        GettingPredefinedTests.main(new String[]{});
        ConstructorPredefinedTests.main(new String[]{});
        ClearPredefinedTests.main(new String[]{});
        IteratorPredefinedTests.main(new String[]{});
        PushPredefinedTests.main(new String[]{});
        SizePredefinedTests.main(new String[]{});
        System.out.println("\tPredefined values tests ended\n");

    }
}
