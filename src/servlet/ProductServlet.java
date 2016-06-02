package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
import dao.shoppingCartDao;
import dao.shoppingCartDaoImpl;
import dto.Book;
import dto.BookPurchaseInfo;
import dto.User;
import dto.UserPayInfo;
import dto.shoppingCart;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	
	
	
	
	private static final long serialVersionUID = 1L;
    public shoppingCartDaoImpl sci=new shoppingCartDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**把数据存到session中
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductServlet ps=new ProductServlet();
		BookDaoImpl bdi=new BookDaoImpl();
		
		String product=request.getParameter("product");
		System.out.println("当前动作"+product);
		/**
		 * 选择商品进入购物车
		 */
		if(product.contains("B0")){
			shoppingCartDaoImpl scdi=new shoppingCartDaoImpl(); 
			System.out.println("选择图书"+product);
			int amount=Integer.parseInt(request.getParameter("amount").toString());
			System.out.println("购买数量"+amount);
			Book[] books=bdi.findById(product);
			List<Book> chooseBooks=new ArrayList<Book>();
			for(int i=0;i<books.length;i++){
				chooseBooks.add(books[i]);
			}
			
			
			//购买信息对象
			BookPurchaseInfo onePurInfo=new BookPurchaseInfo();
			onePurInfo.setBook(chooseBooks.get(0));//给购买信息对象设置购买书籍
			if(amount<=chooseBooks.get(0).getAmount()){
				//给购物车对象设置用户
			       HttpSession session=request.getSession();
			       onePurInfo.setQuantities(amount);//给购买信息对象设置购买数量
				   shoppingCart cart=null;
				       //有用户登陆
				       if(session.getAttribute("activeUser")!=null){
					       User activeUser=(User)session.getAttribute("activeUser");
					       cart=ps.getCartOfUser(activeUser.getId());
					       System.out.println("在线用户"+activeUser);
					       cart.check(product,activeUser);//检查函数，删除购物车中重复的购物信息
					       //购物车重新设置购买信息
					       List<BookPurchaseInfo> bpci=cart.getBookInfos();
					       bpci.add(onePurInfo);
					       cart.setBookInfos(bpci);

					       //session设置购物车标签
					       session.setAttribute("cart", cart);
					       //有用户登录将购买信息添加进数据库
					       if(cart.getUser()!=null){
					    	   sci.insert(onePurInfo, cart.getUser());
					       }
				       }

			      // }
			       /*  else{
			    	   System.out.println("之前购物车对象");
			    	   shoppingCart cart=(shoppingCart)session.getAttribute("cart");
			    	   cart.deleteBookInfo(product);
				       onePurInfo.setQuantities(amount);//给购买信息对象设置购买数量
				       cart.addBookInfo(onePurInfo);//给购物车对象增添购买信息
				       //session设置购物车标签
				       session.setAttribute("cart", cart);
				       //有用户登录添加进数据库
				       if(cart.getUser()!=null){
				    	   sci.insert(onePurInfo, cart.getUser());
				       }
			       }*/
				       //无用户登陆
				       else{
				    	   System.out.println("当前无用户登录");
				    	   //会话中无购物车对象
				    	   if(session.getAttribute("cart")==null){
				    		    cart=new shoppingCart();
				    		    List<BookPurchaseInfo> nullUserCartList=new ArrayList<BookPurchaseInfo>();
				    		    User nullUser=new User();
				    		    nullUserCartList.add(onePurInfo);
				    		    cart.setBookInfos(nullUserCartList);
				    		    cart.setUser(nullUser);
				    	   }
				    	   //会话中有购物车对象
				    	   else{
				    		   cart=(shoppingCart)session.getAttribute("cart");
				    		   cart.addBookInfo(onePurInfo);
				    	   }
				    	   
				    	   
					       //session设置购物车标签
					       session.setAttribute("cart", cart);
				       }
			       //重定向(绝对路径)
			       response.sendRedirect(request.getContextPath()+"/shoppingCart.jsp");
			}
			//库存不足
			else{
				JOptionPane.showMessageDialog(null, "库存不足，只剩余"+chooseBooks.get(0).getAmount()+"", "ERROR", JOptionPane.PLAIN_MESSAGE);
				RequestDispatcher view=request.getRequestDispatcher("productInfo.jsp");
				view.forward(request, response);
				
			}
	      
    }
		/**
		 * 详细信息查询
		 */
		else if(product.contains("info")){
			System.out.println("查询详细信息"+product);
			String book_id=product.replace("info", "B00");
			Book[] books=bdi.findById(book_id);
			request.getSession().setAttribute("bookinfo", books[0]);
			RequestDispatcher view = request.getRequestDispatcher("bookInfo.jsp");
			view.forward(request, response);	
			
		}
		/**
		 * 选择购物车商品生成订单
		 */
		else if(product.equals("toOrder")){
			System.out.println("生成订单。");
			//无用户登陆
			if(request.getSession().getAttribute("User")==null){
				request.getSession().invalidate();//sessio失效
				RequestDispatcher view=request.getRequestDispatcher("denglu.jsp");
				JOptionPane.showMessageDialog(null, "当前无用户登陆", "ERROR", JOptionPane.QUESTION_MESSAGE);
				view.forward(request, response);
			}
			//有用户登录
			else{
			//订单中购买信息对象
			List<BookPurchaseInfo> orderBookPurInfos=new ArrayList<BookPurchaseInfo>();
			//获取购物车中购买信息对象
			HttpSession session=request.getSession();
			shoppingCart cart=(shoppingCart)session.getAttribute("cart");
			List<BookPurchaseInfo> cartBookPurInfos=cart.getBookInfos();
			//根据名字获取书籍id
		    String [] book_ids=request.getParameterValues("book");
		    //将选中的书籍加入 订单中购买信息对象orderBookPurInfos
		    for(int i=0;i<book_ids.length;i++){
		    	for(int j=0;j<cartBookPurInfos.size();j++)
		    	if(book_ids[i].equals(cartBookPurInfos.get(j).getBook().getId())){
		    		orderBookPurInfos.add(cartBookPurInfos.get(j));
		    		//将购物车中这些信息删掉。
		    		cart.deleteInfoInDB(cartBookPurInfos.get(j), (User)request.getSession().getAttribute("User"));
		    		System.out.println("选中图书入订单"+cartBookPurInfos.get(j).getBook().getId());
		    	}
		    }   
		    session.setAttribute("cart", cart);
		    
		       //将订单中购买信息对象放入session中
		       session.setAttribute("orderBookPurInfos", orderBookPurInfos);
		       response.sendRedirect(request.getContextPath()+"/pay.jsp");
			}
		}
		
		
		/**
		 * 获取订单信息，跳转到确认订单界面
		 */
		else if(product.equals("orderInfo")){
	        //获取参数
	       String  name=request.getParameter("name");
	       String address=request.getParameter("address");
	       String phone=request.getParameter("phone");
	       String type=request.getParameter("type");
	       String account=request.getParameter("account");
	       
	       
	 
	       //将参数从session中取出来
	       HttpSession session=request.getSession();
	       User activeUser=(User)session.getAttribute("User");
	       List<BookPurchaseInfo> orderBookPurInfos=(List<BookPurchaseInfo>)session.getAttribute("orderBookPurInfos");
	       System.out.println("session传入"+activeUser.getName());
	       UserPayInfo order =new UserPayInfo(name, address,phone, type, account,orderBookPurInfos,activeUser);//直接封装一个对象用来接收
	       session.setAttribute("order", order);
	       //重定向
	       response.setContentType("text/html; charset=UTF-8");
	       response.setCharacterEncoding("UTF-8");
	       response.sendRedirect(request.getContextPath()+"/confirmPayInfo.jsp");//一定要用绝对路径
		}
		/**
		 * 退出账户
		 */
		else if(product.equals("exit")){
			HttpSession session=request.getSession();
			request.removeAttribute("styles");
			request.removeAttribute("bookInfo");
			session.removeAttribute("activeUser");
			session.removeAttribute("User");
			session.removeAttribute("cart");
			session.removeAttribute("orderBookPurInfos");
			session.removeAttribute("order");
			session.invalidate();//session失效
			RequestDispatcher view=request.getRequestDispatcher("denglu.jsp");
			view.forward(request, response);
		}
		/**
		 * 删除购物车商品
		 */
		else if(product.contains("deletePInfo")){
			HttpSession session=request.getSession();
			shoppingCart cart=(shoppingCart)session.getAttribute("cart");
			String delID=product.replace("deletePInfo", "");
			System.out.println("删除"+delID);
			cart.deleteBookInfo(delID);
			session.setAttribute("cart",cart);
			RequestDispatcher view=request.getRequestDispatcher("shoppingCart.jsp");
			 view.forward(request, response);
		}
	}
	
	public shoppingCart getCartOfUser(String user_id){
		shoppingCart cart =new shoppingCart();
		//从数据库获取user对象
		UserDaoImpl udi=new UserDaoImpl(); 
		User user=udi.findById(user_id);
		//加入购物车对象
		cart.setUser(user);
		System.out.println(user.getName()+"已成功从数据库加入购物车对象");
		//从数据库获取用户购物车商品信息记录,并加入购物车对象
		shoppingCartDaoImpl scdi=new shoppingCartDaoImpl();
		cart.setBookInfos(scdi.getInfoFromDB(user_id));
		return cart;
	}

}
