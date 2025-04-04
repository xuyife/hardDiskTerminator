package gg.sh.xuyifei.core;

import gg.sh.xuyifei.commons.constant.Constant;
import gg.sh.xuyifei.ui.window.MainWindow;

import javax.swing.*;
import java.io.*;

public class Start {

    public boolean isSuccess;

    public Start(String path, MainWindow mainWindow, String mode) {
        String folderPath = path + "system/";
        File folder = new File(folderPath);
        if (folder.exists()) {
            deleteFile(folder);
        }
        folder.mkdir();
        File disk = new File(path);
        long usableSpace = disk.getUsableSpace();
        System.out.println(usableSpace + "字节");
        String sets = "attrib +H \"" + folder.getAbsolutePath() + "\"";
        try {
            Runtime.getRuntime().exec(sets);
        } catch (IOException e) {
            e.printStackTrace();
            isSuccess = false;
            return;
        }
        if (mode.equals(Constant.COMMAND_MODE_BTN_ACTION_COMMAND)) {
            sets = "fsutil file createnew " + folderPath + "sysData" + " " + usableSpace;
            try {
                Runtime.getRuntime().exec(sets);
            } catch (IOException e) {
                e.printStackTrace();
                isSuccess = false;
                return;
            }
            isSuccess = true;
        } else if (mode.equals(Constant.WRITE_MODE_BTN_ACTION_COMMAND)){
            JOptionPane.showMessageDialog(mainWindow, "<html>榨干进行中，写入式榨干时间漫长，取决于电脑处理速度和硬盘剩余大小，<br/>可能需要1小时甚至更长，请不用一直盯着</html>");
            String text = "1";
            try (FileOutputStream fos = new FileOutputStream(folderPath + "sysData")) {
                long currentPosition = 0;
                while (currentPosition < usableSpace) {
                    fos.write(text.getBytes());
                    currentPosition += text.length();
                    if (currentPosition > usableSpace) {
                        fos.write(text.substring(0, (int) (usableSpace - currentPosition + text.length())).getBytes());
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                isSuccess = false;
                return;
            }
            isSuccess = true;
        }
    }

    private static void deleteFile(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                deleteFile(f);
            } else {
                f.delete();
            }
        }
        file.delete();
    }
}
