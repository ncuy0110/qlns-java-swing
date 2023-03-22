/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 *
 * @author
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Account {

	private Integer id;
	@NonNull
	private String username;
	@NonNull
	private String password;

	public Account(int id) {
		setId(id);
	}
}
