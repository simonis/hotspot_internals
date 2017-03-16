package org.simonis;

public class LoopWithGC {

  static double compute(int count, double d) {
    for (int i = 0; i < count; i++) {
      d += Math.pow(Math.sin(d), Math.sqrt(d));
    }
    return d;
  }

  public static void main(String[] args) throws Exception {

      int count = Integer.parseInt(args[0]);

    for (int i = 0; i < 20_000; i++) {
      compute(2, 0.0d);
    }

    new Thread() {
      { setDaemon(true); }
      public void run() {
        while (true) {
          try {
            Thread.sleep(1_000);
          } catch (InterruptedException e) {}
          System.gc();
        }
      }
    }.start();

    long start  = System.currentTimeMillis();
    compute(count, 0.0d);
    long end = System.currentTimeMillis();

    System.out.println(end - start + "ms");
    System.exit(0);
  }
}
