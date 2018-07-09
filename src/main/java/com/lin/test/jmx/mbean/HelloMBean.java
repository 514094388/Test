package com.lin.test.jmx.mbean;

public interface HelloMBean {

	public String getName();

	public void setName(String name);

	public String getAge();

	public void setAge(String age);

	public void helloWorld();

	public void helloWorld(String str);

	public void getTelephone();
}
/**
 * 接口的命名规范为以具体的实现类为前缀（这个规范很重要）
 */
