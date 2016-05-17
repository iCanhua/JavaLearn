package headfirst.designpatterns.strategy;
/**
 * 这是鸭子的所有基类，所有鸭子继承这个类，使得它是个鸭子
 * @author FAN
 *
 */
public abstract class Duck {
	//行为被声明为行为“接口”类型，因为这只鸭子的行为是需要组装的，想做成一个怎么样的鸭子就组装成什么样的鸭子
	FlyBehavior flyBehavior;        //飞行行为
	QuackBehavior quackBehavior;       //呱呱叫行为

	public Duck() {
	}

	public void setFlyBehavior(FlyBehavior fb) {
		flyBehavior = fb;
	}

	public void setQuackBehavior(QuackBehavior qb) {
		quackBehavior = qb;
	}
	//外观
	abstract void display();

	public void performFly() {
		flyBehavior.fly();
	}

	public void performQuack() {
		quackBehavior.quack();
	}

	public void swim() {
		System.out.println("All ducks float, even decoys!");
	}
}
