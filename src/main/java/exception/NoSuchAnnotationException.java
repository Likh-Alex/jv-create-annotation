package exception;

public class NoSuchAnnotationException extends RuntimeException {
    public NoSuchAnnotationException(String message) {
        super(message);
    }
}
