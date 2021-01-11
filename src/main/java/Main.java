import contoller.ConsoleHandler;
import java.lang.reflect.InvocationTargetException;
import lib.Injector;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException,
            IllegalAccessException, InstantiationException,
            InvocationTargetException {
        ConsoleHandler consoleHandler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        consoleHandler.handle();
    }
}
