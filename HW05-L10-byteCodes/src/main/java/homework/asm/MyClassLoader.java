//package homework.proxy.simple;
//
//import java.io.File;
//import java.io.IOException;
//import java.net.URISyntaxException;
//import java.net.URL;
//import java.nio.file.Files;
//import java.util.Enumeration;
//
//public class MyClassLoader extends ClassLoader {
//    Class<?> defineClass() throws IOException, URISyntaxException, ClassNotFoundException {
//        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
//        String basePackage = new File("").getAbsolutePath();
//        String path = basePackage.replace('.', '/');
//        Enumeration<URL> resources = classLoader.getResources(path);
//
//
//        while (resources.hasMoreElements()) {
//            URL resource = resources.nextElement();
//
//            File file = new File(resource.toURI());
//            for (File classFile : file.listFiles()) {
//                String fileName = classFile.getName();//ProductService.class
//
//                if (fileName.endsWith(".class")) {
//                    String className = fileName.substring(0, fileName.lastIndexOf("."));
//                    Class classObject = Class.forName(basePackage + "." + className);
//
//                    if (classObject.isAnnotationPresent(Log.class)) {
//                        System.out.println("Log: " + classObject);
//                    }
//                }
//            }
//        }
//        retur nsuper.defineClass(className, bytecode, 0, bytecode.length);
//
////        var file = new File(getFileName(className));
////        byte[] bytecode = Files.readAllBytes(file.toPath());
////        return super.defineClass(className, bytecode, 0, bytecode.length);
////    }
////
////    String getFileName(String className) {
////        String projectPath = new File("").getAbsolutePath();
////        return projectPath + "\\build\\classes\\java\\main" + File.separator + className.replace('.', '\\') + ".class";
////    }
//    }
//}
