package com.epam.issuetracker.ui.layout;

import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.VerticalLayout;


/**
 * Main layout of the application.
 * <p/>
 * Date: 12/11/13
 *
 * @author Mikita_Hladkikh
 */
public class MainLayout extends VerticalLayout {

    private HorizontalSplitPanel horizontalSplitPanel = new HorizontalSplitPanel();

    /**
     * Default constructor.
     */
    public MainLayout() {
        init();
        addComponent(horizontalSplitPanel);
        setSizeFull();
    }

    private void init() {
        horizontalSplitPanel.setSplitPosition(20, Unit.PERCENTAGE);
        horizontalSplitPanel.setSizeFull();
        horizontalSplitPanel.setLocked(true);
        horizontalSplitPanel.setFirstComponent(new ProjectsLayout());
        horizontalSplitPanel.setSecondComponent(new TabsLayout());
    }
}
