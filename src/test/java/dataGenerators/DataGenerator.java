package dataGenerators;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class DataGenerator {

    @DataProvider(name = "Excel")
    public static Object[][] testDataGenerator(Method method) throws IOException {
        if (method.getName().equalsIgnoreCase("tc001_search_stock")) {
            FileInputStream fileInputStream = new FileInputStream("./TestData.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheet("CompanyStocks");
            int numberOfCompanies = sheet.getPhysicalNumberOfRows();
            Object[][] companies = new Object[numberOfCompanies][1];
            for (int i = 1; i < numberOfCompanies; i++) {
                XSSFRow row = sheet.getRow(i);
                XSSFCell company = row.getCell(0);
                companies[i][0] = company.getStringCellValue();
            }
            return companies;
        } else {
            Object[][] testData = new Object[0][0];
            return testData;
        }
    }
}
