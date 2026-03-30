package ProjectUI.puzzlegame;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

//游戏的主界面
public class GameJFrame extends JFrame implements KeyListener, ActionListener {

    int[][] arr = new int[4][4];
    int x = 0;
    int y = 0;
    int[][] win ={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
    int step=0;
    Random r=new Random();
    String path="..\\Java_Learning\\JavaAdvance\\src\\main\\java\\ProjectUI\\image\\girl\\girl"+r.nextInt(1,14)+"\\";

    JMenuItem replayJMenuItem = new JMenuItem("重新游戏");
    JMenuItem reloginJMenuItem = new JMenuItem("重新登录");
    JMenuItem closeJMenuItem = new JMenuItem("关闭游戏");

    JMenuItem accountItemJMenuItem = new JMenuItem("公众号");

    JMenuItem girl=new JMenuItem("美女");
    JMenuItem animal=new JMenuItem("动物");
    JMenuItem sport=new JMenuItem("运动");



    //构造方法
    public GameJFrame() {
        //初始化界面
        initJFrame();

        //初始化菜单
        initMenu();

        //初始化数据
        initData();

        //初始化图片
        initImage();

        //设置界面的可视性
        this.setVisible(true);
    }

    //初始化数据
    private void initData() {
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        Random r = new Random();

        for (int i = 0; i < tempArr.length; i++) {

            int index = r.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }
        int count = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (tempArr[count] == 0) {
                    x = i;
                    y = j;
                }
                arr[i][j] = tempArr[count++];


            }
        }
    }


    //初始化图片
    private void initImage() {
        //移除所有图片
        this.getContentPane().removeAll();

        if(victory()){

            JLabel winjLabel =new JLabel(new ImageIcon("C:\\Code\\Java_Learning\\JavaAdvance\\src\\main\\java\\ProjectUI\\image\\win.png"));
            winjLabel.setBounds(203,283,197,73);
            this.getContentPane().add(winjLabel);
        }

        JLabel stepcount=new JLabel("步数："+step);
        stepcount.setBounds(70,30,100,20);
        this.getContentPane().add(stepcount);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = arr[i][j];
                JLabel jLabel = new JLabel(new ImageIcon(path + num + ".jpg"));

                jLabel.setBounds(j * 105 + 83, i * 105 + 134, 105, 105);
                //设置边框
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                //添加到页面中
                this.getContentPane().add(jLabel);
            }
        }

        //添加背景图片
        ImageIcon bg = new ImageIcon("C:\\Code\\Java_Learning\\JavaAdvance\\src\\main\\java\\ProjectUI\\image\\background.png");
        JLabel background = new JLabel(bg);
        background.setBounds(40, 40, 508, 560);
        this.getContentPane().add(background);

        //刷新页面
        this.getContentPane().repaint();
    }

    //初始化菜单
    private void initMenu() {
        JMenuBar jMenuBar = new JMenuBar();
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("名片");

        JMenu subjMenu=new JMenu("更换图片");
        subjMenu.add(girl);
        subjMenu.add(animal);
        subjMenu.add(sport);

        functionJMenu.add(replayJMenuItem);
        functionJMenu.add(reloginJMenuItem);
        functionJMenu.add(closeJMenuItem);
        functionJMenu.add(subjMenu);

        aboutJMenu.add(accountItemJMenuItem);

        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        replayJMenuItem.addActionListener(this);
        reloginJMenuItem.addActionListener(this);
        closeJMenuItem.addActionListener(this);
        accountItemJMenuItem.addActionListener(this);

        girl.addActionListener(this);
        animal.addActionListener(this);
        sport.addActionListener(this);

        this.setJMenuBar(jMenuBar);
    }


    //初始化界面
    private void initJFrame() {
        //设置界面的宽高
        this.setSize(603, 680);

        //设置界面的标题
        this.setTitle("陈氏拼图单机版");

        //设置界面置顶处于最上方
        this.setAlwaysOnTop(true);

        //设置界面居中
        this.setLocationRelativeTo(null);

        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //取消默认的居中放置
        this.setLayout(null);

        this.addKeyListener(this);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    //按下不松时会调用该方法
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65) {
            this.getContentPane().removeAll();
            JLabel all = new JLabel(new ImageIcon(path+"\\all.jpg"));
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);
            JLabel background =new JLabel(new ImageIcon("C:\\Code\\Java_Learning\\JavaAdvance\\src\\main\\java\\ProjectUI\\image\\background.png"));
            background.setBounds(40,40,508,560);
            this.getContentPane().add(background);

            this.getContentPane().repaint();

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(victory()){
            return;
        }

        int code = e.getKeyCode();
        if (code == 37) {
            System.out.println("向左移动");
            if (y <= 2) {
                arr[x][y] = arr[x][y + 1];
                arr[x][y + 1] = 0;
                y++;
                step++;
                initImage();
            }

        } else if (code == 38) {
            System.out.println("向上移动");
            if (x <= 2) {
                //把空白方块下方的数字赋值给空白方块
                arr[x][y] = arr[x + 1][y];
                arr[x + 1][y] = 0;
                x++;
                step++;
                initImage();
            }
        } else if (code == 39) {
            System.out.println("向右移动");
            if (y >= 1) {
                arr[x][y] = arr[x][y - 1];
                arr[x][y - 1] = 0;
                y--;
                step++;
                initImage();
            }
        } else if (code == 40) {
            System.out.println("向下移动");
            if (x >= 1) {
                arr[x][y] = arr[x - 1][y];
                arr[x - 1][y] = 0;
                x--;
                step++;
                initImage();
            }
        } else if(code==65){
            initImage();
        } else if(code==87){
            arr =new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0}
            };
            initImage();


        }
    }

    public boolean victory (){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j]!=win[i][j] )
                    return false;
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==replayJMenuItem){
            initData();
            step = 0;
            initImage();
        }else if(e.getSource()==reloginJMenuItem)
        {
            this.setVisible(false);

            new LoginJFrame();
        }else if(e.getSource()==closeJMenuItem){
            System.out.println("关闭游戏");
            System.exit(0);
        }else if(e.getSource()==accountItemJMenuItem){
            JDialog jDialog=new JDialog();
            JLabel jLabel=new JLabel(new ImageIcon("C:\\Code\\Java_Learning\\JavaAdvance\\src\\main\\java\\ProjectUI\\image\\weixin.jpg"));
            jLabel.setBounds(50,50,600,800);
            jDialog.getContentPane().add(jLabel);
            jDialog.setSize(700,900);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            jDialog.setLayout(null);
            jDialog.setModal(true);
            jDialog.setVisible(true);
        }else if(e.getSource()==girl){
            path="..\\Java_Learning\\JavaAdvance\\src\\main\\java\\ProjectUI\\image\\girl\\girl"+r.nextInt(1,14)+"\\";
            initData();
            step=0;
            initImage();
        }else if(e.getSource()==animal){
            path="..\\Java_Learning\\JavaAdvance\\src\\main\\java\\ProjectUI\\image\\animal\\animal"+r.nextInt(1,9)+"\\";
            initData();
            step=0;
            initImage();
        }else if(e.getSource()==sport){
            path="..\\Java_Learning\\JavaAdvance\\src\\main\\java\\ProjectUI\\image\\sport\\sport"+r.nextInt(1,11)+"\\";
            initData();
            step=0;
            initImage();
        }
    }
}
