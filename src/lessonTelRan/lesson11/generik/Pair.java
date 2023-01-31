package lessonTelRan.lesson11.generik;
/*

 */
public class Pair<L, R extends Number> {
    private L left;
    private R right;


    public L getLeft() {
        return left;
    }

    public void setLeft(L left) {
        this.left = left;
    }

    public R getRight() {
        return right;
    }

    public void setRight(R right) {
        this.right = right;
    }
}
