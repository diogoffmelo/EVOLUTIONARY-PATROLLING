package yaps.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomUtil {
	
	private static long SEED = 1613; 
	private static Random rand = new Random(SEED); 
	
	/**
	 * Randomly chooses an integer from the inclusive range "from .. to".  
	 */
	public static int chooseInteger(int from, int to) {
		return from + rand.nextInt(to-from+1);
	}

	/**
	 * Escolhe uma das posicoes do array aleatoriamente, com probabilidades 
	 * (para cada posição) proporcionais aos pesos delas. 
	 */
	public static int chooseProportionally(double[] weights) {
		double sum = 0.0d;
		for (int i = 0; i < weights.length; i++) {
			sum += weights[i];
		}
		
		double choice = sum * rand.nextDouble(); //choice is in interval [0;sum)
		
		double partialSum = 0.0d;
		for (int i = 0; i < weights.length; i++) {
			partialSum += weights[i];
			if (choice <= partialSum) {
				return i;
			}
		}
		
		return weights.length - 1; //nunca devera acontecer!
	}
	
	
	/**
	 * Escolhe um double entre zero e 1(exclusivo).
	 * 
	 */
	public static double getUniformDouble(){
		return rand.nextDouble();
	}
	
	/**
	 * Escolhe um boolean entre zero e 1(exclusivo).
	 * 
	 */
	public static boolean getHeadTailTrow(){
		return rand.nextBoolean();
	}
	
	
	public static <T> List<T> shuffle(List<T> l){
		List<T> ls = new ArrayList<T>();
		ls.addAll(l);
		Collections.shuffle(ls, rand);
		return ls;
	}


}
