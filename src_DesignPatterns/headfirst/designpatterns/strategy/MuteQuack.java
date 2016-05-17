package headfirst.designpatterns.strategy;
/**
 * 用来被组装的发生器，鸭舌？、、、
 * @author FAN
 *
 */
public class MuteQuack implements QuackBehavior {
	public void quack() {
		System.out.println("<< Silence >>");
	}
}
