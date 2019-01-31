package designPattern.templatemethod;

/**
 * @author sby
 * @Title: XMLDataViewer
 * @Description: XML数据展示类
 * @date 2019/1/31 16:21
 */
public class XMLDataViewer extends DataViewer {

    @Override
    public void getDatas() {
        System.out.println("获取XML数据");
    }

    @Override
    public void displayDatas() {
        System.out.println("柱状图展示XML数据");
    }

    @Override
    public boolean isNotXML() {
        return false;
    }
}
