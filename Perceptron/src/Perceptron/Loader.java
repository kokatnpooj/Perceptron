package Perceptron;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loader {

    private String categoryName;

    public Loader(){
    }

    public List<Images> loadImages(String fileName) {
        java.util.regex.Pattern bit = java.util.regex.Pattern.compile("[01]");
        Scanner f = null;
        try {
            f = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            f.close();
            e.printStackTrace();
        }
        List<Images> images = new ArrayList<>();

        while (f.hasNext()) {
            if (!f.next().equals("P1"))
                System.out.println("Not a P1 PBM file");
            String category = f.next().substring(1);
            if (!category.equals("other"))
                categoryName = category;

            int rows = f.nextInt();
            int cols = f.nextInt();

            boolean[][] data = new boolean[rows][cols];
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    data[r][c] = (f.findWithinHorizon(bit, 0).equals("1"));
                }
            }
            Images image = new Images(data, category);
            images.add(image);
        }
        f.close();
        return images;
    }


    public String getCategoryName() {
        return categoryName;
    }
}