/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@RequiredArgsConstructor
public class Task {

	Integer id;

	@NonNull
	String name;
	@NonNull
	String description;
	@NonNull
	Date deadline;
	@NonNull
	Employee employee;
	@NonNull
	Boolean completed;
	Date created;
}
