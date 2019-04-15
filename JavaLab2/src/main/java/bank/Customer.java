package bank;

import java.math.BigDecimal;
import java.util.Random;

public class Customer {
    private int id;
    private BigDecimal sumOfCustomer;
    private TypeOfAction typeOfAction;
    private int timeOfService;
    private Bank bank;


    public Customer() {
    }

    public boolean getDecisionToRetryQuery() {
        Random random = new Random();
        boolean desicion = random.nextBoolean();
        return desicion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getSumOfCustomer() {
        return sumOfCustomer;
    }

    public void setSumOfCustomer(BigDecimal sumOfCustomer) {
        this.sumOfCustomer = sumOfCustomer;
    }

    public TypeOfAction getTypeOfAction() {
        return typeOfAction;
    }

    public void setTypeOfAction(TypeOfAction typeOfAction) {
        this.typeOfAction = typeOfAction;
    }

    public long getTimeOfService() {
        return timeOfService;
    }

    public void setTimeOfService(int timeOfService) {
        this.timeOfService = timeOfService;
    }
}
