package prac23;

public class LinkedQueue extends AbstractQueue implements Queue {
    private static class Node {
        Object value;
        Node next;

        Node(Object value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;


    @Override
    public void enqueue(Object element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
        Node node = new Node(element);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }


    @Override
    public Object element() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return head.value;
    }


    @Override
    public Object dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        Object result = head.value;
        head = head.next;
        size--;
        if (size == 0) {
            tail = null;
        }
        return result;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
}
