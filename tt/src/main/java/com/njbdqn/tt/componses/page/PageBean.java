package com.njbdqn.tt.componses.page;

import java.util.ArrayList;
import java.util.List;

public class PageBean<T> {
	private IPageDAO<T> pageDAO;

	public PageBean(IPageDAO<T> pageDAO) {
		this.pageDAO = pageDAO;
	}
	private PageInParam pip = new PageInParam();
	private int countPage = 0;
	private int prev = 0;
	private int next = 0;
	private List<T> data = new ArrayList<T>();
	
	public PageBean<T> findBean(){
		countPage = pageDAO.findCountPage(pip);
		prev = pip.getCurrentPage()-1<=1?1:pip.getCurrentPage()-1;
		next = pip.getCurrentPage()+1>=countPage?countPage:pip.getCurrentPage()+1;
		data = pageDAO.findCurrentPageData(pip);
		return this;
	}

	public IPageDAO<T> getPageDAO() {
		return pageDAO;
	}

	public void setPageDAO(IPageDAO<T> pageDAO) {
		this.pageDAO = pageDAO;
	}

	public PageInParam getPip() {
		return pip;
	}

	public void setPip(PageInParam pip) {
		this.pip = pip;
	}

	public int getCountPage() {
		return countPage;
	}

	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}

	public int getPrev() {
		return prev;
	}

	public void setPrev(int prev) {
		this.prev = prev;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
	
}
