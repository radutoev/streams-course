package com.siemens.ifa;

/**
 * Created by Radu Toev on 27.07.2018.
 */
public class TimeIT {
    public static void code(Runnable block) {
        long start = System.nanoTime();
        try {
            block.run();
        } finally {
            long end = System.nanoTime();
            System.out.println("Execution time: " + (end - start) / 1.e09);
        }
    }
}
