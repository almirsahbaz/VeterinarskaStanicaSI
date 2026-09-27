package ui;

import helper.DAO;
import helper.Konekcija;
import helper.MojComboBox;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Administrator;
import model.Gradovi;
import model.KorisnickiNalog;
import model.KorisnickiNalog.TipKorisnika;
import model.StrucneSpreme;

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

public class frmDodajAdministratora extends Shell
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
			frmDodajAdministratora shell = new frmDodajAdministratora(display);
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

	private final Label lblUsername;
	private final Label lblIme;
	private final Text txtIme;
	private final Label lblPrezime;
	private final Text txtPrezime;
	private final Label lblStrucnaSprema;
	private final MojComboBox cmbStrucnaSprema;
	private final Label lblGrad;
	private final MojComboBox cmbGradovi;
	private final Button btnSacuvaj;

	private final Button btnOdustani;
	private Label lblDodajAdministratora;
	private Label lblDodajAdmina;
	private Text txtUsername;
	private Label lblPassword;
	private Text txtPassword;

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public frmDodajAdministratora(Display display)
	{
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setImage(SWTResourceManager.getImage(frmDodajAdministratora.class, "/ui/slike/admin-icon.png"));

		lblUsername = new Label(this, SWT.NONE);
		lblUsername.setBounds(21, 102, 105, 15);
		lblUsername.setText("Username:");

		lblIme = new Label(this, SWT.NONE);
		lblIme.setBounds(21, 174, 105, 15);
		lblIme.setText("Ime:");

		txtIme = new Text(this, SWT.BORDER);
		txtIme.setBounds(132, 171, 153, 21);

		lblPrezime = new Label(this, SWT.NONE);
		lblPrezime.setBounds(21, 211, 55, 15);
		lblPrezime.setText("Prezime:");

		txtPrezime = new Text(this, SWT.BORDER);
		txtPrezime.setBounds(132, 208, 153, 21);

		lblStrucnaSprema = new Label(this, SWT.NONE);
		lblStrucnaSprema.setBounds(21, 248, 105, 15);
		lblStrucnaSprema.setText("Stru\u010Dna sprema:");

		cmbStrucnaSprema = new MojComboBox(this, SWT.READ_ONLY);
		cmbStrucnaSprema.setBounds(132, 245, 153, 23);

		lblGrad = new Label(this, SWT.NONE);
		lblGrad.setBounds(21, 287, 105, 15);
		lblGrad.setText("Grad:");

		cmbGradovi = new MojComboBox(this, SWT.READ_ONLY);
		cmbGradovi.setBounds(132, 284, 153, 23);

		btnSacuvaj = new Button(this, SWT.NONE);
		btnSacuvaj.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				KorisnickiNalog k = new KorisnickiNalog();
				Administrator admin = new Administrator();
				k.setUsername(txtUsername.getText());
				k.setPassword(txtPassword.getText());
				k.setIsAktivan(true);
				k.setTipK(TipKorisnika.administrator);
				admin.setNalog(k);
				String Ime = txtIme.getText();
				admin.setIme(Ime);
				String Prezime = txtPrezime.getText();
				admin.setPrezime(Prezime);
				admin.setStrucnaSprema(cmbStrucnaSprema.uzmiOznacenuStavku(StrucneSpreme.class));
				admin.set_Grad(cmbGradovi.uzmiOznacenuStavku(Gradovi.class));

				Integer username = k.getKorisnickiNalogID();
				if (Ime.isEmpty() || Prezime.isEmpty() || txtUsername.getText() == "" || txtPassword.getText() == "" || cmbGradovi.getText() == ""
						|| cmbStrucnaSprema.getText() == "")
				{
					MessageDialog.openError(null, "Greška", "Sva polja su obavezna za unos !");
					return;
				}

				EntityManager em = Konekcija.getEmf().createEntityManager();
				TypedQuery<Administrator> q = em.createQuery("select k from Administrator k  where k._nalog.KorisnickiNalogID = ?",
						Administrator.class);
				q.setParameter(1, username);
				List<Administrator> lista = q.getResultList();
				em.close();
				if (lista.size() == 0)
				{
					DAO.snimi(k);
					Dodavanje.DodajAdmina(admin);
					MessageDialog.openInformation(null, "Informacija", "Administrator uspješno dodat!");
					close();
				} else
				{
					MessageDialog.openError(null, "Greška", "Taj username je zauzet, odaberite drugi!");
				}
				lista.clear();
			}
		});
		btnSacuvaj.setBounds(132, 325, 75, 25);
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
		btnOdustani.setBounds(210, 325, 75, 25);
		btnOdustani.setText("Odustani");

		lblDodajAdministratora = new Label(this, SWT.NONE);
		lblDodajAdministratora.setText("Dodaj administratora:");
		lblDodajAdministratora.setFont(SWTResourceManager.getFont("Arial", 10, SWT.BOLD));
		lblDodajAdministratora.setBounds(132, 40, 168, 38);

		lblDodajAdmina = new Label(this, SWT.NONE);
		lblDodajAdmina.setImage(SWTResourceManager.getImage(frmDodajAdministratora.class, "/ui/slike/admin-Add.png"));
		lblDodajAdmina.setBounds(21, 22, 55, 58);

		txtUsername = new Text(this, SWT.BORDER);
		txtUsername.setBounds(132, 102, 153, 21);

		lblPassword = new Label(this, SWT.NONE);
		lblPassword.setBounds(21, 139, 105, 15);
		lblPassword.setText("Password:");

		txtPassword = new Text(this, SWT.BORDER | SWT.PASSWORD);
		txtPassword.setBounds(132, 136, 153, 21);
		createContents();

		List<StrucneSpreme> lista = DAO.getAll(StrucneSpreme.class);
		for (StrucneSpreme s : lista)
		{
			cmbStrucnaSprema.dodajStavku(s, s.getNaziv());
		}

		List<Gradovi> lista2 = DAO.getAll(Gradovi.class);
		for (Gradovi g : lista2)
		{
			cmbGradovi.dodajStavku(g, g.getNaziv());
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
		setText("Novi administrator");
		setSize(313, 384);

	}
}
