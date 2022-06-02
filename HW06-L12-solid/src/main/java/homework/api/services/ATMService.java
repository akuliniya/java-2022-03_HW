package homework.api.services;

import homework.domain.Banknote;
import homework.exceptions.BanknotesAcceptingException;
import homework.exceptions.NoSuchSumException;

import java.util.List;

public interface ATMService {
    String acceptMoney(List<Banknote> banknotes) throws BanknotesAcceptingException;
    List<Banknote> giveOutMoney(int sum) throws NoSuchSumException;
}
