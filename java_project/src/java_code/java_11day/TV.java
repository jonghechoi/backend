package java_code.java_11day;

public class TV {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void changeChannel(int channel) {
		System.out.println(name + "TV ä���� �� " + channel + "���� ����Ǿ����ϴ�.");
	}
}
