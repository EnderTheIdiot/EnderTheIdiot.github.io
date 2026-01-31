// Program: Multithread Program
// Made By: Henry Smith
// Date Created: 1/21/2026

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class MouseClickCounter {
    private double clicks = 0.0;
    private Runnable listener;

    public synchronized double getClicks() {
        return clicks;
    }

    public synchronized void increment() {
        clicks += 1.0;
        if (listener != null) listener.run();
    }

    public void setListener(Runnable listener) {
        this.listener = listener;
    }
}

class ClickCounter extends JFrame {
    private JLabel counter;
    private MouseClickCounter cc1;

    public ClickCounter(String windowName, MouseClickCounter cc1) {
        this.cc1 = cc1;
        setTitle(windowName);
        setSize(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        counter = new JLabel(String.format("%.2f", cc1.getClicks()), SwingConstants.CENTER);
        add(counter, BorderLayout.CENTER);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cc1.increment();
                updateAllCounters();
            }
        });
    }
    public void updateCounter() {
        counter.setText(String.format("%.2f", cc1.getClicks()));
    }
    private static ClickCounter[] windows = new ClickCounter[2];

    private void updateAllCounters() {
        for (ClickCounter window : windows) {
            window.updateCounter();
        }
    }

    public static void setCounters(ClickCounter ccw1, ClickCounter ccw2) {
        windows[0] = ccw1;
        windows[1] = ccw2;
    }
}

public class MultithreadProgram {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MouseClickCounter MouseData = new MouseClickCounter();

            ClickCounter window1 = new ClickCounter("Window 1", MouseData);
            ClickCounter window2 = new ClickCounter("Window 2", MouseData);
            ClickCounter.setCounters(window1, window2);
            window1.setVisible(true);
            window2.setVisible(true); 
        });
    }
}
