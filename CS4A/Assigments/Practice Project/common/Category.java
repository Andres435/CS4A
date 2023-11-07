package common;

public interface Category {
    String id();
    String description();
    Category parent();
}