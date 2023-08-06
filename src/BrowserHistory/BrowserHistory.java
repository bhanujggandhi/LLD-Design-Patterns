package BrowserHistory;

import java.util.ArrayDeque;
import java.util.Deque;

public class BrowserHistory {
    private Deque<String> backHistory;
    private Deque<String> forwardHistory;

    public BrowserHistory(String homepage) {
        this.backHistory = new ArrayDeque<>();
        this.forwardHistory = new ArrayDeque<>();

        backHistory.push(homepage);
    }

    public String visit(String url) {
        this.backHistory.push(url);
        this.forwardHistory.clear();

        return url;
    }

    public String back(int steps) {
        while(!backHistory.isEmpty() && steps > 0) {
            forwardHistory.push(backHistory.pop());
            steps--;
        }

        if(backHistory.isEmpty()) {
            backHistory.push(forwardHistory.pop());
        }

        return backHistory.peek();
    }

    public String forward(int steps) {
        while(!forwardHistory.isEmpty() && steps > 0) {
            backHistory.push(forwardHistory.pop());
            steps--;
        }

        return backHistory.peek();
    }
}
