package cn.mvc.controller;

import java.nio.channels.SeekableByteChannel;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.yd.shop.model.Product;


// 无需继承HttpServlet，因此可以支持JUnit测试？？？？
@Controller //代表当前类是控制层，默认为单例模式
@RequestMapping(value="/productController")
//默认为饿汉模式，可配置为懒汉模式
public class ProductController { //单例模式，项目启动时实例化，为后续被访问做准备，这样效率高
	
	// MVC会自动注入request session application内置对象，此时request session已做处理-装饰模式，无需担心线程安全
	@Resource
	private HttpServletRequest request; // 按类型注入
	
	@Resource
	private HttpSession session; // 按类型注入
	
	@Resource
	private ServletContext application; // 按类型注入
	
	// ProductController项目启动时初始化，且单例模式
	public ProductController() {
		System.out.println("ProductController......");
	}

	// 1：获取参数
	@RequestMapping("/save")
	public String save(Product product){
		// 2：调用逻辑
		product.setName("update name");
		System.out.println(request); //每人每次一个 Current HttpServletRequest
		System.out.println(session); //每人一个 Current response
		System.out.println(application); //项目唯一 org.apache.catalina.core.ApplicationContextFacade@d305b51
		request.setAttribute("product", product);
		session.setAttribute("product", product);
		application.setAttribute("product", product);
		// 3：返回结果（无论转发还是重定向都自动添加了工程名）
		// return "redirect:/mvc/index.jsp";
		return "redirect:/index.jsp";
			
	}
	
	@RequestMapping("/query")
	public String query(String name){
		System.out.println("query......");
		// 3：返回结果（无论转发还是重定向都自动添加了工程名）
		return "forward:/index.jsp";
	}
	
	

}
