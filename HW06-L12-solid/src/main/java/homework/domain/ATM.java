package homework.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class ATM {
    private final List<Section> sections;

    public ATM() {
        sections = new ArrayList<>();
        sections.add(new Section(100));
        sections.add(new Section(200));
        sections.add(new Section(500));
        sections.add(new Section(1000));
        sections.add(new Section(2000));
        sections.add(new Section(5000));
    }

    public List<Section> getSections() {
        return sections;
    }

    public int getAvailableSum() {
        return sections.stream().map(Section::getNominal).mapToInt(Integer::intValue).sum();
    }
}
