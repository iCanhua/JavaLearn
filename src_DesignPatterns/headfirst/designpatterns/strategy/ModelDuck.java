package headfirst.designpatterns.strategy;
/**
 * 模型鸭，会叫不会飞
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
