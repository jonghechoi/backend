package java_code.java_14day;

public class UserVo {
	String name, address;
	int age;
	
	public UserVo() {
		this("ȫ�浿","�����",20);
	}
	
	public UserVo(String name, String address, int age) {
		this.name = name;
		this.address = address;
		this.age = age;
	}
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
