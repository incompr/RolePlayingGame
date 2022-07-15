package gameworld.mechanics;

import gameworld.GameWorld;
import gameworld.characters.GameCharacter;
import gameworld.characters.Player;

import java.io.IOException;

import static gameworld.GameWorld.br;
import static gameworld.GameWorld.userInput;

public class Battle {


    static Player gc1;
    static GameCharacter gc2;


    public Battle(Player player, GameCharacter monster) {
        gc1 = player;
        gc2 = monster;

    }


    public static void fightingWithMonster() {
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

    private static Boolean makeHit(GameCharacter gameCharacter1, GameCharacter gameCharacter2) {

        int hit = gameCharacter1.attack();
        int defenderHealth = gameCharacter1.getHealthPoints() - hit;

        if (hit != 0) {
            System.out.printf("%s Hit by %d HP!%n", gameCharacter2.getName(), hit);
            System.out.printf("%s has %d HP...%n", gameCharacter1.getName(), defenderHealth);
        } else {

            System.out.printf("%s Miss!%n", gameCharacter1.getName());
        }
        if (defenderHealth <= 0 && gameCharacter1 instanceof Player) {


            System.out.println("You are loose the game");

            Battle.fightLost();
            return true;
        } else if (defenderHealth <= 0) {

            System.out.printf("You Win! exp + %d, gold %d %n", gameCharacter2.getXp(), gameCharacter2.getGold());
            // System.out.println(gameCharacter1.printStatus());

            gameCharacter2.setXp(gameCharacter1.getXp() + gameCharacter2.getXp());
            gameCharacter2.setGold(gameCharacter1.getGold() + gameCharacter2.getGold());
            System.out.println(gameCharacter2.printStatus());


            fightWin();
            return true;
        } else {

            gameCharacter1.setHealthPoints(defenderHealth);
            return false;
        }

    }

    //      gameCharacter.attack();
    //    player.attack();

    public static void fightWin() {
        System.out.printf("%s win! +%d exp +%d gold, status: %d HP%n", gc1.getName(), gc1.getXp(), gc1.getGold(), gc1.health);
        System.out.println("continue or return to Town? (Y/N)");
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