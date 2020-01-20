package utils;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.Random;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utils {

	public Utils() {
	}

	public String generateString(int l) {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString();

		System.out.println(generatedString);

		return generatedString;

	}

	public int generateSeverity(int lenght) {
		int randomNum = 1 + (int) (Math.random() * 10);
		return randomNum;

	}

//	_____________________________________USER NAME_____________________________________________________
	public String getUserName() {
		return configData("userNameXml");

	}
//	_____________________________________USER NAME END_____________________________________________________
//	_____________________________________USER PASSWORD_____________________________________________________

	public String getUserPassword() {
		return configData("passwordXml");

	}
//	_____________________________________USER PASSWORD END_____________________________________________________
//	_____________________________________URL___________________________________________________________________

	public String getUrl() {
		return configData("urlXml");
	}

	public String configData(String l) {
		try {
			File File = new File("D:\\Mokslai BIT\\Testavimas\\Eclipse IDE\\MavenProject\\config\\config.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(File);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("config");
			Node nNode = nList.item(0);
	
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;

				return eElement.getElementsByTagName(l).item(0).getTextContent();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

//___________________________________________READ xlsx Files___________________________________________________
//
//	public List<String> readLoginBadPasswords() {
//		List<String> al = new ArrayList();
//		try {
//            File file = new File("test-data\\login.xlsx"); // creating a new file instance
//            FileInputStream fis = new FileInputStream(file); // obtaining bytes from the file
//            // creating Workbook instance that refers to .xlsx file
//            XSSFWorkbook wb = new XSSFWorkbook(fis);
//            XSSFSheet sheet = wb.getSheetAt(0); // creating a Sheet object to retrieve object
//            Iterator<Row> itr = sheet.iterator(); // iterating over excel file
//            while (itr.hasNext()) {
//                Row row = itr.next();
//                Iterator<Cell> cellIterator = row.cellIterator(); // iterating over each column
//                while (cellIterator.hasNext()) {
//                    Cell cell = cellIterator.next();
//                    switch (cell.getCellType()) {
//                    case Cell.CELL_TYPE_STRING: // field that represents string cell type
//                        System.out.print("password is:" + cell.getStringCellValue() + "\t\t\t");
//                        al.add(cell.getStringCellValue());
//                        break;
//                    case Cell.CELL_TYPE_NUMERIC: // field that represents number cell type
//                        System.out.print(cell.getNumericCellValue() + "\t\t\t");
//                        break;
//                    default:
//                    }
//                }
//            }
//            wb.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return al;
//    }
}

