package com.epam.issuetracker.ui;

import com.epam.issuetracker.ui.layout.MainLayout;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;

/**
 * Created by Mikita_Hladkikh on 12/11/13.
 */
public class IssueTrackerUi extends UI {

    MainLayout mainLayout;
    @Override
    protected void init(VaadinRequest request) {

        mainLayout = new MainLayout();
        setContent(mainLayout);
        setSizeFull();
    }
}
