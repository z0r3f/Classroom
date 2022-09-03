package me.adrian.manager.user;

// Next Steps

// - Contemplar parámetro de validación "-v", para ello necesitamos leer todo el fichero


public class App {

    public static void main(String[] args) throws Exception {

        var request = handleParameters(args);

        switch (request.getMode()) {
            case ADD -> request.getUser().save();
            case VALIDATE ->
                    System.out.printf("The %s is %s%n", request.getUser(), (User.isValid(request.getUser()) ? "valid" : "invalid"));
            default -> throw new Exception("Bad execution...");
        }
        System.exit(0);
    }

    private static Request handleParameters(String[] args) {
        var mode = Mode.UNKNOWN;
        var username = "";
        var password = "";

        if (args == null || args.length == 0) {
            System.out.println("Should adding parameters");
            System.exit(1);
        }

        for (int i = 0; i < args.length; i++) {
            //System.out.printf("\nI'm checking the parameter [%d]", i);

            var actualParameter = args[i];

            if (actualParameter.equalsIgnoreCase("-a")) {
                mode = Mode.ADD;
            }
            if (actualParameter.equalsIgnoreCase("-u")) {
                username = args[++i];
            }
            if (actualParameter.equalsIgnoreCase("-p")) {
                password = args[++i];
            }
            if (actualParameter.equalsIgnoreCase("-v")) {
                mode = Mode.VALIDATE;
            }
            //System.out.printf("\n%d → %s", i, actualParameter);
        }
        //System.out.println();

        User user = new User(username, password);
        //System.out.println(user.toString());

        return new Request(user, mode);
    }
}
