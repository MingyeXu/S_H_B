package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.ResourceManager;
import dto.Book;

public class BookDaoImpl implements BookDao {

private Connection userConn;
	
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " (book_id, book_name, book_author, book_press, book_press_date, book_price, book_amount) values(?, ?, ?, ?, ?, ?, ?)";
	protected  String SQL_SELECT = "SELECT book_id, book_name, book_author, book_press, book_press_date, book_price, book_amount FROM " + getTableName() + "";
	protected  String SQL_DELETE = "DELETE FROM "  + getTableName()  + " ";

	protected static final int COLUMN_ID = 1;
	protected static final int COLUMN_NAME = 2;	
	protected static final int COLUMN_AUTHOR = 3;
	protected static final int COLUMN_PRESS = 4;
	protected static final int COLUMN_PRESS_DATE = 5;
	protected static final int COLUMN_PRICE = 6;
	protected static final int COLUMN_AMOUNT = 7;
	
	@Override
	public void insert(Book book){
		
		System.out.println("Insert Book!");
		final boolean isConnSupplied = (userConn != null);
		
		Connection conn = null;
		CallableStatement stmt = null;
		
		try
		{
			// 从ResourceManager获取连接
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
			stmt = conn.prepareCall(SQL_INSERT);
			
			stmt.setString(COLUMN_ID, book.getId());
			stmt.setString(COLUMN_NAME, book.getName());
			stmt.setString(COLUMN_AUTHOR, book.getAuthor());
			stmt.setString(COLUMN_PRESS, book.getPress());
			stmt.setString(COLUMN_PRESS_DATE, book.getPressDate());
			stmt.setDouble(COLUMN_PRICE, book.getPrice());
			stmt.setInt(COLUMN_AMOUNT, book.getAmount());
			System.out.println("#########");
			//stmt.execute();   // 卡住了，执行不通过
			stmt.executeUpdate();
			int rows = stmt.getUpdateCount();
			System.out.println("Insert affect rows：" + rows);
			
		}
		catch(SQLException _e)
		{
			
//			throw new UserDaoException("")
			System.out.println("Exception...");
		}
		finally
		{
			ResourceManager.close(stmt);
			if(!isConnSupplied)
			{	
				ResourceManager.close(conn);
			}			
		}		

		return ;
	}

	
	public String getTableName()
	{
		return "book";
	}


	@Override
	public Book[] findById(String id)
	{	
		String sql = SQL_SELECT + " where book_id = '" + id + "'";				
		return executeSelectSQL(sql);
	}


	@Override
	public Book[] findByName(String name) 
	{
		String sql = SQL_SELECT + " where book_name = '" + name + "'";
		return executeSelectSQL(sql);
	}
	
	public Book[] getAllBooks(){
		
		return executeSelectSQL(SQL_SELECT);
	}
	
	/**
	 * 执行select查询语句方法
	 * @param sql
	 * @return
	 */
	protected Book[] executeSelectSQL(String sql)
	{
		  Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs = null;	  
		  Book[] ret = null;
		  final boolean isConnSupplied = (userConn != null);
		  try 
		  {	   
			  conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		  	   stmt = conn.prepareCall(sql);
			   // 从连接中获取状态
			   stmt = conn.createStatement();
			   rs = stmt.executeQuery(sql);//执行sql语句 
			   List<Book> resultList = new ArrayList<Book>();
				try 
				{
					while (rs.next())
					{
						Book book = populateDto(rs);
						resultList.add(book);
					}
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
				
				ret = new Book[ resultList.size() ];
				resultList.toArray( ret );			   
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
		
		return ret;
		
	}
	
	/**
	 * 数据库查询的结果组装成对象数组
	 * @param rs
	 * @return
	 * @throws SQLException 
	 */
	protected Book[] fetchMultiResults(ResultSet rs)
	{
		List<Book> resultList = new ArrayList<Book>();
		try 
		{
			while (rs.next())
			{
				Book book = populateDto(rs);
				resultList.add(book);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		Book ret[] = new Book[ resultList.size() ];
		resultList.toArray( ret );
		
		return ret;
	}
	
	/**
	 * 将一条数据库记录组装成一个对象
	 * @param rs
	 * @return
	 */
	protected Book populateDto(ResultSet rs)
	{
		Book book = new Book();
		
		try 
		{
			book.setId(rs.getString("book_id"));
			book.setName(rs.getString("book_name"));
			book.setAuthor(rs.getString("book_author"));
			book.setPress(rs.getString("book_press"));
			book.setPressDate(rs.getString("book_press_date"));
			book.setPrice(rs.getDouble("book_price"));
			book.setAmount(rs.getInt("book_amount"));
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
		return book;
	}

	/**
	 * 从数据库中删除书籍
	 */
	@Override
	public boolean deleteBook(String id)
	{
		System.out.println("Delete Book! id = " + id);
		final boolean isConnSupplied = (userConn != null);
		
		Connection conn = null;
		CallableStatement stmt = null;
		
		String sql = SQL_DELETE + "WHERE book_id = '" + id + "'";
		System.out.println(sql);
		try
		{
			// 从ResourceManager获取连接
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
			
			stmt = conn.prepareCall(sql);
			
//			stmt.execute();  
			 stmt.executeUpdate(sql);
			
			int rows = stmt.getUpdateCount();
			System.out.println("delete affect rows：" + rows);
			
		}
		catch(SQLException _e)
		{			
//			throw new UserDaoException("")
			System.out.println("Exception...");
		}
		finally
		{
			ResourceManager.close(stmt);
			if(!isConnSupplied)
			{	
				ResourceManager.close(conn);
			}			
		}			
		
		return false;
	}
}
