package gg.sh.xuyifei.ui.main;

import gg.sh.xuyifei.ui.window.MainWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new MainWindow();
    }
}
