# SSM 面试

## 一、整体认知

### SSM 分别指什么？

优先级：最重要

关键词：**SSM、Spring、Spring MVC、MyBatis、Java Web、分层开发**

SSM 是指 Spring、Spring MVC 和 MyBatis 三个框架的组合，常用于 Java Web 后端开发。

### Spring、Spring MVC、MyBatis 分别解决什么问题？

优先级：最重要

关键词：**Spring 管理对象、IOC、AOP、Spring MVC 接收请求、MyBatis 操作数据库**

Spring主要负责业务对象的管理和增强，核心思想是 IOC 和 AOP。IOC 是控制反转，指对象的创建、管理和对象之间的依赖关系不再由程序员手动 new，而是交给 Spring 容器统一管理。AOP 是面向切面编程，指的是在不修改原有业务代码的情况下，对方法进行增强，比如日志、事务、权限校验等。

Spring MVC 主要负责 web 层的请求处理，包括请求分发、参数绑定、调用 Controller 方法、返回响应以及 JSON 转换。在前后端分离项目中，Spring MVC 通常负责接受前端请求并返回 JSON 数据。

MyBatis 主要负责持久层数据库操作。通过 Mapper 接口和 SQL 映射文件或注解，将 Java 方法和 SQL 语句对应起来，帮助我们执行增删改查，并把数据库查询的结果映射为 Java 对象。



### Spring Boot 和传统 SSM 有什么区别？

优先级：最重要

关键词：**传统 SSM、Spring Boot、自动配置、starter、内嵌 Tomcat、减少 XML**

传统 SSM 是 Spring、Spring MVC和 MyBatis 的手动整合方式，通常需要配置 web.xml、spring.xml、springmvc.xml、mybatis-config.xml 等文件，还要手动配置数据源、SqlSessionFactory、Mapper 扫描、事务管理器和 DispatcherServlet，项目搭建和整合过程较为繁琐。

Spring Boot 是基于 Spring 生态的一套快速开发框架，它不是替代 Spring，而是通过 starter、自动配置、约定大于配置的方式简化项目搭建。使用 Spring Boot 时，通常只需要引入对应starter，在 application.yml 中配置必要参数，再通过注解开发即可。

所以二者的核心区别就是：传统 SSM 需要大量手动配置，而 Spring Boot 帮我们自动完成了很多配置，让开发变得更加简单、更快。在我的项目中主要通过 Spring Boot 启动类、application.yml、和@RestController、@Service、@Mapper等注解完成了开发，没有手动写大量的 xml 配置。

### Spring Boot 相比传统 SSM 简化了什么？

优先级：最重要

关键词：**web.xml、spring.xml、数据源、SqlSessionFactory、事务管理器、Mapper 扫描、自动配置**

相比于传统的 SSM，Spring Boot 通过 starter、自动配置和约定大于配置的方式， 把很多常用配置自动完成。比如引入 starter 后会自动配置内嵌 Tomcat、DispatcherServlet、JSON 转换等文件；引入 MyBatis starter 后会根据 application.yml 中的数据源配置自动创建 DataSource、SqlSessionFactory 等对象。

所以 Spring Boot 不是不需要配置，而是减少了大量重复的手动配置，只需要我们保留必要的业务配置，让项目搭建更快、更简单。

### Starter 是什么？

优先级：普通

关键词：**starter、起步依赖、依赖整合、spring-boot-starter-web、mybatis-spring-boot-starter**

Starter 是 Spring Boot 提供的一种依赖整合机制，本质上是一组依赖的集合。它把某个功能模块需要的相关依赖统一封装起来，开发者只需要引入对应的 starter，就不用手动一个个引入 jar 包，也减少了版本冲突问题。

比如引入 spring-boot-starter-web，就会自动引入 Spring MVC、内嵌 Tomcat，Jackson 等 web 开发相关依赖；引入 mybatis-spring-boot-starter，就会引入 MyBatis 和 Spring Boot 整合相关依赖。

Starter 通常会配合 Spring Boot 的自动配置机制使用。Starter 负责引入依赖，自动配置负责根据这些依赖和配置文件创建对应的 Bean，从而简化项目搭建。



### 自动配置是什么？

优先级：最重要

关键词：**自动配置、约定大于配置、DataSource、DispatcherServlet、消息转换器、Bean**

自动配置是 Spring Boot 的核心机制。它会根据当前项目引入的依赖、配置文件以及容器中已有的 Bean 来判断是否需要**创建和配置某些常用组件，从而减少大量手动配置**。

比如引入 spring-boot-starter-web 之后，Spring Boot 会自动配置内嵌 Tomcat、DispatcherServlet、Spring MVC 和 JSON 消息转换器；引入 mybatis-spring-boot-starter 并配置数据源后，Spring Boot 会自动配置 DataSource、SqlSessionFactory、Mapper 代理等相关组件。

自动配置底层主要依赖条件装配，比如 @ConditionalOnClass、@ConditionalOnMissingBean、@ConditionalOnProperty 等注解。他不是无脑配置，而是在满足条件时才生效。

### application.yml / application.properties 是什么？

优先级：普通

关键词：**配置文件、端口、数据库、Redis、MyBatis、properties、yml**

二者都是 Spring Boot 的核心配置文件，用来集中管理项目运行时需要的配置，比如服务端口、数据库连接、Redis、MyBatis、日志、文件上传以及第三方服务配置等。

它们的本质作用一样，只是格式不同。properties 是 key-value 形式，yml 是层级结构，配置较多时 yml 的可读性更好。

Spring Boot 会自动读取这些配置，并结合自动配置机制创建相关的 Bean。比如读取 spring.datasource 下的配置后会自动配置 DataSource；读取 server.port 后，会设置项目启动端口。

实际项目中还可以通过 application-dev.yml、application-prod.yml 区分不同的配置环境，敏感信息一般不直接提交到仓库，而是通过环境变量或.env.example 的方式管理。

### 为什么现在项目里很少手写大量 XML 配置？

优先级：普通

关键词：**注解开发、Spring Boot、自动配置、配置类、减少 XML、主流开发方式**

主要是因为 Spring Boot 通过 starter、自动配置、和注解开发简化了传统的 SSM 的配置。

传统 SSM 中需要在 web.xml、spring.xml、springmvc.xml、mybatis-config.xml 中手动配置 DispatcherServlet、组件扫描、数据源、SqlSessionFactory、Mapper 扫描、事务管理器等内容，配置比较繁琐。

Spring Boot 引入对应 starter 后，会根据依赖和 application.yml 中的配置自动创建很多常用组件。比如引入 Web starter 后自动配置内嵌 Tomcat、DispatcherServlet 和 JSON 转换器；引入 MyBatis starter 后自动配置 DataSource、SqlSessionFactory 等。再配合 @Controller、@Service、@Mapper、@Transactional 等注解，就不需要手写大量 XML 了。

不过 XML 并不是完全淘汰，比如 MyBatis 中复杂 SQL 和动态 SQL 仍然常常写在 XML 中，只是传统框架整合类 XML 配置变少了。

## 二、Spring 核心

### Spring 是什么？

优先级：最重要

关键词：**Spring、Java 企业级开发、IOC、AOP、Bean、对象管理**

Spring 是一个 Java 企业级开发框架，主要用于简化 Java 后端开发。它的核心思想是 IOC 和 AOP，IOC 用来管理对象的创建和依赖关系，AOP 用来抽取事务、日志、权限校验等公共逻辑。除此之外，Spring 还提供事务管理、Web 开发支持，并且可以方便地整合 MyBatis、Redis 等其他技术。

### 为什么要使用 Spring？

优先级：最重要

关键词：**解耦、IOC、DI、AOP、事务、开发效率、扩展性**

使用 Spring 主要是为了简化开发、降低耦合、提高项目可维护性。没有 Spring 的话，对象的创建和依赖关系需要程序员手动维护，代码之间耦合较高。Spring 通过 IOC 容器统一管理对象，通过 DI 自动注入依赖，让业务类不需要自己创建依赖对象。

同时，Spring 通过 AOP 可以统一处理事务、日志、权限校验等公共逻辑，减少重复代码。Spring 还提供事务管理和良好的框架整合能力，所以在 Java 后端项目中使用非常广泛。

### Spring 的核心思想是什么？

优先级：最重要

关键词：**IOC、DI、AOP、控制反转、面向切面编程**

Spring 的核心思想主要是 IOC 和 AOP。IOC 是控制反转，指对象的创建、管理以及对象之间的依赖关系不再由程序员手动 new 和维护，而是交给 Spring 容器统一管理，从而降低代码耦合。AOP 是面向切面编程，指在不修改原有业务代码的情况下，对方法进行增强，比如统一处理事务、日志、权限校验等公共逻辑。

### 什么是 IOC？

优先级：最重要

关键词：**IOC、控制反转、对象创建、依赖关系、Spring 容器**

IOC 是控制反转，指对象的创建、管理以及对象之间的依赖关系不再由程序员手动 new 和维护，而是交给 Spring 容器统一管理。所谓“控制反转”，就是对象创建和依赖装配的控制权从程序员手里转移到了 Spring 容器手里。

### 什么是 DI？

优先级：最重要

关键词：**DI、依赖注入、IOC 实现方式、构造器注入、属性注入**

DI 是依赖注入，是 IOC 的具体实现方式，他指的是 Spring 容器在创建 Bean 的时候，把这个 Bean 所依赖的其他 Bean 自动注入进来，从而完成对象之间依赖关系的装配。

比如Service 层依赖 Mapper 层的时候，不需要在 Service 层中手动 new Mapper，而是由 Spring 穿件 Mapper 代理对象，并注入到 Service 中。这样业务类只关注业务逻辑，不需要关心依赖对象的创建，从而降低代码耦合。

### IOC 和 DI 的关系是什么？

优先级：最重要

关键词：**IOC 思想、DI 实现、对象交给容器、依赖由容器注入**

