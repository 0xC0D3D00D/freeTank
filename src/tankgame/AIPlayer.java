/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tankgame;

import javax.tools.Diagnostic;

/**
 *
 * @author Mohammad Hossein Heydari <mdh.heydari@gmail.com>
 */
public class AIPlayer extends Player {
    public void addTank()
    {
       Tank newTank=new Tank(0,0,0,Direction.Horizontal); 
       super.addTank(newTank);
    }
}
