package headfirst.designpatterns.strategy;
/**
 * 会喷火发射而增加动力的翅膀哦
 * @author FAN
 *
 */
public class FlyRocketPowered implements FlyBehavior {
	public void fly() {
		System.out.println("I'm flying with a rocket");
	}
}
