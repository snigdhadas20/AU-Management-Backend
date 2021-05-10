package com.project.aumanagement.service;

import java.util.List;
import java.util.Optional;

import com.project.aumanagement.model.User;

public interface UserService {

	User getUser(String email);

}
