package lessonProJava.lesson3.interfaces;

public class RockMusicianDemo {
    public static void main(String[] args) {
        Musician musician = new RockMusician();
        Singer singer = new RockMusician();
        Dancer dancer = new RockMusician();

        musician.dance();
        musician.sing();

        singer.sing();

        Singer[] singers = {
                new RockMusician(),
                new PopMusician(),
        };
        singers[0].sing();
        singers[1].sing();

        Singer[] rockMusiciansSing = {
                new RockMusician(),
        };
        Dancer[] rockMusiciansDance = {
                new RockMusician(),
        };


        RockMusicianService service = new RockMusicianService();
        service.singAll(rockMusiciansSing);
        service.danceAll(rockMusiciansDance);
    }
}

