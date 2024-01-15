package Logic.service;

import models.Card;
import Logic.service.api.CardService;
import ui.Menu;

public class CardServiceImp implements CardService {
    @Override
    public void addMoney(String CardNumber, int moneyAdd) {
        for (Card el : Menu.bank.getRegisteredCard()){
            if (el.getCardNumber().equals(CardNumber)){
                el.setAmount(el.getAmount()+moneyAdd);
                System.out.println("Операция проведена успешно");
            }
        }
    }

    @Override
    public void getMoney(String CardNumber, int moneyGet) {
        for(Card el : Menu.bank.getRegisteredCard()){
            if (el.getCardNumber().equals(CardNumber) && el.getAmount() >= moneyGet) {
                el.setAmount(el.getAmount()-moneyGet);
                System.out.println("Операция проведена успешно");
            }
            else
                System.out.println("Недостаточно средств");
        }
    }

    @Override
    public void getCardInfo(String CardNumber) {
        for(Card el : Menu.bank.getRegisteredCard()){
            if (el.getCardNumber().equals(CardNumber)) {
                System.out.println(el.getAmount());
            }
        }
    }
}
