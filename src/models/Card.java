package models;

import java.io.Serializable;

public class Card implements Serializable {
    private String cardNumber;
    private int password;
    private int amount;

    public Card(String cardNumber, int password, int amount) {
        this.cardNumber = cardNumber;
        this.password = password;
        this.amount = amount;
    }

    public Card() {
        this.cardNumber = "";
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
