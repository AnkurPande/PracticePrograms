import java.util.Arrays;
import java.util.Random;


public class JavaUtilArrayExample {
	
	int size = 0;
	int[] A = new int[40];
	int[] B;
	Random randomGenerator = new Random();
	
	public JavaUtilArrayExample(int size){
		this.size = size;
		B =new int[size];
	}
	
	private void fillArrayRandomly(){
		int k=0;
		for(int element:A){
			A[k] = randomGenerator.nextInt(100); 
			k++;
		}
	}
	
	private void display(int[] c){
		
		
		for(int element:c){
			System.out.print(element+" ");
		}
		System.out.println();
	}
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JavaUtilArrayExample demo = new JavaUtilArrayExample(20);
		System.out.println("Element A before Sorting.");
		
		/*Fill Array With Random VAlues.*/
		demo.fillArrayRandomly();
		demo.display(demo.A);
		
		/*Sort Array Of Random VAlues.*/
		Arrays.sort(demo.A);
		System.out.println("\nElement A After Sorting.");
		demo.display(demo.A);
		
		/*Copy VAlues Array With Random VAlues.*/
		demo.B =Arrays.copyOf(demo.A,demo.B.length);
		demo.display(demo.B);
		
		/*Copy VAlues Array With Random VAlues with range specified.*/
		demo.B = Arrays.copyOfRange(demo.A, 10, 40);
		demo.display(demo.B);
		
		//The copy method also alter the original array length to new.
		System.out.println(demo.B.length);
		
		String str = Arrays.toString(demo.B);
		System.out.println("Print B as string : "+str);
		
	}

}
