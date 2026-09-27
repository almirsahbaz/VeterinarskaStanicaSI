package ui;

import helper.DAO;
import model.Doktori;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

public class frmPregledDoktora extends Shell
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
			frmPregledDoktora shell = new frmPregledDoktora(display);
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
	private final TableColumn tblclmnZvanje;
	private final TableColumn tblclmnPozicija;
	private final TableColumn tblclmnIme;
	private final TableColumn tblclmnPrezime;

	private final TableColumn tblclmnGrad;

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public frmPregledDoktora(Display display)
	{
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setImage(SWTResourceManager.getImage(frmPregledDoktora.class, "/ui/slike/search-b-icon.png"));

		tblKorisnici = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		tblKorisnici.setBounds(10, 10, 604, 242);
		tblKorisnici.setHeaderVisible(true);
		tblKorisnici.setLinesVisible(true);

		tblclmnUsername = new TableColumn(tblKorisnici, SWT.NONE);
		tblclmnUsername.setWidth(100);
		tblclmnUsername.setText("Username");

		tblclmnZvanje = new TableColumn(tblKorisnici, SWT.NONE);
		tblclmnZvanje.setWidth(100);
		tblclmnZvanje.setText("Zvanje");

		tblclmnPozicija = new TableColumn(tblKorisnici, SWT.NONE);
		tblclmnPozicija.setWidth(100);
		tblclmnPozicija.setText("Pozicija");

		tblclmnIme = new TableColumn(tblKorisnici, SWT.NONE);
		tblclmnIme.setWidth(100);
		tblclmnIme.setText("Ime");

		tblclmnPrezime = new TableColumn(tblKorisnici, SWT.NONE);
		tblclmnPrezime.setWidth(100);
		tblclmnPrezime.setText("Prezime");

		tblclmnGrad = new TableColumn(tblKorisnici, SWT.NONE);
		tblclmnGrad.setWidth(100);
		tblclmnGrad.setText("Grad");
		createContents();

		for (Doktori d : DAO.getAll(Doktori.class))
		{
			final TableItem tblI = new TableItem(tblKorisnici, SWT.None);
			tblI.setText(0, d.getNalog().getUsername());
			tblI.setText(1, d.getZvanje().getNaziv());
			tblI.setText(2, d.getPozicija());
			tblI.setText(3, d.getIme());
			tblI.setText(4, d.getPrezime());
			tblI.setText(5, d.getGrad().getNaziv());
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
		setText("Pregled doktora");
		setSize(625, 288);

	}

}
