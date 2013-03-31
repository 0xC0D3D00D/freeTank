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
    
}

