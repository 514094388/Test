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
 * 1、其中第13行是通过工厂类获取MBeanServer，用来做MBean的容器 。
 * 
 * 2、第14行中的ObjectName中的取名是有一定规范的，格式为：“域名：name=MBean名称”，其中域名和MBean的名称可以任意取。这样定义后，就可以唯一标识我们定义的这个MBean的实现类了。
 * 
 * 3、第16行是将Hello这个类注入到MBeanServer中，注入需要创建一个ObjectName类
 */