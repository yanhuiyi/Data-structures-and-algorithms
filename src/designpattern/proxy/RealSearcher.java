package designpattern.proxy;

public class RealSearcher implements Searcher {
    @Override
    public String doSearch(String userId, String keyword) {
        System.out.printf("User %s query information with keyword %s\n", userId, keyword);
        return "Query result.";
    }
}
