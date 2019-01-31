package designPattern.templatemethod;

/**
 * @author sby
 * @Title: DocDataViewer
 * @Description: doc数据展示类
 * @date 2019/1/31 16:23
 */
public class DocDataViewer extends DataViewer {
    @Override
    public void getDatas() {
        System.out.println("获取DOC数据");
    }

    @Override
    public void displayDatas() {
        System.out.println("饼状图展示XML数据");
    }
}
