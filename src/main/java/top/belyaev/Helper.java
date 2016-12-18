package top.belyaev;

public class Helper {
    public static Integer parseInt(String entry) {
        try {
            return Integer.parseInt(entry);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
