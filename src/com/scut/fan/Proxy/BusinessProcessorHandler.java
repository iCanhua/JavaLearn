package com.scut.fan.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * ��̬������ʵ����java.lang.reflect.Proxy�ද̬�ĸ�����ָ�������нӿ�����һ��class byte��
 * ��class��̳�Proxy�࣬��ʵ��������ָ���Ľӿڣ����ڲ����д���Ľӿ����飩��
 * Ȼ����������ָ����classloader�� class byte���ؽ�ϵͳ��
 * �����������һ����Ķ��󣬲���ʼ���ö����һЩֵ����invocationHandler,�Լ����еĽӿڶ�Ӧ��Method��Ա��
 *  ��ʼ��֮�󽫶��󷵻ظ����õĿͻ��ˡ������ͻ����õ��ľ���һ��ʵ�������еĽӿڵ�Proxy�����뿴ʵ��������
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
	 * ���Է���
	 * @param args
	 * bp.processBusiness()��ʵ���ϵ��õ���$Proxy0.processBusiness();
	 * ��ô$Proxy0.processBusiness()��ʵ�־���ͨ��InvocationHandlerȥ����invoke����
	 */
	 public static void main(String[] args) {
		  BusinessProcessorImpl bpimpl = new BusinessProcessorImpl();
		  BusinessProcessorHandler handler = new BusinessProcessorHandler(bpimpl);
		  BusinessProcessor bp = (BusinessProcessor)Proxy.newProxyInstance(bpimpl.getClass().getClassLoader(), bpimpl.getClass().getInterfaces(), handler);
		  bp.processBusiness();
		 }

}
