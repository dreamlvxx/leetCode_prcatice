package jz_offer_studp_project;

public class JZ_cn_002 {

    /**
     * 这里需要知道的是
     *  '0' 和 '1'的ASSIC只相差1 所以有 ‘0’ + 1 = ‘1’
     * @param a
     * @param b
     * @return
     */
    public String addBinary1(String a,String b){
        StringBuilder sb = new StringBuilder();
        int maxLength = Math.max(a.length(),b.length());
        int carry = 0;
        for (int i = 0; i < maxLength; i++) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0' ): 0;
            carry += i< b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            sb.append((char)(carry % 2 + '0'));
            carry /= 2;
        }
        if(carry > 0){
            sb.append('1');
        }
        sb.reverse();
        return sb.toString();
    }



    public String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }
}
