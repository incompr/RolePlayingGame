package gameworld.characters.monsters;

import gameworld.characters.GameCharacter;

public class Skeleton extends GameCharacter {

    public Skeleton(int health, int goldAmount, byte agility,byte strength, int exp ){
        super( health, goldAmount, agility, strength, exp);
        this.setName("Skeleton");
    }
}
