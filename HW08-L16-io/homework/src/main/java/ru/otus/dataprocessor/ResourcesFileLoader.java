package ru.otus.dataprocessor;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.otus.model.Measurement;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ResourcesFileLoader implements Loader {
    private final ObjectMapper mapper;
    private final String fileName;


    public ResourcesFileLoader(String fileName) {
        this.mapper = new ObjectMapper();
        mapper.addMixInAnnotations(Measurement.class, MeasurementMixin.class);
        this.fileName = fileName;
    }

    @Override
    //читает файл, парсит и возвращает результат
    public List<Measurement> load() {
//        System.out.println("current dir: " + System.getProperty("user.dir"));
        try {
            var file = new File(fileName);
            System.out.println("json will will be loaded from the file:" + file.getAbsolutePath());

            JavaType type = mapper.getTypeFactory().constructParametricType(List.class, Measurement.class);
            List<Measurement> measurements = mapper.readValue(file, type);

            for (Measurement measurement : measurements) {
                System.out.println(measurement.toString());
            }
            return measurements;
        }catch (IOException e) {
            throw new FileProcessException(e);
        }
    }
}
