public class InvalidExpressionException extends RuntimeException {
    private final Throwable t;

    public InvalidExpressionException(String message, Throwable t) {
        super(message, t);
        this.t = t;
    }
    
    public InvalidExpressionException(String message) {
        this(message, null);
    }
}
