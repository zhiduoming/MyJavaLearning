# SSM 面试

## 一、整体认知

### SSM 分别指什么？

SSM 是指 Spring 、Spring MVC、和 Mybatis 三个框架的组合，常用于 Java Web 后端开发。

### Spring、Spring MVC、MyBatis 分别解决什么问题？

Spring主要负责业务对象的管理和增强，核心思想是 IOC 和 AOP。IOC 是控制反转，指对象的创建、管理和对象之间的依赖关系不再由程序员手动 new，而是交给 Spring 容器统一管理。AOP 是面向切面编程，指的是在不修改原有业务代码的情况下，对方法进行增强，比如日志、事务、权限校验等。

Spring MVC 主要负责 web 层的请求处理，包括请求分发、参数绑定、调用 Controller 方法、返回响应以及 JSON 转换。在前后端分离项目中，Spring MVC 通常负责接受前端请求并返回 JSON 数据。

Mybatis 主要负责持久层数据库操作。通过 Mapper 接口和 SQL 映射文件或注解，将 Java 方法和 SQL 语句对应起来，帮助我们执行增删改查，并把数据库查询的结果映射为 Java 对象。



### Spring Boot 和传统 SSM 有什么区别？

传统 SSM 是 Spring、SpringMVC和 Mybatis 的手动整合方式，通常需要配置 web.xml、spring.xml、springmvc.xml、mybatis-config.xml 等文件，还要手动配置数据源、SqlSessionFactory、Mapper 扫描、事务管理器和 DispatcherServlet，项目搭建和整合过程较为繁琐。

Spring Boot 是基于 Spring 生态的一套快速开发框架，它不是替代 Spring，而是通过 stater、自动配置、约定大于配置的方式简化项目搭建。使用 Spring Boot 时，通常只需要引入对应starter，在 application.yml 中配置必要参数，再通过注解开发即可。

所以二者的核心区别就是：传统 SSM 需要大量手动配置，而 Spring Boot 帮我们自动完成了很多配置，让开发变得更加简单、更快。在我的项目中主要通过 Spring Boot 启动类、application.yml、和@RestController、@Service、@Mapper等注解完成了开发，没有手动写大量的 xml 配置。

### Spring Boot 相比传统 SSM 简化了什么？

相比于传统的 SSM，Spring Boot 通过 stater、自动配置和约定大于配置的方式， 把很多常用配置自动完成。比如引入 starter 后会自动配置内嵌 Tomcat、DispatcherServlet、JSON 转换等文件；引入 MyBatis starter 后会根据 application.yml 中的数据源配置自动创建 DataSource、SqlSessionFactory 等对象。

所以 Spring Boot 不是不需要配置，而是减少了大量重复的手动配置，只需要我们保留必要的业务配置，让项目搭建更快、更简单。

### Starter 是什么？

Starter 是 springboot 提供的一种依赖整合机制，本质上是一组依赖的集合。它把某个功能模块需要的相关依赖统一封装起来，开发者只需要引入对应的 starter，就不用手动一个个引入 jar 包，也减少了版本冲突问题。

比如引入 spring-boot-starter-web，就会自动引入 Spring MVC、内嵌 Tomcat，Jackson 等 web 开发相关依赖；引入 mybatis-spring-boot-starter，就会引入 Mybatis 和 Spring boot 整合相关依赖。

Starter 通常会配合 Spring Boot 的自动配置机制使用。Starter 负责引入依赖，自动配置负责根据这些依赖和配置文件创建对应的 Bean，从而简化项目搭建。



### 自动配置是什么？

自动配置是 Spring Boot 的核心机制。它会根据当前项目引入的依赖、配置文件以及容器中已有的 Bean 来判断是否需要**创建和配置某些常用组件，从而减少大量手动配置**。

比如引入 spring-boot-starter-web 之后，SpringBoot 会自动配置内嵌 Tomcat、DisPatcherServlet、SpringMVC 和 JSON 消息转换器；引入mybatis-spring-boot-starter 并配置数据源后，Spring Boot 会自动配置 DataSource、SqlSessionFactory、Mapper 代理等相关组件。

自动配置底层主要依赖条件装配，比如 @ConditionalOnClass、@ConditionalOnMissingBean、@ConditionalOnProperty 等注解。他不是无脑配置，而是在满足条件时才生效。

### application.yml / application.properties 是什么？

二者都是 Spring Boot 的核心配置文件，用来集中管理项目运行时需要的配置，比如服务端口、数据库连接、Redis、Mybatis、日志、文件上传以及第三方服务配置等。

