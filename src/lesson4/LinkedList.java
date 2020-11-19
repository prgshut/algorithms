package lesson4;

public interface LinkedList<E> {
    /**
     * add element to beginning of list
     * @param value
     */
    void insertFirst(E value);

    /**
     *
     * @return element from the beginning of list and remove it
     */
    E removeFirst();

    /**
     *
     * @param value
     * @return
     */
    boolean remove(E value);

    boolean contains(E value);

    int size();

    boolean isEmpty();

    void display();

    E getFirst();


    class Node<E>{
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}
