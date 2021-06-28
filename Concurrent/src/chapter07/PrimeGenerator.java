package chapter07;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * 使用volatile的域来保存取消状态
 * @author ohYoung
 * @date 2020/12/26 17:43
 */
public class PrimeGenerator implements Runnable {

    private static final List<BigInteger> primes = new ArrayList<>();

    private volatile boolean cancelled;

    @Override
    public void run() {
        BigInteger one = BigInteger.ONE;
        while (!cancelled) {
            one = one.nextProbablePrime();
            synchronized (this) {
                primes.add(one);
            }
        }
    }

    public void cancel() {
        cancelled = true;
    }

    public synchronized List<BigInteger> get() {
        return new ArrayList<>(primes);
    }

    List<BigInteger> aSecondOfPrimes() throws InterruptedException {
        PrimeGenerator primeGenerator = new PrimeGenerator();
        new Thread(primeGenerator).start();
        try {
            SECONDS.sleep(1);
        } finally {
            primeGenerator.cancel();
        }
        return primeGenerator.get();
    }
}