它们的本质作用一样，只是格式不同。properties 是 key-value 形式，yml 是层级结构，配置较多时 yml 的可读性更好。

SpringBoot 会自动读取这些配置，并结合自动配置机制创建相关的 Bean。比如读取 spring.datasource 下的配置后会自动配置 DataSource；读取 server.port 后，会设置项目启动端口。

实际项目中还可以通过 application-dev.yml、application-prod.yml 区分不同的配置环境，敏感信息一般不直接提交到仓库，而是通过环境变量或.env.example 的方式管理。

### 为什么现在项目里很少手写大量 XML 配置？

主要是因为 Spring Boot 通过 starter、自动配置、和注解开发简化了传统的 SSM 的配置。

传统 SSM 中需要在 web.xml、spring.xml、springmvc.xml、mybatis-config.xml 中手动配置 DispatcherServlet、组件扫描、数据源、SqlSessionFactory、Mapper 扫描、事务管理器等内容，配置比较繁琐。

Spring Boot 引入对应 starter 后，会根据依赖和 application.yml 中的配置自动创建很多常用组件。比如引入 Web starter 后自动配置内嵌 Tomcat、DispatcherServlet 和 JSON 转换器；引入 MyBatis starter 后自动配置 DataSource、SqlSessionFactory 等。再配合 @Controller、@Service、@Mapper、@Transactional 等注解，就不需要手写大量 XML 了。

不过 XML 并不是完全淘汰，比如 MyBatis 中复杂 SQL 和动态 SQL 仍然常常写在 XML 中，只是传统框架整合类 XML 配置变少了。

## 二、Spring 核心

### Spring 是什么？

Spring 是一个 Java 企业级开发框架，主要用于简化 Java 后端开发。它的核心思想是 IOC 和 AOP，IOC 用来管理对象的创建和依赖关系，AOP 用来抽取事务、日志、权限校验等公共逻辑。除此之外，Spring 还提供事务管理、Web 开发支持，并且可以方便地整合 MyBatis、Redis 等其他技术。

### 为什么要使用 Spring？

使用 Spring 主要是为了简化开发、降低耦合、提高项目可维护性。没有 Spring 的话，对象的创建和依赖关系需要程序员手动维护，代码之间耦合较高。Spring 通过 IOC 容器统一管理对象，通过 DI 自动注入依赖，让业务类不需要自己创建依赖对象。

同时，Spring 通过 AOP 可以统一处理事务、日志、权限校验等公共逻辑，减少重复代码。Spring 还提供事务管理和良好的框架整合能力，所以在 Java 后端项目中使用非常广泛。

### Spring 的核心思想是什么？

Spring 的核心思想主要是 IOC 和 AOP。IOC 是控制反转，指对象的创建、管理以及对象之间的依赖关系不再由程序员手动 new 和维护，而是交给 Spring 容器统一管理，从而降低代码耦合。AOP 是面向切面编程，指在不修改原有业务代码的情况下，对方法进行增强，比如统一处理事务、日志、权限校验等公共逻辑。

### 什么是 IOC？

IOC 是控制反转，指对象的创建、管理以及对象之间的依赖关系不再由程序员手动 new 和维护，而是交给 Spring 容器统一管理。所谓“控制反转”，就是对象创建和依赖装配的控制权从程序员手里转移到了 Spring 容器手里。

### 什么是 DI？

DI 是依赖注入，是 IOC 的具体实现方式，他指的是 Spring 容器在创建 Bean 的时候，把这个 Bean 所依赖的其他 Bean 自动注入进来，从而完成对象之间依赖关系的装配。

比如Service 层依赖 Mapper 层的时候，不需要在 Service 层中手动 new Mapper，而是由 Spring 穿件 Mapper 代理对象，并注入到 Service 中。这样业务类只关注业务逻辑，不需要关心依赖对象的创建，从而降低代码耦合。

### IOC 和 DI 的关系是什么？

IOC 是控制反转，是一种设计思想，IOC 是控制反转，是一种设计思想，指对象的创建和依赖关系交给 Spring 容器管理。DI 是依赖注入，是 IOC 的具体实现方式。Spring 容器创建 Bean 后，会把这个 Bean 依赖的其他 Bean 自动注入进来，从而完成对象之间依赖关系的装配。

简单来说，IOC 是目标：把对象控制权交给 Spring；DI 是手段：Spring 通过依赖注入把对象关系组装起来。

### Bean 是什么？

