package Excteptions;

public class FileReadException extends Exception{
    public FileReadException(){
        super("Ошибка чтения файла!");
    }
}
