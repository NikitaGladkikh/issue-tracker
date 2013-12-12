package com.epam.issuetracker.ui.layout;

import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.VerticalLayout;


/**
 * Created by Mikita_Hladkikh on 12/11/13.
 */
public class MainLayout extends VerticalLayout {

    public MainLayout() {
        HorizontalSplitPanel horizontalSplitPanel = new HorizontalSplitPanel();

        horizontalSplitPanel.setSplitPosition(20, Unit.PERCENTAGE);
        horizontalSplitPanel.setSizeFull();
        horizontalSplitPanel.setLocked(true);
        horizontalSplitPanel.setFirstComponent(new ProjectsLayout());
        horizontalSplitPanel.setSecondComponent(new TabsLayout());

        addComponent(horizontalSplitPanel);
        setSizeFull();
    }


}