Bean 是被 Spring 容器管理的对象。我们通过@Component、@Controller、@Service、@Repository 等注解标记类，Spring 在扫描过后会创建这些对象并放入容器中。之后其他 Bean 就可以通过依赖注入来使用它们。

在项目中，Controller、Service、配置类等通常都是 Bean。MyBatis 和 Spring 整合后，Mapper 代理对象也会被注册到 Spring 容器中。

### Spring 容器是什么？

Spring 容器是 Spring 用来创建和管理 Bean 的核心组件。它负责 Bean 的创建、依赖注入、生命周期管理等工作。常见的 Spring 容器有 BeanFactory、ApplicationContext，实际开发中常用 ApplicationContext。

Spring 容器负责创建 Bean，保存 Bean，维护 Bean 之间的依赖关系，并在需要的时候通过依赖注入把 Bean 注入给其他 Bean使用。

### IOC 有什么好处？

IOC 的好处主要是降低代码耦合。对象的创建和依赖关系由 Spring 容器统一管理，业务代码不需要去手动 new 依赖对象，也不用关注对象创建的细节。

这样后续如果要替换实现类或者调整依赖关系，只需要修改配置或 Bean 的定义，业务代码改动更少。同时Bean 交给 Spring 管理后，也方便 Spring 对齐进行 AOP、事务等功能增强。

### Spring 依赖注入有哪些方式？

Spring 常见依赖注入方式有属性注入、Setter 方法注入和构造方法注入。

属性注入是在成员变量上使用 @Autowired 或 @Resource，写法简单，但依赖关系不够清晰，也不利于测试。

Setter 注入是通过 set 方法注入，适合可选依赖，但依赖可能在对象创建后被修改。

构造方法注入是在创建对象时通过构造方法传入依赖，可以保证对象创建时依赖已经准备好，也可以配合 final 字段保证依赖不可变，所以现在更推荐构造方法注入。

### 为什么更推荐构造方法注入？

更推荐构造方法注入，是因为它能让依赖关系更清晰。一个类需要哪些依赖，可以直接从构造方法中看出来，同时构造方法注入可以配合 final 字段，保证依赖在对象创建后不可变。

另外，构造方法注入可以保证对象创建时依赖就已经准备好，避免对象处于依赖不完整的状态，也更方便进行单元测试。所以在正式项目中，必需依赖一般更推荐使用构造方法注入。

### @Autowired 和 @Resource 的区别？

@Autowired 是 Spring 提供的注解，默认按类型注入。如果同一个类型有多个 Bean，需要配合 @Qualifier 指定具体 Bean 名称。

@Resource 是 JDK/Jakarta 提供的注解，默认按名称注入，如果按名称找不到，再按类型注入。它也可以通过 name 属性指定要注入的 Bean。

### @Qualifier 有什么用？

@Qualifier 通常和 @Autowired 配合使用。当容器中存在多个相同类型的 Bean 时，@Autowired 只按类型无法确定注入哪个 Bean，就可以通过 @Qualifier 指定 Bean 的名称，避免注入冲突。

### @Component、@Controller、@Service、@Repository 的区别？

@Component、@Controller、@Service、@Repository 本质上都是把类交给 Spring 容器管理，注册成 Bean。区别主要是语义和分层不同。@Component 是通用组件，@Controller 用在控制层，@Service 用在业务层，@Repository 用在持久层。这样可以让项目分层更清晰，也方便 Spring 做组件扫描和后续扩展。

### @Configuration 是什么？

@Configuration 用来标记一个配置类，相当于传统 XML 配置文件。配置类中可以通过 @Bean 方法向 Spring 容器注册对象，也可以实现一些配置接口，比如 WebMvcConfigurer 来配置拦截器、跨域等。

### @Bean 是什么？

@Bean 用在配置类的方法上，**表示将方法返回的对象注册到 Spring 容器中**。它常用于注册第三方类或需要手动创建的对象，比如 PasswordEncoder、ObjectMapper、RedisTemplate 等。

### @Component 和 @Bean 的区别？

@Component 是类级别注解，通常用于我们自己编写的类，Spring 通过组件扫描把它注册成 Bean。

@Bean 是方法级别注解，通常写在 @Configuration 配置类中，用来把方法返回的对象注册成 Bean。它更适合注册第三方类或需要自定义创建过程的对象。

### Bean 的生命周期大概是什么？

