package homework.proxy.framework;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

public class BeanFactory {
    private Map<String,Set<String>> singletons = new HashMap<>();

    public void instantiate(String basePackage) {
        try {
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();

            String path = basePackage.replace('.', '/');
            Enumeration<URL> resources = classLoader.getResources(path);

            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                File file = new File(resource.toURI());

                for (File classFile : file.listFiles()) {
                    String fileName = classFile.getName();//ProductService.class
                    System.out.println(fileName);
                    if (fileName.endsWith(".class")) {
                        String className = fileName.substring(0, fileName.lastIndexOf("."));
                        Class clazz = Class.forName(basePackage + "." + className);
                        Method[] methods = clazz.getMethods();
                        Set<String> methodsForLogging = new HashSet<>();
                        boolean hasMethodsWithLogging = false;
                        for (Method method : methods) {
                            if (method.isAnnotationPresent(Log.class)) {
                                System.out.println("Log: " + method.getName());
                                hasMethodsWithLogging = true;
                                methodsForLogging.add(method.getName());
                            }
                        }
                        if (hasMethodsWithLogging){
                            String beanName = className.substring(0, 1).toLowerCase() + className.substring(1);
                            singletons.put(beanName, methodsForLogging);
                        }
                    }
                }
            }
        } catch (IOException | URISyntaxException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

//    public Object getBean(String beanName) {
//        return singletons.get(beanName);
//    }

    public Map<String,Set<String>> getBeans() {
        return Collections.unmodifiableMap(Map.copyOf(singletons));
    }
}
