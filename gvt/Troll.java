package gvt;

public abstract class Troll {
        private final String name;
        private final int maxHP;
        private int currentHP;
        private final double regenAmount;
 
        public Troll(String name, int maxHP, double regenAmount) {
            this.name = name;
            this.maxHP = maxHP;
            this.currentHP = maxHP;
            this.regenAmount = regenAmount;
        }

        public String getName() {
            return name;
        }

        public int getMaxHP() {
            return maxHP;
        }

        public int getCurrentHP() {
            return currentHP;
        }

        public boolean isVanquished() {
            return currentHP <= 0;
        }

        public void regenerate() {
            if(!isVanquished()) {
                this.currentHP += (int)(this.maxHP * regenAmount);
            }
        }

        public abstract Attack attack();

        public abstract void takeDamage(Attack attack);

        protected void deductHP(int amount) {
            currentHP -= amount;
            if(currentHP < 0) {
                currentHP = 0;
            }
            System.out.println ("\t" + name + " takes " + amount + " damage (HP: " + currentHP + ")");
        }

}
