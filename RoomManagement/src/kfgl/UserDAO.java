package kfgl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Users���CRUD����
 */

public class UserDAO {
/**
 *1 ��User���C����
 */
public void addUser(Users u) {
	Connection con=null;
	PreparedStatement pstat=null;
	con=JDBCUtils.getConnection();
	try {
		String sql="insert into users(username,pwd) values(?,?)";
		pstat=con.prepareStatement(sql);
		pstat.setString(1,u.getUsername());
		pstat.setString(2,u.getPwd());
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
 *2 ��Users���U����
 */
public void updateUser(Users u) {
	Connection con=null;
	PreparedStatement pstat=null;
	con=JDBCUtils.getConnection();
	try {
		String sql="update users set pwd=? where username=?";
		pstat=con.prepareStatement(sql);
		pstat.setString(1, u.getPwd());
		pstat.setString(2, u.getUsername());
		int result=pstat.executeUpdate();
		System.out.println("update result="+result);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		JDBCUtils.closeResource(con, pstat, null);
	}
}
/**
 *3 ��Users���D����
 */
public void delUser(String username) {
	Connection con=null;
	PreparedStatement pstat=null;
	con=JDBCUtils.getConnection();
	try {
		String sql="delete from users where username=?";
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
/**
 *4 ��Users���R����(��ѯһ����¼)
 */
public Users findUser(String username,String pwd) {
	Connection con=null;
	PreparedStatement pstat=null;
	ResultSet rs=null;
	Users u=null;
	con=JDBCUtils.getConnection();
	try {
		String sql="select * from users where username=? and pwd=?";
		pstat=con.prepareStatement(sql);
		pstat.setString(1,username);
		pstat.setString(2,pwd);
		rs=pstat.executeQuery();
		if(rs.next()) {
			u=new Users();
			u.setUsername(rs.getString("username"));
			u.setPwd(rs.getString("pwd"));
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		JDBCUtils.closeResource(con, pstat, rs);
	}
	return u;
}
/**
 *5 ��Users���R����(��ѯ���м�¼)
 */
public List<Users>findAllUsers(){
	Connection con=null;
	PreparedStatement pstat=null;
	ResultSet rs=null;
	List<Users> list=null;
	Users u=null;
	con=JDBCUtils.getConnection();
	try {
		String sql="select * from users";
		pstat=con.prepareStatement(sql);
		rs=pstat.executeQuery();
		list=new ArrayList();
		while(rs.next()) {
			u=new Users();
			u.setUsername(rs.getString("username"));
			u.setPwd(rs.getString("pwd"));
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

}

