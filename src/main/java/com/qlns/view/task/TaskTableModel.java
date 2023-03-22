/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.view.task;

import com.qlns.model.Task;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class TaskTableModel extends AbstractTableModel {

	@NonNull
	private final List<Task> tasks;
	private final Class[] columnClass = new Class[]{Integer.class, String.class, String.class, Date.class, String.class, String.class, Date.class};
	private final String[] columnNames = new String[]{"ID", "Tên", "Mô tả", "Hạn", "Nhân viên", "Đã hoàn thành", "Ngày tạo"};
	@Getter
	@Setter
	private Task selectedRow;

	@Override
	public int getRowCount() {
		return tasks.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Task t = tasks.get(rowIndex);
		switch (columnIndex) {
			case 0:
				return t.getId();
			case 1:
				return t.getName();
			case 2:
				return t.getDescription();
			case 3:
				return t.getDeadline();

			case 4:
				return t.getEmployee().getFirstName();
			case 5:
				return t.getCompleted() ? "Rồi" : "Chưa";
			case 6:
				return t.getCreated();
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

	public Task getRow(int i) {
		return tasks.get(i);
	}
}
