package com.njbdqn.tt.componses.page;

public class EqualCondition implements ICondition{
	public String getSqlCondition(String conds) {
		return " "+conds.replace(":", "='")+"' ";
	}
}
