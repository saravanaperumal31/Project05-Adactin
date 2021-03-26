package com.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.utility.HelperClass;

import junit.framework.Assert;

public class BookAHotel extends HelperClass {
	public BookAHotel() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first_name")
	private WebElement txtFirstName;

	@FindBy(id = "last_name")
	private WebElement txtLastName;

	@FindBy(id = "address")
	private WebElement txtAddress;

	@FindBy(id = "book_now")
	private WebElement btnBookNow;

	@FindBy(id = "cc_num")
	private WebElement ccNum;
	@FindBy(id = "cc_type")
	private WebElement ccType;
	@FindBy(id = "cc_exp_month")
	private WebElement ccExpMth;
	@FindBy(id = "cc_exp_year")
	private WebElement ccExpYr;
	@FindBy(id = "cc_cvv")
	private WebElement cvvNum;

	@FindBy(xpath = "//td[text()='Booking Confirmation ']")
	private WebElement txtbookconfirm;

	@FindBy(id = "first_name_span")
	private WebElement txtfirsterror;

	@FindBy(id = "last_name_span")
	private WebElement txtlasterror;

	@FindBy(id = "cc_num_span")
	private WebElement txtcardnumerror;

	@FindBy(id = "cc_type_span")
	private WebElement txtcardtyperror;

	@FindBy(id = "cc_expiry_span")
	private WebElement txtcardexperror;

	@FindBy(id = "cc_cvv_span")
	private WebElement txtcvverror;

	@FindBy(id = "address_span")
	private WebElement txtaddserror;

	@FindBy(xpath = "//a[text()='Booked Itinerary']")
	private WebElement txtbookiternary;

	@FindBy(xpath = "(//input[@class='disable_text'])[15]")
	private WebElement txtorderno;

	@FindBy(id = "order_id_text")
	private WebElement txtorderid;

	@FindBy(id = "search_hotel_id")
	private WebElement txtgo;

	@FindBy(xpath = "(//input[@type='button'])[1]")
	private WebElement txtcancel;

	@FindBy(id = "search_result_error")
	private WebElement txtdelete;

	@FindBy(xpath = "(//input[@type='button'])[1]")
	private WebElement txtbutton;

	public WebElement getTxtbutton() {
		return txtbutton;
	}

	public WebElement getTxtcancel() {
		return txtcancel;
	}

	public WebElement getTxtdelete() {
		return txtdelete;
	}

	public WebElement getTxtgo() {
		return txtgo;
	}

	public WebElement getTxtorderid() {
		return txtorderid;
	}

	public WebElement getTxtorderno() {
		return txtorderno;
	}

	public WebElement getTxtbookiternary() {
		return txtbookiternary;
	}

	public WebElement getTxtfirsterror() {
		return txtfirsterror;
	}

	public WebElement getTxtlasterror() {
		return txtlasterror;
	}

	public WebElement getTxtcardnumerror() {
		return txtcardnumerror;
	}

	public WebElement getTxtcardtyperror() {
		return txtcardtyperror;
	}

	public WebElement getTxtcardexperror() {
		return txtcardexperror;
	}

	public WebElement getTxtcvverror() {
		return txtcvverror;
	}

	public WebElement getTxtaddserror() {
		return txtaddserror;
	}

	public WebElement getTxtbookconfirm() {
		return txtbookconfirm;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getCcNum() {
		return ccNum;
	}

	public WebElement getCcType() {
		return ccType;
	}

	public WebElement getCcExpMth() {
		return ccExpMth;
	}

	public WebElement getCcExpYr() {
		return ccExpYr;
	}

	public WebElement getCvvNum() {
		return cvvNum;
	}

	public WebElement getBtnBookNow() {
		return btnBookNow;
	}

	public void bookAHotel(String FirstName, String LastName, String BillAdds, String CardNo, String CardType,
			String ExpDate, String ExpYear, String CVVNo) {
		filltext(getTxtFirstName(), FirstName);
		filltext(getTxtLastName(), LastName);
		filltext(getTxtAddress(), BillAdds);
		filltext(getCcNum(), CardNo);
		filltext(getCcType(), CardType);
		filltext(getCcExpMth(), ExpDate);
		filltext(getCcExpYr(), ExpYear);
		filltext(getCvvNum(), CVVNo);
		buttonClick(getBtnBookNow());
	}

	public void bookNow() {
		buttonClick(getBtnBookNow());

	}

	public void verifyerrormsg() {
		WebElement txtfirsterror2 = getTxtfirsterror();
		String text = txtfirsterror2.getText();
		Assert.assertEquals("Please Enter your First Name", text);
		WebElement txtlasterror2 = getTxtlasterror();
		String text2 = txtlasterror2.getText();
		Assert.assertEquals("Please Enter you Last Name", text2);
		WebElement txtaddserror2 = getTxtaddserror();
		String text3 = txtaddserror2.getText();
		Assert.assertEquals("Please Enter your Address", text3);
		WebElement txtcardnumerror2 = getTxtcardnumerror();
		String text4 = txtcardnumerror2.getText();
		Assert.assertEquals("Please Enter your 16 Digit Credit Card Number", text4);
		WebElement txtcardtyperror2 = getTxtcardtyperror();
		String text5 = txtcardtyperror2.getText();
		Assert.assertEquals("Please Select your Credit Card Type", text5);
		WebElement txtcardexperror2 = getTxtcardexperror();
		String text6 = txtcardexperror2.getText();
		Assert.assertEquals("Please Select your Credit Card Expiry Month", text6);
		WebElement txtcvverror2 = getTxtcvverror();
		String text7 = txtcvverror2.getText();
		Assert.assertEquals("Please Enter your Credit Card CVV Number", text7);
	}

	public void cancelBooking() {

		String attribute = getAttribute(getTxtorderno());
		buttonClick(getTxtbookiternary());
		submit(getTxtorderid(), attribute);
		buttonClick(getTxtcancel());
		Alert a = driver.switchTo().alert();
		a.accept();
		WebElement txtdelete2 = getTxtdelete();
		String text = txtdelete2.getText();
		Assert.assertEquals("The booking has been cancelled.", text);

	}

	public void bookiternary() {
		buttonClick(getTxtbookiternary());
	}

	public void cancelexixtingorder() {
		buttonClick(getTxtbutton());
		Alert a = driver.switchTo().alert();
		a.accept();
		WebElement txtdelete2 = getTxtdelete();
		String text = txtdelete2.getText();
		Assert.assertEquals("The booking has been cancelled.", text);
	}
}
