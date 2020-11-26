package lesson5;


import java.util.LinkedList;
import java.util.List;

public class BagTest {
    public final static int MAX_WEIGHT = 10;
    public final static List<Item> items;

    static{
        items = new LinkedList<>(){{
            add(new Item("a", 3, 300));
            add(new Item("b", 2, 1000));
            add(new Item("c", 1, 10));
            add(new Item("d", 2, 1500));
            add(new Item("e", 1, 900));
            add(new Item("f", 1, 2000));
            add(new Item("g", 1, 500));
            add(new Item("h", 5, 3000));
        }};
    }

    public static void main(String[] args) {

        Bag bag = new Bag(MAX_WEIGHT);
        bag.findBestSet(items);

        bag.printInfo();
    }
}
