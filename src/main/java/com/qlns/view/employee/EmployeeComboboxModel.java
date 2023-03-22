/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.view.employee;

import com.qlns.model.Employee;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmployeeComboboxModel extends AbstractListModel<Employee> implements ComboBoxModel<Employee> {

	private Employee selection = null;
	@NonNull
	private final List<Employee> employees;

	@Override
	public int getSize() {
		return employees.size();
	}

	@Override
	public Employee getElementAt(int index) {
		return employees.get(index);
	}

	@Override
	public void setSelectedItem(Object anItem) {
		selection = (Employee) anItem;
	}

	@Override
	public Employee getSelectedItem() {
		return selection;
	}

	public void setByIndex(int i){
		setSelectedItem(employees.get(i));
	}

}
