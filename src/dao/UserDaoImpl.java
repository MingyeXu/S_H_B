package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import com.sun.org.apache.bcel.internal.generic.RET;

import jdbc.ResourceManager;
import dto.Book;
import dto.User;
import exceptions.UserDaoException;

public class UserDaoImpl implements UserDao{

	private Connection userConn;
	
	protected final String SQL_INSERT = "insert into " + getTableName() + "(user_id, user_psw,user_name, user_address,user_tel) values(?, ?, ?, ?, ?)";
	protected final String SQL_DISPLAY = "SELECT *FROM " + getTableName();
	protected final String SQL_SELECT = "SELECT *FROM " + getTableName();
	protected final String SQL_DELETE="DELETE FROM "+ getTableName()+" WHERE user_id=?";
	protected static final int COLUMN_ID = 1;
	protected static final int COLUMN_PSW= 2;
	protected static final int COLUMN_NAME= 3;
	protected static final int COLUMN_ADDRESS=4;
	protected static final int COLUMN_TEL=5;
	/**
	 * 新增user信息
	 */
	@Override
	public String insert(User user) throws UserDaoException {
		
		final boolean isConnSupplied = (userConn != null);
		
		Connection conn = null;
		CallableStatement stmt = null;
		
		try
		{
			System.out.println("Insert" + isConnSupplied);
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();  // 这行代码有问题
			stmt = conn.prepareCall(SQL_INSERT);//准备调用语句
			stmt.setString(COLUMN_ID, user.getId());
			stmt.setString(COLUMN_PSW, user.getPsw());
			stmt.setString(COLUMN_NAME, user.getName());
			stmt.setString(COLUMN_ADDRESS, user.getAddress());
			stmt.setString(COLUMN_TEL, user.getTel());
			stmt.execute();  //执行
			System.out.println("conn"+conn);
//			stmt.executeUpdate();
//			int rows = stmt.getUpdateCount();
//			System.out.println("Insert affect rows:" + rows);
			
		}
		catch(SQLException _e)
		{
			System.out.println("新增用户失败");
//			throw new UserDaoException("")
		}
		finally
		{
			ResourceManager.close(stmt);
			if(!isConnSupplied)
			{	
				ResourceManager.close(conn);
			}			
		}		
		System.out.println("Insert new user");
		return "";
	}

	/**
	 * 获取user表信息
	 * @return
	 * @throws UserDaoException
	 */
	public Vector<User> getExportInfo() throws UserDaoException{
		final boolean isConnSupplied = (userConn != null);
		
		Connection conn = null;
		CallableStatement stmt = null;
		
		try{
			
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();  
			System.out.println("conn:"+conn);
			
			Statement stmt_2 = conn.createStatement();
		
		    ResultSet rs = stmt_2.executeQuery(SQL_DISPLAY);
		    Vector<User> usersInfo=new Vector<User>();
		    //System.out.println("#####");
		    while (rs.next()) {
		    	User temp=new User();
		    	temp.setId(rs.getString(COLUMN_ID));
		    	temp.setPsw(rs.getString(COLUMN_PSW));
		    	temp.setName(rs.getString(COLUMN_NAME));
		    	temp.setAddress(rs.getString(COLUMN_ADDRESS));
		    	temp.setTel(rs.getString(COLUMN_TEL));
		    //	temp.display();
		    	usersInfo.add(temp);
		   
		    }   
		    return usersInfo;
		}
		catch(SQLException _e){
			System.out.println("打印数据失败");
			return null;
		}
		finally
		{
			ResourceManager.close(stmt);
			if(!isConnSupplied)
			{	
				ResourceManager.close(conn);
			}			
		}	
	}
	/**
	 * 删除user信息
	 * @param del_id
	 * @throws UserDaoException
	 */
	public void delete(String del_id)throws UserDaoException{
		final boolean isConnSupplied = (userConn != null);
		
		Connection conn = null;
		CallableStatement stmt = null;
		
		try {
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();  // 这行代码有问题
			stmt = conn.prepareCall(SQL_DELETE);
			stmt.setString(COLUMN_ID, del_id);
			stmt.execute();  //执行
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//准备调用语句
	}
	/**
	 * find
	 * @param id
	 * @return
	 */
	public User findById(String user_id)
	{	
		String sql = SQL_SELECT + " where user_id = '" + user_id + "'";				
		return executeSelectSQL(sql);
	}
	protected User executeSelectSQL(String sql)
	{
		  Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs = null;	  
		  User[] ret;
		  final boolean isConnSupplied = (userConn != null);
		  try 
		  {	   
			  conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		  	   stmt = conn.prepareCall(sql);
			   // 从连接中获取状态
			   stmt = conn.createStatement();
			   rs = stmt.executeQuery(sql);//执行sql语句 
			   List<User> resultList = new ArrayList<User>();
				try 
				{
					while (rs.next())
					{
						User user = populateDto(rs);
						resultList.add(user);
					}
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
				
				 ret = new User[ resultList.size() ];
				resultList.toArray( ret );	
				return ret[0];
		  } 
		  catch (SQLException e)
		  {
			   System.out.println("数据操作错误");
			   e.printStackTrace();
		  }
		  
		//关闭数据库
		  try 
		  {
			   if(stmt != null)
			   {
				    stmt.close();
				    stmt = null;
			   }
			   if(conn != null) 
			   {
				    conn.close();
				    conn = null;
			   }
		  }
		  catch(Exception e)
		  {
			   System.out.println("数据库关闭错误");
			   e.printStackTrace();
		  }
		
	return null;
		
	}
	/**
	 * 将一条数据库记录组装成一个对象
	 * @param rs
	 * @return
	 */
	protected User populateDto(ResultSet rs)
	{
		User user=new User();
		
		try 
		{
			user.setId(rs.getString("user_id"));
			user.setPsw(rs.getString("user_psw"));
			user.setName(rs.getString("user_name"));
			user.setAddress(rs.getString("user_address"));
			user.setTel(rs.getString("user_tel"));
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
		return user;
	}
	


	public String getTableName()
	{
		return "user";
	}
	
}
