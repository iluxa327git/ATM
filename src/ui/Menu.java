package ui;

import Logic.service.ATMServiceImp;
import Logic.service.CardServiceImp;
import Logic.service.SerializationService;
import Logic.service.TransactionServiceImp;
import models.Bank;
import models.Card;

import java.util.Scanner;

public class Menu {
    public static Bank bank;
    public static ATMServiceImp atmServiceImp = new ATMServiceImp();
    public static TransactionServiceImp transactionServiceImp = new TransactionServiceImp();
    public static CardServiceImp cardServiceImp = new CardServiceImp();
    private final static Scanner scanner = new Scanner(System.in);

    private static final String menu1 = """
            Что вы хотите сделать:
            1 Зарегетрировать карту
            2 Войти в аккаунт
            3 Просмотреть все транкзакции
            0 Выйти
            """;

    private static final String menu2 = """
            Что вы хотите сделать:
            1 Перевести деньги
            2 Снять деньги
            3 Положить деньги
            4 Получить информацию о карте
            0 Выйти
            """;

    public static void run(){
        if(SerializationService.deserialization() == null)
            bank = new Bank();
        else
            bank = SerializationService.deserialization();
        int a = -9;
        do{
            System.out.println(menu1);
            a = scanner.nextInt();
            switch (a){
                case 1:
                    Card newCard = atmServiceImp.registerNewCard();

                    System.out.println("Ваша новая карта: ");
                    System.out.println(newCard.getCardNumber());

                    System.out.println("Ваш пин-код: ");
                    System.out.println(newCard.getPassword());
                    break;

                case 2:
                    System.out.println("Введите номер карты: ");
                    String num = scanner.next();

                    System.out.println("Введите пин-код: ");
                    int pass = scanner.nextInt();

                    if(atmServiceImp.authenticateCard(num, pass)){
                        int b = -9;
                        do{
                            System.out.println(menu2);
                            b = scanner.nextInt();
                            switch (b){
                                case 1:
                                    System.out.println("Введите номер карты для перевода денег: ");
                                    String toNumber = scanner.next();

                                    System.out.println("Введите количество денег для перевода на эту карту: ");
                                    int amount = scanner.nextInt();

                                    if(transactionServiceImp.getTransaction(toNumber, num, amount))
                                        System.out.println("Операция проведена успешно");
                                    else
                                        System.out.println("Операция не проведена");
                                    break;
                                case 2:
                                    System.out.println("Какое кол-во денег вы хотите снять?");
                                    int getMoney = scanner.nextInt();

                                    cardServiceImp.getMoney(num, getMoney);
                                    break;
                                case 3:
                                    System.out.println("Какое кол-во денег вы хотите положить?");
                                    int addMoney = scanner.nextInt();

                                    cardServiceImp.addMoney(num, addMoney);
                                    break;
                                case 4:
                                    cardServiceImp.getCardInfo(num);
                            }

                        }while(b!=0);

                    }
                    else
                        System.out.println("Неверно введены данные");
                    break;

                case 3:
                    transactionServiceImp.getAllTransactions();


            }

        }while(a!=0);
    }
}
