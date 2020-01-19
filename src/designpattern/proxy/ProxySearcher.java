package designpattern.proxy;

public class ProxySearcher implements Searcher {
    private RealSearcher searcher = new RealSearcher();
    private AccessValidator validator;
    private Logger logger;
    @Override
    public String doSearch(String userId, String keyword) {
        if(this.validate(userId) == true) {
            String result = searcher.doSearch(userId, keyword);
            this.log(userId);
            return result;
        }
        return null;
    }

    public boolean validate(String userId) {
        return new AccessValidator().validate(userId);
    }

    public void log(String userId) {
        new Logger().log(userId);
    }
}
