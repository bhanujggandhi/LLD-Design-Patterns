package LifeChangingAppObserverPattern;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DevilListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Cmon, go on do it!!");
    }
}
