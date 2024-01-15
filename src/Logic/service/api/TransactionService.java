package Logic.service.api;

import models.Transaction;

import java.util.List;

public interface TransactionService {
    boolean getTransaction(String toCardNumber, String fromCardNumber, int amount);
    List<Transaction> getAllTransactions();

}
