package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Vo.RaceStar;
import Vo.User;
import tools.DbConnect;

public class UserDao {
	
	public User login(String username ,String password) throws ClassNotFoundException{
		
		User user = new User();
		DbConnect con = new DbConnect();
		
		try{
			String sql = "select * from tuser where username = ? and password = ?";
			PreparedStatement pst = con.conn.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				user.setUsername(username);
				user.setPassword(password);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public ArrayList<Race> queryRace() throws ClassNotFoundException, SQLException{
		ArrayList<Race> list = new ArrayList<Race>();
		User user = new User();
		
		DbConnect con = new DbConnect();
		Statement stmt = con.conn.createStatement();
		try{
			String sql = "select * from t_race";
			PreparedStatement pst = con.conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Race race = new Race();
				race.setRaceId(rs.getString("raceId"));
				race.setRaceName(rs.getString("raceName"));
				list.add(race);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<Star> queryStar(String raceId) throws ClassNotFoundException, SQLException{
		ArrayList<Star> list = new ArrayList<Star>();
		User user = new User();
		
		DbConnect con = new DbConnect();
		Statement stmt = con.conn.createStatement();
		try{
			String sql = "select * from t_star where raceId=" +raceId ;
			PreparedStatement pst = con.conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Star star = new Star();
				star.setRaceId(rs.getString("raceId"));
				star.setStarNumber(rs.getString("starNumber"));
				star.setName(rs.getString("name"));
				list.add(star);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<RaceStar> queryUser(String raceId,String starNumber,String page,String currentpage){
		ArrayList<RaceStar> list=new ArrayList<RaceStar>();
		StringBuffer sb=new StringBuffer();
		
		sb.append("select A.raceId,raceName, starNumber, name");
		sb.append(" from t_race A");
		sb.append(" inner join t_star B");
		sb.append(" on A.raceId=B.raceId ");
		sb.append("where 1=1");
		
		if(raceId!= null && !"".equals(raceId))
			sb.append(" and A.raceId='"+raceId+"'");
		
		if( starNumber!= null && !"".equals(starNumber))
			sb.append(" and B.starNumber='"+starNumber+"'");
		
		int start=(Integer.parseInt(currentpage)-1)*Integer.parseInt(page);
		int size = Integer.parseInt(page);
		
		sb.append(" limit ");
		sb.append(start);
		sb.append("," + size);

		DbConnect db;
		Statement stm;
		try {
			db = new DbConnect();
			stm=db.conn.createStatement();
			ResultSet rs=stm.executeQuery(sb.toString());
			while(rs.next()){
				RaceStar raceStar= new RaceStar();
				raceStar. setRaceId(rs.getString("raceId"));
				raceStar. setRaceName(rs.getString("raceName"));
				raceStar. setStarNumber(rs.getString("starNumber"));
				raceStar. setName(rs.getString("name"));
				
				list.add(raceStar);

			}	
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public int total(String race,String star){
		int count=0;
		
		StringBuffer sb=new StringBuffer();
		sb.append("select count(*) total from t_star where 1=1");
		if(race!=null && !"".equals(race)){
		sb.append(" and raceId='");
		sb.append(race);
		sb.append("' and starNumber ='");
		sb.append(star);
		sb.append("'");
		
	}
		DbConnect db;
		Statement stm;
		try {
			db = new DbConnect();
			stm=db.conn.createStatement();
			ResultSet rs=stm.executeQuery(sb.toString());
			rs.next();
			count=rs.getInt("total");
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return count;
		
	}

	public boolean delete(String name) {
		boolean ret=false;
		try{
			DbConnect con = new DbConnect();
			Statement stm;
			stm=con.conn.createStatement();
		
			String sql="delete from t_star where name=?";
			PreparedStatement pst = con.conn.prepareStatement(sql);
			pst.setString(1, name);
			int i=pst.executeUpdate();
			if(i>0)
				return true;
		}catch (SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ret;
	}

	public boolean deleteBatch(String ids) {
		boolean ret=false;
		try{
			DbConnect con = new DbConnect();
			String sql="delete from t_star where name in(";
			String arr[]=ids.split(",");
			System.out.println(ids);
			StringBuffer sb=new StringBuffer();
			for(int i=0;i<arr.length;i++)
			{
				sb.append("'");
				sb.append(arr[i]);
				sb.append("',");
			}
			
			String s=sb.toString();
			s=s.substring(0,s.length()-1);
			sql=sql+s+")";
			
			Statement stm=con.conn.createStatement();
			int i=stm.executeUpdate(sql);
			if(i>0)
				ret = true;
		}catch (SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	
	
	public boolean update(String raceId,String raceName,String starNumber,String name){
		boolean ret=false;
		
		try{
			DbConnect con = new DbConnect();
			Statement stm=con.conn.createStatement();
			
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO t_race(");
			sb.append("raceId,");
			sb.append("raceName) VALUES('");
			sb.append(raceId);
			sb.append("','");
			sb.append(raceName);sb.append("')");
			int i=stm.executeUpdate(sb.toString());
			
			String sql="INSERT INTO t_star(raceId,starNumber,name) VALUES ('" + raceId + "','" + starNumber + "','" + name + "')";
			int j=stm.executeUpdate(sql);
			
			if(i>0 && j>0)
				ret = true;
		}catch (SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ret;
	}

	public boolean add(String raceId, String raceName, String starNumber,String name) {
		boolean ret=false;
		try{
			DbConnect con = new DbConnect();
			Statement stm=con.conn.createStatement();
			StringBuffer sb=new StringBuffer();
				
			sb.append("UPDATE t_star SET name ='");
			sb.append(name);	
			sb.append("' where raceId='");
			sb.append(raceId);
			sb.append("' and starNumber='");
			sb.append(starNumber);
			sb.append("'");
			
			
			int i=stm.executeUpdate(sb.toString());
			if(i>0)
				ret = true;
		}catch (SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ret;
	}
	
	public boolean clear(String raceId, String starNumber) {
		boolean ret=false;
		try{
			DbConnect con = new DbConnect();
			Statement stm=con.conn.createStatement();
			StringBuffer sb=new StringBuffer();
				
			sb.append("delete from t_star where raceId='");
			sb.append(raceId);
			sb.append("' and starNumber='");
			sb.append(starNumber);
			sb.append("'");
			
			int i=stm.executeUpdate(sb.toString());
			if(i>0)
				ret = true;
		}catch (SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ret;
	}
	
}
