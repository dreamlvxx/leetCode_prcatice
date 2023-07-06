import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestDemo {
    public static void main(String[] args) {
        SimpleDateFormat sdf
                = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        System.out.println(sdf.format(new Date()));
    }

    public static class TargetImpl implements Target{
        @Override
        public void printMsg() {
            System.out.println("printMsg");
        }
    }

    public static interface Target{
        void printMsg();
    }

    public static class DynamicProxyHandler implements InvocationHandler {
        private final Object target;

        public DynamicProxyHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("before invoke");
            if (method.getName().matches("print.+")){
                return null;
            }
            Object invoke = method.invoke(target, args);
            return invoke;
        }
    }


}
