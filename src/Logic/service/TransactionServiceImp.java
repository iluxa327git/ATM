package Logic.service;

import Logic.service.api.TransactionService;
import models.Card;
import models.Transaction;
import ui.Menu;

import java.util.List;

public class TransactionServiceImp implements TransactionService  {
    @Override
    public boolean getTransaction(String toCardNumber, String fromCardNumber, int amount) {
        Transaction transaction = new Transaction(toCardNumber, fromCardNumber, amount);

        Menu.bank.getSaveTransaction().add(transaction);

        for(Card el : Menu.bank.getRegisteredCard())
            for (Card le : Menu.bank.getRegisteredCard())
                if (el.getCardNumber().equals(toCardNumber)){
                    if (le.getCardNumber().equals(fromCardNumber) && le.getAmount() >= el.getAmount()) {
                        el.setAmount(el.getAmount() + amount);
                        le.setAmount(le.getAmount() - amount);
                        SerializationService.serialization(Menu.bank);
                        return true;
                    }
                }
        return false;
    }

    public List<Transaction> getAllTransactions(){
        List<Transaction> trancsactions = SerializationService.deserialization().getSaveTransaction();
        trancsactions.forEach(x -> System.out.println(x));
        return trancsactions;
    }
}
