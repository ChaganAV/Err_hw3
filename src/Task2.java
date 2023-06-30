import java.io.File;
import java.io.FileNotFoundException;

public class Task2 {
    public static void main(String[] args) {
        try {
            isFileExists("src/Task2.java");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
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
}
