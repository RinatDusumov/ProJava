package lessonProJava.lesson3.interfaces;

public class RockMusicianService {
    public void singAll (Singer[] rockMusicians) {
        for (int i = 0; i < rockMusicians.length; i++) {
            rockMusicians[i].sing();
        }
    }
    public void danceAll (Dancer[] rockMusician) {
        for (int i = 0; i < rockMusician.length; i++) {
            rockMusician[i].dance();
        }
    }
}