IOC 是控制反转，是一种设计思想，IOC 是控制反转，是一种设计思想，指对象的创建和依赖关系交给 Spring 容器管理。DI 是依赖注入，是 IOC 的具体实现方式。Spring 容器创建 Bean 后，会把这个 Bean 依赖的其他 Bean 自动注入进来，从而完成对象之间依赖关系的装配。

简单来说，IOC 是目标：把对象控制权交给 Spring；DI 是手段：Spring 通过依赖注入把对象关系组装起来。

### Bean 是什么？

优先级：最重要

关键词：**Bean、Spring 容器管理对象、单例、组件对象**

Bean 是被 Spring 容器管理的对象。我们通过@Component、@Controller、@Service、@Repository 等注解标记类，Spring 在扫描过后会创建这些对象并放入容器中。之后其他 Bean 就可以通过依赖注入来使用它们。

在项目中，Controller、Service、配置类等通常都是 Bean。MyBatis 和 Spring 整合后，Mapper 代理对象也会被注册到 Spring 容器中。

### Spring 容器是什么？

优先级：最重要

关键词：**Spring 容器、ApplicationContext、Bean 管理、依赖注入、生命周期**

Spring 容器是 Spring 用来创建和管理 Bean 的核心组件。它负责 Bean 的创建、依赖注入、生命周期管理等工作。常见的 Spring 容器有 BeanFactory、ApplicationContext，实际开发中常用 ApplicationContext。

Spring 容器负责创建 Bean，保存 Bean，维护 Bean 之间的依赖关系，并在需要的时候通过依赖注入把 Bean 注入给其他 Bean使用。

### IOC 有什么好处？

优先级：最重要

关键词：**解耦、统一管理对象、依赖注入、可测试性、可维护性**

IOC 的好处主要是降低代码耦合。对象的创建和依赖关系由 Spring 容器统一管理，业务代码不需要去手动 new 依赖对象，也不用关注对象创建的细节。

这样后续如果要替换实现类或者调整依赖关系，只需要修改配置或 Bean 的定义，业务代码改动更少。同时Bean 交给 Spring 管理后，也方便 Spring 对齐进行 AOP、事务等功能增强。

### Spring 依赖注入有哪些方式？

优先级：最重要

关键词：**构造方法注入、Setter 注入、字段注入、@Autowired、@Resource**

Spring 常见依赖注入方式有属性注入、Setter 方法注入和构造方法注入。

属性注入是在成员变量上使用 @Autowired 或 @Resource，写法简单，但依赖关系不够清晰，也不利于测试。

Setter 注入是通过 set 方法注入，适合可选依赖，但依赖可能在对象创建后被修改。

构造方法注入是在创建对象时通过构造方法传入依赖，可以保证对象创建时依赖已经准备好，也可以配合 final 字段保证依赖不可变，所以现在更推荐构造方法注入。

### 为什么更推荐构造方法注入？

优先级：最重要

关键词：**构造方法注入、依赖不可变、必需依赖、测试友好、循环依赖暴露更早**

更推荐构造方法注入，是因为它能让依赖关系更清晰。一个类需要哪些依赖，可以直接从构造方法中看出来，同时构造方法注入可以配合 final 字段，保证依赖在对象创建后不可变。

另外，构造方法注入可以保证对象创建时依赖就已经准备好，避免对象处于依赖不完整的状态，也更方便进行单元测试。所以在正式项目中，必需依赖一般更推荐使用构造方法注入。

### @Autowired 和 @Resource 的区别？

优先级：最重要

关键词：**@Autowired、按类型、@Resource、按名称、Spring、JDK**

@Autowired 是 Spring 提供的注解，默认按类型注入。如果同一个类型有多个 Bean，需要配合 @Qualifier 指定具体 Bean 名称。

@Resource 是 JDK/Jakarta 提供的注解，默认按名称注入，如果按名称找不到，再按类型注入。它也可以通过 name 属性指定要注入的 Bean。

### @Qualifier 有什么用？

优先级：普通

关键词：**@Qualifier、多个 Bean、指定名称、配合 @Autowired**

@Qualifier 通常和 @Autowired 配合使用。当容器中存在多个相同类型的 Bean 时，@Autowired 只按类型无法确定注入哪个 Bean，就可以通过 @Qualifier 指定 Bean 的名称，避免注入冲突。

### @Component、@Controller、@Service、@Repository 的区别？

优先级：最重要

关键词：**组件注解、Controller 表现层、Service 业务层、Repository 持久层、语义区分**

@Component、@Controller、@Service、@Repository 本质上都是把类交给 Spring 容器管理，注册成 Bean。区别主要是语义和分层不同。@Component 是通用组件，@Controller 用在控制层，@Service 用在业务层，@Repository 用在持久层。这样可以让项目分层更清晰，也方便 Spring 做组件扫描和后续扩展。

### @Configuration 是什么？

优先级：普通

关键词：**配置类、@Configuration、Bean 配置、替代 XML**

@Configuration 用来标记一个配置类，相当于传统 XML 配置文件。配置类中可以通过 @Bean 方法向 Spring 容器注册对象，也可以实现一些配置接口，比如 WebMvcConfigurer 来配置拦截器、跨域等。

### @Bean 是什么？

优先级：普通

关键词：**@Bean、第三方对象、注册 Bean、配置类**

@Bean 用在配置类的方法上，**表示将方法返回的对象注册到 Spring 容器中**。它常用于注册第三方类或需要手动创建的对象，比如 PasswordEncoder、ObjectMapper、RedisTemplate 等。

### @Component 和 @Bean 的区别？

优先级：普通

关键词：**@Component 类级别、@Bean 方法级别、自定义类、第三方类**

@Component 是类级别注解，通常用于我们自己编写的类，Spring 通过组件扫描把它注册成 Bean。

@Bean 是方法级别注解，通常写在 @Configuration 配置类中，用来把方法返回的对象注册成 Bean。它更适合注册第三方类或需要自定义创建过程的对象。

### Bean 的生命周期大概是什么？

优先级：普通

关键词：**Bean 生命周期、实例化、属性注入、初始化、使用、销毁**

Spring Bean 生命周期大致包括实例化、属性注入、初始化、使用和销毁。Spring 容器先根据 Bean 定义创建对象，然后完成依赖注入，接着执行初始化相关方法，之后 Bean 就可以被业务代码使用。容器关闭时，如果 Bean 定义了销毁方法，Spring 会调用对应销毁逻辑。

### Spring Bean 默认是单例还是多例？

优先级：最重要

关键词：**singleton、单例、默认作用域、Spring Bean**

Spring Bean 默认是单例的，也就是 singleton。默认情况下，一个 Bean 在 Spring 容器中只会创建一个实例，多个地方注入的都是同一个对象。

### singleton 和 prototype 的区别？

优先级：普通

关键词：**singleton、prototype、单例、多例、生命周期、作用域**

singleton 是 Spring 默认作用域，表示一个 Bean 在容器中只有一个实例，多个地方注入的是同一个对象。prototype 表示每次从容器获取 Bean 时都会创建一个新的实例。

实际项目中，Controller、Service、Mapper 这类通常都是无状态的，所以默认使用 singleton 就可以。

### Bean 的作用域有哪些？

优先级：了解即可

关键词：**singleton、prototype、request、session、application、web 作用域**

Spring Bean 常见作用域有 singleton、prototype、request、session、application、websocket 等。默认是 singleton，表示容器中只有一个实例。prototype 表示每次获取都会创建新实例。request 和 session 主要用于 Web 环境，分别表示每次 HTTP 请求或每个 Session 对应一个 Bean 实例。

## 三、Spring AOP

### AOP 是什么？

优先级：最重要

关键词：**AOP、面向切面编程、方法增强、不改业务代码、代理**

AOP 全称 Aspect Oriented Programming，面向切面编程。它可以在不修改原有业务代码的情况下，对方法进行增强。

AOP 主要用于把日志、事务、权限校验、接口耗时统计等横切逻辑从业务代码中抽离出来，统一处理，从而减少重复代码，提高代码可维护性。

可以理解为：业务方法只负责核心业务，公共增强逻辑由 AOP 在方法执行前后统一织入。

### 为什么需要 AOP？

优先级：最重要

关键词：**横切关注点、日志、事务、权限、代码复用、解耦**

需要 AOP 是因为很多系统级功能，比如日志、事务、权限校验、性能统计等，会横跨多个业务模块。如果直接写在每个业务方法中，会造成大量重复代码，也会让业务逻辑变得不清晰。

AOP 可以把这些公共逻辑抽离成切面，在方法执行前后统一增强，从而提高代码复用性和可维护性。

### AOP 适合解决什么问题？

优先级：普通

关键词：**日志、事务、权限校验、性能统计、统一增强**

AOP 适合解决和核心业务无关，但很多地方都会用到的横切逻辑，比如事务管理、日志记录、权限校验、接口耗时统计、参数校验、缓存处理、异常监控、审计记录等。

这些逻辑不是某一个业务独有的，而是很多业务都会用到，所以适合通过 AOP 抽取出来统一处理。

### AOP 中的连接点、切入点、通知、切面分别是什么？

优先级：最重要

关键词：**连接点、切入点、通知、切面、JoinPoint、Pointcut、Advice、Aspect**

连接点是程序执行过程中可以被增强的位置，在 Spring AOP 中通常指方法执行。

切入点是从连接点中筛选出来的、真正要增强的方法范围。

通知是具体的增强逻辑，比如方法执行前打印日志、方法异常时记录错误、方法执行前开启事务、方法执行后提交或回滚事务。

切面就是切入点和通知的组合，表示在哪些方法上执行哪些增强逻辑。

简单来说：

```text
连接点：可以被增强的位置
切入点：真正要增强的位置
通知：增强逻辑本身
切面：切入点 + 通知
```

### AOP 有哪些通知类型？

优先级：最重要

关键词：**前置通知、后置通知、返回后通知、异常通知、环绕通知**

