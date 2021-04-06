package app.views.login;

import app.views.Window;
import javax.swing.*;
import rojerusan.RSMaterialButtonRectangle;
import rojerusan.RSPasswordTextPlaceHolder;

public class LoginLayout extends Window {

    protected JPanel body;
    protected JPanel landing;
    protected JLabel formTitle;
    protected JTextField usernameField;
    protected RSPasswordTextPlaceHolder passwordField;
    protected JLabel userIcon;
    protected JLabel passwordIcon;
    protected JLabel usernamePadding;
    protected JLabel passwordPadding;
    protected RSMaterialButtonRectangle signInButton;
    protected RSMaterialButtonRectangle signUpButton;

    public LoginLayout() {
        body = new JPanel();
        landing = new JPanel();
        signInButton = new RSMaterialButtonRectangle();
        signUpButton = new RSMaterialButtonRectangle();
        formTitle = new JLabel();
        usernameField = new JTextField();
        passwordField = new RSPasswordTextPlaceHolder();
        usernamePadding = new JLabel();
        passwordPadding = new JLabel();
        userIcon = new JLabel();
        passwordIcon = new JLabel();
    }

    public void layoutConfiguration() {
        GroupLayout bodyLayout = new GroupLayout(body);
        body.setLayout(bodyLayout);

        bodyLayout.setHorizontalGroup(
            bodyLayout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(
                    bodyLayout
                        .createSequentialGroup()
                        .addComponent(
                            landing,
                            GroupLayout.PREFERRED_SIZE,
                            439,
                            GroupLayout.PREFERRED_SIZE
                        )
                        .addPreferredGap(
                            LayoutStyle.ComponentPlacement.RELATED,
                            80,
                            Short.MAX_VALUE
                        )
                        .addGroup(
                            bodyLayout
                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(
                                    GroupLayout.Alignment.TRAILING,
                                    bodyLayout
                                        .createSequentialGroup()
                                        .addGroup(
                                            bodyLayout
                                                .createParallelGroup(
                                                    GroupLayout.Alignment.LEADING,
                                                    false
                                                )
                                                .addComponent(
                                                    signInButton,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    0,
                                                    Short.MAX_VALUE
                                                )
                                                .addComponent(
                                                    signUpButton,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    0,
                                                    Short.MAX_VALUE
                                                )
                                                .addComponent(
                                                    formTitle,
                                                    GroupLayout.DEFAULT_SIZE,
                                                    214,
                                                    Short.MAX_VALUE
                                                )
                                        )
                                        .addGap(91, 91, 91)
                                )
                                .addGroup(
                                    GroupLayout.Alignment.TRAILING,
                                    bodyLayout
                                        .createSequentialGroup()
                                        .addGroup(
                                            bodyLayout
                                                .createParallelGroup(
                                                    GroupLayout.Alignment.LEADING
                                                )
                                                .addGroup(
                                                    bodyLayout
                                                        .createSequentialGroup()
                                                        .addComponent(
                                                            usernamePadding,
                                                            GroupLayout.PREFERRED_SIZE,
                                                            10,
                                                            GroupLayout.PREFERRED_SIZE
                                                        )
                                                        .addGap(0, 0, 0)
                                                        .addComponent(
                                                            usernameField,
                                                            GroupLayout.PREFERRED_SIZE,
                                                            200,
                                                            GroupLayout.PREFERRED_SIZE
                                                        )
                                                        .addGap(0, 0, 0)
                                                        .addComponent(
                                                            passwordIcon,
                                                            GroupLayout.PREFERRED_SIZE,
                                                            34,
                                                            GroupLayout.PREFERRED_SIZE
                                                        )
                                                )
                                                .addGroup(
                                                    bodyLayout
                                                        .createSequentialGroup()
                                                        .addComponent(
                                                            passwordPadding,
                                                            GroupLayout.PREFERRED_SIZE,
                                                            10,
                                                            GroupLayout.PREFERRED_SIZE
                                                        )
                                                        .addGap(0, 0, 0)
                                                        .addComponent(
                                                            passwordField,
                                                            GroupLayout.PREFERRED_SIZE,
                                                            GroupLayout.DEFAULT_SIZE,
                                                            GroupLayout.PREFERRED_SIZE
                                                        )
                                                        .addGap(0, 0, 0)
                                                        .addComponent(
                                                            userIcon,
                                                            GroupLayout.PREFERRED_SIZE,
                                                            34,
                                                            GroupLayout.PREFERRED_SIZE
                                                        )
                                                )
                                        )
                                        .addGap(74, 74, 74)
                                )
                                .addGroup(
                                    GroupLayout.Alignment.TRAILING,
                                    bodyLayout
                                        .createSequentialGroup()
                                        .addComponent(
                                            getMinimize(),
                                            GroupLayout.PREFERRED_SIZE,
                                            30,
                                            GroupLayout.PREFERRED_SIZE
                                        )
                                        .addGap(0, 0, 0)
                                        .addComponent(
                                            getClose(),
                                            GroupLayout.PREFERRED_SIZE,
                                            20,
                                            GroupLayout.PREFERRED_SIZE
                                        )
                                        .addContainerGap()
                                )
                        )
                )
        );
        bodyLayout.setVerticalGroup(
            bodyLayout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(
                    landing,
                    GroupLayout.DEFAULT_SIZE,
                    GroupLayout.DEFAULT_SIZE,
                    Short.MAX_VALUE
                )
                .addGroup(
                    bodyLayout
                        .createSequentialGroup()
                        .addGroup(
                            bodyLayout
                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(
                                    getMinimize(),
                                    GroupLayout.PREFERRED_SIZE,
                                    30,
                                    GroupLayout.PREFERRED_SIZE
                                )
                                .addComponent(
                                    getClose(),
                                    GroupLayout.PREFERRED_SIZE,
                                    30,
                                    GroupLayout.PREFERRED_SIZE
                                )
                        )
                        .addGap(11, 11, 11)
                        .addComponent(
                            formTitle,
                            GroupLayout.PREFERRED_SIZE,
                            68,
                            GroupLayout.PREFERRED_SIZE
                        )
                        .addGap(112, 112, 112)
                        .addGroup(
                            bodyLayout
                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(
                                    usernamePadding,
                                    GroupLayout.PREFERRED_SIZE,
                                    30,
                                    GroupLayout.PREFERRED_SIZE
                                )
                                .addComponent(
                                    usernameField,
                                    GroupLayout.PREFERRED_SIZE,
                                    30,
                                    GroupLayout.PREFERRED_SIZE
                                )
                                .addComponent(
                                    passwordIcon,
                                    GroupLayout.PREFERRED_SIZE,
                                    30,
                                    GroupLayout.PREFERRED_SIZE
                                )
                        )
                        .addGap(10, 10, 10)
                        .addGroup(
                            bodyLayout
                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(
                                    passwordPadding,
                                    GroupLayout.PREFERRED_SIZE,
                                    30,
                                    GroupLayout.PREFERRED_SIZE
                                )
                                .addComponent(
                                    passwordField,
                                    GroupLayout.PREFERRED_SIZE,
                                    30,
                                    GroupLayout.PREFERRED_SIZE
                                )
                                .addComponent(
                                    userIcon,
                                    GroupLayout.PREFERRED_SIZE,
                                    30,
                                    GroupLayout.PREFERRED_SIZE
                                )
                        )
                        .addGap(51, 51, 51)
                        .addComponent(
                            signInButton,
                            GroupLayout.PREFERRED_SIZE,
                            46,
                            GroupLayout.PREFERRED_SIZE
                        )
                        .addComponent(
                            signUpButton,
                            GroupLayout.PREFERRED_SIZE,
                            46,
                            GroupLayout.PREFERRED_SIZE
                        )
                        .addGap(51, 51, 51)
                )
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(
                    body,
                    GroupLayout.DEFAULT_SIZE,
                    GroupLayout.DEFAULT_SIZE,
                    Short.MAX_VALUE
                )
        );
        layout.setVerticalGroup(
            layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(
                    body,
                    GroupLayout.DEFAULT_SIZE,
                    GroupLayout.DEFAULT_SIZE,
                    Short.MAX_VALUE
                )
        );
    }
}
