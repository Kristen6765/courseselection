package com.hs.timetable.util;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;
import org.json.JSONException;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


@Intercepts(@Signature(method="handleResultSets", type=ResultSetHandler.class, args={Statement.class}))
public class MapInterceptor implements Interceptor {

	/* (non-Javadoc) 实现拦截器主函数
	 * @see org.apache.ibatis.plugin.Interceptor#intercept(org.apache.ibatis.plugin.Invocation)
	 */
	public Object intercept(Invocation invocation) throws Throwable {
		//获取到当前的Statement
		Statement stmt = (Statement) invocation.getArgs()[0];
		//获取第一个ResultSet结果集
		ResultSet rs = stmt.getResultSet();
		//获取执行的SQL语句，强制转成大写，避免大小写产生的
		String sql = rs.getStatement().toString().toUpperCase();
		//仅查看select语句或存储过程（CALL+空格）
		if(sql.indexOf("SELECT")>=0||sql.indexOf("CALL ")>=0){
			//获取MetaData
			ResultSetMetaData md = rs.getMetaData();
			//获取列数
			int column = md.getColumnCount();
			HashSet<String> set = new HashSet<String>();  
			for(int i=1;i<=column;i++){
				set.add(md.getTableName(i));
			}
			if(set.size()==1&&!set.contains("")){
				//closeResultSet(rs);
				//不进行拦截
				return invocation.proceed();
			}
		}else if(sql.indexOf("HIVE")>=0){
			
		}else{
			//closeResultSet(rs);
			//如果没有进行拦截处理，则执行默认逻辑
			return invocation.proceed();
		}
		//上面的if没有进行返回，说明需要进行拦截
		//定义返回对象类型
		List<List<Map<String,Object>>> resultList = new ArrayList<List<Map<String,Object>>>();
		List<Map<String,Object>> result = resultSetToMapList(rs);
		closeResultSet(rs);
		resultList.add(result);
		//遍历结果集，如果有第二个结果集
		/*
		while(stmt.getMoreResults(Statement.KEEP_CURRENT_RESULT)){
			stmt.getMoreResults();
			ResultSet _rs = stmt.getResultSet();
			List<Map<String,Object>> _result = resultSetToMapList(_rs);
			closeResultSet(_rs);
			resultList.add(_result);
		}
		*/
		return resultList;
	}

	
	/**
	 * 关闭ResultSet
	 * @param resultSet 需要关闭的ResultSet
	 */
	private void closeResultSet(ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			
		}
	}

	/* (non-Javadoc)
	 * @see org.apache.ibatis.plugin.Interceptor#plugin(java.lang.Object)
	 */
	public Object plugin(Object obj) {
		return Plugin.wrap(obj, this);
	}

	/* (non-Javadoc)
	 * @see org.apache.ibatis.plugin.Interceptor#setProperties(java.util.Properties)
	 */
	public void setProperties(Properties props) {
		
	}
	
	/**
	 * @param rs 
	 * @return list
	 * @throws SQLException
	 * @throws JSONException
	 * @description 将结果集进行转化
	 */
	private List<Map<String,Object>> resultSetToMapList(ResultSet rs) throws SQLException,JSONException  
	{  
		List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
	   // 获取列数  
	   ResultSetMetaData metaData = rs.getMetaData();  
	   int columnCount = metaData.getColumnCount();  
	    
	   // 遍历ResultSet中的每条数据  
	    while (rs.next()) {  
	    	Map<String,Object> map = new HashMap<String,Object>();
	        // 遍历每一列  
	        for (int i = 1; i <= columnCount; i++) {  
	            String columnName =metaData.getColumnLabel(i);  
	            String value = rs.getString(columnName);  
	            map.put(columnName, value);  
	        }   
	        mapList.add(map);   
	    }  
	    
	   return mapList;  
	}

}
