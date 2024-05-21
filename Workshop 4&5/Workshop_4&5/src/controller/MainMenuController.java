/**********************************************
Workshop 4&5
Course:APD545 -5th Semester
Last Name:Aman
First Name:Aanand
ID:166125211
Section:ZAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date:2024/03/26
**********************************************/

package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.Inventory;
import model.Part;
import model.Product;

public class MainMenuController implements Initializable {

	@FXML
	private Button addPartBtn;

	@FXML
	private Button addProductBtn;

	@FXML
	private Button deletePartBtn;

	@FXML
	private Button deleteProductBtn;

	@FXML
	private Button exitBtn;

	@FXML
	private Button modifyPartBtn;

	@FXML
	private Button modifyProductBtn;

	@FXML
	private TableColumn<Part, Integer> partIdCol;

	@FXML
	private TableColumn<Part, Integer> partInvCol;

	@FXML
	private TableColumn<Part, String> partNameCol;

	@FXML
	private TableColumn<Part, Double> partPriceCol;

	@FXML
	private TableView<Part> partTableV;

	@FXML
	private TableColumn<Product, Integer> productIdCol;

	@FXML
	private TableColumn<Product, Integer> productInvCol;

	@FXML
	private TableColumn<Product, String> productNameCol;

	@FXML
	private TableColumn<Product, Double> productPriceCol;

	@FXML
	private TableView<Product> productTableV;

	@FXML
	private TextField searchPart;

	@FXML
	private TextField searchProduct;

	// Rows Selection
	public static Part selectedPartRow;
	public static Product selectedProductRow;

	static Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
	public static Optional<ButtonType> confirmResult;
	private static Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
	static Alert errorAlert = new Alert(Alert.AlertType.ERROR);

	@FXML
	void exitMainMenu(ActionEvent event) {
		Platform.exit();
	}

	// Search Part
	@FXML
	void handleSearchPart(KeyEvent event) {
		if (isEntered(event) && isNumber()) {
			searchPartById();
		} else if (isEntered(event) && isString()) {
			searchPartByName();
		} else {
			partTableV.setItems(Inventory.getAllParts());
		}
	}

	// Enter Key Pressed by the Keyboard
	private boolean isEntered(KeyEvent event) {
		return event.getCode().equals(KeyCode.ENTER);
	}

	private void searchPartByName() {
		ObservableList<Part> result = Inventory.searchPartByName(searchPart.getText());
		if (result.size() > 0) {
			partTableV.setItems(result);
		} else {
			infoAlert.setTitle("Information");
			infoAlert.setHeaderText("Part is not found");
			infoAlert.showAndWait();
		}
	}

	private void searchPartById() throws NumberFormatException {
		var part = Inventory.searchPartByID(Integer.parseInt(searchPart.getText()));
		if (part == null) {
			infoAlert.setTitle("Information");
			infoAlert.setHeaderText("Part is not found");
			infoAlert.showAndWait();
		} else {
			ObservableList<Part> result = FXCollections.observableArrayList();
			result.add(part);
			partTableV.setItems(result);
		}
	}

	// This regex matches strings containing only alphabetical characters (both
	// uppercase and lowercase) and spaces.
	private boolean isString() {
		return searchPart.getText() != null && searchPart.getText().matches("^[a-zA-Z\\s]*$");
	}

	// This regex matches strings containing only numeric digits (0-9).
	private boolean isNumber() {
		return searchPart != null && searchPart.getText().matches("^[0-9]*$");
	}

	@FXML
	void handleSearchProduct(KeyEvent event) {
		if (isEntered(event) && isProdNumber()) {
			searchProdById();
		} else if (isEntered(event) && isProdString()) {
			searchProdByName();
		} else {
			productTableV.setItems(Inventory.getAllProducts());
		}

	}

	private void searchProdByName() {
		ObservableList<Product> result = Inventory.searchProductByName(searchProduct.getText());
		if (result.size() > 0) {
			productTableV.setItems(result);
		} else {
			infoAlert.setTitle("Information");
			infoAlert.setHeaderText("Product not found");
			infoAlert.showAndWait();
		}
	}

	private void searchProdById() throws NumberFormatException {
		var prod = Inventory.searchProductByID(Integer.parseInt(searchProduct.getText()));
		if (prod == null) {
			infoAlert.setTitle("Information");
			infoAlert.setHeaderText("Product not found");
			infoAlert.showAndWait();
		} else {
			ObservableList<Product> result = FXCollections.observableArrayList();
			result.add(prod);
			productTableV.setItems(result);
		}
	}

