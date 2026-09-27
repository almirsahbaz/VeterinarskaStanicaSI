package ui;

import helper.DAO;
import model.Vlasnik;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

public class frmPregledVlasnika extends Shell
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
			frmPregledVlasnika shell = new frmPregledVlasnika(display);
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

	private final Table tblvlasnici;

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public frmPregledVlasnika(Display display)
	{
		super(display, SWT.SHELL_TRIM);
		setImage(SWTResourceManager.getImage(frmPregledVlasnika.class, "/ui/slike/search-b-icon.png"));

		tblvlasnici = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		tblvlasnici.setBounds(10, 10, 274, 198);
		tblvlasnici.setHeaderVisible(true);
		tblvlasnici.setLinesVisible(true);

		TableColumn tblclmnIme = new TableColumn(tblvlasnici, SWT.NONE);
		tblclmnIme.setWidth(118);
		tblclmnIme.setText("Ime");

		TableColumn tblclmnPrezime = new TableColumn(tblvlasnici, SWT.NONE);
		tblclmnPrezime.setWidth(150);
		tblclmnPrezime.setText("Prezime");
		createContents();

		for (Vlasnik v : DAO.getAll(Vlasnik.class))
		{
			TableItem tableItem = new TableItem(tblvlasnici, SWT.NONE);
			tableItem.setText(0, v.getIme());
			tableItem.setText(1, v.getPrezime());

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
		setText("Pregled vlasnika");
		setSize(305, 253);

	}

}
