package codingTest;

public class ����ȭ������ {

	public static void main(String[] args) {
		String[] wallpaper = {"..........", ".....#....", "......##..", "...##.....", "....#....."};

        int luy = 51;
        int rdy = 0;
        int lux = 51;
        int rdx = 0;
        for(int i=0; i<wallpaper.length; i++) {
            for(int j=0; j<wallpaper[i].length(); j++) {
                // ó������ #�� ������ �迭�� ���ȣ -> lux
                if(wallpaper[i].charAt(j)=='#' && i<=lux) {
                    lux=i;
                } 
                // ���� ������(y)�� ���� ���� -> luy
                if(wallpaper[i].charAt(j)=='#' && j<=luy) {
                    luy=j;
                }
                // ���������� #�� ������ �迭�� ���ȣ -> rdx
                if(wallpaper[i].charAt(j)=='#' && i>=rdx) rdx=i;
                // ���������� #�� ������ �迭�� ���ȣ -> rdy
                if(wallpaper[i].charAt(j)=='#' && j>=rdy) rdy=j;
            }
        }
         
        System.out.println(lux);
        System.out.println(luy);
        System.out.println(rdx+1);
        System.out.println(rdy+1);

	}

}
