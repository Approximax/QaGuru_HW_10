package parametrized;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://samokat.ru/";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 5000;
        Configuration.pageLoadStrategy = "eager";
    }
}
