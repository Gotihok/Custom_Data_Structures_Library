package com.shpp.p2p.cs.bhnatiuk.dataStructures.myAbstractList;

import java.util.NoSuchElementException;

/**
 * An abstract class representing an abstract list.
 * This class provides basic list operations such as adding, removing,
 * replacing, and checking for containment.
 *
 * @implNote {@code MyAbstractList} defines fundamental list operations but does not provide
 *           an internal data storage mechanism. Subclasses must implement methods
 *           for element access, modification, and deletion.
 *           Implementing classes must maintain the {@code size} field,
 *           ensuring it represents the actual number of elements in the list at all times.
 *
 * @author Bohdan Hnatiuk
 *
 * @param <T> the type of elements in this list.
 */
public abstract class MyAbstractList<T> implements Iterable<T> {
    /**
     * The number of all accessible elements in the list.
     *
     * @implNote Implementing classes shouldn't define their own size field.
     * They must use this field and manage it such way, that it will
     * contain the actual number of element that are currently in the list.
     */
    protected int size;

    /**
     * Gets the element from the specified position in the list.
     *
     * @param index The index of the element (required position) to get from the list starting from 0
     * @return The element from the list from the required position.
     * @throws IndexOutOfBoundsException If the index is lower than 0, greater or equal the size.
     *
     * @implNote The implementation should return the element with {@code <T>} type,
     * not the container, used to store the objects.
     */
    public abstract T get(int index) throws IndexOutOfBoundsException;

    /**
     * Gets the first element of the list if it isn't empty.
     *
     * @return The first element of the list (index: 0).
     * @throws NoSuchElementException if the list is empty.
     */
    public T getFirst() {
        if (size == 0)
            throw new NoSuchElementException("List is empty");
        return get(0);
    }

    /**
     * Gets the last element of the list if it isn't empty.
     *
     * @return The first element of the list (index size: - 1).
     * @throws NoSuchElementException if the list is empty.
     */
    public T getLast() {
        if (size == 0)
            throw new NoSuchElementException("List is empty");
        return get(size - 1);
    }

    /**
     * Adds the element to the end of the list (index: size).
     *
     * @param object The object to be added to the list.
     */
    public void add(T object) {
        add(object, size);
    }

    /**
     * Adds the element to the specified position in the list.
     *
     * @param object The object for adding to the list.
     * @param index The position where to add or insert the element.
     * @throws IndexOutOfBoundsException If the index is lower than 0 or greater than size.
     *
     * @implNote Implementation should increase the size of inner array when needed if using it.
     */
    public abstract void add(T object, int index) throws IndexOutOfBoundsException;

    /**
     * Replaces the element in the specified position.
     *
     * @param object The object for replacing the element.
     * @param index The position of the replacement.
     * @throws IndexOutOfBoundsException If the index is lower than 0, greater or equal the size.
     *
     * @implNote The implemented method can't add the elements if index = size.
     */
    public abstract void replace(T object, int index) throws IndexOutOfBoundsException;

    /**
     * Removes the element from the specified position.
     *
     * @param index The position of the element to remove.
     * @throws IndexOutOfBoundsException If the index is lower than 0, greater or equal the size.
     *
     * @implNote Implemented method should maintain correct other elements order
     * and their shifting after removing of the element.
     */
    public abstract void remove(int index) throws IndexOutOfBoundsException;

    /**
     * Checks if the list contains provided element.
     * <p>Correctness of execution of the method depends on correctness of the {@link Iterable} implementation </p>
     *
     * @param object The object to be checked for containment in the list.
     * @return {@code true} if object found, otherwise {@code false}
     */
    public boolean contains(T object) {
        for (T arrElement : this)
            if (object.equals(arrElement))
                return true;
        return false;
    }

    /**
     * Empties the list.
     *
     * @implNote Implementation shouldn't strictly delete all the elements,
     * as long as it doesn't provide access to them.
     */
    public abstract void clear();

    /**
     * Gets the size of the list (number of all it's accessible elements).
     *
     * @return The value of the size field.
     */
    public int size() {
        return size;
    }

    /**
     * Shows if the list has any content.
     *
     * @return {@code true} if the size is 0, otherwise {@code false}
     */
    public boolean isEmpty() {
        return this.size() == 0;
    }
}
