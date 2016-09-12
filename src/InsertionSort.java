
import java.util.Random;


public class InsertionSort {

	private int[] numbers ;
	
	private void fillArray(int size){
		numbers = new int[size];
		int j = size-1;
		Random randomGenerator = new Random();
	//	randomGenerator.setSeed(20);
		while( j>=0){
			numbers[j] = randomGenerator.nextInt(1000) ;
			j--;
		}
	}
	
	public void display(){
		System.out.println();
		for(int element:numbers){
			System.out.print(element+" ");
		}
	}
	
	private void sort(){
				
		for(int i =1; i<numbers.length; i++){
			int temp = numbers[i];
			
			int k = i;
			while(k>0 && numbers[k-1]>temp){
				numbers[k] = numbers[k-1];
				k--;
			}
			numbers[k] =temp;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InsertionSort sortRandomArray = new InsertionSort();
		sortRandomArray.fillArray(40);
		sortRandomArray.display();
		sortRandomArray.sort();
		sortRandomArray.display();
	}

}
