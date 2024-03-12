package org.anotherone661.animabeyondhelper.ui;

import org.anotherone661.animabeyondhelper.Settings;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window() {
        this(Settings.APP_NAME, Settings.WINDOW_WIDTH, Settings.WINDOW_HEIGHT, Settings.WINDOW_RESIZABLE, Settings.ALWAYS_ON_TOP, Settings.ICON_PATH);
    }

    public Window(String title) {
        this(title, Settings.WINDOW_WIDTH, Settings.WINDOW_HEIGHT, Settings.WINDOW_RESIZABLE, Settings.ALWAYS_ON_TOP, Settings.ICON_PATH);
    }

    public Window(String title, int width, int height, boolean resizable, boolean alwaysOnTop, String iconPath) {
        setTitle(title);
        setSize(width, height);
        setPreferredSize(Settings.WINDOW_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        if (!title.equals(Settings.APP_NAME))
            setupTitle(title);

        init();
        loadIcon(iconPath);
        setUpUI();
        setUpEvents();
        setResizable(resizable);
        setAlwaysOnTop(alwaysOnTop);
        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Initializes the window components.
     * Child classes should override this method to initialize the window
     */
    protected void init() {
        // Override this method to initialize the window
    }

    /**
     * Set up UI components.
     * Child classes should override this method to set up their UI components
     */
    protected void setUpUI() {
        // Override this method to set up UI
    }

    protected void setUpEvents() {
       // Override this method to set up events
    }

    private void loadIcon(String path) {
        Image icon = new ImageIcon(Window.class.getResource(path)).getImage();
        setIconImage(icon);
    }

    /**
     * @param title The title of the window
     * @returns void
     */
    private void setupTitle(String title) {
        setTitle(String.format("%s - %s", Settings.APP_NAME, title));

    }
}
