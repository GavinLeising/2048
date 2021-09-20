import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.Color;
import java.util.ArrayList;
public class TwentyFourtyEight extends TenTwentyFour
{
    public TwentyFourtyEight()
    {
        value = 2048;
    }
    public static void main(String[] args)
    {
        Grid<Actor> g = new BoundedGrid<Actor>(4,4); 
        KeyWorld world = new KeyWorld(g);
        world.add(new Two());
        world.add(new Two());
        world.show();
    }
    public boolean combineUp()
    {
        Grid<Actor> gr = getGrid();
        Location loc = getLocation();
        Location up = null;
        if(loc.getRow() > 0)
        {
            up = loc.getAdjacentLocation(0);
            if(gr.get(loc) instanceof TwentyFourtyEight && gr.get(up) instanceof TwentyFourtyEight && !(gr.get(loc) instanceof FourtyNinetySix) && !(gr.get(up) instanceof FourtyNinetySix))
            {
                gr.get(loc).removeSelfFromGrid();
                gr.get(up).removeSelfFromGrid();
                Actor a = new FourtyNinetySix();
                a.putSelfInGrid(gr,up);
                return true;
            }
        }
        return false;
    }
    public boolean combineDown()
    {
        Grid<Actor> gr = getGrid();
        Location loc = getLocation();
        Location down = null;
        if(loc.getRow() < 3)
        {
            down = loc.getAdjacentLocation(180);
            if(gr.get(loc) instanceof TwentyFourtyEight && gr.get(down) instanceof TwentyFourtyEight && !(gr.get(loc) instanceof FourtyNinetySix) && !(gr.get(down) instanceof FourtyNinetySix))
            {
                gr.get(loc).removeSelfFromGrid();
                gr.get(down).removeSelfFromGrid();
                Actor a = new FourtyNinetySix();
                a.putSelfInGrid(gr,down);
                return true;
            }
        }
        return false;
    }
    public boolean combineRight()
    {
        Grid<Actor> gr = getGrid();
        Location loc = getLocation();
        Location right = null;
        if(loc.getCol() < 3)
        {
            right = loc.getAdjacentLocation(90);
            if(gr.get(loc) instanceof TwentyFourtyEight && gr.get(right) instanceof TwentyFourtyEight && !(gr.get(loc) instanceof FourtyNinetySix) && !(gr.get(right) instanceof FourtyNinetySix))
            {
                gr.get(loc).removeSelfFromGrid();
                gr.get(right).removeSelfFromGrid();
                Actor a = new FourtyNinetySix();
                a.putSelfInGrid(gr,right);
                return true;
            }
        }
        return false;
    }
    public boolean combineLeft()
    {
        Grid<Actor> gr = getGrid();
        Location loc = getLocation();
        Location left = null;
        if(loc.getCol() > 0)
        {
            left = loc.getAdjacentLocation(270);
            if(gr.get(loc) instanceof TwentyFourtyEight && gr.get(left) instanceof TwentyFourtyEight && !(gr.get(loc) instanceof FourtyNinetySix) && !(gr.get(left) instanceof FourtyNinetySix))
            {
                gr.get(loc).removeSelfFromGrid();
                gr.get(left).removeSelfFromGrid();
                Actor a = new FourtyNinetySix();
                a.putSelfInGrid(gr,left);
                return true;
            }
        }
        return false;
    }
}