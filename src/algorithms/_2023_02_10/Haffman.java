package algorithms._2023_02_10;
/** алгоритмы сжатия */



import java.util.TreeMap;

public class Haffman {
    public static void main(String[] args) {
        String text = "fb vbh ghdfkjgregh mcvn uivtrhg kdnre gnry";
        // Сколько каждый символ встречается в тексте
    }
    private static TreeMap<Character, Integer> countFrequency(String text) {
        TreeMap<Character, Integer> freqMap = new TreeMap<>();
        for (int i = 0; i < text.length(); i++) {
            Character c = text.charAt(i);
            Integer count = freqMap.get(c);
            freqMap.put(c, count != null ? count + 1 : 1);
        }
        return freqMap;
    }
    // Класс для предоставления кодового дерева
    private static class CodeTreeNode implements Comparable<CodeTreeNode> {
        Character content;
        int weight;
        CodeTreeNode left;
        CodeTreeNode right;

        @Override
        public int compareTo(CodeTreeNode o) {
            // o1.compareTo(o2)
            return o.weight - weight;
        }

        public CodeTreeNode(Character content, int weight) {
            this.content = content;
            this.weight = weight;
        }

        public CodeTreeNode(Character content, int weight, CodeTreeNode left, CodeTreeNode right) {
            this.content = content;
            this.weight = weight;
            this.left = left;
            this.right = right;
        }


    }
}
