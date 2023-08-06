package BrowserHistory;

public class Driver {
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("bhanujgandhi.me");

        browserHistory.visit("www.google.com");
        browserHistory.visit("www.youtube.com");
        System.out.println(browserHistory.back(3));
        System.out.println(browserHistory.forward(1));
    }
}
