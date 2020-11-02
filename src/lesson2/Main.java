package lesson2;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        int capacity = 100*1000;
        MyArray arr1=new MyArray(capacity);
        MyArray arr2=new MyArray(capacity);
        MyArray arr3=new MyArray(capacity);

        for (int i=0;i<capacity;i++){
            int randomNum = ThreadLocalRandom.current().nextInt(-100*1000, 100*1000);
            arr1.add(randomNum);
            arr2.add(randomNum);
            arr3.add(randomNum);
        }
        System.out.println("Начало сортировки");
        long startTime = System.currentTimeMillis();
        arr1.sortBubble();
        long endTime=System.currentTimeMillis();
        System.out.println("Пузырек "+(endTime-startTime) +" ms");
        startTime = System.currentTimeMillis();
        arr2.sortSelect();
        endTime=System.currentTimeMillis();
        System.out.println("Выборка "+(endTime-startTime) +" ms");
        startTime = System.currentTimeMillis();
        arr2.sortInsert();
        endTime=System.currentTimeMillis();
        System.out.println("Вставкой "+(endTime-startTime) +" ms");
    }
}
