package lessonTelRan.lesson18.outputStream;

/*
самостоятельная
1. Создайте файл, используя FileOutputStream, с текстом: "This is my first experience when I myself work with IO API.
I can do everything!"
2. Создайте файл используя new File() в каталоге Desktop, убедитесь, что файл существует, удалите файл.
3. Создайте метод для удаления директории и суб-директорий
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Example7 {
    public static void main(String[] args) throws IOException {

        File testFile = new File("src/main/resources/testFileLastExample.txt");

        FileOutputStream stream = new FileOutputStream(testFile);
        stream.write("This is my first experience when I myself work with IO API. I can do everything! 111\n".getBytes());

        stream.write("This is my first experience when I myself work with IO API. I can do everything! 2222".getBytes());
        stream.close();

        boolean isExists = testFile.exists();
        System.out.println("our file is exist? -" + isExists);

        testFile.delete();

        File parentDir = new File("src/main/resources/testOne");
        removeDirAndSubDir(parentDir);
    }

    public static boolean removeDirAndSubDir(File dir) {
        // testOne
        //  - testTwo
        //    - testFour
        //  - TestThree


        File[] allContents = dir.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                removeDirAndSubDir(file);
            }
        }
        return dir.delete();

    }
}