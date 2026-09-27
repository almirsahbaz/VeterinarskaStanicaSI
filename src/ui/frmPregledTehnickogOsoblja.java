package ui;

import helper.DAO;
import model.Tehnicko_osoblje;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

public class frmPregledTehnickogOsoblja extends Shell
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
			frmPregledTehnickogOsoblja shell = new frmPregledTehnickogOsoblja(display);
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
	private final TableColumn tblclmnVrstaPosla;
	private final TableColumn tblclmnOdjel;
	private final TableColumn tblclmnIme;
	private final TableColumn tblclmnPrezime;

	private final TableColumn tblclmnGrad;

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public frmPregledTehnickogOsoblja(Display display)
	{
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setImage(SWTResourceManager.getImage(frmPregledTehnickogOsoblja.class, "/ui/slike/search-b-icon.png"));

		tblKorisnici = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		tblKorisnici.setBounds(10, 10, 577, 242);
		tblKorisnici.setHeaderVisible(true);
		tblKorisnici.setLinesVisible(true);

		tblclmnUsername = new TableColumn(tblKorisnici, SWT.NONE);
		tblclmnUsername.setWidth(100);
		tblclmnUsername.setText("Username");

		tblclmnVrstaPosla = new TableColumn(tblKorisnici, SWT.NONE);
		tblclmnVrstaPosla.setWidth(100);
		tblclmnVrstaPosla.setText("Vrsta posla");

		tblclmnOdjel = new TableColumn(tblKorisnici, SWT.NONE);
		tblclmnOdjel.setWidth(100);
		tblclmnOdjel.setText("Odjel");

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

		for (Tehnicko_osoblje t : DAO.getAll(Tehnicko_osoblje.class))
		{
			final TableItem tblI = new TableItem(tblKorisnici, SWT.None);

			tblI.setText(0, t.getNalog().getUsername());
			tblI.setText(1, t.getVrsta_posla());
			tblI.setText(2, t.getOdjel().getNaziv());
			tblI.setText(3, t.getIme());
			tblI.setText(4, t.getPrezime());
			tblI.setText(5, t.getGrad().getNaziv());
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
		setText("Pregled tehnièkog osoblja");
		setSize(613, 300);

	}

}
