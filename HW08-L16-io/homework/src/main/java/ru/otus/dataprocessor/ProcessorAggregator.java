package ru.otus.dataprocessor;

import ru.otus.model.Measurement;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProcessorAggregator implements Processor {

    @Override
    //группирует выходящий список по name, при этом суммирует поля value
    public Map<String, Double> process(List<Measurement> data) {
        Map<String, Double> aggregatedMeasurements = new TreeMap<>();
        for (Measurement datum : data) {
            String name = datum.getName();
            double value = datum.getValue();
            aggregatedMeasurements.computeIfPresent(name, (n, v) -> v + value);
            aggregatedMeasurements.putIfAbsent(name, value);
        }
        return aggregatedMeasurements;
    }
}
