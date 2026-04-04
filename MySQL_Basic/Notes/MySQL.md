# MySQL

[toc]



## 一、 MySQL相关概述

## 数据库相关概念

**数据库管理系统（DBMS）**DataBase：按照一定的数据结构来组织、存储和管理数据的仓库

**数据库（DB）**Database Management System

**关系型数据库管理系统（RDBMS）**Relational Database Management System

**非关系型数据库：**不使用关系型数据库结构的数据库，是对关系型数据库的补充

**结构化查询语言（SQL）**Structured Query Language：一种操作关系型数据库的编程语言，定义了一套操作关系型数据库统一SQL标准



**关系型数据库（RDBMS）**

**概念：**由多张相互关联的二维表组成的数据库

**特点：**

* **使用表结构存储数据**，格式统一，便于维护
* **使用SQL语言操作**，标准统一，使用方便

不通过表结构存储数据的数据库被称为非关系型数据库



**MySQL数据库的数据模型**

下载完MySQL之后，一单计算机运行了MySQL进程，计算机就可以被当作为MySQL数据库服务器**Server**。

客户端连接到MySQL数据库中的**数据库管理系统DBMS**，可以通过**SQL语句**通过DBMS来创建数据库，也可以通过SQL语句来通过数据库管理系统在指定的数据库中创建不同的表。

在一个数据库管理系统中可以创建多个数据库，在一个数据库中可以创建多张表（二维表），在表中可以存储多个记录

<img src="./images\image-20260402180349474.png" alt="image-20260402180349474" style="zoom:67%;" />



**MySQL启动**

在Powershell中输入`net start mysql84`(我的版本为8.4)，输入`net stop mysql84`则会关闭



**MySQL客户端连接**

1. 使用自带的客户端命令行
2. 在powershell中输入`mysql [-h 127.0.0.1][-p 3306] -u root -p`。  



## 二、SQL语句

**SQL通用语法**

* SQL语句可以单行或多行书写，**以分号结尾**
* SQL语句可以使用空格/缩进来增强语句的可读性
* MySQL数据库的SQL语句不区分大小写，关键字建议使用大写
* 注释：
  *  单行注释： -- 注释内容 或 # 注释内容（MySQL特有）
  * 多行注释： /* 注释内容*/

**MySQL数据类型**

**数值类型：**

**1. 整数类型**

| 类型          | 大小   | 有符号范围 (Signed)                                    | 无符号范围 (Unsigned)          | 描述     |
| :------------ | :----- | :----------------------------------------------------- | :----------------------------- | :------- |
| TINYINT       | 1 字节 | -128 ~ 127                                             | 0 ~ 255                        | 小整数   |
| SMALLINT      | 2 字节 | -32,768 ~ 32,767                                       | 0 ~ 65,535                     | 大整数   |
| MEDIUMINT     | 3 字节 | -8,388,608 ~ 8,388,607                                 | 0 ~ 16,777,215                 | 大整数   |
| INT / INTEGER | 4 字节 | -2,147,483,648 ~ 2,147,483,647                         | 0 ~ 4,294,967,295              | 大整数   |
| BIGINT        | 8 字节 | -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807 | 0 ~ 18,446,744,073,709,551,615 | 极大整数 |

**2. 浮点数类型**

* FLOAT: 4 字节，单精度浮点数，范围：-3.402823466 E+38 ~ 3.402823466351 E+38，近似值
* DOUBLE: 8 字节，双精度浮点数，范围：-1.7976931348623157 E+308 ~ 1.7976931348623157 E+308，近似值
* DECIMAL(M, D): 精确值，M 是总位数，D 是小数位数。例如，DECIMAL(5, 2)可以存储 123.45

---

**字符串类型**

| 类型       | 大小 / 限制                  | 描述                       |
| :--------- | :--------------------------- | :------------------------- |
| CHAR(N)    | 固定长度，最多 255 个字符    | 检索速度快                 |
| VARCHAR(N) | 可变长度，最多 65,535 个字符 | 常用，根据实际长度占用空间 |
| TINYBLOB   | 不超过 255 个字符            | 二进制形式短文本           |
| TINYTEXT   | 最多 255 个字符              | 短文本字符串               |
| BLOB       | 最多 65,535 字符             | 二进制形式长文本数据       |
| TEXT       | 最多 65,535 字符             | 长文本数据                 |
| MEDIUMBLOB | 最多 16,777,215 字符         | 二进制形式中等长度文本     |
| MEDIUMTEXT | 最多 16,777,215 字符         | 中等长度文本数据           |
| LONGBLOB   | 最多 4,294,967,295 字符      | 二进制形式极大文本         |
| LONGTEXT   | 最多 4,294,967,295 字符      | 极大文本数据               |

