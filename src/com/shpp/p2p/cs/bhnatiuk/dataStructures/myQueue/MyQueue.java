package com.shpp.p2p.cs.bhnatiuk.dataStructures.myQueue;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myLinkedList.MyLinkedList;

import java.util.Iterator;

/**
 * The {@code MyQueue} class that implements {@code FIFO} data access policy.
 *
 * <p>It uses {@link MyLinkedList} as internal storage.</p>
 *
 * @author Bohdan Hnatiuk
 *
 * @param <T> the type of elements in this list.
 */
public class MyQueue<T> implements Iterable<T>{
    /**
     * Internal storage list of the queue.
     */
    private final MyLinkedList<T> list;

    /**
     * Default constructor that crates empty {@code MyQueue}.
     */
    public MyQueue() {
        list = new MyLinkedList<>();
    }

    /**
     * Init array constructor that crates {@code MyQueue} with the content of the init array.
     *
     * @param initArray The array with elements to be added to the {@code MyLinkedList}.
     */
    public MyQueue(T[] initArray) {
        list = new MyLinkedList<>(initArray);
    }

    /**
     * Adds the element to the end of the list.
     *
     * @param object The object to be added.
     */
    public void enqueue(T object) {
        list.addLast(object);
    }

    /**
     * Gets element from the beginning of the list and removes it.
     *
     * @return The item from the beginning of the list.
     */
    public T dequeue() {
        T temp = list.getFirst();
        list.remove(0);
        return temp;
    }

    /**
     * Gets element from the beginning of the list, but doesn't remove it.
     *
     * @return The item from the beginning of the list.
     */
    public T peek() {
        return list.getFirst();
    }

    /**
     * Empties the queue.
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
     * Gets the inner list of the queue.
     *
     * @return {@link MyLinkedList} object that stores the data of the queue.
     */
    public MyLinkedList<T> getList() {
        return list;
    }

    /**
     * Implementation of the {@link Iterable} interface.
     *
     * @return The {@link Iterator} object, similar to the {@link MyLinkedList} iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
