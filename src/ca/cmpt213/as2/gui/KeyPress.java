package ca.cmpt213.as2.gui;

import ca.cmpt213.as2.model.MazeGame;
import ca.cmpt213.as2.model.MoveDirection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

/**
 * KeyPress class to take in arrow key input.
 */
public class KeyPress extends JPanel implements ActionListener, KeyListener {

    private MazeGame maze;

    private List<KeyPressObserver> observers = new ArrayList<>();

    public void notifyAllObservers(MoveDirection direction){
        for (KeyPressObserver observer : observers) {
            observer.update(direction);
        }
    }

    public void addObserver(KeyPressObserver observer){
        observers.add(observer);
    }

    public KeyPress() {
        addKeyListener(this);
        setFocusable(true);
        this.maze = maze.getInstance();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_UP:
               if (maze.isValidPlayerMove(MoveDirection.MOVE_UP)) {
                    notifyAllObservers(MoveDirection.MOVE_UP);
                   break;
                }
            case KeyEvent.VK_DOWN:
               if (maze.isValidPlayerMove(MoveDirection.MOVE_DOWN)) {
                    notifyAllObservers(MoveDirection.MOVE_DOWN);
                   break;
                }
            case KeyEvent.VK_LEFT:
               if (maze.isValidPlayerMove(MoveDirection.MOVE_LEFT)) {
                    notifyAllObservers(MoveDirection.MOVE_LEFT);
                   break;
               }
            case KeyEvent.VK_RIGHT:
                if (maze.isValidPlayerMove(MoveDirection.MOVE_RIGHT)) {
                    notifyAllObservers(MoveDirection.MOVE_RIGHT);
                    break;
               }
            default:
                SoundMaker.play(Sounds.INVALID);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}

