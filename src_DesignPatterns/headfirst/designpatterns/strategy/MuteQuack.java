package headfirst.designpatterns.strategy;
/**
 * ��������װ�ķ�������Ѽ�ࣿ������
 * @author FAN
 *
 */
public class MuteQuack implements QuackBehavior {
	public void quack() {
		System.out.println("<< Silence >>");
	}
}
