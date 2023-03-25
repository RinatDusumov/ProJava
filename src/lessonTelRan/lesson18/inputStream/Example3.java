package lessonTelRan.lesson18.inputStream;

/*
1.Create a File
2.Check if File or Directory Exists
3.Create a Directory if it Does Not Exist
4.File Length
5.Rename or Move File or Directory
6.Delete File or Directory
7.Check if Path is File or Directory
8.Read List of Files in Directory
 */

import java.io.File;
import java.util.Arrays;

public class Example3 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/test.txt");
        boolean isExist = file.exists();

        System.out.println("Файл test сущействует?: " + isExist);
        long length = file.length();
        System.out.println(length);

        file = new File("src/main/resources/test1");
        isExist = file.exists();

        System.out.println("Файл test1 сущействует?: " + isExist);

        boolean wasCreated = file.mkdir();
        System.out.println("Directory was created: " + wasCreated);

        length = file.length();
        System.out.println(length);

        boolean success = file.delete();
        System.out.println(success);

        File direcory = new File("src/main/resources/test2");
        boolean isDirecory = file.isDirectory();
        System.out.println(isDirecory);

        direcory = new File("src/main/resources/");
        String[] fileNames = direcory.list();


        System.out.println(Arrays.toString(fileNames));
    }
}
