package ru.otus.model;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

//Допустим, этот класс библиотечный, его нельзя менять
public final class Measurement {
    private final String name;

    private final double value;

    public Measurement(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    private static class MyClassLoader extends ClassLoader {
        Class<?> defineClass(String className) throws IOException {
            var file = new File(getFileName(className));
            byte[] bytecode = Files.readAllBytes(file.toPath());
            return super.defineClass(className, bytecode, 0, bytecode.length);
        }

        private static String getFileName(String className) {
            String projectPath = new File("").getAbsolutePath();
            return projectPath + "\\out\\production\\classes" + File.separator + className.replace('.', '\\') + ".class";
        }
    }
}
