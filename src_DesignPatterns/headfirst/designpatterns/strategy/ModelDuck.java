package headfirst.designpatterns.strategy;
/**
 * ģ��Ѽ����в����
 * @author FAN
 *
 */
public class ModelDuck extends Duck {
	public ModelDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Quack();
	}

	public void display() {
		System.out.println("I'm a model duck");
	}
}
