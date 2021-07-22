package com.ghostfacedlabs;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter cost of item: ");
            String costGiven = scanner.nextLine();
            System.out.print("Enter the amount given: ");
            String amountGiven = scanner.nextLine();
            double cost;
            double amount;

            try {
                cost = Double.parseDouble(costGiven);
                amount = Double.parseDouble(amountGiven);

            } catch (NumberFormatException n) {
                System.out.println("User entered invalid values" + n.getMessage());
                continue;
            }

            getChange(cost, amount);
            break;
        }

    }

    public static void getChange(double cost, double amount) {
        double change = round((amount - cost), 2);
        int dollars = (int) change;
        double cents = round((change - dollars), 2) * 100;

        System.out.println("Change given: " + change);
        System.out.println("Dollars: " + dollars);
        System.out.println("Quarters: " + (int) (cents / 25));
        System.out.println("Dimes: " + (int) (cents % 25) / 10);
        System.out.println("Nickels: " + (int) ((cents % 25) % 10) / 5);
        System.out.println("Pennies: " + (int) ((cents % 25) % 10) % 5);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
