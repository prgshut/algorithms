package lesson8;

public class HashTableImpl<K, V> implements HashTable<K, V> {

    private final int maxSize;

    static class Node<K, V> implements Entry<K, V> {

        private final K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next=null;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }


    private final Node<K, V>[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTableImpl(int maxSize) {
        this.maxSize = maxSize;
        this.data = new Node[this.maxSize * 2];
    }

    @Override
    public boolean put(K key, V value) {
        int index = hash(key);

        if (size == maxSize) {
            return false;
        }

        if (data[index] == null) {
            data[index] = new Node<>(key, value);
            size++;
            return true;
        }

        Node<K, V> node = data[index];
        while (node.getNext() != null) {
            if (node.getKey().equals(key)) {
                node.setValue(value);
                return true;
            }
            node = node.getNext();
        }
        node.setNext(new Node<>(key, value));
        size++;
        return true;
    }

    protected int getStep(K key) {
        return 1;
    }

    private int hash(K key) {
        return key.hashCode() % data.length;
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        if (data[index] == null) {
            return null;
        }
        Node<K, V> node = data[index];
        while (node != null && !node.getKey().equals(key)) {
            node = node.getNext();
        }
        if (node == null) {
            return null;
        }
        return node.getValue();
    }

    private int indexOf(K key) {
        int index = hash(key);
        while (data[index] != null) {
            Node<K, V> node = data[index];
            if (node.getKey().equals(key)) {
                return index;
            }
            index = index + getStep(key);
            index %= data.length;
        }

        return -1;
    }

    @Override
    public V remove(K key) {
        int index = hash(key);
        if (data[index] == null) {
            return null;
        }
        Node<K, V> current = data[index];
        Node<K, V> previous = null;
        while (current != null) {
            if (current.getKey().equals(key)) {
                if (previous == null) {
                    data[index] = current.getNext();
                    if (current.getNext() == null) {
                        size--;
                    }
                } else {
                    previous.setNext(current.getNext());
                    size--;
                }
                return current.getValue();
            }
            previous = current;
            current = current.getNext();
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println("----------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d = [%s]%n", i, data[i]);
        }
        System.out.println("----------");
    }
}
