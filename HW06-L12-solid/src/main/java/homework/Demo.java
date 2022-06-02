package homework;

import homework.api.services.ATMService;
import homework.domain.ATM;
import homework.domain.Banknote;
import homework.domain.ClassicATM;
import homework.exceptions.BanknotesAcceptingException;
import homework.exceptions.NoSuchSumException;
import homework.services.ATMServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        ATM atm = new ClassicATM();
        ATMService atmService = new ATMServiceImpl(atm);
        List<Banknote> banknotes = new ArrayList<>();
        banknotes.add(new Banknote(100, 10));
        banknotes.add(new Banknote(200, 10));
        banknotes.add(new Banknote(500, 10));
        banknotes.add(new Banknote(1000, 10));
        banknotes.add(new Banknote(2000, 0));
        banknotes.add(new Banknote(5000, 10));
        banknotes.add(new Banknote(200, 10));


        executeRefill(atm, atmService, banknotes);
        executeIssue(atm, atmService, 56);
        executeIssue(atm, atmService, 5600);
        executeIssue(atm, atmService, 500000);
        executeIssue(atm, atmService, 100);
    }

    private static void executeRefill(ATM atm, ATMService atmService, List<Banknote> banknotes) {
        System.out.println("-----------------------------------------------------");
        System.out.println("До пополнения");
        System.out.println(atm.getSections().toString());
        System.out.println("-------------");

        System.out.println("Пополняем банкомат");
        try {
            System.out.println(atmService.acceptMoney(banknotes));
        } catch (BanknotesAcceptingException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println("-------------");
        System.out.println("После пополнения");
        System.out.println(atm.getSections().toString());
    }

    private static void executeIssue(ATM atm, ATMService atmService, int sum) {
        System.out.println("-----------------------------------------------------");
        System.out.println("Запрошена сумма: " + sum);

        System.out.println("Выдано:");
        try {
            System.out.println(atmService.giveOutMoney(sum));
        } catch (NoSuchSumException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println("-------------");
        System.out.println("В банкомате осталось");
        System.out.println(atm.getSections().toString());
    }
}
