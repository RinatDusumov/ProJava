package algorithms._2023_03_17.lex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LEX {
    /**
     * expr
     * plus/minus
     * multiply/div
     * factor
     */
    public static void main(String[] args) {
        String expression = "100-2*(4+2*(10-8))";
    }

    // 1. Lexeme Type
    public enum LexemeType {
        LEFT_BRACKET, RIGHT_BRACKET,
        OP_PLUS, OP_MINUS, OP_MUL, OP_DIV,
        NUMBER,
        END;
    }

    // 2. Utility Class
    public static class Lexeme {
        LexemeType type;
        String value;

        public Lexeme(LexemeType type, Character value) {
            this.type = type;
            this.value = value.toString();
        }

        @Override
        public String toString() {
            return "Lexeme{" +
                    "type=" + type +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    // 3. Utility Class 2
    public static class LexemeBuffer {
        private int position;
        public List<Lexeme> lexems;

        public LexemeBuffer(List<Lexeme> lexems) {
            this.lexems = lexems;
        }

        // get Lexemes
        public Lexeme next() {
            return lexems.get(position++);
        }

        // go back
        public void back() {
            position--;
        }

        // current position
        public int getPosition() {
            return position;
        }
    }

    public static List<Lexeme> lexAnalyzer(String expText) {
        ArrayList<Lexeme> lexemes = new ArrayList<>();
        int position = 0;
        // Пока не дошли до конца текста идем по стринге и генерируем лексемы
        while (position < expText.length()) {
            // будем брать каждый символ из стринги и смотреть что это за символ,
            // и далее добавлять его в наш массив лексем
            char с = expText.charAt(position);
        }

        return null;
    }
}