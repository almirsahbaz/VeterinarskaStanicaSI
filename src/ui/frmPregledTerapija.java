package ui;

import helper.DAO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import model.Terapija;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

public class frmPregledTerapija extends Shell
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
			frmPregledTerapija shell = new frmPregledTerapija(display);
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

	private final Table tblTerapije;

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public frmPregledTerapija(Display display)
	{
		super(display, SWT.CLOSE | SWT.MIN | SWT.MAX | SWT.TITLE);
		setImage(SWTResourceManager.getImage(frmPregledTerapija.class, "/ui/slike/search-b-icon.png"));

		tblTerapije = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		tblTerapije.setBounds(10, 10, 284, 252);
		tblTerapije.setHeaderVisible(true);
		tblTerapije.setLinesVisible(true);

		TableColumn tblclmnVrsta = new TableColumn(tblTerapije, SWT.NONE);
		tblclmnVrsta.setWidth(142);
		tblclmnVrsta.setText("Vrsta");

		TableColumn tblclmnDatum = new TableColumn(tblTerapije, SWT.NONE);
		tblclmnDatum.setWidth(137);
		tblclmnDatum.setText("Datum");
		createContents();

		for (Terapija t : DAO.getAll(Terapija.class))
		{
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Calendar cal = Calendar.getInstance();

			TableItem tableItem = new TableItem(tblTerapije, SWT.NONE);
			tableItem.setText(0, t.getVrsta());
			tableItem.setText(1, dateFormat.format(t.getDatumTerapije()));

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
		setText("Pregled terapija");
		setSize(312, 300);

	}

}
