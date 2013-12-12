package com.epam.issuetracker.ui.layout;

import com.epam.issuetracker.ui.window.ProjectWindow;
import com.vaadin.ui.*;

/**
 * Created by Mikita_Hladkikh on 12/12/13.
 */
public class ProjectLayout extends VerticalLayout {
    private Label prjName = new Label();
    private Label prjShortName = new Label();
    private Label prjDescription = new Label();

    private Button edit = new Button("Edit");
    private Button delete = new Button("Delete");

    public ProjectLayout() {

        Label name = new Label("Name");
        Label shortName = new Label("Short Name");
        Label description = new Label("Description");

        edit.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                ProjectWindow sub;
                sub = new ProjectWindow(prjName.getValue(), prjShortName.getValue(), prjDescription.getValue());
                UI.getCurrent().addWindow(sub);
            }
        });


        prjName.setValue("Project_1");
        prjShortName.setValue("prj_1");

        HorizontalLayout layName = newHorLayout(name, prjName);
        layName.setSizeUndefined();
        HorizontalLayout layShortName = newHorLayout(shortName, prjShortName);
        layShortName.setSizeUndefined();
        HorizontalLayout buttons = newHorLayout(edit, delete);
        buttons.setSizeFull();
        buttons.setComponentAlignment(delete, Alignment.MIDDLE_RIGHT);

        VerticalLayout vDescription = new VerticalLayout();
        prjDescription.setValue("Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 vv");
        vDescription.addComponent(description);
        vDescription.addComponent(prjDescription);
        vDescription.setSpacing(true);
        vDescription.setMargin(true);

        addComponents(layName, layShortName, vDescription, buttons);

        setExpandRatio(layName, 1.0f);
        setExpandRatio(layShortName, 1.0f);
        setExpandRatio(vDescription, 10.0f);
        setExpandRatio(buttons, 1.0f);

        setSizeFull();
    }

    private HorizontalLayout newHorLayout(Component component1, Component component2) {
        HorizontalLayout hor = new HorizontalLayout();
        hor.addComponent(component1);
        hor.addComponent(component2);
        hor.setSpacing(true);
        hor.setMargin(true);
        return hor;
    }
}
