package org.pnm;

import com.microsoft.playwright.*;

public class BasePage {

    protected Page page;

    protected BasePage(Page page) {
        this.page = page;
    }

}
