package main.java.students.rinat_dusumov.homeWork._25_01_2023;

import java.util.Objects;

public class HeavyBox implements Comparable<HeavyBox> {
    private int length, height, width, weight;

    public HeavyBox(int length, int height, int width, int weight) {
        this.length = length;
        this.height = height;
        this.width = width;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "HeavyBox{" +
                "length=" + length +
                ", height=" + height +
                ", width=" + width +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeavyBox heavyBox = (HeavyBox) o;
        return length == heavyBox.length && height == heavyBox.height && width == heavyBox.width && weight == heavyBox.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, height, width, weight);
    }

    @Override
    public int compareTo(HeavyBox o) {
        return this.height - o.height;
    }
}