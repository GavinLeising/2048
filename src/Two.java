import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.util.*;
public class Two extends Actor
{
    public int value;
    private static int num = 0;
    public Two()
    {
        setColor(null);
        value = 2;
    }
    public int getValue()
    {
        return value;
    }
    public boolean equals(Two other)
    {
        if(value == other.getValue())
        {
            return true;
        }
        return false;
    }
    public boolean canCombine()
    {
        Grid<Actor> gr = getGrid();
        Location loc = new Location(0,0);
        for(int r = 0; r<3; r++)
        {
            for(int c = 0; c<4; c++)
            {
                loc = new Location(r,c);
                Location down = loc.getAdjacentLocation(180);
                if(gr.get(loc) != null && gr.get(down) != null)
                {
                    if(((Two)gr.get(loc)).equals(((Two)gr.get(down))))
                    {
                        return true;
                    }
                }
            }
        }
        for(int a = 0; a<4; a++)
        {
            for(int b = 0; b<3; b++)
            {
                loc = new Location(a,b);
                Location right = loc.getAdjacentLocation(90);
                if(gr.get(loc) != null && gr.get(right) != null)
                {
                    if(((Two)gr.get(loc)).equals(((Two)gr.get(right))))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean checkWin()
    {
        Grid<Actor> gr = getGrid();
        ArrayList<Location> arr = gr.getOccupiedLocations();
        Actor a = null;
        if(num == 0)
        {
            for(int i = 0; i<arr.size(); i++)
            {
                a = gr.get(arr.get(i));
                if(((Two)a).getValue() == 2048)
                {
                    num++;
                    return true;
                }
            }
        }
        return false;
    }
    public void addRandom(int count)
    {
        Grid<Actor> gr = getGrid();
        ArrayList<Location> arr = new ArrayList<Location>();
        Location loc = new Location(0,0);
        for(int r = 0; r<4; r++)
        {
            for(int c = 0; c<4; c++)
            {
                loc = new Location(r,c);
                if(gr.get(loc) == null)
                {
                    arr.add(loc);
                }
            }
        }
        if(count>0 && arr.size()>0)
        {
            Location rando = arr.get((int)(arr.size()*Math.random()));
            double choose = Math.random();
            if(choose>=0.8)
            {
                Four f = new Four();
                f.putSelfInGrid(gr,rando);
            }
            else
            {
                Two t = new Two();
                t.putSelfInGrid(gr,rando);
            }
        }
    }
    private int moveUp()
    {
        Grid<Actor> gr = getGrid();
        Location up = null;
        int count = 0;
        while(1==1)
        {
            Location loc = getLocation();
            up = loc.getAdjacentLocation(0);
            if(gr.isValid(up) && gr.get(up)==null)
            {
                moveTo(up);
                count++;
            }
            else 
            {
                break;
            }
        }
        return count;
    }
    private boolean combineUp()
    {
        Grid<Actor> gr = getGrid();
        Location loc = getLocation();
        Location up = null;
        if(loc.getRow() > 0)
        {
            up = loc.getAdjacentLocation(0);
            if(gr.get(loc) instanceof Two && gr.get(up) instanceof Two && !(gr.get(loc) instanceof Four) && !(gr.get(up) instanceof Four))
            {
                gr.get(loc).removeSelfFromGrid();
                gr.get(up).removeSelfFromGrid();
                Actor a = new Four();
                a.putSelfInGrid(gr,up);
                return true;
            }
        }
        return false;
    }
    public void slideUp()
    {
        Grid<Actor> gr = getGrid();
        Actor a = null;
        Two t = null;
        int count = 0;
        for(int r = 0; r<4; r++)
        {
            for(int c = 0; c<4; c++)
            {
                if(gr.get(new Location(r,c)) != null)
                {
                    a = gr.get(new Location(r,c));
                    t = (Two)a;
                    if(t.moveUp() > 0)
                    {
                        count++;
                    }
                }
            }
        }
        for(int r = 0; r<4; r++)
        {
            for(int c = 0; c<4; c++)
            {
                if(gr.get(new Location(r,c)) != null)
                {
                    a = gr.get(new Location(r,c));
                    t = (Two)a;
                    if(gr.get(new Location(r,c)) instanceof Two && ((Two)t).combineUp())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof Four && ((Four)t).combineUp())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof Eight && ((Eight)t).combineUp())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof Sixteen && ((Sixteen)t).combineUp())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof ThirtyTwo && ((ThirtyTwo)t).combineUp())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof SixtyFour && ((SixtyFour)t).combineUp())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof OneTwentyEight && ((OneTwentyEight)t).combineUp())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof TwoFiftySix && ((TwoFiftySix)t).combineUp())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof FiveTwelve && ((FiveTwelve)t).combineUp())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof TenTwentyFour && ((TenTwentyFour)t).combineUp())
                    {
                        count++;
                    }
                }
            }
        }
        for(int r = 0; r<4; r++)
        {
            for(int c = 0; c<4; c++)
            {
                if(gr.get(new Location(r,c)) != null)
                {
                    a = gr.get(new Location(r,c));
                    t = (Two)a;
                    if(t.moveUp() > 0)
                    {
                        count++;
                    }
                }
            }
        }
        ((Two)a).addRandom(count);
        if(((Two)a).checkWin() == true)
        {
            System.out.println("YOU GOT 2048");
        }
        if(((Two)a).canCombine() == false && gr.getOccupiedLocations().size() == 16)
        {
            System.out.println("GAME OVER");
        }
    }
    private int moveDown()
    {
        Grid<Actor> gr = getGrid();
        Location down = null;
        int count = 0;
        while(1==1)
        {
            Location loc = getLocation();
            down = loc.getAdjacentLocation(180);
            if(gr.isValid(down) && gr.get(down)==null)
            {
                moveTo(down);
                count++;
            }
            else 
            {
                break;
            }
        }
        return count;
    }
    private boolean combineDown()
    {
        Grid<Actor> gr = getGrid();
        Location loc = getLocation();
        Location down = null;
        if(loc.getRow() < 3)
        {
            down = loc.getAdjacentLocation(180);
            if(gr.get(loc) instanceof Two && gr.get(down) instanceof Two && !(gr.get(loc) instanceof Four) && !(gr.get(down) instanceof Four))
            {
                gr.get(loc).removeSelfFromGrid();
                gr.get(down).removeSelfFromGrid();
                Actor a = new Four();
                a.putSelfInGrid(gr,down);
                return true;
            }
        }
        return false;
    }
    public void slideDown()
    {
        Grid<Actor> gr = getGrid();
        Actor a = null;
        Two t = null;
        int count = 0;
        for(int r = 3; r>=0; r--)
        {
            for(int c = 3; c>=0; c--)
            {
                if(gr.get(new Location(r,c)) != null)
                {
                    a = gr.get(new Location(r,c));
                    t = (Two)a;
                    if(t.moveDown() > 0)
                    {
                        count++;
                    }
                }
            }
        }
        for(int r = 3; r>=0; r--)
        {
            for(int c = 3; c>=0; c--)
            {
                if(gr.get(new Location(r,c)) != null)
                {
                    a = gr.get(new Location(r,c));
                    t = (Two)a;
                    if(gr.get(new Location(r,c)) instanceof Two && ((Two)t).combineDown())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof Four && ((Four)t).combineDown())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof Eight && ((Eight)t).combineDown())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof Sixteen && ((Sixteen)t).combineDown())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof ThirtyTwo && ((ThirtyTwo)t).combineDown())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof SixtyFour && ((SixtyFour)t).combineDown())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof OneTwentyEight && ((OneTwentyEight)t).combineDown())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof TwoFiftySix && ((TwoFiftySix)t).combineDown())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof FiveTwelve && ((FiveTwelve)t).combineDown())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof TenTwentyFour && ((TenTwentyFour)t).combineDown())
                    {
                        count++;
                    }
                }
            }
        }
        for(int r = 3; r>=0; r--)
        {
            for(int c = 3; c>=0; c--)
            {
                if(gr.get(new Location(r,c)) != null)
                {
                    a = gr.get(new Location(r,c));
                    t = (Two)a;
                    if(t.moveDown() > 0)
                    {
                        count++;
                    }
                }
            }
        }
        ((Two)a).addRandom(count);
        if(((Two)a).checkWin() == true)
        {
            System.out.println("YOU GOT 2048");
        }
        if(((Two)a).canCombine() == false && gr.getOccupiedLocations().size() == 16)
        {
            System.out.println("GAME OVER");
        }
    }
    private int moveRight()
    {
        Grid<Actor> gr = getGrid();
        Location right = null;
        int count = 0;
        while(1==1)
        {
            Location loc = getLocation();
            right = loc.getAdjacentLocation(90);
            if(gr.isValid(right) && gr.get(right)==null)
            {
                moveTo(right);
                count++;
            }
            else 
            {
                break;
            }
        }
        return count;
    }
    private boolean combineRight()
    {
        Grid<Actor> gr = getGrid();
        Location loc = getLocation();
        Location right = null;
        if(loc.getCol() < 3)
        {
            right = loc.getAdjacentLocation(90);
            if(gr.get(loc) instanceof Two && gr.get(right) instanceof Two && !(gr.get(loc) instanceof Four) && !(gr.get(right) instanceof Four))
            {
                gr.get(loc).removeSelfFromGrid();
                gr.get(right).removeSelfFromGrid();
                Actor a = new Four();
                a.putSelfInGrid(gr,right);
                return true;
            }
        }
        return false;
    }
    public void slideRight()
    {
        Grid<Actor> gr = getGrid();
        Actor a = null;
        Two t = null;
        int count = 0;
        for(int c = 3; c>=0; c--)
        {
            for(int r = 3; r>=0; r--)
            {
                if(gr.get(new Location(r,c)) != null)
                {
                    a = gr.get(new Location(r,c));
                    t = (Two)a;
                    if(t.moveRight() > 0)
                    {
                        count++;
                    }
                }
            }
        }
        for(int c = 3; c>=0; c--)
        {
            for(int r = 3; r>=0; r--)
            {
                if(gr.get(new Location(r,c)) != null)
                {
                    a = gr.get(new Location(r,c));
                    t = (Two)a;
                    if(gr.get(new Location(r,c)) instanceof Two && ((Two)t).combineRight())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof Four && ((Four)t).combineRight())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof Eight && ((Eight)t).combineRight())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof Sixteen && ((Sixteen)t).combineRight())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof ThirtyTwo && ((ThirtyTwo)t).combineRight())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof SixtyFour && ((SixtyFour)t).combineRight())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof OneTwentyEight && ((OneTwentyEight)t).combineRight())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof TwoFiftySix && ((TwoFiftySix)t).combineRight())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof FiveTwelve && ((FiveTwelve)t).combineRight())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof TenTwentyFour && ((TenTwentyFour)t).combineRight())
                    {
                        count++;
                    }
                }
            }
        }
        for(int c = 3; c>=0; c--)
        {
            for(int r = 3; r>=0; r--)
            {
                if(gr.get(new Location(r,c)) != null)
                {
                    a = gr.get(new Location(r,c));
                    t = (Two)a;
                    if(t.moveRight() > 0)
                    {
                        count++;
                    }
                }
            }
        }
        ((Two)a).addRandom(count);
        if(((Two)a).checkWin() == true)
        {
            System.out.println("YOU GOT 2048");
        }
        if(((Two)a).canCombine() == false && gr.getOccupiedLocations().size() == 16)
        {
            System.out.println("GAME OVER");
        }
    }
    private int moveLeft()
    {
        Grid<Actor> gr = getGrid();
        Location left = null;
        int count = 0;
        while(1==1)
        {
            Location loc = getLocation();
            left = loc.getAdjacentLocation(270);
            if(gr.isValid(left) && gr.get(left)==null)
            {
                moveTo(left);
                count++;
            }
            else 
            {
                break;
            }
        }
        return count;
    }
    private boolean combineLeft()
    {
        Grid<Actor> gr = getGrid();
        Location loc = getLocation();
        Location left = null;
        if(loc.getCol() > 0)
        {
            left = loc.getAdjacentLocation(270);
            if(gr.get(loc) instanceof Two && gr.get(left) instanceof Two && !(gr.get(loc) instanceof Four) && !(gr.get(left) instanceof Four))
            {
                gr.get(loc).removeSelfFromGrid();
                gr.get(left).removeSelfFromGrid();
                Actor a = new Four();
                a.putSelfInGrid(gr,left);
                return true;
            }
        }
        return false;
    }
    public void slideLeft()
    {
        Grid<Actor> gr = getGrid();
        Actor a = null;
        Two t = null;
        int count = 0;
        for(int c = 0; c<4; c++)
        {
            for(int r = 0; r<4; r++)
            {
                if(gr.get(new Location(r,c)) != null)
                {
                    a = gr.get(new Location(r,c));
                    t = (Two)a;
                    if(t.moveLeft() > 0)
                    {
                        count++;
                    }
                }
            }
        }
        for(int c = 0; c<4; c++)
        {
            for(int r = 0; r<4; r++)
            {
                if(gr.get(new Location(r,c)) != null)
                {
                    a = gr.get(new Location(r,c));
                    t = (Two)a;
                    if(gr.get(new Location(r,c)) instanceof Two && ((Two)t).combineLeft())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof Four && ((Four)t).combineLeft())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof Eight && ((Eight)t).combineLeft())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof Sixteen && ((Sixteen)t).combineLeft())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof ThirtyTwo && ((ThirtyTwo)t).combineLeft())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof SixtyFour && ((SixtyFour)t).combineLeft())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof OneTwentyEight && ((OneTwentyEight)t).combineLeft())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof TwoFiftySix && ((TwoFiftySix)t).combineLeft())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof FiveTwelve && ((FiveTwelve)t).combineLeft())
                    {
                        count++;
                    }
                    if(gr.get(new Location(r,c)) instanceof TenTwentyFour && ((TenTwentyFour)t).combineLeft())
                    {
                        count++;
                    }
                }
            }
        }
        for(int c = 0; c<4; c++)
        {
            for(int r = 0; r<4; r++)
            {
                if(gr.get(new Location(r,c)) != null)
                {
                    a = gr.get(new Location(r,c));
                    t = (Two)a;
                    if(t.moveLeft() > 0)
                    {
                        count++;
                    }
                }
            }
        }
        ((Two)a).addRandom(count);
        if(((Two)a).checkWin() == true)
        {
            System.out.println("YOU GOT 2048");
        }
        if(((Two)a).canCombine() == false && gr.getOccupiedLocations().size() == 16)
        {
            System.out.println("GAME OVER");
        }
    }
}
