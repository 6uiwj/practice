package com.momo.dto;

public class Criteria {
	/**
	 * 리스트를 조회하기 위한 파라미터 세팅
	 */
	private int pageNo=1;
	private int amount = 10;
	private int endNo;
	private int startNo;
	
	
	public Criteria() {}
	/**
	 * 생성자를 통해 페이지번호와 페이지당 게시물의 수를 받아와서
	 * 시작번호와 끝번호를 구합니다.
	 * @param pageNo
	 * @param amount
	 */	
	public Criteria(String pageNo, String amount) {
		
	if(pageNo!=null && !"".equals(pageNo)) {
		this.pageNo=Integer.parseInt(pageNo);
	}
	if(amount!=null && !"".equals(amount)) {
		this.amount=Integer.parseInt(amount);
	}
	System.out.println("Criteria - pageNo : " + pageNo);
	System.out.println("Criteria - amount : " + amount);
	
	endNo = this.pageNo*this.amount;
	startNo = endNo - (this.amount - 1);
	
	System.out.println("Criteria - endNo : " + endNo);
	System.out.println("Criteria - startNo : " + startNo);
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getEndNo() {
		return endNo;
	}

	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}

	public int getStartNo() {
		return startNo;
	}

	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}
}