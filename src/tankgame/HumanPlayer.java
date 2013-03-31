/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tankgame;

/**
 *
 * @author Mohammad Hossein Heydari <mdh.heydari@gmail.com>
 */
public class HumanPlayer extends Player {
    public void addTank(int i, int j, int length, Direction direction)
    {
        Tank newTank = new Tank(i, j, length, direction);
        tanks.add(newTank);
        super.addTank(newTank);
    }
}
