// AnimalVo.java

package java_code.java_11day;

public class AnimalVo {
	String name;
    int eat, sleep, play;

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setDayEat(int eat) {
		this.eat = eat;
	}
	public int getDayEat() {
		return eat;
	}

	public void setDaySleep(int sleep) {
		this.sleep = sleep;
	}
	public int getDaySleep() {
		return sleep;
	}

	public void setDayPlay(int play) {
		this.play = play;
	}
	public int getDayPlay() {
		return play;
	}
}