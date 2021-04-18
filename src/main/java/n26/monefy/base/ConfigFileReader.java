package n26.monefy.base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader 
{
	
	public static Properties properties;
	private final String propertyFilePath= "Configuration/Config.properties";

	
	public ConfigFileReader()
	{
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getDriverPath()
	{
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}
	
	
	public String getApplicationUrl() 
	{
		String url = properties.getProperty("applicationUrl");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public String getStudentLogin() 
	{
		String studentLogin = properties.getProperty("studentLogin");
		if(studentLogin != null) return studentLogin;
		else throw new RuntimeException("studentLogin not specified in the Configuration.properties file.");
	}
	public String getStudentPassword() 
	{
		String studentPassword = properties.getProperty("studentPassword");
		if(studentPassword != null) return studentPassword;
		else throw new RuntimeException("studentPassword not specified in the Configuration.properties file.");
	}
	
	public String getTeacherLogin() 
	{
		String teacherLogin = properties.getProperty("teacherLogin");
		if(teacherLogin != null) return teacherLogin;
		else throw new RuntimeException("teacherLogin not specified in the Configuration.properties file.");
	}
	public String getTeacherPassword() 
	{
		String teacherPassword = properties.getProperty("teacherPassword");
		if(teacherPassword != null) return teacherPassword;
		else throw new RuntimeException("teacherPassword not specified in the Configuration.properties file.");
	}
	
	public String getSubjectName() 
	{
		String subjectName = properties.getProperty("subject");
		if(subjectName != null) return subjectName;
		else throw new RuntimeException("subject is not specified in the Configuration.properties file.");
	}
	
	public String getStudentSubject() 
	{
		String StudentSubject = properties.getProperty("StudentSubject");
		if(StudentSubject != null) return StudentSubject;
		else throw new RuntimeException("Student Subject is not specified in the Configuration.properties file.");
	}
	
	public String getSection() 
	{
		String sectionName = properties.getProperty("section");
		if(sectionName != null) return sectionName;
		else throw new RuntimeException("Section is not specified in the Configuration.properties file.");
	}
	
	public String getDMFromTeacher() 
	{
		String DMFromTeacher = properties.getProperty("DMFromTeacher");
		if(DMFromTeacher != null) return DMFromTeacher;
		else throw new RuntimeException("Student name for DM is not specified in the Configuration.properties file.");
	}
	
	public String getDMFromStudent() 
	{
		String DMFromStudent = properties.getProperty("DMFromStudent");
		if(DMFromStudent != null) return DMFromStudent;
		else throw new RuntimeException("Name for DM is not specified in the Configuration.properties file.");
	}
	
	public String getTeacherMessageToStudent() 
	{
		String teacherMessageToStudentValue = properties.getProperty("TeacherMessageToStudent");
		if(teacherMessageToStudentValue != null) return teacherMessageToStudentValue;
		else throw new RuntimeException("Teacher message to student is not specified in the Configuration.properties file.");
	}
	

	public String getBrowserName() 
	{
		String browserValue = properties.getProperty("browser");
		if(browserValue != null) return browserValue;
		else throw new RuntimeException("Browser Name is not specified in the Configuration.properties file.");
	}
	
}
