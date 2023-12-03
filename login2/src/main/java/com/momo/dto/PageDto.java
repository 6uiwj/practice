package com.momo.dto;

public class PageDto {
	int blockStartNo;   //페이지 블럭 끝번호
	int blockEndNo;		//페이지 블럭 끝번호
	int realEndNo;		//게시물의 끝 페이지 번호 -> 총 게시물의 수 / 페이지 당 게시물의 수

	boolean prev, next; //이전, 다음 버튼(true: 보여주기)

	
	int totalCnt;
	Criteria cri;
	int blockAmount=10;
	
	public PageDto() {}
	
	
	public PageDto(int totalCnt, Criteria cri, String blockAmount) {
		this(totalCnt, cri);
		if(blockAmount != null 
				&& !"".equals(blockAmount)) {
			this.blockAmount = Integer.parseInt(blockAmount);
		}
	}
	
	public PageDto(int totalCnt, Criteria cri) {
		super();
		this.totalCnt = totalCnt;
		this.cri = cri;
		this.blockAmount = blockAmount;
		
		//페이지 블럭의 끝번호를 구합니다.
		//요청 페이지, 블럭 당 페이지 수에 따라서 블럭의 범위가 정해집니다.
		//1-10, 11-20, 21-30...
		//ex) 현재페이지 7, 블럭당 페이지수 10 ->  올림(7/10.0) = 1 -> 첫번째 블럭
		// 보여줄 블럭의 끝번호 : 위에서구한 블럭(1) * blockAmount = 10
		//페이지 블럭의 시작 번호, 끝번호

		
		blockEndNo = (int)Math.ceil(cri.getPageNo()/(blockAmount*1.0))*blockAmount;
		blockStartNo = blockEndNo - (blockAmount-1);
		//페이지 끝번호
		realEndNo = (int)Math.ceil((totalCnt*1.0)/cri.getAmount());
		
		System.out.println("PageDto - blockStartNo : " + blockStartNo);
		System.out.println("PageDto - blockEndNo : " + blockEndNo);

		//게시물이 67건인 경우
		//페이지 진짜 끝번호는 7인데 블럭의 끝번호는 10입니다
		blockEndNo = blockEndNo > realEndNo?  realEndNo : blockEndNo;
	
		prev = blockStartNo == 1 ? false: true;
		next = blockEndNo == realEndNo ? false : true;
}

	public int getBlockStartNo() {
		return blockStartNo;
	}

	public void setBlockStartNo(int blockStartNo) {
		this.blockStartNo = blockStartNo;
	}

	public int getBlockEndNo() {
		return blockEndNo;
	}

	public void setBlockEndNo(int blockEndNo) {
		this.blockEndNo = blockEndNo;
	}

	public int getRealEndNo() {
		return realEndNo;
	}

	public void setRealEndNo(int realEndNo) {
		this.realEndNo = realEndNo;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	public int getBlockAmount() {
		return blockAmount;
	}

	public void setBlockAmount(int blockAmount) {
		this.blockAmount = blockAmount;
	}
}
