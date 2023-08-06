package LifeChangingAppObserverPattern;

import javax.swing.*;

public class SwingObserverExample {
    JFrame frame;

    public static void main(String[] args) {
        SwingObserverExample example = new SwingObserverExample();
        example.go();
    }

    public void go() {
        frame = new JFrame();

        JButton button = new JButton("Should I do it?");
        button.addActionListener(event -> System.out.println("No, don't do it you will regret this!"));
        button.addActionListener(event -> System.out.println("Cmon, go on, just do it!"));
    }
}
