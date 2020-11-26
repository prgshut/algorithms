package lesson3.stak;

public class Stak {

    private char[] data;
    private int size;
    public Stak(int capacity){
        data= new char[capacity];
    }

    public void add(char d){
        if (!isFull())
        data[size++]=d;
    }
    public char take(){
             return data[--size];
    }
    public boolean isFull(){
        return size==data.length;
    }

    public boolean isEmpty(){
        return size==0;
    }

}
