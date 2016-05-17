package headfirst.designpatterns.strategy;
/**
 * 额，这是一只假鸭子
 * @author FAN
 *
 */
public class FakeQuack implements QuackBehavior {
	public void quack() {
		System.out.println("Qwak");
	}
}
