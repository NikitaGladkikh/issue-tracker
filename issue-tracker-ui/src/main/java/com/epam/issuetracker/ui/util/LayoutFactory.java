package com.epam.issuetracker.ui.util;

import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

/**
 * Util class for creating horizontal and vertical layouts.
 * <p/>
 * 12/18/13
 *
 * @author Mikita_Hladkikh
 */
public final class LayoutFactory {

    private LayoutFactory() {
        new AssertionError();
    }

    /**
     * Create vertical layout basic on spacing, margin and
     * transmitted VAADIN UI components.
     *
     * @param enableSpacing enable spacing in layout.
     * @param enableMargin  enable margin in layouts.
     * @param components    which are used for creating layout.
     * @return new prepared vertical layout.
     */
    public static VerticalLayout createVerticalLayout(boolean enableSpacing, boolean enableMargin,
                                                      Component... components) {
        if (null != components) {
            VerticalLayout verticalLayout = new VerticalLayout(components);
            verticalLayout.setSpacing(enableSpacing);
            verticalLayout.setMargin(enableMargin);
            return verticalLayout;
        } else {
            return new VerticalLayout();
        }

    }

    /**
     * Create horizontal layout basic on spacing, margin and
     * transmitted VAADIN UI components.
     *
     * @param enableSpacing enable spacing in layout.
     * @param enableMargin  enable margin in layouts.
     * @param components    which are used for creating layout.
     * @return new prepared horizontal layout.
     */
    public static HorizontalLayout createHorizontalLayout(boolean enableSpacing, boolean enableMargin,
                                                          Component... components) {
        if (null != components) {
            HorizontalLayout horizontalLayout = new HorizontalLayout(components);
            horizontalLayout.setSpacing(enableSpacing);
            horizontalLayout.setMargin(enableMargin);
            return horizontalLayout;
        } else {
            return new HorizontalLayout();
        }
    }
}
