//package com.editor.test.report;
//
//import java.nio.channels.NonWritableChannelException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.Timestamp;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.stream.Collector;
//import java.util.stream.Collectors;
//
//import com.wizdepot.common.model.Organization;
//import com.wizdepot.ontime.model.ActionLog;
//import com.wizdepot.ontime.model.ActivityTime;
//import com.wizdepot.ontime.model.ManagerInitImage;
//import com.wizdepot.ontime.model.Timesheet;
//import com.wizdepot.ontime.model.list.ListOfTimesheet;
//import com.wizdepot.ontime.util.DetailPage;
//import com.wizdepot.ontime.util.PayrollReport;
//import com.wizdepot.ontime.util.SummaryAndDetailPage;
//import com.wizdepot.ontime.util.SummaryPage;
//import com.wizdepot.ontime.util.TimesheetReceipt;
//
//public class TimeSheetDao {
//	private final String REPORT_TYPE_RECEIPT = "Orginial Timesheet Receipt";
//	 private final String REPORT_TYPE_SUMMARY = "Timesheet Report - Summary";
//	 private static final String REPORT_TYPE_DETAIL = "Timesheet Report - Details";
//	 private final String REPORT_TYPE_PAYROLL = "Payroll Report"; 
//	
//	
//	public static void main(String[] args) {
//		Connection connection = JdbcUtil.getConnection();
//		ResultSet res = null;
//		PreparedStatement preparedStatement = null;
//	
//		try {
//			String sql = "select t.*,e.timesheet_start as job_start_date from timesheet t,employee e where t.user_id = e.id and start_date between ? and ?";
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setString(1, "2021-05-8");
//			preparedStatement.setString(2, "2021-12-23");
//			ResultSet exeJcuteQuery = preparedStatement.executeQuery();
////			List<TimeSheet> resultToList = JdbcUtil.resultToList(exeJcuteQuery, TimeSheet.class);
//			List<Timesheet> listTimesheets = new ArrayList<>();
//			while (exeJcuteQuery.next()) {
//				Timesheet timesheet = JdbcUtil.getTimeSheet(exeJcuteQuery);
//				int tid = timesheet.getTid();
//				String sql_activity_time = "select at.*,a.code,a.type from activity_time at,activities a where timesheet_id = ? and at.activity_id = a.id";
//				PreparedStatement p1 = connection.prepareStatement(sql_activity_time);
//				p1.setInt(1, tid);
//				ResultSet activitySet = p1.executeQuery();
//				
//    		    ArrayList<ActivityTime> activityTimes =new ArrayList<>();
//				while (activitySet.next()) {
//					int columnCount = activitySet.getMetaData().getColumnCount();
//					ActivityTime activityTime = JdbcUtil.geActivityTime(activitySet);
//					activityTimes.add(activityTime);
//				}
//				timesheet.setActivityTime(activityTimes);
//				listTimesheets.add(timesheet);
//			}
//			ArrayList<ListOfTimesheet> listOfTimesheets= new ArrayList<>();
//			ListOfTimesheet listOfTimesheet = new ListOfTimesheet();
//			listOfTimesheet.setTimsheets(listTimesheets);
//			listOfTimesheet.setCount(listTimesheets.size());
//			listOfTimesheets.add(listOfTimesheet);
//			//group by user_id
////			Map<Integer, List<Timesheet>> collect = listTimesheets.stream().collect(Collectors.groupingBy(Timesheet::getUid));
////			//
////			Iterator<Entry<Integer, List<Timesheet>>> iterator = collect.entrySet().iterator();
////			while(iterator.hasNext()) {
////				Entry<Integer, List<Timesheet>> next = iterator.next();
////				Integer userId = next.getKey();
////				List<Timesheet> value = next.getValue();
////				ListOfTimesheet listOfTimesheet2 = new ListOfTimesheet();
////				String select_org_info = " select p.org_id,p.name,p.code from employee e,usergroup p where e.org_id = p.org_id and e.id=?";
////				PreparedStatement prepareStatement = connection.prepareStatement(select_org_info);
////				prepareStatement.setInt(1, userId);
////				ResultSet executeQuery = preparedStatement.executeQuery();
////				while (executeQuery.next()) {
////					int org_id = executeQuery.getInt("org_id");
////					String name = exesheet2);
////			}ecuteQuery.getString("name");
////					String code = executeQuery.getString("code");
////					listOfTimesheet2.setGroupId(org_id);
////					listOfTimesheet2.setGroupCode(code);
////					listOfTimesheet2.setGroupName(name);
////				}
//////				
////				listOfTimesheet2.setCount(value.size());
////			
////				listOfTimesheets.add(listOfTim
//			
///**
// * 创建新的report-detail
// */
//			
//			Organization organization = new Organization();
//			organization.setId(15);
//			organization.setName("orgName");
////			DetailPage detailPage = new DetailPage();
//			SummaryAndDetailPage detailPage = new SummaryAndDetailPage();
////			SummaryPage detailPage = new SummaryPage();
////			PayrollReport detailPage = new PayrollReport();
////			TimesheetReceipt detailPage = new TimesheetReceipt();
//			detailPage.createPDF();
//			
////			detailPage.setSummaryPage(LocalDate.of(2021, 8, 8), LocalDate.of(2022, 8, 16),REPORT_TYPE_DETAIL,organization, listOfTimesheets,0);
//			detailPage.setPage(LocalDate.of(2021, 5, 8), LocalDate.of(2021, 8, 23),REPORT_TYPE_DETAIL,organization, listOfTimesheets,0);
////			boolean re = detailPage.createSummaryPage();
////			detailPage.setDetailPage(LocalDate.of(2021, 5, 8), LocalDate.of(2021, 12, 23), REPORT_TYPE_DETAIL, organization, listOfTimesheets);
////			boolean re = detailPage.createDetailReport();
//			boolean re = detailPage.createReport();
////			detailPage.seetPayrollReport(LocalDate.of(2021, 5, 4), "ecompex123",LocalDate.of(2021, 6, 29), organization, listOfTimesheets, null);
////			=boolean re d tailPage.createPayrollReport();
////			
////			ActionLog log = new ActionLog();
////			log.setActionIp("183.208.49.114");
////			log.setFirstName("aaa");
////			log.setLastName("bbb");
////			log.setDescription("");
////			log.setActionType("Submit-ByManager");
////			log.setReason("feqfjkqf");
////			log.setActivityName("activritName");
////			ArrayList<ActionLog> arrayList = new ArrayList<ActionLog>();
////			log.setUserName("bnbnbb");
////			arrayList.add(log);
////			detailPage.setTimeSheet(listTimesheets.get(0), new ArrayList<ManagerInitImage>(), null, null,arrayList );
////			boolean re = detailPage.createOneTimeSheetReceipt();
//			detailPage.savePDF("E:\\zzltools\\pdfFile\\DetailPaget-12.pdf");
//			System.out.println(re);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}finally {
//			try {
//				JdbcUtil.closeConnection(res, preparedStatement, connection);
//				
//			} catch (Exception e2) {
//				// TODO: handle exception
//				e2.printStackTrace();
//			}
//		}
//	}
//}
