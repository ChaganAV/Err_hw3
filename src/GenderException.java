public class GenderException extends Exception{
    public GenderException(){
        super("Пол не соответствует формату латинской: f или m");
    }
}
