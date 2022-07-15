package gameworld.characters;

import gameworld.mechanics.Fighting;
import gameworld.mechanics.RandomValueGenerator;
import gameworld.traderdesk.avalaiblegoods.HealingGoods;

public abstract class GameCharacter implements Fighting {


    public boolean isCharacterInShop;

    protected String name;

    public int health;
    int goldAmount;
    byte agility;
    int exp;
    byte strength;


    public GameCharacter(String name, int health, int goldAmount, byte agility, byte strength, int exp) {
        this.name = name;
        this.health = health;
        this.goldAmount = goldAmount;
        this.agility = agility;
        this.exp = exp;
        this.strength = strength;
    }

    public GameCharacter(int health, int goldAmount, byte agility, byte strength, int exp) {
        this.health = health;
        this.goldAmount = goldAmount;
        this.agility = agility;
        this.exp = exp;
        this.strength = strength;
    }


    public int attack() {
        if ((RandomValueGenerator.generateRandom() < 3) && this.agility * 3 > RandomValueGenerator.generateRandom()) {
            return this.strength * 2;
        } else if (this.agility * 3 > RandomValueGenerator.generateRandom()) {
            return this.strength;
        } else return 0;

    }


    // public GameCharacter create() ;


    public void setHealth(HealingGoods hp) {
        this.health += hp.potionStrength();
    }

    protected void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }


    public String printStatus() {
        return this.getName() + ", " + "exp: " + this.exp + ", gold: " + this.goldAmount + ", HP: " + this.health + ", Strength: " + this.strength + ", Agility: " + this.agility;

    }


    @Override
    public String toString() {
        return "Name: " + name + " Health Points: " + this.health;
    }

    public int getXp() {
        return this.exp;
    }

    public int getGold() {
        return this.goldAmount;
    }

    public int getHealthPoints() {
        return this.health;
    }

    public void setHealthPoints(int healthPoints) {
        this.health = healthPoints;

    }

    public void setXp(int exp) {
        this.exp += exp;

    }

    public void setGold(int gold) {
        this.goldAmount += gold;

    }
}
