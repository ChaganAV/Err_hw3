import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите эл.адрес");
        String input  = scanner.nextLine();
        //input.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        if(input.contains("@") && input.charAt(0)!='@'){
            System.out.println("Адрес корректный");
        }else {
            throw new RuntimeException("Адрес некорректный");
        }
    }
}
