package designPattern.templatemethod;

/**
 * @author sby
 * @Title: DataViewer
 * @Description: 数据展示类
 * @date 2019/1/31 16:17
 */
public abstract class DataViewer {

    public abstract void getDatas();

    public void convertDatas() {
        System.out.println("将数据转换成XML格式");
    }

    public abstract void displayDatas();

    public boolean isNotXML() {
        return true;
    }

    public void process() {
        getDatas();

        if (isNotXML()) {
            convertDatas();
        }

        displayDatas();
    }
}