	private boolean isProdString() {
		return searchProduct.getText() != null && searchProduct.getText().matches("^[a-zA-Z\\s]*$");
	}

	private boolean isProdNumber() {
		return searchProduct != null && searchProduct.getText().matches("^[0-9]*$");
	}

	// Add Part Btn
	@FXML
	void handleaddPartBtn(ActionEvent event) throws IOException {

		setScene(event, "/views/addPartForm.fxml");
	}

	// Add Product Btn
	@FXML
	void handleaddProductBtn(ActionEvent event) throws IOException {
		setScene(event, "/views/addProductForm.fxml");

	}

	// Delete Part Btn
	@FXML
	void handledeletePartBtn(ActionEvent event) {
		selectedPartRow = partTableV.getSelectionModel().getSelectedItem();
		if (selectedPartRow == null) {
			infoAlert.setTitle("Information");
			infoAlert.setHeaderText("Please select a row");
			infoAlert.showAndWait();
		} else {
			confirmAlert.setTitle("Part");
			confirmAlert.setHeaderText("Delete");
			confirmAlert.setContentText("Are you sure you want to delete it?");
			confirmResult = confirmAlert.showAndWait();
			if (confirmResult.isPresent() && confirmResult.get() == ButtonType.OK) {
				boolean isDeleted = Inventory.deletePart(selectedPartRow);
				if (!isDeleted) {
					errorAlert.setTitle("Error");
					errorAlert.setHeaderText("Error Occurred");
					errorAlert.setContentText("Error! Try Agaain");
				}
			}
		}

	}

	// Delete Product Btn
	@FXML
	void handledeleteProductBtn(ActionEvent event) {
		Product productSelectedRow = productTableV.getSelectionModel().getSelectedItem();
		Product prod = null;
		if (productSelectedRow == null) {
			infoAlert.setTitle("Information");
			infoAlert.setHeaderText("Please select a row");
			infoAlert.showAndWait();

		} else {
			if (productSelectedRow.getAllAssociatedParts().size() > 0) {
				errorAlert.setTitle("Error");
				errorAlert.setHeaderText("Product");
				errorAlert.setContentText("Product contains Parts, Delete parts first and proceed");
				errorAlert.showAndWait();
			} else {
				confirmAlert.setTitle("Part");
				confirmAlert.setHeaderText("Delete");
				confirmAlert.setContentText("Are you sure you want to delete it?");
				confirmResult = confirmAlert.showAndWait();
				if (confirmResult.isPresent() && confirmResult.get() == ButtonType.OK) {
					for (int i = 0; i < Inventory.getAllProducts().size(); i++) {
						if (Inventory.getAllProducts().get(i).getId() == productSelectedRow.getId()) {
							prod = Inventory.getAllProducts().get(i);
						}
					}
				}
				boolean isDeleted = Inventory.deletedProduct(prod);
				if (!isDeleted) {
					errorAlert.setTitle("Error");
					errorAlert.setHeaderText("Error Occurred");
					errorAlert.setContentText("Error! Try Agaain");
				}
			}
		}
	}

	// Modify Part Btn
	@FXML
	void handlemodifyPartBtn(ActionEvent event) throws IOException {
		selectedPartRow = partTableV.getSelectionModel().getSelectedItem();
		if (selectedPartRow == null) {
			infoAlert.setTitle("Information");
			infoAlert.setHeaderText("Please select a row");
			infoAlert.showAndWait();
		} else
			setScene(event, "/views/modifyPartForm.fxml");
	}

	// MOdify Product Btn
	@FXML
	void handlemodifyProductBtn(ActionEvent event) throws IOException {
		selectedProductRow = productTableV.getSelectionModel().getSelectedItem();
		if (selectedProductRow == null) {
			infoAlert.setTitle("Information");
			infoAlert.setHeaderText("Please select a row");
			infoAlert.showAndWait();
		} else
			setScene(event, "/views/modifyProductForm.fxml");
	}

	// Setting Scene
	private void setScene(ActionEvent event, String s) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource(s));
		var scene = new Scene(parent);
		var stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// Showing table Data
		partIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		partNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		partInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
		partPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
		partTableV.setItems(Inventory.getAllParts());

		productIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		productNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		productInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
		productPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
		productTableV.setItems(Inventory.getAllProducts());

	}

}
