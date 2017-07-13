package com.njbdqn.tt.componses.page;

public class SanameCondition implements ICondition{
	public String getSqlCondition(String conds) {
		return " "+conds.replace(":", " like '")+"' ";
	}
}
