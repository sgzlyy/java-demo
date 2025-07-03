package designPattern.Composite;

/**
 * @author sby
 * @Title: Client
 * @Description: 组合模式
 * @date 2019/1/23 17:13
 */
public class Client {

    public static void main(String[] args) {
        AbstractModel org1, org2, org3, org4, person, person1, person2, person3, person4, person5;


        org1 = new Org("北京总部");
        org2 = new Org("湖北分校");
        org3 = new Org("湖南分校");
        org4 = new Org("长沙教学点");

        person = new Person("北京大大");
        person1 = new Person("湖南小明");
        person2 = new Person("湖南小红");
        person3 = new Person("湖北小小");
        person4 = new Person("长沙小臭");
        person5 = new Person("长沙大臭");

        ((Org) org4).add(person4);
        ((Org) org4).add(person5);
        ((Org) org3).add(person2);
        ((Org) org3).add(person1);
        ((Org) org2).add(person3);
        ((Org) org1).add(person);

        ((Org) org3).add(org4);

        ((Org) org1).add(org2);
        ((Org) org1).add(org3);

        org1.sendMsg();
    }
}
