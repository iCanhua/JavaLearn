package headfirst.designpatterns.strategy;
/**
 * ����Ѽ�ӵ����л��࣬����Ѽ�Ӽ̳�����࣬ʹ�����Ǹ�Ѽ��
 * @author FAN
 *
 */
public abstract class Duck {
	//��Ϊ������Ϊ��Ϊ���ӿڡ����ͣ���Ϊ��ֻѼ�ӵ���Ϊ����Ҫ��װ�ģ�������һ����ô����Ѽ�Ӿ���װ��ʲô����Ѽ��
	FlyBehavior flyBehavior;        //������Ϊ
	QuackBehavior quackBehavior;       //���ɽ���Ϊ

	public Duck() {
	}

	public void setFlyBehavior(FlyBehavior fb) {
		flyBehavior = fb;
	}

	public void setQuackBehavior(QuackBehavior qb) {
		quackBehavior = qb;
	}
	//���
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
