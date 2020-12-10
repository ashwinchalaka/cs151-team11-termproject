package cs151Project;

import cs151Project.views.Game;

import javax.swing.*;

/**
 * Contains the run commands to start the program.
 */
public class StartGame {
    public static void main(String[] args) {
        Game w = new Game();
        JFrame frame = new JFrame(w.TITLE);
        frame.add(w);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.start();
    }
}
