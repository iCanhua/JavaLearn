package headfirst.designpatterns.strategy;
/**
 * ��һ�෢�����������͸��ḻ�����
 * @author FAN
 *
 */
public class Squeak implements QuackBehavior {
	public void quack() {
		System.out.println("Squeak");
	}
}
