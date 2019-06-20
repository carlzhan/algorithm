import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 生产者、消费值模式
 */
public class ThreadLocalTest {

    static class MyService {
        private boolean hasValue = false;

        synchronized public void set() {
            if (hasValue) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("set");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            hasValue = true;
            notify();
        }

        synchronized public void get() {
            if (!hasValue) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("get");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            hasValue = false;
            notify();
        }
    }

    static class ThreadA extends Thread {
        private final MyService s;

        ThreadA(MyService s) {
            this.s = s;
        }

        @Override
        public void run() {
            while (true) {
                s.get();
            }
        }
    }

    static class ThreadB extends Thread {
        private final MyService s;

        ThreadB(MyService s) {
            this.s = s;
        }

        @Override
        public void run() {
            while (true) {
                s.set();
            }
        }
    }

    static class DataTools {
        // 注意：ThreadLocal一定要用static修饰，全局变量
        private static ThreadLocal<SimpleDateFormat> t1 = new ThreadLocal<>();

        public static SimpleDateFormat getSimpleDateFormat(String date) {
            SimpleDateFormat sdf = null;
            sdf = t1.get();
            if (sdf == null) {
                sdf = new SimpleDateFormat(date);
                t1.set(sdf);
            }
            return sdf;
        }
    }

    public static void main(String args[]) {
        ThreadLocal<String> local = new ThreadLocal<>();
        ThreadLocal<String> loca11 = new ThreadLocal<>();
        local.set("first");

        loca11.set("second");

        System.out.println(loca11.get()+"________-"+local.get());
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Integer.parseInt("a"));
//            }
//        });
//
//
//        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//            @Override
//            public void uncaughtException(Thread t, Throwable e) {
//                e.printStackTrace();
//                System.out.println("类");
//            }
//        });
//        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//            @Override
//            public void uncaughtException(Thread t, Throwable e) {
//                e.printStackTrace();
//                System.out.println("子线程");
//            }
//        });
//        thread.start();
    }

    static class SingleTask {
        private static class SingleHandlerTask {
            public static SingleTask mySingleTask = new SingleTask();
        }

        public static SingleTask getInstance() {
            byte[] a = {1, 2};
            switch (a[1]) {

            }
            return SingleHandlerTask.mySingleTask;
        }


    }
}
