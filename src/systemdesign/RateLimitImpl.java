package systemdesign;

import java.security.InvalidParameterException;

public class RateLimitImpl implements RateLimit {
    private int qps;
    private double serviceTime;
    private long latestStart;

    @Override
    public void setQPS(int qps) {
        if(qps < 1 || qps > 1000000)
            throw new InvalidParameterException(String.format("OPS: %d is not valid", qps));
        this.qps = qps;
        this.serviceTime = 1000.0 / this.qps;
        latestStart = -1;
    }

    @Override
    public boolean allowThisRequest() {
        long crtTime = System.currentTimeMillis();
        if(crtTime - latestStart >= serviceTime) {
            latestStart = crtTime;
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        RateLimit rateLimit = new RateLimitImpl();
        rateLimit.setQPS(1);

        long start = System.currentTimeMillis();
        System.out.println(rateLimit.allowThisRequest());;

        long elapsed = System.currentTimeMillis() - start;
        Thread.sleep(10 - elapsed);
        elapsed = System.currentTimeMillis() - start;
        System.out.println(elapsed >= 10 && elapsed <= 11);
        System.out.println(rateLimit.allowThisRequest());
    }
}
