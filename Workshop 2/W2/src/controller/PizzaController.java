

package controller;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import view.MainView;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.Customer;
import model.Order;

public class PizzaController {

	@FXML
	private CheckBox anchoviesCheckBox;

	@FXML
	private CheckBox baconCheckBox;

	@FXML
	private Button clearBtn;

	@FXML
	private RadioButton crustDeep;

	@FXML
	private RadioButton crustNormal;

	@FXML
	private RadioButton crustThin;

	@FXML
	private ToggleGroup crustType;

	@FXML
	private CheckBox daconCheckBox;

	@FXML
	private CheckBox driedshrimpsCheckBox;

	@FXML
	private CheckBox extracheeseCheckBox;

	@FXML
	private CheckBox grilledChickenCheckBox;

	@FXML
	private CheckBox groundbeefCheckBox;

	@FXML
	private CheckBox hamCheckBox;

	@FXML
	private CheckBox jalapenoCheckBox;

	@FXML
	private CheckBox mushroomsCheckBox;

	@FXML
	private TextField nameF;

	@FXML
	private TextArea ordSumArea;

	@FXML
	private CheckBox pepperoniCheckBox;

	@FXML
	private TextField phoneF;

	@FXML
	private RadioButton piExLarge;

	@FXML
	private RadioButton piLarge;

	@FXML
	private RadioButton piMedium;

	@FXML
	private RadioButton piSmall;

	@FXML
	private CheckBox pineappleCheckBox;

	@FXML
	private ToggleGroup pizzaSize;

	@FXML
	private Button placeOrderBtn;

	@FXML
	private TextField qtyF;

	@FXML
	private CheckBox roastedgarlicCheckBox;

	@FXML
	private CheckBox shreddedCheckbox;

	@FXML
	private CheckBox spinachCheckBox;

	@FXML
	private CheckBox sundriedCheckBox;

