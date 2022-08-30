package me.adrian.manager.user;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class User {

    private final String username;
    private final String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void save() {
        // Path path = Paths.get("C:\\Users\\HP\\Desktop\\gfg.txt");
        Path path = Paths.get("/Users/fernando/Temporal/classroom/users.txt");

        try {
            Files.writeString(path, serialize(), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            System.out.print("Invalid Path");
        }
    }

    private String serialize() {
        return username + '|' + password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username=" + username +
                ", password=" + password +
                '}';
    }
}
