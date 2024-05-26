package gg.sh.xuyifei.core;

import com.sun.management.OperatingSystemMXBean;
import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.text.DecimalFormat;

public class TestDemo1 extends TestCase {
    public static void main(String[] args) throws IOException {
        getDiskInfo();
        getMemoryInfo();
    }
    /**
     * 获取系统各个硬盘的总容量、已经使用的容量、剩余容量和使用率
     * @throws IOException
     */
    public static void getDiskInfo() throws IOException {
        DecimalFormat df = new DecimalFormat("#0.00");
        File file = new File("I:\\");
// 获取盘符
        System.out.print(file.getCanonicalPath() + "   ");
        // 获取总容量
        long totalSpace = file.getTotalSpace();
        // 获取剩余容量
        long usableSpace = file.getUsableSpace();
        // 获取已经使用的容量
        long freeSpace = totalSpace - usableSpace;
        // 获取使用率
        float useRate = (float)((freeSpace * 1.0 / totalSpace) * 100);
        System.out.print("总容量： " + transformation(totalSpace));
        System.out.print("已经使用： " + transformation(freeSpace));
        System.out.print("剩余容量： " + usableSpace);
        System.out.println("使用率： " + Double.parseDouble(df.format(useRate)) + "%   ");

    }
    /**
     * 获取内存使用情况
     */
    public static void getMemoryInfo() {
        OperatingSystemMXBean mem = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        // 获取内存总容量
        long totalMemorySize = mem.getTotalPhysicalMemorySize();
        // 获取可用内存容量
        long freeMemorySize = mem.getFreePhysicalMemorySize();
        System.out.println("内存总容量：" + transformation(totalMemorySize) );
        System.out.println("可用容量：" + transformation(freeMemorySize));
    }
    /**
     * 将字节容量转化为GB
     */
    public static String transformation(long size){
        return size / 1024 / 1024 / 1024 + "GB"+"   ";
    }
}
