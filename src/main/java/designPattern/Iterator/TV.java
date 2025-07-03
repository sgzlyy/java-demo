package designPattern.Iterator;

import java.util.List;

/**
 * @author sby
 * @Title: TV
 * @Description: 具体电视类
 * @date 2019/1/30 15:55
 */
public class TV extends AbstractTV {

    public TV(List<Channel> channels) {
        super(channels);
    }

    @Override
    public AbstractIterator createIterator() {
        return new Iterator(this.getChannels());
    }
}
