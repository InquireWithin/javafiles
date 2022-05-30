package backtracker;

import java.util.Collection;

public interface Configuration {
    /**
     * Get the collection of successors from the current one.
     * 
     * @return All successors, valid and invalid
     */
    public Collection<Configuration> getSuccessors();
    
    /**
     * Is the current configuration valid or not?
     * 
     * @return true if valid; false otherwise
     */
    public boolean isValid();
    
    /**
     * Is the current configuration a goal?
     * @return true if goal; false otherwise
     */
    public boolean isGoal();
}
