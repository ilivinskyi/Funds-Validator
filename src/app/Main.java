package app;

import java.lang.module.FindException;
import java.util.Scanner;

public class Main {

    private static final double AVAILABLE_FUNDS = 1000.00;
    static double balance;

    public static void main(String[] args) {
        balance = getBalance();
        validateAmount(balance, getAmount());
    }

    private static double getBalance() {
        return AVAILABLE_FUNDS;
    }

    private static double getAmount() {
        System.out.printf("Balance is USD %.2f.%n" +
                "Enter purchase amount, USD: ", balance);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    private static void validateAmount(double balance, double withdrawal) {
        try {
            if (withdrawal > balance) {
                throw new FindException("Insufficient funds!");
            } else {
                balance = getBalance(balance, withdrawal);
                System.out.printf("Funds are OK. Purchase paid." +
                        "%nBalance is USD %.2f", balance);
            }
        } catch (FindException e) {
            System.out.println(e.getMessage());
        }
    }

    private static double getBalance(double balance, double withdrawal){
        return balance - withdrawal;
    }
}