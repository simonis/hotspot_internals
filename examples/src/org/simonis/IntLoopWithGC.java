package org.simonis;

public class IntLoopWithGC {

  static long tmp;

  static void loop(int count) {
    for (int i = 1; i < count; i++)
      for (int j = 1; j < 1_000_000; j++)
        tmp++;
  }

  public static void main(String[] args) {

    for (long i = 0; i < 100; i++) loop(2);

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
    loop(Integer.parseInt(args[0]));
    long end = System.currentTimeMillis();

    System.out.println(end - start + "ms");
    System.exit(0);
  }
}
