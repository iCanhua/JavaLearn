package headfirst.designpatterns.strategy;
/**
 * ���ǲ���ɣ�������һ���˻��ĳ���
 * @author FAN
 *
 */
public class FlyNoWay implements FlyBehavior {
	public void fly() {
		System.out.println("I can't fly");
	}
}
