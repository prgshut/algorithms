package lesson3.dek;

public class Dek {
    private int[] data;
    private int head;
    private int tail;
    private int cent;

    public Dek(int capcity){
        data=new int[capcity];
        head=capcity/2;
        tail=capcity-head;
        cent=head;
    }

    public void addHead(int d){
        data[head++]=d;
    }
    public int taikHead(){
        return data[--head];
    }

    public void addTail(int d){
        data[tail--]=d;
    }
    public int taikTail(){
        return data[++tail];
    }
    public boolean isFullHead(){
        return head==data.length;
    }
    public boolean isFullTail(){
        return tail==0;
    }
    public boolean isEmptyHead(){
        return head==cent;
    }
    public boolean isEmptyTail(){
        return tail==cent;
    }
}
