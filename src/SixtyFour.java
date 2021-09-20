import info.gridworld.actor.*;
import info.gridworld.grid.*;
public class SixtyFour extends ThirtyTwo
{
    public SixtyFour()
    {
        value = 64;
    }
    public boolean combineUp()
    {
        Grid<Actor> gr = getGrid();
        Location loc = getLocation();
        Location up = null;
        if(loc.getRow() > 0)
        {
            up = loc.getAdjacentLocation(0);
            if(gr.get(loc) instanceof SixtyFour && gr.get(up) instanceof SixtyFour && !(gr.get(loc) instanceof OneTwentyEight) && !(gr.get(up) instanceof OneTwentyEight))
            {
                gr.get(loc).removeSelfFromGrid();
                gr.get(up).removeSelfFromGrid();
                Actor a = new OneTwentyEight();
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
            if(gr.get(loc) instanceof SixtyFour && gr.get(down) instanceof SixtyFour && !(gr.get(loc) instanceof OneTwentyEight) && !(gr.get(down) instanceof OneTwentyEight))
            {
                gr.get(loc).removeSelfFromGrid();
                gr.get(down).removeSelfFromGrid();
                Actor a = new OneTwentyEight();
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
            if(gr.get(loc) instanceof SixtyFour && gr.get(right) instanceof SixtyFour && !(gr.get(loc) instanceof OneTwentyEight) && !(gr.get(right) instanceof OneTwentyEight))
            {
                gr.get(loc).removeSelfFromGrid();
                gr.get(right).removeSelfFromGrid();
                Actor a = new OneTwentyEight();
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
            if(gr.get(loc) instanceof SixtyFour && gr.get(left) instanceof SixtyFour && !(gr.get(loc) instanceof OneTwentyEight) && !(gr.get(left) instanceof OneTwentyEight))
            {
                gr.get(loc).removeSelfFromGrid();
                gr.get(left).removeSelfFromGrid();
                Actor a = new OneTwentyEight();
                a.putSelfInGrid(gr,left);
                return true;
            }
        }
        return false;
    }
}
