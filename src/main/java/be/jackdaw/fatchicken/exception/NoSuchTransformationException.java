package be.jackdaw.fatchicken.exception;

public class NoSuchTransformationException extends RuntimeException {
    public NoSuchTransformationException(String type) {
        super("No Transformation has been found for the entitytype " + type);
    }
}
