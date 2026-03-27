package Oop.arraylist.Project_StudentSystem;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class StudentSystemSignIn {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        while (true) {
            System.out.println("--------------欢迎来到陈氏学生管理系统------------");
            System.out.println("请输入你的选择：1: 登录    2：注册   3：忘记密码   4:退出");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            switch (choose) {
                case "1" -> signIn(list);
                case "2" -> signUp(list);
                case "3" -> forgetPassword(list);
                case "4" -> {
                    System.out.println("退出");
                System.exit(0);
                }
                default -> System.out.println("没有这个选项！");
            }
        }
    }


    //登录界面
    public static void signIn(ArrayList<User> list) {
        User user = new User();
        Scanner sc = new Scanner(System.in);
        for (int i=0;i<3;i++) {
            System.out.println("请输入用户名：");
            String Username = sc.next();
            if(contains(list,Username)==-1){
                System.out.println("用户未注册！");
                return;
            }
            user.setUsername(Username);
            System.out.println("请输入密码：");
            String Password = sc.next();
            user.setPassword(Password);
            String Captcha =generateCaptcha();
            while (true) {
                System.out.println("验证码是："+Captcha);
                System.out.println("请输入验证码：");
                if(sc.next().equals(Captcha))
                    break;
                else
                    System.out.println("输入的验证码错误");
            }

            int index=contains(list,user.getUsername());
            if(user.getPassword().equals(list.get(index).getPassword())){
                System.out.println("登录成功！！");
                StudentSystemSignIn.System();
                return;
            }else {
                System.out.println("密码错误,你还有"+(2-i)+"次机会");
            }
        }
    }

    //注册界面
    public static void signUp(ArrayList<User> list) {
        User user = new User();
        Scanner sc = new Scanner(System.in);
        //验证用户名
        while (true) {
            System.out.println("请输入你的用户名：（长度在3~15位之间，只能是字母加数字的组合，但不能是纯数字）");
            String username = sc.next();
            if (!identifyUsername(list, username)) {
                System.out.println("输入的用户名不合法");
            } else {
                user.setUsername(username);
                break;
            }
        }
        //输入两次密码
        System.out.println("请输入你的密码：");
        String password = sc.next();
        while (true) {
            System.out.println("请确认你的密码：");
            if (sc.next().equals(password)) {
                user.setPassword(password);
                break;
            } else {
                System.out.println("密码与上次不相符");
            }
        }
        while (true) {
            //输入身份证号码
            System.out.println("请输入身份证号码：");
            String ID = sc.next();
            //验证身份证号码
            if (identifyID(ID)) {
                user.setIDcard(ID);
                break;
            } else {
                System.out.println("输入的身份证号码不合法");
            }
        }
        //手机号验证
        while (true) {
            System.out.println("请输入手机号：");
            String phoneNumber = sc.next();
            if (identifyPhoneNumber(phoneNumber)) {
                user.setPhoneNumber(phoneNumber);
                break;
            } else {
                System.out.println("输入的手机号不合法");
            }
        }
        System.out.println("注册成功！");
        list.add(user);
    }

    //忘记密码
    public static void forgetPassword(ArrayList<User> list ) {
        User user =new User();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名： ");
        String username =sc.next();
        if(contains(list,username)==-1){
            System.out.println("该用户名未注册!");
            return;
        }
        System.out.println("请输入身份证号码：");
        String ID =sc.next();
        user.setIDcard(ID);
        System.out.println("请输入电话号码： ");
        String phoneNumber =sc.next();
        user.setPhoneNumber(phoneNumber);
        //判断输入的身份证号码和电话号码是否和已经注册的同名用户名的相一致
        int index =contains(list,username);
        if(ID.equals(list.get(index).getIDcard())&&phoneNumber.equals(list.get(index).getPhoneNumber())){
            System.out.println("请输入新的密码:");
            String newpassword =sc.next();
            list.get(index).setPassword(newpassword);
            System.out.println("密码修改成功!");
        }else{
            System.out.println("账号信息不匹配，修改失败！");
        }

    }

    //判断用户名是否合法
    public static boolean identifyUsername(ArrayList<User> list, String username) {
        //判断唯一性
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().equals(username)) {
                return false;
            }
        }
        //判断长度
        if (username.length() < 3 || username.length() > 15) {
            return false;
        }
        //判断字符类型
        boolean allnum = true;
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            //只要出现字母，就将allnum设为false
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))) {
                return false;
            } else if (c >= 'A') {
                allnum = false;
            }
        }
        return !allnum;
    }

    //判断身份证号码是否合法
    public static boolean identifyID(String ID) {
        if (ID.length() != 18) return false;
        if (ID.charAt(0) == '0') return false;
        for (int i = 0; i < ID.length() - 1; i++) {
            char c = ID.charAt(i);
            if (c < '0' || c > '9') return false;
        }
        char end = ID.charAt(ID.length() - 1);
        if (end > '9' || end < '0') {
            return end == 'x' || end == 'X';
        } else return true;
    }

    //判断手机号是否合法
    public static boolean identifyPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 11) return false;
        if (phoneNumber.charAt(0) == '0') return false;
        for (int i = 0; i < phoneNumber.length(); i++) {
            char c = phoneNumber.charAt(i);
            if (c < '0' || c > '9')
                return false;
        }
        return true;
    }

    //生成验证码
    public static String generateCaptcha() {
        StringBuilder sb = new StringBuilder();
        char[] arr = new char[62];
        for (int i = 0; i < 62; i++) {
            if(i<26){
                arr[i]=(char)('A'+i);
            }
            if(i>=26&&i<52){
                arr[i]=(char)('a'+i-26);
            }
            if(i>=52){
                arr[i]=(char)('0'+i-52);
            }
        }
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            int index=r.nextInt(52);
            sb.append(arr[index]);
        }
        int index=r.nextInt(52,62);
        sb.append(arr[index]);
        return sb.toString();
    }

    //判断是否注册
    public static int contains(ArrayList<User> list, String Username){
        for (int i = 0; i < list.size(); i++) {
            User temp =list.get(i);
            if(temp.getUsername().equals(Username))
                return i;
        }
        return -1;
    }

    public static void System() {
        ArrayList<Student> list = new ArrayList<>();
        while (true) {
            System.out.println("-----------欢迎来到陈氏学生管理系统----------");
            System.out.print("1:添加学生   2:删除学生   3:修改学生   4:查询学生   5：退出系统");
            System.out.println();
            System.out.println("请输入您的选择： ");
            Scanner sc = new Scanner(System.in);

            String choose = sc.next();
            switch (choose) {
                case "1" -> addStudent(list);
                case "2" -> deleteStudent(list);
                case "3" -> updateStudent(list);
                case "4" -> queryStudent(list);
                case "5" -> {
                    System.out.println("退出");
                    System.exit(0);
                }
                default -> System.out.println("没有这个选项");
            }
        }
    }

    //添加学生
    public static void addStudent(ArrayList<Student> list) {
        Student stu = new Student();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("请输入学生的id：");
            String id = sc.next();
            if (contains2(list, id)) {
                System.out.println("该学生已经存在，请重新录入");
            } else {
                stu.setId(id);
                break;
            }
        }


        System.out.println("请输入学生的姓名：");
        stu.setName(sc.next());

        System.out.println("请输入学生的年龄： ");
        stu.setAge(sc.nextInt());

        System.out.println("请输入学生的家庭地址： ");
        stu.setAddress(sc.next());
        list.add(stu);
        System.out.println("学生信息添加成功！");
    }

    //删除学生
    public static void deleteStudent(ArrayList<Student> list) {
        //做判断，若目前集合里无学生则提示无法删除
        if (list.isEmpty()) {
            System.out.println("当前系统内无学生对象，无法进行删除，请先添加学生");
            return;
        }
        Scanner sc = new Scanner(System.in);
        //若删除的对象不存在，则需重新录入
        while (true) {
            System.out.println("请输入要删除的学生的id");
            String sid = sc.next();
            if (!contains2(list, sid)) {
                System.out.println("要删除的学生对象不存在，请重新录入id");
            } else {
                //删除操作
                list.remove(getIndex(list, sid));
                System.out.println("删除成功");
                break;
            }
        }
    }

    //修改学生
    public static void updateStudent(ArrayList<Student> list) {
        if (list.isEmpty()) {
            System.out.println("当前无学生信息，请添加后再修改！");
            return;
        }
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("请输入你要修改的学生的id");
            String sid =sc.next();
            if(!contains2(list,sid)){
                System.out.println("该学生对象不存在，请重新录入id");
            }else{
                Student stu =list.get(getIndex(list,sid));
                System.out.println("请输入修改后的学号：");
                stu.setId(sc.next());
                System.out.println("请输入修改后的姓名：");
                stu.setName(sc.next());
                System.out.println("请输入修改后的年龄：");
                stu.setAge(sc.nextInt());
                System.out.println("请输入修改后的家庭地址：");
                stu.setAddress(sc.next());
                System.out.println("学生信息修改完成！");
                break;
            }
        }
    }

    //查询学生
    public static void queryStudent(ArrayList<Student> list) {
        if (list.isEmpty()) {
            System.out.println("当前无学生信息，请添加后再查询！");
            return;
        }
        //打印表头信息
        System.out.println("id\t\t姓名\t\t年龄\t\t家庭住址");
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.getId() + "\t\t" + stu.getName() + "\t\t" + stu.getAge() + "\t\t" + stu.getAddress());
        }
    }

    //判断学生id唯一性
    public static boolean contains2(ArrayList<Student> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            if (id.equals(list.get(i).getId())) {
                return true;
            }
        }
        return false;
    }

    //返回学生对象的索引
    public static int getIndex(ArrayList<Student> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            if (id.equals(list.get(i).getId())) {
                return i;
            }
        }
        return -1;
    }

}




