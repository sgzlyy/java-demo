package designPattern.Iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sby
 * @Title: Client
 * @Description: 迭代器模式
 * @date 2019/1/30 16:11
 */
public class Client {

    public static void main(String[] args) {

        List<Channel> channels = new ArrayList<>();

        Channel channel1 = new Channel();
        channel1.setNo(1);
        channel1.setName("中央1");
        channels.add(channel1);

        Channel channel2 = new Channel();
        channel2.setNo(2);
        channel2.setName("辽宁卫视");
        channels.add(channel2);

        Channel channel3 = new Channel();
        channel3.setNo(3);
        channel3.setName("湖南卫视");
        channels.add(channel3);

        AbstractTV tv = new TV(channels);
        AbstractIterator iterator = tv.createIterator();

        while (iterator.hasNext()) {
            iterator.next();
        }

    }
}
