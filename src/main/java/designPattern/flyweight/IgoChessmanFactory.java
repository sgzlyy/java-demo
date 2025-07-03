package designPattern.flyweight;

import java.util.HashMap;

/**
 * @author sby
 * @Title: IgoChessmanFactory
 * @Description: TODO
 * @date 2019/1/24 17:36
 */
public class IgoChessmanFactory {

    private static IgoChessmanFactory instance = new IgoChessmanFactory();
    private HashMap<String, IgoChessman> map;

    private IgoChessmanFactory() {
        map = new HashMap<>();

        IgoChessman whiteIgoChessman = new WhiteIgoChessman();
        map.put("w", whiteIgoChessman);

        IgoChessman blackIgoChessman = new BlackIgoChessman();
        map.put("b", blackIgoChessman);
    }

    public static IgoChessmanFactory getInstance() {
        return instance;
    }

    public IgoChessman getIgoChessman(String color) {
        return map.get(color);
    }
}
