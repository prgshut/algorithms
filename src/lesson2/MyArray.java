package lesson2;

public class MyArray {
    private int[] data;
    private int size;
//Написать методы удаления, добавления, поиска элемента массива.
    public MyArray(int capacity){
        data= new int[capacity];
    }

    public void add(int n){

        data[size]=n;
        size++;
    }
    public boolean remove(int position){
        if (position<size && position>=0) {
            for (int i=position; i<size; i++){
                data[i]=data[i+1];
            }
            size--;
                return true;
        }
        return false;
    }

    public int find(int n){
        for (int i = 0; i < size; i++) {
            if (data[i]==n)
                return i;
        }
        return -1;
    }

    void sortBubble(){
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1-i; j++) {
                if (data[j]>data[j+1]){
                    int tepm=data[j];
                    data[j]=data[j+1];
                    data[j+1]=tepm;
                }
            }
        }
    }

    public void sortSelect() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (data[j]<data[minIndex])  {
                    minIndex = j;
                }
            }
            int tepm=data[minIndex];
            data[minIndex]=data[i];
            data[i]=tepm;
        }
    }

    public void sortInsert() {
        for (int i = 1; i < size; i++) {
            int temp = data[i];
            int in = i;
            while (in > 0 && data[in - 1]>= temp) {
                data[in] = data[in - 1];
                in--;
            }
            data[in] = temp;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(data[i]);
            sb.append(", ");
        }
        if (size > 0) {
            sb.append(data[size - 1]);
        }
        sb.append("]");
        return sb.toString();
    }
}
