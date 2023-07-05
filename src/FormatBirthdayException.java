public class FormatBirthdayException extends Exception{
    public FormatBirthdayException(){
        super("Дата рождение не соответствует формату dd.mm.yyyy");
    }
}
