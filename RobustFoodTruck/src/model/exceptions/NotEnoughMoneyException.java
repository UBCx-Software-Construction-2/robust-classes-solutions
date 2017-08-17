package model.exceptions;

/**
 * Created by James on 2017-05-12.
 */
public class NotEnoughMoneyException extends Exception {

    public NotEnoughMoneyException() { }

    public NotEnoughMoneyException(String msg) { super(msg); }
}
