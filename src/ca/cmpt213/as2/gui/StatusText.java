package ca.cmpt213.as2.gui;

import ca.cmpt213.as2.model.MazeGame;

import javax.swing.*;
import java.awt.*;

/**
 * StatusText class to display the status message at the end
 */
public class StatusText extends JPanel implements UIObserverInterface {

    private int numCheeseCollected;
    private int numCheeseToCollect;
    private MazeGame maze;
    private JLabel headerLabel;

    public StatusText() {

        this.maze = MazeGame.getInstance();
        this.numCheeseCollected = maze.getNumberCheeseCollected();
        this.numCheeseToCollect = maze.getNumberCheeseToCollect();
        headerLabel = new JLabel(textMessage(numCheeseCollected, numCheeseToCollect), SwingConstants.RIGHT);
        this.setLayout(new BorderLayout());
        add(headerLabel);
    }

    private String textMessage(int numCheeseCollected, int numCheeseToCollect) {
        return "Collected " + numCheeseCollected + " of " + numCheeseToCollect + " Ayu's.";
    }

    @Override
    public void update() {
        numCheeseCollected = maze.getNumberCheeseCollected();
        numCheeseToCollect = maze.getNumberCheeseToCollect();
        headerLabel.setText(textMessage(numCheeseCollected, numCheeseToCollect));
    }
}
