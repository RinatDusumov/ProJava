package lessonTelRan.lesson18.outputStream;

/*
FileInputStream & FileOutputStream examples
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Example6 {
    public static void main(String[] args) throws IOException {
        inputExample();
        outputExample();
    }

    public static void inputExample() throws IOException {
        // пример чтения
        try {
            String path = "src/main/resources/test.txt";
            FileInputStream input = new FileInputStream(path);

            int data = input.read();

            while (data != -1) {
                System.out.print((char) data + " ");
                data = input.read();
            }

            input.close();

        } catch (IOException e) {
            System.out.println("Something wrong!");
        }

        System.out.println("All is OK");
    }

    public static void outputExample() {
        try {
            String path = "src/main/resources/test.txt";
            FileOutputStream out = new FileOutputStream(path, true);
            out.write("\nhello from java outputstream".getBytes());
            out.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}