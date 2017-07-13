package com.njbdqn.tt.componses.page;

public class RangeCondition implements ICondition{
	public String getSqlCondition(String conds) {
		return " "+conds.replace(":", " between ").replace("-", " and ");
	}
}
