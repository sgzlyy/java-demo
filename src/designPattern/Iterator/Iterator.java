package designPattern.Iterator;

import java.util.List;

/**
 * @author sby
 * @Title: Iterator
 * @Description: 迭代器
 * @date 2019/1/30 16:00
 */
public class Iterator extends AbstractIterator {

    private int cursor = 0;

    private List<Channel> channels;

    Iterator(List<Channel> channels) {
        this.channels = channels;
    }

    @Override
    public void next() {
        Channel channel = channels.get(cursor);
        System.out.println("频道号：" + channel.getNo() + "    频道名：" + channel.getName());
        cursor++;
    }

    @Override
    public boolean hasNext() {
        return (cursor != channels.size());
    }
}
