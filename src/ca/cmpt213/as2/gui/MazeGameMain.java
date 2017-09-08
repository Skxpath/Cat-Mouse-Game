package ca.cmpt213.as2.gui;

import ca.cmpt213.as2.model.MazeGame;

/**
 * Launch the Maze Game with a GUI.
 */
public class MazeGameMain {

	public static void main(String[] args) {

		MazeGame maze = MazeGame.getInstance();
		MazeGUI ui = new MazeGUI();
		ui.playGame();

	}
}
