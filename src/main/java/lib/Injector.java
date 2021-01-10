package lib;

import exception.NoSuchAnnotationException;
import factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static final String BET_DAO = "betDao";
    public static final String PERSON_DAO = "personDao";
    public static final Class<Dao> CLASS_ANNOTATION = Dao.class;

    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                if (field.getName().equals(BET_DAO)
                        && Factory.getBetDao().getClass()
                        .getAnnotation(CLASS_ANNOTATION) != null) {
                    field.setAccessible(true);
                    field.set(instance, Factory.getBetDao());
                } else if (field.getName().equals(PERSON_DAO)
                        && Factory.getPersonDao().getClass()
                        .getAnnotation(CLASS_ANNOTATION) != null) {
                    field.setAccessible(true);
                    field.set(instance, Factory.getPersonDao());
                } else {
                    throw new NoSuchAnnotationException("There is no such annotation: "
                            + CLASS_ANNOTATION + " in : " + clazz.getName());
                }
            }
        }
        return instance;
    }
}
