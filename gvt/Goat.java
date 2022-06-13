package gvt;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Goat {
    private final String name;
    private final int maxHP;
    private int currentHP; // could be protected
    private Map <String, Ability> abilities;
    private static final Random random = new Random ();

    public Goat(String name, int maxHP) {
        this.name = name;
        this.maxHP = maxHP;
        currentHP = maxHP;
        abilities = null;
    }

    public Goat(String name, int maxHP, Map <String, Ability> abilities) {
        this.name = name;
        this.maxHP = maxHP;
        currentHP = maxHP;
        this.abilities = abilities;
    }

    public String getName() {
        return name;
    }

    public int getMaxHp() {
        return maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public abstract Attack attack ();

    /**
     * New attack which randomly selects and ability and uses it
     * 
     * @param enemies List of all un-vanquished enimies
     * @param party List of all consious party memebers
     */
    public void attack (List<Troll> enemies, List<Goat> party) {
        String abilityName = getRandomAbility (abilities.keySet());
        System.out.println (getName () + " uses the " + abilityName + " ability!");
        abilities.get (abilityName).use (enemies, party);
    }

    public abstract void takeDamage(Attack attack);
    
    public boolean isConscious() {
        return currentHP > 0;
    }

    public void heal(int amount) {
        currentHP += amount;
        currentHP = currentHP < maxHP ? currentHP : maxHP;
    }

    protected void takeDamage(Attack attack, double adjustment) {
        // two ways to solve this, either make currentHP a protected
        // field or add a helper method; I prefer this way
        int amount = 0;
        for(int hit : attack.getHits()) {
            amount += (int)(hit * adjustment);
        }

        currentHP -= amount;
        currentHP = currentHP > 0 ? currentHP : 0;
        System.out.println ("\t" + name + " takes " + amount + " damage (HP: " + currentHP + ")");
    }

    /**
     * Help method to randomly choose an ability from the abilities Map
     * 
     * @param abilities Keys in the abilities Map
     * @return Name of the ability that was chosen
     */
    protected static String getRandomAbility (Set <String> abilities) {
        Random random = new Random ();
        String abilityName = "";
        int ability_index = random.nextInt (abilities.size ());
        int count = 0;
        for (String ability : abilities){
            if (count == ability_index) {
                abilityName = ability;
                break;
            }
            count++;
        }
        return abilityName;
    }

    /**
     * Helper method to select a random target.
     * 
     * @param targets List of enemy targets
     * @return Selected enemy target
     */
    protected static Troll getRandomTarget (List<Troll> targets) {
        int index = random.nextInt (targets.size ());
        Troll target = targets.get (index);
        return target;
    }
    
    /**
     * Generic basic attacks. Doubles as an illustration of how to use the 
     * new attack system.
     * 
     * @param enemies List of enemies
     * @param party List of party memebers
     */
    protected static void basicAttack (List<Troll> enemies, List<Goat> party) {
        Troll target = getRandomTarget (enemies);
        int [] hits = {10};
        target.takeDamage (new Attack ("", hits, DamageType.PHYSICAL));
        removeVanquished (enemies, target);
    }
    /*
    added ability punch, relies on anonymous class
    selects a random enemy out of the first HALF of the enemies list, 4x hit
    */
    protected static Ability punch = new Ability() {
        
        @Override
        public void use(List<Troll> enemies, 
                      List<Goat> party) {
        if(enemies.size() == 0) {return;}
        Troll target = getRandomTarget (
            enemies.stream().filter(e -> enemies.indexOf(e) <= enemies.size()/2).collect(Collectors.toList()));
        int [] hits = {15};
        Attack attack = new Attack("", hits, DamageType.PHYSICAL);
        target.takeDamage (attack);
        removeVanquished (enemies, target);
        
      }
    };
    

    /**
     * Helper method to remove a target if it was defeated.
     * 
     * @param enemies List of enemies
     * @param target Enemy to check for removal from enemies List
     */
    protected static void removeVanquished (List<Troll> enemies, Troll target) {
        if (target.isVanquished()) {
            enemies.remove (target);
            System.out.println ("\t" + target.getName() + " has been vanquished!");
        }
    }
    
    @Override
    public String toString() {
        return "Goat: " + getName() + " Current HP: " + getCurrentHP();
    }

}
