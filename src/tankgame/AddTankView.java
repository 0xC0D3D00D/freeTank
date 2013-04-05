/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tankgame;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Mohammad Hossein Heydari <mdh.heydari@gmail.com>
 */
public class AddTankView extends JFrame {
    private FlowLayout layout;
    private Container container;
    private JButton addButton;
    private JButton startGame;
    private JComboBox tankX;
    private JComboBox tankY;
    private JComboBox tankSize;
    private JComboBox direction;
    private JLabel tankLabelX;
    private JLabel tankLabelY;
    private JLabel tankSizeLabel;
    private JLabel directionLabel;
    private ArrayList<Tank> tanks;
    private BoardView designBoardView;
    private Board designBoard;
    private GameStartEvent gs;
    
    public AddTankView(GameStartEvent gs) throws HeadlessException {
        super("Add Tank");
        Integer acceptableSizes[] = {2,3,4,5};
        Integer acceptablePositions[] = {0,1,2,3,4,5,6,7,8,9};
        String acceptableDirections[] = {"Horizontal", "Vertical"};
        tanks = new ArrayList<>();
        designBoardView = new BoardView("Create your board");
        designBoard = new Board();
        this.gs=gs;
        layout = new FlowLayout();
        container = this.getContentPane();
        container.setLayout(layout);
        tankLabelX = new JLabel("X:");
        tankX = new JComboBox(acceptablePositions);
        tankLabelY = new JLabel("Y:");
        tankY = new JComboBox(acceptablePositions);
        tankSizeLabel = new JLabel("Size:");
        tankSize = new JComboBox(acceptableSizes);
        directionLabel = new JLabel("Direction:");
        direction = new JComboBox(acceptableDirections);
        addButton = new JButton("Add");
        startGame = new JButton("Start Game");
        addButton.addActionListener(new addButtonAction());
        startGame.setEnabled(false);
        startGame.addActionListener(gs);
        
        add(tankLabelX);
        add(tankX);
        add(tankLabelY);
        add(tankY);
        add(tankSizeLabel);
        add(tankSize);
        add(directionLabel);
        add(direction);
        add(addButton);
        add(startGame);
        
        this.setSize(new Dimension(250, 150));
        this.setMaximumSize(new Dimension(250, 150));
        this.setMinimumSize(new Dimension(250, 150));
        
        designBoardView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        designBoardView.setVisible(true);
    }
    
    public void hide()
    {
        designBoardView.setVisible(false);
        designBoardView.dispose();
        WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
    }
    
    class addButtonAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean flag = false;
            Tank newtank = new Tank((int)tankX.getSelectedItem(),(int)tankY.getSelectedItem(),(int)tankSize.getSelectedItem(),direction.getSelectedIndex()==1? Direction.Vertical : Direction.Horizontal);
            //System.out.println(newtank.toString());
            for(Tank prevtank: tanks)
            {
                if(prevtank.isCollide(newtank))
                {
                    flag=true;
                }
            }
            if(flag)
            {
                JOptionPane.showMessageDialog(null, "The tank you want to add collides another tank in the board!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
               try {
                    for(Point p:newtank.getLine().toArrayList())
                    {
                        designBoard.setPoint(p);
                    }
                    designBoardView.update(designBoard);
                    tanks.add(newtank);
                }
                catch(ArrayIndexOutOfBoundsException exception)
                {
                    JOptionPane.showMessageDialog(null, "The tank you want to add gets out of the board!", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
            if(tanks.size()==5)
            {
                tankLabelX.setEnabled(false);
                tankX.setEnabled(false);
                tankLabelY.setEnabled(false);
                tankY.setEnabled(false);
                tankSizeLabel.setEnabled(false);
                tankSize.setEnabled(false);
                directionLabel.setEnabled(false);
                direction.setEnabled(false);
                addButton.setEnabled(false);
                
                gs.setTankPositions(tanks);
                startGame.setEnabled(true);
            }
        }
    }
}

class GameStartEvent implements ActionListener {
    private ArrayList<Tank> tanks;
    private GameView gameView;
    private AddTankView addTankView;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        gameView.setHumanTanksData(tanks);
        gameView.show();
        addTankView.hide();
    }
    
    public void setTankPositions(ArrayList<Tank> tanks)
    {
        this.tanks=tanks;
    }
    
    public ArrayList<Tank> getTankPositions()
    {
        return tanks;
    }
    
    public void setAddTankView(AddTankView addTankView)
    {
        this.addTankView = addTankView;
    }
    
    public void setGameView(GameView gameView)
    {
        this.gameView=gameView;
    }
    
}