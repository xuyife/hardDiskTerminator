package gg.sh.xuyifei.core;

import gg.sh.xuyifei.ui.window.MainWindow;

public class TestDemo2 {
    public static void main(String[] args) {
        System.out.println(MainWindow.class.getResource("/image/avagk-a82jo-001.ico").toString().substring(6));
    }

}
