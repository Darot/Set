/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package set.model;

/**
 *
 * @author Daniel
 */
public class Player {
    
    private int points = 0;
    private String name;
    
    public Player(String name){
        this.name = name;
    }
    
    public void addPoint(){
        points ++;
    }
    
    public int getPoints(){
        return points;
    }
    
    public void setName(String name){
        this.name = name;
    }

    
    public String getName(){
        return name;
    }
    
}
