package reflection.Demo;

import java.lang.reflect.*;

public class ReflectionDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        /*
        获取class对象的三种方式：
        1.Class.forName("全类名")
        2.类名.class
        3.对象.getClass
         */
        //第一种方式获取class对象
        Class clazz = Class.forName("reflection.Demo.Student");
        //获取构造方法
        Constructor constructor = clazz.getDeclaredConstructor(String.class,int.class,String.class);
        /*//获取参数个数
        int parameterCount = constructor.getParameterCount();
        //获取参数
        Parameter[] parameters = constructor.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter);
        }
        System.out.println(parameterCount);
        //获取参数类型
        Class[] parameterTypes = constructor.getParameterTypes();
        for (Class parameterType : parameterTypes) {
            System.out.println(parameterType);
        }
        //获取class对应的实例对象
        Object object = constructor.newInstance("zhangsan",23,"男");

        //获取成员变量
        //获取公共的成员变量
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        //所有成员变量
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);*//*output: private java.lang.String reflection.Demo.Student.name
private int reflection.Demo.Student.age
public java.lang.String reflection.Demo.Student.gender*//*
             }
        //获取单个的公共的成员变量
        Field gender = clazz.getField("gender");
        System.out.println(gender);  //output:  public java.lang.String reflection.Demo.Student.gender
        //获取单个的任何权限的成员变量
        Field name = clazz.getDeclaredField("name");
        System.out.println(name);   //output:private java.lang.String reflection.Demo.Student.name
        Student stu =new Student("zhangsan",23,"男");
        //临时取消权限校验
        name.setAccessible(true);
        //获取成员变量对应的值
        Object value = name.get(stu);
        System.out.println(value);*/
        //获取class对应的实例对象
        Object object = constructor.newInstance("zhangsan",23,"男");

        //获取指定的单一方法
        //eat方法被private修饰，所有要使用getDeclaredMethod,传递方法的名字和方法的形参
        Method method = clazz.getDeclaredMethod("eat", String.class);

        //获取方法的修饰符
        int modifiers = method.getModifiers();
        System.out.println(modifiers);

        //获取方法的名字
        String name = method.getName();
        System.out.println(name);

        //获取方法的参数
        Parameter[] parameters = method.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter);
        }

        //获取方法抛出的异常
        Class[] exceptionTypes = method.getExceptionTypes();
        for (Class exceptionType : exceptionTypes) {
            System.out.println(exceptionType);
        }

        //方法调用
        Student stu =new Student("zhangsan",24,"男");
        method.setAccessible(true);
        String result = (String) method.invoke(stu, "汉堡包");
        System.out.println(result);
    }
}
