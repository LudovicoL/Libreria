package it.project.libreria.business;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;


public class LibroManager {
	private static LibroManager instance;
	
	public static LibroManager getInstance() {
		if(instance==null)
			instance = new LibroManager();
		return instance;
	}
/*	public Libro titoloLibro(int i) {
		Libro l= new Libro(i);
		if(l.elencoLibriTitolo(i)) return l;
		else return null;
		
	}*/
				
public static DefaultTableModel setModelloTab (Object rowDataModel[][], Object columnNamesModel[]){
	
	DefaultTableModel modelModel = new DefaultTableModel(rowDataModel, columnNamesModel)
	   {
		   public boolean isCellEditable(int row, int column)
		   {
			   return false;
		   }
	   };
	   return modelModel;
}

public static DefaultComboBoxModel setCModel (String Autori[]){
	
	DefaultComboBoxModel CModel = new DefaultComboBoxModel(Autori){
		
	};
	return CModel;
}

}

