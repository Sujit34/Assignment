package IoC;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MyInjector {
    private Map<Class, Object> container = new HashMap<>();
    public Object getBean(Class cls) throws BeanNotFoundException {
        try {
            return container.get(cls);
        } catch (Exception ex) {
            throw new BeanNotFoundException("Bean Not Found!");
        }
    }
    public void scanForBean() throws Exception {
        Set<Object> classes = findAllClasses("Classes");
        for (Object cls : classes) {
            String thisClass = cls.toString().split(" ")[1];
            if (hasAnnotation(Class.forName(thisClass))) {
                container.put(Class.forName(thisClass), Class.forName(thisClass).getDeclaredConstructor().newInstance());
            }
        }
    }

    public Set<Object> findAllClasses(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines().filter(line -> line.endsWith(".class")).map(line -> getClass(line, packageName))
                .collect(Collectors.toSet());
    }

    private Object getClass(String line, String packageName) {
        try {
            return Class.forName(packageName + "." + line.substring(0, line.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
        }
        return null;
    }

    private boolean hasAnnotation(Class cls) {
        List<Field> privateFields = new ArrayList<>();
        Field[] allField = cls.getDeclaredFields();
        for (Field f : allField) {
            if (Modifier.isPrivate(f.getModifiers())) {
                privateFields.add(f);
            }
        }
        for (Field f : privateFields) {
            if (f.isAnnotationPresent(MyAutowired.class)) {
                return true;
            }
        }
        return false;
    }





}
