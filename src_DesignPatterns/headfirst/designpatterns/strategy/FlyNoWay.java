package headfirst.designpatterns.strategy;
/**
 * 这是不会飞，可能是一对退化的翅膀吧
 * @author FAN
 *
 */
public class FlyNoWay implements FlyBehavior {
	public void fly() {
		System.out.println("I can't fly");
	}
}
