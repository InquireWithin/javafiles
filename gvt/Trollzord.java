package gvt;

public class Trollzord extends Troll {
    private static final int MAX_HP = 64;
    private static final double REGEN_AMOUNT = 0.05;

    public Trollzord() {
        super("Trollzord", MAX_HP, REGEN_AMOUNT);
    }

    @Override
    public Attack attack() {
        int[] hits = {25};
        System.out.println (getName () + " attacks with Flame War!");
        return new Attack("Flame War", hits, DamageType.MAGICAL);
    }

    @Override
    public void takeDamage(Attack attack) {
        double modifier = 1.0;
        if(attack.getDamageType() == DamageType.HOLY) {
            modifier = 1.25;
        }

        int[] hits = attack.getHits();
        for(int i=0; i<hits.length; i++) {
            int amount = (int)(hits[i] * modifier);
            deductHP(amount);
        }

    }   
}
