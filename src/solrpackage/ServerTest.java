package solrpackage;
import java.io.IOException;
import java.net.MalformedURLException; 
import java.util.ArrayList; 
import java.util.Collection;
import java.util.List; 

import org.apache.solr.client.solrj.SolrQuery; 
import org.apache.solr.client.solrj.SolrServer; 
import org.apache.solr.client.solrj.SolrServerException; 
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse; 
import org.apache.solr.client.solrj.response.UpdateResponse; 
import org.apache.solr.common.SolrDocumentList; 
import org.apache.solr.common.SolrInputDocument; 
import org.apache.solr.common.params.ModifiableSolrParams; 
import org.apache.solr.common.params.SolrParams; 
import org.junit.After; 
import org.junit.Before; 
import org.junit.Test; 
/**
 * <b>function:</b> Server TestCase
 * @author hoojo
 * @createDate 2011-10-19 下午01:49:07 
 * @file ServerTest.java 
 * @package com.hoo.test 
 * @project SolrExample 
 * @blog http://blog.csdn.net/IBM_hoojo 
 * @email hoojo_@126.com 
 * @version 1.0 
 */
public class ServerTest {  
    private SolrServer server;
    private HttpSolrServer httpServer; 
    private static final String DEFAULT_URL = "http://localhost:8080/solr/core1/"; 
    @Before 
    public void init() throws MalformedURLException { 
        server = new HttpSolrServer(DEFAULT_URL); 
		httpServer = new HttpSolrServer(DEFAULT_URL); 
    }   
    @After 
    public void destory() { 
        server = null; 
        httpServer = null; 
        System.runFinalization(); 
        System.gc(); 
    } 
    public final void fail(Object o) { 
        System.out.println(o); 
    } 
    /** 
     * <b>function:</b> 测试是否创建server对象成功 
     * @author hoojo 
     * @createDate 2011-10-21 上午09:48:18 
     */
    @Test
    public void server() { 
        fail(server); 
        fail(httpServer); 
    } 
    /** 
     * <b>function:</b> 根据query参数查询索引 
     * @author hoojo 
     * @createDate 2011-10-21 上午10:06:39 
     * @param query 
     */ 
    public void query(String query) { 
        SolrParams params = new SolrQuery(query);       
        try { 
            QueryResponse response = server.query(params);        
            SolrDocumentList list = response.getResults();
            for (int i = 0; i < list.size(); i++) {
                 fail(list.get(i));
            }
        } catch (SolrServerException e) { 
            e.printStackTrace(); 
        }  
    } 
}

