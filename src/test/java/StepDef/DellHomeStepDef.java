package StepDef;

import org.openqa.selenium.WebDriver;

import Helper.Config;
import Helper.Utils;
import Page.DellHome;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DellHomeStepDef {
	
	@Given("Admin is on homepage")
	public void admin_is_on_homepage() throws Exception {
		Config.Confchrome();
		Config.maximizeWindow();
		Config.driver.get(Utils.getproprety("Web_Portal_Link"));

	  	}
	    
	

	@When("Admin mousehover on menu {string} and submenu {string}")
	public void admin_mousehover_on_menu_and_submenu (String menuTitle, String submenuTitle) throws Exception {
		DellHome page = new DellHome();
		page.mousehoverOnMenuByName(menuTitle,submenuTitle);
	}

	@When("Admin mousehover on menu\"Ordinateurs et accessoires\"and submenu\"Ordinateurs portables\"")
	public void admin_mousehover_on_menu_ordinateurs_et_accessoires_and_submenu_ordinateurs_portables() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


  
	

	@When("Admin click on product {string}")
	public void admin_click_on_product(String  productTitle) {
		DellHome page = new DellHome();
		page.clickOnProduit(productTitle);
	    
	}

	@Then("Admin is directed to the page {string}")
	public void admin_is_directed_to_the_page(String productTitle) {
		DellHome page = new DellHome();
		page.verifProduct(productTitle);
	   
	  

	}
}


