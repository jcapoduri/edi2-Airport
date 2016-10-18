package org.Airport.ui;

import org.Airport.business.*;
import org.Airport.io.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

public class MainWidget extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			SqlHandler sql = SqlHandler.instance();
			Airport obj = new Airport();
			obj.saveNew();
			Display display = Display.getDefault();
			MainWidget shell = new MainWidget(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public MainWidget(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Menu menu = new Menu(this, SWT.BAR);
		setMenuBar(menu);
		
		MenuItem mntmArchivo = new MenuItem(menu, SWT.CASCADE);
		mntmArchivo.setText("Archivo");
		
		Menu menu_1 = new Menu(mntmArchivo);
		mntmArchivo.setMenu(menu_1);
		
		MenuItem mntmSalir = new MenuItem(menu_1, SWT.NONE);
		mntmSalir.setText("Salir");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(640, 480);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
