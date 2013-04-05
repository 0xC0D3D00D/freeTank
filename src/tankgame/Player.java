package tankgame;

import java.util.ArrayList;
/**
 *
 * @author Mohammad Hossein Heydari <mdh.heydari@gmail.com>
 */
public class Player {
    protected Board board;
    protected ArrayList<Tank> tanks;

    public Player() {
        this.board = new Board();
        this.tanks = new ArrayList<>();
    }
    
    public void addTank(Tank newTank)
    {
        for(Point p : newTank.getLine().toArrayList())
        {
            board.setPoint(p);
        }
        this.tanks.add(newTank);
    }

    public void addTankArray(ArrayList<Tank> tanks)
    {
        for(Tank t: tanks)
        {
            this.addTank(t);
        }
    }
    
    public boolean doHavePoint(Point point)
    {
        for(Tank t:tanks)
        {
            if(t.doHavePoint(point)) {
                return true;
            }
        }
        return false;
    }

    public Board getBoard() {
        return board;
    }
    
    public boolean shotPoint(int i, int j)
    {
        switch(board.getPointType(i, j))
        {
            case PointTank:
                board.setPoint(i, j, PointType.PointDead);
                return true;
            case PointEmpty:
                board.setPoint(i, j, PointType.PointMissed);
                return true;
            case PointMissed:
                return false;
            case PointDead:
                return false;
            default:
                return false;
        }
    }
    
    protected int tankArraySize()
    {
        return tanks.size();
    }
    
    protected boolean isCollideAnyTank(Tank tank)
    {
        boolean flag=false;
        for(Tank t: tanks)
        {
            if(t.isCollide(tank))
                flag=true;
        }
        return flag;
    }
    
    public boolean isLost()
    {
        for(int i=0;i<10;i++)
            for(int j=0;j<10;j++)
                if(board.getPointType(i, j)== PointType.PointTank)
                    return false;
        return true;
    }
}