常见通知类型有：

```text
@Before：前置通知，在目标方法执行前执行
@After：后置通知，在目标方法执行后执行，无论是否异常都会执行
@AfterReturning：返回通知，在方法正常返回后执行
@AfterThrowing：异常通知，在方法抛出异常后执行
@Around：环绕通知，功能最强，可以在方法执行前后都加入逻辑，并且可以控制目标方法是否执行
```

### @Before、@After、@AfterReturning、@AfterThrowing、@Around 的区别？

优先级：最重要

关键词：**@Before、@After、@AfterReturning、@AfterThrowing、@Around、通知类型**

@Before 是前置通知，在目标方法执行前执行，适合权限校验、参数记录、前置日志等场景。

@After 是后置通知，在目标方法执行后执行，无论方法正常返回还是抛出异常都会执行，类似 finally。

@AfterReturning 是返回通知，在方法正常返回后执行，可以获取方法返回值。

@AfterThrowing 是异常通知，在方法抛出异常后执行，可以获取异常信息。

@Around 是环绕通知，功能最强，可以在方法执行前后都加入逻辑，并通过 ProceedingJoinPoint 的 proceed 方法控制目标方法是否执行。

其中 JoinPoint 可以获取被增强方法的信息，比如方法参数、方法签名、目标对象等。ProceedingJoinPoint 是环绕通知专用的，它除了能获取方法信息，还可以通过 proceed 方法执行目标方法，并获取返回值或处理异常。

### Spring AOP 底层是怎么实现的？

优先级：最重要

关键词：**动态代理、JDK 动态代理、CGLIB、代理对象、目标对象**

Spring AOP 底层主要通过动态代理实现。Spring 会为目标对象创建代理对象，调用方实际调用的是代理对象的方法。代理对象会在调用目标方法前后织入增强逻辑，比如事务、日志等。

目标对象是真正执行业务逻辑的对象，比如 Service 实现类；代理对象是 Spring 在目标对象外面生成的一层包装对象。代理对象不会修改目标对象本身的代码，而是在调用目标方法前后加入增强逻辑。

调用链可以理解为：

```text
调用方
-> 代理对象
-> 执行增强逻辑
-> 调用目标对象的真实方法
-> 执行增强逻辑
-> 返回结果
```

Spring AOP 常见代理方式有 JDK 动态代理和 CGLIB 动态代理。

### JDK 动态代理和 CGLIB 动态代理的区别？

优先级：最重要

关键词：**JDK 动态代理、接口、CGLIB、继承、子类代理、final 限制**

JDK 动态代理是基于接口实现的，要求目标类实现接口，代理对象会实现同样的接口。

CGLIB 动态代理是基于继承实现的，它会生成目标类的子类作为代理对象，所以不要求目标类实现接口，但不能代理 final 类和 final 方法。

简单来说：

```text
JDK 动态代理：基于接口
CGLIB 动态代理：基于继承
```

如果目标类实现了接口，Spring 可以使用 JDK 动态代理；如果目标类没有实现接口，Spring 可以使用 CGLIB 动态代理。实际项目中不用死记某个类一定走哪种代理，重点是理解 Spring AOP 是通过代理对象在目标方法前后加入增强逻辑。

### 项目中哪些场景会用到 AOP？

优先级：普通

关键词：**事务、日志、权限、接口耗时统计、统一增强**

项目中 AOP 最常见的应用是事务管理，比如 @Transactional。Spring 会通过 AOP 动态代理在方法执行前开启事务，方法正常结束后提交事务，发生异常时回滚事务。

我的项目里没有自己手写 @Aspect 这种自定义切面，但有使用 Spring AOP 的典型场景，也就是 @Transactional 事务管理。在评价模块中，发布评价、删除评价、点赞、取消点赞、发布回复、删除回复等写操作都加了 @Transactional。

除此之外，日志记录、接口耗时统计、权限校验、审计记录等也可以通过 AOP 实现。不过在我的项目中，JWT 登录校验主要是通过 Spring MVC 拦截器实现的，而不是 AOP；统一异常处理使用的是 @RestControllerAdvice。

## 四、Spring 事务

### @Transactional 是什么？

优先级：最重要

关键词：**@Transactional、声明式事务、回滚、事务管理**

@Transactional 是 Spring 提供的声明式事务注解，用来让 Spring 自动管理事务。标注了@Transactional 的方法会在执行前开启事务，方法正常执行结束后提交事务，如果发生符合回滚规则的异常则回滚事务。它通常加在 Service 层的方法上，用于保证一组数据库操作的原子性。

### Spring 事务是怎么实现的？

优先级：最重要

关键词：**Spring 事务、AOP、代理对象、事务管理器、方法增强**

Spring 事务主要是基于动态代理实习拿的。Spring 会为带有@Transactional 的 Bean 创建代理对象，调用方实际调用的是代理对象。代理对象在目标方法执行前通过事务管理器开启事务，方法正常执行 1 完成后提交事务，如果抛出符合回滚规则的异常则回滚事务。

### Spring 事务和 AOP 有什么关系？

优先级：最重要

关键词：**事务、AOP、代理、方法前开启事务、方法后提交或回滚**

Spring 声明式事务是 AOP 的典型应用。@Transactional 注解标注的方法会被 Spring AOP 代理增强，代理对象会在目标方法执行前开启事务，在方法正常结束后提交事务，在方法抛出符合回滚规则的异常时回滚事务。所以事务管理本质上就是通过 AOP 把事务这种横切逻辑从业务代码中抽离出来统一处理。

### @Transactional 默认回滚哪些异常？

优先级：最重要

关键词：**RuntimeException、Error、默认回滚、非受检异常**

@Transactional 默认只会对 RuntimeException 极其子类和 Error 进行回滚，也就是非受检异常。对于 checked exception ，默认不会回滚，除非通过 rollbackFor 指定。

### checked exception 会不会默认回滚？

优先级：最重要

关键词：**Checked Exception、默认不回滚、rollbackFor、受检异常**

checked exception 默认不会回滚。如果希望 IOException、SQLException 这类 checked exception 也触发回滚，需要通过 rollbackFor 进行显示指定。

### rollbackFor 有什么用？

优先级：最重要

关键词：**rollbackFor、指定回滚异常、Exception.class、事务回滚**

rollbackFor 用来指定哪些异常类型需要触发事务回滚。因为@Transactional 默认只回滚 RuntimeException及其子类和 Error，对于 checkedException 默认不回滚，如果希望所有异常都能回滚，可以配置 rollbackFor = Exception.class。

### 事务传播行为是什么？

优先级：普通

关键词：**事务传播行为、方法调用、已有事务、新事务、REQUIRED**

事务的传播行为是指多个事务方法相互调用时，事务应该如何传播。比如一个已经存在事务的方法调用另一个带事务的方法时，内层方法是加入外层事务，还是新建一个事务，或者以非事务方式执行，这些规则就是事务传播行为。

### REQUIRED 和 REQUIRES_NEW 的区别？

优先级：最重要

关键词：**REQUIRED、加入当前事务、REQUIRES_NEW、新事务、挂起外层事务**

REQUIRED 是默认的传播行为，表示如果当前存在事务，就加入当前事务；如果没有事务，就新建事务。内外层方法属于同一个事务，一起提交或回滚。

REQUIRED_NEW 表示无论当前是否存在事务，都会新建一个事务。如果当前有事务，会先挂起外层事务。新事务和外层事务相互独立，可以单独提交和回滚。

### 常见事务传播行为有哪些？

优先级：了解即可

关键词：**REQUIRED、REQUIRES_NEW、SUPPORTS、MANDATORY、NESTED、NOT_SUPPORTED、NEVER**

常见的事务传播行为有 7 种：

```text
REQUIRED:默认，有事务就加入，没有就新建
REQUIRED_NEW:总是新建事务，外层事务挂起
SUPPORTS:有事务就加入，没有事务就非事务执行
NOT_SUPPORTED:总是非事务执行，如果当前有事务就挂起
MANDATORY:必须在已有事务中执行，没有事务就报错
NEVER:必须在没有事务的环境下执行，有事务就报错
NESTED:嵌套事务，基于保存点，内层可以回滚到保存点
```



### 事务隔离级别有哪些？

优先级：普通

关键词：**READ_UNCOMMITTED、READ_COMMITTED、REPEATABLE_READ、SERIALIZABLE、隔离级别**

Spring事务的隔离级别和数据库事务的隔离级别相互对应

```text
DEFAULT:使用数据库默认隔离级别
READ_UNCOMMITTED:读未提交
READ_COMMITTED:读已提交
REPEATABALE_READ:可重复读
SERIALIZABLE:串行化
```



### @Transactional 常见失效场景有哪些？

优先级：最重要

关键词：**事务失效、内部调用、非 public、异常被捕获、Checked Exception、代理对象**

@Transactional 常见失效场景包括：

1.方法不是 public；

2.同一个类内部方法调用导致没有经过代理对象；

3.异常被 catch 但没有继续抛出；

4.抛出 checked exception 但没有配置 rollbackFor

5.类没有交给 Spring 容器进行管理

6.数据库存储引擎不支持事务；

7.在 private、static、final 方法上使用事务等。

### 为什么同一个类内部方法调用会导致事务失效？

优先级：最重要

关键词：**内部调用、this、绕过代理、AOP 失效、事务失效**

因为 Spring 事务是基于 AOP 动态代理实习拿的，事务生效的前提是方法调用经过代理对象。同一个类内部方法调用本质上是this 调用，直接调用目标对象自身的方法，没有经过 Spring 代理对象，所以代理对象无法在方法前后加入事务增强逻辑，@Transactional 就会失效。

### 项目中哪些业务场景适合加事务？

优先级：最重要

关键词：**写操作、多表修改、数据一致性、评价、点赞、删除、回滚**

