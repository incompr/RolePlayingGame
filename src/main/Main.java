/*package main;

import gameworld.GameWorld;
import gameworld.characters.GameCharacter;
import gameworld.characters.Player;
import gameworld.characters.Trader;
import gameworld.mechanics.Battle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
   public static BufferedReader br;

    private static Battle battle = null;


    public static void main(String[] args) {
        GameWorld gameWorld = new GameWorld();
        System.out.println("And the world is not Enough");
        //NPC Generating
        Trader trader = new Trader("Trader", 100, 10000, (byte) 5, (byte) 5, 0);

        br = new BufferedReader(new InputStreamReader(System.in));
        battle = new Battle();

        System.out.println("Input your character name:");
        try {
            GameWorld.userInput(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

*/

