package headfirst.designpatterns.strategy;
/**
 * 这是一只绿头鸭，非常活生生，会飞会叫，真的鸭子
 * @author FAN
 *
 */
public class MallardDuck extends Duck {

	public MallardDuck() {

		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();

	}

	public void display() {
		System.out.println("I'm a real Mallard duck");
	}
}
