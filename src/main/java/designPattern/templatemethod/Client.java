package designPattern.templatemethod;

/**
 * @author sby
 * @Title: Client
 * @Description: 模版方法
 * @date 2019/1/31 16:25
 */
public class Client {

    public static void main(String[] args) {
        DataViewer dataViewer = new XMLDataViewer();
        dataViewer.process();

        dataViewer = new DocDataViewer();
        dataViewer.process();
    }
}
