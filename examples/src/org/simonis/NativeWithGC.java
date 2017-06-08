package org.simonis;

public class NativeWithGC {

    static {
        System.loadLibrary("native_call");
    }
    static native void native_call(long la[], long sleep, boolean block);

    public static void main(String[] args) {

        System.out.println("Warmup done");

        new Thread() {
            public void run() {
                while(true) {
                    try { Thread.sleep(1_000); } catch (InterruptedException e) {}
                    System.gc();
                }
            }
        }.start();

        long start  = System.currentTimeMillis();
        native_call(new long[1], Long.parseLong(args[0]), Boolean.parseBoolean(args[1]));
        long end = System.currentTimeMillis();

        System.out.println(end - start + "ms");
        System.exit(0);
    }

}
