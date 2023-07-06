import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public class IPValidator {

    public static void main(String[] args) {
        List<String > list = new ArrayList<>();
        list.add("P2013".toUpperCase());
        list.add("B".toUpperCase());
        list.add("A".toUpperCase());
        list.add("bb123".toUpperCase());
        list.add("ZA".toUpperCase());
        list.sort(Comparator.comparing(String::toString).reversed());
        System.out.println(list.toString());
    }

    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }


    static class SSS {
        String fei = "ttt";
    }

    public static void ffff(SSS b){
        b = null;
    }


    public static int calculateProgress(int size) {
        double percent = (double)size / (double)150;
        int ans = (int) (percent * 100);
        return ans;
    }

    private static boolean isT(int a) {
        if (a != 3 && a != 4) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        return false;
    }

    private static final String IP_V4 = "^(((\\d)|([1-9]\\d)|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))\\.)" +
            "{3}((\\d)|([1-9]\\d)|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))$";
    // 下边这个正则也ok
    // private static final String IP_V4 = "^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$";
    private static final Pattern IP_V4_PATTERN = Pattern.compile(IP_V4);

    /**
     * 是否是有效的ipv4地址
     *
     * @param input 字符串
     * @return 是否是有效的ipv4地址
     */
    public static boolean isValidIpv4(String input) {
        if (input == null) {
            return false;
        }
        return IP_V4_PATTERN.matcher(input).matches();
    }
}