项目中适合加事务的场景一般是**涉及数据库写操作，并且多个操作之间需要保持一致性的业务**。比如发布评价、删除评价、点赞、回复等操作。我的项目中在评价模块的发布评价、删除评价、点赞、取消点赞、发补回复、删除回复方法上都使用了@Transactional，保证数据库写操作在出现异常时可以回滚。

## 五、Spring MVC

### Spring MVC 是什么？

优先级：最重要

关键词：**Spring MVC、Web MVC、请求处理、Controller、DispatcherServlet**

Spring MVC 是 Spring 体系中的 Web 层框架，主要用来处理HTTP 请求和响应。

它基于 MVC 思想，把 Web 请求处理拆分成 Controller、Service、Model、View 或 JSON 响应等部分。

在前后端分离项目中，Spring MVC 主要负责：

* 接收前端 HTTP 请求
* 根据请求路径找到对应的 Controller 方法
* 完成参数绑定，比如把 JSON 格式的数据绑定到 DTO
* 调用业务逻辑
* 将 Java 对象序列化成 JSON 返回给前端

### Spring MVC 和 Spring 的关系是什么？

优先级：最重要

关键词：**Spring MVC、Spring 子框架、Web 层、IOC 容器**

Spring 是一个完整的应用开发框架，核心是 IOC 和 AOP，负责对象管理、依赖注入、事务、AOP 等能力。

Spring MVC 是 Spring 体系中的 Web MVC 模块，主要负责 Web 层请求处理。它依赖 Spring 容器来管理 Controller、Service 等 Bean

### DispatcherServlet 是什么？

优先级：最重要

关键词：**DispatcherServlet、前端控制器、请求分发、Spring MVC 核心**

DispatcherServlet 是 Spring MVC 的前端控制器，也是整个 Spring MVC 请求处理的核心入口。

前端请求进入后，会先到达 DispatcherServlet，再由它负责协调后续流程，比如查找对应的 Controller 方法、调用方法、处理返回结果等。

它本身不写业务逻辑，主要负责请求分发和流程调度。是 Spring MVC 的总调度器。

### Spring MVC 请求执行流程是什么？

优先级：最重要

关键词：**DispatcherServlet、HandlerMapping、Controller、HandlerAdapter、返回 JSON**

```text
前端发送请求
->DispatcherServlet 接收请求
->HandlerMapping 根据 URL 和请求方法找到对应的 Controller 方法
->HandlerAdapter 调用具体的 Controller 方法
->Controller 接收参数，调用 Service 处理业务
->Service 调用 Mapper/Redis/OSS 等完成业务逻辑
->Controller 返回结果
->HttpMessageConverter 将Java 对象序列化为 JSON
->DispatcherServlet 将响应结果返回给前端。
```



### 前后端分离项目中 Spring MVC 如何返回 JSON？

优先级：最重要

关键词：**@RestController、@ResponseBody、HttpMessageConverter、Jackson、JSON**

前后端分离项目中，Controller 通常使用@RestController，或者在方法上使用@ResponseBody。

Controller 方法返回 Java 对象之后，Spring MVC 会通过 HttpMessageConverter，通常底层采用 Jackson，将对象序列化成 JSON，然后写入 HTTP 响应体

### @Controller 和 @RestController 的区别？

优先级：最重要

关键词：**@Controller、视图返回、@ResponseBody、@RestController、JSON**

@Controller 一般用于传统的 MVC 项目，方法返回值默认会被当做视图名，通常用于返回页面。

如果@Controller 中的方法想直接返回 JSON，需要在方法上加@ResponseBody

而@RestController 等价于@Controller+@ResponseBody，他表示当前类中的所有方法的返回值都会直接写入响应体，通常用于前后端分离项目返回 JSON

### @RequestMapping、@GetMapping、@PostMapping、@PutMapping、@DeleteMapping 的区别？

优先级：最重要

关键词：**请求映射、HTTP 方法、GET、POST、PUT、DELETE、RESTful**

@RequestMapping 是通用请求注解，可以指定请求路径和请求方法。

@GetMapping、@PostMapping、@PutMapping、@DeleteMapping 是组合注解，分别对应 HTTP 的 GET、POST、PUT、DELETE 请求。

```text
GET:查询资源
POST：新增资源或提交操作
PUT：更新资源
DELETE：删除资源
```



### @RequestParam 是什么？

优先级：最重要

关键词：**@RequestParam、查询参数、表单参数、普通参数绑定**

@RequstParam 用来接收 URL 查询参数或者表单参数。比如前端请求：`/users?page=1&size=10`后端可以用@RequestParam 来接收 page 和 size

它常用于分页参数、搜索关键字、筛选条件等场景，也可以通过 required 设置参数是否必填，也可以通过 defaultValue 来设置默认值。

### @PathVariable 是什么？

优先级：最重要

关键词：**@PathVariable、路径变量、RESTful、URL 参数**

@PathVariable 用来接收 URL 路径中的变量。比如请求：

```
/users/1
```

接口路径可以写成：

```
@GetMapping("/users/{id}")
```

然后使用 @PathVariable 接收路径中的 id。

它常用于根据 id 查询详情、删除指定资源等场景。

### @RequestBody 是什么？

优先级：最重要

关键词：**@RequestBody、JSON 请求体、DTO、反序列化**

@RequestBody 用来接收 HTTP请求体中的 JSON 数据，并将 JSON 数据反序列化成 Java 对象

比如前端提交登录信息：

```json
{
  "username": "chen",
  "password": "123456"
}
```

后端就可以使用`@RequestBody LoginDTO loginDTO `来接收

常用于登录、注册、新增、修改等需要提交复杂对象的场景。

### @RequestHeader 是什么？

优先级：普通

关键词：**@RequestHeader、请求头、Authorization、token**

@RequestHeader 用来获取 HTTP 请求头中的数据。比如前端在请求头中携带：

`Authorization: Bearer token`

后端就可以使用`@RequestHeader("Authorization")`来获取这个请求头。

不过在实际项目中，像 JWT 这种认证信息一般不会在每个 Controller 里面手动获取，而是放在拦截器或过滤器中统一解析。

### @RequestParam、@PathVariable、@RequestBody 的区别？

优先级：最重要

关键词：**@RequestParam 查询参数、@PathVariable 路径参数、@RequestBody 请求体 JSON**

@RequestParam 用来接收 URL 问号后面的查询参数，比如分页、搜索条件

@PathVariable 用来接收 URL 路径中的变量，比如`/users/{id}`中的 id。

@RequestBody 用来接收请求体中的 JSON 数据，并转换成 Java 对象。

### 前端 JSON 如何绑定到 DTO？

优先级：最重要

关键词：**JSON、DTO、@RequestBody、Jackson、字段名匹配**

前端发送 JSON 数据时，后端可以使用@RequestBody 接收，并绑定到 DTO 对象上。

Spring MVC 会根据 JSON 字段名和 DTO 属性名进行匹配，然后通过 Jackson 将 JSON 反序列化成 DTO 对象

### @ResponseBody 是什么？

优先级：普通

关键词：**@ResponseBody、返回 JSON、响应体、消息转换器**

@ResponseBody 表示方法返回值不再被解析成视图名称，而是直接写入 HTTP 响应体。如果返回的是 Java 对象，Spring MVC 会通过消息转换器将对象序列化成 JSON。

在前后端分离项目中，@ResponseBody 常用于返回 JSON 数据。@RestController 已经包含了@ResponseBody，所以使用@RestController 时一般不需要再单独加。

### 为什么项目中要使用统一返回结果？

优先级：最重要

关键词：**统一返回、Result、状态码、message、data、前后端约定**

项目中使用统一返回结果主要是为了规范接口响应格式，方便前后端协作。比如统一返回

```json
{
  "code": 200,
  "message": success,
  "data": {}
}
```

这样前端可以用统一方式判断请求是否成功、展示错误信息、读取业务数据。

后端也可以配合全局异常处理，在发生异常时返回统一格式，避免不同接口返回结构混乱。

所以统一返回结果可以**提高接口规范性、可维护性和前后端协作效率**。



### DTO、VO、Entity 的区别？

优先级：最重要

关键词：**DTO 请求参数、VO 响应对象、Entity 数据库实体、分层解耦**

Entity 是实体类，通常和数据库表对应，用于持久层数据映射。

DTO 是数据传输对象，通常用于接收前端请求参数、比如登录参数、注册参数、新增参数。

VO 是视图对象，是后端返回给前端展示用的数据。

这样分层可以避免直接暴露数据库实体，防止敏感字段泄露、也可以让请求参数、数据库字段和返回数据各自保持清晰。

### Spring MVC 如何做 JSON 序列化和反序列化？

优先级：普通

关键词：**Jackson、HttpMessageConverter、序列化、反序列化、JSON**

Spring MVC 用过 HttpMessageConverter 完成 JSON 的序列化和反序列化，常见实现是 Jackson。

反序列化是指前端传 JSON，后端通过@RequestBody 接收，Spring MVC 会把 JSON 转换成 DTO 对象。

序列化是指后端返回 Java 对象，配合@ResponseBody 或者@RestController，Spring MVC 会把 Java 对象转换成 JSON 返回给前端。

底层主要依赖 HttpMessageConverter 和 Jackson 完成。

## 六、拦截器与异常处理

### Interceptor 是什么？

优先级：最重要

关键词：**Interceptor、拦截器、Controller 前后、登录校验、权限校验**

Interceptor 是 Spring MVC 提供的拦截器机制，可以在请求进入 Controller 之前、Controller 执行之后、请求完成之后插入一些通用处理逻辑。

常见使用场景有：登录鉴权、权限校验、请求日志、接口耗时统计、统一参数预处理。

拦截器通常要实现`HandlerInterceptor`接口，并重写里面的方法。

在 Spring MVC 中，拦截器主要围绕 Controller 方法执行前后进行增强。它不是用来写具体业务逻辑的，而是用来处理多个接口都需要的通用逻辑。

### 拦截器的 preHandle、postHandle、afterCompletion 分别什么时候执行？

