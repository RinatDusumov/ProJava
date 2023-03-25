package lessonTelRan.lesson18.inputStream;
import java.io.*;
public class Example1 {
    public static void main(String[] args) {
        inputStreamExample();
        System.out.println();
        bufferedReaderExample();
    }

    public static void inputStreamExample() {
        /*
        InputStreamReader — считывает байты и декодирует
        */
        try {
            InputStream stream = new FileInputStream("src/main/resources/input.txt");
            Reader reader = new InputStreamReader(stream);
            int data = reader.read();

            while (data != -1) {
                System.out.print((char) data + " ");
                data = reader.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void bufferedReaderExample() {
        InputStreamReader stream = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(stream);

        double n = 0;
        double k = 0;

        try {
            n = Double.parseDouble(br.readLine());
            k = Double.parseDouble(br.readLine());

            System.out.println(n + k);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}