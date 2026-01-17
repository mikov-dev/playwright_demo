package org.pnm.e2e;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pnm.BaseTest;
import org.pnm.pages.FormElementsPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        //TODO: fix this

       // String[] options = {"option1", "option2", "option3", "option4"};
       // String[] optionValues = {"Option 1", "Option 2", "Option 3", "Option 4"};

        //for (int i = 0; i < options.length; i++) {
           // assertEquals(optionValues[i], formElementsPage.selectSingleOption(options[i]));
        //}
    }

}
