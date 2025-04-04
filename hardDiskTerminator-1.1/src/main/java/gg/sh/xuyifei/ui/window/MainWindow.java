package gg.sh.xuyifei.ui.window;

import gg.sh.xuyifei.commons.constant.Constant;
import gg.sh.xuyifei.ui.listener.ButtonListener;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    /*
    创建组件
     */
    // 创建面板
    public final JPanel panel = new JPanel();
    // 说明文字
    public final JLabel introduceLabel = new JLabel("<html>此软件会榨干指定盘符的剩余空间，在隐藏文件夹system里有一个sysData，删除即可恢复。<br/><strong style=\"color: red;\">注意：此操作可能会减少硬盘寿命，或损坏硬盘，请谨慎使用！如硬盘损坏，本人不负责！</strong></html>");
    // 选择盘符
    public final JLabel pathLabel = new JLabel("<html>选择需榨干盘符：</html>");
    // 选择按钮
    public final JButton chooseBtn = new JButton("选择盘符");
    // 监听器
    public final ButtonListener buttonListener = new ButtonListener(this);
    // 路径显示
    public final JLabel pathTextLabel = new JLabel("");
    // 写入或命令
    public final ButtonGroup modeGroup = new ButtonGroup();
    public final JRadioButton writeModeBtn = new JRadioButton("写入模式", true);
    public final JRadioButton commandModeBtn = new JRadioButton("命令模式");
    // 榨干开始
    private final JButton startBtn = new JButton("开始榨干");

    public MainWindow() {
        // 创建窗口并加载所有组件
        contentPanel();
        this.getContentPane().add(panel);
        setTitle("硬盘终结者");
        setSize(430, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        JOptionPane.showMessageDialog(null, "本软件作者：Xuyifei, github号：xuyife, 请勿侵权","著作权声明" , JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * 加载所有组件并添加到面板
     */
    private void contentPanel() {
        // 绝对布局
        panel.setLayout(null);

        // 说明文字
        introduceLabel.setFont(new Font("黑体", Font.PLAIN, 16));
        introduceLabel.setPreferredSize(new Dimension(400, 300));
        introduceLabel.setBounds(0, -100, 400, 300);

        // 选择盘符
        pathLabel.setFont(new Font("黑体", Font.PLAIN, 16));
        pathLabel.setBounds(0, 60, 140, 100);

        // 选择按钮
        chooseBtn.setFont(new Font("黑体", Font.PLAIN, 12));
        chooseBtn.setBounds(150, 103, 85, 20);
        chooseBtn.setActionCommand(Constant.CHOOSE_BTN_ACTION_COMMAND);
        chooseBtn.addActionListener(buttonListener);

        // 路径Label
        pathTextLabel.setFont(new Font("黑体", Font.PLAIN, 12));
        pathTextLabel.setBounds(130, 103, 50, 20);

        // 写入或命令
        writeModeBtn.setFont(new Font("黑体", Font.PLAIN, 14));
        writeModeBtn.setBounds(143, 140, 100, 20);
        writeModeBtn.setToolTipText("会以1字节每单次循环的速度写入文件，时间漫长，但能有效造成伤害，减少硬盘读写寿命。");
        writeModeBtn.setActionCommand(Constant.WRITE_MODE_BTN_ACTION_COMMAND);

        commandModeBtn.setFont(new Font("黑体", Font.PLAIN, 14));
        commandModeBtn.setBounds(143, 160, 100, 20);
        commandModeBtn.setToolTipText("直接用命令创建文件，对硬盘没伤害，且对系统有一定要求。");
        commandModeBtn.setActionCommand(Constant.COMMAND_MODE_BTN_ACTION_COMMAND);

        modeGroup.add(writeModeBtn);
        modeGroup.add(commandModeBtn);

        // 榨干
        startBtn.setFont(new Font("黑体", Font.PLAIN, 12));
        startBtn.setBounds(143, 200, 100, 30);
        startBtn.setActionCommand(Constant.START_BTN_ACTION_COMMAND);
        startBtn.addActionListener(buttonListener);

        panel.add(introduceLabel);
        panel.add(pathLabel);
        panel.add(chooseBtn);
        panel.add(pathTextLabel);
        panel.add(writeModeBtn);
        panel.add(commandModeBtn);
        panel.add(startBtn);
    }
}
