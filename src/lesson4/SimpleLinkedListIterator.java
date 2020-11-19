package lesson4;

import java.util.Iterator;

public class SimpleLinkedListIterator<E> implements Iterator<E> {
    private LinkedList.Node<E> current;
    private final SimpleLinkedListImpl<E> collection;
    private int currentIndex;

    public SimpleLinkedListIterator(SimpleLinkedListImpl<E> collection) {
        this.collection = collection;
        this.current = collection.firstElement;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        if(collection.size() == 0) {
            return false;
        }
        if(currentIndex > collection.size() - 1){
            return false;
        }
        return true;
    }

    @Override
    public E next() {
        E returnedValue = current.item;
        current = current.next;
        currentIndex++;
        return returnedValue;
    }
}
