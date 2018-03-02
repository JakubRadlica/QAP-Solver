package pl.radlica.io.Exception;

public class ContextFileException extends Exception {

    public ContextFileException(){
        super("Incorrect format of context file or file doesn't exists!");
    }
}
