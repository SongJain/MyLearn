package com.SongJian.run;

import java.sql.SQLException;

import com.SongJian.view.LoginViewBegin;


public class mainRun {
	public static void main(String[] args) throws SQLException {
		new LoginViewBegin().init();
	}
}