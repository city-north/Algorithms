package com.eric.stopwatch;

import com.eric.stdOut.StdOut;

/**
 * 秒表类
 * 用来衡量程序的运行时间
 * wall clock time is the time taken to run a code as mesured by a regular clock.
 * This will include all kinds of input/output operations and any processor idle time, also,
 * if you are runnung 10 applications alongside your code,
 * the wall clock time for your code will be obviously larger than if it was run only by itself.
 * @author Chen 2017/10/23
 */
public class StopWatch {

    private final long start;

    public StopWatch() {
        start = System.currentTimeMillis();
    }

    /**
     * 返回从秒表创建以来消耗了多少CPU时间（秒）
     * @return
     */
    public double elapsedTime(){
        long now = System.currentTimeMillis();
        return (now -start)/1000.0;
    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        // sum of square roots of integers from 1 to n using Math.sqrt(x).
        StopWatch timer1 = new StopWatch();
        double sum1 = 0.0;
        for (int i = 1; i <= n; i++) {
            sum1 += Math.sqrt(i);
        }
        double time1 = timer1.elapsedTime();
        StdOut.printf("%e (%.2f seconds)\n", sum1, time1);

        // sum of square roots of integers from 1 to n using Math.pow(x, 0.5).
        StopWatch timer2 = new StopWatch();
        double sum2 = 0.0;
        for (int i = 1; i <= n; i++) {
            sum2 += Math.pow(i, 0.5);
        }
        double time2 = timer2.elapsedTime();
        StdOut.printf("%e (%.2f seconds)\n", sum2, time2);
    }
}
