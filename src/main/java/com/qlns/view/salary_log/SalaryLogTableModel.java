/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.view.salary_log;

import com.qlns.model.SalaryLog;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SalaryLogTableModel extends AbstractTableModel {

	@NonNull
	private final List<SalaryLog> slList;
	private final String[] columnNames = new String[]{"ID", "Nhân viên", "Lương", "Ngày trả"};
	private final Class[] columnClass = new Class[]{Integer.class, String.class, Long.class, Date.class};

	@Override
	public int getRowCount() {
		return slList.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		SalaryLog sl = slList.get(rowIndex);
		switch (columnIndex) {
			case 0:
				return sl.getId();
			case 1:
				return sl.getEmployee();
			case 2:
				return sl.getSalary();
			case 3:
				return sl.getCreated();
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

	public SalaryLog getRow(int i) {
		return slList.get(i);
	}

}
