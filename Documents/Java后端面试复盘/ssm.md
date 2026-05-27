# SSM 面试

## 一、整体认知

### SSM 分别指什么？

### Spring、Spring MVC、MyBatis 分别解决什么问题？

### Spring Boot 和传统 SSM 有什么区别？

### Spring Boot 相比传统 SSM 简化了什么？

### Starter 是什么？

### 自动配置是什么？

### application.yml / application.properties 是什么？

### 为什么现在项目里很少手写大量 XML 配置？

## 二、Spring 核心

### Spring 是什么？

### 为什么要使用 Spring？

### Spring 的核心思想是什么？

### 什么是 IOC？

### 什么是 DI？

### IOC 和 DI 的关系是什么？

### Bean 是什么？

### Spring 容器是什么？

### IOC 有什么好处？

### Spring 依赖注入有哪些方式？

### 为什么更推荐构造方法注入？

### @Autowired 和 @Resource 的区别？

### @Qualifier 有什么用？

### @Component、@Controller、@Service、@Repository 的区别？

### @Configuration 是什么？

### @Bean 是什么？

### @Component 和 @Bean 的区别？

### Bean 的生命周期大概是什么？

### Spring Bean 默认是单例还是多例？

### singleton 和 prototype 的区别？

### Bean 的作用域有哪些？

## 三、Spring AOP

### AOP 是什么？

### 为什么需要 AOP？

### AOP 适合解决什么问题？

### AOP 中的连接点、切入点、通知、切面分别是什么？

### AOP 有哪些通知类型？

### @Before、@After、@AfterReturning、@AfterThrowing、@Around 的区别？

### Spring AOP 底层是怎么实现的？

### JDK 动态代理和 CGLIB 动态代理的区别？

### 项目中哪些场景会用到 AOP？

## 四、Spring 事务

### @Transactional 是什么？

### Spring 事务是怎么实现的？

### Spring 事务和 AOP 有什么关系？

### @Transactional 默认回滚哪些异常？

### checked exception 会不会默认回滚？

### rollbackFor 有什么用？

### 事务传播行为是什么？

### REQUIRED 和 REQUIRES_NEW 的区别？

### 常见事务传播行为有哪些？

### 事务隔离级别有哪些？

### @Transactional 常见失效场景有哪些？

### 为什么同一个类内部方法调用会导致事务失效？

### 项目中哪些业务场景适合加事务？

## 五、Spring MVC

### Spring MVC 是什么？

### Spring MVC 和 Spring 的关系是什么？

### DispatcherServlet 是什么？

### Spring MVC 请求执行流程是什么？

### 前后端分离项目中 Spring MVC 如何返回 JSON？

### @Controller 和 @RestController 的区别？

### @RequestMapping、@GetMapping、@PostMapping、@PutMapping、@DeleteMapping 的区别？

### @RequestParam 是什么？

### @PathVariable 是什么？

### @RequestBody 是什么？

### @RequestHeader 是什么？

### @RequestParam、@PathVariable、@RequestBody 的区别？

### 前端 JSON 如何绑定到 DTO？

### @ResponseBody 是什么？

### 为什么项目中要使用统一返回结果？

### DTO、VO、Entity 的区别？

### Spring MVC 如何做 JSON 序列化和反序列化？

## 六、拦截器与异常处理

### Interceptor 是什么？

### 拦截器的 preHandle、postHandle、afterCompletion 分别什么时候执行？

### 拦截器和过滤器 Filter 的区别？

### 项目中 JWT 鉴权为什么适合用拦截器？

### 项目中 JWT 鉴权调用链是什么？

### @ControllerAdvice / @RestControllerAdvice 是什么？

### @ExceptionHandler 是什么？

### 为什么要做统一异常处理？

### 项目中一般怎么处理异常？

## 七、MyBatis 基础

### MyBatis 是什么？

### MyBatis 解决了什么问题？

### MyBatis 和 JDBC 的区别？

### MyBatis 和 JPA / Hibernate 的区别？

