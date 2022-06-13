package ru.otus.dataprocessor;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class FileSerializer implements Serializer {
    private final ObjectMapper mapper;
    private final File file;

    public FileSerializer(String fileName) {
        this.mapper = new ObjectMapper();
        this.file = new File(fileName);
    }

    @Override
    //формирует результирующий json и сохраняет его в файл
    public void serialize(Map<String, Double> data) throws IOException {
        mapper.writeValue(file, data);
        System.out.println("user saved to the file:" + file.getAbsolutePath());

    }
}
