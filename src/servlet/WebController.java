package servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import dao.BookDaoImpl;
import dao.UserDaoImpl;
import dto.Book;
import dto.User;
import exceptions.UserDaoException;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class WebController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Book book = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		UserDaoImpl udi=new UserDaoImpl();
		
		request.setCharacterEncoding("UTF-8");//客户端网页我们控制为UTF-8
		String action = request.getParameter("action");
		//String action="";//text
        System.out.println("********action:"+action);
        
        //注册
        if(action.equals("user")){
		Vector<User> usersInfo=new Vector<User>();
		String id = request.getParameter("user_id");
		String name = request.getParameter("user_name");
		String psw = request.getParameter("user_psw");
		String address=request.getParameter("user_address");
		String tel=request.getParameter("user_tel");
		User user = new User(id, name, psw,address,tel);
		try
		{
			udi.insert(user);
			usersInfo=udi.getExportInfo();
		} 
		catch (UserDaoException e) 
		{
			e.printStackTrace();
		}		

		response.setCharacterEncoding("UTF-8");
		request.setAttribute("styles",usersInfo );
		RequestDispatcher view=request.getRequestDispatcher("manage.jsp");
		view.forward(request, response);
		System.out.println("ID: " + id);
		System.out.println("Name: " + name);
		System.out.println("Password: " + psw);
		System.out.println("address: " + address);
		System.out.println("tel: " + tel);
	}
      //登陆
    if(action.equals("login")){
    	User activeUser=new User();
    	String id=request.getParameter("user_id");
    	String psw = request.getParameter("user_psw");
    	Vector<User> usersInfo=new Vector<User>();
    	try {
			usersInfo=udi.getExportInfo();
			boolean flagUser=false;
			boolean flagPsw=false;
			for(int i=0;i<usersInfo.size();i++){
				if(id.equals(usersInfo.get(i).getId())&&psw.equals(usersInfo.get(i).getPsw())){
					activeUser=usersInfo.get(i);
					flagUser=true;
					flagPsw=true;
				}
				if(id.equals(usersInfo.get(i).getId())&&!psw.equals(usersInfo.get(i).getPsw())){
					flagUser=true;
					flagPsw=false;
					System.out.println("密码错误！");
					JOptionPane.showMessageDialog(null, "密码错误", "ERROR", JOptionPane.QUESTION_MESSAGE);
					response.setCharacterEncoding("UTF-8");
					request.setAttribute("styles",usersInfo );
					RequestDispatcher view=request.getRequestDispatcher("denglu.jsp");
					view.forward(request, response);
				}
			}
	    	if(flagUser==false){
				System.out.println("没有此用户！");
				JOptionPane.showMessageDialog(null, "用户不存在", "ERROR", JOptionPane.QUESTION_MESSAGE);
				response.setCharacterEncoding("UTF-8");
				RequestDispatcher view=request.getRequestDispatcher("denglu.jsp");
				view.forward(request, response);
	    		
	    	}
	    	else if(flagUser==true&&flagPsw==true){
	    		System.out.println(activeUser.getName());
		    	JOptionPane.showMessageDialog(null, "欢迎"+activeUser.getName(), "登陆成功", JOptionPane.PLAIN_MESSAGE);
		    	response.setCharacterEncoding("UTF-8");
				HttpSession session=request.getSession();
				session.setAttribute("activeUser", activeUser);//加标签
				RequestDispatcher view=request.getRequestDispatcher("productInfo.jsp");
				view.forward(request, response);	    		
	    	}   	



		} catch (UserDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		session.setAttribute("User",activeUser );
    	
      }
        
       //书籍添加 
	  if(action.equals("book"))
      {
      	String id = request.getParameter("book_id");
  		String name = request.getParameter("book_name");
  		String author = request.getParameter("book_author");
      	String press = request.getParameter("book_press");
  		String pressDate = request.getParameter("book_press_date");
  		double price = Double.parseDouble(request.getParameter("book_price"));
  		int amount = Integer.parseInt(request.getParameter("book_amount"));
  		
  		Book book = new Book(id, name, author, press, pressDate, price, amount);
  			System.out.println("12345");
  			new BookDaoImpl().insert(book);
  			System.out.println("54321");
	
  		
  		System.out.println("ID: " + id);
  		System.out.println("Name: " + name);
  		System.out.println("Author: " + author);
  		System.out.println("Press: " + press);
  		System.out.println("PressDate: " + pressDate);
  		System.out.println("Price: " + price);
  		System.out.println("Amount: " + amount);
  		
      }
      
      
      //书记选择
      if(action.equals("BookQuery"))
      {
      	String selectAction =  request.getParameter("selectAction");
      	
      	String selectWay = request.getParameter("idOrName");
      	
      	Book[] books = null;
      	
      	System.out.println("selectWay: " + selectWay);
      	
      	if(selectAction.equals("QueryById"))
      	{
      		books = new BookDaoImpl().findById(selectWay);      		
      	}
      	
      	if(selectAction.equals("QueryByName"))
      	{
      		books = new BookDaoImpl().findByName(selectWay);
      	}
      	
			for(int i = 0; i < books.length; i++)
			{
				System.out.println(books[i].toString());
			}        	
      	
			book = books[0];
			
			request.setAttribute("book", books[0]);
			
			RequestDispatcher view = request.getRequestDispatcher("QueryBook.jsp");
			
			view.forward(request, response);			
      }
      //用户删除
      if(action.equals("deleteUser")){
    	  Vector<User> usersInfo=new Vector<User>();
  		String id = request.getParameter("delete_id");
  		System.out.println("&&&&&&&&&&&&&"+id);
  		try
  		{
  			udi.delete(id);
  			usersInfo=udi.getExportInfo();
  			

  		} 
  		catch (UserDaoException e) 
  		{
  			e.printStackTrace();
  		}		
  		request.setAttribute("styles",usersInfo );
  		RequestDispatcher view=request.getRequestDispatcher("manage.jsp");
  		view.forward(request, response);

  		
  	}
      //书记删除
      if(action.equals("BookDelete"))
      {
      	System.out.println("删除书籍");
      	String id = request.getParameter("idOrName");
      	
      	new BookDaoImpl().deleteBook(book.getId());
      	
      }		
	}
	
}
