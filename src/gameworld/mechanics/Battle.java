package gameworld.mechanics;

import gameworld.GameWorld;
import gameworld.characters.GameCharacter;
import gameworld.characters.Player;

import java.io.IOException;

import static gameworld.GameWorld.br;
import static gameworld.GameWorld.userInput;

public class Battle {
    Player gc1;
    GameCharacter gc2;

    public Battle(Player player, GameCharacter monster) {
        this.gc1 = player;
        this.gc2 = monster;

    }

    public void fightingWithMonster() {
        Runnable battleThread = () -> {
            int turn = 1;

            boolean isFightEnded = false;
            while (!isFightEnded) {
                System.out.println("********** Turn " + turn + " ***********");

                if (turn++ % 2 != 0) {
                    isFightEnded = makeHit(gc2, gc1);
                } else {
                    isFightEnded = makeHit(gc1, gc2);
                }
                try {


                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        Thread thread = new Thread(battleThread);
        thread.start();
    }

    private Boolean makeHit(GameCharacter gameCharacter1, GameCharacter gameCharacter2) {

        int hit = gameCharacter2.attack();
        int defenderHealth = gameCharacter1.getHealthPoints() - hit;

        if (hit != 0) {
            System.out.printf("%s Hit by %d HP!%n", gameCharacter2.getName(), hit);
            System.out.printf("%s has %d HP...%n", gameCharacter1.getName(), defenderHealth);
        } else {

            System.out.printf("%s Miss!%n", gameCharacter2.getName());
        }
        if (defenderHealth <= 0 && gameCharacter1 instanceof Player) {


            System.out.println("You are loose the game");

            Battle.fightLost();
            return true;
        } else if (defenderHealth <= 0) {

            System.out.printf("You Win! exp + %d, gold + %d %n", gc2.getXp(), gc2.getGold());
            gc1.setXp(gc1.getXp() + gc2.getXp());
            gc1.setGold(gc1.getGold() + gc2.getGold());
            System.out.println(gameCharacter2.printStatus());


            fightWin();

            return true;
        } else {

            gameCharacter1.setHealthPoints(defenderHealth);
            return false;
        }

    }

    public void fightWin() {

        System.out.printf("%s win! +%d exp +%d gold, player status: %d HP%n", gc1.getName(), gc2.getXp(), gc2.getGold(), gc1.health);
        this.gc1 = null;
        this.gc2 = null;
        System.out.println("continue or return to Town? (y/n)");
        try {
            userInput(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void fightLost() {
        System.out.println("Game is over");
        System.exit(1);
    }


}