### MyBatis 为什么叫半 ORM 框架？

### Mapper 接口是什么？

### Mapper XML 是什么？

### Mapper 接口的方法如何和 XML 中的 SQL 对应？

### namespace 有什么作用？

### id 有什么作用？

### parameterType 是什么？

### resultType 是什么？

### resultMap 是什么？

### resultType 和 resultMap 的区别？

### 数据库字段名和 Java 属性名不一致怎么办？

## 八、Spring Boot 整合 MyBatis

### Spring Boot 怎么整合 MyBatis？

### mybatis-spring-boot-starter 做了什么？

### DataSource 是什么？

### SqlSession 是什么？

### SqlSessionFactory 是什么？

### SqlSessionTemplate 是什么？

### Mapper 代理对象是什么？

### @Mapper 和 @MapperScan 的区别？

### 传统 Spring 整合 MyBatis 需要配置哪些东西？

### Spring Boot 自动帮我们配置了哪些 MyBatis 相关对象？

### properties 文件和 application.yml 的关系是什么？

## 九、MyBatis SQL 编写

### #{} 和 ${} 的区别？

### 为什么 #{} 可以防止 SQL 注入？

### ${} 一般适合用在什么场景？

### MyBatis 动态 SQL 是什么？

### if 标签怎么用？

### where 标签有什么用？

### set 标签有什么用？

### foreach 标签怎么用？

### choose / when / otherwise 标签怎么用？

### MyBatis 多个参数怎么传？

### @Param 有什么用？

### 对象参数、Map 参数、集合参数分别怎么传？

### 模糊查询怎么写？

### 批量新增、批量删除、批量查询怎么写？

## 十、MyBatis 缓存

### MyBatis 一级缓存是什么？

### MyBatis 二级缓存是什么？

### 一级缓存和二级缓存的区别？

### 为什么实际项目中更常用 Redis 而不是 MyBatis 二级缓存？

## 十一、SSM 在项目中的调用链

### 一个 HTTP 请求在项目中的完整调用链是什么？

### Controller 层负责什么？

### Service 层负责什么？

### Mapper / DAO 层负责什么？

### 为什么项目要分 Controller、Service、Mapper？

### 登录接口的 SSM 调用链是什么？

### 高校详情查询接口的 SSM 调用链是什么？

### 注册验证码接口的 SSM 调用链是什么？

### 发布评价接口的 SSM 调用链是什么？

### 项目中 Redis、MySQL、OSS 分别在调用链中处于什么位置？

### 项目中的 DTO、VO、Entity 分别在哪里使用？

## 十二、面试高频综合问题

### 你项目中 Spring 是怎么管理对象的？

### 你项目中 Service 是怎么注入 Mapper 的？

### 你项目中 Controller 如何接收前端参数？

### 你项目中如何保证返回格式统一？

### 你项目中如何进行登录鉴权？

### 你项目中如何处理异常？

### 你项目中哪里用到了事务？

### 你项目中 MyBatis 的 SQL 写在哪里？

### 你项目中为什么使用 MyBatis 而不是 JPA？

### 你项目中为什么使用 Spring Boot 而不是传统 SSM？

## 十三、学习优先级

### 第一优先级：必须掌握

- IOC / DI / Bean
- 常见注解
- AOP
- @Transactional
- Spring MVC 请求流程
- Controller 参数接收
- 统一返回
- 统一异常处理
- 拦截器
- MyBatis 是什么
- Mapper 和 XML 对应
- #{} 和 ${}
- 动态 SQL
- Spring Boot 整合 MyBatis
- 项目调用链

### 第二优先级：了解即可

- Bean 生命周期
- Bean 作用域
- 事务传播行为细节
- MyBatis 缓存
- SqlSessionFactory 细节
- 传统 XML 整合过程

### 第三优先级：暂时不深挖

- Spring 源码
- BeanFactory / ApplicationContext 深层源码
- 循环依赖源码
- AOP 代理源码细节
- MyBatis 插件源码
- 传统 SSM 大量 XML 配置细节
