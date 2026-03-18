
# 如梦初醒

## 2025.3.16打卡 Day 1
**1. 学习JavaSE基础：**  
* 方法的定义和调用
* 方法的重载
* 方法的基本内存原理
* 封装
* 就近原则和this关键字 
* 构造方法
* API帮助文档的查询使用
* String字符串的比较、拼接、反转

**2. Java语法练习：**
* 方法重载的练习：
```java
//定义：
    public static  int getSum(int a,int b){
        return a+b;
    }
    public static  int getSum( int a,int b,int c){
        return a+b+c;
    }
    public static double getSum(double a,double b){
        return a+b;
    }
//调用:
    int result =getSum(13 ,45);
    double result2 =getSum(1.4,4.3);
    int  result3= getSum(4,6,8);
    System.out.println(result+" "+result2+" "+result3 );
//结果：58 5.7 18
```
* 生成5位数的验证码：
```java
    char[] ch = new char[52];
    int index = 0;
    for (int i = 0; i < ch.length; i++) {
        //存小写字母
        if (i <= 25) {
            ch[index++] = (char) ('a' + i);
        } else {
                 ch[index++] = (char) ('A' + i - 26);
        }
    }
```
* 数字加密：
```java
 //将每位数字存进数组
   int[] nums=new int[length];
   for(int i=0;i<length;i++){
       int digit =num%10;
       nums[i]=(digit+5)%10;
       num/=10;
   }
   得到新数字
   int newnum =0;
   for(int i=0;i<length;i++)
   {
       newnum=newnum*10+nums[i];
   }
   return newnum;
```
* 字符串练习(登录系统、统计字符串字符数、字符串反转)
* 字符串练习（金额转换）：
```java
    //将传入的数字转成大写
    public static String getCapitalNum(int a){  
        String[] str={"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
        return str[a];
    }
    public static void printCapitalNum(int num){
        String newstr="";
        while(num>0){
            int ge=num%10;
            newstr=getCapitalNum(ge)+newstr;
            num/=10;
        }
        String[] array={"佰","拾","万","仟","佰","拾","元"};
        String result="";
        for (int i = 0; i <newstr.length() ; i++) {
            result=result+newstr.charAt(i)+array[i+7-newstr.length()];
        }
        System.out.println(result);
    }
```
#ps:感觉今天收获满满


## 2026.3.17 打卡Day 2 

**1.学习Java基础**：
* StringBuilder的基本操作
* stringJoiner的基本操作
* 链式编程
* 字符串相关类的底层原理：
  * 字符串直接赋值会复用字符串常量池中的，new出来的不会进行复用，而是开辟一个新的空间
  * == 号比较时：基本数据类型比较数据值，引用数据类型比较地址值
  *  字符串拼接时：如果没有变量参与，都是字符串直接相加，编译之后就是拼接之后的结果，会复用字符串池中的字符串；  
如果有变量参与，则会创建新的字符串，浪费内存、浪费性能（拼接一次产生了两个对象，一个StringBuilder对象，一个String对象）


**2.leetcode刷题：**
1.两数之和
```java
 public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        //如果没有找到，返回一个长度为0的空数组
        return new int[0];
 }
```
4.寻找两个正序数组中的中位数（双指针）
```java
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        //定义两个指针来分别指向两个数组的首位，按照从小到大的顺序将其中元素放到大数组arr中，同时注意指针更新
        int ptr1 = 0;
        int ptr2 = 0;
        int k = 0;
        while ((ptr1 < nums1.length && ptr2 < nums2.length)) {
            if (nums1[ptr1] < nums2[ptr2]) {
                arr[k++] = nums1[ptr1++];
            } else {
                arr[k++] = nums2[ptr2++];
            }
        }
        //若比对完，则将剩下元素全部放到arr中
        while (ptr1 < nums1.length){
            arr[k++]=nums1[ptr1++];
        }
        while (ptr2 < nums2.length){
            arr[k++]=nums2[ptr2++];
        }
            //得到大数组之后从两边往中间归并
            int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            left++;
            right--;
        }
        double s=arr[left]+arr[right];
        return s/2;
    }
```
26.删除有序数组中的重复项返回删除后的长度（双指针）
```java
   public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 1;
        while (right < n) {
            if (nums[left] != nums[right]) {
                nums[++left] = nums[right];
            }
            right++;
        }
        //left是索引，所以最后长度1加一
        return left + 1;
    }
```
## 2026.3.18打卡Day 3
**1.学习Java基础：**
* 集合的基本使用
* 集合的练习  

**2.配置openclaw:**
* 成功在电脑上配置openclaw
* 成功将openclaw连接到QQ机器人
![img.png](picture/img.png)
#ps：今天的效率很低，主要事件浪费在了解决openclaw不同模型的API接入吧，
发现不同的大模型token也不同，原来养龙虾这么耗财耗力，但也终究开始成功开始养我的第一个龙虾，给它起名为一粒吧，谐音毅力，而且寓意只看眼前一厘米，踏实做好眼前事。





