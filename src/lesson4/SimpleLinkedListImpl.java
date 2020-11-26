package lesson4;

import java.util.Iterator;

public class SimpleLinkedListImpl<E> implements LinkedList<E>, Iterable<E> {
    protected int size;
    protected Node<E> firstElement;

    @Override
    public void insertFirst(E value) {
        Node<E> newNode = new Node<>(value, firstElement);
        firstElement = newNode;
        size++;
    }

    @Override
    public E removeFirst() {
        if(isEmpty()){
            return null;
        }
        Node<E> removedElement = firstElement;
        E data = removedElement.item;
        firstElement = firstElement.next;
        removedElement.next = null;
        removedElement.item = null;

        size--;
        return  data;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = firstElement;
        Node<E> previous = null;
        while (current != null){
            if(value.equals(current.item)){
                break;
            }
            previous = current;
            current = current.next;
        }

        if(current == null){
            return false;
        }
        if(current == firstElement){
            firstElement = firstElement.next;
        }else {
            previous.next = current.next;
        }
        current.next = null;
        current.item = null;
        size--;

        return true;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = firstElement;
        while (current != null){
            if(value.equals(current.item)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void display() {
        System.out.println("****");
        Node<E> current = firstElement;
        while (current != null){
            System.out.println(current.item);
            current = current.next;
        }
        System.out.println("****");
    }

    @Override
    public E getFirst() {
        return firstElement.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new SimpleLinkedListIterator<>(this);
    }


    public LinkIterator<E> getIterator(){
        return new LinkIterator<>(this);
    }
}
