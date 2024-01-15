package Logic.service.api;

import models.Card;

public interface ATMService {
    Card registerNewCard();
    boolean authenticateCard(String cardNumber, int password);

}
