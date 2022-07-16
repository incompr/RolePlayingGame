package gameworld.characters;

public class Player extends GameCharacter {

    public Player(String name, int health, int goldAmount, byte agility, byte strength, int exp) {
        super(health, goldAmount, agility, strength, exp);
        this.name = name;

    }

}
