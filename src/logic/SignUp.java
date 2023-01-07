package logic;

import tictactoe.java.SignUpScreenBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SignUp {

    public SignUpScreenBase signUpScreenBase;
    public ClientSide clientSide;

    String userName;
    String password;
    String confirmPassword;
    String email;
    String gender;
    ActionEvent actionEvent;

    public SignUp() {
        signUpScreenBase = new SignUpScreenBase();
        clientSide = ClientSide.getInstanse();
        signUpButton();
    }

    public String[] signUpTextFields() {
        userName = signUpScreenBase.userNameTextField.getText();
        password = signUpScreenBase.passwordTextField.getText();
        confirmPassword = signUpScreenBase.confirmTextField.getText();
        email = signUpScreenBase.emailTextField.getText();
        gender = signUpScreenBase.getGender(actionEvent);
        boolean isValiad = signUpScreenBase.validEmail(email);
        
        if (isValiad || confirmPassword.equals(password) || userName != null || gender=="Not Selected") {
            String[] data = {userName, password, confirmPassword, email, gender};
            return data;
        }
        
        return null;
    }

    public final void signUpButton() {

        signUpScreenBase.signUpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clientSide.ps.println("I clicked signup");
                if (signUpTextFields() != null) {
                    String[] signUpData = signUpTextFields();
                    for (int i = 0; i < signUpData.length; i++) {
                        clientSide.ps.println(signUpData[i]);
                    }
                }
            }
        });

    }
}
