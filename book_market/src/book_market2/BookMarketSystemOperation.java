package book_market2;

public interface BookMarketSystemOperation {
	
	public void menuUserInfo();			// 고객 정보 확인
	public void menuCartList();			// 장바구니 상품 목록 출력
	public void menuCartClear();		// 장바구니 비우기
	public void menuCartAdd();			// 장바구니 항목 추가
	public void menuCartRemoveItem();	// 장바구니 항목 삭제
	public void menuCartRemove();		// 장바구니 삭제
	public void menuCartBill();			// 영수증 표시
	public void menuExit();				// 메뉴 종료
}
