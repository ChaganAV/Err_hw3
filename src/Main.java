import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        app();
    }

    private static void app() throws IOException {
        Record record = inputData();
        String filename = record.getLastname()+".txt";
        File file = new File(filename);
        if (file.exists()) {
            try(BufferedWriter bf = new BufferedWriter(new FileWriter(file)) ){

                bf.write(record.toString());
                bf.newLine();
            }
        }else {
            try(BufferedWriter bf = new BufferedWriter(new FileWriter(file)) ){

                bf.write(record.toString());
                bf.newLine();
            }
        }
    }
    public static void isFileExists(String path) throws FileNotFoundException {
        File file = new File(path);
        if(file.exists()){
            System.out.println("OK");
        }else{
            throw new FileNotFoundException("File do not is exist");
        }
    }
    private static Record inputData(){
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
        Record record = new Record();
        try{
            if (arrString.length != countData){
                throw new CountFalseException();
            }

            setRecord(record,arrString);
            System.out.println(record);
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
        return record;
    }
    private static void setRecord(Record record, String[] arrString)
            throws FormatBirthdayException, GenderException {
        for (int i = 0; i < arrString.length; i++) {
            switch (i) {
                case 0:
                    record.setLastname(arrString[i]);
                    break;
                case 1:
                    record.setFirstname(arrString[i]);
                    break;
                case 2:
                    record.setSecondname(arrString[i]);
                    break;
                case 3:
                    if(getBirthdayFormat(arrString[i])){
                        record.setBirthday(arrString[i]);
                    }
                    break;
                case 4:
                    boolean flag = contentDigit(arrString[i]);
                    if(!flag){
                        throw new NumberFormatException();
                    }else {
                        record.setPhone(arrString[i]);
                    }
                    break;
                case 5:
                    if(getGender(arrString[i])){
                        record.setGender(arrString[i]);
                    }else {
                        throw new GenderException();
                    }
                    break;
            }
        }
    }
    private static boolean getGender(String gender) throws GenderException {
        boolean result = false;
        if(gender.equals("f") || gender.equals("m")) {
            return true;
        }
        return result;
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