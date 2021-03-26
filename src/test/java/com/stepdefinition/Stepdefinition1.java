package com.stepdefinition;

import org.utility.HelperClass;

import com.pages.BookAHotel;
import com.pages.LoginPage;
import com.pages.SearchHotel;
import com.pages.SelectHotel;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefinition1 extends HelperClass {

	LoginPage l;
	SearchHotel s;
	BookAHotel b;
	SelectHotel h;
	static String bookAHotel;

	@Given("user is on Adactin Page")
	public void user_is_on_Adactin_Page() {
		browserChrome();
		urlLaunch("http://adactinhotelapp.com/");
		windowMaximize();
		implicitWait(50);
	}

	@When("user should enter the login {string} and {string} and click login button")
	public void user_should_enter_the_login_and_and_click_login_button(String userName, String password) {
		l = new LoginPage();
		l.loginPage(userName, password);
	}

	@When("user should enter {string},{string},{string},{string},{string},{string},{string},{string} and click search button")
	public void user_should_enter_and_click_search_button(String Location, String Hotels, String RoomType,
			String NumberOfRooms, String CheckInDate, String CheckOutDate, String AdultsPerRoom,
			String ChildrenPerPerson) {
		s = new SearchHotel();
		s.SearchHotelpage(Location, Hotels, RoomType, NumberOfRooms, CheckInDate, CheckOutDate, AdultsPerRoom,
				ChildrenPerPerson);
	}

	@Then("user should verify the select hotel page")
	public void user_should_verify_the_select_hotel_page() {
		s = new SearchHotel();
		s.selectHotelVerify();
	}

	@When("user should enter {string},{string},{string},{string},{string} and click search button")
	public void user_should_enter_and_click_search_button(String Location, String NumberOfRooms, String CheckInDate,
			String CheckOutDate, String AdultsPerRoom) {
		s = new SearchHotel();
		s.mandatoryFields(Location, NumberOfRooms, CheckInDate, CheckOutDate, AdultsPerRoom);
	}

	@Then("user should verify the hotel page")
	public void user_should_verify_the_hotel_page() {
		s = new SearchHotel();
		s.selectHotelVerify();
	}

	@When("user should enter {string},{string}")
	public void user_should_enter(String CheckInDate, String CheckOutDate) {
		s = new SearchHotel();
		s.datecheck(CheckInDate, CheckOutDate);
	}

	@Then("user should verify the error message")
	public void user_should_verify_the_error_message() {
		s = new SearchHotel();
		s.dateerror();
	}

	@Then("user should verify the error messages")
	public void user_should_verify_the_error_messages() {
		s = new SearchHotel();
		s.errorWithoutFields();
	}

	@When("user should enter {string},{string},{string},{string},{string},{string},{string} and {string} and  click Search button")
	public void user_should_enter_and_and_click_Search_button(String Location, String Hotels, String RoomType,
			String NumberOfRooms, String CheckInDate, String CheckOutDate, String AdultsPerRoom,
			String ChildrenPerPerson) {
		s = new SearchHotel();
		s.SearchHotelpage(Location, Hotels, RoomType, NumberOfRooms, CheckInDate, CheckOutDate, AdultsPerRoom,
				ChildrenPerPerson);
	}

	@When("user should click Hotel button and Continue button")
	public void user_should_click_Hotel_button_and_Continue_button() {
		h = new SelectHotel();
		h.selectHotelPage();
	}

	@When("user should enter {string},{string},{string},{string},{string},{string},{string},{string} and click BookNow button")
	public void user_should_enter_and_click_BookNow_button(String FirstName, String LastName, String BillAdds,
			String CardNo, String CardType, String ExpDate, String ExpYear, String CVVNo) {
		b = new BookAHotel();
		b.bookAHotel(FirstName, LastName, BillAdds, CardNo, CardType, ExpDate, ExpYear, CVVNo);
	}

	@When("user should enter {string},{string},{string},{string},{string},{string},{string} ,{string} and click Search button")
	public void user_should_enter_and_click_Search_button(String Location, String Hotels, String RoomType,
			String NumberOfRooms, String CheckInDate, String CheckOutDate, String AdultsPerRoom,
			String ChildrenPerPerson) {
		s = new SearchHotel();
		s.SearchHotelpage(Location, Hotels, RoomType, NumberOfRooms, CheckInDate, CheckOutDate, AdultsPerRoom,
				ChildrenPerPerson);
	}

	@When("user should enter book now button")
	public void user_should_enter_book_now_button() {
		b = new BookAHotel();
		b.bookNow();
	}

	@Then("User should verify error messages")
	public void user_should_verify_error_messages() {
		b = new BookAHotel();
		b.verifyerrormsg();

	}

	@Then("User should verify cancel Booking Confirmation")
	public void user_should_verify_cancel_Booking_Confirmation() {
		b = new BookAHotel();
		b.cancelBooking();
	}

	@When("user should click Book Itinerary button")
	public void user_should_click_Book_Itinerary_button() {
		b = new BookAHotel();
		b.bookiternary();
	}

	@When("user should search order no and click cancel selected button")
	public void user_should_search_order_no_and_click_cancel_selected_button() {
		b = new BookAHotel();
		b.cancelexixtingorder();
	}

}
