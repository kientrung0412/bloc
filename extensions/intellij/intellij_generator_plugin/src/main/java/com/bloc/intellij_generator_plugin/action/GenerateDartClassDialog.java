package com.bloc.intellij_generator_plugin.action;

import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class GenerateDartClassDialog extends DialogWrapper {
    private final GenerateBlocDialog.Listener listener;
    private JPanel contentPane;
    private JTextField fieldClassName;


    public GenerateDartClassDialog(GenerateBlocDialog.Listener listener) {
        super(null);
        this.listener = listener;
        init();
    }

    @Override
    protected void doOKAction() {
        listener.onGenerateBlocClicked(fieldClassName.getText(), false);
        super.doOKAction();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return contentPane;
    }
}
