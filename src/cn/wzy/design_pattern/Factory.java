package cn.wzy.design_pattern;

/**
 * 简单工厂模式
 */
public class Factory {

	public static void main(String[] args) {
		Operator operator = OperatorFactory.getOperator("+");
		System.out.println(operator.ans(1.2,2.3));
	}
}
/**
 * 基类
 */
abstract class Operator {
	abstract double ans(double a, double b);
}
/**
 * 加法
 */
class Add extends Operator {
	@Override
	double ans(double a, double b) {
		return a + b;
	}
}
/**
 * 减法
 */
class Sub extends Operator {
	@Override
	double ans(double a, double b) {
		return a - b;
	}
}
/**
 * 工厂
 */
class OperatorFactory{
	static Operator getOperator(String name){
		switch (name){
			case "+":return new Add();
			case "-":return new Sub();
			default:return new Add();
		}
	}
}