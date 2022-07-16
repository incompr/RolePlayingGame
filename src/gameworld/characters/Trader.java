package gameworld.characters;

import gameworld.mechanics.Trading;
import gameworld.traderdesk.avalaiblegoods.HealingGoods;

import java.util.ArrayList;
import java.util.List;

public class Trader extends NPC implements Trading {

    /*for future use*/
    List<String> traderDesk = new ArrayList<>();


    public Trader(String name, int health, int goldAmount, byte agility, byte strength, int exp) {
        super(name, health, goldAmount, agility, strength, exp);

    }

    @Override
    public String sell(Player player, HealingGoods hp) {
        return null;
    }

}
