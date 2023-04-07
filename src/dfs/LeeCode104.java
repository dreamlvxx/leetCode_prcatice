package dfs;

public class LeeCode104 {
    public static void main(String[] args) {
        String hex = "7fffffff";
        int hexInt = convertHexStringToInt(hex);
        System.out.println("hexInt = " + hexInt);
    }

    public static int convertHexStringToInt(String hexStr) {
        return Integer.parseInt(hexStr, 16);
    }

    public static byte setSpecifiedBitToReverse(byte originByte, int bitIndex) {
        return originByte ^= (1 << bitIndex);
    }

    public static byte setSpecifiedBitTo0(byte originByte, int bitIndex) {
        int b = 1 << bitIndex;// 2 0000 1000
        System.out.println("b = " + b);
        for (int i = 7; i >= 0; i--) {
            System.out.print("  " + getSpecifiedBitValue((byte) b,i));
        }
        System.out.println("");
        int a = ~(1 << bitIndex); //3 1000 1001
        for (int i = 7; i >= 0; i--) {
            System.out.print("  " + getSpecifiedBitValue((byte) a,i));
        }
        System.out.println("");
        return originByte &= a;
    }

    public static byte getSpecifiedBitValue(byte originByte, int bitIndex) {
        return (byte) ((originByte) >> (bitIndex) & 1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
