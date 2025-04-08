package com.shpp.p2p.cs.bhnatiuk.dataStructures.myStack;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myArrayList.MyArrayList;
import com.shpp.p2p.cs.bhnatiuk.dataStructures.myLinkedList.MyLinkedList;

import java.util.Iterator;

/**
 * The {@code MyStack} class that implements {@code LIFO} data access policy.
 *
 * <p>It uses {@link MyArrayList} as internal storage.</p>
 *
 * @author Bohdan Hnatiuk
 *
 * @param <T> the type of elements in this list.
 */
public class MyStack<T> implements Iterable<T> {
    /**
     * Internal storage list of the stack.
     */
    MyArrayList<T> list;

    /**
     * Default constructor that crates empty {@code MyStack} with default {@code initSize} and {@code step}.
     */
    public MyStack() {
        list = new MyArrayList<>();
    }

    /**
     * Constructor that crates empty {@code MyStack} with defined {@code initSize} and default {@code step}.
     *
     * @param initSize The size of {@code MyArrayList} inner array.
     * @throws IllegalArgumentException If init size is lover than 0.
     */
    public MyStack(int initSize) {
        list = new MyArrayList<>(initSize);
    }

    /**
     * Constructor that crates empty {@code MyStack} with defined {@code initSize} and {@code step}.
     *
     * @param initSize The size of {@code MyArrayList} inner array.
     * @param step The number of the elements to be added to {@code MyArrayList} when resizing the array.
     * @throws IllegalArgumentException If init size is lover than 0, or step isn't positive.
     */
    public MyStack(int initSize, int step) {
        list = new MyArrayList<>(initSize, step);
    }

    /**
     * Constructor that crates {@code MyStack} with {@code initArray} used as inner array.
     *
     * @param initArray The array with the elements to be assigned as {@code MyArrayList} inner array.
     * @throws IllegalArgumentException If init size is lover than 0, or step isn't positive.
     */
    public MyStack(T[] initArray) {
        list = new MyArrayList<>(initArray);
    }

    /**
     * Constructor that crates {@code MyStack} with {@code initArray} used as inner array and defined {@code step}.
     *
     * @param initArray The array with the elements to be assigned as {@code MyArrayList} inner array.
     * @param step The number of the elements to be added to {@code MyArrayList} when resizing the array.
     * @throws IllegalArgumentException If init size is lover than 0, or step isn't positive.
     */
    public MyStack(T[] initArray, int step) {
        list = new MyArrayList<>(initArray, step);
    }

    /**
     * Adds the element to the end of the list.
     *
     * @param object The object to be added.
     */
    public void push(T object) {
        list.add(object);
    }

    /**
     * Gets element from the end of the list and removes it.
     *
     * @return The item from the end of the list.
     */
    public T pop() {
        T temp = list.getLast();
        list.remove(size() - 1);
        return temp;
    }

    /**
     * Gets element from the end of the list, but doesn't remove it.
     *
     * @return The item from the end of the list.
     */
    public T top() {
        return list.getLast();
    }

    /**
     * Empties the stack.
     */
    public void clear() {
        list.clear();
    }

    /**
     * Gets the size of the list (number of all it's accessible elements).
     *
     * @return The value of the size field of inner list.
     */
    public int size() {
        return list.size();
    }

    /**
     * Shows if the list has any content.
     *
     * @return {@code true} if the size is 0, otherwise {@code false}
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Gets the inner list of the stack.
     *
     * @return {@link MyArrayList} object that stores the data of the queue.
     */
    public MyArrayList<T> getList() {
        return list;
    }

    /**
     * Implementation of the {@link Iterable} interface.
     *
     * @return The {@link Iterator} object, reversed version of the {@link MyArrayList} iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            /**
             * Index of object that will be currently returned by {@code next()},
             * starts with the last object of the list (top object of the stack).
             */
            private int iteration = size() - 1;

            /**
             * Shows if the iterator processed all the elements from the list.
             *
             * @return {@code true} if the {@code iterator} has more elements, otherwise {@code false}
             */
            @Override
            public boolean hasNext() {
                return iteration >= 0;
            }

            /**
             * Returns the next element in the iteration and decreases the iteration by 1.
             *
             * @return The next element in the list.
             * @throws IndexOutOfBoundsException If no more elements are available.
             */
            @Override
            public T next() {
                iteration--;
                return list.get(iteration + 1);
            }
        };
    }
}
