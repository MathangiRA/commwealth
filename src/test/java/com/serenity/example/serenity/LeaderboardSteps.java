package com.serenity.example.serenity;

import com.serenity.example.services.*;
import net.thucydides.core.annotations.Step;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LeaderboardSteps {
	List<UserList> userList;
	UserList user;

	@Step
	public void getUserList() {
		LeaderboardAPI leaderboard = new LeaderboardAPI();
		UserList[] userList = leaderboard.getUserList();
		this.userList = Arrays.asList(userList);
	}

	@Step
	public void addUser(String userName, int score) {
		LeaderboardAPI leaderboard = new LeaderboardAPI();
		userName = userName + RandomStringUtils.randomNumeric(7);
		user = new UserList(userName, score);
		int statuscode = leaderboard.addOrUpdateUser(user, true);
		Assert.assertTrue("Add user is successful", statuscode == 201);
	}

	public void verifyUserAdded() {
		List<UserList> users = userList.stream()
				.filter(u -> u.getUsername().equals(user.getUsername())
				&& u.getScore() == user.getScore())
				.collect(Collectors.toList());
		Assert.assertTrue(users.size() == 1);
	}

	public void delete() {
		LeaderboardAPI leaderboard = new LeaderboardAPI();
		int statuscode = leaderboard.deleteUser(user.getUsername());
		Assert.assertTrue("Add user is successful", statuscode == 204);
	}

	public void verifyUserDeleted() {
		List<UserList> users = userList.stream()
				.filter(u -> u.getUsername().equals(user.getUsername()))
				.collect(Collectors.toList());
		Assert.assertTrue(users.size() == 0);
	}

	public void updateUser(int score) {
		LeaderboardAPI leaderboard = new LeaderboardAPI();
		user.setScore(score);
		int statuscode = leaderboard.addOrUpdateUser(user, false);
		Assert.assertTrue("Add user is successful", statuscode == 204);

	}
}