---

**日期时间类型**

| 类型      | 大小   | 格式                | 范围                                       |
| :-------- | :----- | :------------------ | :----------------------------------------- |
| DATE      | 3 字节 | YYYY-MM-DD          | 1000-01-01 至 9999-12-31                   |
| TIME      | 3 字节 | HH:MM:SS            | -838:59:59 至 838:59:59                    |
| YEAR      | 1 字节 | YYYY                | 1901 至 2155                               |
| DATETIME  | 8 字节 | YYYY-MM-DD HH:MM:SS | 1000-01-01 00:00:00 至 9999-12-31 23:59:59 |
| TIMESTAMP | 4 字节 | YYYY-MM-DD HH:MM:SS | 1970-01-01 00:00:01 至 2038-01-19 03:14:07 |

---

**布尔类型**

* 类型名: BOOLEAN 或 BOOL
* 特点: 底层会自动转换成 TINYINT(1)，赋值时可以用 FALSE 和 TRUE，也可以使用 0 和 1

---

**3.4.5 枚举类型**

**ENUM**

* 语法: ENUM('value1', 'value2', ..., 'valueN')
* 特点:
    1. 只能存储预定义列表中的一个字符串。
    2. 如果没有指定默认值，那么可以取空值 NULL。指定默认值后会默认取默认值。如果未指定默认值且不能为空，会默认取第一个值。
    3. 索引会按照列表顺序从 1 开始。空字符串 '' 的索引为 0（如果允许空值）。



**SQL分类**

| 分类 | 全称                       | 说明                                                 |
| ---- | -------------------------- | ---------------------------------------------------- |
| DDL  | Data Definition Language   | 数据定义语言，用来定义数据库对象（数据库，表，字段） |
| DML  | Data Manipulation Language | 数据操作语言，用于对数据库表中的数据进行增删改       |
| DQL  | Data Query Language        | 数据查询语言，用来查询数据库中表的记录               |
| DCL  | Data Control Language      | 数据库控制语言，用来创建数据库用户、控制数据库的访问 |



### DDL语句

#### DDL-数据库操作

**查询**： 

```SQl
# 查询所有数据库
SHOW DATABASES;

# 查询当前数据库
SELECT DATABASE();
```

**创建：**

```sql
#创建
CREATE DATABASE [IF NOT EXISTS] 数据库名 [DEFAULT CHARSET 字符集] [COLLATE 排序规则];
```

括号中的是可选项，可加可不加

**删除：**

```sql
DROP DATABASE [IF EXISTS]数据库名;
```

使用：

```sql
USE 数据库名;
```





#### DDL-表操作

##### 1.DDL-表操作-创建

```sql
CREATE TABLE 表名（
	字段1  类型 [COMMENT 字段1注释] ,
	字段1  类型 [COMMENT 字段1注释] ,
	字段1  类型 [COMMENT 字段1注释] ,
	字段1  类型 [COMMENT 字段1注释] ,
	... 
	字段n  类型 [COMMENT 字段n注释] 
）[COMMENT 表注释];
```



举例创建一个表：

| id   | name | age  | gender |
| ---- | ---- | ---- | ------ |
| 1    | 张三 | 28   | 男     |
| 2    | 李四 | 29   | 男     |
| 3    | 王五 | 27   | 女     |

使用SQL建表语句如下：

```sql
		mysql> CREATE TABLE tb_user(
   			 -> id TINYINT [COMMENT '编号'],
  			 -> name VARCHAR(50) [COMMENT '姓名'],
 			 -> gender VARCHAR(1) [COMMENT '性别']
 			 -> ) [COMMENT '用户表'] ;
```



这样就创建了一个名为tb_user的表，注意在最后一个字段行后面不能有逗号，其他字段行后有逗号，所有符号必须使用英文符，不能使用中文符号,[...]中为可选字段。



