package Excteptions;

public class IncorrectPatronymic extends Exception{
    public IncorrectPatronymic(){
        super("Неверный формат ввода отчества!");
    }
}
