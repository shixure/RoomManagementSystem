package kfgl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

public class RoomDAO {
	public ResultSet list(Connection con,String s) throws Exception {
		StringBuffer sql=new StringBuffer();
		if(s.equals("È«²¿")) {
		sql.append("select rid,tname,price,pname,sname from room a join rtype b on b.tid = a.tid join principal c on c.pid=a.pid join rstatus d on d.sid=a.sid order by rid");
		}
		else if(s.equals("¿Õ·¿")) {
			sql.append("select rid,tname,price,pname,sname from room a join rtype b on b.tid = a.tid join principal c on c.pid=a.pid join rstatus d on d.sid=a.sid where a.sid=0 order by rid");
		}
		else
			sql.append("select rid,tname,price,pname,sname from room a join rtype b on b.tid = a.tid join principal c on c.pid=a.pid join rstatus d on d.sid=a.sid where a.sid=1 order by rid");
		//		if(!StringUtil.isEmpty(extra.getEid())) {
//			sql.append(" where eid="+extra.getEid());
//		}
//		//System.out.println(sql);
//		if(!StringUtil.isEmpty(extra.getEname())&&StringUtil.isEmpty(extra.getEid())) {
//			sql.append(" where ename like '%"+extra.getEname()+"%'");
//		}
//		if(!StringUtil.isEmpty(extra.getEname())&&!StringUtil.isEmpty(extra.getEid())){
//			sql.append(" and ename like '%"+extra.getEname()+"%'");
//		}
		//sql.append(" order by rid");
		PreparedStatement ps=con.prepareStatement(sql.toString());
		//System.out.println(sql);
		return ps.executeQuery();
	}
	public ResultSet list1(Connection con,String gna,String rid) throws Exception {
		StringBuffer sql=new StringBuffer();
		if(rid.equals("")&&gna.equals("")) {
			sql.append("select a.rid,gname,gphone,bednum,price,pname from room a join book b on b.rid = a.rid join guset c on c.gid = b.gid join rtype d on d.tid=a.tid join principal e on e.pid=a.pid where sid=1");
		}
		else if(rid.equals("")) {
			sql.append("select a.rid,gname,gphone,bednum,price,pname from room a join book b on b.rid = a.rid join guset c on c.gid = b.gid join rtype d on d.tid=a.tid join principal e on e.pid=a.pid where sid=1 and gname='"+gna+"'");
		}
		else if(gna.equals("")) {
			sql.append("select a.rid,gname,gphone,bednum,price,pname from room a join book b on b.rid = a.rid join guset c on c.gid = b.gid join rtype d on d.tid=a.tid join principal e on e.pid=a.pid where sid=1 and a.rid="+rid);
		}
		else {
			sql.append("select a.rid,gname,gphone,bednum,price,pname from room a join book b on b.rid = a.rid join guset c on c.gid = b.gid join rtype d on d.tid=a.tid join principal e on e.pid=a.pid where sid=1 and gname="+gna+" and a.rid="+rid);
		}
		System.out.println(sql);
		PreparedStatement ps=con.prepareStatement(sql.toString());
		return ps.executeQuery();
	}
	public boolean judge(int rid) throws Exception {
		Connection con=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		con=JDBCUtils.getConnection();
			String sql="select * from room where rid=? and sid=0";
			pstat=con.prepareStatement(sql);
			pstat.setInt(1,rid);
			rs=pstat.executeQuery();	
		return rs.next();
	}
}
