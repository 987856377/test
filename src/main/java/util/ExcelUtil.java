package util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class ExcelUtil {
	
	private static POIFSFileSystem fs;
    private static Workbook wb;
    private static Sheet sheet;
    private static Row row;

	/**
	 * 创建excel文档，
	 * @param list 数据
	 * @param keys list中map的key数组集合
	 * @param columnNames excel的列名
	 * */
	public static Workbook createWorkBook(List<Map<String, Object>> list, String[] keys, String columnNames[], Workbook wb) {
		// 创建第一个sheet（页），并命名
		Sheet sheet = wb.createSheet(list.get(0).get("sheetName").toString());
		// 手动设置列宽。第一个参数表示要为第几列设；，第二个参数表示列的宽度，n为列高的像素数。
		for (int i = 0; i < keys.length; i++) {
			sheet.setColumnWidth((short) i, (short) (35.7 * 150));
		}
		
		// 创建第一行
		Row row = sheet.createRow((short) 0);

		// 创建两种单元格格式
		CellStyle cs = wb.createCellStyle();
		CellStyle cs2 = wb.createCellStyle();

		// 创建两种字体
		Font f = wb.createFont();
		Font f2 = wb.createFont();

		// 创建第一种字体样式（用于列名）
		f.setFontHeightInPoints((short) 10);
		f.setColor(IndexedColors.BLACK.getIndex());
		f.setBoldweight(Font.BOLDWEIGHT_BOLD);

		// 创建第二种字体样式（用于值）
		f2.setFontHeightInPoints((short) 10);
		f2.setColor(IndexedColors.BLACK.getIndex());

		// 设置第一种单元格的样式（用于列名）
		cs.setFont(f);
		cs.setBorderLeft(CellStyle.BORDER_THIN);
		cs.setBorderRight(CellStyle.BORDER_THIN);
		cs.setBorderTop(CellStyle.BORDER_THIN);
		cs.setBorderBottom(CellStyle.BORDER_THIN);
		cs.setAlignment(CellStyle.ALIGN_CENTER);

		// 设置第二种单元格的样式（用于值）
		cs2.setFont(f2);
		cs2.setBorderLeft(CellStyle.BORDER_THIN);
		cs2.setBorderRight(CellStyle.BORDER_THIN);
		cs2.setBorderTop(CellStyle.BORDER_THIN);
		cs2.setBorderBottom(CellStyle.BORDER_THIN);
		cs2.setAlignment(CellStyle.ALIGN_CENTER);
		//设置列名
		for (int i = 0; i < columnNames.length; i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(columnNames[i]);
			cell.setCellStyle(cs);
		}
		//设置每行每列的值
		for (short i = 1; i < list.size(); i++) {
			// Row 行,Cell 方格 , Row 和 Cell 都是从0开始计数的
			// 创建一行，在页sheet上
			Row row1 = sheet.createRow((short) i);
			// 在row行上创建一个方格
			for (short j = 0; j < keys.length; j++) {
				Cell cell = row1.createCell(j);
				cell.setCellValue(list.get(i).get(keys[j]) == null ? " " : list.get(i).get(keys[j]).toString());
				cell.setCellStyle(cs2);
			}
		}
		return wb;
	}
	
	/**
	 * 读excel内容,不包括标题
	 * @param is inputSteam
	 * @param type 1:xls 2:xlsx
	 * @param startLine 从第几行开始读
	 * @param feilds 对应model中的字段名称,注意顺序
	 * @return 解析后的json字串
	 */
	@SuppressWarnings("deprecation")
	public static String readWorkBook(InputStream is,int type,int startLine,String ...feilds ) {
	        StringBuffer resStr=new StringBuffer("[");
	        try {
	            if(type==1){
	            	fs = new POIFSFileSystem(is);
	            	wb = new HSSFWorkbook(fs);
	            }
	            if(type==2){
	            	wb = new XSSFWorkbook(is);
	            }	
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        sheet =  wb.getSheetAt(0);
	        // 得到总行数
	        int rowNum = sheet.getLastRowNum();
	        row = sheet.getRow(0);
	        int colNum = row.getPhysicalNumberOfCells();
	        // 正文内容应该从第二行开始,第一行为表头的标题
	        
	        
	        for (int i=startLine; i <= rowNum; i++) {
//	        	if(i==1){ //type=1时跳过第一行
//	        		i=startLine;
//	        	}
	            row = sheet.getRow(i);
	            int j = 0;
	            	resStr.append("{");
	            while (j < colNum) {
	                	resStr.append("\""+feilds[j]+"\":\"").append(getCellFormatValue(row.getCell((short) j)).trim()).append("\",");
	                j++;
	            }
	            	resStr.deleteCharAt(resStr.length()-1).append("},");
	        }
	        
	        return resStr.deleteCharAt(resStr.length()-1).append("]").toString();
	    }

	   
	    /**
	     * 根据HSSFCell类型设置数据
	     * @param cell
	     * @return
	     */
	    private static String getCellFormatValue(Cell cell) {
	        String cellvalue = "";
	        if (cell != null) {
	            // 判断当前Cell的Type
	            switch (cell.getCellType()) {
	            // 如果当前Cell的Type为NUMERIC
	            case HSSFCell.CELL_TYPE_NUMERIC:
	            case HSSFCell.CELL_TYPE_FORMULA: {
	                // 判断当前的cell是否为Date
	                if (HSSFDateUtil.isCellDateFormatted(cell)) {
	                    // 如果是Date类型则，转化为Data格式
	                    
	                    //方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
	                    //cellvalue = cell.getDateCellValue().toLocaleString();
	                    
	                    //方法2：这样子的data格式是不带带时分秒的：2011-10-12
	                    Date date = cell.getDateCellValue();
	                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	                    cellvalue = sdf.format(date);
	                    
	                }
	                // 如果是纯数字
	                else {
	                    // 取得当前Cell的数值
	                    cellvalue = String.valueOf((int)cell.getNumericCellValue());
	                }
	                break;
	            }
	            // 如果当前Cell的Type为STRIN
	            case HSSFCell.CELL_TYPE_STRING:
	                // 取得当前的Cell字符串
	                cellvalue = cell.getRichStringCellValue().getString();
	                break;
	            // 默认的Cell值
	            default:
	                cellvalue = " ";
	            }
	        } else {
	            cellvalue = "";
	        }
	        return cellvalue;

	    }
	    
	    public static void main(String[] args) {
	        try {
	            
	            // 对读取Excel表格内容测试
	        //	AppointDepartment appointDepartment=new AppointDepartment();
	            InputStream is1 = new FileInputStream("d:\\template_dept.xls");
	            InputStream is2 = new FileInputStream("d:\\医院管理.xlsx");
	           String res= readWorkBook(is1,1,1,"deptcode","deptname","parentcode","infomation");
	           // Map<Integer, String> map = readWorkBook<>(is2,,"deptcode","deptname","parentcode","infomation");
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	    
}











