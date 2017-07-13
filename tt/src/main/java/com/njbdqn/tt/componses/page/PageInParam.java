package com.njbdqn.tt.componses.page;

public class PageInParam {
	private int currentPage = 1;
	private int pageSize = 10;
	private String conds = "";
	private String sqlConds;
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getConds() {
		return conds;
	}
	public void setConds(String conds) {
		this.conds = conds;
		this.sqlConds = "";
		String [] cds = conds.split(";");
		ConditionContext csc = new ConditionContext();
		for (String s : cds) {
			this.sqlConds+=" and "+csc.getsqlQueryCond(s);
		}
		this.sqlConds = this.sqlConds.replaceFirst("and", "");
	}
	public String getSqlConds() {
		return sqlConds;
	}
	public void setSqlConds(String sqlConds) {
		this.sqlConds = sqlConds;
	}
	
	
	public static void main(String[] args) {
		PageInParam pip = new PageInParam();
		pip.setConds("k:1;k:%1;k:10-20;");
		System.out.println(pip.getSqlConds());
	}
}
