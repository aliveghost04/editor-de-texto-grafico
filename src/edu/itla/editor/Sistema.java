package edu.itla.editor;

import javax.swing.JFrame;
import javax.swing.UIManager;

import edu.itla.editor.gui.InterfazGrafica;

public class Sistema {

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		InterfazGrafica gui = new InterfazGrafica();
		gui.setSize(600, 400);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setLocationByPlatform(true);
		gui.setVisible(true);
	}
}
