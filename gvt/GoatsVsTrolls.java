package gvt;

/**
 * Game logic for Goats Vs Trolls battle simulation.
 */



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GoatsVsTrolls {
    private static final int HORDE_SIZE = 6;

    public static void main(String[] args) {
        List <Goat> party = new ArrayList<> ();
        List <Troll> horde = new ArrayList<> ();
        Random random = new Random ();

        party.add (new Fighter ("Thurstwig"));
        party.add (new Mage ("Dandilion"));
        party.add (new Fighter ("Player123456"));
        party.add (new Mage ("MagesRock"));

        int num_ling = random.nextInt (HORDE_SIZE);
        for (int i = 0; i < num_ling; i++) {
            horde.add (new Trolling ());
        }
        for (int i = num_ling; i < HORDE_SIZE; i++) {
            horde.add (new Trollzord ());
        }


        /**
         * The round logic is overly complicated due to not having a common base
         * class for Trolls and Goats. This could really be cleaned up by doing that.
         */

        while (party.size () > 0 && horde.size () > 0) {
            // Create a random list to determine attack order
            List <Integer> order = new ArrayList<> ();
            for (int i = 0; i < party.size () + horde.size (); i++) {
                order.add (i);
            }
            Collections.shuffle (order);

            // Execute each attack in list order
            for (int i = 0; i < order.size (); i++) {
                try {
                    int index = order.get (i);
                    // Goats use new attack style
                    if (index < party.size() && horde.size () > 0) {
                        Goat attacker = party.get (index);
                        attacker.attack (horde, party);
                    }
                    // Trolls use old attack style
                    else if (party.size() > 0) {
                        index = index - party.size();
                        int targetIndex = random.nextInt (party.size ());
                        Goat target = party.get (targetIndex);
                        Troll attacker = horde.get (index);
                        target.takeDamage (attacker.attack ());
                        if (!target.isConscious ()) {
                            party.remove (target);
                            System.out.println ("\t" + target.getName() + " has been knocked unconscious!");
                        }                
                    }
                } catch (IndexOutOfBoundsException ioob) {
                    // Someone was knocked out this round, so they cannot do
                    // or take damage.
                }
            }
        }
        if (party.size () > 0) {
            System.out.println ("The glorious goat heroes have won again!");
        }
        else {
            System.out.println ("The evil trolls have defeated our noble party.");
        }

    }
}
