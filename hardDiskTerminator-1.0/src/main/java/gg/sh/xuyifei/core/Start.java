package gg.sh.xuyifei.core;

import gg.sh.xuyifei.ui.window.MainWindow;

import java.io.*;

public class Start {

    public boolean isSuccess;

    public Start(String path, MainWindow mainWindow) {
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
        }
        sets = "fsutil file createnew " + folderPath + "sysData" + " " + usableSpace;
        try {
            Runtime.getRuntime().exec(sets);
        } catch (IOException e) {
            e.printStackTrace();
            isSuccess = false;
        }
        isSuccess = true;
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
