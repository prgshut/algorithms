package lesson6;

public class TestUpToThePower {

    public static double getPower(double base, int power) {
        if (power == 0 && base == 0.0) throw new IllegalArgumentException("Zero to the zero is indeterminately");
        if (base == 0.0 && power < 0) throw new IllegalArgumentException("divide by zero");
        if (power == 0 && base != 0.0) {
            return 1.0;
        } else if(power > 0){
            return base * getPower(base, power - 1);
        } else {
            return 1/(getPower(base, Math.abs(power)));
        }

    }
    public static int getPositivePower(int base, int power) {
        if (power == 0 && base == 0) throw new IllegalArgumentException("Zero to the zero is indeterminately");
        if (power < 0) throw new IllegalArgumentException("power is negative");

        if (power == 0) {
            return 1;
        } else {
            return base * getPositivePower(base, power - 1);
        }

    }

    public static void main(String[] args) {
        System.out.println(getPower(5.0, 0));
        System.out.println(getPower(-5.0, 3));
        System.out.println(getPower(5.0, -4));
        System.out.println(getPositivePower(5, 4));

    }
}
