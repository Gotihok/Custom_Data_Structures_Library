package com.shpp.p2p.cs.bhnatiuk.dataStructures.myLinkedList;

/**
 * Class used in {@link MyLinkedList} as data container.
 *
 * @author Bohdan Hnatiuk
 *
 * @param <T> the type of elements in this list.
 */
public class MyListNode<T> {
    /**
     * The {@code value} field contains the object of the generic type that is the element of the list.
     */
    private T value;

    /**
     * Link to previous node
     */
    private MyListNode<T> prev;

    /**
     * Link to the next node
     */
    private MyListNode<T> next;

    /**
     * Default {@code MyListNode} constructor that makes a node with defined value and no relations.
     *
     * @param value The object to be assigned as internal value of the node.
     */
    public MyListNode(T value) {
        this(value, null, null);
    }

    /**
     * Default {@code MyListNode} constructor that makes a node with defined value and defined relations.
     *
     * @param value The object to be assigned as internal value of the node.
     * @param prev The node to make link as previous for the current node.
     * @param next The node to make link as next for the current node.
     */
    public MyListNode(T value, MyListNode<T> prev, MyListNode<T> next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    /**
     * Shows if there is assigned next node.
     * @return {@code true} if the next node isn't {@code null}.
     */
    public boolean hasNext() {
        return next != null;
    }

    /**
     * Shows if there is assigned previous node.
     * @return {@code true} if the previous node isn't {@code null}.
     */
    public boolean hasPrev() {
        return prev != null;
    }

    /**
     * Gets the next node.
     */
    public MyListNode<T> getNext() {
        return next;
    }

    /**
     * Gets the previous node.
     */
    public MyListNode<T> getPrev() {
        return prev;
    }

    /**
     * Links current node to the next node. Also, creates the link to this node in the next.
     * @param next The node to be linked as next.
     */
    public void setNext(MyListNode<T> next) {
        this.next = next;
        if (next != null)
            next.prev = this;
    }

    /**
     * Links current node to the previous node. Also, creates the link to this node in the previous.
     * @param prev The node to be linked as previous.
     */
    public void setPrev(MyListNode<T> prev) {
        this.prev = prev;
        if (prev != null)
            prev.next = this;
    }

    /**
     * Links current node to both next and previous nodes and creates the link to this node in them.
     *
     * @param prev The node to be linked as previous.
     * @param next The node to be linked as next.
     */
    public void setDependencies(MyListNode<T> prev, MyListNode<T> next) {
        setPrev(prev);
        setNext(next);
    }

    /**
     * Changes the value of the current node.
     * @param value New value.
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * Gets the value of the current node.
     */
    public T getValue() {
        return value;
    }
}