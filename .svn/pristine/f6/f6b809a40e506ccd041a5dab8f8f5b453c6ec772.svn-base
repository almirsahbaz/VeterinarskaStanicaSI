package ui;

import helper.DAO;
import helper.Konekcija;
import helper.MojComboBox;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Doktori;
import model.Gradovi;
import model.KorisnickiNalog;
import model.KorisnickiNalog.TipKorisnika;
import model.Zvanje;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import servis.Dodavanje;

public class frmDodajDoktora extends Shell
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
			frmDodajDoktora shell = new frmDodajDoktora(display);
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

	private final Label lblZvanje;
	private final Label lblPozicija;
	private final Label lblIme;
	private final Label lblPrezime;
	private final Label lblGrad;
	private final MojComboBox cmbZvanje;
	private final Text txtPozicija;
	private final Text txtIme;
	private final Text txtPrezime;
	private final MojComboBox cmbGradovi;
	private final Button btnSacuvaj;

	private final Button btnOdustani;
	private Label lblUsername;
	private Label lblDodajDoktora;
	private Label lblAddDoktora;
	private Text txtUsername;
	private Text txtPassword;
	private Label lblPassword;

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public frmDodajDoktora(Display display)
	{
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setImage(SWTResourceManager.getImage(frmDodajDoktora.class, "/ui/slike/Doctor-icon.png"));

		lblZvanje = new Label(this, SWT.NONE);
		lblZvanje.setBounds(21, 245, 118, 15);
		lblZvanje.setText("Zvanje:");

		lblPozicija = new Label(this, SWT.NONE);
		lblPozicija.setBounds(21, 280, 118, 15);
		lblPozicija.setText("Pozicija:");

		lblIme = new Label(this, SWT.NONE);
		lblIme.setBounds(21, 174, 118, 15);
		lblIme.setText("Ime:");

		lblPrezime = new Label(this, SWT.NONE);
		lblPrezime.setBounds(21, 209, 118, 15);
		lblPrezime.setText("Prezime:");

		lblGrad = new Label(this, SWT.NONE);
		lblGrad.setBounds(21, 314, 118, 15);
		lblGrad.setText("Grad:");

		cmbZvanje = new MojComboBox(this, SWT.READ_ONLY);
		cmbZvanje.setBounds(145, 242, 156, 23);

		txtPozicija = new Text(this, SWT.BORDER);
		txtPozicija.setBounds(145, 277, 156, 21);

		txtIme = new Text(this, SWT.BORDER);
		txtIme.setBounds(145, 171, 156, 21);

		txtPrezime = new Text(this, SWT.BORDER);
		txtPrezime.setBounds(145, 206, 156, 21);

		cmbGradovi = new MojComboBox(this, SWT.READ_ONLY);
		cmbGradovi.setBounds(145, 311, 156, 23);

		btnSacuvaj = new Button(this, SWT.NONE);
		btnSacuvaj.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				KorisnickiNalog k = new KorisnickiNalog();
				Doktori doktor = new Doktori();
				k.setUsername(txtUsername.getText());
				k.setPassword(txtPassword.getText());
				k.setIsAktivan(true);
				k.setTipK(TipKorisnika.doktor);
				doktor.setNalog(k);
				doktor.setZvanje(cmbZvanje.uzmiOznacenuStavku(Zvanje.class));
				String Pozicija = txtPozicija.getText();
				doktor.setPozicija(Pozicija);
				String Ime = txtIme.getText();
				doktor.setIme(Ime);
				String Prezime = txtPrezime.getText();
				doktor.setPrezime(Prezime);
				doktor.setGrad(cmbGradovi.uzmiOznacenuStavku(Gradovi.class));

				Integer username = k.getKorisnickiNalogID();
				if (txtUsername.getText() == "" || txtPassword.getText() == "" || Ime.isEmpty() || Prezime.isEmpty() || Pozicija.isEmpty()
						|| cmbZvanje.getText() == "" || cmbGradovi.getText() == "")
				{
					MessageDialog.openError(null, "Greška", "Sva polja su obavezna za unos !");
					return;
				}

				EntityManager em = Konekcija.getEmf().createEntityManager();
				TypedQuery<Doktori> q = em.createQuery("select k from Doktori k  where k._nalog.KorisnickiNalogID = ?", Doktori.class);
				q.setParameter(1, username);
				List<Doktori> lista = q.getResultList();
				em.close();
				if (lista.size() == 0)
				{
					DAO.snimi(k);
					Dodavanje.DodajDoktora(doktor);
					MessageDialog.openInformation(null, "Informacija", "Doktor uspješno dodat!");
					close();
				} else
				{
					MessageDialog.openError(null, "Greška", "Taj username je zauzet, odaberite drugi!");
				}
				lista.clear();
			}
		});
		btnSacuvaj.setBounds(146, 354, 75, 25);
		btnSacuvaj.setText("Sa\u010Duvaj");

		btnOdustani = new Button(this, SWT.NONE);
		btnOdustani.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				close();
			}
		});
		btnOdustani.setBounds(226, 354, 75, 25);
		btnOdustani.setText("Odustani");

		lblUsername = new Label(this, SWT.NONE);
		lblUsername.setBounds(21, 104, 118, 15);
		lblUsername.setText("Username:");

		lblDodajDoktora = new Label(this, SWT.NONE);
		lblDodajDoktora.setText("Dodaj doktora:");
		lblDodajDoktora.setFont(SWTResourceManager.getFont("Arial", 10, SWT.BOLD));
		lblDodajDoktora.setBounds(145, 42, 168, 38);

		lblAddDoktora = new Label(this, SWT.NONE);
		lblAddDoktora.setImage(SWTResourceManager.getImage(frmDodajDoktora.class, "/ui/slike/doctorAdd.png"));
		lblAddDoktora.setBounds(21, 21, 55, 58);

		txtUsername = new Text(this, SWT.BORDER);
		txtUsername.setBounds(145, 104, 156, 21);

		txtPassword = new Text(this, SWT.BORDER | SWT.PASSWORD);
		txtPassword.setBounds(145, 138, 156, 21);

		lblPassword = new Label(this, SWT.NONE);
		lblPassword.setBounds(21, 141, 118, 15);
		lblPassword.setText("Password:");
		createContents();

		List<Gradovi> lista = DAO.getAll(Gradovi.class);
		for (Gradovi g : lista)
		{
			cmbGradovi.dodajStavku(g, g.getNaziv());
		}

		List<Zvanje> lista2 = DAO.getAll(Zvanje.class);
		for (Zvanje z : lista2)
		{
			cmbZvanje.dodajStavku(z, z.getNaziv());
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
		setText("Novi doktor");
		setSize(324, 418);

	}
}
