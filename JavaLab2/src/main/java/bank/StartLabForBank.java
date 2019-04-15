package bank;

import java.math.BigDecimal;

public class StartLabForBank {
    public static void main(String[] args) {
        int countOfCustomers = 50;
        int countOfOperators = 3;
        int boundsOfTimeForMakingCustomers = 2000;
        BigDecimal amountOfCash = new BigDecimal("1000.00");

        Cashbox cashbox = new Cashbox();
        cashbox.addCash(amountOfCash);

        Bank bank = new Bank();
        CustomerGenerator customerGenerator = new CustomerGenerator(countOfCustomers, bank, boundsOfTimeForMakingCustomers);
        bank.generateQueuesAndOperators(countOfOperators);

        customerGenerator.start();
        bank.generateThreads(countOfOperators);

        try {
            customerGenerator.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bank.stopServicing();

        System.out.println("After all in main method");

    }
}
