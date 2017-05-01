package edu.itla.editor.selectorarchivo;

import java.io.File;
import javax.swing.JFileChooser;

public class SelectorArchivo {
	
	String nombreDelArchivo = "";
	
	public String menuAbrir() {
		
		JFileChooser selectorArchivo = new JFileChooser();
		selectorArchivo.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		selectorArchivo.showOpenDialog(null);
		File archivo = selectorArchivo.getSelectedFile();
		
		if (archivo != null){
			nombreDelArchivo = archivo.getPath();
		}
		
		return nombreDelArchivo;
	}
	
	public String menuGuardar() {
		
		JFileChooser selectorArchivo = new JFileChooser();
		selectorArchivo.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		selectorArchivo.showSaveDialog(null);
		File archivo = selectorArchivo.getSelectedFile();
		
		if (archivo != null) {
			nombreDelArchivo = archivo.getPath();
			if (!nombreDelArchivo.endsWith(".txt")) {
				nombreDelArchivo += ".txt";
			}
		} else {
			nombreDelArchivo = "";
		}
		
		return nombreDelArchivo;
	}
}
