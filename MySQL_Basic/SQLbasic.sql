# 创建一个新的员工表
CREATE TABLE emp
(
    id        int AUTO_INCREMENT COMMENT 'ID' KEY,
    name      varchar(50) NOT NULL COMMENT '姓名',
    age       int COMMENT '年龄',
    job       varchar(20) COMMENT '职位',
    salary    int COMMENT '薪资',
    entrydate date COMMENT '入职时间',
    managerid int COMMENT '直质领导ID',
    dept_id   int COMMENT '部门ID'
) COMMENT '员工表1';

# 添加数据
INSERT INTO emp
VALUES (1, '金庸', 66, '总裁', 20000, '2000-01-01', NULL, 5),
       (2, '张无忌', 20, '项目经理', 12500, '2005-12-05', 1, 1),
       (3, '杨逍', 33, '开发', 8400, '2000-11-03', 2, 1),
       (4, '韦一笑', 48, '开发', 11000, '2002-02-05', 2, 1),
       (5, '常遇春', 43, '开发', 10500, '2004-07-09', 3, 1),
       (6, '小昭', 19, '程序员鼓励师', 6600, '2004-10-12', 2, 1),
       (7, '灭绝', 60, '财务总监', 8500, '2002-09-12', 1, 3),
       (8, '周芷若', 19, '会计', 4800, '2006-06-02', 7, 3),
       (9, '丁敏君', 23, '出纳', 5250, '2009-05-12', 7, 3),
       (10, '赵敏', 20, '市场部总监', 12500, '2002-02-05', 1, 2),
       (11, '鹿杖客', 56, '职员', 3750, '2006-12-05', 10, 2),
       (12, '鹤笔翁', 19, '职员', 3750, '2006-05-25', 10, 2),
       (13, '方东白', 19, '职员', 5500, '2002-11-05', 10, 2),
       (14, '张三丰', 88, '销售总监', 14000, '2003-06-15', 1, 4),
       (15, '俞莲舟', 38, '销售', 4600, '2003-07-05', 14, 4),
       (16, '宋远桥', 40, '销售', 4600, '2004-09-18', 14, 4),
       (17, '陈友谅', 42, NULL, 2000, '2010-06-16', 1, NULL);

-- ------------------------------------> 查询需求 < ----------------------------------------------------------
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
WHERE age < 25 &&/*或者使用AND*/ job = '会计';

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
WHERE name LIKE '__';

# 查询所有入职日期为该月5号的员工信息
SELECT *
FROM emp
WHERE entrydate LIKE '%05';

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
HAVING COUNT(*) >= 2;

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


-- 分页查询

# 1. 查询第一页的员工数据,每页展示5条记录
SELECT *
FROM emp
LIMIT 0,5;

# 2. 查询第三页的员工数据,每页展示5条记录
SELECT *
FROM emp
LIMIT 10,5;

USE itcast;
SHOW TABLES ;