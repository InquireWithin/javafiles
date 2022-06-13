package gvt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Mage extends Goat {

    /**
     * Example of using the Ability interface
     */
    private static class BasicAttack implements Ability {
        @Override
        public void use(List<Troll> enemies, List<Goat> party) {
            Goat.basicAttack(enemies, party);
        }
    }
    //the mage's punch is weaker and more selective than the more buff classes
    //this is a common thing in game design for a ranged class to be weaker in cqc

    /*
    added ability punch, relies on anonymous class and interior lambda
    selects the first alive enemy of the enemies list, hits it twice
    */
    private static Ability staffPunch = new Ability(){
        @Override
        public void use(List<Troll> enemies, 
                      List<Goat> party) {
        Troll target = getRandomTarget (
            enemies.stream().filter(e -> enemies.indexOf(e) < 1).collect(Collectors.toList()));
        int [] hits = {2};
        Attack attack = new Attack("", hits, DamageType.PHYSICAL);
        target.takeDamage (attack);
        removeVanquished (enemies, target);
                      }
    };
    private static Ability magicMissles = (enemies, party) -> {
        Random r = new Random();
        List<Attack> li = new ArrayList<>();
        for(int i =0;i<4;i++) {
            if(enemies.size() == 0) {break;}
            int a = r.nextInt(enemies.size());
            int[] hits = {12};
            Attack at = new Attack("",hits, DamageType.MAGICAL);
            enemies.get(a).takeDamage(at);
            removeVanquished(enemies, enemies.get(a));
        }
        
    };
    /**
     * Mage ability list. There is one list for all mages.
     */
    
    private static final Map <String, Ability> abilities = new HashMap<> ();
    static {
        /**
         * Add new abilities in here
         */
        abilities.put("Staff Attack", Goat::basicAttack);
        abilities.put("Magic Missles", magicMissles);
        abilities.put("Punch", punch);
    }

    public Mage(String name) {
        super(name, 100, abilities);
    }

    public Attack attack() {
        int[] hits = {9, 9, 9, 9};
        return new Attack("Magic Missiles", hits, DamageType.MAGICAL);
    }

    public void takeDamage(Attack attack) {
        double adjustment = 1.0;
        DamageType type = attack.getDamageType();
        if(type == DamageType.MAGICAL) {
            adjustment = 0.75;
        } else if(type == DamageType.PHYSICAL) {
            adjustment = 1.25;
        }
        takeDamage(attack, adjustment);
    }
}
