import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PlaylistController {
    @FXML
    private TextField albumNameField;
    @FXML
    private TextField artistField;
   
    @FXML
    private TableView<Album> albumTableView;
    @FXML
    private TableColumn<Album, String> AlbumNameColumn;
    @FXML
    private TableColumn<Album, String> artistColumn;

    private ObservableList<Album> albumList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        AlbumNameColumn.setCellValueFactory(new PropertyValueFactory<>("namaAlbum"));
        artistColumn.setCellValueFactory(new PropertyValueFactory<>("artist"));
        albumTableView.setItems(albumList);
    }

    @FXML
    void handleMouseClick(MouseEvent event) {
        Album selectedAlbum = albumTableView.getSelectionModel().getSelectedItem();
        if (selectedAlbum != null) {
            albumNameField.setText(selectedAlbum.getnamaAlbum());
            artistField.setText(selectedAlbum.getArtist());
        }
    }

    @FXML
    void handleTambah(ActionEvent event) {
        try {
            String albumName = albumNameField.getText();
            String artist = artistField.getText();

            Album newAlbum = new Album(albumName, artist);
            albumList.add(newAlbum);
            clearFields();
            showAlert(Alert.AlertType.INFORMATION, "Album Ditambahkan", "Album baru dengan nama \"" + albumName + "\" berhasil ditambahkan");
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Kesalahan Input", "Silakan isi dengan benar");
        } catch (IllegalArgumentException e) {
            showAlert(Alert.AlertType.ERROR, "Kesalahan Input", "Silakan isi semua kolom dengan benar");
        }
    }

    private void clearFields() {
        albumNameField.clear();
        artistField.clear();
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}