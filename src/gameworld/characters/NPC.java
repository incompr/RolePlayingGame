package gameworld.characters;

public abstract class NPC extends GameCharacter {


    public NPC(String name, int health, int goldAmount, byte agility, byte strength, int exp) {
        super(name, health, goldAmount, agility, strength, exp);
    }

}
