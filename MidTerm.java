package openmidtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

//jsoup
import org.jsoup.Jsoup;

//kkma
import org.snu.ids.kkma.index.Keyword;
import org.snu.ids.kkma.index.KeywordExtractor;
import org.snu.ids.kkma.index.KeywordList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@SuppressWarnings({ "rawtypes", "unchecked", "nls" })

public class MidTerm {
	String p;
	String q;
	public MidTerm(String path, String query) {
		// TODO Auto-generated constructor stub
		this.p=path;
		this.q=query;
	}

	public void showSnippet() throws TransformerException, IOException {
		File br = new File(p);
		org.jsoup.nodes.Document html = Jsoup.parse(br, "UTF-8");
		
		
		 HashMap map = new HashMap<String, Integer>();
		KeywordExtractor ke = new KeywordExtractor();
		KeywordList k1 = ke.extractKeyword(q, true);

		for (int j = 0; j < k1.size(); j++) {
			Keyword kwrd = k1.get(j);
			map.put(kwrd.getString(), kwrd.getCnt());

		}
		
		
		

	   
	      
	      HashMap[] fn = new HashMap[5];
	      for (int i = 0; i < 5; i++) {
	         fn[i] = new HashMap<String, String>();
	      }
	      
	      
	      for(int i=0;i<html.select("title").size();i++) {
				org.jsoup.select.Elements a=html.select("docs doc#"+i);	
				String wr=a.text();
				StringTokenizer st=new StringTokenizer(wr," ");
				String titleData=st.nextToken();			
				String bodyData =wr.substring(titleData.length());	

				
				
				
				KeywordExtractor ac=new KeywordExtractor();
				KeywordList b=ac.extractKeyword(bodyData, true);
				
				for(int j=0;j<b.size();j++) {
					Keyword kwrd=b.get(j);	
					
					
					String s=kwrd.getString(); //body data
					int n=kwrd.getCnt(); //bodty num
					
					Iterator<String> itr = map.keySet().iterator();
				      while (itr.hasNext()) {
				         String key = itr.next();
				         int num=(Integer)map.get(key);
				         
				         if(key.equals(s)) {
				        	 System.out.println(key+","+bodyData);
				         }
				         
				      }
					
				

				}//body 
							
				
			}
	      
	      
	
	      
	      
	      

	}
}
