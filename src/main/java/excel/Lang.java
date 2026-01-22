package excel;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 * @author sby
 * @date 2025/11/6 09:53
 */
public class Lang {
    public static void main(String[] args) throws Exception {
        Map<String, String> map = new HashMap<>();
        // 全部对应关系
        List<Map<String, String>> allList = new ArrayList<>();
        // 需要创建的对应关系
        List<Map<String, String>> createList = new ArrayList<>();
        int codeStart = 500;

        System.out.println("读取现有翻译开始...");
        XSSFWorkbook xssfWorkbook1 = new XSSFWorkbook(new File("/Users/sgz/Downloads/BTI翻译/数据库最新翻译.xlsx"));
        XSSFSheet xssfSheet1 = xssfWorkbook1.getSheetAt(0);
        int rowStart1 = xssfSheet1.getFirstRowNum();
        int rowEnd1 = xssfSheet1.getLastRowNum();
        for (int i = rowStart1; i <= rowEnd1; i++) {
            try {
                XSSFRow row = xssfSheet1.getRow(i);
                if (row == null) {
                    continue;
                }

                String code = row.getCell(0).getStringCellValue();
                String message = row.getCell(1).getStringCellValue();
                map.put(message, code);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("读取现有翻译结束...");

        System.out.println("读取待翻译开始...");
        int maxLength = 0;
        XSSFWorkbook xssfWorkbook2 = new XSSFWorkbook(new File("/Users/sgz/Downloads/BTI翻译/BTI中文翻译统计_20251224.xlsx"));
        XSSFSheet xssfSheet2 = xssfWorkbook2.getSheetAt(0);
        int rowStart2 = xssfSheet2.getFirstRowNum();
        int rowEnd2 = xssfSheet2.getLastRowNum();
        for (int i = rowStart2; i <= rowEnd2; i++) {
            try {
                XSSFRow row = xssfSheet2.getRow(i);
                if (row == null) {
                    continue;
                }

                String message = row.getCell(0).getStringCellValue();
                if (message.length() > maxLength) {
                    maxLength = message.length();
                }
                if (map.containsKey(message)) {
                    allList.add(new HashMap<String, String>() {{
                        put("code", map.get(message));
                        put("message", message);
                    }});
                } else {
                    String code;
                    if (codeStart >= 1000) {
                        code = "N00" + codeStart;
                    } else {
                        code = "N000" + codeStart;
                    }
                    codeStart++;
                    allList.add(new HashMap<String, String>() {{
                        put("code", code);
                        put("message", message);
                    }});
                    createList.add(new HashMap<String, String>() {{
                        put("code", code);
                        put("message", message);
                    }});
                    map.put(message, code);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("读取待翻译结束...maxLength=" + maxLength);

        System.out.println("创建前端翻译开始...");
        XSSFWorkbook outworkbook1 = new XSSFWorkbook();
        XSSFSheet outsheet1 = outworkbook1.createSheet("Sheet1");
        for (int i = 0; i < allList.size(); i++) {
            Map<String, String> stringMap = allList.get(i);
            XSSFRow outrow1 = outsheet1.createRow(i);
            outrow1.createCell(0).setCellValue(stringMap.get("code"));
            outrow1.createCell(1).setCellValue(stringMap.get("message"));
        }
        FileOutputStream out1 = new FileOutputStream("/Users/sgz/Downloads/BTI翻译/前端翻译对应code.xlsx");
        outworkbook1.write(out1);
        out1.close();
        System.out.println("创建前端翻译结束...");

        System.out.println("创建不存在的翻译开始...");
        XSSFWorkbook outworkbook2 = new XSSFWorkbook();
        XSSFSheet outsheet2 = outworkbook2.createSheet("Sheet1");
        for (int i = 0; i < createList.size(); i++) {
            Map<String, String> stringMap = createList.get(i);
            XSSFRow outrow2 = outsheet2.createRow(i);
            outrow2.createCell(0).setCellValue(stringMap.get("code"));
            outrow2.createCell(1).setCellValue(stringMap.get("message"));
        }
        FileOutputStream out2 = new FileOutputStream("/Users/sgz/Downloads/BTI翻译/前端需要创建的对应关系.xlsx");
        outworkbook2.write(out2);
        out2.close();
        System.out.println("创建不存在的翻译结束...");

    }
}
