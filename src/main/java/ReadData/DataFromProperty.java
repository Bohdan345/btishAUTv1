package ReadData;

public class DataFromProperty {
    public static final String DRIVER_PATH = new ReadFromFile().getReadPropertyFile("driver.path");
    public static final String BROWSER = new ReadFromFile().getReadPropertyFile("driver.browser");
    public static final String URL = new ReadFromFile().getReadPropertyFile("driver.url");
    public static final String USER_LOGIN = new ReadFromFile().getReadPropertyFile("user.login");
    public static final String USER_PASSWORD = new ReadFromFile().getReadPropertyFile("user.password");
    public static final int TIME_OUT = Integer.parseInt(new ReadFromFile().getReadPropertyFile("element.wait"));
}
