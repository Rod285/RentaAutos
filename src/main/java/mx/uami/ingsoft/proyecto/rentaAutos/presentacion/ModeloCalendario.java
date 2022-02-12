/*
 * SourceFile: ModeloCalendario
 * Description: Class who manages the rendering of the calendar which is present in principal views
 * Author: Mejía Velázquez José Rodrigo
 * Date: 12/02/2022
 */
package mx.uami.ingsoft.proyecto.rentaAutos.presentacion;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ModeloCalendario extends AbstractTableModel{

	int dia = 0;

	@Override
	public int getRowCount() {
		return 5;
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public String getColumnName(int columnIndex) {
		
		String[] nombres = {"L", "M", "X", "J", "V", "S", "D"};
		return nombres[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return Integer.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		int diasMes = LocalDate.now().getMonth().length(false);
		int diaInicial = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()).getDayOfWeek().getValue();;
					
		dia = dia + 1;
		if(rowIndex == 0 && columnIndex + 1 < diaInicial) {
			dia = 0;
			return null;
		}else if(rowIndex == 0 && columnIndex + 1 >= diaInicial){
			return dia;
		}
		else if(rowIndex > 0 && dia <= diasMes){
			return dia;
		}else {
			return null;
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}
}
