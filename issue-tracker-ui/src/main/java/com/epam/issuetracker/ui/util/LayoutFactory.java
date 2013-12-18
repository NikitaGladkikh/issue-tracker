package com.epam.issuetracker.ui.util;

import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

/**
 * 12/18/13
 *
 * @author Mikita_Hladkikh
 */
public class LayoutFactory {

    private LayoutFactory() {
        new AssertionError();
    }

    public static VerticalLayout createVerticalLayout(boolean enableSpacing, boolean enableMargin, Component...components) {
        VerticalLayout verticalLayout = new VerticalLayout(components);
        verticalLayout.setSpacing(enableSpacing);
        verticalLayout.setMargin(enableMargin);
        return verticalLayout;
    }

    public static HorizontalLayout createHorizontalLayout(boolean enableSpacing, boolean enableMargin,Component...components) {
        HorizontalLayout horizontalLayout = new HorizontalLayout(components);
        horizontalLayout.setSpacing(enableSpacing);
        horizontalLayout.setMargin(enableMargin);
        return horizontalLayout;
    }
}
