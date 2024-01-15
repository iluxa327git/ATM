package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Bank implements Serializable{
    public List<Card> registeredCard;

    public List<Transaction> saveTransaction;

    public Bank(List<Card> registeredCard, List<Transaction> saveTransaction) {
        this.registeredCard = registeredCard;
        this.saveTransaction = saveTransaction;
    }

    public Bank() {
        this.registeredCard = new ArrayList<>();
        this.saveTransaction = new ArrayList<>();
    }

    public List<Card> getRegisteredCard() {
        return registeredCard;
    }

    public void setRegisteredCard(List<Card> registeredCard) {
        this.registeredCard = registeredCard;
    }

    public List<Transaction> getSaveTransaction() {
        return saveTransaction;
    }
}
