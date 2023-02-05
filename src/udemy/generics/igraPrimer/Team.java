package udemy.generics.igraPrimer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team <T extends Participant> {
    private String name;
    private List<T> participants = new ArrayList<>();

    public Team (String name) {
        this.name = name;
    }
    public void addNewParticipant (T participant) {
        participants.add(participant);
        System.out.println("V komandy " + name + " byl dobavlen novyi" +
                " uchastnik po imeni " + participant.getName());
    }
    public void playWith (Team<T> team) {
        String winnerName;
        Random rnd = new Random();
        int i = rnd.nextInt(2); // 0 и 1
        if (i == 0) {
            winnerName = this.name;
        } else {
            winnerName = team.name;
        }
        System.out.println("Vyigrala komanda " + winnerName);
    }
}
