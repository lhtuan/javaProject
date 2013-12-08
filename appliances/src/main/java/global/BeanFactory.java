package global;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFactory {
	private static ApplicationContext context = new ClassPathXmlApplicationContext(
			"hibernate.xml");
	public static Object getBean(String beanName)
	{
		return context.getBean(beanName);
	}
}
