package lib;

import dao.BetDao;
import dao.PersonDao;
import dao.implementation.BetDaoImpl;
import dao.implementation.PersonDaoImpl;
import exception.NoSuchAnnotationException;
import factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static final Class<Dao> DAO_ANNOTATION = Dao.class;
    public static final Class<Inject> INJECT_ANNOTATION = Inject.class;

    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(INJECT_ANNOTATION)) {
                if (field.getType() == BetDao.class
                        && BetDaoImpl.class.isAnnotationPresent(DAO_ANNOTATION)) {
                    field.setAccessible(true);
                    field.set(instance, Factory.getBetDao());
                } else if (field.getType() == PersonDao.class
                        && PersonDaoImpl.class.isAnnotationPresent(DAO_ANNOTATION)) {
                    field.setAccessible(true);
                    field.set(instance, Factory.getPersonDao());
                } else {
                    throw new NoSuchAnnotationException("There is no such annotation: "
                            + DAO_ANNOTATION + " in : " + clazz.getName());
                }
            }
        }
        return instance;
    }
}
