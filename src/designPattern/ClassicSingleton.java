package designPattern;

public final class ClassicSingleton {
	private static ClassicSingleton instance = null;
	private int incrementNumberOfInstances =0;
	
	private ClassicSingleton(){
		
	}
	
	public static ClassicSingleton getInstance(){
		if(instance == null){
			instance = new ClassicSingleton();
		}
		return instance;		
	}
	
	public void incrementNumberOfInstances(){
		incrementNumberOfInstances++;
	}
	
	public int getNumberOfinstances(){
		return incrementNumberOfInstances;
	}
}

