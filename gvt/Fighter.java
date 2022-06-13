package gvt;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class Fighter extends Goat {
    /**
     * Example of using the Ability interface
     */
    private static class BasicAttack implements Ability {
        @Override
        public void use(List<Troll> enemies, List<Goat> party) {
            Goat.basicAttack(enemies, party);
        }
    }
    private static Ability Cleave = (enemies, party) -> {
        List<Troll> enemyCopy = new ArrayList<>();
        enemyCopy = enemies;
        Random ra = new Random();
        for(int b = 0;b<enemies.size();b++) {
            if (b == 0) {
                int next = ra.nextInt(enemyCopy.size());
                int[] hits = {25};
                enemyCopy.get(next).takeDamage(new Attack ("",hits,DamageType.PHYSICAL));
                enemyCopy.remove(enemyCopy.get(next));
            }
            else{
                int next = ra.nextInt(enemyCopy.size());
                int[] hits = {12};
                enemyCopy.get(next).takeDamage(new Attack ("",hits,DamageType.PHYSICAL));
                enemyCopy.remove(enemyCopy.get(next));
            }
        }
    
    };
    //Added new ability "Guillotine". Does a single clean blow against a random troll
    //if that troll becomes vanquished as a direct result of guillotine, strike
    //another random troll for 20. this effect cant happen more than once per use.

    private static Ability Guillotine = (enemies, party) -> {

        Troll target = getRandomTarget(enemies);
        int[] hits = {40};
        target.takeDamage(new Attack("", hits, DamageType.PHYSICAL));
        
        if(target.isVanquished()) {
            removeVanquished(enemies, target);
            target = getRandomTarget(enemies);
            int[] secondHits = {20};
            target.takeDamage(new Attack("",secondHits,DamageType.PHYSICAL));
            removeVanquished(enemies, target);
        }
        };


    /**
     * Fighter ability list. There is one list for all fighters.
     */
    private static final Map <String, Ability> abilities = new HashMap<> ();

    static {
        /**
         * Add new abilities in here
         */
        abilities.put ("Punch", punch);
        abilities.put("Cleave", Cleave);
        abilities.put("Guillotine", Guillotine);
        abilities.put("Basic",Goat::basicAttack);
    }

    public Fighter(String name) {
        super(name, 150, abilities);
    }
    
    @Override
    public Attack attack() {
        int[] hits = {25};
        return new Attack("Cleave", hits, DamageType.PHYSICAL);
    }

    @Override
    public void takeDamage(Attack attack) {
        double adjustment = 1.0;
        DamageType type = attack.getDamageType();
        if(type == DamageType.MAGICAL) {
            adjustment = 1.25;
        } else if(type == DamageType.PHYSICAL) {
            adjustment = 0.75;
        }
        takeDamage(attack, adjustment);
    }
}
