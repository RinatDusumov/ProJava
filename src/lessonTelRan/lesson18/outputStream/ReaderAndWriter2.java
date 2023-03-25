package lessonTelRan.lesson18.outputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReaderAndWriter2 {
    public static void main(String[] args) {

        List<String> ourList = new ArrayList<>();

        try{
            FileReader reader = new FileReader("src/main/resources/input.txt");

            char[] buf = new char[256];
            int c;

            while ((c = reader.read(buf)) > 0){

                if (c < 256) {
                    buf = Arrays.copyOf(buf,c);
                }
                ourList.add(Arrays.toString(buf));
                System.out.println(buf);
            }

            System.out.println(ourList);


        } catch (IOException e) {
            System.out.println("I/O  error");
        }


    }
}