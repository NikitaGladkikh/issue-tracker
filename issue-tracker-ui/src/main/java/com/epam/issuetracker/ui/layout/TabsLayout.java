package com.epam.issuetracker.ui.layout;

import com.epam.issuetracker.ui.tabs.MainTabs;
import com.vaadin.ui.VerticalLayout;

/**
 * Layout to display main tabs.
 * <p/>
 * Date: 12/12/13
 *
 * @author Mikita_Hladkikh
 */
public class TabsLayout extends VerticalLayout {

    /**
     * Default constructor.
     */
    public TabsLayout() {
        MainTabs mainTabs = new MainTabs();
        addComponent(mainTabs);
        setSizeFull();
    }
}
