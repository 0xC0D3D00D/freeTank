package tankgame;

/**
 *
 * @author Mohammad Hossein
 */
public class Board {
    private Point[][] board;

    public Board() {
        this.board = new Point[10][10];
        for(int i=0; i<10; i++)
        {
            for(int j=0; j<10; j++)
            {
                this.board[i][j] = new Point(i,j, PointType.PointEmpty);
            }
        }
    }
    
    public void setPoint(int i, int j, PointType type)
    {
        if(i<10 && i>=0 && j<10 && j>=0) {
            this.board[i][j].setType(type);
        }
        else throw new ArrayIndexOutOfBoundsException("Setting point which it not exist!");
    }
    
    public void setPoint(Point point)
    {
        this.setPoint(point.getX(), point.getY(), point.getType());
    }
    
    public PointType getPointType(int i, int j)
    {
        if(i<10 && i>=0 && j<10 && j>=0)
        {
            return this.board[i][j].getType();
        }
        else throw new ArrayIndexOutOfBoundsException("Getting point which it not exist!");
    }
    
    public Point getPoint(int i, int j)
    {
        if(i<10 && i>=0 && j<10 && j>=0)
        {
            return this.board[i][j];
        }
        else throw new ArrayIndexOutOfBoundsException("Getting point which it not exist!");
    }
    
}
