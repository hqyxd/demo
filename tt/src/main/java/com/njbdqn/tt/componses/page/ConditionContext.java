package com.njbdqn.tt.componses.page;

import java.io.FileInputStream;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConditionContext {
	private static Map<String,ICondition> straties;
	static{
		try {
			fillStrategy();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void fillStrategy() throws Exception{
		straties = new HashMap<String, ICondition>();
		String path = URLDecoder.decode(ConditionContext.class.getResource("/strat.properties").getPath(),"utf-8");
		Properties ps = new Properties();
		ps.load(new FileInputStream(path));
		Enumeration names = ps.propertyNames();
		while(names.hasMoreElements()){
			String key = names.nextElement().toString();
			String value = ps.getProperty(key);
			Object ob = Class.forName(value).newInstance();
			straties.put(key, (ICondition)ob);
		}
	}
	
	public String getsqlQueryCond(String conds){
		Pattern pat = Pattern.compile("%|-");
		Matcher mat = pat.matcher(conds);
		ICondition ic = mat.find()?straties.get(mat.group()):straties.get("null");
		return ic.getSqlCondition(conds);
	}
}
