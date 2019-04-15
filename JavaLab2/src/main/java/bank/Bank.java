package bank;

import java.util.*;

public class Bank {
    Map<Integer, Operator> queuesForServiceOperators = new HashMap<Integer, Operator>();
    Map<Integer, Thread> queuesForServiceThreads = new HashMap<Integer, Thread>();

    public void generateQueuesAndOperators(int countOfOperators) {
        for (int id = 0; id < countOfOperators; id++) {
            Operator operator = new Operator(id, this);
            queuesForServiceOperators.put(id, operator);
            }
        }

    public void generateThreads(int countOfOperators) {
        for (int i = 0; i < countOfOperators; i++) {
            queuesForServiceThreads.put(i, queuesForServiceOperators.get(i));
            queuesForServiceOperators.get(i).start();
        }
    }

    public void stopServicing() {
        boolean isEmptyThreads = false;
        do {
            for (int i = 0; i < queuesForServiceOperators.size(); i++) {
                if ((queuesForServiceOperators.get(i).getQueue().isEmpty())) {
                    isEmptyThreads = true;
                } else {
                    isEmptyThreads = false;
                    break;
                }
            }
        } while (!isEmptyThreads);
            if (isEmptyThreads) {
        for (int i = 0; i < queuesForServiceThreads.size(); i++) {
            queuesForServiceThreads.get(i).interrupt();
        }
            }


    }

    public void addCustomerToMinimalQueue(Customer customer) {
        int indexOfMinimalQueue = 0;
        for (int i = 1; i < queuesForServiceOperators.size(); i++) {
            if (queuesForServiceOperators.get(i).getQueue().size() < queuesForServiceOperators.get(i - 1).getQueue().size()) {
                indexOfMinimalQueue = i;
            }
        }
        queuesForServiceOperators.get(indexOfMinimalQueue).addCustomer(customer);
    }
    }
