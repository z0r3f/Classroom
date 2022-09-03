package me.adrian.manager.user;

public enum Mode {
    UNKNOWN,
    ADD,
    VALIDATE;

    public static Mode fromMode(String name) throws EnumConstantNotPresentException {

        for (Mode mode : Mode.values()) {
            if (mode.name().equalsIgnoreCase(name)) {
                return mode;
            }
        }
        throw new EnumConstantNotPresentException(Mode.class, name);
    }
}
