package lessonTelRan.lesson_26;

public class PairUniversal <R,L> {
    private R right;
    private L left;

    public PairUniversal(R right, L left) {
        this.right = right;
        this.left = left;
    }

    public R getRight() {
        return right;
    }

    public void setRight(R right) {
        this.right = right;
    }

    public L getLeft() {
        return left;
    }

    public void setLeft(L left) {
        this.left = left;
    }

    @Override
    public String toString() {
        return "PairUniversal{" +
                "right=" + right +
                ", left=" + left +
                '}';
    }
}
