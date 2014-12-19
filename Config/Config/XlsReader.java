package Config;
//import static Config.XlsReader.configDetails;
//import static Config.XlsReader.configDetails;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.hssf.model.Sheet;
import org.apache.poi.hssf.model.Workbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import ReusableComponents.htmlReport;

@SuppressWarnings("unused")
public class XlsReader extends BaseConfig
{
	//@SuppressWarnings("unused")
	private static Workbook workbook;
	static Sheet sheet;
	//@SuppressWarnings("unused")
	private static HSSFSheet xlSheet;
	//@SuppressWarnings("unused")
	private static HSSFWorkbook xlWorkBook;
	private static HSSFCell cell;
    //@SuppressWarnings("unused")
	private static HSSFRow row;
	static int ExcelRows;
	static int Excelcols;    
	public static String localArray[][];
	public static String localArray1[][];
	public static String localArray2[][];	
	public static String ExpeActual[][];
	
	 static htmlReport htr=new htmlReport();
	 
	private static String excelP() throws Exception
	 {
		 String ExcelPa=configDetails(0,3,1); 
		 return "ExcelPa";
	 }
	 
	 
	//@SuppressWarnings("static-access")
	public static void Fetchmethod(String sheet) throws Exception {	
		
	  //  String ExcelPath=configDetails(0,3,1);
		try{		
		//String ExcelPath=configDetails(0,1,1);
		//String ExcelPath=excelPath();		
		System.out.println("Entered FetchMethod");
		System.out.println("The value of ExcelPath is:"+ExcelPath);
		File oxlFile = new File(ExcelPath);
		FileInputStream oTestDataStream = new FileInputStream(oxlFile);
		HSSFWorkbook xlWorkBook = new HSSFWorkbook(oTestDataStream);
		HSSFSheet xlSheet = xlWorkBook.getSheet("Sheet2");
	
		ExcelRows = xlSheet.getLastRowNum() + 1;
		Excelcols = xlSheet.getRow(0).getLastCellNum();
		localArray = new String[ExcelRows][Excelcols];
			
		for(int i=0;i<ExcelRows;i++){
			
		HSSFRow row = xlSheet.getRow(i);
		for(Short j=0;j<Excelcols;j++){
			HSSFCell cell =row.getCell(j);
			if (cell == null)
			{
			  
			}
			else if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
            {
			String Value = cell.getStringCellValue();			
			localArray[i][j] = Value;
            }
			else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
            {
                
                double num = cell.getNumericCellValue();
                int num1 = Double.valueOf(num).intValue();
                String num2 = Integer.toString(num1);
                localArray[i][j] = num2;
            }
						
		}
				
		}
		}
		  catch (Exception e){
 

            }
	}
	
	public static int FindRowno(String Methodname) throws Exception {
		int rowno=0;
		for(int i=0;i<ExcelRows;i++){
			
				if(localArray[i][0].contentEquals(Methodname))
				{
					String noofitem1 = localArray[i][1];
					rowno =Integer.parseInt(noofitem1);
				}		
			}
		return rowno;				
	}
	
		
		//@SuppressWarnings("static-access")
		public static void FetchExceldata(int rowno) throws Exception {
			File oxlFile = new File(ExcelPath);
			FileInputStream oTestDataStream = new FileInputStream(oxlFile);
			HSSFWorkbook xlWorkBook = new HSSFWorkbook(oTestDataStream);
			HSSFSheet xlSheet = xlWorkBook.getSheet("Sheet3");
			int i=0;
			ExcelRows = xlSheet.getLastRowNum()+1;
			Excelcols = xlSheet.getRow(0).getLastCellNum();
			localArray1 = new String[ExcelRows][Excelcols];
			HSSFRow row = xlSheet.getRow(rowno);
			for(short j=0;j<Excelcols;j++){
				HSSFCell cell =row.getCell(j);
				if (cell == null)
				{
				  continue; 
				}
				else if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
	            {
				String Value = cell.getStringCellValue();			
				localArray1[i][j] = Value;
	            }
				else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
	            {
					double num = cell.getNumericCellValue();
	                int num1 = Double.valueOf(num).intValue();
	                String num2 = Integer.toString(num1);
	                localArray1[i][j] = num2;
	            }
													
			}
					
			}	
		
	
		@SuppressWarnings("static-access")
		public static String fetchCell(int num,int row, int i) throws Exception {
			try{
			File oxlFile = new File(Path_TestData+File_TestData);
			FileInputStream oTestDataStream = new FileInputStream(oxlFile);
			HSSFWorkbook xlWorkBook = new HSSFWorkbook(oTestDataStream);
			HSSFSheet xlSheet = xlWorkBook.getSheetAt(num);	
				
				
			//HSSFRow Row = xlSheet.getRow(row);
			//HSSFCell  cell = Row.getCell(i);
				cell = xlSheet.getRow(row).getCell((short) i);
			String cellData=cell.getStringCellValue();
			
		if (cell.getCellType() != cell.CELL_TYPE_BLANK) {
		    System.out.println("Value "+cell.getStringCellValue());
		}
		return cellData;		
	}
		  catch (Exception e){

              return"";

            }
}
		
