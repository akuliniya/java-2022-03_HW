package homework.exceptions;

import homework.services.MessageService;

public class NoSuchSumException extends Exception {
    String message;
    Throwable cause;

    public NoSuchSumException() {
        this.message = MessageService.NO_SUCH_SUM_MESSAGE;
    }

    public NoSuchSumException(int sum) {
        this.message = MessageService.NO_SUCH_SUM_MESSAGE + sum;
    }

    public NoSuchSumException(Throwable cause) {
        this.message = MessageService.NO_SUCH_SUM_MESSAGE;
        this.cause = cause;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public synchronized Throwable getCause() {
        return cause;
    }

}
