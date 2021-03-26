package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility.HelperClass;

public class ConfirmBooking  extends HelperClass{
public ConfirmBooking() {
PageFactory.initElements(driver,this);
}

@FindBy(xpath=("(//input[@class='disable_text'])[15]"))
private WebElement txtOrder;

public WebElement getTxtOrder() {
	return txtOrder;
}

public void orderNo() {
getAttribute(getTxtOrder());
}





}
