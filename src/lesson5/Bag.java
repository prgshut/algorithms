package lesson5;

import java.util.LinkedList;
import java.util.List;

public class Bag {
    private List<Item> bestItems = null;
    private int bestPrice;
    private int maxWeight;

    public Bag(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public List<Item> getBestItems() {
        return bestItems;
    }

    public int getBestPrice() {
        return bestPrice;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    private void checkItems(List<Item> items) {
        if (bestItems == null) {
            if (calcWeight(items) <= maxWeight) {
                bestItems = List.copyOf(items);
                bestPrice = calcPrice(bestItems);
            }
        } else {
            if (calcWeight(items) <= maxWeight && calcPrice(items) > bestPrice) {
                bestItems = List.copyOf(items);
                bestPrice = calcPrice(bestItems);
            }
        }
    }

    public void findBestSet(List<Item> items) {
        if (items.size() == 0) {
            return;
        } else {
            checkItems(items);
            for (Item item : items) {
                List<Item> newSet = new LinkedList<>(List.copyOf(items));
                newSet.remove(item);
                findBestSet(newSet);
            }
        }
    }

    public int calcWeight(List<Item> items) {
        return items.stream().map(Item::getWeight).reduce(Integer::sum).get();
    }

    public int calcPrice(List<Item> items) {
        return items.stream().map(Item::getPrice).reduce(Integer::sum).get();
    }


    public void printInfo(){
        System.out.println("Bag info");
        System.out.println("Стоимость " + this.calcPrice(bestItems));
        System.out.println("Вес " + this.calcWeight(bestItems));
        for (Item bestItem : bestItems) {
            System.out.println(bestItem.info());
        }
    }


}