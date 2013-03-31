
package tankgame;

import java.lang.Math;
/**
 *
 * @author Mohammad Hossein Heydari
 */
public class Point {
    private int x;
    private int y;
    private PointType type;

    public Point(int x, int y, PointType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public PointType getType() {
        return type;
    }

    public void setType(PointType type) {
        this.type = type;
    }
    
    public boolean compare(Point theOther)
    {
        if(this.x == theOther.getX() && this.y == theOther.getY() && this.type == theOther.getType()) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public static Point randomPointOnASurface(int maxX, int maxY, PointType type)
    {
        int x = ((int) Math.random()) % (maxX+1);
        int y = (int) Math.random() % (maxY+1);
        return new Point(x,y, type);
    }
    
    @Override
    public String toString()
    {
        return "X:" + this.getX() + ", Y:" + this.getY() + ", Type:" + this.getType();
    
    }
}
