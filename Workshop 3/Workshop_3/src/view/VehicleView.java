package view;

import java.text.DecimalFormat;

import model.VehicleLoan;

public class VehicleView {

	public static String displayDialog(VehicleLoan v) {

		DecimalFormat d = new DecimalFormat("#,###.00");
		
		return v.getVehicleType() + " ID: " + v.getM_id() + "\n Age: " + (String) v.getVehicleAge() + "\n Price: $" + d.format(v.getPrice())
				+ "\n Down Payment: $" + d.format(v.getDownPayment()) + "\n Interest Rate: " + v.getInterestRate()
				+ "%\n Loan Frequency: " + v.getLoanFrequency() + "\n Final Price: $" + d.format(v.getTotal())
				+ "\n Est. Loan Payment: $" + d.format(v.getLoanPaymentAmount()) + "-" + v.getLoanFrequency() + "\n\n";

	}

}
