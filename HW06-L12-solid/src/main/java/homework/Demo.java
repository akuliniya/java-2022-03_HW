package homework;

import homework.api.services.ATMService;
import homework.domain.ATM;
import homework.domain.Banknote;
import homework.domain.ClassicATM;
import homework.exceptions.BanknotesAcceptingError;
import homework.exceptions.NoSuchSumException;
import homework.services.ATMServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Demo {
    public static void main(String[] args) throws NoSuchSumException, BanknotesAcceptingError {
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

        System.out.println("Сначала ячейки банкомата пустые");
        System.out.println(atm.getSections().toString());
        System.out.println("-----------------------------------------------------");

        System.out.println("Затем мы наполняем их");
        System.out.println(atmService.acceptMoney(banknotes));
        System.out.println("-----------------------------------------------------");

        System.out.println("Смотрим, что сейчас в ячейках");
        System.out.println(atm.getSections().toString());
        System.out.println("-----------------------------------------------------");

        System.out.println("Выдаем запрошенную сумму, смотрим, какми купюрами выдали");

        System.out.println(atmService.giveOutMoney(56));
        System.out.println(atmService.giveOutMoney(5600));
        System.out.println(atmService.giveOutMoney(500000));
        System.out.println(atmService.giveOutMoney(100));
        System.out.println("-----------------------------------------------------");

        System.out.println("Смотрим, сколько осталось в ячейках");
        System.out.println(atm.getSections().toString());
        System.out.println("-----------------------------------------------------");

    }
}
