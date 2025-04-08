package com.shpp.p2p.cs.bhnatiuk.dataStructures.myLinkedList;

import com.shpp.p2p.cs.bhnatiuk.dataStructures.myAbstractList.MyAbstractList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The {@code MyLinkedList} class that completes {@link MyAbstractList} functionality and provides its own.
 *
 * <p>It uses {@link MyListNode} with links to next and previous nodes as internal storage.</p>
 *
 * @author Bohdan Hnatiuk
 *
 * @param <T> the type of elements in this list.
 */
public class MyLinkedList<T> extends MyAbstractList<T> {
    /**
     * The first node of the list
     */
    private MyListNode<T> head;

    /**
     * The last node of the list
     */
    private MyListNode<T> tail;

    /**
     * Default constructor that crates empty {@code MyLinkedList}.
     */
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Init array constructor that crates {@code MyLinkedList} with the content of the init array.
     *
     * @param initArray The array with elements to be added to the {@code MyLinkedList}.
     */
    public MyLinkedList(T[] initArray) {
        head = null;
        tail = null;
        size = 0;

        for (T object : initArray)
            this.add(object);
    }

    /**
     * {@inheritDoc}
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);

        return getNode(index).getValue();
    }

    /**
     * Gets the required objects {@link MyListNode} container.
     *
     * @param index Position of the required object.
     * @return The {@link MyListNode} container of the required object.
     * @throws IndexOutOfBoundsException If the index is lower than 0, greater or equal the size.
     */
    public MyListNode<T> getNode(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);

        MyListNode<T> current = head;
        for (int i = 0; i < index; i++)
            current = current.getNext();
        return current;
    }

    /**
     * {@inheritDoc}
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public void add(T object, int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);

        if (size == 0) {
            addFirstEmptyList(object);
        } else if (index == 0) {
            addFirst(object);
        } else if (index == size) {
            addLast(object);
        } else {
            MyListNode<T> current = getNode(index);
            MyListNode<T> prev = current.getPrev();
            MyListNode<T> insertedNode = new MyListNode<>(object);

            insertedNode.setDependencies(prev, current);
            size++;
        }
    }

    /**
     * Initializes the first element of the list by assigning it to both
     * {@code head} and {@code tail} without setting any relations.
     *
     * <p>Doesn't check the conditions if there are any items in the list,
     * so execution must be handled externally</p>
     *
     * @param object The object to be set as value of the first node.
     */
    private void addFirstEmptyList(T object) {
        head = tail = new MyListNode<>(object);
        size++;
    }

    /**
     * Inserts the object in the beginning of the list (index: 0).
     *
     * @param object The object to be set as value of the inserted node.
     */
    public void addFirst(T object) {
        if (size == 0) {
            addFirstEmptyList(object);
            return;
        }

        MyListNode<T> next = head;
        head = new MyListNode<>(object);
        head.setNext(next);
        size++;
    }

    /**
     * Adds the object to the end of the list (index: size).
     *
     * @param object The object to be set as value of the added node.
     */
    public void addLast(T object) {
        if (size == 0) {
            addFirstEmptyList(object);
            return;
        }

        MyListNode<T> prev = tail;
        tail = new MyListNode<>(object);
        tail.setPrev(prev);
        size++;
    }

    /**
     * {@inheritDoc}
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public void replace(T object, int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);

        MyListNode<T> current = getNode(index);
        current.setValue(object);
    }

    /**
     * {@inheritDoc}
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public void remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);

        if (size == 1) {
            clear();
            return;
        }

        MyListNode<T> current = getNode(index);
        MyListNode<T> prev = current.getPrev();
        MyListNode<T> next = current.getNext();

        if (index == 0) {
            head = next;
            head.setPrev(null);
        } else {
            prev.setNext(next);
        }

        size--;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public MyListNode<T> getHead() {
        return head;
    }

    public MyListNode<T> getTail() {
        return tail;
    }

    /**
     * Implementation of the {@link Iterable} interface.
     *
     * @return The {@link Iterator} object.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            MyListNode<T> current = head;

            /**
             * Shows if the iterator processed all the elements from the list.
             *
             * @return {@code true} if the {@code iterator} has more elements, otherwise {@code false}
             */
            @Override
            public boolean hasNext() {
                return current != null;
            }

            /**
             * Returns the next element in the iteration and increases the iteration by 1.
             *
             * @return The next element in the list.
             * @throws IndexOutOfBoundsException If no more elements are available.
             */
            @Override
            public T next() {
                if (current == null)
                    throw new NoSuchElementException("No more elements in the iterator");

                MyListNode<T> temp = current;
                current = current.getNext();
                return temp.getValue();
            }
        };
    }
}
