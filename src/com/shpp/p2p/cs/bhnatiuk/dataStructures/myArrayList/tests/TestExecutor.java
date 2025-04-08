package com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList.tests;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList.MyArrayList;
import com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList.tests.predefinedValueTests.*;
import com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList.tests.randomValueTests.AddingTests;
import com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList.tests.randomValueTests.ConstructorsTests;
import com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList.tests.randomValueTests.ReplaceTests;
import com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList.tests.randomValueTests.ResizeTests;

/**
 * Class that executes all the tests for {@link MyArrayList}.
 *
 * <p>Must be called with the assertions enabled</p>
 */
public class TestExecutor {
    public static void main(String[] args) {
        System.out.println("Testing MyArrayList\n");
        executePredefinedValuesTests();
        executeRandomValuesTests();
        System.out.println("Testing MyArrayList ended\n");
    }

    private static void executeRandomValuesTests() {
        System.out.println("\tStarting random values tests");
        AddingTests.main(new String[]{});
        ConstructorsTests.main(new String[]{});
        ReplaceTests.main(new String[]{});
        ResizeTests.main(new String[]{});
        System.out.println("\tRandom values tests ended\n");
    }

    private static void executePredefinedValuesTests() {
        System.out.println("\tStarting predefined values tests");
        GettingPredefinedTests.main(new String[]{});
        AddingPredefinedTests.main(new String[]{});
        ClearPredefinedTests.main(new String[]{});
        ConstructorPredefinedTests.main(new String[]{});
        ContainsPredefinedTests.main(new String[]{});
        IteratorPredefinedTests.main(new String[]{});
        RemovePredefinedTests.main(new String[]{});
        ReplacePredefinedTests.main(new String[]{});
        ResizePredefinedTests.main(new String[]{});
        System.out.println("\tPredefined values tests ended\n");
    }
}
