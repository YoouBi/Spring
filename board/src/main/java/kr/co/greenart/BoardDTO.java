package kr.co.greenart;

import java.util.List;

public class BoardDTO {
	private List<Article> list;
	private int totalPage;
	
	public BoardDTO() {
		super();
	}
	
	public BoardDTO(List<Article> list, int totalPage) {
		super();
		this.list = list;
		this.totalPage = totalPage;
	}
	
	public List<Article> getList() {
		return list;
	}
	
	public void setList(List<Article> list) {
		this.list = list;
	}
	
	public int getTotalPage() {
		return totalPage;
	}
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
