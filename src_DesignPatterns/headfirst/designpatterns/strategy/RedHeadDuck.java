package headfirst.designpatterns.strategy;
/**
 * ����������¿ͷѼ��Ҳ�к�ͷѼ��
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
