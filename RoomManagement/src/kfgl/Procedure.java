package kfgl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class Procedure {
	public void ProRes(String gna,int rno) {
		Connection con=null;
		CallableStatement cs=null;
		con=JDBCUtils.getConnection();
		try {
			cs=con.prepareCall("{call pro_reserve(?,?)}");
			cs.setString(1, gna);
			cs.setInt(2, rno);
	
			int result=cs.executeUpdate();
			System.out.println("result="+result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.closeResource(con, cs, null);
		}
	}
	public void ProChe(String gna,int rno) {
		Connection con=null;
		CallableStatement cs=null;
		con=JDBCUtils.getConnection();
		try {
			cs=con.prepareCall("{call pro_checkout(?,?)}");
			cs.setString(1, gna);
			cs.setInt(2, rno);
			int result=cs.executeUpdate();
			System.out.println("result="+result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.closeResource(con, cs, null);
		}
	}
	public void ProCha(String gna,int rno1,int rno2) {
		Connection con=null;
		CallableStatement cs=null;
		con=JDBCUtils.getConnection();
		try {
			cs=con.prepareCall("{call pro_change(?,?,?)}");
			cs.setString(1, gna);
			cs.setInt(2, rno1);
			cs.setInt(3, rno2);
			int result=cs.executeUpdate();
			System.out.println("result="+result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.closeResource(con, cs, null);
		}
	}

}
