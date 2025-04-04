package gg.sh.xuyifei.core;

import javax.swing.JFrame;   //顶层容器 (框架)
import javax.swing.JPanel; //中间容器
import javax.swing.JLabel;   //标签
import javax.swing.JRadioButton; //单选框实现类
import javax.swing.ButtonGroup;  //按钮组类

public class TestDemo3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Radio Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setLayout(null);  // 使用绝对布局

        JRadioButton radioButton1 = new JRadioButton("Option 1");
        radioButton1.setBounds(50, 30, 100, 30);
        panel.add(radioButton1);

        JRadioButton radioButton2 = new JRadioButton("Option 2");
        radioButton2.setBounds(50, 70, 100, 30);
        panel.add(radioButton2);

        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);

        frame.add(panel);
        frame.setVisible(true);
    }
}
