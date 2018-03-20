package com.athens.athens2048;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class AppFrame extends JFrame {
    AppFrame() {
        Game game = new Game();

        // Set JFrame properties for the game board
        this.setSize(800, 600);
        this.setLayout(null);
        this.setVisible(true);
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add key listeners for Up/North/East/West keys
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent event) {

            }

            @Override
            public void keyPressed(KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.VK_LEFT) {
                    game.onKeyPressed(Direction.WEST);
                }
                if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
                    game.onKeyPressed(Direction.EAST);
                }
                if (event.getKeyCode() == KeyEvent.VK_UP) {
                    game.onKeyPressed(Direction.NORTH);
                }
                if (event.getKeyCode() == KeyEvent.VK_DOWN) {
                    game.onKeyPressed(Direction.SOUTH);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        // Generates the titles
        buildGameBoard();
    }

    // Bord size (default: 4 - 4x4)
    private int max_titles = 4;

    // X and Y where the titles start to be drawn
    private int leftBorder = 40;
    private int topBorder = 40;


    /**
     * Variable of type {@link JLabel} that represents an array of game titles.
     */
    private JButton[][] gameTitle = new JButton[4][4];

    /**
     * Creates the game titles in the {@link JFrame}
     */
    private void buildGameBoard() {
        for (int i = 0; i < max_titles; i++) {
            for (int j = 0; j < max_titles; j++) {
                gameTitle[i][j] = new JButton("");
                gameTitle[i][j].setText("i = " +i+ " j = "+j);
                gameTitle[i][j].setBounds(leftBorder + i * 100 + 15 * (i + 1),
                        topBorder + j * 100 + 15 * (j + 1), 100, 100);
                gameTitle[i][j].setEnabled(false);
                this.add(gameTitle[i][j]);
            }
        }
    }



}
