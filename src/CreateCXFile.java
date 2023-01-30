import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * TODO
 * @author sby
 * @date 2022/8/22 18:09
 */
public class CreateCXFile {

    public static void main(String[] args) throws IOException {
        for (int i = 24; i <= 30; i++) {
            for (int j = 1; j <= 12; j++) {
                String month = i + "";
                if (j < 10) {
                    month += "0";
                }
                month += j;
//                createStopPoint(month);
//                createPosition(month);
//                createPositionACT(month);
//                createPositionStatics(month);
            }
        }
    }

    private static void createPositionStatics(String month) throws IOException {
        File f1 = new File("/Users/sgz/Downloads/PositionStatics/PositionStatics_" + month + ".java");
        if (!f1.exists()) {
            f1.createNewFile();
        }
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f1, true), "GBK"));
        StringBuilder sb = new StringBuilder();
        sb.append("package co.chexiao.phoenix.position;");
        sb.append("\n\n");
        sb.append("import co.chexiao.db.mysql.dao.annotation.Table;");
        sb.append("\n\n");
        sb.append("@Table(name = \"t_gpsdata_position_statistic_" + month + "\")");
        sb.append("\n");
        sb.append("public class PositionStatics_" + month + " extends PositionStatics_1901 {");
        sb.append("\n");
        sb.append("}");
        w.write(sb.toString());   //一次性写入文件中
        w.flush();      //清除缓冲区
        w.close();      //关闭流
    }

    private static void createPositionACT(String month) throws IOException {
        File f1 = new File("/Users/sgz/Downloads/Position_ACT/Position_ACT_" + month + ".java");
        if (!f1.exists()) {
            f1.createNewFile();
        }
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f1, true), "GBK"));
        StringBuilder sb = new StringBuilder();
        sb.append("package co.chexiao.phoenix.position;");
        sb.append("\n\n");
        sb.append("import co.chexiao.db.mysql.dao.annotation.Table;");
        sb.append("\n\n");
        sb.append("@Table(name = \"t_gpsdata_position_act_" + month + "\")");
        sb.append("\n");
        sb.append("public class Position_ACT_" + month + " extends Position_ACT_1802 {");
        sb.append("\n");
        sb.append("}");
        w.write(sb.toString());   //一次性写入文件中
        w.flush();      //清除缓冲区
        w.close();      //关闭流
    }

    private static void createPosition(String month) throws IOException {
        File f1 = new File("/Users/sgz/Downloads/Position/Position_" + month + ".java");
        if (!f1.exists()) {
            f1.createNewFile();
        }
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f1, true), "GBK"));
        StringBuilder sb = new StringBuilder();
        sb.append("package co.chexiao.phoenix.position;");
        sb.append("\n\n");
        sb.append("import co.chexiao.db.mysql.dao.annotation.Table;");
        sb.append("\n\n");
        sb.append("@Table(name = \"t_gpsdata_position_" + month + "\")");
        sb.append("\n");
        sb.append("public class Position_" + month + " extends Position_1802 {");
        sb.append("\n");
        sb.append("}");
        w.write(sb.toString());   //一次性写入文件中
        w.flush();      //清除缓冲区
        w.close();      //关闭流
    }

    private static void createStopPoint(String month) throws IOException {
        File f1 = new File("/Users/sgz/Downloads/StopPoint/StopPoint_" + month + ".java");
        if (!f1.exists()) {
            f1.createNewFile();
        }
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f1, true), "GBK"));
        StringBuilder sb = new StringBuilder();
        sb.append("package co.chexiao.phoenix.stoppiont;");
        sb.append("\n\n");
        sb.append("import co.chexiao.db.mysql.dao.annotation.Table;");
        sb.append("\n\n");
        sb.append("@Table(name = \"t_gpsdata_stop_point_" + month + "\")");
        sb.append("\n");
        sb.append("public class StopPoint_" + month + " extends StopPoint_1802 {");
        sb.append("\n");
        sb.append("}");
        w.write(sb.toString());   //一次性写入文件中
        w.flush();      //清除缓冲区
        w.close();      //关闭流
    }


}
