package DirectoryParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
  private String name;
	private String location;
	private String department;
	private String salary;
	private String expenses;
	private String position;

	public Person(String n, String l, String d, String s, String e) {
		setName(n);
		setLocation(l);
		setDepartment(d);
		setSalary(s);
		setExpenses(e);
	}

	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}
	public String getDepartment() {
		return department;
	}
	public String getSalary() {
		return salary;
	}
	public String getExpenses() {
		return expenses;
	}
	public String getPosition() {
		return position;
	}

	public void setName(String n) {
		String regex = "\\s";
		String [] nameList = n.trim().split(regex);
		
		if (nameList.length>1) {
			name = nameList[1] + " " + nameList[0];
		}
		
		else {
			name = nameList[0];
		}
	}
	public void setLocation(String l) {
		String mydata = l;
		Pattern pattern = Pattern.compile("(<p>)(.*?)(<br />)");
		Matcher matcher = pattern.matcher(mydata);
		if (matcher.find())
		{
			    location = matcher.group(2);
		}
	}
	public void setPosition(String p) {
		String mydata = p;
		Pattern pattern = Pattern.compile("(.*?)(<br>)");
		Matcher matcher = pattern.matcher(mydata);
		if (matcher.find())
		{
			    position = matcher.group(1).trim();
		}

	}
	public void setDepartment(String d) {
		setPosition(d);
		String mydata = d;
		Pattern pattern = Pattern.compile("(href)(.*?)(>)(.*?)(<)");
		Matcher matcher = pattern.matcher(mydata);
		if (matcher.find())
		{
			    department = matcher.group(4);
		}
	}
	
	public void setSalary(String s) {
		salary = s;
	}
	public void setExpenses(String e) {
		expenses = e;
	}

}
