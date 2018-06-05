package m;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MySQLQueryReceiver implements QueryReceiver{

	public Bean storeResultSet(ResultSet rs){
		Bean bean = null;
		try{
			 	
	    bean = new Bean();
		bean.table_name = rs.getMetaData().getTableName(1);
		bean.tuples = new ArrayList<Map<String,String>>();
		System.out.println(bean.table_name);
		
		while(rs.next()){ 
			Map<String,String> tuple = new HashMap<String, String>();
			for  (int i = 1; i<= rs.getMetaData().getColumnCount(); i++){ 
                System.out.print(rs.getString(i)+"\t");
                tuple.put(rs.getMetaData().getColumnName(i), rs.getString(i));
            }System.out.println();
			bean.tuples.add(tuple);
		} 
		
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		return bean;
	}
	Connection getConnectionFromPool() throws ClassNotFoundException, SQLException{
        return DBConnection.getInstance().getConnectionFromPool(); 
	}
	 
	
	@Override
	public Bean selectQuery(String query) {
		System.out.println("select query execute");
        try{ 
	        Connection con = getConnectionFromPool();
	        System.out.println("Sucess");
	        Statement stmt = null;  // statement/query execute
	        ResultSet rs = null;    // output show
	         
	        stmt =  con.createStatement();
	        stmt.execute("use trigsoft");
	        stmt =  con.createStatement();
	        rs=stmt.executeQuery(query);
	         
	             /*  System.out.println("Table: " + rs.getMetaData().getTableName(1));
	                for  (int i = 1; i<= rs.getMetaData().getColumnCount(); i++){
	                    System.out.print(rs.getMetaData().getColumnName(i)+"\t");
	                }
	                System.out.println();
			        while (rs.next()) { //till null
			        	for  (int i = 1; i<= rs.getMetaData().getColumnCount(); i++){ 
			                System.out.print(rs.getString(i)+"\t");
		                }
			        	System.out.println();
			        }*/
			        
			 
			System.out.println("printing");
			con.close(); 
	        return storeResultSet(rs);
			
        }catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
	}

	@Override
	public Bean insertQuery(String query) {
		System.out.println("insert query execute");
		try {
			Connection con = getConnectionFromPool();
	        System.out.println("Sucess");
	        Statement stmt = null;  // statement/query execute 
	         
	        stmt =  con.createStatement();
	        stmt.execute("use trigsoft");
	        stmt =  con.createStatement();
	        stmt.execute(query);

			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
		
	}

	@Override
	public Bean updateQuery(String query) {
		System.out.println("update query execute");
		try {
			Connection con = getConnectionFromPool();
	        System.out.println("Success");
	        Statement stmt = null;  // statement/query execute 
	         
	        stmt =  con.createStatement();
	        stmt.execute("use trigsoft");
	        stmt =  con.createStatement();
	        stmt.execute(query);

			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
		
	}

	@Override
	public Bean deleteQuery(String query) {
		System.out.println("delete query execute");
		try {
			Connection con = getConnectionFromPool();
	        System.out.println("Success");
	        Statement stmt = null;  // statement/query execute 
	         
	        stmt =  con.createStatement();
	        stmt.execute("use trigsoft");
	        stmt =  con.createStatement();
	        stmt.execute(query);

			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
		
	}

}
