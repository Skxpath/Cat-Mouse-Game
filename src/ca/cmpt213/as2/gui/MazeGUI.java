package ca.cmpt213.as2.gui;

import ca.cmpt213.as2.model.MazeGame;
import ca.cmpt213.as2.model.MoveDirection;

import javax.swing.*;

/**
 * MazeGUI class which implements GUI of game.
 */
public class MazeGUI implements KeyPressObserver {

    private final MazeGame maze;

    public MazeGUI() {
        this.maze = MazeGame.getInstance();
    }

    public void playGame() {

        JFrame frame = new JFrame("Maze Game");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));

        StatusText statusText = new StatusText();
        maze.addObserver(statusText);

        GameGrid gameGrid = new GameGrid();

        KeyPress Controller = new KeyPress();
        Controller.addObserver(this);

        frame.add(gameGrid);
        frame.add(statusText);
        frame.add(Controller);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void KeyPressMove(MoveDirection move) {
        doPlayerMove(move);
        doCatMoves();
    }

    private boolean gameNotWonOrLost() {
        return !maze.hasUserWon() && !maze.hasUserLost();
    }

    private void doPlayerMove(MoveDirection move) {
        maze.recordPlayerMove(move);
    }

    private void doCatMoves() {
        maze.doCatMoves();
    }

    private void doWonOrLost() {
        if (maze.hasUserWon()) {
            SoundMaker.play(Sounds.WON);
            PopupBox.infoBox("Congratulations! You won!", "Game Won!");
            System.exit(1);
        } else if (maze.hasUserLost()) {
            SoundMaker.play(Sounds.LOST);
            PopupBox.infoBox("I'm Sorry, you have been eaten! \n GAME OVER; please try again.", "Game Lost!");
            System.exit(1);
        }
    }

    @Override
    public void update(MoveDirection direction) {
        KeyPressMove(direction);
        doWonOrLost();
    }
}
