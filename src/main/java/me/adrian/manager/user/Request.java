package me.adrian.manager.user;

public class Request {
    private User user;
    private Mode mode;

    Request(User user, Mode mode) {
        this.user = user;
        this.mode = mode;
    }

    public User getUser() {
        return user;
    }

    public Mode getMode() {
        return mode;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }
}
