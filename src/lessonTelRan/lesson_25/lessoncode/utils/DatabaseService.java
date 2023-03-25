package lessonTelRan.lesson_25.lessoncode.utils;

import lessonTelRan.lesson_25.lessoncode.database.DatabaseImpl;
import lessonTelRan.lesson_25.lessoncode.entity.Employer;

public class DatabaseService {
    private DatabaseImpl db = new DatabaseImpl();
    private InputData inputData = new InputData();

    public Employer createEmployer() {
        // ввод данных (получение данных) от пользователя
        // проверка (валидация данных)

        return null;
    }
    public void addEmployer(Employer employer) {
        // добавить в базу данных
        db.add(employer);
    }
}
