package xyz.akaksr.scs.type;

public enum Type {
    LOGIN("LOGIN_SESSION");

    private String type;

    Type(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
