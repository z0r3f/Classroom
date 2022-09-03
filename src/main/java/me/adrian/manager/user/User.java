package me.adrian.manager.user;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Objects;

public class User {
    static Path PATH = Paths.get("/Users/fernando/Temporal/classroom/users.txt");

    private final String username;
    private final String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String userSerialized) {
//        System.out.println("User serialized: " + userSerialized);
        String[] user = userSerialized.split("\\|");
        this.username = user[0];
        this.password = user[1];
//        System.out.println("User deserialized: " + this.toString());
    }

    public void save() {
        // Path PATH = Paths.get("C:\\Users\\HP\\Desktop\\gfg.txt");

        try {
            if (!Files.exists(PATH)) {
                Files.createFile(PATH);
            }
            // adds new line to the end of the file
            Files.writeString(PATH, serialize() + "\n", StandardOpenOption.APPEND);
            //Files.writeString(PATH, serialize(), StandardCharsets.UTF_8);

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!username.equals(user.username)) return false;
        return password.equals(user.password);
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    public static boolean isValid(User user) {
        return Objects.requireNonNull(getUsers()).stream().anyMatch(u -> u.equals(user));
    }

    private static List<User> getUsers() {
        List<User> users = null;
        try {
            users = Files.readAllLines(PATH, StandardCharsets.UTF_8).stream()
                    // .peek(System.out::println)
                    .map(User::new).toList();
        } catch (IOException e) {
            System.out.print("Invalid Path");
            users = List.of();
        }
        return users;
    }
}
