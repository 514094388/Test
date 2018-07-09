package com.lin.test.jmx.agent;

import java.lang.management.ManagementFactory;

import javax.management.JMException;
import javax.management.MBeanServer;
import javax.management.ObjectName;

import com.lin.test.jmx.mbean.Hello;

public class HelloAgent {
	public static void main(String[] args) throws JMException, Exception {
		MBeanServer server = ManagementFactory.getPlatformMBeanServer();
		ObjectName helloName = new ObjectName("jmxBean:name=hello");
		//create mbean and register mbean
		server.registerMBean(new Hello(), helloName);
		Thread.sleep(60 * 60 * 1000);
	}
}
/**
 * 1�����е�13����ͨ���������ȡMBeanServer��������MBean������ ��
 * 
 * 2����14���е�ObjectName�е�ȡ������һ���淶�ģ���ʽΪ����������name=MBean���ơ�������������MBean�����ƿ�������ȡ����������󣬾Ϳ���Ψһ��ʶ���Ƕ�������MBean��ʵ�����ˡ�
 * 
 * 3����16���ǽ�Hello�����ע�뵽MBeanServer�У�ע����Ҫ����һ��ObjectName��
 */