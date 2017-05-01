package edu.itla.editor.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import edu.itla.editor.guardado.ManejadoraTexto;
import edu.itla.editor.selectorarchivo.SelectorArchivo;

public class InterfazGrafica extends JFrame {

	private static final long serialVersionUID = 1L;
	
	String textoObtenido;
	String nombreDelArchivo = "";
	
	public InterfazGrafica() {
		
		setTitle("Editor de Texto");
		setLayout(new BorderLayout());
		
		final JTextArea areaDeTexto = new JTextArea("Editor de texto escrito en java");
		areaDeTexto.selectAll();
		areaDeTexto.setLineWrap(true);
		areaDeTexto.setWrapStyleWord(true);
		
		JScrollPane barraDesplazamiento = new JScrollPane(areaDeTexto);
		
		JMenu menuArchivo = new JMenu("Archivo");
		JMenuItem abrirArchivo = new JMenuItem("Abrir");
		abrirArchivo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				SelectorArchivo selectorArchivo = new SelectorArchivo();
				nombreDelArchivo = selectorArchivo.menuAbrir();
				
				ManejadoraTexto guardar = new ManejadoraTexto();
				
				try {
					if (!nombreDelArchivo.equalsIgnoreCase("")) {
						areaDeTexto.setText(guardar.textoObtenido(nombreDelArchivo));
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(InterfazGrafica.this, "Error al leer desde el archivo", "Informacion", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		menuArchivo.add(abrirArchivo);
		
		JMenuItem guardarArchivo = new JMenuItem("Guardar");
		guardarArchivo.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent e){
				
				textoObtenido = areaDeTexto.getText();
				
				SelectorArchivo selectorArchivo = new SelectorArchivo();
				nombreDelArchivo = selectorArchivo.menuGuardar();
				
				ManejadoraTexto guardar = new ManejadoraTexto();
				
				try {
					if (!nombreDelArchivo.equalsIgnoreCase("")) {
						guardar.guardarTexto(textoObtenido, nombreDelArchivo);
						JOptionPane.showMessageDialog(InterfazGrafica.this, "Archivo Guardado Con Exito", "Informacion", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		menuArchivo.add(guardarArchivo);
		JMenuItem elementoSalir = new JMenuItem("Salir");
		elementoSalir.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		menuArchivo.addSeparator();
		menuArchivo.add(elementoSalir);
		
		JMenuBar barraMenu = new JMenuBar();
		barraMenu.add(menuArchivo);
		setJMenuBar(barraMenu);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				
				ManejadoraTexto mngTxt = new ManejadoraTexto();
				try {
					if (!areaDeTexto.getText().equals(mngTxt.textoObtenido(nombreDelArchivo))) {
						int resultado = JOptionPane.showConfirmDialog(InterfazGrafica.this, "¿Desea Guardar?", 
								"Editor de Texto", JOptionPane.YES_NO_OPTION);
						switch (resultado) {
							case (JOptionPane.YES_OPTION):
								mngTxt.guardarTexto(areaDeTexto.getText(), nombreDelArchivo);
							break;
							case (JOptionPane.NO_OPTION):
								System.exit(JFrame.EXIT_ON_CLOSE);
							case (JOptionPane.CLOSED_OPTION):
								// TODO Arreglar la opcion de cerrar
							break;
						}
					}
				} catch (Exception e) {
					System.out.println();
				}
			}
		});
		getContentPane().add(BorderLayout.CENTER, barraDesplazamiento);
	}
}
