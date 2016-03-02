package lazecrew.kitchu.paging;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;

import lazecrew.kitchu.paging.vo.Category;

public class PagingTest {

	private static final String DB_ADDR = "apdoer.ciszfmxklhbp.ap-northeast-2.rds.amazonaws.com";
	private static final int DB_PORT = 3306;
	private static final String DB_USER = "apdoer";
	private static final String DB_PASSWORD = "apdoer1234";
	
	static List<Category> listFromDB;
	static List<Category> listActual;
	static int[] linkArr;
	
	// paging params
	static final int MAX_PAGE_COUNT = 10;
	static final int MAX_LINK_COUNT = 10;
	static int pageIndex = 2;
	static int startIndex;
	static int endIndex;
	
	public static void main(String[] args) throws Exception {
		
		getCategoryList();
		getActualList();
		
		for (Category category : listActual) {
			System.out.println(category);
		}
		
	}
	
	private static void getActualList() {
		listActual = new ArrayList<Category>();
		
		startIndex = (pageIndex - 1) * 10;
		endIndex = startIndex + MAX_PAGE_COUNT;
		
		listActual.addAll(listFromDB.subList(startIndex, endIndex));
	}
	
	private static List<Category> getCategoryListFromDB() throws ClassNotFoundException, SQLException {
		// connection retrieving
		Class.forName("com.mysql.jdbc.Driver");
		
		Properties prop = new Properties();
		prop.put("proxy_host", "70.10.15.10");
		prop.put("proxy_host", "8080");
		
		Connection conn = DriverManager.getConnection(
				String.format("jdbc:mysql://%s:%d?user=%s&password=%s",
				DB_ADDR, DB_PORT, DB_USER, DB_PASSWORD), prop);
		
		// data retrieving
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT * "); 
		sb.append(" FROM category "); 
		
		pstmt = conn.prepareStatement(sb.toString());
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			System.out.println(rs.getInt(0));
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(1));
		}
		
		return null;
	}
	
	private static void getCategoryList() {
		listFromDB = new ArrayList<Category>();
		
		final String[] gubun = {"F", "C"};
		for (int i = 0; i < 128; i++) {
			listFromDB.add(new Category(i, gubun[(int)(Math.random() * 2)], "name #" + i));
		}
		
		Collections.sort(listFromDB, new Comparator<Category>() {

			@Override
			public int compare(Category o1, Category o2) {
				return o2.getId() - o1.getId();
			}
		});
	}
	
}
