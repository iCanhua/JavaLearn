package headfirst.designpatterns.strategy;
/**
 * 一双展翅高飞的翅膀
 * @author FAN
 *
 */
public class FlyWithWings implements FlyBehavior {
	public void fly() {
		System.out.println("I'm flying!!");
	}
}
