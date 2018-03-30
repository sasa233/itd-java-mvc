Spring MVC环境搭建: 

    1: 需要jar + xml配置文件
    
    2: 定义前端控制器: DispatcherServlet (此Servlet用来处理 *.mvc请求,且在项目启动时候就会加载spring-mvc.xml配置文件) 
    
    3: 创建Controller代替传统HttpServlet. 需要配置: @Controller @RequestMapping(类/方法)
       
              注意: 没有继承HttpServlet，因此配置对象,都是通过注解自动注入(按类型注入 )  @Resource
                        
                   转发(forward:)与重定向(redirect:)都不需要填写工程名
                           
    4: MVC推荐使用注解,但是必须在spring-mvc.xml中开启注解扫描(首先要配置xsd文件)
    
        <mvc:annotation-driven />
	    <context:component-scan base-package="cn.mvc.controller" />
	    
	5：创建jsp文件