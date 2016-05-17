package headfirst.designpatterns.strategy;
/**
 * 飞行行为组装接口，你得把一只鸭子的翅膀通过这个接口的约定装进任何你想要装进的鸭子里面去，甚至可以换！
 * @author FAN
 *
 */
public interface FlyBehavior {
	public void fly();
}