优先级：普通

关键词：**preHandle、postHandle、afterCompletion、Controller 前、返回后、完成后**

Spring MVC 拦截器中常见的三个方法是：

preHandle，postHandle，afterCompletion

其中 preHandle 在 Controller 方法执行前执行，返回值是 boolean，如果返回 true：继续执行后续流程，最终进入 Controller。返回 false：中断请求，不再进入 Controller。可以用来做登录校验，权限校验，请求预处理。

postHandle 在 Controller 方法执行之后、视图渲染或响应处理之前执行。在传统返回页面的 MVC 项目中，可以在这里对 ModelAndView 做处理。在前后端分离项目中，因为大多数接口直接返回 JSON，postHandle 的使用频率相对低一些。

afterCompletion 在整个请求执行完之后执行。也就是响应结果处理完成之后执行。一般用于资源清理、记录请求日志、统计接口耗时、异常后的收尾处理。

### 拦截器和过滤器 Filter 的区别？

优先级：普通

关键词：**Interceptor、Filter、Servlet、Spring MVC、执行时机、作用范围**

拦截器 Interceptor 和过滤器 Filter 都可以对请求进行拦截，但它们的层级和使用场景不同。

Filter 是 Servlet 规范中的组件，属于 Java Web 层面的机制。它在请求进入 Spring MVC 之前就可以生效，作用范围更底层。主要用于字符编码处理、跨域处理、底层安全过滤。

Interceptor 是 Spring MVC 提供的机制，依赖 Spring 容器，主要拦截 Controller 方法相关的请求。

### 项目中 JWT 鉴权为什么适合用拦截器？

优先级：最重要

关键词：**JWT、拦截器、统一鉴权、Controller 前、userId 写入 request**

JWT 鉴权属于多个接口都需要的通用逻辑，不适合在每个 Controller 方法中重复解析 token。可以减少代码重复，避免接口遗漏，让 Controller方法职责更清晰。

### 项目中 JWT 鉴权调用链是什么？

优先级：最重要

关键词：**Authorization、Bearer token、LoginCheckInterceptor、JwtUtils、userId、request**

```text
前端提交账号和密码
-> POST /api/v1/auth/login
-> AuthController#login 接收 LoginDTO
-> AuthServiceImpl#login 校验参数
-> UserMapper#selectByUsernameOrPhone 根据用户名或手机号查询用户
-> BCryptPasswordEncoder#matches 校验密码
-> 校验通过后，把 userId 和 username 放入 claims
-> JwtUtils#generateToken 生成 JWT
-> 封装 LoginVO 返回给前端
-> 前端保存 token
-> 后续请求携带 token
-> 前端请求需要登录的接口
-> 请求进入 LoginCheckInterceptor#preHandle
-> 从请求头读取 Authorization
-> 判断 Authorization 是否为空、是否以 Bearer 开头
-> 截取真正的 token
-> 调用 JwtUtils#parseToken 解析 JWT
-> 从 Claims 中取出 userId
-> request.setAttribute("userId", userId)
-> 放行请求，进入 Controller
-> Controller 从 request 中取出 userId
-> 调用 Service 完成业务逻辑
```



### @ControllerAdvice / @RestControllerAdvice 是什么？

优先级：最重要

关键词：**@RestControllerAdvice、全局异常处理、统一响应、Controller 增强**

@ControllerAdvice 是 Spring MVC 提供的 Controller 全局增强机制，可以对多个 Controller 做统一处理。

常见用途：

```
全局异常处理 全局数据绑定 全局模型数据处理
```

在前后端分离项目中，更常用的是 @RestControllerAdvice。

@RestControllerAdvice 可以理解为：

```
@ControllerAdvice + @ResponseBody
```

也就是说，它处理后的返回值会直接写入响应体，通常会被序列化成 JSON 返回给前端。

### @ExceptionHandler 是什么？

优先级：最重要

关键词：**@ExceptionHandler、捕获异常、异常类型、统一处理**

@ExceptionHandler 用来指定某个方法处理哪一类异常。

它通常和 @ControllerAdvice 或 @RestControllerAdvice 配合使用，实现全局异常处理。

例如：

```Java
@ExceptionHandler(RuntimeException.class)
public Result handleRuntimeException(RuntimeException e) { 
			return Result.error(e.getMessage());
}
```

表示当 Controller 调用链中抛出 RuntimeException 时，会进入这个方法处理，并返回统一错误结果。

### 为什么要做统一异常处理？

优先级：最重要

关键词：**统一异常处理、减少 try-catch、统一错误格式、避免暴露堆栈**

统一异常处理的核心目的是让异常返回格式统一，同时避免在每个 Controller 中重复写 try-catch。

如果没有统一异常处理，可能会出现：

```
有的接口返回字符串错误 
有的接口返回JSON 错误 
有的接口直接暴露异常堆栈 
每个 Controller 都写大量 try-catch 前端不好统一处理
```

使用统一异常处理后，业务代码可以在出现异常时向上抛出，最后由全局异常处理器统一捕获，并转换成标准返回格式。

好处：

```
减少重复代码 
统一接口错误格式
方便前端统一处理错误
避免直接暴露系统异常细节 
业务代码更清晰
```

### 项目中一般怎么处理异常？

优先级：最重要

关键词：**全局异常处理、业务异常、Result、@RestControllerAdvice、错误码**

项目中一般不会在每个 Controller 里重复写 try-catch，而是通过全局异常处理器统一处理异常。业务层遇到账号密码错误、验证码过期、资源不存在、无权限等情况时，会抛出异常，最后由@RestControllerAdvice配合 @ExceptionHandler 捕获，并转换成统一的 Result 返回给前端。这样可以减少重复代码，也能保证接口错误响应格式一致。我的 UniTour 项目里目前主要是抛 RuntimeException 表示业务异常，后续可以进一步抽象BusinessException 和错误码，让业务异常和系统异常区分得更清楚。

## 七、MyBatis 基础

### MyBatis 是什么？

优先级：最重要

MyBatis 是一个 Java 持久层框架，主要用来简化 Java 操作数据库的过程。它底层还是基于 JDBC，但封装了获取连接、执行 SQL、处理结果集、对象映射等重复操作。开发者只需要定义 Mapper 接口并编写 SQL，MyBatis 就可以根据接口方法执行对应 SQL，并把查询结果映射成 Java 对象。

关键词：**持久层框架、简化 JDBC、Mapper 接口、SQL 映射、结果映射成 Java 对象**

### MyBatis 解决了什么问题？

优先级：最重要

MyBatis 主要解决了 JDBC 开发中重复代码多、结果集处理麻烦、SQL 和 Java 代码耦合较重的问题。使用 JDBC 时，我们需要手动获取连接、创建 Statement、设置参数、执行 SQL、遍历 ResultSet 并封装对象。MyBatis 对这些流程进行了封装，让开发者主要关注 SQL 本身和对象映射，从而提高开发效率。

关键词：**减少 JDBC 重复代码、封装连接和执行流程、自动映射结果集、保留 SQL 控制权、提高开发效率**

### MyBatis 和 JDBC 的区别？

优先级：最重要

JDBC 是 Java 原生操作数据库的 API，开发者需要自己管理连接、创建 SQL 执行对象、设置参数、处理结果集，代码比较重复。MyBatis 是对 JDBC 的封装，它把 SQL 和 Java 方法进行映射，开发者通过调用 Mapper 接口来执行 SQL，MyBatis 负责参数绑定、SQL 执行和结果映射。简单来说，JDBC 更底层，而 MyBatis 更偏框架化，开发效率更高。

关键词：**JDBC 原生 API、MyBatis 封装 JDBC、Mapper 调用、参数绑定、执行 SQL、结果映射、减少重复代码**

### MyBatis 和 JPA / Hibernate 的区别？

优先级：普通

MyBatis 和 JPA/Hibernate 都是持久层框架，但侧重点不同。MyBatis 更偏 SQL 映射框架，SQL 主要由开发者自己编写，适合复杂 SQL 和需要精细控制 SQL 的场景。JPA、Hibernate 更偏向全 ORM 框架，可以根据对象关系自动生成 SQL，开发效率高，但复杂 SQL 控制起来不如 MyBatis 直观。实际 Java 后端项目中，如果业务 SQL 比较复杂，很多公司会更倾向使用 MyBatis。

关键词：**MyBatis SQL 自己写、半 ORM、灵活可控、JPA/Hibernate 自动生成 SQL、全 ORM、复杂 SQL**

### MyBatis 为什么叫半 ORM 框架？

优先级：最重要

ORM 是对象关系映射，指的是把数据库表和 Java 对象进行映射。MyBatis 可以把 SQL 查询结果映射成 Java 对象，也可以把 Java 对象中的属性作为 SQL 参数传入，所以它具备 ORM 的一部分能力。但 MyBatis 的 SQL 主要还是由开发者自己编写，不像 Hibernate / JPA 那样自动生成大量 SQL，所以它通常被称为半 ORM 框架。

关键词：ORM、对象关系映射、结果映射、SQL 自己写、半自动、区别于 JPA/Hibernate

### Mapper 接口是什么？

优先级：最重要

Mapper 接口是 MyBatis 提供给 Java 代码调用数据库操作的接口。它一般定义增删改查方法，本身通常没有手写实现类。程序运行时，MyBatis 会为 Mapper 接口生成代理对象，Service 层调用 Mapper 方法时，代理对象会根据方法找到对应的 SQL 并执行。

关键词：**数据库操作接口、增删改查方法、没有手写实现类、MyBatis 代理对象、Service 调用 Mapper**

### Mapper XML 是什么？

优先级：最重要

Mapper XML 是 MyBatis 用来编写和管理 SQL 语句的 XML 文件。它里面可以写 select、insert、update、delete 等 SQL，并通过 namespace 和 id 与 Mapper 接口的方法建立对应关系。使用 Mapper XML 可以把 SQL 从 Java 代码中分离出来，方便编写复杂 SQL 和动态 SQL。

