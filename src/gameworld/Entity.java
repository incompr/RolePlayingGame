package gameworld;

import gameworld.traderdesk.avalaiblegoods.HealPotion;
import gameworld.traderdesk.avalaiblegoods.HealingGoods;

public class Entity {
    String name;

    public int health;
    int goldAmount;
    byte agility;
    int exp;
    byte strength;

    public void attack() {
      //  sucsess attack -agility
       // critical attack -strength * 2
    }

    public void setHealth(HealingGoods hp) {
        this.health+=hp.hitPointToRestore;
    }



}
