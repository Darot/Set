package interfaces.model;

/**
 *
 * @author Daniel Roth
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
    
    public int getNumber();
    
    public String getImagePath();
    
}
