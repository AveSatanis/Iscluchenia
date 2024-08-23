package Excteptions;

public class BirthDayException extends Exception{
    public BirthDayException(){
        super("Неверный формат ввода даты рождения!");
    }
}