关键词：**SQL 映射文件、select/insert/update/delete、namespace、id、复杂 SQL、动态 SQL**

### Mapper 接口的方法如何和 XML 中的 SQL 对应？

优先级：最重要

Mapper 接口方法和 XML 中 SQL 的对应主要依靠 namespace 和 id。Mapper XML 的 namespace 通常写 Mapper 接口的全限定名，XML 中每条 SQL 的 id 对应 Mapper 接口中的方法名。这样当 Service 调用 Mapper 接口方法时，MyBatis 就能根据接口名和方法名找到 XML 中对应的 SQL 并执行。

关键词：**namespace、Mapper 接口全限定名、id、方法名、参数绑定、resultType、resultMap、代理对象执行 SQL**

### namespace 有什么作用？

优先级：普通

namespace 用来标识当前 Mapper XML 属于哪个 Mapper 接口，通常写 Mapper 接口的全限定名。MyBatis 会通过 namespace 加 SQL 的 id 来唯一定位一条 SQL 语句。这样既能把 XML 和 Mapper 接口绑定起来，也能避免不同 XML 中 SQL id 重名导致冲突。

关键词：**Mapper 接口全限定名、绑定 XML 和接口、唯一定位 SQL、避免 id 冲突**


### id 有什么作用？

优先级：普通

id 是 Mapper XML 中每条 SQL 的唯一标识，通常要和 Mapper 接口中的方法名保持一致。MyBatis 调用 Mapper 接口方法时，会根据 namespace 找到对应 XML，再根据 id 找到具体 SQL 并执行。

关键词：**SQL 唯一标识、对应 Mapper 方法名、namespace + id、定位 SQL**

### parameterType 是什么？

优先级：了解即可

parameterType 用来指定 SQL 入参的 Java 类型，比如传入一个 User 对象、Integer、String 或 Map。不过在实际开发中，MyBatis 很多时候可以根据 Mapper 方法参数自动推断参数类型，所以 parameterType 经常可以省略。

关键词：**入参类型、Java 类型、参数绑定、可自动推断、常可省略**

### resultType 是什么？

优先级：普通

resultType 是 MyBatis 中用于指定查询结果映射类型的属性。表示一条 SQL 查询出来的结果要封装成哪个 Java 类型。通常适用于数据库字段名和 Java 对象属性名能够自动对应的简单场景，比如查询用户表后直接映射成 Java 对象。

关键词：**返回结果类型、简单映射、字段名和属性名自动对应、Java 对象**

### resultMap 是什么？

优先级：最重要

resultMap 是 MyBatis 中自定义结果映射规则的配置。它可以手动指定数据库字段和 Java 对象属性之间的对应关系，适合字段名和属性名不一致，或者一对一、一对多等复杂映射场景。相比 resultType，resultMap 更灵活，但配置也更复杂。

关键词：**自定义映射规则、字段和属性手动对应、复杂映射、一对一、一对多**

### resultType 和 resultMap 的区别？

优先级：最重要

resultType 和 resultMap 都用于处理查询结果映射。resultType 是直接指定返回结果类型，适合字段名和 Java 属性名可以自动匹配的简单场景。resultMap 是自定义映射规则，可以手动指定字段和属性的对应关系，也可以处理复杂对象关系。简单查询可以用 resultType，复杂映射更适合用 resultMap。

关键词：**resultType 简单映射、resultMap 自定义映射、字段不一致、复杂对象关系**

### 数据库字段名和 Java 属性名不一致怎么办？

优先级：最重要

数据库字段名和 Java 属性名不一致时，可以有几种处理方式。第一种是在 SQL 中使用别名，让查询结果字段名和 Java 属性名保持一致。第二种是开启 MyBatis 的驼峰命名映射，比如数据库字段是 user_name，Java 属性是 userName。第三种是使用 resultMap 手动配置字段和属性之间的对应关系。简单场景可以用别名或驼峰映射，复杂场景一般使用 resultMap。

关键词：**SQL 别名、驼峰命名映射、map-underscore-to-camel-case、resultMap、字段名和属性名对应**

## 八、Spring Boot 整合 MyBatis

### Spring Boot 怎么整合 MyBatis？

优先级：最重要

Spring Boot 整合 MyBatis 通常先引入 `mybatis-spring-boot-starter`，然后在 `application.yml` 中配置数据源、Mapper XML 路径等信息。接着通过 `@Mapper` 或 `@MapperScan` 扫描 Mapper 接口，Service 层就可以直接注入 Mapper 调用数据库。Spring Boot 会自动配置 DataSource、SqlSessionFactory、SqlSessionTemplate 等对象，所以不需要像传统 SSM 那样手写大量 XML 配置。

关键词：**mybatis-spring-boot-starter、DataSource、Mapper XML、@Mapper、@MapperScan、自动配置**

### mybatis-spring-boot-starter 做了什么？

优先级：普通

`mybatis-spring-boot-starter` 是 MyBatis 提供给 Spring Boot 的起步依赖。它会引入 MyBatis 和 Spring 整合所需的依赖，并配合 Spring Boot 自动配置机制，根据数据源自动创建 SqlSessionFactory、SqlSessionTemplate，同时支持 Mapper 接口扫描。简单说，它让 MyBatis 可以更方便地接入 Spring Boot 项目。

关键词：**起步依赖、自动配置、SqlSessionFactory、SqlSessionTemplate、Mapper 扫描、Spring Boot 整合**

### DataSource 是什么？

优先级：普通

DataSource 是数据源，负责提供数据库连接。项目连接 MySQL 时，连接地址、用户名、密码、连接池等配置最终都会形成一个 DataSource 对象。MyBatis 执行 SQL 时，底层也需要通过 DataSource 获取数据库连接。

关键词：**数据源、数据库连接、连接池、MySQL 配置、获取连接**

### SqlSession 是什么？

优先级：了解即可

SqlSession 是 MyBatis 操作数据库的核心会话对象，可以用来执行 SQL、获取 Mapper、提交或回滚事务。在传统 MyBatis 中可能会手动使用 SqlSession，但在 Spring Boot 项目里通常由 Spring 和 MyBatis 整合层管理，开发者一般直接注入 Mapper，不需要手动操作 SqlSession。

关键词：**数据库会话、执行 SQL、获取 Mapper、事务、Spring Boot 中通常不手动使用**

### SqlSessionFactory 是什么？

优先级：普通

SqlSessionFactory 是用来创建 SqlSession 的工厂对象。它会根据 MyBatis 配置、数据源、Mapper XML 等信息构建出来。Spring Boot 整合 MyBatis 后，一般会自动创建 SqlSessionFactory，开发者通常不需要手动配置。

关键词：**SqlSession 工厂、创建 SqlSession、数据源、Mapper XML、自动配置**

### SqlSessionTemplate 是什么？

优先级：了解即可

SqlSessionTemplate 是 MyBatis 和 Spring 整合时提供的线程安全 SqlSession 实现。它负责把 MyBatis 的 SQL 执行和 Spring 的事务管理结合起来。日常开发中我们不直接操作它，但 Mapper 代理对象底层会通过它执行 SQL。

关键词：**线程安全、Spring 整合 MyBatis、事务管理、Mapper 底层执行 SQL**

### Mapper 代理对象是什么？

优先级：最重要

Mapper 接口通常没有手写实现类，但项目运行时可以直接注入并调用，这是因为 MyBatis 会为 Mapper 接口生成代理对象。当调用 Mapper 方法时，代理对象会根据接口方法找到对应的 SQL，完成参数绑定、SQL 执行和结果映射。

关键词：**接口无实现类、动态代理、方法对应 SQL、参数绑定、结果映射**

### @Mapper 和 @MapperScan 的区别？

优先级：最重要

`@Mapper` 是加在单个 Mapper 接口上的注解，用来告诉 Spring 这个接口需要交给 MyBatis 创建代理对象。`@MapperScan` 一般加在启动类或配置类上，用来批量扫描某个包下的所有 Mapper 接口。Mapper 少时可以用 `@Mapper`，项目中 Mapper 多时更常用 `@MapperScan`。

关键词：**@Mapper 单个接口、@MapperScan 批量扫描、Mapper 代理对象、启动类、配置类**

### 传统 Spring 整合 MyBatis 需要配置哪些东西？

优先级：了解即可

传统 Spring 整合 MyBatis 通常需要手动配置数据源 DataSource、SqlSessionFactory、MapperScannerConfigurer 或 Mapper 扫描器、事务管理器、Mapper XML 路径等内容。Spring Boot 出现后，这些配置大多可以通过 starter 和自动配置完成，所以现在项目里很少手写大量整合 XML。

关键词：**DataSource、SqlSessionFactory、Mapper 扫描器、事务管理器、Mapper XML、传统 XML 配置**

### Spring Boot 自动帮我们配置了哪些 MyBatis 相关对象？

优先级：普通

Spring Boot 整合 MyBatis 后，会根据配置自动创建数据源相关对象，并进一步配置 SqlSessionFactory、SqlSessionTemplate、Mapper 代理对象扫描等内容。开发者主要负责配置数据库连接信息、Mapper XML 路径以及编写 Mapper 接口和 SQL。

关键词：**DataSource、SqlSessionFactory、SqlSessionTemplate、Mapper 代理、自动配置、减少 XML**

### properties 文件和 application.yml 的关系是什么？

优先级：了解即可

`application.properties` 和 `application.yml` 都是 Spring Boot 的配置文件，只是写法不同。properties 使用 key-value 形式，yml 使用层级缩进形式。它们都可以配置端口、数据库连接、Redis、MyBatis、日志等信息。实际项目中二选一即可，团队统一风格更重要。

关键词：**Spring Boot 配置文件、properties、yml、层级配置、数据库、Redis、MyBatis**

## 九、MyBatis SQL 编写

### #{} 和 ${} 的区别？

优先级：最重要

