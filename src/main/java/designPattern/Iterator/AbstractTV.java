package designPattern.Iterator;

import java.util.List;

/**
 * @author sby
 * @Title: AbstractTV
 * @Description: 抽象电视类
 * @date 2019/1/30 15:51
 */
public abstract class AbstractTV {

    private List<Channel> channels;

    AbstractTV(List<Channel> channels) {
        this.channels = channels;
    }

    public void addChannel(Channel channel) {
        channels.add(channel);
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public abstract AbstractIterator createIterator();
}
