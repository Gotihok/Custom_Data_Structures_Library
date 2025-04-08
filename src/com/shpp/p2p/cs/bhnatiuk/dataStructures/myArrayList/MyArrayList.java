package com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myAbstractList.MyAbstractList;

import java.util.Iterator;

/**
 * The {@code MyArrayList} class that completes {@link MyAbstractList} functionality and provides its own.
 * The class is used to store objects in dynamic sized array.
 *
 * <p>It uses {@link Object} array casted to the generic type as internal storage.</p>
 *
 * @author Bohdan Hnatiuk
 *
 * @param <T> the type of elements in this list.
 */
@SuppressWarnings("unchecked")
public class MyArrayList<T> extends MyAbstractList<T> {
    /**
     * Default size of the array used while creating an {@code MyArrayList}
     * without giving init size or array for the constructor.
     */
    public static final int DEFAULT_ARRAY_LENGTH = 16;

    /**
     * Default array increase step used while creating an {@code MyArrayList}
     * without giving init step for the constructor.
     *
     * <p>Cannot be passed without init size or array.</p>
     */
    public static final int DEFAULT_INCREASE_STEP = 16;

    /**
     * Internal array of the list, where all the elements are stored.
     *
     * <p>Can have reserved space for later elements adding, without direct access to it.</p>
     */
    private T[] array;

    /**
     * Increase step that represent how many reserved element spaces will be added to the {@code array}.
     *
     * <p>Must be a positive number.</p>
     */
    private final int step;

    /**
     * Default constructor that crates empty {@code MyArrayList} with default {@code initSize} and {@code step}.
     */
    public MyArrayList() {
        this(DEFAULT_ARRAY_LENGTH, DEFAULT_INCREASE_STEP);
    }

    /**
     * Constructor that crates empty {@code MyArrayList} with defined {@code initSize} and default {@code step}.
     *
     * @param initSize The size of inner array.
     * @throws IllegalArgumentException If init size is lover than 0.
     */
    public MyArrayList(int initSize) throws IllegalArgumentException {
        this(initSize, DEFAULT_INCREASE_STEP);
    }

    /**
     * Constructor that crates empty {@code MyArrayList} with defined {@code initSize} and {@code step}.
     *
     * @param initSize The size of inner array.
     * @param step The number of the elements to be added when resizing the array.
     * @throws IllegalArgumentException If init size is lover than 0, or step isn't positive.
     */
    public MyArrayList(int initSize, int step) {
        if (initSize < 0)
            throw new IllegalArgumentException("Init size can't be negative");
        if (step <= 0)
            throw new IllegalArgumentException("Step can't be negative or zero");

        this.array = (T[]) new Object[initSize];
        this.size = 0;
        this.step = step;
    }

    /**
     * Constructor that crates {@code MyArrayList} with {@code initArray} used as inner array.
     *
     * @param initArray The array with the elements to be assigned as an inner array.
     * @throws IllegalArgumentException If init size is lover than 0, or step isn't positive.
     */
    public MyArrayList(T[] initArray) {
        this(initArray, DEFAULT_INCREASE_STEP);
    }

    /**
     * Constructor that crates {@code MyArrayList} with {@code initArray} used as inner array and defined {@code step}.
     *
     * @param initArray The array with the elements to be assigned as an inner array.
     * @param step The number of the elements to be added when resizing the array.
     * @throws IllegalArgumentException If init size is lover than 0, or step isn't positive.
     */
    public MyArrayList(T[] initArray, int step) {
        if (step < 0)
            throw new IllegalArgumentException("Step can't be negative");

        this.array = initArray;
        this.size = initArray.length;
        this.step = step;
    }

    /**
     * {@inheritDoc}
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        return array[index];
    }

    /**
     * Returns inner array field.
     */
    public T[] getArray() {
        return array;
    }

    /**
     * {@inheritDoc}
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public void add(T object, int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);

        size++;
        resize();
        System.arraycopy(array, index, array, index + 1, array.length - index - 1);
        array[index] = object;
    }

    /**
     * {@inheritDoc}
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public void replace(T object, int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        array[index] = object;
    }

    /**
     * {@inheritDoc}
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public void remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);

        size--;
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        size = 0;
    }

    /**
     * Empties the list by deleting the old array and assigning new and not only zeroing the size.
     */
    public void clearStrict() {
        array = (T[]) new Object[DEFAULT_ARRAY_LENGTH];
        size = 0;
    }

    /**
     * Returns the step field.
     */
    public int step() {
        return step;
    }

    /**
     * Returns an inner array length.
     */
    public int arrayLength() {
        return array.length;
    }

    /**
     * Increases the size of the inner array by the step field value.
     */
    public void resize() {
        if (size > array.length)
            resize(step);
    }

    /**
     * Increases the size of the inner array by the defined step.
     *
     * @param increment The number of the elements to be added to the inner array.
     * @throws IllegalArgumentException If the increment is negative.
     */
    public void resize(int increment) {
        if (increment < 0)
            throw new IllegalArgumentException("Increment can't be negative");

        T[] tempArr = (T[]) new Object[array.length + increment];
        System.arraycopy(array, 0, tempArr, 0, array.length);
        array = tempArr;
    }

    /**
     * Implementation of the {@link Iterable} interface.
     *
     * @return The {@link Iterator} object.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            /**
             * Index of object that will be currently returned by {@code next()},
             * starts with the first object of the list.
             */
            private int iteration = 0;

            /**
             * Shows if the iterator processed all the elements from the list.
             *
             * @return {@code true} if the {@code iterator} has more elements, otherwise {@code false}
             */
            @Override
            public boolean hasNext() {
                return iteration < size;
            }

            /**
             * Returns the next element in the iteration and increases the iteration by 1.
             *
             * @return The next element in the list.
             * @throws IndexOutOfBoundsException If no more elements are available.
             */
            @Override
            public T next() throws IndexOutOfBoundsException {
                iteration++;
                return get(iteration - 1);
            }
        };
    }
}
