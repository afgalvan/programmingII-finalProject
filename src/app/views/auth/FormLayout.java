package app.views.auth;

import javax.swing.*;

public class FormLayout {

    private final AuthForm form;
    private final GroupLayout layout;

    public FormLayout(AuthForm form) {
        this.form = form;
        this.layout = new GroupLayout(form);
        configureLayout();
    }

    private void configureLayout() {
        form.setLayout(layout);
        configureHorizontalLayout();
        configureVerticalLayout();
    }

    private void configureHorizontalLayout() {
        layout.setHorizontalGroup(
            layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(
                    layout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(
                            GroupLayout.Alignment.TRAILING,
                            layout
                                .createSequentialGroup()
                                .addGroup(
                                    layout
                                        .createParallelGroup(
                                            GroupLayout.Alignment.LEADING,
                                            false
                                        )
                                        .addComponent(
                                            form.signInButton,
                                            GroupLayout.PREFERRED_SIZE,
                                            0,
                                            Short.MAX_VALUE
                                        )
                                        .addComponent(
                                            form.signUpButton,
                                            GroupLayout.PREFERRED_SIZE,
                                            0,
                                            Short.MAX_VALUE
                                        )
                                        .addComponent(
                                            form.title,
                                            GroupLayout.DEFAULT_SIZE,
                                            214,
                                            Short.MAX_VALUE
                                        )
                                )
                                .addGap(91, 91, 91)
                        )
                        .addGroup(
                            GroupLayout.Alignment.TRAILING,
                            layout
                                .createSequentialGroup()
                                .addGroup(
                                    layout
                                        .createParallelGroup(
                                            GroupLayout.Alignment.CENTER
                                        )
                                        .addGroup(
                                            layout
                                                .createSequentialGroup()
                                                .addComponent(
                                                    form.usernamePadding,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    10,
                                                    GroupLayout.PREFERRED_SIZE
                                                )
                                                .addGap(0, 0, 0)
                                                .addComponent(
                                                    form.usernameField,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    200,
                                                    GroupLayout.PREFERRED_SIZE
                                                )
                                                .addGap(0, 0, 0)
                                                .addComponent(
                                                    form.passwordIcon,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    34,
                                                    GroupLayout.PREFERRED_SIZE
                                                )
                                        )
                                        .addGroup(
                                            layout
                                                .createSequentialGroup()
                                                .addComponent(
                                                    form.passwordPadding,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    10,
                                                    GroupLayout.PREFERRED_SIZE
                                                )
                                                .addGap(0, 0, 0)
                                                .addComponent(
                                                    form.passwordField,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.DEFAULT_SIZE,
                                                    GroupLayout.PREFERRED_SIZE
                                                )
                                                .addGap(0, 0, 0)
                                                .addComponent(
                                                    form.userIcon,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    34,
                                                    GroupLayout.PREFERRED_SIZE
                                                )
                                        )
                                )
                                .addGap(74, 425, 425)
                        )
                        .addGroup(
                            GroupLayout.Alignment.TRAILING,
                            layout
                                .createSequentialGroup()
                                .addComponent(
                                    form.window.getMinimize(),
                                    GroupLayout.PREFERRED_SIZE,
                                    30,
                                    GroupLayout.PREFERRED_SIZE
                                )
                                .addGap(0, 0, 0)
                                .addComponent(
                                    form.window.getClose(),
                                    GroupLayout.PREFERRED_SIZE,
                                    20,
                                    GroupLayout.PREFERRED_SIZE
                                )
                                .addContainerGap()
                        )
                )
        );
    }

    private void configureVerticalLayout() {
        layout.setVerticalGroup(
            layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(
                    layout
                        .createSequentialGroup()
                        .addGroup(
                            layout
                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(
                                    form.window.getMinimize(),
                                    GroupLayout.PREFERRED_SIZE,
                                    30,
                                    GroupLayout.PREFERRED_SIZE
                                )
                                .addComponent(
                                    form.window.getClose(),
                                    GroupLayout.PREFERRED_SIZE,
                                    30,
                                    GroupLayout.PREFERRED_SIZE
                                )
                        )
                        .addGap(11, 11, 11)
                        .addComponent(
                            form.title,
                            GroupLayout.PREFERRED_SIZE,
                            68,
                            GroupLayout.PREFERRED_SIZE
                        )
                        .addGap(112, 112, 112)
                        .addGroup(
                            layout
                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(
                                    form.usernamePadding,
                                    GroupLayout.PREFERRED_SIZE,
                                    30,
                                    GroupLayout.PREFERRED_SIZE
                                )
                                .addComponent(
                                    form.usernameField,
                                    GroupLayout.PREFERRED_SIZE,
                                    30,
                                    GroupLayout.PREFERRED_SIZE
                                )
                                .addComponent(
                                    form.passwordIcon,
                                    GroupLayout.PREFERRED_SIZE,
                                    30,
                                    GroupLayout.PREFERRED_SIZE
                                )
                        )
                        .addGap(10, 10, 10)
                        .addGroup(
                            layout
                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(
                                    form.passwordPadding,
                                    GroupLayout.PREFERRED_SIZE,
                                    30,
                                    GroupLayout.PREFERRED_SIZE
                                )
                                .addComponent(
                                    form.passwordField,
                                    GroupLayout.PREFERRED_SIZE,
                                    30,
                                    GroupLayout.PREFERRED_SIZE
                                )
                                .addComponent(
                                    form.userIcon,
                                    GroupLayout.PREFERRED_SIZE,
                                    30,
                                    GroupLayout.PREFERRED_SIZE
                                )
                        )
                        .addGap(51, 51, 51)
                        .addComponent(
                            form.signInButton,
                            GroupLayout.PREFERRED_SIZE,
                            46,
                            GroupLayout.PREFERRED_SIZE
                        )
                        .addComponent(
                            form.signUpButton,
                            GroupLayout.PREFERRED_SIZE,
                            46,
                            GroupLayout.PREFERRED_SIZE
                        )
                        .addGap(51, 51, 51)
                )
        );
    }
}
