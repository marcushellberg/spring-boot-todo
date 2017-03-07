package com.example;

import com.vaadin.data.Binder;
import com.vaadin.shared.ui.ValueChangeMode;
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
        setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);

        done = new CheckBox();
        text = new TextField();
        text.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
        text.setValueChangeMode(ValueChangeMode.BLUR);

        Binder<Todo> binder = new Binder<>(Todo.class);
        //Binds fields in this class to those in Todo based on their names
        binder.bindInstanceFields(this);
        // The following does the same more explicitly
        // binder.bind(text, Todo::getText, Todo::setText);
        // binder.bind(done, Todo::isDone, Todo::setDone);

        binder.setBean(todo);

        addComponent(done);
        addComponentsAndExpand(text);

        binder.addValueChangeListener(event -> changeListener.todoChanged(todo));
    }
}
