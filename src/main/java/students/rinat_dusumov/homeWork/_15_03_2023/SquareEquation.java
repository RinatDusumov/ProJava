package main.java.students.rinat_dusumov.homeWork._15_03_2023;

class SquareEquation {
    private Double param1;
    private Double param2;
    private Double param3;

    public SquareEquation(Double param1, Double param2, Double param3) {
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
    }

    public SquareEquation() {
    }

    @Override
    public String toString() {
        return "SquareEquation{" +
                "param1=" + param1 +
                ", param2=" + param2 +
                ", param3=" + param3 +
                '}';
    }
    void rootSearch () {
        double discriminant = Math.pow(param2,2) -
                (4 * param1 * param3);
        if (discriminant < 0) {
            System.out.println("Корней нет");
        }
        if (discriminant == 0 ) {
            double root = (param2 * -1) / 2 * param1;
            Roots roots = new Roots(root);
            System.out.println("Есть один корень");
            solution(roots);
        }
        if (discriminant > 0) {
            double root1 = ((param2 * -1) + Math.sqrt(discriminant)) / 2 * param1;
            double root2 = ((param2 * -1) - Math.sqrt(discriminant)) / 2 * param1;
            Roots roots = new Roots(root1, root2);
            System.out.println("У уравнения два корня");
            solution(roots);
        }
    }
    double rootSearch (Double param1, Double param2, Double param3) {
        double discriminant = Math.pow(param2,2) -
                (4 * param1 * param3);
        double numberOfRoots = 0;
//        if (discriminant < 0) {
//            System.out.println("Корней нет");
//            numberOfRoots = 0;
//        }
        if (discriminant == 0 ) {
            double root = (param2 * -1) / 2 * param1;
            Roots roots = new Roots(root);
            System.out.println("Есть один корень");
            solution(roots);
            numberOfRoots = 1;
        }
        if (discriminant > 0) {
            double root1 = ((param2 * -1) + Math.sqrt(discriminant)) / 2 * param1;
            double root2 = ((param2 * -1) - Math.sqrt(discriminant)) / 2 * param1;
            Roots roots = new Roots(root1, root2);
            System.out.println("У уравнения два корня");
            solution(roots);
            numberOfRoots = 2;
        }
        return numberOfRoots;
    }
    void solution(Roots roots) {
        System.out.println(roots);
        try {
            boolean presenceOfRoots = roots.getX1() == null && roots.getX2() == null;
        } catch (ArithmeticException e) {
            System.out.println("Корней нет");
            double numberOfRoots = 0;
        }
    }
}