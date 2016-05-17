package headfirst.designpatterns.strategy;

/**
 * ����һֻ�ն�Ѽ������ɣ��������
 * @author FAN
 *
 */
public class DecoyDuck extends Duck {
	//���Ǽ̳���Ѽ�ӱ��壬��������һֻѼ���ˣ������ն�Ѽ����װЩʲô��ȥ�أ�
	public DecoyDuck() {
		setFlyBehavior(new FlyNoWay());  
		setQuackBehavior(new MuteQuack());
	}
	//�����ն�Ѽ
	public void display() {
		System.out.println("I'm a duck Decoy");
	}
}
