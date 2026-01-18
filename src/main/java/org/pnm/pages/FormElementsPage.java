package org.pnm.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.BoundingBox;
import com.microsoft.playwright.options.KeyboardModifier;
import com.microsoft.playwright.options.SelectOption;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormElementsPage extends HomePage {

    public Locator textInput;
    public Locator emailInput;
    public Locator passwordInput;
    public Locator textAreaInput;
    public Locator rangeSlider;
    public Locator singleSelectElement;
    public Locator multiSelectElement;


    public FormElementsPage(Page page) {
        super(page);
        this.textInput = page.getByTestId("text-input");
        this.emailInput = page.getByTestId("email-input");
        this.passwordInput = page.getByTestId("password-input");
        this.textAreaInput = page.getByTestId("textarea-input");
        this.rangeSlider = page.getByTestId("range-input");
        this.singleSelectElement = page.getByTestId("single-select");
        this.multiSelectElement = page.getByTestId("multi-select");
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

    public String selectSingle(String option) {
        return singleSelectElement.selectOption(new SelectOption().setValue(option)).get(0);
    }

    private List<Locator> getLocators(List<String> selectors) {
        List<Locator> locators = new ArrayList<>();
        for (String selector : selectors) {
            locators.add(multiSelectElement.locator(String.format("option[value='%s']", selector)));
        }
        return locators;
    }

    public List<Locator> getAllOptions() {
        List<Locator> locators = new ArrayList<>();
        Locator options = multiSelectElement.locator("option");
        for (int i = 0; i < options.count(); i++) {
            locators.add(options.nth(i));
        }
        return locators;
    }


    public void selectMultiple(String[] selector) {
        selectMultiple(Arrays.asList(selector));
    }

    public void selectMultiple(List<String> selectors) {
        KeyboardModifier modifier =
                System.getProperty("os.name").toLowerCase().contains("mac")
                        ? KeyboardModifier.META
                        : KeyboardModifier.CONTROL;

        for (Locator locator : getLocators(selectors)) {
            locator.click(new Locator.ClickOptions().setModifiers(List.of(modifier)));
        }
    }

    public void selectAllOptions() {
        List<Locator> options = getAllOptions();
        List<String> values = new ArrayList<>();
        for (Locator option : options) {
            values.add(option.getAttribute("value"));
        }
        selectMultiple(values);
    }
}
