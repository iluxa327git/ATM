package models;

import java.io.Serializable;

public class Transaction implements Serializable {
    public String fromCardNumber;
    public String toCardNumber;
    public int amount;

    public Transaction(String fromCardNumber, String toCardNumber, int amount) {
        this.fromCardNumber = fromCardNumber;
        this.toCardNumber = toCardNumber;
        this.amount = amount;
    }

    public Transaction() {
        this.fromCardNumber = "";
        this.toCardNumber = "";
    }

    public String getFromCardNumber() {
        return fromCardNumber;
    }

    public void setFromCardNumber(String fromCardNumber) {
        this.fromCardNumber = fromCardNumber;
    }

    public String getToCardNumber() {
        return toCardNumber;
    }

    public void setToCardNumber(String toCardNumber) {
        this.toCardNumber = toCardNumber;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "fromCardNumber='" + fromCardNumber + '\'' +
                ", toCardNumber='" + toCardNumber + '\'' +
                ", amount=" + amount +
                '}';
    }
}
