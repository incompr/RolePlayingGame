package gameworld.traderdesk.avalaiblegoods;

import gameworld.Entity;

public abstract class HealPotion implements HealingGoods{

   final private  int  hitPointToRestore;

    public HealPotion (int hitPointToRestore){
        this.hitPointToRestore=hitPointToRestore;
    }

    public int potionStrength(){
      return  this.hitPointToRestore;
    }


    public void restoreHealth(HealingGoods hp, Entity entity) {
        entity.setHealth(hp);

    }

}
