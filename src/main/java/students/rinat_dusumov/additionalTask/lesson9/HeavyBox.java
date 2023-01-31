package main.java.students.rinat_dusumov.additionalTask.lesson9;

import java.util.*;

public class HeavyBox implements Comparable{
    private int mass;
    private int id;
    public HeavyBox(int mass, int id) {
        this.mass = mass;
        this.id = id;
    }
    public static void main(String[] args) {
        // task 1
        List<HeavyBox> box = new ArrayList<>();
        HeavyBox heavyBox1 = new HeavyBox(260, 4546);
        HeavyBox heavyBox2 = new HeavyBox(310, 5678);
        HeavyBox heavyBox3 = new HeavyBox(290, 5722);
        HeavyBox heavyBox4 = new HeavyBox(400, 5722);
        box.add(heavyBox1);
        box.add(heavyBox2);
        box.add(heavyBox3);
        box.add(heavyBox4);
        for (HeavyBox boxes : box) {
            System.out.print(boxes + " ");
        }
        heavyBox1.setMass(1);
        box.remove(box.size() - 1);

        HeavyBox[] boxesArray1 = box.toArray(new HeavyBox[0]);
        Object[] boxesArray2 = box.toArray();
        HeavyBox[] boxesArray3 = new HeavyBox[box.size()];
        for (int i = 0; i < box.size(); i++) {
            boxesArray3[i] = box.get(i);
        }
        System.out.println("\n" + Arrays.toString(boxesArray1));
        System.out.println(Arrays.toString(boxesArray2));
        System.out.println(Arrays.toString(boxesArray3));
        box.clear();

        // task 2
        TreeSet<HeavyBox> boxTreeSet = new TreeSet<>();
        boxTreeSet.add(heavyBox1);
        boxTreeSet.add(heavyBox2);
        boxTreeSet.add(heavyBox3);
        for (HeavyBox boxes : boxTreeSet) {
            System.out.println(boxes);
        }

        // task 3
        String user = "1, 2, 3, 4, 4, 5";
        String[] numberArray = user.split(", ");
        Set<String> str = new HashSet<>();
        for (int i = 0; i < numberArray.length; i++) {
            str.add(numberArray[i]);
        }
        System.out.println(str);

        // task 4
        Set<Integer> number1 = new HashSet<>();
        number1.add(12);
        number1.add(34);
        number1.add(43);
        number1.add(32);
        number1.add(22);

        Set<Integer> number2 = new HashSet<>();
        number2.add(47);
        number2.add(76);
        number2.add(43);
        number2.add(22);
        number2.add(12);
        number2.add(95);

        System.out.println(union(number1, number2));
        System.out.println(intersect(number1, number2));

        // task 6
        Set<HeavyBox> boxSet = new HashSet<>();
        boxSet.add(heavyBox1);
        boxSet.add(heavyBox2);
        boxSet.add(heavyBox3);
        boxSet.add(heavyBox4);

        Set<Iterator<HeavyBox>> boxSet2 = division(boxSet);

        // task 8

    }
    public static Set<Iterator<HeavyBox>> division (Set<HeavyBox> boxSet) {
        Set<Iterator<HeavyBox>> boxSet2 = new HashSet<>();
        Iterator<HeavyBox> itr = boxSet.iterator();
        while (itr.hasNext()) {
            if (itr.next().getMass() > 300) {
                boxSet2.add(itr);
                itr.remove();
            }
        }
        return boxSet2;
    }
    public static Set<Integer> union(Set<Integer> number1, Set<Integer> number2) {
        HashSet<Integer> union = new HashSet<>(number1);
        union.addAll(number2);
        return union;
    }
    public static Set<Integer> intersect (Set<Integer> number1, Set<Integer> number2) {
        HashSet<Integer> intersect = new HashSet<>(number1);
        intersect.retainAll(number2);
        return intersect;
    }

    @Override
    public String toString() {
        return "HeavyBox{" +
                "mass=" + mass +
                ", id=" + id +
                '}';
    }
    public void setMass(int mass) {
        this.mass = mass;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getMass() {
        return mass;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeavyBox heavyBox = (HeavyBox) o;
        return mass == heavyBox.mass && id == heavyBox.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mass, id);
    }

    @Override
    public int compareTo(Object o) {
        int massHeavyBox = ((HeavyBox) o).getMass();
        return this.mass - massHeavyBox;
    }
}
