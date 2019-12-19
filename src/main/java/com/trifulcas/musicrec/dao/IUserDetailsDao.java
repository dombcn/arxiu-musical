package com.trifulcas.musicrec.dao;

import com.trifulcas.musicrec.model.User;

public interface IUserDetailsDao {
	
	User findUserByUsername(String username);
	
}
