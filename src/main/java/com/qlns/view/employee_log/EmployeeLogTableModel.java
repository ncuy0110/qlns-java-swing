/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.view.employee_log;

import com.qlns.model.EmployeeLog;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class EmployeeLogTableModel extends AbstractTableModel {

	@NonNull
	private final List<EmployeeLog> list;
	private final Class[] columnClass = new Class[]{Integer.class, String.class, String.class, Long.class, String.class, Date.class};
	private final String[] columnNames = new String[]{"ID", "Nhân viên", "Khen thưởng/Phạt", "Số tiền", "Lý do", "Ngày tạo"};

	@Getter
	@Setter
	private EmployeeLog selectedRow;

	@Override
	public int getRowCount() {
		return list.size();
	}

	@Override
	public int getColumnCount() {
		return this.columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		EmployeeLog el = list.get(rowIndex);
		switch (columnIndex) {
			case 0:
				return el.getId();
			case 1:
				return el.getEmployee();
			case 2:
				return el.getReward()?"Khen thưởng":"Phạt";
			case 3:
				return el.getAmount();
			case 4:
				return el.getReason();
			case 5:
				return el.getCreated();
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

	public EmployeeLog getRow(int i) {
		return list.get(i);
	}
}
