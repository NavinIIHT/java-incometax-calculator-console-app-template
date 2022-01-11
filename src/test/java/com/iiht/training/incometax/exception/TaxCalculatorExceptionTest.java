package com.iiht.training.incometax.exception;

import static com.iiht.training.incometax.testutils.TestUtils.currentTest;
import static com.iiht.training.incometax.testutils.TestUtils.exceptionTestFile;
import static com.iiht.training.incometax.testutils.TestUtils.testReport;
import static com.iiht.training.incometax.testutils.TestUtils.yakshaAssert;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.iiht.training.incometax.calculator.TaxCalculator;
import com.iiht.training.incometax.model.Employee;
import com.iiht.training.incometax.testutils.MasterData;

class TaxCalculatorExceptionTest {

	static TaxCalculator calculator = null;

	@BeforeAll
	public static void setUp() {
		calculator = new TaxCalculator();
		calculator.employees = MasterData.getEmployeeList();
		calculator.deductions = MasterData.getDeductionsList();
		calculator.taxDetails = MasterData.getTaxDetailsList();
	}

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testPANCardAlreadyExistsException() throws IOException {
		Employee employee = calculator.employees.get(0);
		employee.setPAN("BLHPT1010K");
		PANAlreadyExistsException thrown = Assertions.assertThrows(PANAlreadyExistsException.class, () -> {
			calculator.addEmployee(employee);
		});
		String message = "PAN Details Already Exists";
		yakshaAssert(currentTest(), message.contentEquals(thrown.getMessage()) ? true : false, exceptionTestFile);

	}

	@Test
	public void testPANDoesNotExistsException() throws IOException {
		Employee employee = MasterData.getEmployeeData();
		employee.setPAN("BLBAK2312C");
		PANDoesNotExistsException thrown = Assertions.assertThrows(PANDoesNotExistsException.class, () -> {
			calculator.showTaxableSalary(employee.getPAN());
		});
		String message = "PAN Does not Exists";
		yakshaAssert(currentTest(), message.contentEquals(thrown.getMessage()) ? true : false, exceptionTestFile);

	}

	@Test
	public void testPANDetailsNotProvidedException() throws IOException {
		Employee employee = MasterData.getEmployeeData();
		employee.setPAN("");
		PANDetailsNotProvidedException thrown = Assertions.assertThrows(PANDetailsNotProvidedException.class, () -> {
			calculator.addEmployee(employee);
		});
		String message = "PAN Details are not provided";
		yakshaAssert(currentTest(), message.contentEquals(thrown.getMessage()) ? true : false, exceptionTestFile);

	}
}