Spring Bean 生命周期大致包括实例化、属性注入、初始化、使用和销毁。Spring 容器先根据 Bean 定义创建对象，然后完成依赖注入，接着执行初始化相关方法，之后 Bean 就可以被业务代码使用。容器关闭时，如果 Bean 定义了销毁方法，Spring 会调用对应销毁逻辑。

### Spring Bean 默认是单例还是多例？

Spring Bean 默认是单例的，也就是 singleton。默认情况下，一个 Bean 在 Spring 容器中只会创建一个实例，多个地方注入的都是同一个对象。

### singleton 和 prototype 的区别？

singleton 是 Spring 默认作用域，表示一个 Bean 在容器中只有一个实例，多个地方注入的是同一个对象。prototype 表示每次从容器获取 Bean 时都会创建一个新的实例。

实际项目中，Controller、Service、Mapper 这类通常都是无状态的，所以默认使用 singleton 就可以。

### Bean 的作用域有哪些？

Spring Bean 常见作用域有 singleton、prototype、request、session、application、websocket 等。默认是 singleton，表示容器中只有一个实例。prototype 表示每次获取都会创建新实例。request 和 session 主要用于 Web 环境，分别表示每次 HTTP 请求或每个 Session 对应一个 Bean 实例。

## 三、Spring AOP

### AOP 是什么？

AOP 全称 Aspect Oriented Programming，面向切面编程。它可以在不修改原有业务代码的情况下，对方法进行增强。

AOP 主要用于把日志、事务、权限校验、接口耗时统计等横切逻辑从业务代码中抽离出来，统一处理，从而减少重复代码，提高代码可维护性。

可以理解为：业务方法只负责核心业务，公共增强逻辑由 AOP 在方法执行前后统一织入。

### 为什么需要 AOP？

需要 AOP 是因为很多系统级功能，比如日志、事务、权限校验、性能统计等，会横跨多个业务模块。如果直接写在每个业务方法中，会造成大量重复代码，也会让业务逻辑变得不清晰。

AOP 可以把这些公共逻辑抽离成切面，在方法执行前后统一增强，从而提高代码复用性和可维护性。

### AOP 适合解决什么问题？

AOP 适合解决和核心业务无关，但很多地方都会用到的横切逻辑，比如事务管理、日志记录、权限校验、接口耗时统计、参数校验、缓存处理、异常监控、审计记录等。

这些逻辑不是某一个业务独有的，而是很多业务都会用到，所以适合通过 AOP 抽取出来统一处理。

### AOP 中的连接点、切入点、通知、切面分别是什么？

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

常见通知类型有：

```text
@Before：前置通知，在目标方法执行前执行
@After：后置通知，在目标方法执行后执行，无论是否异常都会执行
@AfterReturning：返回通知，在方法正常返回后执行
@AfterThrowing：异常通知，在方法抛出异常后执行
@Around：环绕通知，功能最强，可以在方法执行前后都加入逻辑，并且可以控制目标方法是否执行
```

### @Before、@After、@AfterReturning、@AfterThrowing、@Around 的区别？

@Before 是前置通知，在目标方法执行前执行，适合权限校验、参数记录、前置日志等场景。

@After 是后置通知，在目标方法执行后执行，无论方法正常返回还是抛出异常都会执行，类似 finally。

@AfterReturning 是返回通知，在方法正常返回后执行，可以获取方法返回值。

@AfterThrowing 是异常通知，在方法抛出异常后执行，可以获取异常信息。

@Around 是环绕通知，功能最强，可以在方法执行前后都加入逻辑，并通过 ProceedingJoinPoint 的 proceed 方法控制目标方法是否执行。

其中 JoinPoint 可以获取被增强方法的信息，比如方法参数、方法签名、目标对象等。ProceedingJoinPoint 是环绕通知专用的，它除了能获取方法信息，还可以通过 proceed 方法执行目标方法，并获取返回值或处理异常。

### Spring AOP 底层是怎么实现的？

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

JDK 动态代理是基于接口实现的，要求目标类实现接口，代理对象会实现同样的接口。

CGLIB 动态代理是基于继承实现的，它会生成目标类的子类作为代理对象，所以不要求目标类实现接口，但不能代理 final 类和 final 方法。

简单来说：

```text
JDK 动态代理：基于接口
CGLIB 动态代理：基于继承
```

如果目标类实现了接口，Spring 可以使用 JDK 动态代理；如果目标类没有实现接口，Spring 可以使用 CGLIB 动态代理。实际项目中不用死记某个类一定走哪种代理，重点是理解 Spring AOP 是通过代理对象在目标方法前后加入增强逻辑。

