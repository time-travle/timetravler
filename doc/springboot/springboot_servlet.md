##如何在SpringBoot中使用servlet
###方法一
1、编写servlet类 继承HttpServlet类，按需复写父类的方法 对于这个servlet不做多余的注解
    
    public class CustomServlet extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
            ...
        }
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
            ...
        } 
    }
2、在启动类中添加响应的配置

    @SpringBootApplication
    public class CustomSpringApplication {
    	public static void main(String[] args) {
    		SpringApplication.run(SpringApplication.class, args);
    	}
    	// 注解必有 名字随意 尽量有意义
    	@Bean
    	public ServletRegistrationBean getServletRegistrationBean() {
    		ServletRegistrationBean bean = new ServletRegistrationBean(new CustomServlet());
    		bean.addUrlMappings("/customServle");//访问路径
    		return bean;
    	}
    }

###方法二
1、编写servlet类 继承HttpServlet类，按需复写父类的方法 对于这个servlet不做多余的注解
    
    @WebServlet(urlPatterns="/customServle",name="CustomServlet")
    public class CustomServlet extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
            ...
        }
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
            ...
        }
    }
2、在启动类中添加响应的配置

    @SpringBootApplication
    @ServletComponentScan//在SpringBoot启动时会扫描@WebServlet，并取到该类实例化
    public class CustomSpringApplication {
    	public static void main(String[] args) {
    		SpringApplication.run(SpringApplication.class, args);
    	}
    }

参考：

https://www.cnblogs.com/javastack/archive/2019/05/07/10823558.html

http://codingdict.com/sources/java/org.springframework.boot/19043.html

http://codingdict.com/sources/java/org.springframework.boot/19043.html

https://www.cnblogs.com/Guhongying/p/10517201.html