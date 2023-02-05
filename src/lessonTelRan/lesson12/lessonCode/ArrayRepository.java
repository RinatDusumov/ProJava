package lessonTelRan.lesson12.lessonCode;

public class ArrayRepository implements StringRepository {
    private String[] dataBase = new String[0];

    @Override
    public void save(String text) {
        // Если бы не было коллекций и требовалось бы писать самому
        /* ... написать реализацию при которой старые значения из массива
            копировались бы в новый массив со сдвигом индекса на единицу.
         */
        dataBase[0] = text;
    }
}
