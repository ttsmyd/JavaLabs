package bank;

import sun.misc.ClassFileTransformer;

import java.math.BigDecimal;

public class Cashbox {
    private static BigDecimal amountOfCash = new BigDecimal("0.0");

    public Cashbox() {
    }

    synchronized public boolean getCash(BigDecimal sizeOfClientCash) {
        if (amountOfCash.subtract(sizeOfClientCash).compareTo(BigDecimal.ZERO) >= 0) {
            Cashbox.amountOfCash =  Cashbox.amountOfCash.subtract(sizeOfClientCash);
            System.out.println("Cashbox was decreased: -" + sizeOfClientCash + ". Cashbox: " + Cashbox.amountOfCash);
            return true;
        } else {
            return false;
        }
    }

    synchronized public void addCash(BigDecimal sizeOfClientCash) {
        Cashbox.amountOfCash = Cashbox.amountOfCash.add(sizeOfClientCash);
        System.out.println("Cashbox was increased: +" + sizeOfClientCash +". Cashbox: " + Cashbox.amountOfCash);
    }


}
