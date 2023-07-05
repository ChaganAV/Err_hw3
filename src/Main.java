import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class Main {
    public static void main(String[] args) throws IOException {

        app();
    }

    private static void app() throws IOException {
        Record record = inputData();
        String filename = record.getLastname()+".txt";
        File file = new File(filename);
        String[] strings;
        if (file.exists()) {
            List<String> list = new ArrayList<>();
            try(BufferedReader br = new BufferedReader(new FileReader(file))){
                String line;
                while ((line = br.readLine())!=null){
                    list.add(line);
                }
            }

            try(BufferedWriter bf = new BufferedWriter(new FileWriter(file)) ){
                for (String str : list) {
                    if(str!=null) {
                        bf.write(str+"\n");
                    }
                }
                bf.write(record.toString());
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
        View view = new View();
        view.print();
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
            throws FormatBirthdayException, GenderException, DataFormatException {
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
    private static boolean getBirthdayFormat(String dateIn) throws FormatBirthdayException, DataFormatException {
        boolean result = true;
        String[] periods = dateIn.split(".");
        if(dateIn.charAt(2)!='.') throw new FormatBirthdayException();
        if(dateIn.charAt(5)!='.') throw new FormatBirthdayException();
        String sDay = dateIn.substring(0,2);
        String sMonth = dateIn.substring(3,5);
        String sYear = dateIn.substring(6,10);
        int day,month,year = 0;
        if(!contentDigit(sDay)) throw new FormatBirthdayException();
        else{
            day = Integer.parseInt(sDay);
        }
        if(!contentDigit(sMonth)) throw new FormatBirthdayException();
        else{
            month = Integer.parseInt(sMonth);
        }
        if(!contentDigit(sYear)) throw new FormatBirthdayException();
        else {
            year = Integer.parseInt(sYear);
            if(year==0)throw new DataFormatException();
        }
        if(month>12) throw new DataFormatException();
        if(month<7){
            if(month!=2) {
                if (month % 2 == 0 ){
                    if(day > 30) throw new DataFormatException();
                }else {
                    if(day > 31) throw new DataFormatException();
                }
            }else{
                if(day> 28 && year%4!=0){
                    throw new DataFormatException();
                }else{
                    if(day > 29) throw new DataFormatException();
                }
            }
        }else {
            if(month %2 != 0){
                if(day > 30) throw new DataFormatException();
            }
            else {
                if(day > 31) throw new DataFormatException();
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
}