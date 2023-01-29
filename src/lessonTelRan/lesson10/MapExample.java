package lessonTelRan.lesson10;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    /* Есть жёсткая связь между ключом и значением.
    ключи всегда уникальные.
    Нельзя изменять данные ключей, иначе данные этого объекта
    будут более недоступны
     */
    public static void main(String[] args) {
        Map<String, Integer> stringIntegerMap = new HashMap<>();

        stringIntegerMap.put("A", 1);
        stringIntegerMap.put("A", 1);
        stringIntegerMap.put("B", 1);
        stringIntegerMap.put("B", 2);
        stringIntegerMap.put("B", 2);
    }
}
