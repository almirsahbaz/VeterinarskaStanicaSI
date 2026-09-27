package ui;

import java.util.List;

import model.Doktori;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import servis.Pretraga;

public class frmPretragaDoktora extends Shell
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
			frmPretragaDoktora shell = new frmPretragaDoktora(display);
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

	private final Label lblImePrezime;
	private final Text txtImePrezime;
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
	public frmPretragaDoktora(Display display)
	{
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setImage(SWTResourceManager.getImage(frmPretragaDoktora.class, "/ui/slike/search-b-icon.png"));

		lblImePrezime = new Label(this, SWT.NONE);
		lblImePrezime.setBounds(10, 10, 94, 15);
		lblImePrezime.setText("Ime i prezime:");

		txtImePrezime = new Text(this, SWT.BORDER);
		txtImePrezime.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent arg0)
			{
				do_txtIme_keyPressed(arg0);
			}
		});

		txtImePrezime.setBounds(110, 7, 504, 21);

		tblKorisnici = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		tblKorisnici.setBounds(10, 41, 604, 211);
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
		setText("Pretraga doktora");
		setSize(625, 288);

	}

	protected void do_txtIme_keyPressed(KeyEvent arg0)
	{
		tblKorisnici.removeAll();
		List<Doktori> result = Pretraga.PretragaDoktoraD(txtImePrezime.getText());
		for (Doktori d : result)
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
}
