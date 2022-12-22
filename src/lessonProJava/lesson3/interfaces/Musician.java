package lessonProJava.lesson3.interfaces;

import lessonProJava.lesson3.interfaces.Dancer;
import lessonProJava.lesson3.interfaces.Singer;

public interface Musician extends Dancer, Singer {
    void playMusic();
}
