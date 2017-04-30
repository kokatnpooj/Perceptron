package Perceptron;
//all are 10 by 10 images
public class Images {
	 private boolean[][] data;
	    private String category; 


	    public Images(boolean[][] data, String category){
	        this.data = data;
	        this.category = category;
	    }

	    public String getCategory() {
	        return category;
	    }

	    public boolean getData(int row, int col) {
	        return data[row][col];
	    }
}
