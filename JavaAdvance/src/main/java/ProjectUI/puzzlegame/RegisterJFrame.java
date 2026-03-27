package ProjectUI.puzzlegame;

import javax.swing.*;
//注册界面
public class RegisterJFrame extends JFrame {

    public RegisterJFrame(){
        this.setSize(488,500);

        //设置界面的标题
        this.setTitle("陈氏拼图  注册");

        //设置界面置顶处于最上方
        this.setAlwaysOnTop(true);

        //设置界面居中
        this.setLocationRelativeTo(null);

        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        this.setVisible(true);
    }
}