`#{}` 和 `${}` 都可以在 MyBatis 的 SQL 中取参数，但底层处理方式不同。`#{}` 使用预编译占位符方式，参数会作为值传入 SQL，类似 PreparedStatement，可以防止 SQL 注入。`${}` 是字符串拼接，会把参数内容直接拼接到 SQL 中，存在 SQL 注入风险。实际开发中普通参数传值优先使用 `#{}`，只有表名、字段名、排序字段这类无法用占位符的位置，才可能使用 `${}`，并且必须做好白名单校验。

关键词：**#{} 预编译、PreparedStatement、参数绑定、防 SQL 注入、${} 字符串拼接、白名单校验**

### 为什么 #{} 可以防止 SQL 注入？

优先级：最重要

因为 `#{}` 底层使用的是预编译占位符，用户输入会被当作参数值处理，而不是直接拼接成 SQL 语句的一部分。数据库会先确定 SQL 结构，再把参数传进去执行，所以即使用户输入了 `or 1=1` 这类内容，也只会被当作普通字符串值，不会改变原来的 SQL 语义。

关键词：**预编译、占位符、SQL 结构先确定、参数值、PreparedStatement、防 SQL 注入**

### ${} 一般适合用在什么场景？

优先级：最重要

`${}` 一般只适合用在不能使用占位符的位置，比如动态表名、动态字段名、动态排序字段等。比如 `order by ${sortField}` 这种场景，字段名不能用 `#{}` 当作普通值传入。但使用 `${}` 时必须对参数做白名单校验，只允许传入后端明确支持的字段，不能直接信任前端传来的字符串。

关键词：**动态表名、动态字段名、order by、字符串拼接、SQL 注入风险、白名单校验**

### MyBatis 动态 SQL 是什么？

优先级：最重要

MyBatis 动态 SQL 是指根据不同参数条件动态拼接 SQL 的能力。比如查询用户时，有时按用户名查，有时按状态查，有时两个条件都有，这时就可以使用 `if`、`where`、`set`、`foreach` 等标签来动态生成 SQL，避免在 Java 代码中手动拼接字符串。

关键词：**动态拼接 SQL、if、where、set、foreach、条件查询、避免手写字符串拼接**

### if 标签怎么用？

优先级：最重要

`if` 标签用于根据条件决定某段 SQL 是否出现。比如查询条件中 username 不为空时才拼接 `and username = #{username}`。它常用于多条件查询、可选参数查询等场景。

```xml
<if test="username != null and username != ''">
    and username = #{username}
</if>
```

关键词：**条件判断、可选查询条件、多条件查询、test 表达式**

### where 标签有什么用？

优先级：最重要

`where` 标签用来智能处理 SQL 中的 `where` 关键字。如果内部有条件成立，它会自动加上 `where`；如果第一个条件前面多了 `and` 或 `or`，它也会自动去掉。这样可以避免动态 SQL 中出现 `where and ...` 这类语法错误。

关键词：**自动添加 where、去掉多余 and/or、动态查询、防止 SQL 语法错误**

### set 标签有什么用？

优先级：普通

`set` 标签主要用于动态更新语句。它会自动添加 `set` 关键字，并去掉最后多余的逗号，适合只更新非空字段的场景。

```xml
<set>
    <if test="username != null">username = #{username},</if>
    <if test="status != null">status = #{status},</if>
</set>
```

关键词：**动态 update、自动添加 set、去掉多余逗号、只更新非空字段**

### foreach 标签怎么用？

优先级：最重要

`foreach` 标签用于遍历集合或数组，常见场景是批量删除、批量查询、批量新增。比如根据多个 id 查询数据时，可以用 foreach 拼接 `in` 条件。

```xml
<foreach collection="ids" item="id" open="(" separator="," close=")">
    #{id}
</foreach>
```

关键词：**遍历集合、批量操作、in 查询、collection、item、open、separator、close**

### choose / when / otherwise 标签怎么用？

优先级：了解即可

`choose / when / otherwise` 类似 Java 中的 `if / else if / else`，用于多个条件中只选择一个分支。当满足某个 when 条件时，就不会继续判断后面的分支；如果所有 when 都不满足，就执行 otherwise。

关键词：**多分支选择、if else、choose、when、otherwise、只走一个分支**

### MyBatis 多个参数怎么传？

优先级：最重要

MyBatis 多个参数可以通过 `@Param` 指定参数名，也可以封装成 DTO、实体对象或 Map 传入。实际项目中，如果参数属于一个业务请求，通常更推荐封装成 DTO；如果只是少量简单参数，可以使用 `@Param`。

关键词：**@Param、DTO、实体对象、Map、多参数绑定、参数名**

### @Param 有什么用？

优先级：最重要

`@Param` 用来给 Mapper 方法参数指定名称，方便在 XML 中通过这个名称取值。特别是 Mapper 方法有多个参数时，如果不使用 `@Param`，XML 中直接写参数名可能无法正确识别。使用 `@Param("id")` 后，XML 中就可以通过 `#{id}` 获取该参数。

关键词：**参数命名、多参数、XML 取值、#{id}、Mapper 方法参数**

### 对象参数、Map 参数、集合参数分别怎么传？

优先级：普通

对象参数适合业务字段较明确的场景，XML 中可以直接通过对象属性名取值，比如 `#{username}`。Map 参数适合字段不固定的场景，XML 中通过 key 取值。集合参数常用于批量操作，通常配合 `foreach` 使用；如果集合参数需要自定义名字，可以配合 `@Param`。

关键词：**对象属性取值、Map key 取值、集合参数、foreach、@Param**

### 模糊查询怎么写？

优先级：最重要

模糊查询推荐使用 `concat` 配合 `#{}`，不要直接用 `${}` 拼接用户输入。比如：

```sql
where name like concat('%', #{keyword}, '%')
```

这样既能实现模糊查询，又能避免 SQL 注入风险。

关键词：**like、concat、#{}、模糊查询、防 SQL 注入**

### 批量新增、批量删除、批量查询怎么写？

优先级：普通

批量操作一般使用 `foreach` 标签。批量删除和批量查询常用 `in` 条件，批量新增可以遍历集合拼接多组 values。关键是通过 `collection` 指定集合名，通过 `item` 表示当前遍历元素。

关键词：**foreach、批量新增、批量删除、批量查询、in、values、collection、item**

## 十、MyBatis 缓存

### MyBatis 一级缓存是什么？

优先级：了解即可

MyBatis 一级缓存是 SqlSession 级别的缓存，默认开启。同一个 SqlSession 中，如果执行相同查询，MyBatis 可能会直接从缓存中返回结果，而不再查询数据库。但在 Spring Boot 项目中，SqlSession 通常由框架管理，日常开发不太需要手动关注一级缓存。

关键词：**一级缓存、SqlSession 级别、默认开启、同一会话、减少重复查询**

### MyBatis 二级缓存是什么？

优先级：了解即可

MyBatis 二级缓存是 Mapper namespace 级别的缓存，多个 SqlSession 可以共享。它需要额外开启和配置，并且对数据一致性要求较高。实际项目中，因为分布式部署、缓存一致性和管理复杂度等原因，二级缓存使用得不多。

关键词：**二级缓存、namespace 级别、多个 SqlSession 共享、需要配置、一致性问题**

### 一级缓存和二级缓存的区别？

优先级：了解即可

一级缓存作用范围是 SqlSession，默认开启，生命周期较短。二级缓存作用范围是 Mapper namespace，可以被多个 SqlSession 共享，但需要额外配置。简单说，一级缓存更局部，二级缓存范围更大，但一致性问题也更复杂。

关键词：**一级缓存 SqlSession、二级缓存 namespace、默认开启、共享范围、一致性**

### 为什么实际项目中更常用 Redis 而不是 MyBatis 二级缓存？

优先级：普通

因为 Redis 是独立的缓存中间件，支持分布式部署、多种数据结构、TTL 过期时间、统一缓存管理，也方便多个服务共享缓存。MyBatis 二级缓存主要绑定在 Mapper namespace 上，粒度和控制能力都比较有限，在复杂业务和分布式场景下不如 Redis 灵活。所以实际项目中更常用 Redis 做业务缓存，而不是依赖 MyBatis 二级缓存。

关键词：**Redis、分布式缓存、TTL、多数据结构、跨服务共享、MyBatis 二级缓存粒度有限**

## 十一、SSM 在项目中的调用链

### 一个 HTTP 请求在项目中的完整调用链是什么？

优先级：最重要

一个 HTTP 请求进入后端后，通常先经过过滤器或拦截器，再由 DispatcherServlet 分发到对应 Controller。Controller 负责接收请求参数并调用 Service，Service 处理业务逻辑，必要时调用 Mapper 操作 MySQL，或者调用 Redis、OSS 等外部组件。Mapper 通过 MyBatis 执行 SQL 并返回数据，Service 组装结果，Controller 最后把统一 Result 返回给前端，Spring MVC 再把对象序列化成 JSON。

关键词：**前端请求、拦截器、DispatcherServlet、Controller、Service、Mapper、MySQL、Redis、OSS、Result、JSON**

### Controller 层负责什么？

优先级：最重要

Controller 层负责接收前端请求、解析请求参数、做基础参数校验、调用 Service 层处理业务，并把结果封装成统一响应返回给前端。Controller 不应该写复杂业务逻辑，也不应该直接操作数据库。

关键词：**接收请求、参数绑定、基础校验、调用 Service、统一返回、不写复杂业务**

### Service 层负责什么？

优先级：最重要

Service 层负责核心业务逻辑，是项目中最重要的业务组织层。它会进行业务校验、调用 Mapper 操作数据库、调用 Redis 或 OSS 等组件、处理事务、组装 VO 返回结果。比如登录校验、验证码校验、高校详情组装、评价发布等逻辑都应该主要放在 Service 层。

关键词：**业务逻辑、业务校验、调用 Mapper、Redis、OSS、事务、组装 VO**

### Mapper / DAO 层负责什么？

