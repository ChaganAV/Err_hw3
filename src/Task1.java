import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        run();
    }

    private static void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива ");
        try {
            int size = scanner.nextInt();
            int[] array = new int[size];
            System.out.println("и элементы массива");
            for (int i = 0; i <array.length; i++) {
                array[i] = scanner.nextInt();
            }
            System.out.println("Введите число для поиска");
            int num = scanner.nextInt();
            boolean flag = false;
                for (int i = 0; i < array.length; i++) {
                    if (array[i] == num) {
                        System.out.println("Ваше число лежит по индексом: " + i + " оно у нас под контролем!");
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    throw new NumberNotFoundException();
                }
        }catch (NumberFormatException ex){
            ex.printStackTrace();
        }catch (NumberNotFoundException e){
            e.printStackTrace();
        }
    }
    private static class NumberNotFoundException extends Exception{
        public NumberNotFoundException(){
            super("Число не найдено");
        }
    }
}
