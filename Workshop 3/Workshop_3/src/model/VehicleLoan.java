
package model;

import java.text.DecimalFormat;
import view.VehicleView;

public class VehicleLoan {

	private int m_id;
	private String vehicleType;
	private String vehicleAge;
	private double price;
	private double total;
	private double downPayment;
	private double interestRate;
	private int loanPeriod;
	private String loanFrequency;
	private double loanPaymentAmount;

	// Constructors
	public VehicleLoan() {

	}

	public VehicleLoan(int id, String vehicleType, String vehicleAge, double price, double total, double downPayment,
			double interestRate, int loanPeriod, String loanFrequency, double loanPaymentAmount) {
		this.m_id = id;
		this.vehicleType = vehicleType;
		this.vehicleAge = vehicleAge;
		this.price = price;
		this.total = total;
		this.downPayment = downPayment;
		this.interestRate = interestRate;
		this.loanPeriod = loanPeriod;
		this.loanFrequency = loanFrequency;
		this.loanPaymentAmount = loanPaymentAmount;
	}

	public double getTotal() {
		return total;
	}

	@Override
	public String toString() {
		DecimalFormat d = new DecimalFormat("#,###.00");
		return vehicleType + " ID: " + m_id + "\n Age: " + (String) vehicleAge + "\n Price: $" + d.format(price)
				+ "\n Down Payment: $" + d.format(downPayment) + "\n Interest Rate: " + interestRate
				+ "%\n Loan Frequency: " + loanFrequency + "\n Final Price: $" + d.format(total)
				+ "\n Est. Loan Payment: $" + d.format(loanPaymentAmount) + "-" + loanFrequency + "\n\n";
	}

	public int getM_id() {
		return m_id;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public String getVehicleAge() {
		return vehicleAge;
	}

	public double getPrice() {
		return price;
	}

	public double getDownPayment() {
		return downPayment;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public int getLoanPeriod() {
		return loanPeriod;
	}

	public String getLoanFrequency() {
		return loanFrequency;
	}

	public double getLoanPaymentAmount() {
		return loanPaymentAmount;
	}

}
