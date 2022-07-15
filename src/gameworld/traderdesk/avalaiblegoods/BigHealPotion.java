package gameworld.traderdesk.avalaiblegoods;


public class BigHealPotion extends HealPotion {

   static int hitPointToRestore=50;

    public BigHealPotion() {
        super(hitPointToRestore);
    }


//    @Override
//    public void restoreHealth(HealingGoods hp, Entity entity) {
//        entity.setHealth(this);
//
//    }
}
