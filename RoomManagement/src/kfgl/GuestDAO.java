package kfgl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GuestDAO{
/**
*1 对Guest表的插入操作
*/	
public void addGuest(Guest u) {
	Connection con=null;
	PreparedStatement pstat=null;
	con=JDBCUtils.getConnection();
	try {
		String sql="insert into guset(gname,gphone) values(?,?)";
		pstat=con.prepareStatement(sql);
		pstat.setString(1,u.getGname());
		pstat.setString(2,u.getGphone());
		int result=pstat.executeUpdate();
		System.out.println("add result="+result);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		JDBCUtils.closeResource(con, pstat, null);
	}
}
/**
*2 对Guest表的R操作(查询一条记录)
*/	
public Guest findGuest(String gname) {
	Connection con=null;
	PreparedStatement pstat=null;
	ResultSet rs=null;
	Guest g=null;
	con=JDBCUtils.getConnection();
	try {
		String sql="select * from guset where gname=?";
		pstat=con.prepareStatement(sql);
		pstat.setString(1,gname);
		rs=pstat.executeQuery();
		if(rs.next()) {
			g=new Guest();
			g.setGname(rs.getString("gname"));
			g.setGid(rs.getString("gid"));
			g.setGphone(rs.getString("gphone"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		JDBCUtils.closeResource(con, pstat, rs);
	}
	return g;
}
/**
*3 对Guest表的更新
*/
public void updateGuest(Guest u) {
	Connection con=null;
	PreparedStatement pstat=null;
	con=JDBCUtils.getConnection();
	try {
		String sql="update guset set gphone=? where gname=?";
		pstat=con.prepareStatement(sql);
		pstat.setString(1, u.getGphone());
		pstat.setString(2, u.getGname());
		int result=pstat.executeUpdate();
		System.out.println("update result="+result);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		JDBCUtils.closeResource(con, pstat, null);
	}
}
public List<Guest>findAllGuest(){
	Connection con=null;
	PreparedStatement pstat=null;
	ResultSet rs=null;
	List<Guest> list=null;
	Guest u=null;
	con=JDBCUtils.getConnection();
	try {
		String sql="select * from Guset order by gid";
		pstat=con.prepareStatement(sql);
		rs=pstat.executeQuery();
		list=new ArrayList();
		while(rs.next()) {
			u=new Guest();
			u.setGname(rs.getString("gname"));
			u.setGid(rs.getString("gid"));
			u.setGphone(rs.getString("gphone"));
			list.add(u);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		JDBCUtils.closeResource(con, pstat, rs);
	}
	return list;
}
public void DeleteGuest(String username) {
	Connection con=null;
	PreparedStatement pstat=null;
	con=JDBCUtils.getConnection();
	try {
		String sql="delete from guset where gname=?";
		pstat=con.prepareStatement(sql);
		pstat.setString(1,username);
		int result=pstat.executeUpdate();
		System.out.println("del result="+result);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		JDBCUtils.closeResource(con, pstat, null);
	}	
}
}