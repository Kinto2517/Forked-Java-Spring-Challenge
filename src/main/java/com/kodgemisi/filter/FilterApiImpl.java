package com.kodgemisi.filter;

import com.kodgemisi.usermanagement.User;
import com.kodgemisi.usermanagement.UserService;

import java.util.ArrayList;
import java.util.List;

public class FilterApiImpl implements FilterApi {

	private final UserService userService;

	public FilterApiImpl(UserService userService) {
		this.userService = userService;
	}

	@Override
	public List<User> unverifiedUnder18() {

		List<User> finalList = userService.list();

		for (int i = finalList.size()-1; i>=0;i--) {
			if (finalList.get(i).getAge() >= 18 || finalList.get(i).isVerified()) {
				finalList.remove(i);
			}
		}
		return finalList;
	}

	@Override
	public List<User> verifiedWithTrPrimaryPhone() {

		List<User> finalList = userService.list();

		for (int i = finalList.size()-1; i>=0;i--) {
			if (!finalList.get(i).getProfile().getPrimaryPhone().toString().startsWith("+90") || !finalList.get(i).isVerified()) {
				finalList.remove(i);
			}
		}
		return finalList;
	}
}
