package gameworld.characters.monsters;


import gameworld.characters.GameCharacter;

public class Goblin extends GameCharacter{

    public Goblin(int health, int goldAmount, byte agility,byte strength, int exp ){
        super( health, goldAmount, agility, strength, exp);
        this.setName("Goblin");
    }





}