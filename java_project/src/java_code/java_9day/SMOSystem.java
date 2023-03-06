
package java_code.java_9day;
import java.util.Scanner;

/*
 * �������� �ý���
 */
public class SMOSystem {
	// Field
	Scanner scan = new Scanner(System.in);
	StudentVo[] slist = new StudentVo[5];
	int rcount = 0;
	
	// class�� ���� ��ü ����
	StudentVo hong; // ���� heap�� ���� ����(��ü)�� �������� ���� ��. ���� �Ѱ�. ���⿡ ������ ���� �Ϸ��� ��ü ������ ������
	
	// Constructor
	
	// Method
	public int findIndex(String name) {
		int result_idx = -1;
		
		for(int i=0; i<rcount; i++) {
			if(name.equals(slist[i].getName())) {
				result_idx = i;
			}
		}
		return result_idx;
	}
	
	// ���
	public void insert() {
		if(rcount<slist.length) {
			for(int i=rcount; i<slist.length; i++) {
				StudentVo svo = new StudentVo();
				
				System.out.print("�л��� > ");
				svo.setName(scan.next());
				
				System.out.print("���� > ");
				svo.setKor(scan.nextInt());
				
				System.out.print("���� > ");
				svo.setEng(scan.nextInt());
		
				System.out.print("���� > ");
				svo.setMath(scan.nextInt());
			
				slist[i] = svo;
				rcount++;
				System.out.print("��� ����Ͻðڽ��ϱ�?(n:���� �ƹ�Ű:���)");
				String rcon = scan.next();
				if(rcon.equals("n")) {
					i = slist.length;
					System.out.println("\n======= ��� �Ϸ� =======\n");
				}else {
					if(rcount==slist.length) {
						System.out.println("\n== ������� �������� �߰������ �Ұ����մϴ�. ==\n");
					}
				}
			}
		}else {
			System.out.println("\n== ������� �������� �߰������ �Ұ����մϴ�. ==\n");
		}
	}
	public void select() {
		if(rcount!=0) {
			System.out.println("=======================");
			System.out.print("�л���\t����\t����\t����\t����\t���\n");
			for(int i=0; i<rcount; i++) {
				System.out.printf("%s\t%d\t%d\t%d\t%d\t%f%n",slist[i].getName(),slist[i].getKor(),slist[i].getEng(),slist[i].getMath(),slist[i].getTot(),slist[i].getAvg());
			}
			System.out.println("=======================");
		}else {
			System.out.println("\n== ��ϵ� �����Ͱ� �����ϴ�. ==\n");
		}
	}
	public void search() {
		if(rcount!=0) {
			showMenu("���� ����б�");
			System.out.println("�˻��� �л��� �̸��� �Է��ϼ���.");
			int search_idx = findIndex(scan.next());
			
			if(search_idx!=-1) {
				System.out.println("=======================");
				System.out.print("�л���\t����\t����\t����\t����\t���\n");
				System.out.printf("%s \t%d\t%d\t%d\t%d\t%f%n",slist[search_idx].getName(),slist[search_idx].getKor(),slist[search_idx].getEng(),slist[search_idx].getMath(),slist[search_idx].getTot(),slist[search_idx].getAvg());
				System.out.println("=======================");
			}else {
				System.out.println("\n== �˻��� �����Ͱ� �������� �ʽ��ϴ�. ==\n");
			}
			
		}else {
			System.out.println("\n== ��ϵ� �����Ͱ� �����ϴ�. ==\n");
		}
	
	}
	public void update() {
		/*
		 * 1. ������ �л���
		 * 2. �л��� üũ
		 * 3. update_idx
		 * 4. ���ο� ��ü ���� ġȯ
		 */		
		if(rcount!=0) {
			System.out.println("������ �л��� �̸��� �Է����ּ���.");
			String name = scan.next();
			int update_idx = findIndex(scan.next());

			//���ο� ��ü ���� ġȯ
			if(update_idx!=-1) {
				StudentVo svo = new StudentVo();
				svo.setName(name);				
				System.out.print("���� > ");
				svo.setKor(scan.nextInt());
				System.out.print("���� > ");
				svo.setEng(scan.nextInt());
				System.out.print("���� > ");
				svo.setMath(scan.nextInt());
				
				slist[update_idx] = svo;
				System.out.println("\n== ���� �Ϸ� ==\n");
			}else {
				System.out.println("\n== ��ϵ� �����Ͱ� �����ϴ�. ==\n");
			}
			
		}else {
			System.out.println("\n== ��ϵ� �����Ͱ� �����ϴ�. ==\n");
		}
	}
	public void delete() {
		/*
		 * 1. ������ �л���
		 * 2. �л��� üũ
		 * 3. remove_idx
		 */

		if(rcount!=0) {
			System.out.println("������ �л����� �Է����ּ���.");
			int remove_idx = findIndex(scan.next());
			
			for(int i=remove_idx; i<slist.length-1; i++) {
				slist[i] = slist[i+1];
			}
			slist[slist.length-1] = null;
			rcount--;
			
		}else {
		System.out.println("\n== ��ϵ� �����Ͱ� �����ϴ�. ==\n");
		}
		
	}
	
	// �޴��� �����Ѵ�.
	public boolean choiceMenu() {
		System.out.print("�޴� �Է�(����) >> ");
		int menu = scan.nextInt();
		
		boolean result = true;
		switch(menu) {
		case 1:
			insert(); // this ��������
			showMenu();
			break;
		case 2:
			select();
			showMenu();
			break;
		case 3:
			search();
			showMenu();
			break;
		case 4:
			update();
			showMenu();
			break;
		case 5:
			delete();
			showMenu();
			break;
		case 0:
			System.out.println("����");
			result = false;
			break;
		default:
			System.out.println("�޴� �غ����Դϴ�.");
		}
		return result;
	}
	
	// �޴��� ����Ѵ�.
	public void showMenu() {
		System.out.println("==============================");
		System.out.println("  1. ���� ���");
		System.out.println("  2. ���� ��ȸ(��ü)");
		System.out.println("  3. ���� �˻�");
		System.out.println("  4. ���� ����");
		System.out.println("  5. ���� ����");
		System.out.println("  0. ���α׷� ����");
		System.out.println("==============================");
	}
	
	public void showMenu(String schoolName) {
		System.out.println("==============================");
		System.out.println(schoolName + " ���� ���� �ý���");
		System.out.println("==============================");
		System.out.println("  1. ���� ���");
		System.out.println("  2. ���� ��ȸ(��ü)");
		System.out.println("  3. ���� �˻�");
		System.out.println("  4. ���� ����");
		System.out.println("  5. ���� ����");
		System.out.println("  0. ���α׷� ����");
		System.out.println("==============================");
	}
	
	
}//class
