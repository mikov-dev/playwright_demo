package org.pnm;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlaywrightTest extends BaseTest {

    @Test
    void testPlaywrightTitle() {
        page.navigate("https://playwright.dev");
        System.out.println(page.title());
        assertTrue(page.title().contains("Playwright"));
    }
}