##### 2.DDL-表操作-查询：

**查看当前数据库所有表**`SHOW TABLES;`  

<img src="images/image-20260402210208388.png" alt="image-20260402210208388" style="zoom: 100%;" />


  **查询表结构**`DESC 表名;`  
<img src="./images\image-20260402210140180.png" alt="image-20260402210140180" style="zoom: 85%;" />



 **查询指定表的建表语句**`SHOW CREATE TABLE 表名;`
<img src="Notes/images\image-20260402210547641.png" alt="image-20260402210547641" style="zoom: 60%;" />



##### 3.DDL-表操作-修改：

```sql
#格式
#添加字段
ALTER TABLE 表名 ADD 字段名 类型(长度) [COMMENT '注释'][约束];

#修改字段名和字段数据类型
ALTER TABLE 表名 CHANGE 旧字段 新字段 [COMMENT '注释'][约束];

#只修改数据类型
ALTER TABLE 表名 MODIFY 字段名 新数据长度(长度);

#修改表名
ALTER TABLE 表名 RENAME TO 新表名;
```





##### 4.DDL-表操作-删除：

```sql
# 格式
#删除字段
ALTER TABLE 表名 DROP 字段名;

#删除表(即删除表结构又删除表数据)
DROP TABLE [IF EXISTS] 表名;

#删除指定表，并重新创建该表(相当于清空数据)
TRUNCATE TABLE 表名;
```



**完整代码实例：**

```sql
#创建一个员工信息表
CREATE TABLE employee(
	id INT COMMENT '编号' ,
    workid VARCHAR(10) COMMENT '员工工号',
    name VARCHAR(10) COMMENT '员工姓名',
    gender CHAR(1) COMMENT '性别',
    age TINYINT COMMENT '年龄',
    idcard  CHAR(18) COMMENT '身份证号',
    workdate DATE COMMENT '入职时间'
)COMMENT '员工信息表';

#查询表
SHOW TABLES;

#查询表结构
DESC employee;

#查询建表信息
SHOW CREATE TABLE employee;

#添加字段
ALTER TABLE employee ADD nickname VARCHAR(20) COMMENT '昵称';

#修改字段和字段数据类型
ALTER TABLE employee CHANGE nickname username VARCHAR(30) COMMENT '用户名';

#删除字段
ALTER TABLE employee DROP username;

#修改表名
ALTER TABLE employee RENAME TO emp;

#删除表并重建
TRUNCATE TABLE emp;

#删除表
DROP TABLE IF EXISTS emp;
```





### DML语句

##### 1.DML-插入

```sql
# 格式
# 给指定字段添加数据
INSERT INTO 表名 (字段1,字段2,...) VALUES (值1,值2,...);

# 给所有字段添加数据
INSERT INTO 表名 VALUES (值1,值2,值3,...),;

# 批量添加数据
INSERT INTO 表名 (字段1,字段2,...) VALUES (值1,值2,...),(值1,值2,...),(值1,值2,...);

# 批量添加数据
INSERT INTO 表名 VALUES (值1,值2,...),(值1,值2,...),(值1,值2,...);
```



例如:

```sql
# 给指定字段添加数据
INSERT INTO employee (id, name, gender, age, workdate)
VALUES (3, 'wangwu', '男', 10, '2000-01-01');

# 给所有字段添加数据
INSERT INTO employee
VALUES (4, '4', 'zhaoliu', '男', 19, '987654321012345678', '2005-03-03');

# 给所有字段批量添加数据
INSERT INTO employee
VALUES (5, '5', 'xiaoming', '男', 19, '988954321012345678', '2005-03-03')
     , (6, '6', 'xiaohong', '女', 19, '191919191991919191', '2006-05-05');
```



##### 2.DML-修改

```sql
# 格式
UPDATE 表名 SET 字段1=值1,字段2=值2,...[WHERE 条件];
```

修改语句的条件可以有,也可以没有,如果没有条件,则会修改整张表的所有数据

例如:

