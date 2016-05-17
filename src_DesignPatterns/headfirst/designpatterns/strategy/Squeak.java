package headfirst.designpatterns.strategy;
/**
 * 另一类发生器，这样就更丰富多彩了
 * @author FAN
 *
 */
public class Squeak implements QuackBehavior {
	public void quack() {
		System.out.println("Squeak");
	}
}
