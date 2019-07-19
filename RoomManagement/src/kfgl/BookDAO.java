package kfgl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookDAO {
	public ResultSet list(Connection con,String gna,String rid) throws Exception {
		StringBuffer sql=new StringBuffer();
		if(rid.equals("")&&gna.equals("")) {
			sql.append("select bid,a.gid,gname,rid,btime,utime from book a join guset b on b.gid = a.gid  order by bid");
		}
		else if(rid.equals("")) {
			sql.append("select bid,a.gid,gname,rid,btime,utime from book a join guset b on b.gid = a.gid where gname='"+gna+"'");
		}
		else if(gna.equals("")) {
			sql.append("select bid,a.gid,gname,rid,btime,utime from book a join guset b on b.gid = a.gid where rid="+rid);
		}
		else {
			sql.append("select bid,a.gid,gname,rid,btime,utime from book a join guset b on b.gid = a.gid where gname="+gna+" and rid="+rid);
		}
		System.out.println(sql);
		PreparedStatement ps=con.prepareStatement(sql.toString());
		
		return ps.executeQuery();
	}
//	public void addBook(String gna,int rno) {
//		Connection con=null;
//		PreparedStatement pstat=null;
//		con=JDBCUtils.getConnection();
//		try {
//			String sql="insert into book(gid,rid,btime) values((select gid from guset where gname=?),?,to_date(?,'yyyy-mm-dd hh24:mi:ss'))";
//			pstat=con.prepareStatement(sql);
//			pstat.setString(1,gna);
//			pstat.setInt(2,rno);
//			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			pstat.setString(3, df.format(new Date()).toString());
//			int result=pstat.executeUpdate();
//			System.out.println("add result="+result);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			JDBCUtils.closeResource(con, pstat, null);
//		}
//	}
//	public void updateBook(String gno,int rno) {
//		Connection con=null;
//		PreparedStatement pstat=null;
//		con=JDBCUtils.getConnection();
//		try {
//			String sql="update book set utime=to_date(?,'yyyy-mm-dd hh24:mi:ss') where rid=? and gid=(select gid from guset where gname=?) and utime is null";
//			pstat=con.prepareStatement(sql);
//			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			pstat.setString(1, df.format(new Date()).toString());
//			pstat.setInt(2, rno);
//			pstat.setString(3, gno);
//			int result=pstat.executeUpdate();
//			System.out.println("update result="+result);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			JDBCUtils.closeResource(con, pstat, null);
//		}
//	}
}
