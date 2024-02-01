package parametrized;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@DisplayName("Простые параметризованые тесты")
public class SimpleParametrizedTests extends TestBase{

    @BeforeEach
    void BeforeEach() {
        open("https://samokat.ru/");
        $("#desktop-aside-left").shouldHave(text("Самокат"));
    }

    @Tag("BLOCKER")
    @ValueSource(strings = {
            "ягоды", "молоко", "яйца"
    })
    @ParameterizedTest(name = "Для поискового запроса {0} должна быть не пустая выдача товаров")
    void searchResultsShouldNotBeEmpty(String searchQueryInput) {
        $("[placeholder='Искать в Самокате']").setValue(searchQueryInput);

        $("")


    }
}
