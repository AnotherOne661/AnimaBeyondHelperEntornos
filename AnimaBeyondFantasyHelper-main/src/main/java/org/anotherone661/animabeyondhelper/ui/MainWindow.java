package org.anotherone661.animabeyondhelper.ui;

import org.anotherone661.animabeyondhelper.Settings;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends Window {
    private JPanel mainPanel;
    private ImageIcon background;
    private JLabel backgroundLabel;
    private JPanel menuPanel;
    private JPanel dummyPanel;
    private CardLayout cardLayout;
    private JButton rollerButton;
    private JButton dummyButton;
    private JButton nextButton;

    public MainWindow() {
        super();
    }

    @Override
    protected void init() {
        // Panels
        mainPanel = new JPanel();
        menuPanel = createMenuPanel();
        dummyPanel = createDummyPanel();

        // Buttons
        rollerButton = new JButton("Roller");
        dummyButton = new JButton("Dummy");

        // Layout
        cardLayout = new CardLayout();
    }

    @Override
    protected void setUpUI() {
        mainPanel.setLayout(new BorderLayout());

        // Set background
        loadBackground();
        mainPanel.add(backgroundLabel);

        // Set layout
       mainPanel.setLayout(cardLayout);

        // Add panels
        mainPanel.add(menuPanel, "Menu");
        mainPanel.add(dummyPanel, "Dummy");
    }

    @Override
    protected void setUpEvents() {
        rollerButton.addActionListener(e -> cardLayout.show(mainPanel, "Menu"));
        dummyButton.addActionListener(e -> cardLayout.show(mainPanel, "Dummy"));
    }

    private void loadBackground() {
        background = new ImageIcon(MainWindow.class.getResource(Settings.BG_PATH));
        backgroundLabel = new JLabel(background);
        add(mainPanel);
    }

    private JPanel createMenuPanel() {
        JPanel panel = new JPanel();

        rollerButton = new JButton("Roller");
        // TODO: add roller button action listener

        panel.add(rollerButton);

        nextButton = new JButton("Next");

        panel.add(nextButton);

        return panel;
    }
    private JPanel createDummyPanel() {
        JPanel panel = new JPanel();

        dummyButton = new JButton("Dummy");
        // TODO: add dummy button action listener

        panel.add(dummyButton);

        nextButton = new JButton("Next");
        // TODO: add next button action listener

        return panel;
    }
}

