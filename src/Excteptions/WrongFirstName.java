package Excteptions;

public class WrongFirstName extends Exception{
    public WrongFirstName(){
        super("Неверныйй формат ввода имени!");
    }
}
