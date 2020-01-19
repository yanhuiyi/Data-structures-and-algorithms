package designpattern.proxy;

public class Program {
    public static void main(String[] args) {
        Searcher proxy =  new ProxySearcher();
        System.out.printf(proxy.doSearch("foo", "bar"));
    }
}
