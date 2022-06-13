package gvt;

public class Attack {
    private final String name;
    private final int[] hits;
    private final DamageType type;

    public Attack(String name, int[] hits, DamageType type) {
        this.name = name;
        this.hits = hits;
        this.type = type;
    }

    public DamageType getDamageType() {
        return type;
    }

    public int[] getHits() {
        return hits;
    }

    public String getName() {
        return name;
    }
}
