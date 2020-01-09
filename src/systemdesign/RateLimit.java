package systemdesign;

public interface RateLimit {
    void setQPS(int qps);
    boolean allowThisRequest();
}
