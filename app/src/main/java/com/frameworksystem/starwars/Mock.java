package com.frameworksystem.starwars;

import com.frameworksystem.starwars.model.Droid;
import com.frameworksystem.starwars.model.Film;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felipets on 11/17/15.
 */
public class Mock {



    public static Droid getDroid() {

        Droid droid = new Droid();

        droid.setName("BATTLE DROID");
        droid.setDescription("Rather than use flesh-and-blood warriors, the Separatists prefer mindlessly loyal soldiers that are easily controlled. The soulless ranks of their armies are dominated by tall, thin B1 battle droids built as mechanical imitations of their Geonosian designers.\n\nBattle droids can be controlled by centralized command centers such as the Trade Federation’s enormous Droid Control Ships, or programmed for independent action. They often suffer programming glitches that manifest as personality quirks. Battle droids are dim-witted and no match for clone troopers or Jedi, but they weren’t designed to be smart – they were designed to overwhelm Republic civilians through sheer numbers, something they do very effectively.");
        droid.setLink("http://www.starwars.com/databank/battle-droid");
        droid.setImage("http://img.lum.dolimg.com/v1/images/databank_battledroid_01_169_1524f145.jpeg?region=0%2C0%2C1560%2C878&width=720");

        return droid;
    }

    public static List<Droid> getDroids() {

        List<Droid> droids = new ArrayList<>();

        Droid droid = new Droid();

        droid.setName("BATTLE DROID");
        droid.setDescription("Rather than use flesh-and-blood warriors, the Separatists prefer mindlessly loyal soldiers that are easily controlled. The soulless ranks of their armies are dominated by tall, thin B1 battle droids built as mechanical imitations of their Geonosian designers.\n\nBattle droids can be controlled by centralized command centers such as the Trade Federation’s enormous Droid Control Ships, or programmed for independent action. They often suffer programming glitches that manifest as personality quirks. Battle droids are dim-witted and no match for clone troopers or Jedi, but they weren’t designed to be smart – they were designed to overwhelm Republic civilians through sheer numbers, something they do very effectively.");
        droid.setLink("http://www.starwars.com/databank/battle-droid");
        droid.setImage("http://img.lum.dolimg.com/v1/images/databank_battledroid_01_169_1524f145.jpeg?region=0%2C0%2C1560%2C878&width=720");

        Droid droid2 = new Droid();

        droid2.setName("PROTOCOL DROID");
        droid2.setDescription("Protocol droids are vital in smoothing differences encountered by the many farflung cultures interacting on a regular basis throughout the galaxy. Programmed in etiquette and equipped with formidable language skills, protocol droids assist diplomats and politicians and also serve as administrative aides and companions for high-ranking officials. They come in many shapes and sizes, but most are humanoid, like the company they keep.");
        droid2.setLink("http://www.starwars.com/databank/protocol-droid");
        droid2.setImage("http://img.lum.dolimg.com/v1/images/protocol_droid_6ddeb574.jpeg?region=243%2C0%2C1447%2C814&width=768");

        Droid droid3 = new Droid();

        droid3.setName("ASTROMECH DROID");
        droid3.setDescription("Astromech droids are a series of versatile utility robots generally used for the maintenance and repair of starships and related technology. These small droids are often equipped with a variety of tool-tipped appendages that are stowed in recessed compartments. The R2 unit is a popular example of an astromech droid.");
        droid3.setLink("http://www.starwars.com/databank/astromech-droid");
        droid3.setImage("http://img.lum.dolimg.com/v1/images/databank_astromechdroid_01_169_9d9b98b1.jpeg?region=155%2C238%2C1139%2C640&width=720");

        droids.add(droid);
        droids.add(droid2);
        droids.add(droid3);

        return droids;
    }

    public static List<Film> getFilms() {

        List<Film> films = new ArrayList<>();

        Film film = new Film();
        film.setName("STAR WARS: EPISODE VI RETURN OF THE JEDI");
        film.setDescription("Luke Skywalker heads a mission to rescue Han Solo from the clutches of Jabba the Hutt, and faces Darth Vader one last time.");
        film.setLink("http://www.starwars.com/films/star-wars-episode-vi-return-of-the-jedi/");
        film.setImage("http://img.lum.dolimg.com/v1/images/Star-Wars-Return-Jedi-VI-Poster_a10501d2.jpeg?region=12%2C9%2C618%2C982&width=480");
        films.add(film);

        Film film2 = new Film();
        film2.setName("STAR WARS: EPISODE V THE EMPIRE STRIKES BACK");
        film2.setDescription("After the destruction of the Death Star, the Empire has regrouped -- with Darth Vader leading the hunt for Luke Skywalker.");
        film2.setLink("http://www.starwars.com/films/star-wars-episode-v-the-empire-strikes-back");
        film2.setImage("http://img.lum.dolimg.com/v1/images/Star-Wars-Empire-Strikes-Back-V-Poster_878f7fce.jpeg?region=31%2C272%2C603%2C302&width=480");
        films.add(film2);

        Film film3 = new Film();
        film3.setName("STAR WARS: EPISODE IV A NEW HOPE");
        film3.setDescription("Luke Skywalker begins a journey that will change the galaxy, as he leaves his home planet, battles the evil Empire, and learns the ways of the Force.");
        film3.setLink("http://www.starwars.com/films/star-wars-episode-iv-a-new-hope");
        film3.setImage("http://img.lum.dolimg.com/v1/images/Star-Wars-New-Hope-IV-Poster_c217085b.jpeg?region=49%2C43%2C580%2C914&width=480");
        films.add(film3);


        Film film4 = new Film();
        film4.setName("STAR WARS: EPISODE III REVENGE OF THE SITH");
        film4.setDescription("Faced with haunting premonitions that his secret wife, Padmé Amidala, will die, Anakin Skywalker is seduced by the dark side.");
        film4.setLink("http://www.starwars.com/films/star-wars-episode-iii-revenge-of-the-sith");
        film4.setImage("http://img.lum.dolimg.com/v1/images/Star-Wars-Revenge-Sith-III-Poster_646108ce.jpeg?region=61%2C329%2C634%2C319&width=480");
        films.add(film4);


        Film film5 = new Film();
        film5.setName("STAR WARS: EPISODE II ATTACK OF THE CLONES");
        film5.setDescription("Padawan Anakin Skywalker must choose between his Jedi duty and forbidden love, while Obi-Wan Kenobi uncovers a sinister plot that leads to war.");
        film5.setLink("http://www.starwars.com/films/star-wars-episode-ii-attack-of-the-clones");
        film5.setImage("http://img.lum.dolimg.com/v1/images/Star-Wars-Attack-Clones-II-Poster_53baa2e7.jpeg?region=0%2C136%2C678%2C339&width=480");
        films.add(film5);


        Film film6 = new Film();
        film6.setName("STAR WARS: EPISODE I THE PHANTOM MENACE");
        film6.setDescription("Anakin Skywalker, a young slave strong with the Force, is discovered on Tatooine. Meanwhile, the evil Sith have returned, enacting their plot for revenge against the Jedi.");
        film6.setLink("http://www.starwars.com/films/star-wars-episode-i-the-phantom-menace");
        film6.setImage("http://img.lum.dolimg.com/v1/images/Star-Wars-Phantom-Menace-I-Poster_3c1ff9eb.jpeg?region=15%2C9%2C651%2C979&width=480");
        films.add(film6);

        return films;

    }
}
