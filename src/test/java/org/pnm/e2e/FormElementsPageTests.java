package org.pnm.e2e;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pnm.BaseTest;
import org.pnm.pages.FormElementsPage;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormElementsPageTests extends BaseTest {

    FormElementsPage formElementsPage;

    @BeforeEach
    public void setup() {
        formElementsPage = new FormElementsPage(page);
        formElementsPage.goToFormElementsPage();
    }

    @Test
    @DisplayName("Test Text Input")
    public void testTextInput() {
        formElementsPage.enterText("Test Text");
        assertThat(formElementsPage.textInput).hasValue("Test Text");
    }

    @Test
    @DisplayName("Test Email Input")
    public void testEmailInput() {
        formElementsPage.enterEmail("testEmail@email.test");
        assertThat(formElementsPage.emailInput).hasValue("testEmail@email.test");
    }

    @Test
    @DisplayName("Test Password Input")
    public void testPasswordInput() {
        formElementsPage.enterPassword("TestPassword@2026+Playwright");
        assertThat(formElementsPage.passwordInput).hasValue("TestPassword@2026+Playwright");
    }

    @Test
    @DisplayName("Test Text Area Input")
    public void testTextAreaInput() {
        formElementsPage.enterTextArea("This is a test text area");
        assertThat(formElementsPage.textAreaInput).containsText("This is a test text area");
    }

    @Test
    @DisplayName("Test Slider Movement")
    public void testSliderMovement() {
        assertThat(formElementsPage.rangeSlider).hasValue("50");
        formElementsPage.moveSlider();
        assertThat(formElementsPage.rangeSlider).hasValue("74");
    }

    @Test
    @DisplayName("Test Select Element")
    public void testSelectElement() {

        String[] options = {"option1", "option2", "option3", "option4"};

        for (String option : options) {
            assertEquals(option, formElementsPage.selectSingle(option));
        }
    }

    @Test
    @DisplayName("Test Multi Select Element")
    public void testMultiSelectElement() {
        String[] items = {"item1", "item2", "item3", "item4", "item5"};
        formElementsPage.selectMultiple(items);

        List<Locator> allOptions = formElementsPage.getAllOptions();
        assertEquals(5, allOptions.size());

        assertThat(formElementsPage.multiSelectElement).hasValues(items);
    }

    @Test
    @DisplayName("Test Select All Options")
    public void testSelectAllOptions() {
        formElementsPage.selectAllOptions();

        List<Locator> allOptions = formElementsPage.getAllOptions();
        String[] allValues = allOptions.stream()
                .map(locator -> locator.getAttribute("value"))
                .toArray(String[]::new);

        assertThat(formElementsPage.multiSelectElement).hasValues(allValues);
    }

}
