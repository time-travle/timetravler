#注解Annotaion
@Component	最普通的组件，可以被注入到spring容器进行管理

@Repository	作用于持久层

@Service	作用于业务逻辑层

@Controller	作用于表现层（spring-mvc的注解）

@Autowired 依赖注入

@ConfigurationProperties与@EnableConfigurationPropertie的作用就是：

    @ConfigurationProperties注解的作用是把yml或者properties配置文件转化为bean。
    
    @EnableConfigurationProperties注解的作用是使@ConfigurationProperties注解生效

@Configuration的作用上面我们已经知道了，被注解的类将成为一个bean配置类。 注解的类可以看作是能生产让Spring IoC容器管理的Bean实例的工厂。

@ComponentScan的作用就是自动扫描并加载符合条件的组件，比如@Component和@Repository等，最终将这些bean定义加载到spring容器中。

@EnableAutoConfiguration 这个注解的功能很重要，借助@Import的支持，收集和注册依赖包中相关的bean定义。

@Configuration&与@Bean->基于java代码的bean配置

@Conditional->设置自动配置条件依赖

@EnableConfigurationProperties与@ConfigurationProperties->读取配置文件转换为bean。

@EnableAutoConfiguration、@AutoConfigurationPackage 与@Import->实现bean发现与加载。

@Bean注解告诉Spring，一个带有@Bean的注解方法将返回一个对象，该对象应该被注册到spring容器中。

##如果要让一个普通类交给Spring容器管理，通常有以下方法：
    1、使用 @Configuration与@Bean 注解
    2、使用@Controller @Service @Repository @Component 注解标注该类，然后启用@ComponentScan自动扫描
    3、使用@Import 方法

##依赖注入三种方式
	依赖注入分为三种方式：
		变量（filed）注入
			    @Autowired
			    UserDao userDao;
		构造器注入
			    UserDao userDao;
			    @Autowired
			    public UserServiceImpl(UserDao userDao) {
			        this.userDao = userDao;
			    }
		set方法注入
			    private UserDao userDao;
			    @Autowired
			    public void setUserDao (UserDao userDao) {
			        this.userDao = userDao;
			    }
		原文链接：https://blog.csdn.net/zhangjingao/article/details/81094529
		
	优点：变量方式注入非常简洁，没有任何多余代码，非常有效的提高了java的简洁性。即使再多几个依赖一样能解决掉这个问题。
	
	缺点：不能有效的指明依赖。相信很多人都遇见过一个bug，依赖注入的对象为null，在启动依赖容器时遇到这个问题都是配置的依赖注入少了一个注解什么的，然而这种方式就过于依赖注入容器了，当没有启动整个依赖容器时，这个类就不能运转，在反射时无法提供这个类需要的依赖。
	
	在使用set方式时，这是一种选择注入，可有可无，即使没有注入这个依赖，那么也不会影响整个类的运行。
	在使用构造器方式时已经显式注明必须强制注入。通过强制指明依赖注入来保证这个类的运行。
	
	总结下：
	变量方式注入应该尽量避免，使用set方式注入或者构造器注入，这两种方式的选择就要看这个类是强制依赖的话就用构造器方式，选择依赖的话就用set方法注入
	
	结论
	如果注入的属性是必选的属性，则通过构造器注入。
	如果注入的属性是可选的属性，则通过setter方法注入。
	至于field注入，不建议使用
