/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.view.employee;

import com.qlns.model.Employee;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class EmployeeTableModel extends AbstractTableModel {

	@NonNull
	private final List<Employee> employees;
	private final Class[] columnClass = new Class[]{Integer.class, String.class, String.class, String.class, String.class, String.class, Long.class};
	private final String[] columnNames = new String[]{"ID", "Tên", "Họ", "Giới tính", "SĐT", "Địa chỉ", "Lương"};
	@Getter
	@Setter
	private Employee selectedRow;

	@Override
	public int getRowCount() {
		return employees.size();
	}

	@Override
	public int getColumnCount() {
		return columnClass.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Employee e = employees.get(rowIndex);
		switch (columnIndex) {
			case 0:
				return e.getId();
			case 1:
				return e.getFirstName();
			case 2:
				return e.getLastName();
			case 3:
				return e.getGender() ? "Nam" : "Nữ";
			case 4:
				return e.getPhoneNumber();
			case 5:
				return e.getAddress();
			case 6:
				return e.getSalary();
			default:
				break;

		}
		return null;
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Class<?> getColumnClass(int i) {
		return columnClass[i];
	}

	public Employee getRow(int r) {
		return employees.get(r);
	}
}
