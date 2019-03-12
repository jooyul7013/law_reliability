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
	        // ��Ʈ�� ����
	        Sheet sheet = workbook.createSheet("parmlist");
	        Row row;
	 
	        // Ÿ��Ʋ ������
	        row = sheet.createRow(0);
	 
	        // �� ������ Ÿ��Ʋ�� �����ش�.
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
	            //row.createCell(1).setCellValue(entity.getjo() = all +"��"));
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
	            	all = all +" ��"+jo+"��";
	            	if(joga != null)
	            	{
	            		all=all+"��"+joga;
	            	}
	            	all = all+"("+joName+")";
	            	if(josak != null)
	            	{
	            		if(josak.equals("����"))
	            		{
	            			all = all +" "+"<����>";
	            			//row.createCell(1).setCellValue(jo+"�� "+"����");
	            			josak = null;
	            		}
	            	}
	            	/*else
	            		row.createCell(1).setCellValue(jo+"��");*/
	            }
	            if(hang != null)
	            {
	            	all = all +" "+hang+"��";
	            	if(hangga != null)
	            	{
	            		all = all +"��"+hangga;
	            	}
	            	if(hangsak != null)
	            	{
	            		if(hangsak.equals("����"))
	            		{
	            			all = all +" "+"<����>";
	            			//row.createCell(1).setCellValue(jo+"�� "+"����");
	            			hangsak = null;
	            		}
	            	}
	            	/*else
	            		row.createCell(1).setCellValue(jo+"��");*/
	            }
	            if(ho != null)
	            {
	            	all = all+" "+ho+"ȣ";
	            	if(hoga != null)
	            	{
	            		all = all+"��"+hoga;
	            	}
	            	if(hosak != null)
	            	{
	            		if(hosak.equals("����"))
	            		{
	            			all = all +" "+"<����>";
	            			//row.createCell(1).setCellValue(jo+"�� "+"����");
	            			hosak = null;
	            		}
	            	}
	            }
	            if(mok != null)
	            {
	            	all = all +" "+mok+"��";
	            	if(mokga != null)
	            	{
	            		all = all +"��"+mokga;
	            	}
	            	if(moksak != null)
	            	{
	            		if(moksak.equals("����"))
	            		{
	            			all = all +" "+"<����>";
	            			//row.createCell(1).setCellValue(jo+"�� "+"����");
	            			moksak = null;
	            		}
	            	}
	            }
	            /*if(hang != null)
	            {
	            	if(hangsak != null)
	            	{
	            		if(hangsak.equals("����"))
	            		{
	            			row.createCell(2).setCellValue(hang+"�� "+"����");
	            			hangsak = null;
	            		}
	            	}
	            	else
	            		row.createCell(2).setCellValue(hang+"��");
	            }
	            if(ho != null)
	            	row.createCell(3).setCellValue(ho+"ȣ");
	            if(mok != null)
	            	row.createCell(4).setCellValue(mok+"��");*/
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
