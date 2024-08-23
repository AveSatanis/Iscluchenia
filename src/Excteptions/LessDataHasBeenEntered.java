package Excteptions;

public class LessDataHasBeenEntered  extends Exception{
    public LessDataHasBeenEntered(){
        super("Введены не все данные!");
    }
}
