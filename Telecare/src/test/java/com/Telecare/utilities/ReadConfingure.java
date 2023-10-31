package com.Telecare.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfingure {
	Properties pro;
public ReadConfingure()
{
	try
	{
		File fl= new File("./Configuration/configure.properties");
		FileInputStream fi=new FileInputStream(fl);
		pro=new Properties();
		pro.load(fi);
	}
	catch(Exception e)
	{
		System.out.println("exception hanled");
	}
	
}

public String getbaseurl()
{
	String burl=pro.getProperty("baseurl");
	return burl;
}
public String getusername()
{
	String usr=pro.getProperty("username");
	return usr;
}
public String getpassword()
{
	String psw=pro.getProperty("password");
	return psw;
}
public String getchromepath()
{
	String cpth=pro.getProperty("chromepath");
	return cpth;
}
public String getfirefoxpath()
{
	String fpth=pro.getProperty("firefoxpath");
	return fpth;
}


public String getcusName()
{
	String custName=pro.getProperty("Customername");
	return custName;
}
public String getdob()
{
	String custdd=pro.getProperty("DD");
	return custdd;
}
public String getdob1()
{
	String custmm=pro.getProperty("MM");
	return custmm;
}
public String getdob2()
{
	String custyy=pro.getProperty("YYYY");
	return custyy;
}
public String getAddress()
{
	String custAdd=pro.getProperty("Address");
	return custAdd;
}
public String getCity()
{
	String custCity=pro.getProperty("City");
	return custCity;
}
public String getState()
{
	String custState=pro.getProperty("State");
	return custState;
}
public String getPin()
{
	String custPin=pro.getProperty("Pin");
	return custPin;
}
public String getMobileno()
{
	String custMobileno=pro.getProperty("MobileNumber");
	return custMobileno;
}
public String getEmail()
{
	String custEmail=pro.getProperty("E-mail");
	return custEmail;
}
public String getPassword1()
{
	String custPassword=pro.getProperty("Password");
	return custPassword;
}
public String geturl()
{
	String url1=pro.getProperty("baseurl1");
	return url1;
}
public String getemail1()
{
	String emai=pro.getProperty("Email1");
	return emai;
}
public String getPasswor1()
{
	String pass=pro.getProperty("Password1");
	return pass;
}

 public String getname2()
 {
	 String names=pro.getProperty("name");
	 return names;
 }
}


