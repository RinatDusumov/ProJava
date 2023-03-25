package lessonTelRan.lesson18.outputStream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputExample {
    public static void main(String[] args) throws IOException {
        FileInputStream input = new FileInputStream("src/main/resources/input.txt");
        while (input.available() > 0) {
            int oneByte = input.read();
            System.out.print((char) oneByte);
        }
        input.close();

    }
}