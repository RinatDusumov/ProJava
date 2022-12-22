package homeWork.homeWorkTwo;

public class Player extends PokerTable {
    public Player(String name, String card) {
        super.name = name;
        super.card = card;
    }

    @Override
    public String toString() {
        return "Карты игрока: " + name + " " + card;
    }
}
