package solrpackage;

import java.net.MalformedURLException;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("###");
		ServerTest st= new ServerTest();
		try {
			st.init();
			st.server();
			st.query("user_name:徐名业");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
