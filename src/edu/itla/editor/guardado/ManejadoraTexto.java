package edu.itla.editor.guardado;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ManejadoraTexto {
	
	public void guardarTexto(String textoObtenido, String nombreDelArchivo) throws Exception{
		
		FileOutputStream fos = new FileOutputStream(nombreDelArchivo);
		PrintWriter pw = new PrintWriter(fos);
		pw.println(textoObtenido);
		pw.close();
		fos.close();
	}
	
	public String textoObtenido(String nombreDelArchivo) throws Exception{
		
		String textoObtenido = "";
		FileInputStream fis = new FileInputStream(nombreDelArchivo);
		Scanner lector = new Scanner(fis);
		StringBuilder almacenadorTexto = new StringBuilder();
		while (lector.hasNextLine()) {
			almacenadorTexto.append(lector.nextLine());
			if (lector.hasNextLine()) {
				almacenadorTexto.append("\n");
			}
		}
		textoObtenido = almacenadorTexto.toString();
		lector.close();
		fis.close();
		
		return textoObtenido;
	}
}
