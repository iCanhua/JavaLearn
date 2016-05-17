package headfirst.designpatterns.strategy;
/**
 * 这个世界除了驴头鸭，也有红头鸭！
 * @author FAN
 *
 */
public class RedHeadDuck extends Duck {
 
	public RedHeadDuck() {
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	}
 
	public void display() {
		System.out.println("I'm a real Red Headed duck");
	}
}
