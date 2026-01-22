package excel;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 去重
 * @author sby
 * @date 2025/11/6 09:53
 */
public class DelLang {
    public static void main(String[] args) throws Exception {
        Map<String, String> map = new HashMap<>();
        // 需要创建的对应关系
        Map<String, List<String>> createMap = new TreeMap<>();

        System.out.println("读取现有翻译开始...");
        XSSFWorkbook xssfWorkbook1 = new XSSFWorkbook(new File("/Users/sgz/Downloads/海外贸易翻译/去重/中文全部翻译.xlsx"));
        XSSFSheet xssfSheet1 = xssfWorkbook1.getSheetAt(0);
        int rowStart1 = xssfSheet1.getFirstRowNum();
        int rowEnd1 = xssfSheet1.getLastRowNum();
        for (int i = rowStart1; i <= rowEnd1; i++) {
            try {
                XSSFRow row = xssfSheet1.getRow(i);
                if (row == null) {
                    continue;
                }

                String code = row.getCell(2).getStringCellValue();
                String message = row.getCell(3).getStringCellValue();

                if (map.containsKey(message)) {
                    List<String> list = createMap.get(message);
                    if (list == null) {
                        list = new java.util.ArrayList<>();
                        list.add(map.get(message));
                        list.add(code);
                        createMap.put(message, list);
                    } else {
                        list.add(code);
                    }
                } else {
                    map.put(message, code);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("读取现有翻译结束...");


        System.out.println("创建重复翻译开始...");
        XSSFWorkbook outworkbook1 = new XSSFWorkbook();
        XSSFSheet outsheet1 = outworkbook1.createSheet("Sheet1");

        final int[] rowNum = {0};
        createMap.forEach((message, list) -> {
            int j = 0;
            for (String code : list) {
                XSSFRow outrow1 = outsheet1.createRow(rowNum[0]);
                if (j == 0) {
                    outrow1.createCell(0).setCellValue(message);
                    outrow1.createCell(1).setCellValue(code);
                } else {
                    outrow1.createCell(0).setCellValue("");
                    outrow1.createCell(1).setCellValue("");
                    outrow1.createCell(2).setCellValue(code);
                }

                j++;
                rowNum[0]++;
            }
        });
        FileOutputStream out1 = new FileOutputStream("/Users/sgz/Downloads/重复翻译统计.xlsx");
        outworkbook1.write(out1);
        out1.close();
        System.out.println("创建重复翻译结束...");

    }
}
