package gvt;

public class Trolling extends Troll {
    private static final int MAX_HP = 38;
    private static final double REGEN_AMOUNT = 0.03;

    public Trolling() {
        super("Trolling", MAX_HP, REGEN_AMOUNT);
    }

    @Override
    public Attack attack() {
        int[] hits = {25};
        System.out.println (getName () + " attacks with U Mad?!");
        return new Attack("U Mad?", hits, DamageType.MAGICAL);
    }

    @Override
    public void takeDamage(Attack attack) {
        double modifier = 1.0;
        if(attack.getDamageType() == DamageType.MAGICAL) {
            modifier = 1.25;
        }

        int[] hits = attack.getHits();
        for(int i=0; i<hits.length; i++) {
            int amount = (int)(hits[i] * modifier);
            deductHP(amount);
        }

    }
}
