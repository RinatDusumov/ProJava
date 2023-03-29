package main.java.students.rinat_dusumov.homeWork._15_03_2023;

class Roots {
    private Double x1;
    private Double x2;

    public Roots(Double x1, Double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    public Double getX1() {
        return x1;
    }

    public Double getX2() {
        return x2;
    }

    public Roots(Double x1) {
        this.x1 = x1;
    }

    @Override
    public String toString() {
        return "x1 = " + x1 +
                ", x2 = " + x2;
    }
}