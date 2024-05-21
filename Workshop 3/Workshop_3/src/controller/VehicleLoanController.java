
package controller;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.VehicleLoan;

public class VehicleLoanController implements Initializable {

	@FXML
	private ToggleGroup LPF;

	@FXML
	private Label LPFLabel;

	@FXML
	private Label LPPLabel;

	@FXML
	private Label LPPLabel1;

	@FXML
	private Label ageLabel;

	@FXML
	private ToggleGroup ageOfVehicle;

	@FXML
	private RadioButton biweeklyRBtn;

	@FXML
	private Button calculateBtn;

	@FXML
	private RadioButton carRBtn;

	@FXML
	private Button clearBtn;

	@FXML
	private TextField downPaymentTextField;

	@FXML
	private Label downPaymentLabel;

	@FXML
	private TextField efrlpTextField;

	@FXML
	private RadioButton familyvanRBtn;

	@FXML
	private Label interestRateLabel;

	@FXML
	private TextField interestRateTextField;

	@FXML
	private Slider loanPaymentPeriodSlider;

	@FXML
	private RadioButton monthlyRBtn;

	@FXML
	private RadioButton newRBtn;

	@FXML
	private Label priceLabel;

	@FXML
	private TextField priceTextField;

	@FXML
	private Button savedRatesBtn;

	@FXML
	private Label sliderLabel;

	@FXML
	private RadioButton truckRBtn;

	@FXML
	private Label typeLabel;

	@FXML
	private ToggleGroup typeofvehicle;

	@FXML
	private RadioButton usedRBtn;

	@FXML
	private RadioButton weeklyRBtn;

	@FXML
	private TextArea textArea;

	// Month number showing
	int monthOnSlider;

	// Id for vehicle
	private int id = 0;

	// Arraylist for all Vehicleloan
	private List<VehicleLoan> vehicleLoans = new ArrayList<>();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// Slider and Label
		monthOnSlider = (int) loanPaymentPeriodSlider.getValue();
		sliderLabel.setText(Integer.toString(monthOnSlider));

		loanPaymentPeriodSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				monthOnSlider = (int) loanPaymentPeriodSlider.getValue();
				sliderLabel.setText(Integer.toString(monthOnSlider));
			};
		});

		// Vehicle Price only numbers input
		priceTextField.setOnKeyTyped(e -> {
			String input = e.getCharacter();
			if (!input.matches("[0-9.]")) {
				priceTextField.setText("");
			}
		});

		// Down Payment only numbers input
		downPaymentTextField.setOnKeyTyped(e -> {
			String input = e.getCharacter();
			if (!input.matches("[0-9.]")) {

				downPaymentTextField.setText("");
			}
		});

		// Interest Rate only numbers input
		interestRateTextField.setOnKeyTyped(e -> {
			String input = e.getCharacter();
			if (!input.matches("[0-9.]")) {
				interestRateTextField.setText("");
			}
		});

	}

	// Check if all required fields are filled
	private boolean isInputValid() {
		if (!carRBtn.isSelected() && !truckRBtn.isSelected() && !familyvanRBtn.isSelected()) {
			return false;
		}

		if (!newRBtn.isSelected() && !usedRBtn.isSelected()) {
			return false;
		}

		if (priceTextField.getText().isEmpty() || downPaymentTextField.getText().isEmpty()
				|| interestRateTextField.getText().isEmpty()) {
			return false;
		}
		return true;
	}

	// Show an alert
	private void showAlert(String title, String message) {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}

	@FXML
	void calculate(ActionEvent event) {

		if (!isInputValid()) {
			showAlert("Input Data", "Please fill in all required fields.");
			return;
		}

		String vType = "";
		String vAge = "";
		String loanFreq = "";

		// Type Of Vehicle
		if (carRBtn.isSelected()) {
			vType = "Car";
		}
		if (truckRBtn.isSelected()) {
			vType = "Truck";
		}

		if (familyvanRBtn.isSelected()) {
			vType = "Family Van";
		}

		// Age Of Vehicle
		if (newRBtn.isSelected()) {
			vAge = "New";
		}
		if (usedRBtn.isSelected()) {
			vAge = "Used";
		}

		// Amounts
		double estPaymentValue = 0.0;
		double vPrice = Double.parseDouble(priceTextField.getText());
		double dPrice = Double.parseDouble(downPaymentTextField.getText());
		double rate = Double.parseDouble(interestRateTextField.getText());
		double total = vPrice - dPrice;

		// Loan Frequency
		if (weeklyRBtn.isSelected()) {
			loanFreq = "Weekly";
		} else if (biweeklyRBtn.isSelected()) {
			loanFreq = "Bi-weekly";
		} else {
			loanFreq = "Monthly";
		}

		// Calculation
		if (loanFreq.equals("Weekly")) {
			estPaymentValue = calculateEMI(total, rate / 52 / 100, monthOnSlider * 4);
		}
		if (loanFreq.equals("Bi-weekly")) {
			estPaymentValue = calculateEMI(total, rate / 26 / 100, monthOnSlider * 2);
		}
		if (loanFreq.equals("Monthly")) {
			estPaymentValue = calculateEMI(total, rate / 12 / 100, monthOnSlider);
		}

		// Loan Obj
		VehicleLoan Loan = new VehicleLoan(++id, vType, vAge, vPrice, total, dPrice, rate, monthOnSlider, loanFreq,
				estPaymentValue);

		// Adding in List
		vehicleLoans.add(Loan);

		// Text Area
		DecimalFormat d = new DecimalFormat("#,###.00");
		textArea.setText("$" + d.format(estPaymentValue) + " " + loanFreq);

	}

	// EMI
	double calculateEMI(double principal, double rate, int loanTermInMonth) {
		double amount = principal * (rate * Math.pow(1 + rate, loanTermInMonth))
				/ (Math.pow(1 + rate, loanTermInMonth) - 1);

		return amount;
	}

	// Saved Button
	@FXML
	void savedBtn(ActionEvent ae) {

		Dialog<VehicleLoan> dialog = new Dialog<>();
		dialog.setTitle("Vehicle Loan Details");
		dialog.setHeaderText("List of Vehicle Details");

		ObservableList<VehicleLoan> observableList = FXCollections.observableArrayList(vehicleLoans);
		ListView<VehicleLoan> listView = new ListView<>(observableList);

		DialogPane dialogPane = dialog.getDialogPane();
		dialogPane.setContent(listView);

		dialogPane.getButtonTypes().addAll(ButtonType.CLOSE);
		dialog.showAndWait();
	}

	// Clear Button
	@FXML
	void clearBtn(ActionEvent event) {

		carRBtn.setSelected(false);
		truckRBtn.setSelected(false);
		familyvanRBtn.setSelected(false);
		weeklyRBtn.setSelected(false);
		biweeklyRBtn.setSelected(false);
		monthlyRBtn.setSelected(false);
		newRBtn.setSelected(false);
		usedRBtn.setSelected(false);

		priceTextField.setText("");
		downPaymentTextField.setText("");
		interestRateTextField.setText("");

		textArea.setText("");

		loanPaymentPeriodSlider.valueProperty().set(12.0);

	}

}