### 项目中哪些场景会用到 AOP？

项目中 AOP 最常见的应用是事务管理，比如 @Transactional。Spring 会通过 AOP 动态代理在方法执行前开启事务，方法正常结束后提交事务，发生异常时回滚事务。

我的项目里没有自己手写 @Aspect 这种自定义切面，但有使用 Spring AOP 的典型场景，也就是 @Transactional 事务管理。在评价模块中，发布评价、删除评价、点赞、取消点赞、发布回复、删除回复等写操作都加了 @Transactional。

除此之外，日志记录、接口耗时统计、权限校验、审计记录等也可以通过 AOP 实现。不过在我的项目中，JWT 登录校验主要是通过 Spring MVC 拦截器实现的，而不是 AOP；统一异常处理使用的是 @RestControllerAdvice。

## 四、Spring 事务

### @Transactional 是什么？

@Transactional 是 Spring 提供的声明式事务注解，用来让 Spring 自动管理事务。标注了@Transactional 的方法会在执行前开启事务，方法正常执行结束后提交事务，如果发生符合回滚规则的异常则回滚事务。它通常加在 Service 层的方法上，用于保证一组数据库操作的原子性。

### Spring 事务是怎么实现的？

Spring 事务主要是基于动态代理实习拿的。Spring 会为带有@Transactional 的 Bean 创建代理对象，调用方实际调用的是代理对象。代理对象在目标方法执行前通过事务管理器开启事务，方法正常执行 1 完成后提交事务，如果抛出符合回滚规则的异常则回滚事务。

### Spring 事务和 AOP 有什么关系？

Spring 声明式事务是 AOP 的典型应用。@Transactional 注解标注的方法会被 Spring AOP 代理增强，代理对象会在目标方法执行前开启事务，在方法正常结束后提交事务，在方法抛出符合回滚规则的异常时回滚事务。所以事务管理本质上就是通过 AOP 把事务这种横切逻辑从业务代码中抽离出来统一处理。

### @Transactional 默认回滚哪些异常？

@Transactional 默认只会对 RuntimeException 极其子类和 Error 进行回滚，也就是非受检异常。对于 checked exception ，默认不会回滚，除非通过 rollbackFor 指定。

### checked exception 会不会默认回滚？

checked exception 默认不会回滚。如果希望 IOException、SQLException 这类 checked exception 也触发回滚，需要通过 rollbackFor 进行显示指定。

### rollbackFor 有什么用？

rollbackFor 用来指定哪些异常类型需要触发事务回滚。因为@Transactional 默认只回滚 RuntimeException及其子类和 Error，对于 checkedException 默认不回滚，如果希望所有异常都能回滚，可以配置 rollbackFor = Exception.class。

### 事务传播行为是什么？

事务的传播行为是指多个事务方法相互调用时，事务应该如何传播。比如一个已经存在事务的方法调用另一个带事务的方法时，内层方法是加入外层事务，还是新建一个事务，或者以非事务方式执行，这些规则就是事务传播行为。

### REQUIRED 和 REQUIRES_NEW 的区别？

REQUIRED 是默认的传播行为，表示如果当前存在事务，就加入当前事务；如果没有事务，就新建事务。内外层方法属于同一个事务，一起提交或回滚。

REQUIRED_NEW 表示无论当前是否存在事务，都会新建一个事务。如果当前有事务，会先挂起外层事务。新事务和外层事务相互独立，可以单独提交和回滚。

### 常见事务传播行为有哪些？

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

Spring事务的隔离级别和数据库事务的隔离级别相互对应

```text
DEFAULT:使用数据库默认隔离级别
READ_UNCOMMITTED:读未提交
READ_COMMITTED:读已提交
REPEATABALE_READ:可重复读
SERIALIZABLE:串行化
```



### @Transactional 常见失效场景有哪些？

@Transactional 常见失效场景包括：

1.方法不是 public；

2.同一个类内部方法调用导致没有经过代理对象；

3.异常被 catch 但没有继续抛出；

4.抛出 checked exception 但没有配置 rollbackFor

5.类没有交给 Spring 容器进行管理

6.数据库存储引擎不支持事务；

7.在 private、static、final 方法上使用事务等。

### 为什么同一个类内部方法调用会导致事务失效？

因为 Spring 事务是基于 AOP 动态代理实习拿的，事务生效的前提是方法调用经过代理对象。同一个类内部方法调用本质上是this 调用，直接调用目标对象自身的方法，没有经过 Spring 代理对象，所以代理对象无法在方法前后加入事务增强逻辑，@Transactional 就会失效。

