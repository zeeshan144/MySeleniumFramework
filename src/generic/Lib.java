package generic;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Lib implements IAutoConstant{

	public static FileInputStream fis;
	public static Workbook wb;
	public static String getProperty(String key){
		String propertyValue="";
		try {
			fis=new FileInputStream(CONFIG_PATH);
			Properties prop=new Properties();
			prop.load(fis);
			propertyValue = prop.getProperty(key);
		} catch (Exception e) {
		}
		return propertyValue;
	}

	public static String getCellValue(String sheet,int row,int column){
		String cellValue="";
		try {
			fis=new FileInputStream(EXCEL_PATH);
			wb = WorkbookFactory.create(fis);
			cellValue = wb.getSheet(sheet).getRow(row).getCell(column).toString();
		} catch (Exception e) {
		}
		return cellValue;
	}
	public static int getRowCount(String sheet){
		int rowCount=0;
		try {
			fis=new FileInputStream(EXCEL_PATH);
			wb = WorkbookFactory.create(fis);
			rowCount = wb.getSheet(sheet).getLastRowNum();
		} catch (Exception e) {
		}
		return rowCount;
	}

	public static void captureScreenshot(WebDriver driver,String testMethodName){
		try {
			TakesScreenshot ts=(TakesScreenshot) driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			File destFile=new File("./screenshots/" +testMethodName+".png");


			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

