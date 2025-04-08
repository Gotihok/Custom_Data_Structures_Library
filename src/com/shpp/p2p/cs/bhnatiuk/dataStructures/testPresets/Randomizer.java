package com.shpp.p2p.cs.bhnatiuk.dataStructures.testPresets;

/**
 * Contains methods for generating random integers and random integer arrays
 */
public class Randomizer {
    /**
     * Returns random int in defined boundaries.
     *
     * @param min The minimal border of the returned value inclusively.
     * @param max The maximal border of the returned value exclusively.
     */
    public static int randInt(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    /**
     * Returns the array with random int values in defined boundaries.
     *
     * @param min The minimal border of the array element value inclusively.
     * @param max The maximal border of the array element value exclusively.
     * @param quantity The number of the elements in the returned array.
     */
    public static Integer[] randIntArr(int min, int max, int quantity) {
        Integer[] arr = new Integer[quantity];

        for (int i = 0; i < quantity; i++)
            arr[i] = (int) (Math.random() * (max - min) + min);

        return arr;
    }
}
