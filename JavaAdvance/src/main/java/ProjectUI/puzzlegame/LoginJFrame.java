package ProjectUI.puzzlegame;

import javax.swing.*;
//登录界面
public class LoginJFrame extends JFrame {


    //空参构造时直接初始化
    public LoginJFrame() {

        initFrame();


        //设置可视性
        this.setVisible(true);
    }

    private void initFrame() {
        //设置宽高
        this.setSize(488, 430);

        //设置界面的标题
        this.setTitle("陈氏拼图 登录");

        //设置界面置顶处于最上方
        this.setAlwaysOnTop(true);

        //设置界面居中
        this.setLocationRelativeTo(null);

        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
