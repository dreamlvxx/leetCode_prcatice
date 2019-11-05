package offer;

import java.util.ArrayList;
import java.util.Arrays;

public class VerifySequenceIsBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length <= 0){ //root结点为空和叶子结点为空情况不同，特殊处理一下
            return false;
        }
        return VerfyI(sequence);
    }

    /**
     * 验证主要是对于一个数组A序列，
     * 如果是后续遍历，
     * 那么满足最后一个结点为root，剩下的B序列就是左子树和右子树构成的
     * 则值需要验证B序列前一段是大于root的，后一段小于root即满足。
     * @param sequence
     * @return
     */
    public boolean VerfyI(int [] sequence){
        if(sequence == null || sequence.length <= 0){//这里在递归里面属于叶子，返回true
            return true;
        }
        int size = sequence.length;
        int last = sequence[size - 1];//找到最后一个结点，root
        int index = -1;
        for(int i = 0;i < size; i ++){ //这个循环找分割点index
            if(sequence[i] > last){
                index = i;
                break;
            }
        }
        if(index == -1){//如果没有分割点，说明都是小于root的，直接继续去除最后一个结点继续验证
            return VerfyI(Arrays.copyOfRange(sequence,0,size - 1));
        }
        for(int j = index;j < size - 1; j ++){//这个循环验证index后半部分是否都大于root
            if(sequence[j] < last){
                return false;
            }
        }
        return VerfyI(Arrays.copyOfRange(sequence,0,index)) && VerfyI(Arrays.copyOfRange(sequence,index,size - 1));//验证都通过，继续验证左子树和右子树
    }
}
