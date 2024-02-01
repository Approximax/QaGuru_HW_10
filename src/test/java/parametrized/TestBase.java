package parametrized;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    @BeforeEach
    void beforeEach() {
        Configuration.baseUrl = "https://samokat.ru/";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 5000;
        Configuration.pageLoadStrategy = "eager";
    }
}