```sql
# 修改数据,将id为1的员工信息的name字段修改为小张
UPDATE employee
SET name = '小张'
WHERE id =1;

# 修改数据,将id为2的员工信息的name修改为小王,姓名改为女
UPDATE employee
SET name = '小王',
    gender = '女'
WHERE id =2;

# 修改所有员工的入职日期为 2026-04-03
UPDATE employee
SET workdate = '2026-04-03';
```

修改多个字段,中间用逗号隔开

##### 3.DML-删除

```sql
# 格式
DELETE FROM 表名 [WHERE 条件];
```

* DELETE语句的条件可以有也可以没有,如果没有条件,则会删除整张表的所有数据
* DELETE语句不能删除单个字段的值,如果需要删除,可以使用UPDATE语句将其置为null

例如:

```sql
# 将所有gender为女的员工删除
DELETE
FROM employee
WHERE gender = '女';
```



### DQL语句

*Data Query Language*

分类:

**基本查询、条件查询、分组查询、排序查询、分页查询**

##### DQL-基本查询

```sql
# 查询多个字段
SELECT 字段1,字段2,字段3...FROM 表名;
SELECT * FROM 表名;

# 设置别名(AS可省略)
SELECT 字段1 [AS 别名1],字段2 [AS 别名2]...FROM 表名;

# 去除重复记录
SELECT DISTINCT 字段列表 FROM 表名;
```

例如:

```sql
-- 基础查询
# 查询指定字段name,id
SELECT name, id
FROM emp;

# 查询所有字段
SELECT *
FROM emp;

# 查询所有员工的入职日期,并起别名
SELECT entrydate AS '入职日期'
FROM emp;

# 查询所有员工的职位不要重复
SELECT DISTINCT job '职位'
FROM emp;

```



##### DQL-条件查询

<img src="images/image-20260404001019831.png" alt="image-20260404001019831" style="zoom:50%;" />

**条件:**

| **比较运算符**      | **功能**           | **补充/注意事项**                                   |
| ------------------- | ------------------ | --------------------------------------------------- |
| >                   | 大于               | 常用于数值或日期比较                                |
| >=                  | 大于等于           |                                                     |
| <                   | 小于               |                                                     |
| <=                  | 小于等于           |                                                     |
| =                   | 等于               | 注意：判断 NULL 不能用 =，要用 IS NULL              |
| <> 或 !=            | 不等于             | 建议统一使用一种风格，阿里手册通常不强制，但推荐 != |
| BETWEEN ... AND ... | 在某个范围之内     | **包含**最小值和最大值（闭区间）                    |
| IN(...)             | 在之后的列表中的值 | 多选一。例：`id IN(1, 2, 3)`                        |
| LIKE 占位符         | 模糊匹配           | `_` 匹配单个字符，`%` 匹配任意个字符                |
| IS NULL             | 是 NULL            | 专门用来判断数据库中的空值                          |



| **逻辑运算符** | **功能** | **补充/注意事项**                           |
| -------------- | -------- | ------------------------------------------- |
| AND 或 &&      | 并且     | 多个条件同时成立。**推荐使用关键字 AND**    |
| OR 或 \|\|     | 或者     | 多个条件任意一个成立。**推荐使用关键字 OR** |
| NOT 或 !       | 非，不是 | 取反。例：`NOT IN(1, 2)`                    |

**1.关于 BETWEEN ... AND ...**：

* **顺序不能乱**：必须是 `BETWEEN 小值 AND 大值`。如果你写 `BETWEEN 30 AND 20`，MySQL 不会报错，但它会返回空结果。

**2.关于 IS NULL vs = NULL**：

* 在 SQL 中，`NULL` 代表“未知”，它不等于任何值，甚至不等于它自己。
* **错误写法**：`WHERE age = NULL` (永远查不到结果)。
* **正确写法**：`WHERE age IS NULL`。

**3.关于逻辑运算符的优先级**：

* **AND 的优先级高于 OR**。
* 如果写 `WHERE age > 20 OR age < 10 AND gender = '男'`，SQL 会先处理 `AND`。
* **习惯**：永远给 `OR` 条件加上括号 `( )`，比如 `WHERE (age > 20 OR age < 10) AND ...`。

例如:

