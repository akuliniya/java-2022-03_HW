package homework.services;

import homework.api.services.ATMService;
import homework.domain.ATM;
import homework.domain.Banknote;
import homework.domain.Section;
import homework.exceptions.BanknotesAcceptingError;
import homework.exceptions.NoSuchSumException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ATMServiceImpl implements ATMService {
    private final ATM atm;

    public ATMServiceImpl(ATM atm) {
        this.atm = atm;
    }

    @Override
    public String acceptMoney(List<Banknote> banknotes) throws BanknotesAcceptingError {
        List<Section> sections = List.copyOf(atm.getSections());
        for (Section atmSection : sections) {
            for (Banknote banknote : banknotes) {
                if (banknote.getNominal() == atmSection.getNominal()) {
                    atmSection.changeQuantity(atmSection.getQuantity() + banknote.getQuantity());
                }
            }
        }
        return Optional.of(MessageService.BANKNOTES_ACCEPTED).orElseThrow(BanknotesAcceptingError::new);
    }

    @Override
    public List<Banknote> giveOutMoney(int sum) throws NoSuchSumException {
        List<Banknote> banknotes = new ArrayList<>();
        List<Section> atmSections = atm.getSections();
        int leastNominal = atmSections.get(0).getNominal();
        int as = atm.getAvailableSum();
        if (sum % leastNominal > 0 || atm.getAvailableSum() < sum) {
            throw new NoSuchSumException(sum);
        }
        int needToGiveOutSum = sum;
        int possibleToGiveOutSum = 0;
        for (int i = atmSections.size() - 1; i >= 0; i--) {
            int banknotesQuantity = 0;
            Section section = atmSections.get(i);
            int sectionNominal = section.getNominal();
            int sectionQuantity = section.getQuantity();
            while (section.getQuantity() > 0 && needToGiveOutSum / sectionNominal > 0) {
                banknotesQuantity++;
                sectionQuantity--;
                section.changeQuantity(sectionQuantity);
                needToGiveOutSum -= sectionNominal;
                possibleToGiveOutSum += sectionNominal;
            }
            if (needToGiveOutSum > possibleToGiveOutSum) {
                throw new NoSuchSumException(sum);
            }
            Banknote banknote = new Banknote(sectionNominal, banknotesQuantity);
            banknotes.add(banknote);
            section.changeQuantity(sectionQuantity);
        }
        return Optional.of(banknotes).orElseThrow(() -> new NoSuchSumException(sum));
    }
}
