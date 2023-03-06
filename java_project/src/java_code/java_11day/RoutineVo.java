// RoutineVo.java

package java_code.java_11day;

public class RoutineVo {
    String name;
    int eat, sleep, play;

    // lion - 4/4/4
    // tiger - 5/5/5
    // bird - 6/6/6
    public void setRoutineName(String name) {
        this.name = name;
    }
    public String getRoutineName() {
        return name;
    }

    public void setRoutineEat(int eat) {
         this.eat = eat;
    }

    public int getRoutineEat() {
        return eat;
    }

    public void  setRoutineSleep(int sleep) {
        this.sleep = sleep;
    }
    public int  getRoutineSleep() {
        return sleep;
    }

    public void setRoutinePlay(int play) {
        this.play = play;
    }
    public int getRoutinePlay() {
        return play;
    }
}