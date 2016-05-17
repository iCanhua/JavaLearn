package headfirst.designpatterns.strategy;
/**
 * 发声行为组装接口，你得把一只鸭子的发声器通过这个接口的约定装进任何你想要装进的鸭子里面去，甚至可以换！
 * @author FAN
 *
 */
public interface QuackBehavior {
	public void quack();
}
