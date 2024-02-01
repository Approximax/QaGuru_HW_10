package parametrized;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
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

        $$(".ProductCardOverlay_slide__954Wj").shouldBe(sizeGreaterThan(0));
    }

    @Tag("BLOCKER")
    @CsvSource(value = {
            "Хлеб и выпечка , Хлеб",
            "Мясо и рыба , Мясо и выпечка"
    })
    @CsvFileSource(resources = "/internalCategoriesMatchWithParent.csv")
    @ParameterizedTest(name = "Соответствие внутренней категории её родительской")
    void internalCategoriesMatchWithParent(String internalCategory, String parentCategory) {
        $(".CatalogTree_root__IHeCU").find(String.valueOf(text(parentCategory))).click();
        $("CatalogTreeSectionCard_categories__4uYFm").shouldHave(text(internalCategory));
    }
}