	@FXML
	void placeOrder(ActionEvent event) {

		// Order Details
		double subtotal = 0;
		double tax = 0;
		double grandTotal = 0;
		int quantity = 0;

		try {
			quantity = Integer.parseInt(qtyF.getText());

		} catch (NumberFormatException e) {
			System.out.println("Error: Please enter a valid integer for quantity.");
		}

		// Pizza Details
		String piSize = null;
		String crust = null;
		List<String> toppings = new ArrayList<>();

		// Customer Details
		String custName = nameF.getText();
		String custPhone = phoneF.getText();

		// Phone number String to long conversion
		long custPhoneT = Long.parseLong(custPhone);

		// Customer Obj
		Customer c1 = new Customer(custName, custPhoneT);

		// Pizza Type
		if (piSmall.isSelected()) {
			subtotal = subtotal + 7.00;
			piSize = "Small";

		}
		if (piMedium.isSelected()) {
			subtotal = subtotal + 10.00;
			piSize = "Medium";

		}
		if (piLarge.isSelected()) {
			subtotal = subtotal + 13.00;
			piSize = "Large";

		}
		if (piExLarge.isSelected()) {
			subtotal = subtotal + 15.00;
			piSize = "Extra Large";
		}

		// Crust Type
		if (crustNormal.isSelected()) {
			crust = "Normal";
		}
		if (crustThin.isSelected()) {
			crust = "Normal";
		}
		if (crustDeep.isSelected()) {
			crust = "Deep Dish";
		}

		// Toppings
		if (pineappleCheckBox.isSelected()) {
			subtotal = subtotal + 1.10;
			toppings.add("Pineapple");
		}
		if (extracheeseCheckBox.isSelected()) {
			subtotal = subtotal + 1.10;
			toppings.add("Extra Cheese");
		}
		if (driedshrimpsCheckBox.isSelected()) {
			subtotal = subtotal + 1.10;
			toppings.add("Dried Shrimps");
		}
		if (mushroomsCheckBox.isSelected()) {
			subtotal = subtotal + 1.10;
			toppings.add("Mushrooms");
		}
		if (anchoviesCheckBox.isSelected()) {
			subtotal = subtotal + 1.10;
			toppings.add("Anchovies");
		}
		if (sundriedCheckBox.isSelected()) {
			subtotal = subtotal + 1.10;
			toppings.add("Sun Dried Tomatoes");
		}
		if (daconCheckBox.isSelected()) {
			subtotal = subtotal + 1.10;
			toppings.add("Dacon");
		}
		if (spinachCheckBox.isSelected()) {
			subtotal = subtotal + 1.10;
			toppings.add("Spinach");
		}
		if (roastedgarlicCheckBox.isSelected()) {
			subtotal = subtotal + 1.10;
			toppings.add("Roasted Garlic");
		}
		if (jalapenoCheckBox.isSelected()) {
			subtotal = subtotal + 1.10;
			toppings.add("Jalapeno");
		}

		// Meat Toppings
		if (groundbeefCheckBox.isSelected()) {
			subtotal = subtotal + 2.15;
			toppings.add("Ground Beef");
		}
		if (shreddedCheckbox.isSelected()) {
			subtotal = subtotal + 2.15;
			toppings.add("Shredded Chicken");
		}
		if (grilledChickenCheckBox.isSelected()) {
			subtotal = subtotal + 2.15;
			toppings.add("Grilled Chichken");
		}
		if (pepperoniCheckBox.isSelected()) {
			subtotal = subtotal + 2.15;
			toppings.add("Pepperoni");
		}
		if (hamCheckBox.isSelected()) {
			subtotal = subtotal + 2.15;
			toppings.add("Ham");
		}
		if (baconCheckBox.isSelected()) {
			subtotal = subtotal + 2.15;
			toppings.add("Bacon");
		}

		// Billing
		if (quantity > 1) {
			subtotal = subtotal * quantity;
		} else {
			quantity = 1;
		}
		tax = (subtotal * 13) / 100;
		grandTotal = subtotal + tax;

		// Alert
		Alert alert = new Alert(AlertType.CONFIRMATION, "Do you want to confirm your order?", ButtonType.YES,
				ButtonType.NO);
		alert.setTitle("Pizza Order");
		alert.showAndWait();

		if (alert.getResult() == ButtonType.YES) {
			// Final Order
			Order o1 = new Order(quantity, c1, piSize, crust, subtotal, tax, grandTotal, toppings);

			// Display Data
			ordSumArea.setText(MainView.Data(o1));
			ordSumArea.setEditable(false);

		} else {
			ordSumArea.setText("No Order Placed! \n Try Again");
			ordSumArea.setEditable(false);
		}

	}

	@FXML
	void clearBtn(ActionEvent event) {

		// Text Fields
		nameF.setText("");
		phoneF.setText("");
		qtyF.setText("");

		// Pizza Size
		piSmall.setSelected(false);
		piMedium.setSelected(false);
		piLarge.setSelected(false);
		piExLarge.setSelected(false);

		// Crust Type
		crustNormal.setSelected(false);
		crustThin.setSelected(false);
		crustDeep.setSelected(false);

		// Toppings
		pineappleCheckBox.setSelected(false);
		extracheeseCheckBox.setSelected(false);
		driedshrimpsCheckBox.setSelected(false);
		mushroomsCheckBox.setSelected(false);
		anchoviesCheckBox.setSelected(false);
		sundriedCheckBox.setSelected(false);
		daconCheckBox.setSelected(false);
		spinachCheckBox.setSelected(false);
		roastedgarlicCheckBox.setSelected(false);
		jalapenoCheckBox.setSelected(false);
		groundbeefCheckBox.setSelected(false);
		shreddedCheckbox.setSelected(false);
		grilledChickenCheckBox.setSelected(false);
		pepperoniCheckBox.setSelected(false);
		hamCheckBox.setSelected(false);
		baconCheckBox.setSelected(false);

		// Text Area
		ordSumArea.setText("");

	}

}
