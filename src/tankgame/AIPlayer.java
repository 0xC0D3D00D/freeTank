/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tankgame;


/**
 *
 * @author Mohammad Hossein Heydari <mdh.heydari@gmail.com>
 */
public class AIPlayer extends Player {
    
    public void addTanks()
    {
        Direction randomDirection;
        int length;
        int randomDirectionInt;
        int x,y;
        
        while(true)
        {
            x=(int)(Math.random()*9);
            y=(int)(Math.random()*9);
            length = (int)(Math.random()*5);
            length = (length<2 ? 2 : length);
            randomDirectionInt = (int)(Math.random()*2);
            randomDirection = Direction.Horizontal;
            if(randomDirectionInt==1)
            {
                randomDirection= Direction.Horizontal;
                if(x+length>9)
                    continue;
            }
            else {
                randomDirection= Direction.Vertical;
                if(y+length>9)
                    continue;
            }
            
            Tank newTank=new Tank(x,y, length, randomDirection);
            
            if(!isCollideAnyTank(newTank))
                super.addTank(newTank);
            
            if(super.tankArraySize()==5)
                break;
        }
    }
    
    public Point shotPoint()
    {
        Point p = new Point((int)(Math.random()*9), (int)(Math.random()*9), PointType.PointEmpty);
        //System.out.println(p.toString());
        return p;
    }
}
