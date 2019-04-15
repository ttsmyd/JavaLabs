package bank;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

public class CustomerGenerator extends Thread {
    private final Random random = new Random();
    private int countOfCustomers;
    private Bank bank;
    private int boundOfTime;


    CustomerGenerator(int countOfCustomers, Bank bank, int boundOfTime) {
        this.countOfCustomers =  countOfCustomers;
        this.bank = bank;
        this.boundOfTime = boundOfTime;
    }

    @Override
    public void run() {
        generateCustomers(countOfCustomers, bank, boundOfTime);
    }


    private void generateCustomers(int countOfCustomers, Bank bank, int boundsOfTime) {
        int clientId = 1;
        for (int i = 0; i < countOfCustomers; i ++) {
            Customer customer = new Customer();
            generatingDataForCustomer(customer, clientId);
            System.out.println("Customer " + customer.getId() + " was made. ID: " + customer.getId() +
                    ". Type of action:" + customer.getTypeOfAction() +
                    ". Sum Of Customer: " + customer.getSumOfCustomer() +
                    ". Time of Service: " + customer.getTimeOfService());
            bank.addCustomerToMinimalQueue(customer);
            clientId++;
            try {
                Thread.sleep(random.nextInt(boundsOfTime));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private void generatingDataForCustomer(Customer customer, int clientId) {
        customer.setId(clientId);

        //generating sum
        BigDecimal sumOfCustomer = new BigDecimal(BigInteger.valueOf(new Random().nextInt(100001)), 2);
        customer.setSumOfCustomer(sumOfCustomer);

        //generating typeOfAction
        TypeOfAction[] values = TypeOfAction.values();
        int length = values.length;
        customer.setTypeOfAction(values[random.nextInt(length)]);

        //generate time of service
        customer.setTimeOfService(random.nextInt(5001));
    }


    }
