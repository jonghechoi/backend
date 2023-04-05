package codingTest;

public class 바탕화면정리 {

	public static void main(String[] args) {
		String[] wallpaper = {"..........", ".....#....", "......##..", "...##.....", "....#....."};

        int luy = 51;
        int rdy = 0;
        int lux = 51;
        int rdx = 0;
        for(int i=0; i<wallpaper.length; i++) {
            for(int j=0; j<wallpaper[i].length(); j++) {
                // 처음으로 #이 나오는 배열의 행번호 -> lux
                if(wallpaper[i].charAt(j)=='#' && i<=lux) {
                    lux=i;
                } 
                // 가장 적은수(y)를 변수 삽입 -> luy
                if(wallpaper[i].charAt(j)=='#' && j<=luy) {
                    luy=j;
                }
                // 마지막으로 #이 나오는 배열의 행번호 -> rdx
                if(wallpaper[i].charAt(j)=='#' && i>=rdx) rdx=i;
                // 마지막으로 #이 나오는 배열의 행번호 -> rdy
                if(wallpaper[i].charAt(j)=='#' && j>=rdy) rdy=j;
            }
        }
         
        System.out.println(lux);
        System.out.println(luy);
        System.out.println(rdx+1);
        System.out.println(rdy+1);

	}

}
