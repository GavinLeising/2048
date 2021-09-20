import info.gridworld.actor.*;
import info.gridworld.grid.*;
public class TwoFiftySix extends OneTwentyEight
{
    public TwoFiftySix()
    {
        value = 256;
    }
    public boolean combineUp()
    {
        Grid<Actor> gr = getGrid();
        Location loc = getLocation();
        Location up = null;
        if(loc.getRow() > 0)
        {
            up = loc.getAdjacentLocation(0);
            if(gr.get(loc) instanceof TwoFiftySix && gr.get(up) instanceof TwoFiftySix && !(gr.get(loc) instanceof FiveTwelve) && !(gr.get(up) instanceof FiveTwelve))
            {
                gr.get(loc).removeSelfFromGrid();
                gr.get(up).removeSelfFromGrid();
                Actor a = new FiveTwelve();
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
            if(gr.get(loc) instanceof TwoFiftySix && gr.get(down) instanceof TwoFiftySix && !(gr.get(loc) instanceof FiveTwelve) && !(gr.get(down) instanceof FiveTwelve))
            {
                gr.get(loc).removeSelfFromGrid();
                gr.get(down).removeSelfFromGrid();
                Actor a = new FiveTwelve();
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
            if(gr.get(loc) instanceof TwoFiftySix && gr.get(right) instanceof TwoFiftySix && !(gr.get(loc) instanceof FiveTwelve) && !(gr.get(right) instanceof FiveTwelve))
            {
                gr.get(loc).removeSelfFromGrid();
                gr.get(right).removeSelfFromGrid();
                Actor a = new FiveTwelve();
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
            if(gr.get(loc) instanceof TwoFiftySix && gr.get(left) instanceof TwoFiftySix && !(gr.get(loc) instanceof FiveTwelve) && !(gr.get(left) instanceof FiveTwelve))
            {
                gr.get(loc).removeSelfFromGrid();
                gr.get(left).removeSelfFromGrid();
                Actor a = new FiveTwelve();
                a.putSelfInGrid(gr,left);
                return true;
            }
        }
        return false;
    }
}
