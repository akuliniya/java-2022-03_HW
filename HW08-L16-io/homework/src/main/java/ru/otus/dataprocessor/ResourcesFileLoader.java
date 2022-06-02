package ru.otus.dataprocessor;

import ru.otus.json.xjson.JavaxJsonDemo;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonNumber;
import jakarta.json.JsonObject;
import jakarta.json.JsonString;
import jakarta.json.JsonStructure;
import jakarta.json.JsonValue;
import ru.otus.model.Measurement;
import java.util.List;

public class ResourcesFileLoader implements Loader {

    public ResourcesFileLoader(String fileName) {
    }

    @Override
    public List<Measurement> load() {
        //читает файл, парсит и возвращает результат
        try (var jsonReader = Json.createReader(JavaxJsonDemo.class.getClassLoader().getResourceAsStream(fileName)) {
            JsonStructure jsonFromTheFile = jsonReader.read();
            System.out.println("\n json from the file:");
            System.out.println(jsonFromTheFile);
            System.out.println("property:" + jsonFromTheFile.getValue("/firstName"));
        return null;
    }
}
