package com.njbdqn.tt.componses.page;

import java.util.List;


public interface IPageDAO<T> {
	public List<T> findCurrentPageData(PageInParam pip);
	public int findCountPage(PageInParam pip);
}
