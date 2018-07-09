package com.lin.test.jmx.agent;

import java.lang.management.ManagementFactory;

import javax.management.JMException;
import javax.management.MBeanServer;
import javax.management.ObjectName;

import com.lin.test.jmx.mbean.Hello;
import com.sun.jdmk.comm.HtmlAdaptorServer;

public class HelloHtmlAgent {
	public static void main(String[] args) throws JMException, Exception {
		MBeanServer server = ManagementFactory.getPlatformMBeanServer();
		ObjectName helloName = new ObjectName("jmxBean:name=hello");
		//create mbean and register mbean
		server.registerMBean(new Hello(), helloName);

		ObjectName adapterName = new ObjectName("HelloAgent:name=htmladapter,port=8082");
		HtmlAdaptorServer adapter = new HtmlAdaptorServer();
		server.registerMBean(adapter, adapterName);
		adapter.start();
	}
}

/**
 * 需要到导入外部jar包jdmk
 */