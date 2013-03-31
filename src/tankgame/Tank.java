/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tankgame;

/**
 *
 * @author Mohammad Hossein Heydari <mdh.heydari@gmail.com>
 */
public class Tank {
    private Line line;
    private int length;
    private Direction direction;

    public Tank(int i, int j, int length, Direction direction) {
        Point startPoint, endPoint;
        
        if(direction==Direction.Vertical)
        {
            startPoint = new Point(i, j, PointType.PointTank);
            endPoint = new Point(i, j+length-1, PointType.PointTank);
        }
        else
        {
            startPoint = new Point(i, j, PointType.PointTank);
            endPoint = new Point(i+length-1, j, PointType.PointTank);
        }
        this.line = new Line(startPoint, endPoint, PointType.PointTank);
        this.length=length;
        this.direction=direction;
    }
    
    public boolean isCollide(Tank theOther) {
       return this.line.isCollide(theOther.getLine());
    }

    public boolean doHavePoint(Point p)
    {
        return this.line.doHavePoint(p);
    }
    
    public Line getLine() {
        return line;
    }

    public int getLength() {
        return length;
    }

    public Direction getDirection() {
        return direction;
    }
    
}
