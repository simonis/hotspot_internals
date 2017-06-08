package org.simonis;

public class FlameLoopWithGC {

  static double compute(int count, double d) {
    for (int i = 0; i < count; i++) {
      d += Math.pow(Math.sin(d), Math.sqrt(d));
    }
    return d;
  }

  public static void main(String[] args) throws Exception {

    for (int i = 0; i < 20_000; i++) {
      compute(2, 0.0d);
    }

    long start  = System.currentTimeMillis();
    for (int i = 0; i < Integer.parseInt(args[0]); i++) {
      compute(20_000, 0.0d);
    }
    long end = System.currentTimeMillis();

    System.out.println(end - start + "ms");
    System.exit(0);
  }
}
