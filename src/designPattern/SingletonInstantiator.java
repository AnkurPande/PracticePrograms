package designPattern;

public class SingletonInstantiator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassicSingleton instance = ClassicSingleton.getInstance();
		instance.incrementNumberOfInstances();
		System.out.println(instance.getNumberOfinstances());
		ClassicSingleton instance1 = ClassicSingleton.getInstance();
		instance1.incrementNumberOfInstances();
		System.out.println(instance1.getNumberOfinstances());
	}

}
