package gameworld.traderdesk.avalaiblegoods;

import gameworld.Entity;

public interface HealingGoods {

     void restoreHealth(HealingGoods hp, Entity entity);

     int potionStrength();


}
