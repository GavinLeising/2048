import info.gridworld.actor.*;
import info.gridworld.grid.*;
public class TenTwentyFour extends FiveTwelve
{
    public TenTwentyFour()
    {
        value = 1024;
    }
    public boolean combineUp()
    {
        Grid<Actor> gr = getGrid();
        Location loc = getLocation();
        Location up = null;
        if(loc.getRow() > 0)
        {
            up = loc.getAdjacentLocation(0);
            if(gr.get(loc) instanceof TenTwentyFour && gr.get(up) instanceof TenTwentyFour && !(gr.get(loc) instanceof TwentyFourtyEight) && !(gr.get(up) instanceof TwentyFourtyEight))
            {
                gr.get(loc).removeSelfFromGrid();
                gr.get(up).removeSelfFromGrid();
                Actor a = new TwentyFourtyEight();
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
            if(gr.get(loc) instanceof TenTwentyFour && gr.get(down) instanceof TenTwentyFour && !(gr.get(loc) instanceof TwentyFourtyEight) && !(gr.get(down) instanceof TwentyFourtyEight))
            {
                gr.get(loc).removeSelfFromGrid();
                gr.get(down).removeSelfFromGrid();
                Actor a = new TwentyFourtyEight();
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
            if(gr.get(loc) instanceof TenTwentyFour && gr.get(right) instanceof TenTwentyFour && !(gr.get(loc) instanceof TwentyFourtyEight) && !(gr.get(right) instanceof TwentyFourtyEight))
            {
                gr.get(loc).removeSelfFromGrid();
                gr.get(right).removeSelfFromGrid();
                Actor a = new TwentyFourtyEight();
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
            if(gr.get(loc) instanceof TenTwentyFour && gr.get(left) instanceof TenTwentyFour && !(gr.get(loc) instanceof TwentyFourtyEight) && !(gr.get(left) instanceof TwentyFourtyEight))
            {
                gr.get(loc).removeSelfFromGrid();
                gr.get(left).removeSelfFromGrid();
                Actor a = new TwentyFourtyEight();
                a.putSelfInGrid(gr,left);
                return true;
            }
        }
        return false;
    }
}
