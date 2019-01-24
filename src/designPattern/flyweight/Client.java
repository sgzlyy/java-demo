package designPattern.flyweight;

/**
 * @author sby
 * @Title: Client
 * @Description: TODO
 * @date 2019/1/24 17:41
 */
public class Client {
    public static void main(String[] args) {
        IgoChessmanFactory igoChessmanFactory = IgoChessmanFactory.getInstance();
        IgoChessman wIgoChessman1 = igoChessmanFactory.getIgoChessman("w");
        IgoChessman wIgoChessman2 = igoChessmanFactory.getIgoChessman("w");

        IgoChessman bIgoChessman1 = igoChessmanFactory.getIgoChessman("b");
        IgoChessman bIgoChessman2 = igoChessmanFactory.getIgoChessman("b");

        System.out.println(wIgoChessman1 == wIgoChessman2);
        System.out.println(bIgoChessman1 == bIgoChessman2);

        wIgoChessman1.display();
        wIgoChessman2.display();
        bIgoChessman1.display();
        bIgoChessman2.display();
    }
}
