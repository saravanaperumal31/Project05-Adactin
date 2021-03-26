package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility.HelperClass;

public class SelectHotel extends HelperClass {
public SelectHotel() {
PageFactory.initElements(driver,this);

}

@FindBy(id="radiobutton_0")
private WebElement btnHotel;

@FindBy(id="continue")
private WebElement btnContinue;

public WebElement getBtnHotel() {
	return btnHotel;
}

public WebElement getBtnContinue() {
	return btnContinue;
}

public void selectHotelPage() {
	buttonClick(getBtnHotel());
	buttonClick(getBtnContinue());
}


}
