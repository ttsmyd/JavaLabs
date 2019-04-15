package bank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Operator extends Thread {
    private int id;
    private Queue<Customer> queue;
    private Bank bank;

    Operator(int id, Bank bank) {
        this.id = id;
        this.queue = new LinkedList<Customer>();
        this.bank = bank;
    }

    public Queue<Customer> getQueue() {
        return queue;
    }

    public void setQueue(Queue<Customer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("Thread " + id + " was runned");
        Cashbox cashbox = new Cashbox();
        int countOfRequestToQueue = 0;
        while (!Thread.currentThread().isInterrupted()) {
        try {
        while (queue.isEmpty()) {
          put();
        }
        Customer customer = queue.element();
            Thread.sleep(customer.getTimeOfService());
        switch (customer.getTypeOfAction()) {
            case addAction:
                cashbox.addCash(customer.getSumOfCustomer());
                System.out.println("Customer " + customer.getId() + " successful add money: " + customer.getSumOfCustomer());
                queue.remove();
                break;
            case getAction:
                boolean responseFromBank = cashbox.getCash(customer.getSumOfCustomer());
                if (!responseFromBank) {
                    System.out.println("Customer " + customer.getId() + " failed for get money: " + customer.getSumOfCustomer());
                    if (customer.getDecisionToRetryQuery()) {
                        System.out.println("Customer " + customer.getId() + " want to retry later");
                        queue.remove();
                        bank.addCustomerToMinimalQueue(customer);
                    } else {
                        System.out.println("Customer " + customer.getId() + " don't want to retry and went from bank");
                        queue.remove();
                    }
                } else {
                    System.out.println("Customer " + customer.getId() + " successful get money: " + customer.getSumOfCustomer());
                    queue.remove();
                }
                break;
            default:
                System.out.println("NullException");
                break;
        }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        }
    }


    private synchronized void put(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void addCustomer(Customer customer) {
        queue.add(customer);
        System.out.println("Customer " + customer.getId() +
        " was added to queue of operator # " + id);
    }


}
