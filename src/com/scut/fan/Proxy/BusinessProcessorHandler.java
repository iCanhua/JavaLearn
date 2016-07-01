package com.scut.fan.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * 动态代理其实就是java.lang.reflect.Proxy类动态的根据您指定的所有接口生成一个class byte，
 * 该class会继承Proxy类，并实现所有你指定的接口（您在参数中传入的接口数组）；
 * 然后再利用您指定的classloader将 class byte加载进系统，
 * 最后生成这样一个类的对象，并初始化该对象的一些值，如invocationHandler,以即所有的接口对应的Method成员。
 *  初始化之后将对象返回给调用的客户端。这样客户端拿到的就是一个实现你所有的接口的Proxy对象。请看实例分析：
 * @author FAN
 *
 */
public class BusinessProcessorHandler implements InvocationHandler {
	
	private Object target = null;
	
	BusinessProcessorHandler(Object target){
		this.target = target;
	}
		 
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("You can do something here before process your business");
		Object result = method.invoke(target, args);
		System.out.println("You can do something here after process your business");
		return result;
	}
	
	/**
	 * 测试方法
	 * @param args
	 * bp.processBusiness()；实际上调用的是$Proxy0.processBusiness();
	 * 那么$Proxy0.processBusiness()的实现就是通过InvocationHandler去调用invoke方法
	 */
	 public static void main(String[] args) {
		  BusinessProcessorImpl bpimpl = new BusinessProcessorImpl();
		  BusinessProcessorHandler handler = new BusinessProcessorHandler(bpimpl);
		  BusinessProcessor bp = (BusinessProcessor)Proxy.newProxyInstance(bpimpl.getClass().getClassLoader(), bpimpl.getClass().getInterfaces(), handler);
		  bp.processBusiness();
		 }

}
