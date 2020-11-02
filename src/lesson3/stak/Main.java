package lesson3.stak;

public class Main {
    public static void main(String[] args) {
        String str = "adcd";
        Stak stak = new Stak(str.length());
        for (int i = 0; i < str.length(); i++) {
            stak.add(str.charAt(i));
        }
        while (!stak.isEmpty()){
            System.out.print(stak.take());
        }
    }


}
