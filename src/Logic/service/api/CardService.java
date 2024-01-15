package Logic.service.api;

public interface CardService {
    void addMoney(String CardNumber, int moneyAdd);
    void getMoney(String CardNumber, int moneyGet);
    void getCardInfo(String CardNumber);
}
