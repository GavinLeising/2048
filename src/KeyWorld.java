import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.Color;
import java.util.ArrayList;
public class KeyWorld extends ActorWorld
{
    public KeyWorld(Grid<Actor> g)
    {
        super(g);
    }
    public boolean keyPressed(String description, Location loc)
    {
        Grid<Actor> g = getGrid();
        ArrayList<Location> arr = g.getOccupiedLocations();
        Two t = (Two)g.get(arr.get(0));
        if(description.equals("UP"))
        {
            t.slideUp();
            return true;
        }
        if(description.equals("DOWN"))
        {
            t.slideDown();
            return true;
        }
        if(description.equals("RIGHT"))
        {
            t.slideRight();
            return true;
        }
        if(description.equals("LEFT"))
        {
            t.slideLeft();
            return true;
        }
        return false;
    }
}