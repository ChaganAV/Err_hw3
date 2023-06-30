import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        app();
    }

    private static void app() {
        inputData();
    }
    private static void inputData(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Фамилия Имя Отчество датарождения номертелефона пол");
        System.out.println("разделенные пробелом");
        System.out.println("Формат данных:");
        System.out.println("фамилия, имя, отчество - строки");
        System.out.println("дата рождения - строка формата dd.mm.yyyy");
        System.out.println("номер телефона - целое беззнаковое число");
        System.out.println("пол - символ латиницей f или m");
        System.out.println("----------------");
        String input = scanner.nextLine();
        String[] arrString = input.split(" ");
        int countData = 6;
        try{
            if (arrString.length != countData){
                throw new CountFalseException();
            }

            for (int i = 0; i < arrString.length; i++) {
                switch (i) {
                    case 3:
                        getBirthdayFormat(arrString[i]);
                        break;
                    case 4:
                        boolean flag = contentDigit(arrString[i]);
                        if(!flag){
                            throw new NumberFormatException();
                        }
                        break;
                    case 5:
                        if(arrString[i]!="f"){
                            if( arrString[i]!="m"){
                                throw new GenderException();
                            }
                        }
                }
            }
        } catch (CountFalseException ex){
            ex.printStackTrace();
        } catch (FormatBirthdayException e) {
            e.printStackTrace();
        } catch (NumberFormatException exNum){
            exNum.printStackTrace();
        } catch (GenderException e) {
            e.printStackTrace();
        } catch (Exception exp){
            exp.printStackTrace();
        }
    }
    private static boolean getBirthdayFormat(String dateIn) throws FormatBirthdayException {
        boolean result = false;
        String[] periods = dateIn.split(".");
        for (int i = 0; i < periods.length; i++) {
            result = contentDigit(periods[i]);
            if(!result){
                throw new FormatBirthdayException();
            }
            switch (i){
                case 0:
                    int day = Integer.parseInt(periods[i]);
                    if(day > 31){
                        throw new FormatBirthdayException();
                    }
                case 1:
                    int month = Integer.parseInt(periods[i]);
                    if(month<1 && month > 12){
                        throw new FormatBirthdayException();
                    }
            }
        }
        return result;
    }
    private static boolean contentDigit(String str){
        for (int i = 0; i < str.length(); i++) {
            if(!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
    public static class CountFalseException extends Exception{
        public CountFalseException(){
            super("Данные не соответствуют количеству");
        }
    }
    public static class FormatBirthdayException extends Exception{
        public FormatBirthdayException(){
            super("Дата рождение не соответствует формату dd.mm.yyyy");
        }
    }
    public static class GenderException extends Exception{
        public GenderException(){
            super("Пол не соответствует формату латинской: f или m");
        }
    }
}