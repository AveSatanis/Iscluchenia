package Excteptions;

public class GenderException extends Exception{
    public GenderException(){
        super("Неверный формат ввода пола!");
    }
}
