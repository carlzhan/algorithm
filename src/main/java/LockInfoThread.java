/**
 * 线程相关知识
 */
public class LockInfoThread {
    public static class Service {
        public void method1() {
            synchronized (Service.class) {
                // Service.class 类锁
            }
        }

        synchronized public static void method2() {
            //  Service.class 类锁
        }

        public void method3() {
            synchronized (this) {
                // 对象锁，Service的实例对象
            }
        }

        synchronized public void method4() {
            // 对象锁，Service的实例对象
        }

        private final String anything = "";

        public void method5() {
            synchronized (new Object()) {
                // String 对象锁
            }
        }


        private void service1() {
            synchronized (anything) {
                try {
                    System.out.println("service begin");
                    Thread.sleep(3000);
                    System.out.println("service end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        synchronized static private void service2() {
            System.out.println("service2");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("service2 end");
        }

        synchronized static private void service3() {
            System.out.println("service3");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("service3 end");
        }
    }

    public static class MyThread1 extends Thread {
        private final Service service;

        MyThread1(Service service) {
            this.service = service;
        }

        @Override
        public void run() {
            super.run();
            service.service3();
        }
    }

    public static class MyThread2 extends Thread {
        private final Service service;

        MyThread2(Service service) {
            this.service = service;
        }

        @Override
        public void run() {
            super.run();
            service.service2();
        }
    }

    public static class PrintString implements Runnable {
        volatile private boolean isContinuePrint = true;

        public boolean isContinuePrint() {
            return isContinuePrint;
        }

        public void setContinuePrint(boolean isContinuePrint) {
            this.isContinuePrint = isContinuePrint;
        }

        public void printStringMethod() {
            while (isContinuePrint) {
                System.out.println("run=" + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void run() {
            printStringMethod();
        }
    }

    public static void main(String args[]) {
//        try {
//            Service service = new Service();
//            MyThread1 myThread1 = new MyThread1(service);
//            myThread1.start();
//            Service service2 = new Service();
//            MyThread2 myThread2 = new MyThread2(service2);
//            myThread2.start();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        PrintString printString = new PrintString();
        Thread thread = new Thread(printString);
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我要停止它" + Thread.currentThread().getName());
        printString.setContinuePrint(false);
    }

    static class Single {
        private Single mInstance;
        private static Single INSTANCE = new Single();

        private Single getSingleInstance() {
            if (mInstance == null) {
                synchronized (this) {
                    if (mInstance != null) {
                        mInstance = new Single();
                    }
                }
            }
            return mInstance;
        }

        private static Single getSingle() {
            return Single.INSTANCE;
        }

    }
}
