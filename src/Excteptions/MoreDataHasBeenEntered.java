package Excteptions;

public class MoreDataHasBeenEntered  extends Exception{
    public MoreDataHasBeenEntered(){
        super("Введены лишние данные!");
    }
}
