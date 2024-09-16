package dev.bernilai;

import dev.bernilai.types.TrainingIntensity;

public class Gallons {

    public static void main(String[] args) {

        System.out.println("N1: " + GallonsToLiters(5) + " liters");
        System.out.println("N2: " + fitCalc(15, TrainingIntensity.HIGH) + " calories");
        System.out.println("N3: " + containers(10, 3, 11) + " products");
        System.out.println("N4: " + triangleType(15, 10, 15));
        System.out.println("N5: " + ternaryEvaluation(20, 17));
        System.out.println("N6: " + howManyItems(25, 1.3, 2.2) + " items");
        System.out.println("N7: " + factorial(8));
        System.out.println("N8: " + gcd(35, 42));
        System.out.println("N9: " + ticketSaler(45, 4200) + " currency");
        System.out.println("N10: " + tables(55, 22) + " places");

    }

    // 1
    public static double GallonsToLiters(double gallons) {
        return gallons * 3.785;
    }

    // 2
    public static int fitCalc(
            int time,
            TrainingIntensity intensity
    ) {
        return time * intensity.getValue();
    }

    // 3
    public static int containers (
            int boxesAmount,
            int bagsAmount,
            int barrelsAmount
    ) {

        final int boxCapacity = boxesAmount * 20;
        final int bagCapacity = bagsAmount * 50;
        final int barrelCapacity = barrelsAmount * 100;

        return boxCapacity * boxesAmount + bagCapacity * bagsAmount + barrelCapacity * barrelsAmount;
    }

    // 4
    public static String triangleType (
            int a,
            int b,
            int c
    ) {

        if (a + b < c || a + c < b || b + c < a) {
            return "Not a triangle";
        }

        if (a == b && b == c) {
            return "equilateral";
        } else if (a == b || a == c || b == c) {
            return "isosceles";
        } else {
            return "scalene";
        }

    }

    //5
    public static int ternaryEvaluation (
            int a,
            int b
    ) {

        return a > b ? a : b;
    }

    // 6
    public static int howManyItems (
            int length,
            double widthOfItem,
            double heightOfItem
    ) {

        double areaOfItem = widthOfItem * heightOfItem * 2;
        double areaOfCloth = length * 2;

        return (int) (areaOfCloth / areaOfItem);
    }

    // 7
    public static int factorial (int n) {

        return n == 0 ? 1 : n * factorial(n-1);
    }

    //8
    public static int gcd (
            int a,
            int b
    ) {

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    //9
    public static int ticketSaler (
            int numberOfTickets,
            int pricePerTicket
    ) {

        final double commission = 0.28;

        return (int) (numberOfTickets * pricePerTicket * (1 - commission));
    }

    //10
    public static int tables (
            int students,
            int desks
    ) {

        final int places = desks * 2;

        return students > places ? students - places : students;
    }
}
