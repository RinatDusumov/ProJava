package lessonTelRan.lesson11.generik;

public class GenRestriction <T> {
    private T type1;
    private T[] arrayType1;

    public GenRestriction(T type1, T[] arrayType1) {
        this.type1 = type1;
        this.arrayType1 = arrayType1;
    }
}
