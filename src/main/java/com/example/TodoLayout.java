package com.example;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

import java.util.Arrays;


public class TodoLayout extends HorizontalLayout {
    private final CheckBox done;
    private final TextField text;

    public TodoLayout(Todo todo, TodoChangeListener changeListener) {
        setWidth("100%");
        setSpacing(true);
        setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);

        done = new CheckBox();
        text = new TextField();
        text.setWidth("100%");
        text.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);

        FieldGroup fieldGroup = new FieldGroup(new BeanItem<>(todo));
        fieldGroup.setBuffered(false);
        fieldGroup.bindMemberFields(this);
        addComponents(done, text);
        setExpandRatio(text, 1);

        Arrays.asList(done, text).forEach(field -> {
            field.addValueChangeListener(change -> changeListener.todoChanged(todo));
        });
    }
}
