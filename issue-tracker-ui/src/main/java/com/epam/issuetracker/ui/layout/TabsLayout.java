package com.epam.issuetracker.ui.layout;

import com.epam.issuetracker.ui.tabs.MainTabs;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by Mikita_Hladkikh on 12/12/13.
 */
public class TabsLayout extends VerticalLayout {

    public TabsLayout() {
        MainTabs tabs = new MainTabs();
        addComponent(tabs);
        setSizeFull();
    }
}
