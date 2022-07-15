package gameworld.mechanics;

import gameworld.characters.NPC;
import gameworld.characters.Player;
import gameworld.traderdesk.avalaiblegoods.HealingGoods;

public interface Trading {

    String sell(Player player, HealingGoods hp);



}