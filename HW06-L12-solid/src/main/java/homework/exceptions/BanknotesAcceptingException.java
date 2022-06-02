package homework.exceptions;

import homework.services.MessageService;

public class BanknotesAcceptingException extends Exception {
    String message;
    Throwable cause;

    public BanknotesAcceptingException() {
        this.message = MessageService.ACCEPT_BANKNOTES_ERROR;
    }

    public BanknotesAcceptingException(Throwable cause) {
        this.message = MessageService.ACCEPT_BANKNOTES_ERROR;
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
