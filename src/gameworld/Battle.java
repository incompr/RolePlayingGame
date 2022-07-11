package gameworld;

public class Battle implements Runnable{

    public void battle(Entity entity, Player player){

        //who attack first
    entity.attack();
    player.attack();


    }


    @Override
    public void run() {
        battle();

    }

}
