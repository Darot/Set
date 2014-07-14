
package set.model;

/**
 * The Player model
 * 
 * @author Sebastian Neiss
 */
public class Player {
    
    private int points = 0;
    private String name;
    
    public Player(String name){
        this.name = name;
    }
    
    /**
     * Adds a point (used if player finds a set).
     */
    public void addPoint(){
        points ++;
    }
    
    /**
     * @return points
     */
    public int getPoints(){
        return points;
    }
    
    
    public void setName(String name){
        this.name = name;
    }

    /**
     * @return name
     */
    public String getName(){
        return name;
    }
    
}
