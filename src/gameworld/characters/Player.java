package gameworld.characters;

public class Player extends GameCharacter {



    // private String name;


    public Player(String name, int health, int goldAmount, byte agility, byte strength, int exp) {
        super(health, goldAmount, agility, strength, exp);
        this.setName(name);

    }




    public void setName(String name) {
        this.name = name;
    }
}
