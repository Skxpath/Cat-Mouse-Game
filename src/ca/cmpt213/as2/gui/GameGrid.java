package ca.cmpt213.as2.gui;

import ca.cmpt213.as2.model.CellLocation;
import ca.cmpt213.as2.model.MazeGame;

import javax.swing.*;
import java.awt.*;

/**
 * GameGrid class to display the game grid.
 */
public class GameGrid extends JPanel {

    MazeGame maze;

    public GameGrid() {
        this.maze = MazeGame.getInstance();

        this.setLayout(new GridLayout(maze.getMazeHeight(), maze.getMazeWidth()));

        for (int y = 0; y < maze.getMazeHeight(); y++) {
            for (int x = 0; x < maze.getMazeWidth(); x++) {
                CellLocation cell = new CellLocation(x, y);
                ObjectLabel mazeIcon = new ObjectLabel(cell);
                maze.addObserver(mazeIcon);
                add(mazeIcon);
            }
        }
    }
}
