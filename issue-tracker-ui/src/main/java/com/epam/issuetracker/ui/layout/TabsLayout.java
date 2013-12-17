package com.epam.issuetracker.ui.layout;

import com.epam.issuetracker.ui.tabs.MainTabs;
import com.vaadin.ui.VerticalLayout;

/**
 * Layout to display main tabs.
 *
 * @author Mikita_Hladkikh on 12/12/13.
 */
public class TabsLayout extends VerticalLayout {

    /**
     * Default constructor.
     */
    public TabsLayout() {
        MainTabs tabs = new MainTabs();
        addComponent(tabs);
        setSizeFull();
    }
}
