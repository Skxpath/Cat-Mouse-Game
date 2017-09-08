package ca.cmpt213.as2.gui;

import ca.cmpt213.as2.model.CellLocation;
import ca.cmpt213.as2.model.CellState;
import ca.cmpt213.as2.model.MazeGame;

import javax.swing.*;

/**
 * ObjectLabel class to represent different objects in the grid
 */
public class ObjectLabel extends JLabel implements UIObserverInterface {

    private final MazeGame maze;
    private ImageIcon wall = new ImageIcon("images/wall.jpg");
    private ImageIcon wallResized = ResizeImage.getScaleImageIcon(wall, 45, 45);

    private ImageIcon cat = new ImageIcon("images/cat.jpg");
    private ImageIcon catResized = ResizeImage.getScaleImageIcon(cat, 45, 45);

    private ImageIcon cheese = new ImageIcon("images/cheese.jpg");
    private ImageIcon cheeseResized = ResizeImage.getScaleImageIcon(cheese, 45, 45);

    private ImageIcon fog = new ImageIcon("images/fog.jpg");
    private ImageIcon fogResized = ResizeImage.getScaleImageIcon(fog, 45, 45);

    private ImageIcon road = new ImageIcon("images/road.jpg");
    private ImageIcon roadResized = ResizeImage.getScaleImageIcon(road, 45, 45);

    private ImageIcon mouse = new ImageIcon("images/mouse.jpg");
    private ImageIcon mouseResized = ResizeImage.getScaleImageIcon(mouse, 45, 45);

    private ImageIcon dead = new ImageIcon("images/dead.jpg");
    private ImageIcon deadResized = ResizeImage.getScaleImageIcon(dead, 45, 45);

    private CellLocation cell;


    public ObjectLabel(CellLocation cell) {
        this.cell = cell;
        this.maze = MazeGame.getInstance();
        ImageIcon icon = getIconForCell(cell);
        this.setIcon(icon);
    }

    @Override
    public void update() {
        ImageIcon icon = getIconForCell(cell);
        this.setIcon(icon);
    }

    private ImageIcon getIconForCell(CellLocation cell) {
        CellState state = maze.getCellState(cell);
        if (maze.isMouseAtLocation(cell) && maze.isCatAtLocation(cell)) {
            return deadResized;
        } else if (maze.isMouseAtLocation(cell)) {
            return mouseResized;
        } else if (maze.isCatAtLocation(cell)) {
            return catResized;
        } else if (maze.isCheeseAtLocation(cell)) {
            return cheeseResized;
        } else if (state.isHidden()) {
            return fogResized;
        } else if (state.isWall()) {
            return wallResized;
        } else {
            return roadResized;
        }
    }
}
