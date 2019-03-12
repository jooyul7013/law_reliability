package poi_test;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriterService {
	 public ExcelWriterService() {
		 
	    }
	 
	    public void makeExcelFileParmList(ArrayList<ParmDTO> list,String LawName) {
	        Workbook workbook = new HSSFWorkbook();
	        String jo, hang, ho, mok, bub = "", josak,hangsak,hosak,moksak,joga,hangga,hoga,mokga,joName=null;
	        String all = "";
	        // 시트명 설정
	        Sheet sheet = workbook.createSheet("parmlist");
	        Row row;
	 
	        // 타이틀 생성부
	        row = sheet.createRow(0);
	 
	        // 각 셀마다 타이틀을 적어준다.
	        /*row.createCell(1).setCellValue("jo");
	        row.createCell(2).setCellValue("hang");
	        row.createCell(3).setCellValue("ho");
	        row.createCell(4).setCellValue("mok");*/
	 
	        int count = 0;
	        
	        
	        for (ParmDTO entity : list) {
	            row = sheet.createRow(count);
	            count = count + 1;
	            if(entity.getbub() != null)
	            	bub = entity.getbub();
	            all= all+bub;
	            //row.createCell(0).setCellValue(bub);
	            //row.createCell(1).setCellValue(entity.getjo() = all +"조"));
	            jo = entity.getjo();
	            if(entity.getjoName() != null)
	            	joName =entity.getjoName();
	            hang = entity.gethang();
	            ho = entity.getho();
	            mok = entity.getmok();
	            
	            joga = entity.getjoga();
	            hangga = entity.gethangga();
	            hoga = entity.gethoga();
	            mokga = entity.getmokga();
	            
	            josak = entity.getjosak();
	            hangsak = entity.gethangsak();
	            hosak = entity.gethosak();
	            moksak = entity.getmoksak();
	            
	            if(jo != null)
	            {
	            	all = all +" 제"+jo+"조";
	            	if(joga != null)
	            	{
	            		all=all+"의"+joga;
	            	}
	            	all = all+"("+joName+")";
	            	if(josak != null)
	            	{
	            		if(josak.equals("삭제"))
	            		{
	            			all = all +" "+"<삭제>";
	            			//row.createCell(1).setCellValue(jo+"조 "+"삭제");
	            			josak = null;
	            		}
	            	}
	            	/*else
	            		row.createCell(1).setCellValue(jo+"조");*/
	            }
	            if(hang != null)
	            {
	            	all = all +" "+hang+"항";
	            	if(hangga != null)
	            	{
	            		all = all +"의"+hangga;
	            	}
	            	if(hangsak != null)
	            	{
	            		if(hangsak.equals("삭제"))
	            		{
	            			all = all +" "+"<삭제>";
	            			//row.createCell(1).setCellValue(jo+"조 "+"삭제");
	            			hangsak = null;
	            		}
	            	}
	            	/*else
	            		row.createCell(1).setCellValue(jo+"조");*/
	            }
	            if(ho != null)
	            {
	            	all = all+" "+ho+"호";
	            	if(hoga != null)
	            	{
	            		all = all+"의"+hoga;
	            	}
	            	if(hosak != null)
	            	{
	            		if(hosak.equals("삭제"))
	            		{
	            			all = all +" "+"<삭제>";
	            			//row.createCell(1).setCellValue(jo+"조 "+"삭제");
	            			hosak = null;
	            		}
	            	}
	            }
	            if(mok != null)
	            {
	            	all = all +" "+mok+"목";
	            	if(mokga != null)
	            	{
	            		all = all +"의"+mokga;
	            	}
	            	if(moksak != null)
	            	{
	            		if(moksak.equals("삭제"))
	            		{
	            			all = all +" "+"<삭제>";
	            			//row.createCell(1).setCellValue(jo+"조 "+"삭제");
	            			moksak = null;
	            		}
	            	}
	            }
	            /*if(hang != null)
	            {
	            	if(hangsak != null)
	            	{
	            		if(hangsak.equals("삭제"))
	            		{
	            			row.createCell(2).setCellValue(hang+"항 "+"삭제");
	            			hangsak = null;
	            		}
	            	}
	            	else
	            		row.createCell(2).setCellValue(hang+"항");
	            }
	            if(ho != null)
	            	row.createCell(3).setCellValue(ho+"호");
	            if(mok != null)
	            	row.createCell(4).setCellValue(mok+"목");*/
	           // row.createCell(2).setCellValue(entity.getho());
	        	//row.createCell(3).setCellValue(entity.getmok());
	            //System.out.println(all);
	            row.createCell(0).setCellValue(all);
	            all = "";
	        }
	 
	        FileOutputStream fos;
	        try {
	            fos = new FileOutputStream("C://"+LawName+".xls");
	            workbook.write(fos);
	            fos.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 

}
