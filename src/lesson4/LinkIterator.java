package lesson4;

public class LinkIterator<E> {
    private LinkedList.Node<E> current;
    private LinkedList.Node<E> previous;
    private SimpleLinkedListImpl<E> collection;

    public LinkIterator(SimpleLinkedListImpl<E> collection) {
        this.collection = collection;
        this.reset();
    }

    public void reset(){
        current = collection.firstElement;
        previous = null;
    }

    public boolean atEnd(){
        return current.next == null;
    }

    public void nextElement(){
        previous = current;
        current = current.next;
    }

    public LinkedList.Node<E> getCurrent(){
        return current;
    }

    public void insertAfter(E value){
        LinkedList.Node<E> newElement = new LinkedList.Node<>(value,null);
        if (collection.isEmpty()){
            collection.firstElement = newElement;
            current = collection.firstElement;
        } else {
            newElement.next = current.next;
            current.next = newElement;
            nextElement();
        }
        collection.size++;
    }

    public void insertBefore(E value){
        LinkedList.Node<E> newElement = new LinkedList.Node<>(value, null);

        if(previous == null){
            newElement.next = collection.firstElement;
            collection.firstElement = newElement;
            reset();
        }
        else{
            newElement.next = previous.next;
            previous.next = newElement;
            current = newElement;
        }
        collection.size++;
    }

    public E deleteCurrent(){
        E value = current.item;
        if (previous == null){
            collection.firstElement = current.next;
            reset();
        } else {
            previous.next = current.next;
            if (atEnd()){
                reset();
            } else {
                current = current.next;
            }
        }
        collection.size--;
        return value;
    }


}
