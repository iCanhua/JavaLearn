package com.scut.fan.Proxy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

public class ClientTest {
	 public static void main(String[] args) {
		  BusinessProcessorImpl bpimpl = new BusinessProcessorImpl();
		  BusinessProcessorHandler handler = new BusinessProcessorHandler(bpimpl);
		  BusinessProcessor bp = (BusinessProcessor)Proxy.newProxyInstance(bpimpl.getClass().getClassLoader(), bpimpl.getClass().getInterfaces(), handler);
		  bp.processBusiness();
		 }
}
