package Logic.service;

import Logic.Utils;
import models.Card;
import Logic.service.api.ATMService;
import ui.Menu;

public class ATMServiceImp implements ATMService {

    @Override
    public Card registerNewCard() {
        int amount = 0;

        String cardNumber = Utils.generateCardNumber();
        int password = Utils.generatePinNumber();

        Card regCard = new Card(cardNumber, password, amount);

        Menu.bank.getRegisteredCard().add(regCard);
        SerializationService.serialization(Menu.bank);
        return regCard;
    }

    @Override
    public boolean authenticateCard(String cardNumber, int password) {
        for (Card el : Menu.bank.getRegisteredCard()) {
            if (el.getCardNumber().equals(cardNumber) && el.getPassword() == password) {
                return true;
            }
        }
        return false;
    }
}
