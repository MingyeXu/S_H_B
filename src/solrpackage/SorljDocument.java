package solrpackage;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.request.QueryRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.util.SolrjNamedThreadFactory;

public class SorljDocument {
	private static final String URL="http://localhost:8983/solr/core1";
	SolrServer server=null;
	
	//使用slorj创建索引
	public void addDoc(){
		try{
			server=getSolrServer();
			Collection docs=new ArrayList();
			server.deleteByQuery("*:*");
			SolrInputDocument doc1=new SolrInputDocument();
			doc1.addField("user_id", "1");
			doc1.addField("user_psw", "123456");
			doc1.addField("user_name", "小王");
			doc1.addField("user_address", "changsha");
			doc1.addField("user_tel", "1395684987");
		
			SolrInputDocument doc2=new SolrInputDocument();
			doc2.addField("user_id", "2");
			doc2.addField("user_psw", "123456");
			doc2.addField("user_name", "小张");
			doc2.addField("user_address", "hengshui");
			doc2.addField("user_tel", "16843125587");	
			
			docs.add(doc1);
			docs.add(doc2);
			
			server.add(docs);
			server.commit();
		}catch(Exception ex){
			
			ex.printStackTrace();
			
		}
		
	}
	
	//查询服务器
	public void getQuery(){
		try{
			SolrServer server=getSolrServer();
			SolrQuery query=new SolrQuery();
			query.setQuery("*:*");
			QueryResponse results=server.query(query);
			SolrDocumentList docs= results.getResults();
			System.out.println("docs的大小是：：："+docs.size());
			for(int i=0;i<docs.size();i++){
				SolrDocument doc=docs.get(i);
				System.out.println(doc.getFieldValue("user_name"));
				System.out.println(doc.getFieldValue("user_id"));
				System.out.println(doc.getFieldValue("user_address"));
				
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
public SolrServer getSolrServer(){
	try{
		return new HttpSolrServer(URL);
	}catch(Exception ex){
		return null;
	}
}	
public static void main(String[] args){
	SorljDocument docsolr=new SorljDocument();
	docsolr.addDoc();
	docsolr.getQuery();
}


}
