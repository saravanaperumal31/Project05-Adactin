package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility.HelperClass;

public class LoginPage extends HelperClass {
	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "username")
	private WebElement txtUserName;

	@FindBy(id = "password")
	private WebElement txtPassWord;

	@FindBy(id = "login")
	private WebElement btnLogin;

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassWord() {
		return txtPassWord;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public void loginPage(String userName, String password) {
		filltext(getTxtUserName(), userName);
		filltext(getTxtPassWord(), password);
		buttonClick(getBtnLogin());
	}

}
