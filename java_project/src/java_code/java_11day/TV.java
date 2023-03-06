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
		System.out.println(name + "TV 채널이 몇 " + channel + "으로 변경되었습니다.");
	}
}
