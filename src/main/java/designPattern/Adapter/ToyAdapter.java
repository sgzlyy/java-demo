package designPattern.Adapter;

/**
 * @author sby
 * @Title: ToyAdapter
 * @Description: TODO
 * @date 2019/1/23 14:19
 */
public class ToyAdapter extends Toy {

    Light light;
    Sound sound;

    ToyAdapter() {
        light = new Light();
        sound = new Sound();
    }


    @Override
    public void lightOn() {
        light.turnOn();
    }

    @Override
    public void soundOn() {
        sound.turnOn();
    }
}
