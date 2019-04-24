public class LeeCode922 {
    public int[] sortArrayByParityII(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                if (A[i] % 2 != 0) {
                    for (int j = i + 1; j < A.length; j++) {
                        if (A[j] % 2 == 0) {
                            int temp = A[i];
                            A[i] = A[j];
                            A[j] = temp;
                            break;
                        }
                    }
                }
            } else {
                if (A[i] % 2 == 0) {
                    for (int j = i + 1; j < A.length; j++) {
                        if (A[j] % 2 != 0) {
                            int temp = A[i];
                            A[i] = A[j];
                            A[j] = temp;
                            break;
                        }
                    }
                }
            }
        }
        return A;
    }
}
