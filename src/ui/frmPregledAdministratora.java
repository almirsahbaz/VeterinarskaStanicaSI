package ui;

import helper.DAO;
import model.Administrator;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

public class frmPregledAdministratora extends Shell
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
			frmPregledAdministratora shell = new frmPregledAdministratora(display);
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

	private final Table tblKorisnici;
	private final TableColumn tblclmnUsername;
	private final TableColumn tblclmnIme;
	private final TableColumn tblclmnPrezime;

	private final TableColumn tblclmnGrad;
	private final TableColumn tblclmnStrunaSprema;

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public frmPregledAdministratora(Display display)
	{
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setImage(SWTResourceManager.getImage(frmPregledAdministratora.class, "/ui/slike/search-b-icon.png"));
		setLayout(null);

		tblKorisnici = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		tblKorisnici.setBounds(10, 10, 507, 262);
		tblKorisnici.setHeaderVisible(true);
		tblKorisnici.setLinesVisible(true);

		tblclmnUsername = new TableColumn(tblKorisnici, SWT.NONE);
		tblclmnUsername.setWidth(100);
		tblclmnUsername.setText("Username");

		tblclmnIme = new TableColumn(tblKorisnici, SWT.NONE);
		tblclmnIme.setWidth(100);
		tblclmnIme.setText("Ime");

		tblclmnPrezime = new TableColumn(tblKorisnici, SWT.NONE);
		tblclmnPrezime.setWidth(100);
		tblclmnPrezime.setText("Prezime");

		tblclmnStrunaSprema = new TableColumn(tblKorisnici, SWT.NONE);
		tblclmnStrunaSprema.setWidth(100);
		tblclmnStrunaSprema.setText("Stru\u010Dna sprema");

		tblclmnGrad = new TableColumn(tblKorisnici, SWT.NONE);
		tblclmnGrad.setWidth(100);
		tblclmnGrad.setText("Grad");
		createContents();

		for (Administrator a : DAO.getAll(Administrator.class))
		{
			final TableItem tblI = new TableItem(tblKorisnici, SWT.None);
			tblI.setText(0, a.getNalog().getUsername());
			tblI.setText(1, a.getIme());
			tblI.setText(2, a.getPrezime());
			tblI.setText(3, a.getStrucnaSprema().getNaziv());
			tblI.setText(4, a.get_Grad().getNaziv());
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
		setText("Pregled administratora");
		setSize(525, 307);

	}
}