		@SuppressWarnings("static-access")
		public static String xmlStatus(int num,int row, int i) throws Exception {
			try{
			File oxlFile = new File(TestNGPath);
			FileInputStream oTestDataStream = new FileInputStream(oxlFile);
			HSSFWorkbook xlWorkBook = new HSSFWorkbook(oTestDataStream);
			HSSFSheet xlSheet = xlWorkBook.getSheetAt(num);	
				
				
			//HSSFRow Row = xlSheet.getRow(row);
			//HSSFCell  cell = Row.getCell(i);
				cell = xlSheet.getRow(row).getCell((short) i);
			String cellData=cell.getStringCellValue();
			
		if (cell.getCellType() != cell.CELL_TYPE_BLANK) {
		    System.out.println(" "+cell.getStringCellValue());
		}
		return cellData;		
	}
		  catch (Exception e){

              return"";

            }
  }
		
		@SuppressWarnings("static-access")
		public static boolean excelStatus(int num,int row, int i) throws Exception {
			try{
			File oxlFile = new File(TestNGPath);
			FileInputStream oTestDataStream = new FileInputStream(oxlFile);
			HSSFWorkbook xlWorkBook = new HSSFWorkbook(oTestDataStream);
			HSSFSheet xlSheet = xlWorkBook.getSheetAt(num);	
				
				
			//HSSFRow Row = xlSheet.getRow(row);
			//HSSFCell  cell = Row.getCell(i);
				cell = xlSheet.getRow(row).getCell((short) i);
			//@SuppressWarnings("unused")
			String cellData=cell.getStringCellValue();
			
		if (cell.getCellType() != cell.CELL_TYPE_BLANK) {
		    System.out.println(" "+cell.getStringCellValue());
		}
		return true;		
	}
		  catch (Exception e){

            //  return"";

            }
			return false;
  }
				
		@SuppressWarnings("static-access")
		public static String configDetails(int num,int row, int i) throws Exception {
			try{			
				File oxlFile = new File(ExcelPath);
				FileInputStream oTestDataStream = new FileInputStream(oxlFile);
				HSSFWorkbook xlWorkBook = new HSSFWorkbook(oTestDataStream);
				HSSFSheet xlSheet = xlWorkBook.getSheetAt(num);					
				//HSSFRow Row = xlSheet.getRow(row);
				//HSSFCell  cell = Row.getCell(i);
					cell = xlSheet.getRow(row).getCell((short) i);
				String cellData=cell.getStringCellValue();
				
			if (cell.getCellType() != cell.CELL_TYPE_BLANK) {
			    System.out.println(" "+cell.getStringCellValue());
			}
			return cellData;		
		}
			  catch (Exception e){

	              return"";

	            }
	  }


			
					
}
