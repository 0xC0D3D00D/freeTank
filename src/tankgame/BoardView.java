
package tankgame;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author Mohammad Hossein Heydari <mdh.heydari@gmail.com>
 */
public class BoardView extends JFrame {
    protected JButton Blocks[][];
    private GridLayout boardLayout;
    private BorderLayout mainLayout;
    private Container container;
    protected Icon explodedIcon;
    protected Icon tankIcon;
    protected Icon tankRedIcon;
    protected Icon crossIcon;
    
    public BoardView(String boardName)
    {
        super(boardName);
        boardLayout = new GridLayout(10, 10, -5, -4);
        mainLayout = new BorderLayout();
        container = getContentPane();
        setLayout(boardLayout);
        
        Blocks = new JButton[10][10];
        for(int i=0;i<10;i++)
            for(int j=0;j<10;j++)
            {
                Blocks[i][j]=new JButton();
                Blocks[i][j].addActionListener(this.createListener(i,j));
                add(Blocks[i][j]);
            }
        
        explodedIcon = new ImageIcon(getClass().getResource("Explosion.png"));
        tankIcon = new ImageIcon(getClass().getResource("Tank.png"));
        tankRedIcon = new ImageIcon(getClass().getResource("TankRed.png"));
        crossIcon = new ImageIcon(getClass().getResource("Cross.png"));
        
        this.setSize(new Dimension(600,600));
        this.setMaximumSize(new Dimension(600, 600));
        this.setMinimumSize(new Dimension(600, 600));
    }
    
    public void update(Board board)
    {
        for(int i=0;i<10;i++)
            for(int j=0;j<10;j++)
                switch(board.getPointType(j, i))
                {
                    case PointEmpty:
                        Blocks[i][j].setText("");
                        break;
                    case PointTank:
                        Blocks[i][j].setIcon(tankIcon);
                    break;
                    case PointMissed:
                        Blocks[i][j].setIcon(crossIcon);
                    break;
                    case PointDead:
                        Blocks[i][j].setIcon(explodedIcon);
//                    default:
//                        throw new UnknownError("gotten PointType is not exist!");
                }
                
    }
    
    protected ActionListener createListener(int i, int j)
    {
        return new BlockAction(i, j) {

            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        };
    }
}

abstract class BlockAction implements ActionListener
{
    protected Point block;
    
    public BlockAction(int i, int j)
    {
        block = new Point(i, j, PointType.PointEmpty);
    }
    
    @Override
    abstract public void actionPerformed(ActionEvent e);
    
    public Point getPoint()
    {
        return block;
    }
}