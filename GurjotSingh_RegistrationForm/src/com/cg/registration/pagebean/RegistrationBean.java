package com.cg.registration.pagebean;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class RegistrationBean {
	@FindBy(how=How.NAME,name="userid")
	private WebElement userId ;

	@FindBy(how=How.NAME,name="passid")
	private WebElement password;

	@FindBy(how=How.NAME,name="username")
	private WebElement name;

	@FindBy(how=How.NAME,name="address")
	private WebElement address;

	@FindBy(how=How.NAME,name="country")
	private WebElement country;

	@FindBy(how=How.NAME,name="zip")
	private WebElement zip;

	@FindBy(how=How.NAME,name="email")
	private WebElement email;

	@FindBy(how=How.NAME,name="sex")
	private List<WebElement> sex;

	@FindBy(how=How.NAME,name="languages")
	private List<WebElement> languages;

	@FindBy(how=How.NAME,name="submit")
	private WebElement submitBtn;

	public String getUserId() {
		return userId.getAttribute("value");
	}

	public void setUserId(String userId) {
		this.userId.sendKeys(userId);;
	}

	public String getPassword() {
		return password.getAttribute("value");
	}

	public void setPassword(String password) {
		this.password.sendKeys(password);;
	}

	public String getName() {
		return name.getAttribute("value");
	}

	public void setName(String name) {
		this.name.sendKeys(name);;
	}

	public String getAddress() {
		return address.getAttribute("value");
	}

	public void setAddress(String address) {
		this.address.clear();
		this.address.sendKeys(address);
	}

	public String getCountry() {															//drop down list
		return new Select(this.country).getFirstSelectedOption().getText();
	}

	public void setCountry(String country) {
		Select select=new Select(this.country);
		select.selectByVisibleText(country);
	}

	public String getZip() {
		return zip.getAttribute("value");
	}

	public void setZip(String zip) {
		this.zip.clear();
		this.zip.sendKeys(zip);
	}

	public String getEmail() {
		return email.getAttribute("value");
	}

	public void setEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}

	public String getSex() {																		//checkbox
		for(WebElement webElement: sex)
			if(webElement.isSelected())
				return webElement.getAttribute("value");
		return null;		
	}

	public void setSex(String sex) {
		if(sex.equalsIgnoreCase("male"))
			this.sex.get(0).click();
		else
			this.sex.get(1).click();
	}

	public String[] getLanguages() {
		return null;
	}

	public void setLanguages(String[] languages) {					//default settings
		for (String language : languages) {
			if(language.equals("english"))
				this.languages.get(0).click();
			else if(language.equals("nonenglish"))
				this.languages.get(1).click();
		}
	}

	public void clickSignUp() {
		submitBtn.submit();
	}

	
}
