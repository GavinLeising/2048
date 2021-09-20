import info.gridworld.actor.*;
import info.gridworld.grid.*;
public class Sixteen extends Eight
{
    public Sixteen()
    {
        value = 16;
    }
    public boolean combineUp()
    {
        Grid<Actor> gr = getGrid();
        Location loc = getLocation();
        Location up = null;
        if(loc.getRow() > 0)
        {
            up = loc.getAdjacentLocation(0);
            if(gr.get(loc) instanceof Sixteen && gr.get(up) instanceof Sixteen && !(gr.get(loc) instanceof ThirtyTwo) && !(gr.get(up) instanceof ThirtyTwo))
            {
                gr.get(loc).removeSelfFromGrid();
                gr.get(up).removeSelfFromGrid();
                Actor a = new ThirtyTwo();
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
            if(gr.get(loc) instanceof Sixteen && gr.get(down) instanceof Sixteen && !(gr.get(loc) instanceof ThirtyTwo) && !(gr.get(down) instanceof ThirtyTwo))
            {
                gr.get(loc).removeSelfFromGrid();
                gr.get(down).removeSelfFromGrid();
                Actor a = new ThirtyTwo();
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
            if(gr.get(loc) instanceof Sixteen && gr.get(right) instanceof Sixteen && !(gr.get(loc) instanceof ThirtyTwo) && !(gr.get(right) instanceof ThirtyTwo))
            {
                gr.get(loc).removeSelfFromGrid();
                gr.get(right).removeSelfFromGrid();
                Actor a = new ThirtyTwo();
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
            if(gr.get(loc) instanceof Sixteen && gr.get(left) instanceof Sixteen && !(gr.get(loc) instanceof ThirtyTwo) && !(gr.get(left) instanceof ThirtyTwo))
            {
                gr.get(loc).removeSelfFromGrid();
                gr.get(left).removeSelfFromGrid();
                Actor a = new ThirtyTwo();
                a.putSelfInGrid(gr,left);
                return true;
            }
        }
        return false;
    }
}
