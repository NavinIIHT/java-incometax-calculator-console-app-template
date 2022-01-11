package com.iiht.training.incometax.calculator;

import java.util.ArrayList;
import java.util.List;

import com.iiht.training.incometax.exception.InvalidPANException;
import com.iiht.training.incometax.exception.PANAlreadyExistsException;
import com.iiht.training.incometax.exception.PANDetailsNotProvidedException;
import com.iiht.training.incometax.exception.PANDoesNotExistsException;
import com.iiht.training.incometax.model.Deductions;
import com.iiht.training.incometax.model.Employee;
import com.iiht.training.incometax.model.TaxDetails;

public class TaxCalculator {

	public List<Employee> employees = new ArrayList<>();
	public List<Deductions> deductions = new ArrayList<>();
	public List<TaxDetails> taxDetails = new ArrayList<>();

	public boolean addEmployee(Employee employee) {

		return false;

	}

	public Double getTotalDeductions(String PAN, double sec80c, double houseRent) {
		// total deductions = pf + sec80c + houseRent
		// pf = basic_salary * 12%
		return 0.0;

	}

	public Double showTaxableSalary(String PAN) {
		// Taxable salary = gross salary - total deductions
		return 0.0;
	}

	public double calculateTotalTax(String PAN) {
		// calculate total tax and add to TaxDetails List
		return 0.0;
	}

	public List<TaxDetails> getTaxDetails() {
		return null;
	}

	private Deductions getDeductionForEmployee(String PAN) {
		for (Deductions deduction : deductions) {
			if (deduction.getPAN().equalsIgnoreCase(PAN)) {
				return deduction;
			}
		}
		return null;
	}

	private Employee getEmployee(String PAN) {
		for (Employee emp : employees) {
			if (emp.getPAN().equalsIgnoreCase(PAN)) {
				return emp;
			}
		}
		throw new PANDoesNotExistsException("PAN Does not Exists");
	}

	private boolean panExists(String pan) {
		for (Employee emp : employees) {
			if (emp.getPAN().equalsIgnoreCase(pan)) {
				return true;
			}
		}
		return false;
	}

}