### 项目中哪些业务场景适合加事务？

项目中适合加事务的场景一般是**涉及数据库写操作，并且多个操作之间需要保持一致性的业务**。比如发布评价、删除评价、点赞、回复等操作。我的项目中在评价模块的发布评价、删除评价、点赞、取消点赞、发补回复、删除回复方法上都使用了@Transactional，保证数据库写操作在出现异常时可以回滚。

## 五、Spring MVC

### Spring MVC 是什么？

Spring MVC 是 Spring 体系中的 Web 层框架，主要用来处理HTTP 请求和响应。

它基于 MVC 思想，把 Web 请求处理拆分成 Controller、Service、Model、View 或 JSON 响应等部分。

在前后端分离项目中，Spring MVC 主要负责：

* 接收前端 HTTP 请求
* 根据请求路径找到对应的 Controller 方法
* 完成参数绑定，比如把 JSON 格式的数据绑定到 DTO
* 调用业务逻辑
* 将 Java对象序列化成 JSON 返回给前端

### Spring MVC 和 Spring 的关系是什么？

Spring 是一个完整的应用开发框架，核心是 IOC 和 AOP，负责对象管理、依赖注入、事务、AOP 等能力。

SpringMVC 是 Spring 体系中的 Web MVC 模块，主要负责 Web 层请求处理。它依赖 Spring 容器来管理 Controller、Service 等 Bean

### DispatcherServlet 是什么？

DispatcherServlet 是 Spring MVC 的前端控制器，也是整个 Spring MVC 请求处理的核心入口。

前端请求进入后，会先到达 DispatcherServlet，再由它负责协调后续流程，比如查找对应的 Controller 方法、调用方法、处理返回结果等。

它本身不写业务逻辑，主要负责请求分发和流程调度。是 Spring MVC 的总调度器。

### Spring MVC 请求执行流程是什么？

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

前后端分离项目中，Controller 通常使用@RestController，或者在方法上使用@ResponseBody。

Controller 方法返回 Java 对象之后，Spring MVC 会通过 HttpMessageConverter，通常底层采用 Jackson，将对象序列化成 JSON，然后写入 HTTP 响应体

### @Controller 和 @RestController 的区别？

@Controller 一般用于传统的 MVC 项目，方法返回值默认会被当做视图名，通常用于返回页面。

如果@Controller 中的方法想直接返回 JSON，需要在方法上加@ResponseBody

而@RestController 等价于@Controller+@ResponseBody，他表示当前类中的所有方法的返回值都会直接写入响应体，通常用于前后端分离项目返回 JSON

### @RequestMapping、@GetMapping、@PostMapping、@PutMapping、@DeleteMapping 的区别？

@RequestMapping 是通用请求注解，可以指定请求路径和请求方法。

@GetMapping、@PostMapping、@PutMapping、@DeleteMapping 是组合注解，分别对应 HTTP 的 GET、POST、PUT、DELETE 请求。

```text
GET:查询资源
POST：新增资源或提交操作
PUT：更新资源
DELETE：删除资源
```



### @RequestParam 是什么？

@RequstParam 用来接收 URL 查询参数或者表单参数。比如前端请求：`/users?page=1&size=10`后端可以用@RequestParam 来接收 page 和 size

它常用于分页参数、搜索关键字、筛选条件等场景，也可以通过 required 设置参数是否必填，也可以通过 defaultValue 来设置默认值。

### @PathVariable 是什么？

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

@RequestHeader 用来获取 HTTP 请求头中的数据。比如前端在请求头中携带：

`Authorization: Bearer token`

后端就可以使用`@RequestHeader("Authorization")`来获取这个请求头。

不过在实际项目中，像 JWT 这种认证信息一般不会在每个 Controller 里面手动获取，而是放在拦截器或过滤器中统一解析。

### @RequestParam、@PathVariable、@RequestBody 的区别？

@RequestParam 用来接收 URL 问号后面的查询参数，比如分页、搜索条件

@PathVariable 用来接收 URL 路径中的变量，比如`/users/{id}`中的 id。

@RequestBody 用来接收请求体中的 JSON 数据，并转换成 Java 对象。

### 前端 JSON 如何绑定到 DTO？

前端发送 JSON 数据时，后端可以使用@RequestBody 接收，并绑定到 DTO 对象上。

Spring MVC 会根据 JSON 字段名和 DTO 属性名进行匹配，然后通过 Jackson 将 JSON 反序列化成 DTO 对象

