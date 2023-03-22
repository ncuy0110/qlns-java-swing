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

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Employee {

	private Integer id;

	@NonNull
	private String firstName;
	@NonNull
	private String lastName;
	@NonNull
	private String phoneNumber;
	@NonNull
	private String address;
	@NonNull
	private Long salary;
	@NonNull
	private Boolean gender;

	@Override
	public String toString() {
		return getId() + "-" + getFirstName();
	}
}
