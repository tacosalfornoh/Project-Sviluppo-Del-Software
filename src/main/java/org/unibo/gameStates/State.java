package org.unibo.gameStates;

import java.awt.event.MouseEvent;

import org.unibo.Game;
import org.unibo.ui.MenuButton;

public class State {
    protected Game game;

    public State(Game game) {
        this.game = game;
    }

    public boolean isInside(MouseEvent e, MenuButton mb) {
        return mb.getBounds().contains(e.getX(), e.getY());
    }

    public Game getGame() {
        return game;
    }

}