### @ResponseBody 是什么？

@ResponseBody 表示方法返回值不再被解析成视图名称，而是直接写入 HTTP 响应体。如果返回的是 Java 对象，SpringMVC 会通过消息转换器将对象序列化成 JSON。

在前后端分离项目中，@ResponseBody 常用于返回 JSON 数据。@RestController 已经包含了@ResponseBody，所以使用@RestController 时一般不需要再单独加。

### 为什么项目中要使用统一返回结果？

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

Entity 是实体类，通常和数据库表对应，用于持久层数据映射。

DTO 是数据传输对象，通常用于接收前端请求参数、比如登录参数、注册参数、新增参数。

VO 是视图对象，是后端返回给前端展示用的数据。

这样分层可以避免直接暴露数据库实体，防止敏感字段泄露、也可以让请求参数、数据库字段和返回数据各自保持清晰。

### Spring MVC 如何做 JSON 序列化和反序列化？

Spring MVC 用过 HttpMessageConverter 完成 JSON 的序列化和反序列化，常见实现是 Jackson。

反序列化是指前端传 JSON，后端通过@RequestBody 接收，Spring MVC 会把 JSON 转换成 DTO 对象。

序列化是指后端返回 Java 对象，配合@ResponseBody 或者@RestController，Spring MVC 会把 Java 对象转换成 JSON 返回给前端。

底层主要依赖 HttpMessageConverter 和 Jackson 完成。

## 六、拦截器与异常处理

### Interceptor 是什么？

Interceptor 是 Spring MVC 提供的拦截器机制，可以在请求进入 Controller 之前、Controller 执行之后、请求完成之后插入一些通用处理逻辑。

常见使用场景有：登录鉴权、权限校验、请求日志、接口耗时统计、统一参数预处理。

拦截器通常要实现`HandlerInterceptor`接口，并重写里面的方法。

在 Spring MVC 中，拦截器主要围绕 Controller 方法执行前后进行增强。它不是用来写具体业务逻辑的，而是用来处理多个接口都需要的通用逻辑。

### 拦截器的 preHandle、postHandle、afterCompletion 分别什么时候执行？

Spring MVC 拦截器中常见的三个方法是：

preHandle，postHandle，afterCompletion

其中 preHandle 在 Controller 方法执行前执行，返回值是 boolean，如果返回 true：继续执行后续流程，最终进入 Controller。返回 false：中断请求，不再进入 Controller。可以用来做登录校验，权限校验，请求预处理。

postHandle 在 Controller 方法执行之后、视图渲染或响应处理之前执行。在传统返回页面的 MVC 项目中，可以在这里对 ModelAndView 做处理。在前后端分离项目中，因为大多数接口直接返回 JSON，postHandle 的使用频率相对低一些。

afterCompletion 在整个请求执行完之后执行。也就是响应结果处理完成之后执行。一般用于资源清理、记录请求日志、统计接口耗时、异常后的收尾处理。

### 拦截器和过滤器 Filter 的区别？

拦截器 Interceptor 和过滤器 Filter 都可以对请求进行拦截，但它们的层级和使用场景不同。

Filter 是 Servlet 规范中的组件，属于 Java Web 层面的机制。它在请求进入 Spring MVC 之前就可以生效，作用范围更底层。主要用于字符编码处理、跨域处理、底层安全过滤。

Interceptor 是 Spring MVC 提供的机制，依赖 Spring 容器，主要拦截 Controller 方法相关的请求。

### 项目中 JWT 鉴权为什么适合用拦截器？

JWT 鉴权属于多个接口都需要的通用逻辑，不适合在每个 Controller 方法中重复解析 token。可以减少代码重复，避免接口遗漏，让 Controller方法职责更清晰。

### 项目中 JWT 鉴权调用链是什么？

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

项目中一般不会在每个 Controller 里重复写 try-catch，而是通过全局异常处理器统一处理异常。业务层遇到账号密码错误、验证码过期、资源不存在、无权限等情况时，会抛出异常，最后由@RestControllerAdvice配合 @ExceptionHandler 捕获，并转换成统一的 Result 返回给前端。这样可以减少重复代码，也能保证接口错误响应格式一致。我的 UniTour 项目里目前主要是抛 RuntimeException 表示业务异常，后续可以进一步抽象BusinessException 和错误码，让业务异常和系统异常区分得更清楚。

## 七、MyBatis 基础

### MyBatis 是什么？

