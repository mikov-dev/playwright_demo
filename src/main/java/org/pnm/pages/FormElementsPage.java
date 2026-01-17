package org.pnm.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.BoundingBox;
import com.microsoft.playwright.options.SelectOption;

public class FormElementsPage extends HomePage {

    public Locator textInput;
    public Locator emailInput;
    public Locator passwordInput;
    public Locator textAreaInput;
    public Locator rangeSlider;
    public Locator selectElementOption;
    public Locator optionOne;

    public FormElementsPage(Page page) {
        super(page);
        this.textInput = page.getByTestId("text-input");
        this.emailInput = page.getByTestId("email-input");
        this.passwordInput = page.getByTestId("password-input");
        this.textAreaInput = page.getByTestId("textarea-input");
        this.rangeSlider = page.getByTestId("range-input");
        this.selectElementOption = page.getByTestId("single-select");
        this.optionOne = page.locator("option[value='option1']");
    }

    public void goToFormElementsPage() {
        formElementsLink.click();
    }

    public void enterText(String text) {
        textInput.fill(text);
    }

    public void enterEmail(String email) {
        emailInput.fill(email);
    }

    public void enterPassword(String password) {
        passwordInput.fill(password);
    }

    public void enterTextArea(String text) {
        textAreaInput.fill(text);
    }

    public void moveSlider() {
        BoundingBox box = rangeSlider.boundingBox();
        page.mouse().move(
                box.x + box.width / 2,
                box.y + box.height / 2
        );
        page.mouse().down();
        page.mouse().move(
                box.x + box.width / 2 + 100, // +100 → right, -100 → left
                box.y + box.height / 2
        );
        page.mouse().up();
    }

    public String selectSingleOption(String option) {
        return selectElementOption.selectOption(new SelectOption().setValue(option)).get(0);
    }
}
