package lessonProJava.lesson2.animals;

public class Fish extends Animal {

    private boolean eatable;
    // для boolean всегда вместо get - is
    public boolean isEatable() {
        return eatable;
    }

    public void setEatable(boolean eatable) {
        this.eatable = eatable;
    }

    @Override
    void breath() {
        System.out.println("Gills");
    }
}
