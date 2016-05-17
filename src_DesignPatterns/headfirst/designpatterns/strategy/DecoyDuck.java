package headfirst.designpatterns.strategy;

/**
 * 这是一只诱饵鸭，不会飞，不会出声
 * @author FAN
 *
 */
public class DecoyDuck extends Duck {
	//我们继承了鸭子本体，现在它是一只鸭子了，不过诱饵鸭该组装些什么进去呢？
	public DecoyDuck() {
		setFlyBehavior(new FlyNoWay());  
		setQuackBehavior(new MuteQuack());
	}
	//我是诱饵鸭
	public void display() {
		System.out.println("I'm a duck Decoy");
	}
}
