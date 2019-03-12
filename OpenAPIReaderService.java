package poi_test;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.net.URL;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class OpenAPIReaderService {
	
	public final static String PHARM_URL = "http://www.law.go.kr/DRF/lawSearch.do?OC=kskim&target=law&type=XML&query=%ED%99%94%EC%9E%A5%ED%92%88%EB%B2%95";
	String jo, hang, ho, mok, bub, josak, hangsak, hosak, moksak;
	String joga, hangga, hoga, mokga;
	String joName;
	String tmp;
	String tmp2;
	String attr;
	String Lawid, LawName;
	int key;
	public OpenAPIReaderService(String Lawid, String LawName)
	{
		this.Lawid = Lawid;
		this.LawName = LawName;
		jo = null;
		joName = null;
		hang = null;
		ho = null;
		mok = null;
		bub = null;
		josak = null;
		hangsak = null;
		joga = null;
		hangga = null;
		hoga = null;
		mokga = null;
		
		tmp2 = "전문";
		try
		{
			apiParserSearch();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void apiParserSearch() throws Exception{

		URL url = new URL("http://www.law.go.kr/DRF/lawService.do?OC=kskim&target=law&ID="+Lawid+"&type=XML");
		
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		factory.setNamespaceAware(true);
		XmlPullParser xpp = factory.newPullParser();
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		xpp.setInput(bis,"UTF-8");
		
		String tag = null;
		int event_type = xpp.getEventType();
		ArrayList<ParmDTO> list = new ArrayList<ParmDTO>();
		
		while (event_type != XmlPullParser.END_DOCUMENT) {
            if (event_type == XmlPullParser.START_TAG) {
                tag = xpp.getName();
                if(tag.equals("조문단위"))
                {
                	attr = xpp.getAttributeValue(null,"조문키");
                }
            } 
            else if (event_type == XmlPullParser.TEXT) {
            	
            	if(tag.equals("조문번호"))
            	{
            		tmp = xpp.getText();
            		if(tmp.length()> 1 || '0' < tmp.charAt(0)) 
            		{
            			jo = xpp.getText();
            		
            		//System.out.println(xpp.nextText());
            		//System.out.println(jo);
            		joName = null;
            		hang = null;
            		ho = null;
            		mok = null;
            		joga = null;
            		hangga = null;
            		hoga = null;
            		mokga = null;
            		}
            		
            	}
            	else if(tag.equals("조문제목"))
            	{
            		tmp = xpp.getText();
            		if(tmp.length()>1 || '0' < tmp.charAt(0)) {
            			joName = xpp.getText().trim().replace("(", "").replace(")", "");
            			//hang = xpp.getText();
            		}
            	}
            	else if(tag.equals("항번호"))
            	{
            		tmp = xpp.getText();
            		if(tmp.length()>1 || '0' < tmp.charAt(0)) {
            			hang = changeCircleNumb(xpp.getText());
            			//hang = xpp.getText();
            		ho = null;
            		mok = null;
            		hangga = null;
            		hoga = null;
            		mokga = null;
            		}
            	}
            	else if(tag.equals("호번호"))
            	{
            		tmp = xpp.getText();
            		if(tmp.trim().length()>1 || '0' < tmp.charAt(0)) {
            			ho = xpp.getText().replace(".", "").trim();
            		mok = null;
            		hoga = null;
            		mokga = null;
            		}
            	}
            	else if(tag.equals("목번호"))
            	{
            		tmp = xpp.getText();
            		if(tmp.trim().length()>1 || '0' < tmp.charAt(0)) {
            			mok = xpp.getText().replace(".","");
            			mokga = null;
            		}
            	}
            	else if(tag.equals("법령명_한글"))
            	{
            		tmp = xpp.getText();
            		if(tmp.length()>1 || '0' < tmp.charAt(0)) {
            			bub = xpp.getText();
            		}
            	}
            	else if(tag.equals("조문내용"))
            	{
            		tmp = xpp.getText();
            		if(tmp.length()>1 || '0' < tmp.charAt(0)) {
            			josak = xpp.getText();
            		}
            	}
            	else if(tag.equals("항내용"))
            	{
            		tmp = xpp.getText();
            		if(tmp.length()>1 || '0' < tmp.charAt(0)) {
            			hangsak = xpp.getText();
            		}
            	}
            	else if(tag.equals("호내용"))
            	{
            		tmp = xpp.getText();
            		if(tmp.length()>1 || '0' < tmp.charAt(0)) {
            			hosak = xpp.getText();
            		}
            	}
            	else if(tag.equals("목내용"))
            	{
            		tmp = xpp.getText();
            		if(tmp.length()>1 || '0' < tmp.charAt(0)) {
            			moksak = xpp.getText();
            		}
            	}
            	else if(tag.equals("조문가지번호"))
            	{
            		tmp = xpp.getText();
            		if(tmp.length()>1 || '0' < tmp.charAt(0)) {
            			joga = xpp.getText().replace(".","");
            		}
            	}
            	else if(tag.equals("항가지번호"))
            	{
            		tmp = xpp.getText();
            		if(tmp.length()>1 || '0' < tmp.charAt(0)) {
            			hangga = xpp.getText().replace(".","");
            		}
            	}
            	else if(tag.equals("호가지번호"))
            	{
            		tmp = xpp.getText();
            		if(tmp.length()>1 || '0' < tmp.charAt(0)) {
            			hoga = xpp.getText().replace(".","").trim();
            		}
            	}
            	else if(tag.equals("목가지번호"))
            	{
            		tmp = xpp.getText();
            		if(tmp.length()>0 || '0' < tmp.charAt(0)) {
            			mokga = xpp.getText().replace(".","").trim();
            		}
            	}
            	
            }
            
            else if (event_type == XmlPullParser.END_TAG) {
                tag = xpp.getName();
                if(tag.equals("조문내용"))
            	{
                	key = Integer.parseInt(attr);
                	if(key%10 == 0)
                	{
                		event_type = xpp.next();
                		continue;
                	}                	
                	 ParmDTO entity = new ParmDTO();
                     entity.setjo(jo);
                     entity.setjoName(joName);
                     entity.sethang(hang);
                     entity.setho(ho);
                     entity.setmok(mok);
                     if(josak!=null)
                     {
                    	 if(josak.contains("삭제"))
                    	 {
                    		 entity.setjosak("삭제");
                    		 josak = null;
                    	 }
                     }
                     if(joga!=null)
                     {
                    	 
                    	 entity.setjoga(joga);
                     }
                     list.add(entity);
                     
                     
            	}
            	else if(tag.equals("항내용"))
            	{
            		 ParmDTO entity = new ParmDTO();
                     entity.setjo(jo);
                     entity.sethang(hang);
                     entity.setho(ho);
                     entity.setmok(mok);
                     if(hangsak!=null)
                     {
                    	 if(hangsak.contains("삭제"))
                    	 {
                    		 entity.sethangsak("삭제");
                    		 hangsak = null;
                    	 }
                     }
                     if(joga!=null)
                     {
                    	 
                    	 entity.setjoga(joga);
                     }
                     if(hangga!=null)
                     {
                    	 
                    	 entity.sethangga(hangga);
                     }
                     //
                     list.add(entity);
            	}
            	else if(tag.equals("호내용"))
            	{
            		 ParmDTO entity = new ParmDTO();
                     entity.setjo(jo);
                     entity.sethang(hang);
                     entity.setho(ho);
                     entity.setmok(mok);
                     if(hosak!=null)
                     {
                    	 if(hosak.contains("삭제"))
                    	 {
                    		 entity.sethosak("삭제");
                    		 hosak = null;
                    	 }
                     }
                     if(joga!=null)
                     {
                    	 
                    	 entity.setjoga(joga);
                     }
                     if(hangga!=null)
                     {
                    	 
                    	 entity.sethangga(hangga);
                     }
                     if(hoga!=null)
                     {
                    	 
                    	 entity.sethoga(hoga);
                     }
                     list.add(entity);
            	}
            	else if(tag.equals("목내용"))
            	{
            		 ParmDTO entity = new ParmDTO();
            		 
                     entity.setjo(jo);
                     entity.sethang(hang);
                     entity.setho(ho);
                     entity.setmok(mok);
                     if(moksak!=null)
                     {
                    	 if(moksak.contains("삭제"))
                    	 {
                    		 entity.setmoksak("삭제");
                    		 moksak = null;
                    	 }
                     }
                     if(joga!=null)
                     {
                    	 
                    	 entity.setjoga(joga);
                     }
                     if(hangga!=null)
                     {
                    	 
                    	 entity.sethangga(hangga);
                     }
                     if(hoga!=null)
                     {
                    	 
                    	 entity.sethoga(hoga);
                     }
                     if(mokga!=null)
                     {
                    	 entity.setmokga(mokga);
                     }
                     list.add(entity);
                     
            	}
            	else if(tag.equals("법령명_한글"))
            	{
            		 ParmDTO entity = new ParmDTO();
            		 
                     entity.setbub(bub);
                     list.add(entity);
                     
            	}
            }
            event_type = xpp.next();
         }
		
		new ExcelWriterService().makeExcelFileParmList(list,LawName);
	}
	
	private String changeCircleNumb(String numb)
	{
		int tmp;
		String tmp2;
		tmp = (int)numb.charAt(0) - 9311;
		tmp2 = Integer.toString(tmp);
		
		return tmp2;
	}
	 public static void main(String args[]){
		 	LawList list = new LawList();
		 	System.out.println("Program Start... Making Excel files...");
		 	for(int i=0; i<49; i++)
		 	{
		 		new OpenAPIReaderService(list.LawID[i],list.LawName[i]);
		 	}
		 	System.out.println("Done!");
	        
	   }
	 
	 
}
