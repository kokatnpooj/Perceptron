package Perceptron;

import java.awt.Image;
import java.util.Random;

public class Feature {
	int [] row;
	int [] col;
	boolean [] sgn;
	public static final int imageDimensions= 10;
	public static final Random random = new Random(); 

	public Feature(){
		row = new int[4];
		col = new int[4];
		sgn = new boolean[4];

		for(int i=0; i < 4; i++){
			row[i] = random.nextInt(imageDimensions);
			col[i] = random.nextInt(imageDimensions);
			sgn[i] = random.nextBoolean();
		} 
	}

	public int check(Images image){ 
		int count = 0;
		for(int i=0; i < 4; i++){
			if(image.getData(row[i], col[i]) == sgn[i])
				count++;
		}
		if(count>=3){
			return 1;
		}
		else{
			return 0;
		}   
	}

}
