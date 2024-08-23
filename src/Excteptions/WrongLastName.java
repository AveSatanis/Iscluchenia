package Excteptions;

public class WrongLastName  extends Exception{
    public WrongLastName(){
        super("Неправильный формат ввода фамилии!");
    }
}
