
package tankgame;
import java.util.ArrayList;
/**
 *
 * @author Mohammad Hossein Heydari <mdh.heydari@gmail.com>
 */
public class Line {
    private ArrayList<Point> line;

    public Line(Point start, Point end, PointType lineType) {
        this.line= new ArrayList<>();
        int startX=start.getX(), startY=start.getY();
        int endX=end.getX(), endY=end.getY();
        double slope = ((double)(endY-startY))/((double)(endX-startX));
        
        if(startX==endX)
        {
            if(startY>endY)
            {
                int tmp=startY;
                startY=endY;
                endY=tmp;
            }
            for(int i=startY;i<=endY;i++)
            {
                Point point = new Point(startX, i, lineType);
                this.line.add(point);
            }
            return;
        }
        
        if(endX<startX)
        {
            int tmp=startX;
            startX=endX;
            endX=tmp;
            
            tmp=startY;
            startY=endY;
            endY=tmp;
        }
        
        double delta=0;
        for(int i=startX;i!=endX+1;i++)
        {
            Point point = new Point(i, (int)Math.ceil(startY+delta), lineType);
            this.line.add(point);
            delta+=slope;
        }
    }
    
    public boolean isCollide(Line theOther)
    {
        for(Point i : this.toArrayList()) {
            for(Point j : theOther.toArrayList()) {
                if(i.compare(j)) {
                    return true;
                }
            }
        }
        
        return false;
    }

    public ArrayList<Point> toArrayList() {
        return line;
    }
    
    public boolean doHavePoint(Point point)
    {
        for(Point p : line)
        {
            if(point.compare(p)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString()
    {
        String str = new String();
        str = "";
        for(Point p: line) {
            str = str + p.toString() + "\n";
        }
        
        return str;
    }
}
