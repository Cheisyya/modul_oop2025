import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private PasswordField textFieldPassword;

    @FXML
    private TextField textFieldUsername;

    @FXML
    void LoginFunction(ActionEvent event) {
        String username = textFieldUsername.getText();
        String password = textFieldPassword.getText();

        if (username.equals("Valda") && password.equals("2909")) {
            try {
                Parent playlistController = FXMLLoader.load(getClass().getResource("Playlist.fxml"));
                Scene playlistControllerScene = new Scene(playlistController);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(playlistControllerScene);
                stage.show();
            } catch (IOException e) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Terjadi kesalahan. Silakan coba lagi.");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Salah username atau password");
            alert.setContentText("Silahkan cek kembali username atau password anda");
            alert.showAndWait();
        }
    }
}
