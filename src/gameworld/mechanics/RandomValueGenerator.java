package gameworld.mechanics;

import gameworld.characters.GameCharacter;
import gameworld.characters.monsters.Goblin;
import gameworld.characters.monsters.Skeleton;

public class RandomValueGenerator {

    public static int generateRandom() {
        return ((int) (Math.random() * 100));
    }

    public static GameCharacter generateMonster() {

        if (((int) (Math.random() * 100)) > 50)
            return new Goblin(40, 10, (byte) 10, (byte) 100, 2);

        else
            return new Skeleton( 20, 5, (byte) 20, (byte) 100, 1);

    }

}
