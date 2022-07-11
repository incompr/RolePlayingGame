package gameworld.traderdesk;


import gameworld.Entity;
import gameworld.traderdesk.avalaiblegoods.HealPotion;


public class SmallHealPotion extends HealPotion {

    int hitPointToRestore=10;




    @Override
    public void restoreHealth(Entity entity) {
        entity.setHealth(this);

    }
}
