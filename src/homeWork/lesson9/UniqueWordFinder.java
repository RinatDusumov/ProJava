package homeWork.lesson9;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class UniqueWordFinder {
    public static void main(String[] args) {
        String str = "aaaa aaaa cg bbb bbb aaaa bbb";
        String[] unigueText = find(str).toArray(new String[0]);
        for (String s : unigueText) {
            System.out.print(s + " ");
        }
    }
    static Set<String> find(String text) {
        String[] strArray = text.split(" ");
        Set<String> set = new HashSet<>();
        for (int i = 0; i < strArray.length; i++) {
            for (int j = 0; j < strArray.length; j++) {
                if (i == j) {
                    continue;
                }
                if (!strArray[i].equals(strArray[j])) {
                    set.add(strArray[j]);
                }
            }
        }
        return set;
    }
}
