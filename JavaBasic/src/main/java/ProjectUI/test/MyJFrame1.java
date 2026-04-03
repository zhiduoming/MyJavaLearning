package ProjectUI.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyJFrame1 extends JFrame implements ActionListener {

    JButton jbt1=new JButton("点我啊");
    JButton jbt2=new JButton("再点我啊");

    public MyJFrame1() {
        this.setSize(500, 500);

        this.setTitle("My Frame");

        this.setAlwaysOnTop(true);

        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setLayout(null);

        jbt1.setBounds(0,0,200,150);
        jbt2.setBounds(200,0,200,150);
        jbt1.addActionListener(this);
        jbt2.addActionListener(this);

        this.getContentPane().add(jbt1);
        this.getContentPane().add(jbt2);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jbt1){
            jbt1.setSize(400,300);
        }else if(e.getSource()==jbt2){
            Random r=new Random();
            jbt2.setBounds(r.nextInt(500),r.nextInt(300),100,100);
        }
    }
}


