package org.unibo.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import org.unibo.gameStates.GameState;
import org.unibo.utils.LoadSave;

import static org.unibo.utils.Constants.UI.Buttons.*;
import static org.unibo.utils.LoadSave.*;

public class MenuButton {
    private int xPos, yPos, rowIndex, index;
    private int xOffSetCenter = BTN_WIDTH / 2;
    private GameState state;
    private BufferedImage[] images;
    private boolean mouseOver, mousePressed;
    private Rectangle bounds;

    public MenuButton(int xPos, int yPos, int rowIndex, GameState state) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.rowIndex = rowIndex;
        this.state = state;
        loadImages();
        initBounds();
    }

    private void initBounds() {
        bounds = new Rectangle(xPos - xOffSetCenter, yPos, BTN_WIDTH, BTN_HEIGHT);
    }

    private void loadImages() {
        images = new BufferedImage[3];
        BufferedImage temp = LoadSave.GetSpriteAtlas(MENU_BUTTON);
        for (int i = 0; i < images.length; i++) {
            images[i] = temp.getSubimage(i * BTN_DEFAULT_WIDTH, rowIndex * BTN_DEFAULT_HEIGHT, BTN_DEFAULT_WIDTH,
                    BTN_DEFAULT_HEIGHT);
        }
    }

    public boolean isMouseOver() {
        return mouseOver;
    }

    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }

    public boolean isMousePressed() {
        return mousePressed;
    }

    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }

    public void setGameState() {
        GameState.state = state;
    }

    public void resetBooleans() {
        mouseOver = false;
        mousePressed = false;
    }

    public void update() {
        index = 0;
        if (mouseOver) {
            index = 1;
        }
        if (mousePressed) {
            index = 2;
        }
    }

    public void render(Graphics g) {
        g.drawImage(images[index], xPos - xOffSetCenter, yPos, BTN_WIDTH, BTN_HEIGHT, null);
    }

    public Rectangle getBounds() {
        return bounds;
    }

}