```sql
-- 条件查询
# 1.查询年龄等于60的员工
SELECT *
FROM emp
WHERE age = 60;

# 2.查询年龄小于20等于的员工信息
SELECT *
FROM emp
WHERE age <= 20;

# 3.查询没有职位的员工信息
SELECT *
FROM emp
WHERE job IS NULL;

# 4.查询有职位的员工信息
SELECT *
FROM emp
WHERE job IS NOT NULL;

# 查询年龄不等于88的员工信息
SELECT *
FROM emp
WHERE age != 88;

SELECT *
FROM emp
WHERE age <> 88;

# 查询性别为女且年龄小于25岁的员工信息
SELECT *
FROM emp
WHERE age < 25 && job = '会计';

# 查询年龄在15岁(包含)到20岁(包含)且薪资在7000(包含)到15000(包含)的员工信息
SELECT *
FROM emp
WHERE age BETWEEN 15 AND 20 && salary >= 7000
  AND salary <= 15000;

# 查询年龄等于18或20或者40的员工信息
SELECT *
FROM emp
WHERE age = 18
   OR age = 20
   OR age = 40;

SELECT *
FROM emp
WHERE age IN (18, 20, 40);

# 查询所有姓名为2个字的员工信息
SELECT *
FROM emp
WHERE name like '__';

# 查询所有入职日期为该月5号的员工信息
SELECT *
FROM emp
WHERE entrydate like '%05';
```

**聚合函数:**

| **函数**  | **功能** | **例子**   | **补充**                        |
| --------- | -------- | ---------- | ------------------------------- |
| **COUNT** | 统计数量 | `COUNT(*)` | 统计总行数（最常用，包含 NULL） |
| **SUM**   | 求和     | `SUM(age)` | 仅对数值类型有效                |
| **AVG**   | 平均值   | `AVG(age)` | 仅对数值类型有效                |
| **MAX**   | 最大值   | `MAX(age)` | 可用于数值、日期、字符串        |
| **MIN**   | 最小值   | `MIN(age)` | 可用于数值、日期、字符串        |

注意事项:

1. NULL 值会自动被“无视”

所有的聚合函数（除了 `COUNT(*)`）都会**自动忽略 NULL 值**。

* **例子**：如果公司有 10 个人，其中 2 个人没填工资（NULL）。
* 执行 `AVG(salary)` 时，分母是 **8**，而不是 10。
* 执行 `COUNT(salary)` 时，结果也是 **8**。

> **建议**：统计总行数永远用 **`COUNT(*)`**，它是数据库专门优化过的，既准又快。

2. 不能在 WHERE 子句中直接使用聚合函数

* **错误写法**：`SELECT * FROM emp WHERE age = MAX(age);` （报错：Invalid use of group function）
* **原因**：`WHERE` 是在聚合之前过滤行的。你还没聚合呢，哪来的 `MAX`？
* **正确姿势**：以后我们会学“子查询”或者 `HAVING` 来解决这个问题。



例如:

```sql
-- 聚合函数
# 1.统计该企业员工数量(null值不参与计算)
SELECT COUNT(*) AS '员工数量'
FROM emp;

# 2.统计该企业员工的平均年龄
SELECT AVG(age) AS '平均年龄'
FROM emp;

# 3.统计该企业员工的最大年龄
SELECT MAX(age) AS '最大年龄'
FROM emp;

# 4.统计该企业员工的最小年龄
SELECT MIN(age) AS '最小年龄'
FROM emp;

# 5.统计该企业职位为开发的员工的薪资之和
SELECT SUM(salary) AS '开发部总薪资'
FROM emp
WHERE job = '开发';
```



##### DQL-分组查询

```sql
# 格式
SELECT 字段列表 FROM 表名 [WHERE 条件] GROUP BY 分组字段名 [HAVING 分组后过滤条件];
```

***WHERE和HAVING的区别(重点!!!)*:**

* WHERE是在**分组前**进行过滤，不满足条件的数据不参与分组，且**不能**在WHERE中写聚合函数

* HAVING是在**分组后对分组后的结果进行过滤**，**可以**（且通常必须）配合聚合函数使用



注意事项:

* 执行顺序: WHERE>聚合函数>HAVING
* 分组之后,查询的字段一般是聚合函数和分组字段,查询其他字段没有意义

举例：

