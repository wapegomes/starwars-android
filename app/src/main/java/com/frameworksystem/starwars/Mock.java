package com.frameworksystem.starwars;

import com.frameworksystem.starwars.model.Droid;

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
}
