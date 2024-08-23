package Excteptions;

public class FileWriteException extends Exception{
    public FileWriteException(){
        super("Ошибка записи в файл!");
    }
}
