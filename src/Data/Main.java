package Data;

import Data.PokemonList.Bulbasaur;
import Data.PokemonList.Caterpie;
import Data.PokemonList.Chansey;
import Data.PokemonList.Charmander;
import Data.PokemonList.Clefairy;
import Data.PokemonList.Dratini;
import Data.PokemonList.Eevee;
import Data.PokemonList.Ekans;
import Data.PokemonList.Electabuzz;
import Data.PokemonList.Machop;
import Data.PokemonList.Magikarp;
import Data.PokemonList.Magmar;
import Data.PokemonList.Mew;
import Data.PokemonList.Nidoran;
import Data.PokemonList.Pikachu;
import Data.PokemonList.Pinsir;
import Data.PokemonList.Rattata;
import Data.PokemonList.Sandshrew;
import Data.PokemonList.Squirtle;
import Data.PokemonList.Tangela;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.HashMap;

public class Main {
    
    static Pokemon generatePoke(int randMin, int randMax) {
        //Select a random pokemon with a level between randMin and randMax and return it.
        int randRange = (randMax - randMin) + 1;
        int randId = (int)(Math.random() * 20);
        int randLevel = (int)(Math.random() * randRange + randMin);
        HashMap<Integer, Pokemon> pokeList = new HashMap<>();
        pokeList.put(0, new Bulbasaur(randLevel));
        pokeList.put(1, new Caterpie(randLevel));
        pokeList.put(2, new Chansey(randLevel));
        pokeList.put(3, new Charmander(randLevel));
        pokeList.put(4, new Clefairy(randLevel));
        pokeList.put(5, new Dratini(randLevel));
        pokeList.put(6, new Eevee(randLevel));
        pokeList.put(7, new Ekans(randLevel));
        pokeList.put(8, new Electabuzz(randLevel));
        pokeList.put(9, new Machop(randLevel));
        pokeList.put(10, new Magikarp(randLevel));
        pokeList.put(11, new Magmar(randLevel));
        pokeList.put(12, new Mew(randLevel));
        pokeList.put(13, new Nidoran(randLevel));
        pokeList.put(14, new Pikachu(randLevel));
        pokeList.put(15, new Pinsir(randLevel));
        pokeList.put(16, new Rattata(randLevel));
        pokeList.put(17, new Sandshrew(randLevel));
        pokeList.put(18, new Squirtle(randLevel));
        pokeList.put(19, new Tangela(randLevel));
        if(pokeList.containsKey(randId)) return pokeList.get(randId);
        //If pokemon id fails return element 0 (Bulbasaur).
        else return pokeList.get(0);
    }
    
    static void init(Player player, Queue <Trainer> trainers) {
        //Fill player's party with pokemon level 15 to 35.
        int minLevel = 15; 
        int maxLevel = 35;
        for(int i = 0; i < 6; i++) {
            player.addPoke(generatePoke(minLevel, maxLevel));
        }
        //Create trainers.
        trainers.add(new Trainer("Brock"));
        trainers.add(new Trainer("Misty"));
        trainers.add(new Trainer("Lt. Surge"));
        trainers.add(new Trainer("Erika"));
        trainers.add(new Trainer("Koga"));
        trainers.add(new Trainer("Sabrina"));
        trainers.add(new Trainer("Blaine"));
        trainers.add(new Trainer("Giovanni"));
        //Fill trainer's parties with pokemon appropriate for their stage.
        for(int i = 0; i < 8; i++) {
            Trainer tempTrainer = trainers.poll();
            minLevel += 5;
            maxLevel += 5;
            for(int j = 0; j < 6; j++) {
                tempTrainer.addPoke(generatePoke(minLevel, maxLevel));
            }
            trainers.add(tempTrainer);
        }
    }

    static Player player = new Player();
    static Queue <Trainer> trainers = new ArrayDeque();
    
    public static void main(String[] args) {
        init(player, trainers);
    }
}

//int randVal = (int)(Math.random() * (Range+1) + Min);