Mybatis 是一个 Java **持久层框架**，主要用来简化 Java 操作数据库的过程。它底层还是基于 JDBC，但帮我们封装了获取连接、执行 SQL、处理结果集等重复操作。开发者只需要编写 Mapper 接口和 SQL 语句，Mybatis 就可以帮我们执行 SQL，并把查询结果映射成 Java对象。

关键词：**持久层框架、简化 JDBC、Mapper 接口、SQL 映射、结果映射成 Java 对象**

### MyBatis 解决了什么问题？

MyBatis 主要解决了 JDBC 开发中重复代码多、结果集处理麻烦、SQL 和 Java 代码耦合较重的问题。使用 JDBC 时，我们需要手动获取连接、创建 Statement、设置参数、执行 SQL、遍历 ResultSet 并封装对象。MyBatis 对这些流程进行了封装，让开发者主要关注 SQL 本身和对象映射，从而提高开发效率。

关键词：**减少 JDBC 重复代码、封装连接和执行流程、自动映射结果集、保留 SQL 控制权、提高开发效率。**

### MyBatis 和 JDBC 的区别？

JDBC 是 Java 原生操作数据库的 API，开发者需要自己管理连接、创建 SQL 执行对象、设置参数、处理结果集，代码比较重复。MyBatis 是对 JDBC 的封装，它把 SQL 和 Java 方法进行映射，开发者通过调用 Mapper 接口来执行 SQL，MyBatis 负责参数绑定、SQL 执行和结果映射。简单来说，JDBC 更底层，而 MyBatis 更偏框架化，开发效率更高。

关键词：JDBC 是原生 API，MyBatis 封装 JDBC，Mapper 调用，参数绑定、执行 SQL、结果映射、减少重复代码

### MyBatis 和 JPA / Hibernate 的区别？



### MyBatis 为什么叫半 ORM 框架？

ORM 是对象关系映射，指的是把数据库表和 Java 对象进行映射。MyBatis 可以把 SQL 查询的结果映射成 Java 对象，也可以把 Java 对象中的属性作为 SQL 参数传入，所以它具备ORM 的一部分能力。但 MyBatis 的 SQL 主要还是有开发者自己编写，不想 Hibernate/JPA 那样自动生成大量的 SQL，所以它通常被称为半 ORM 框架。

关键词：ORM、对象关系映射、结果映射、SQL 自己写、半自动、区别于 JPA/Hibernate

### Mapper 接口是什么？

Mapper 接口是 MyBatis 提供给 Java 代码调用数据库操作的接口。它一般定义增删改查方法，本身通常没有手写实现类。程序运行时，MyBatis 会为 Mapper 接口生成代理对象，Service 层调用 Mapper 方法时，代理对象会根据方法找到对应的 SQL 并执行。

关键词：数据库操作接口、增删改查方法、没有手写实现类、MyBatis 代理对象、Service 调用 Mapper

### Mapper XML 是什么？

Mapper XML 是 MyBatis 用来编写和管理 SQL 语句的 XML 文件。它里面可以写 select、insert、update、delete 等 SQL，并通过 namespace 和 id 与 Mapper 接口的方法建立对应关系。使用 Mapper XML 可以把 SQL 从 Java 代码中分离出来，方便编写复杂 SQL 和动态 SQL。

关键词：SQL 映射文件，select/insert/update/delete，namespace，id，复杂 SQL，动态 SQL

### Mapper 接口的方法如何和 XML 中的 SQL 对应？

Mapper 接口方法和 XML 中 SQL 的对应主要依靠 namespace 和 id。Mapper XML 的 namespace 通常写 Mapper 接口的全限定名，XML 中每条 SQL 的 id 对应 Mapper 接口中的方法名。这样当 Service 调用 Mapper 接口方法时，MyBatis 就能根据接口名和方法名找到 XML 中对应的 SQL 并执行。

关键词：

```text
namespace = Mapper 接口的全限定名
id= Mapper 方法名
参数绑定
resultType/resultMap
代理对象执行 SQL
```

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

`#{}`和 `${}`都可以在MyBatis的SQL中取参数，但底层处理方式不同。`#{}`使用的是预编译占位符方式，参数会作为值传入SQL，类似于PreparedStatement，可以防止SQL注入。`${}`是字符串拼接，会把参数内容直接拼接到SQL中，存在SQL注入风险。实际开发中，普通参数传值优先使用`#{}`，只有表名、字段名、排序字段这类无法用占位符的位置，才可能使用 ${}，并且要做好白名单校验。

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
