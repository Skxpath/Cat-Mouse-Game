package ca.cmpt213.as2.gui;

import ca.cmpt213.as2.model.MoveDirection;

/**
 * KeyPressObserver class to observe the keys pressed by the user.
 */
public interface KeyPressObserver {
    void update(MoveDirection direction);
}
