package jk;

/**
 * 八皇后问题
 */
public class JK39Code1 {
    int[] result = new int[8];//作为结果打印的数组 下标代表row 值代表column   解释：这里只用一个数组就可以了，因为for循环是一次一次执行的，所以路径是一次一次找出来的，可以复用
    public void cal8queens(int row){//调用方式：cal8queens（0）即可；
        if (row == 8){//当每一次循环递归结束的时候，就找到一次路径，则打印
            printQueens(result);
            return;
        }

        for (int column = 0; column < 8; column++) {//第一次传入的是0 ，然后第0行的列有8中情况，所以就是第一行放8个位置，下面的行再依次寻找合适位置
            if (isOk(row,column)){//这行的棋子可放，那么就寻找下一行可以存放的位置
                result[row] = column;
                cal8queens(row + 1);
            }
        }

    }

    private boolean isOk(int row,int column){
        int leftUp = column - 1,rightUp = column + 1;//左上对角和右上对角
        for (int i = row - 1; i >= 0; i--) {//检查这行以上的每一行是否符合条件(判断每一行的三个位置是否有棋子)
            if (result[i] == column)return false;//条件1：第 i 行放置的棋子，是否在我们当前行放置的棋子的正上方

            if (leftUp > 0){//条件2：左斜对角线的位置是否有棋子
                if (result[i] == leftUp)return false;
            }

            if (rightUp < 8){//条件3：右斜对角线的位置是否有棋子
                if (result[i] == rightUp)return false;
            }
            --leftUp;++rightUp;//这行如果通过了，那么i变上一行，那么斜对角线与上一行的交叉位置也左右移动了
        }
        return true;
    }

    private void printQueens(int[] result){//打印所有可能的情况
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (result[row] == column) System.out.println("Q ");
                else System.out.println("* ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
