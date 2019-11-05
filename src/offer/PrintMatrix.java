package offer;

import java.util.ArrayList;

public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList();
        if(matrix == null || matrix[0].length == 0 || matrix.length == 0){
            return res;
        }
        int left = 0;
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;

        while(true){
            //top
            for(int tt = left;tt <= right;tt ++){
                res.add(matrix[top][tt]);
            }
            top ++;
            if(top > bottom){
                break;
            }
            //right
            for(int rr = top;rr <= bottom; rr ++){
                res.add(matrix[rr][right]);
            }
            right --;
            if(left > right){
                break;
            }
            //bottom
            for(int bb = right;bb >= left;bb --){
                res.add(matrix[bottom][bb]);
            }
            bottom --;
            if(top > bottom){
                break;
            }
            //left
            for(int ll = bottom;ll >= top;ll --){
                res.add(matrix[ll][left]);
            }
            left ++;
            if(left > right){
                break;
            }
        }
        return res;
    }
}
