public class UserException extends RuntimeException {
    ExceptionType type;

    public UserException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }

    enum ExceptionType {
        SQLException, Null, ClassNotFound, NullList
    }
}