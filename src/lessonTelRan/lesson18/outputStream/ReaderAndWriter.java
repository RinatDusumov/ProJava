package lessonTelRan.lesson18.outputStream;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderAndWriter {
    public static void main(String[] args) {

        List<String> ourList = new ArrayList<>();

        try{
            File file = new File("src/main/resources/input.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();
            int counter = 0;

            while (line != null){
                counter++;
                ourList.add(line);
                System.out.println(" Our " + counter + " line is: " + line);
                line = reader.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File open Error!!");;
        } catch (IOException e) {
            System.out.println("I/O  error");
        }

        try{
            FileWriter writer =  new FileWriter("src/main/resources/output.txt");
            for (int i = 0; i < ourList.size(); i++) {
                String myLine = ourList.get(i);
                writer.write(myLine);
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}