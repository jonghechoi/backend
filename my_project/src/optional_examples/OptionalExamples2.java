package optional_examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalExamples2 {
	/**
	 * 1. "id:�̸�" ������ �����͸� ItemService inin �޼ҵ忡�� ���� 
	 * 	    �� �Ű������� map�� stackById �޼ҵ带 �̿��� ����
	 * 2. findById���� id�� ���� �˻�
	 * 3. findItemById_orElseThrow/findItemById_orElseGet �޼ҵ带 ���� null ó�� ���� Ȯ��
	 */
	public static void main(String[] args) {
		ItemRepository itemRepository = new ItemRepository();
	
		itemRepository.itemInit();
		
		System.out.println(itemRepository.findItemById_orElseThrow(1));
		System.out.println(itemRepository.findItemById_orElseThrow(2));
//		System.out.println(itemRepository.findItemById_orElseThrow(3));
		System.out.println(itemRepository.findItemById_orElseGet(3));
		
		
	}
}

class ItemRepository {
	ArrayList<Item> list = new ArrayList<Item>();
	
	public void itemInit() {
		int[] intTemp = {1, 2, 3};
		String[] strTemp = {"A", "B", null};
		
		for(int i=0; i<intTemp.length; i++) {
			Item item = new Item();
			item.stackById(intTemp[i], Optional.ofNullable(strTemp[i]));
			list.add(item);
		}
	}
	
	public Item findById(int id) {
		for(Item item : list) {
			if(item.id == id) return item; 
		}
		return null;
	}
	
	public String findItemById_orElseThrow(int id) {
		return findById(id).getString()
				.orElseThrow(() -> new NoSuchElementException());
	}
	
	public String findItemById_orElseGet(int id) {
		return findById(id).getString()
				.orElseGet(() -> "null�� �ԷµǾ����ϴ�");
	}
}

class Item {
	Map<Integer, Optional<String>> map = new HashMap<Integer, Optional<String>>();
	int id;
	
	public void stackById(int id, Optional<String> name) {
		this.id = id;
		map.put(id, name);
	}
	
	public Optional<String> getString() {
		return map.get(id);
	}
}
