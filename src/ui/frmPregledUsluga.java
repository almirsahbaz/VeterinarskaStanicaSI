package ui;

import helper.DAO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import model.Usluge;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

public class frmPregledUsluga extends Shell
{
	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String args[])
	{
		try
		{
			Display display = Display.getDefault();
			frmPregledUsluga shell = new frmPregledUsluga(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed())
			{
				if (!display.readAndDispatch())
				{
					display.sleep();
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private final Table table;

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public frmPregledUsluga(Display display)
	{
		super(display, SWT.CLOSE | SWT.MIN | SWT.MAX | SWT.TITLE);
		setImage(SWTResourceManager.getImage(frmPregledUsluga.class, "/ui/slike/search-b-icon.png"));

		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 10, 244, 242);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tblclmnNaziv = new TableColumn(table, SWT.NONE);
		tblclmnNaziv.setText("Naziv");
		tblclmnNaziv.setWidth(112);

		TableColumn tblclmnVrsta = new TableColumn(table, SWT.NONE);
		tblclmnVrsta.setWidth(126);
		tblclmnVrsta.setText("Datum");
		createContents();
		for (Usluge u : DAO.getAll(Usluge.class))
		{
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Calendar cal = Calendar.getInstance();
			TableItem tableItem = new TableItem(table, SWT.NONE);
			tableItem.setText(0, u.getNaziv());
			tableItem.setText(1, dateFormat.format(u.getDatumUsluge()));

		}
	}

	@Override
	protected void checkSubclass()
	{
		// Disable the check that prevents subclassing of SWT components
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents()
	{
		setText("Pregled Usluga");
		setSize(271, 300);

	}

}