优先级：最重要

Mapper / DAO 层负责和数据库交互，主要定义增删改查方法，并通过 MyBatis 执行对应 SQL。它只关注数据访问，不应该写复杂业务逻辑。Service 调用 Mapper 获取或修改数据，再根据业务规则决定后续处理。

关键词：**数据访问层、增删改查、MyBatis、SQL、只操作数据库、不写业务逻辑**

### 为什么项目要分 Controller、Service、Mapper？

优先级：最重要

项目分层是为了降低代码耦合，让每一层职责更清晰。Controller 负责接口入口，Service 负责业务逻辑，Mapper 负责数据访问。这样代码更容易维护、测试和扩展。比如以后修改数据库 SQL，主要改 Mapper；修改业务规则，主要改 Service；修改接口参数，主要改 Controller。

关键词：**分层架构、职责清晰、降低耦合、便于维护、便于扩展、便于测试**

### 登录接口的 SSM 调用链是什么？

优先级：最重要

登录时，前端调用 `/api/v1/auth/login` 并传入用户名或手机号、密码。请求进入 AuthController 后，Controller 调用 AuthServiceImpl 的 login 方法。Service 先校验参数，再通过 AuthMapper 根据用户名或手机号查询用户。如果用户不存在、状态不合法或密码校验失败，就抛出异常；密码校验通过后，使用 BCrypt 校验密码，并通过 JwtUtils 生成 JWT，最后封装 LoginVO 和 Result 返回给前端。

关键词：**/api/v1/auth/login、AuthController、AuthServiceImpl、AuthMapper、BCrypt、JwtUtils、LoginVO、Result**

### 高校详情查询接口的 SSM 调用链是什么？

优先级：普通

高校详情查询时，Controller 接收 universityId 后调用 UniversityService。Service 先校验高校 id，然后拼接 Redis key 查询缓存。如果缓存命中，就把 JSON 反序列化成 UniversityDetailVO 返回；如果缓存未命中，就调用 Mapper 查询高校基础信息、校区、POI、评分等数据，组装成 UniversityDetailVO 后写入 Redis，并设置过期时间，最后返回给前端。

关键词：**UniversityController、UniversityService、universityId、Redis 缓存、UniversityDetailVO、Mapper 查询、缓存回填**

### 注册验证码接口的 SSM 调用链是什么？

优先级：普通

注册验证码接口中，前端请求验证码后，AuthController 调用 AuthService 生成验证码。Service 使用 UUID 生成 captchaId，再生成验证码内容，把验证码按照指定 key 存入 Redis，并设置 5 分钟过期时间，最后把 captchaId 返回给前端。用户注册时再提交 captchaId 和验证码，后端从 Redis 中取出验证码进行比对，验证成功后删除该 key，防止重复使用。

关键词：**AuthController、generateRegisterCaptcha、captchaId、UUID、Redis、TTL 5 分钟、验证码校验、一次性使用**

### 发布评价接口的 SSM 调用链是什么？

优先级：最重要

发布评价时，请求会先经过登录拦截器解析 JWT，把 userId 放到 request 中。Controller 接收评价 DTO 后调用 ReviewService。Service 校验用户、高校、校区、评分等业务条件，然后调用 ReviewMapper 写入评价数据。评价会影响高校详情展示，所以写入成功后需要删除对应高校详情缓存，让后续查询重新加载最新数据。

关键词：**登录拦截器、JWT、userId、ReviewController、ReviewService、ReviewMapper、评价写入、删除高校详情缓存**

### 项目中 Redis、MySQL、OSS 分别在调用链中处于什么位置？

优先级：普通

MySQL 是核心业务数据的持久化存储，Mapper 层通过 MyBatis 操作 MySQL。Redis 主要作为缓存或短生命周期数据存储，在 Service 层被调用，比如验证码缓存、高校详情缓存。OSS 主要用于文件上传和访问，通常由 Service 层封装调用，不应该让 Controller 直接处理复杂文件存储逻辑。

关键词：**MySQL 持久化、Mapper、Redis 缓存、验证码、高校详情、OSS 文件上传、Service 编排**

### 项目中的 DTO、VO、Entity 分别在哪里使用？

优先级：最重要

DTO 主要用于接收前端请求参数，比如登录 DTO、注册 DTO、评价发布 DTO。Entity 主要对应数据库表结构，用于 Mapper 查询和数据库持久化。VO 主要用于返回给前端，通常会根据页面需要进行组装，不一定和数据库表完全一致。这样区分可以避免前端请求、数据库结构、接口返回三者混在一起。

关键词：**DTO 接收请求、Entity 对应数据库表、VO 返回前端、解耦、参数对象、响应对象**

## 十二、面试高频综合问题

### 你项目中 Spring 是怎么管理对象的？

优先级：最重要

我项目中主要通过 Spring Boot 和注解方式管理对象。比如 Controller 使用 `@RestController`，Service 使用 `@Service`，Mapper 使用 `@Mapper` 或 Mapper 扫描，配置类使用 `@Configuration`。这些类会被 Spring 扫描并注册成 Bean，之后对象的创建、生命周期和依赖关系都交给 Spring 容器管理。

关键词：**Spring 容器、Bean、@RestController、@Service、@Mapper、@Configuration、IOC**

### 你项目中 Service 是怎么注入 Mapper 的？

优先级：最重要

Mapper 接口会被 MyBatis 扫描并生成代理对象，然后注册到 Spring 容器中。Service 层通过依赖注入拿到 Mapper 对象，调用 Mapper 方法完成数据库操作。也就是说，Service 注入的不是手写实现类，而是 MyBatis 为 Mapper 接口生成的代理对象。

关键词：**Mapper 扫描、代理对象、Spring 容器、依赖注入、Service 调用 Mapper**

### 你项目中 Controller 如何接收前端参数？

优先级：最重要

Controller 接收参数主要有几种方式：请求体中的 JSON 使用 `@RequestBody` 绑定到 DTO；URL 路径中的变量使用 `@PathVariable`；查询参数或表单参数使用 `@RequestParam`；请求头中的 token 可以使用 `@RequestHeader` 或在拦截器中读取。项目中登录、注册、评价发布这类复杂请求一般会使用 DTO 接收。

关键词：**@RequestBody、DTO、@PathVariable、@RequestParam、@RequestHeader、JSON 参数绑定**

### 你项目中如何保证返回格式统一？

优先级：最重要

我项目中通过统一返回对象 Result 来保证接口返回格式统一。Controller 不直接返回零散数据，而是把结果封装成 Result，里面通常包含状态码、提示信息和数据。这样前端可以按照统一结构处理成功和失败响应，也方便后端统一维护接口规范。

关键词：**Result、统一返回、状态码、提示信息、data、前后端约定**

### 你项目中如何进行登录鉴权？

优先级：最重要

项目使用 JWT 和拦截器进行登录鉴权。用户登录成功后，后端生成 JWT 返回给前端，前端后续请求在 Authorization 请求头中携带 `Bearer token`。请求进入 Controller 之前，LoginCheckInterceptor 会拦截请求，解析 token，校验合法性，并把 userId 放入 request，后续业务就可以知道当前登录用户是谁。

关键词：**JWT、Authorization、Bearer token、LoginCheckInterceptor、解析 token、userId、request**

### 你项目中如何处理异常？

优先级：最重要

项目中通过全局异常处理器统一处理异常。业务层遇到账号密码错误、验证码错误、资源不存在等情况时，可以抛出异常，由 `@RestControllerAdvice` 和 `@ExceptionHandler` 统一捕获，再转换成统一 Result 返回给前端。这样可以避免每个 Controller 都写 try-catch，也能保证错误响应格式一致。

关键词：**全局异常处理、@RestControllerAdvice、@ExceptionHandler、业务异常、Result、统一错误响应**

### 你项目中哪里用到了事务？

优先级：最重要

项目中涉及多个数据库写操作或需要保证数据一致性的地方适合加事务，比如发布评价、删除评价、点赞或取消点赞、回复评价等。如果这些操作中途失败，应该回滚已经执行的数据库修改，避免出现部分成功、部分失败的数据不一致问题。Spring 中通常使用 `@Transactional` 来管理事务。

关键词：**@Transactional、写操作、数据一致性、发布评价、删除评价、点赞、回滚**

### 你项目中 MyBatis 的 SQL 写在哪里？

优先级：最重要

MyBatis 的 SQL 可以写在 Mapper XML 中，也可以通过注解写在 Mapper 接口方法上。复杂 SQL 更适合写在 XML 中，便于维护动态 SQL 和结果映射；简单 SQL 可以用注解。项目中通常是 Mapper 接口负责定义方法，XML 或注解负责提供具体 SQL。

关键词：**Mapper 接口、Mapper XML、注解 SQL、复杂 SQL、动态 SQL、结果映射**

### 你项目中为什么使用 MyBatis 而不是 JPA？

优先级：普通

因为这个项目中有不少查询需要自己控制 SQL，比如高校信息、校区、POI、评分、评价等多表数据查询和聚合。MyBatis 可以让 SQL 更直观、更可控，也方便做动态 SQL 和复杂查询。JPA 更偏对象关系自动映射，简单 CRUD 很方便，但复杂 SQL 控制起来没有 MyBatis 直接。

关键词：**SQL 可控、复杂查询、多表聚合、动态 SQL、MyBatis 半 ORM、JPA 自动映射**

### 你项目中为什么使用 Spring Boot 而不是传统 SSM？

优先级：普通

因为 Spring Boot 可以自动完成很多传统 SSM 需要手写的配置，比如 Web 容器、Spring MVC、数据源、MyBatis 整合、事务管理、配置文件加载等。它通过 starter 和自动配置减少了大量 XML 配置，让项目搭建和开发更快，也更符合现在主流 Java 后端项目的开发方式。

关键词：**Spring Boot、自动配置、starter、减少 XML、内嵌 Web 容器、快速开发、主流后端项目**

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
