package Excteptions;

public class PhoneNumberException extends Exception{
    public PhoneNumberException(){
        super("Неверный формат ввода номера телефона!");
    }
}
