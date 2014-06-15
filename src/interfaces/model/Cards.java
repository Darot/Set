/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces.model;

/**
 *
 * @author zeus
 */
public interface Cards {
    
    public boolean isSelected();
    
    public void setSelected(boolean selected);
    
    public String getColour();
    
    public void setColour(String colour);
    
    public String getPadding();
    
    public void setPadding(String padding);
    
    public String getSymbol();
    
    public void setSymbol(String Symbol);
    
}
