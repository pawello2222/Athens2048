package com.athens.athens2048.gui;

import javax.swing.*;

/*
 * The interface defining the strategy.
 */

public interface AppFrameTheme {
    // Sets the colors of the theme (background and font)
    void setTileColor(JButton tile, int value);

    // Sets the colors of the theme (background and font)
    void setThemeLabel(JLabel button);

    // Sets the background of the game panels
    void setPanelsBackground(JFrame frame);
}
