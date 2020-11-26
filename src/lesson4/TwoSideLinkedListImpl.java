package lesson4;

public class TwoSideLinkedListImpl<E> extends SimpleLinkedListImpl<E> implements TwoSideLinkedList<E> {
    private Node<E> lastElement;

    @Override
    public E removeFirst() {
        E removedData = super.removeFirst();
        if (isEmpty()) {
            lastElement = null;
        }
        return removedData;
    }

    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);
        if (size() == 1) {
            lastElement = firstElement;
        }
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = firstElement;
        Node<E> previous = null;
        while (current != null) {
            if (value.equals(current.item)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (size() == 1) {
            return removeFirst() != null;
        }

        if (current == firstElement) {
            firstElement = firstElement.next;
        } else if (current == lastElement) {
            lastElement = previous;
            previous.next = null;
        } else {
            previous.next = current.next;
        }
        current.next = null;
        current.item = null;
        size--;

        return true;
    }

    @Override
    public void insertLast(E value) {
        Node<E> newNode = new Node<>(value, null);
        if (isEmpty()) {
            firstElement = newNode;
        } else {
            lastElement.next = newNode;
        }
        lastElement = newNode;
    }
}
