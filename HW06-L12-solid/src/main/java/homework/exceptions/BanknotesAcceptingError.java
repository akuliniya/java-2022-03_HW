package homework.exceptions;

import homework.services.MessageService;

public class BanknotesAcceptingError extends Exception {
    String message;
    Throwable cause;

    public BanknotesAcceptingError() {
        this.message = MessageService.ACCEPT_BANKNOTES_ERROR;
    }

    public BanknotesAcceptingError(Throwable cause) {
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
