package gameworld;

import gameworld.characters.GameCharacter;
import gameworld.characters.Player;
import gameworld.characters.Trader;
import gameworld.mechanics.Battle;
import gameworld.mechanics.RandomValueGenerator;
import gameworld.traderdesk.avalaiblegoods.BigHealPotion;
import gameworld.traderdesk.avalaiblegoods.SmallHealPotion;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class GameWorld {
    //  private static boolean player;
    private static GameCharacter player = null;
    public static BufferedReader br;
    public static Trader trader;


    public static void main(String[] args) {
        //GameWorld gameWorld = new GameWorld();
        System.out.println("And the world is not Enough");

        br = new BufferedReader(new InputStreamReader(System.in));
        //NPC Generating
        trader = new Trader("Trader", 100, 10000, (byte) 5, (byte) 5, 0);
        //   battle = new Battle();

        System.out.println("Input your character name:");
        try {
            userInput(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void userInput(String consoleInput) throws IOException {

        if (player == null) {
            player = new Player(consoleInput, 100, 15, (byte) 15, (byte) 5, 0);
            System.out.println("Player name is :" + GameWorld.player.getName());
            player.printStatus();
            moveOption();
        }

        //Варианты для команд
        switch (consoleInput) {
            case "1" -> {
                player.isCharacterInShop = true;
                System.out.println("Trader now have only heal potion, big and small, what is your choice:");
                sellOption();
                userInput(br.readLine());
            }
            case "2" -> {
                player.isCharacterInShop = false;
                Battle battle = new Battle((Player) player, RandomValueGenerator.generateMonster());
                battle.fightingWithMonster();

            }
            case "3" -> System.exit(1);
            case "y" -> userInput("2");
            case "n" -> {
                moveOption();
                userInput(br.readLine());
            }
            case "s" -> {
                if (player.isCharacterInShop && player.health < 90) {
                    SmallHealPotion.restoreHealth(new SmallHealPotion(), player);
                    System.out.println(player.printStatus());
                } else if (player.isCharacterInShop && player.health < 100) {
                    player.setHealthPoints(100);
                } else {
                    System.out.println(player.printStatus());
                    System.out.println("HP is Full");
                    player.isCharacterInShop = false;
                    moveOption();
                }

            }
            case "b" -> {
                if (player.isCharacterInShop && player.health < 50) {
                    BigHealPotion.restoreHealth(new BigHealPotion(), player);
                    System.out.println(player.printStatus());
                } else if (player.isCharacterInShop && player.health < 100) {
                    player.setHealthPoints(100);
                } else {
                    System.out.println(player.printStatus());
                    System.out.println("HP is Full");
                    player.isCharacterInShop = false;
                    moveOption();
                }
            }
            case "e" -> {
                if (player.isCharacterInShop) {
                    moveOption();
                }
            }

        }

        userInput(br.readLine());
    }


    private static void moveOption() {
        System.out.println("Where to go?");
        System.out.println("1. Trader");
        System.out.println("2. DarkWood");
        System.out.println("3. Exit");
    }

    private static void sellOption() {
        System.out.println("s. Small one");
        System.out.println("b. Big one");
        System.out.println("e. Exit from shop");

    }


}