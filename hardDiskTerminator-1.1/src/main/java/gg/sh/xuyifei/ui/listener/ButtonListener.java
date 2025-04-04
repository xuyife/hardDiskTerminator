package gg.sh.xuyifei.ui.listener;

import gg.sh.xuyifei.commons.constant.Constant;
import gg.sh.xuyifei.core.Start;
import gg.sh.xuyifei.ui.window.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * 监听按钮事件
 */
public class ButtonListener implements ActionListener {

    private final MainWindow mainWindow;
    private String choosePath;
    public ButtonListener(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 获取监听号
        String actionCommand = e.getActionCommand();
        System.out.println("actionCommand=" + actionCommand);
        // 监听判断
        if (Constant.CHOOSE_BTN_ACTION_COMMAND.equals(actionCommand)) {
            doChoosePath();
        } else if (Constant.START_BTN_ACTION_COMMAND.equals(actionCommand)) {
            start();
        }
    }

    private void start() {
        if (choosePath == null || choosePath.equals("")) {
            JOptionPane.showMessageDialog(mainWindow, "请选择榨干盘符！", "请选择榨干盘符！", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int option = JOptionPane.showConfirmDialog(mainWindow, "<html>确定开始榨干吗？<br/><strong style=\"color: red;\">注意：此操作可能会减少硬盘寿命，或损坏硬盘，请谨慎使用！如硬盘损坏，本人不负责！</strong></html>", "确定开始榨干吗？", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String mode = "";
            for (Component c : mainWindow.panel.getComponents()) {
                if (c instanceof JRadioButton) {
                    if (((JRadioButton) c).isSelected()) {
                        mode += ((JRadioButton) c).getActionCommand();
                    }
                }
            }
            System.out.println(mode);
            Start start = new Start(choosePath, mainWindow, mode);
            if (start.isSuccess) {
                JOptionPane.showMessageDialog(mainWindow, "榨干成功", "榨干成功", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(mainWindow, "榨干失败，传输文件时出现错误！", "错误", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void doChoosePath() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = fileChooser.showOpenDialog(mainWindow);
        if (option == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getPath();
            // 判断path是否符合要求
            char da = 'A';
            for (int i = 0; i < 26; i++) {
                if (path.equals(da + ":\\")) {
                    mainWindow.pathTextLabel.setText(path);
                    choosePath = path;
                    return;
                } else {
                    if (da == 'Z') {
                        JOptionPane.showMessageDialog(mainWindow, "请选择盘符!", "错误", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    da++;
                }
            }
        }
    }
}
