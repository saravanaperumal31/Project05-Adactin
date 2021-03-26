package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility.HelperClass;

import junit.framework.Assert;

public class SearchHotel extends HelperClass {
	public SearchHotel() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "location")
	private WebElement drpLocation;

	@FindBy(id = "hotels")
	private WebElement drpHotel;

	@FindBy(id = "room_type")
	private WebElement drpRoomType;

	@FindBy(id = "room_nos")
	private WebElement drpRoomNo;

	@FindBy(id = "datepick_in")
	private WebElement txtChechInDate;

	@FindBy(id = "datepick_out")
	private WebElement txtChechOutDate;

	@FindBy(id = "adult_room")
	private WebElement drpAdultRoom;

	@FindBy(id = "child_room")
	private WebElement drpChildPerRoom;

	@FindBy(id = "Submit")
	private WebElement btnSearch;

	@FindBy(xpath = "//td[text()='Select Hotel ']")
	private WebElement txtselect;

	@FindBy(xpath = "//span[text()='Check-In Date shall be before than Check-Out Date']")
	private WebElement txtcinerror;

	@FindBy(id = "//span[text()='Check-Out Date shall be after than Check-In Date']")
	private WebElement txtcouterror;

	@FindBy(id = "location_span")
	private WebElement txtselectloc;

	public WebElement getTxtselectloc() {
		return txtselectloc;
	}

	public WebElement getTxtcinerror() {
		return txtcinerror;
	}

	public WebElement getTxtcouterror() {
		return txtcouterror;
	}

	public WebElement getTxtselect() {
		return txtselect;
	}

	public WebElement getDrpLocation() {
		return drpLocation;
	}

	public WebElement getDrpHotel() {
		return drpHotel;
	}

	public WebElement getDrpRoomType() {
		return drpRoomType;
	}

	public WebElement getDrpRoomNo() {
		return drpRoomNo;
	}

	public WebElement getTxtChechInDate() {
		return txtChechInDate;
	}

	public WebElement getTxtChechOutDate() {
		return txtChechOutDate;
	}

	public WebElement getDrpAdultRoom() {
		return drpAdultRoom;
	}

	public WebElement getDrpChildPerRoom() {
		return drpChildPerRoom;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}

	public void SearchHotelpage(String Location, String Hotels, String RoomType, String NumberOfRooms,
			String CheckInDate, String CheckOutDate, String AdultsPerRoom, String ChildrenPerPerson) {
		selectByVisibleText(getDrpLocation(), Location);
		selectByVisibleText(getDrpHotel(), Hotels);
		selectByVisibleText(getDrpRoomType(), RoomType);
		selectByVisibleText(getDrpRoomNo(), NumberOfRooms);
		clear(getTxtChechInDate());
		filltext(getTxtChechInDate(), CheckInDate);
		clear(getTxtChechOutDate());
		filltext(getTxtChechOutDate(), CheckOutDate);
		selectByVisibleText(getDrpAdultRoom(), AdultsPerRoom);
		selectByVisibleText(getDrpChildPerRoom(), ChildrenPerPerson);
		buttonClick(getBtnSearch());
	}

	public void selectHotelVerify() {

		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals("Verify the url", "http://adactinhotelapp.com/SelectHotel.php", currentUrl);
	}

	public void mandatoryFields(String Location, String NumberOfRooms, String CheckInDate, String CheckOutDate,
			String AdultsPerRoom) {
		selectByVisibleText(getDrpLocation(), Location);
		selectByVisibleText(getDrpRoomNo(), NumberOfRooms);
		filltext(getTxtChechInDate(), CheckInDate);
		filltext(getTxtChechOutDate(), CheckOutDate);
		selectByVisibleText(getDrpAdultRoom(), AdultsPerRoom);
		buttonClick(getBtnSearch());

	}

	public void datecheck(String CheckInDate, String CheckOutDate) {
		clear(getTxtChechInDate());
		filltext(getTxtChechInDate(), CheckInDate);
		clear(getTxtChechOutDate());
		filltext(getTxtChechOutDate(), CheckOutDate);
		buttonClick(getBtnSearch());
	}

	public void dateerror() {
		WebElement inDate = getTxtcinerror();
		String text = inDate.getText();
		Assert.assertEquals("Check-In Date shall be before than Check-Out Date", text);

	}

	public void errorWithoutFields() {
		buttonClick(btnSearch);
		WebElement txtselectloc2 = txtselectloc;
		String text = txtselectloc2.getText();
		Assert.assertEquals("Please Select a Location", text);
	}

}
