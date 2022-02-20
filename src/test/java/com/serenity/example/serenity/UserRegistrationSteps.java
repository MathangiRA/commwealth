package com.serenity.example.serenity;

import com.serenity.example.services.LeaderboardAPI;
import com.serenity.example.services.UserAPI;
import com.serenity.example.services.UserLoginResponse;
import com.serenity.example.services.UserRegistrationRequest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class UserRegistrationSteps {

	UserAPI userAPI = new UserAPI();
	public UserRegistrationRequest newUser = new UserRegistrationRequest();
	int statusCode;

	@Step
	public void registerNewUser(String userName, String password) {
		newUser.setPassword(password);
		newUser.setUsername(userName);
		this.statusCode = userAPI.registerUser(newUser, "");
	}

	@Step
	public void registerNewUser() {
		this.statusCode = userAPI.registerUser(newUser, "");
	}

	@Step
	public void registerNewUser(String invalidToken) {
		this.statusCode = userAPI.registerUser(newUser, invalidToken);
	}

	@Step
	public void registrationSuccessful(){
		Assert.assertTrue("Request is successful", statusCode == 200);
	}

	@Step
	public void userlogin() {
		UserLoginResponse userLoginResponse = userAPI.userLogin(newUser);
		Assert.assertTrue("Token is generated", !userLoginResponse.getToken().isEmpty());
		Assert.assertTrue("Expiry is 3 mins", userLoginResponse.getExpires().equals("3 min"));
	}

	public void registrationFailed(int statusCode) {
		Assert.assertTrue("Request is successful", this.statusCode == statusCode);
	}
}
