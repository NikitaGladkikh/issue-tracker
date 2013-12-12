package com.epam.issuetracker.ui.window;

import com.vaadin.ui.*;


/**
 * Created by Mikita_Hladkikh on 12/12/13.
 */
public class ProjectWindow extends Window {

    private static final String FIELDWIDTH = "250px";
    private static final String BUTTONWIDTH = "100px";

    private TextField name = new TextField("Name");
    private TextField shortName = new TextField("Short Name");
    private TextArea description = new TextArea("Description");

    private Button cancel = new Button("Cancel");
    private Button save = new Button("Save");

    public ProjectWindow() {
        super("Project");
        center();
        setResizable(false);

        name.setWidth(FIELDWIDTH);
        shortName.setWidth(FIELDWIDTH);
        description.setWidth(FIELDWIDTH);

        VerticalLayout fields = new VerticalLayout();
        fields.addComponents(name, shortName, description);
        fields.setSpacing(true);
        fields.setMargin(true);

        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSizeFull();
        save.setWidth(BUTTONWIDTH);
        cancel.setWidth(BUTTONWIDTH);
        buttons.addComponents(save, cancel);
        buttons.setComponentAlignment(save, Alignment.MIDDLE_CENTER);
        buttons.setComponentAlignment(cancel, Alignment.MIDDLE_CENTER);
        buttons.setSpacing(true);
        buttons.setMargin(true);

        cancel.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                close();
            }
        });

        VerticalLayout window = new VerticalLayout();
        window.addComponents(fields, buttons);

        setModal(true);
        setContent(window);


    }
    public ProjectWindow(String name, String shortName, String description) {
        this();
        this.name.setValue(name);
        this.shortName.setValue(shortName);
        this.description.setValue(description);
    }
}
