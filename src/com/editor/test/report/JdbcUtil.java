//package com.editor.test.report;
//
//import java.io.PrintWriter;
//import java.io.StringWriter;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.nio.Buffer;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class JdbcUtil {
//	
//	public static final String URL = "jdbc:mysql://localhost:3306/wizdepot";
//	public static final String USER = "root";
//	public static final String PASSWORD = "123456";
//	private static Connection conn;
//
//	public static Connection getConnection() {
//		try {
//			// Loading drivers under jdk8.0 
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			try {
//				// Get a database connection
//				conn = DriverManager.getConnection(URL, USER, PASSWORD);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return conn;
//	}
//
//	public static void closeConnection(ResultSet rs, PreparedStatement ps,
//
//			Connection con) throws SQLException {
//		if (rs != null && rs.isClosed()) {
//			rs.close();
//		}
//		if (ps != null && ps.isClosed()) {
//			ps.close();
//		}
//		if (con != null && con.isClosed()) {
//			con.close();
//		}
//	}
//
//	public static <T> List<T> resultToList(ResultSet resultSet,Class<T> clazz ){
//		List<T> list = new ArrayList<>();
//		try {
//			// get instance of object by reflect 
////			T t =  clazz.getConstructor().newInstance();
//			//get all  methods of class include father class
//			Method[] declaredMethods = clazz.getMethods();
//			//get metadata of database 
//			ResultSetMetaData metaData = resultSet.getMetaData();
//			
//			while(resultSet.next()) {
//				// get instance of object by reflect 
//				T t =  clazz.getConstructor().newInstance();
//				//foreach method of class
//			   for(Method method: declaredMethods) {
//				   //get name of method 
//				   String name = method.getName();
//				   if (!name.startsWith("set")) {
//					continue;
//				}
//				   String dbName = getDbName(name);
//				   //foreach all columns of database
//				   
//				   for(int i = 1; i <= metaData.getColumnCount();i++) {
//					   if (metaData.getColumnName(i).equals(dbName)) {
//						
//						   if (resultSet.getObject(i)!= null) {
//							   
//							   setValue(t, method, resultSet, i);
//						   }
//							
//						   break;
//						}
//						  
//					}
//				   }
//				   list.add(t);
//			   }
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//	    return list;
//		
//	}
//	
//	private static String getDbName(String name) {
//		name = name.substring(3,4).toLowerCase()+name.substring(4);
//		//get name of column of database 
//		StringBuffer stringBuffer = new StringBuffer();
//		char[] charArray = name.toCharArray();
//		for(char nameChar : charArray) {
//			
//			if(nameChar >= 'A'&&nameChar <= 'Z') {
//			stringBuffer.append("_").append(String.valueOf(nameChar).toLowerCase());
//			} else {
//				stringBuffer.append(String.valueOf(nameChar));
//			}
//		}
//		return stringBuffer.toString();
//	}
//	
//	private static <T> void setValue(T object, Method method, ResultSet result,int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, SQLException {
//		String name = method.getParameterTypes()[0].getName().toLowerCase();
//		if (name.contains("string")) {
//			method.invoke(object, result.getString(i));
//		}
//		else if (name.contains("short")) {
//			method.invoke(object, result.getShort(i));
//		}
//		else if (name.contains("int")||name.contains("Integer")) {
//			method.invoke(object, result.getInt(i));
//		}
//		else if (name.contains("long")) {
//			method.invoke(object, result.getLong(i));
//		}
//		else if (name.contains("float")) {
//			method.invoke(object, result.getFloat(i));
//		}
//		else if (name.contains("boolean")) {
//			method.invoke(object, result.getBoolean(i));
//		}
//		else if (name.contains("double")) {
//			method.invoke(object, result.getDouble(i));
//		}
//		else if (name.contains("date")) {
//			method.invoke(object, result.getObject(i,LocalDate.class));
//		}
//		else {
//			method.invoke(object,result.getObject(i));
//		}
//		
//	}
//
//	public  static Timesheet getTimeSheet(ResultSet r) {
//		try {
//			Timesheet ts = new Timesheet();
//			ts.setJobStartingDate(r.getObject("job_start_date",LocalDate.class));
//			ts.setTid(r.getInt("id"));
//			ts.setUid(r.getInt("user_id"));
//			ts.setUserFirstname(r.getString("user_firstname"));
//			ts.setUserLastname(r.getString("user_lastname"));
//			ts.setStartDate(r.getObject("start_date", LocalDate.class));
//			ts.setStatus(r.getInt("status"));
//			ts.setSubmitDate(r.getObject("submit_date", LocalDate.class));
//			ts.setApprovalDate(r.getObject("approval_date", LocalDate.class));
//			ts.setRegularHours(r.getDouble("regular_hours"));
//			ts.setOvertimeHours(r.getDouble("overtime_hours"));	
//			ts.setApprovedBy(r.getInt("approved_by"));
//			ts.setSubmitBy(r.getInt("submit_by"));
//			ts.setSignImg(r.getInt("sign_img"));
//			ts.setApprovalImg(r.getInt("approval_img"));
//			return ts;
//		} catch (Exception e) {
//			//StringWriter errors = new StringWriter();
//			//e.printStackTrace(new PrintWriter(errors));
//			//logger.error(errors.toString());
//			e.printStackTrace();
//			return null;
//		}
//	}
//	
//	public static ActivityTime geActivityTime(ResultSet r) {
//		
//		try {
//			ActivityTime ct = new ActivityTime();
//			ct.setId(r.getInt("id"));
//			ct.setTimesheetID(r.getInt("timesheet_id"));
//			ct.setActivityID(r.getInt("activity_id"));
//			ct.setActivityName(r.getString("activity_name"));
//			ct.setActivityCode(r.getString("code"));
//			ct.setActivityType(r.getInt("type"));
//			ct.setTimingMethod(r.getInt("timing_method"));
//			ct.setSunHour(r.getFloat("sun_hours"));
//			ct.setMonHour(r.getFloat("mon_hours"));
//			ct.setTueHour(r.getFloat("tue_hours"));
//			ct.setWedHour(r.getFloat("wed_hours"));
//			ct.setThuHour(r.getFloat("thu_hours"));
//			ct.setFriHour(r.getFloat("fri_hours"));
//			ct.setSatHour(r.getFloat("sat_hours"));
////			ct.setExtraHourDay(r.getInt("extrahour_day"));
//			ct.setApprovedBy(r.getInt("approved_by"));
//			ct.setApproveImg(r.getInt("approval_img"));
//			float actTotal = (float) (r.getDouble("sun_hours")+r.getDouble("mon_hours")+
//					r.getDouble("tue_hours")+r.getDouble("wed_hours")+r.getDouble("thu_hours")+
//					r.getDouble("fri_hours")+r.getDouble("sat_hours"));
//			ct.setActivityTotal(actTotal);
//			return ct;
//		} catch (Exception e) {
//			StringWriter errors = new StringWriter();
//			e.printStackTrace(new PrintWriter(errors));
//			//logger.error(errors.toString());
//			return null;
//		}
//		
//	}
//}
//
