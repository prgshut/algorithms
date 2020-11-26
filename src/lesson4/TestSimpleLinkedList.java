package lesson4;

import java.util.Iterator;

public class TestSimpleLinkedList {
    public static void main(String[] args) {
       SimpleLinkedListImpl<Integer> linkedList = makeTestLinkedListAndFill();
        testForEach(linkedList);
        testIterator(linkedList);
        testLinkIterator(linkedList);
    }

    private static void testLinkIterator(SimpleLinkedListImpl<Integer> linkedList) {
        LinkIterator<Integer> linkIterator = linkedList.getIterator();
        while (!linkIterator.atEnd()) {

            if (linkIterator.getCurrent().item.equals(3)) {
                //linkIterator.deleteCurrent();
                //linkIterator.insertBefore(10);
                linkIterator.insertAfter(15);
                break;
            }
            linkIterator.nextElement();
        }

        System.out.println("_______test LinkIterator start______");
        for (Integer integer : linkedList) {
            System.out.println(integer);
        }
        System.out.println("_______test LinkIterator end______");

    }

    private static SimpleLinkedListImpl<Integer> makeTestLinkedListAndFill() {
       SimpleLinkedListImpl<Integer> linkedList = new SimpleLinkedListImpl<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertFirst(6);
        return linkedList;
    }

    private static void testForEach(SimpleLinkedListImpl<Integer> linkedList) {
        System.out.println("_______test ForEach start______");
        for (Integer integer : linkedList) {
            System.out.println(integer);
        }
        System.out.println(linkedList.size() + " длина листа");
        System.out.println("_______test ForEach end______");
    }

    private static void testIterator(SimpleLinkedListImpl<Integer> linkedList) {
        System.out.println("_______test iterator start______");
        Iterator<Integer> iter = linkedList.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.out.println("_______test iterator end______");
    }
}
