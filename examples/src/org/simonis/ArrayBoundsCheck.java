package org.simonis;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.CompilerControl;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

@State(Scope.Benchmark)
public class ArrayBoundsCheck {
    
    @CompilerControl(CompilerControl.Mode.INLINE)
    static int foo(int i) {
        return i;
    }
    
    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    static int bar(int i) {
        return i;
    }

    static final int[] a = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    
    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public static int test1_impl(int[] unused, int start, int end) {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += a[i];
        }
        return sum;
    }
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public static void test1() {
        test1_impl(a, 0, 10);
    }
 
    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    static int test2_impl(int[] a, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += a[i];
        }
        return sum;
    }
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public static void test2() {
        test2_impl(a, 0, 10);
    }
    
    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    static int test3_impl(int[] a, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += a[foo(i)];
        }
        return sum;
    }
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public static void test3() {
        test3_impl(a, 0, 10);
    }
    
    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    static int test4_impl(int[] a, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += a[bar(i)];
        }
        return sum;
    }
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public static void test4() {
        test4_impl(a, 0, 10);
    }
    
    static int d = 10;
    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    static int test5_impl(int[] a, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += a[i - d];
        }
        return sum;
    }
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public static void test5() {
        test5_impl(a, 10, 20);
    }
 

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(ArrayBoundsCheck.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .warmupTime(new TimeValue(1, TimeUnit.SECONDS))
                .measurementTime(new TimeValue(1, TimeUnit.SECONDS))
                .threads(1)
                .forks(1)
                .build();
        new Runner(opt).run();

        /*
        int[] a = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int i = 0; i < 20_000; i++) {
            test1_impl();
            test2_impl(a, 0, 10);
            test3_impl(a, 0, 10);
            test4_impl(a, 0, 10);
        }
        long start = System.nanoTime();
        for (int i = 0; i < 2_000_000; i++) {
            test1_impl();
        }
        long end = System.nanoTime();
        System.out.format("test1() = %d\n", end - start);
        start = System.nanoTime();
        for (int i = 0; i < 2_000_000; i++) {
            test2_impl(a, 0, 10);
        }
        end = System.nanoTime();
        System.out.format("test2() = %d\n", end - start);
        start = System.nanoTime();
        for (int i = 0; i < 2_000_000; i++) {
            test3_impl(a, 0, 10);
        }
        end = System.nanoTime();
        System.out.format("test3() = %d\n", end - start);
        start = System.nanoTime();
        for (int i = 0; i < 2_000_000; i++) {
            test4_impl(a, 0, 10);
        }
        end = System.nanoTime();
        System.out.format("test4() = %d\n", end - start);
        */
    }
}