```sql
-- 分组查询

# 根据职位分组,统计不同职位的员工数量
SELECT job, COUNT(*)
FROM emp
GROUP BY job;

# 根据职位分组,统计不同职位的员工的平均年龄
SELECT job, AVG(age)
FROM emp
GROUP BY job;

# 查询年龄小于45的员工,并根据职位分组,获取员工数量大于等于3的职位
SELECT job, COUNT(*)
FROM emp
WHERE age < 45
GROUP BY job
HAVING (COUNT(*) >= 2);
```



##### DQL-排序查询

```sql
SELECT 字段列表 FROM 表名 [WHERE 条件] [GROUP BY 分组字段] [HAVING 过滤] ORDER BY 字段1 排序方式1, 字段2 排序方式2;
```

**ASC**：升序（默认值）。从小到大，默认是升序，所以可以省略不写

**DESC**：降序。从大到小

如果是多个字段排序,当第一个字段值相同时,才会根据第二个字段进行排序

举例：

```sql
-- 排序查询

# 1.根据年龄对公司的员工进行升序排序
SELECT *
FROM emp
ORDER BY age ASC;

SELECT *
FROM emp
ORDER BY age;  # 默认采用升序,所以ASC可以省略不写


# 2.根据入职时间,对员工进行降序排序
SELECT *
FROM emp
ORDER BY entrydate DESC ;

# 3.根据年龄对公司的员工进行升序排序,年龄相同,再按照入职时间降序排序
SELECT *
FROM emp
ORDER BY age , entrydate DESC ;
```



##### DQL-分页查询

```sql
# 格式
SELECT 字段列表 FROM 表名 LIMIT 起始索引, 查询记录数;
```

**起始索引 = (页码 - 1) * 每页展示记录数**

如果起始索引是 **0**，可以简写,  例如:`LIMIT 0, 10` 等价于 `LIMIT 10`。

**方言问题:**`LIMIT` 是 **MySQL 的方言**。如果使用 Oracle，分页得用 `ROWNUM` 或者 `OFFSET FETCH`，语法完全不同。这是面试常问的数据库差异点。

举例:

```sql
-- 分页查询

# 1. 查询第一页的员工数据,每页展示5条记录
SELECT *
FROM emp
LIMIT 0,5;

# 2. 查询第三页的员工数据,每页展示5条记录
SELECT *
FROM emp
LIMIT 10,5;
```





##### DQL总结:

| **模块**     | **核心关键字**                      | **关键点 / 潜规则**                                          |
| ------------ | ----------------------------------- | ------------------------------------------------------------ |
| **基础查询** | `AS`, `DISTINCT`                    | `AS` 起别名建议带空格；`DISTINCT` 去重作用于所有选定列。     |
| **条件查询** | `BETWEEN...AND`, `IN`, `LIKE`       | `_` 匹配单个，`%` 匹配任意；`IS NULL` 是判断空的唯一正确姿势。 |
| **聚合函数** | `COUNT`, `SUM`, `AVG`, `MAX`, `MIN` | **纵向计算**。自动忽略 NULL 值；`COUNT(*)` 是统计总行数的神。 |
| **分组查询** | `GROUP BY`, `HAVING`                | `WHERE` 不能接聚合函数，`HAVING` 可以。`SELECT` 字段必须与分组字段对应。 |
| **排序查询** | `ORDER BY`, `ASC`, `DESC`           | 多字段排序时，只有当前一个字段值相同时，才会启动第二个字段排序。 |
| **分页查询** | `LIMIT`                             | 索引从 0 开始。公式：`起始索引 = (页码 - 1) * 每页条数`。    |

**注意事项:**

1. **关于通配符**：尽量避免 `LIKE '%关键词'`（以百分号开头），因为这会导致全表扫描，性能极差。

2. **关于聚合与 WHERE**：`WHERE` 运行在 `GROUP BY` 之前。想根据“平均分”或者“总人数”来过滤需使用 `HAVING`。

3. **关于 SELECT ***：在练习时用 `*` 很爽，但在真实项目中，需**明确写出字段名**。这不仅能提高性能，还能防止以后表结构变动导致的代码崩溃。

**执行顺序:**

`FROM` (去哪找)

`WHERE` (初步筛选)

`GROUP BY` (分组)

`HAVING` (分组后筛选)

`SELECT` (挑出列)

`ORDER BY` (排序)

`LIMIT` (最后截取分页结果)

