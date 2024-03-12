package org.anotherone661.animabeyondhelper.ui;

public class Launcher {
    private MainWindow mainWindow;
    public Launcher() {
        mainWindow = new MainWindow();
    }
    public void run() {
        mainWindow.setVisible(true);
    }
}
