package gameworld.traderdesk.avalaiblegoods;

import gameworld.characters.GameCharacter;

public abstract class HealPotion implements HealingGoods{

   final private  int healthPointToRestore;

    public HealPotion (int healthPointToRestore){
        this.healthPointToRestore = healthPointToRestore;
    }

    public int potionStrength(){
      return  this.healthPointToRestore;
    }


    public static void restoreHealth(HealingGoods hp, GameCharacter gameCharacter) {
        gameCharacter.setHealth(hp);

    }

}
