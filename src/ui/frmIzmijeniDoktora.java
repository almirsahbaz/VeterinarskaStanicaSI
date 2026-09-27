package ui;

import helper.DAO;
import helper.MojComboBox;

import java.util.List;

import model.Doktori;
import model.Gradovi;
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

public class frmIzmijeniDoktora extends Shell
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
			frmIzmijeniDoktora shell = new frmIzmijeniDoktora(display);
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
	private MojComboBox cmbUsername;
	private Label lblUsername;
	private Label lblIzmijeniDoktora;
	private Label lblAddDoktora;
	private Label lblODoktoru;

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public frmIzmijeniDoktora(Display display)
	{
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setImage(SWTResourceManager.getImage(frmIzmijeniDoktora.class, "/ui/slike/Doctor-icon.png"));

		lblZvanje = new Label(this, SWT.NONE);
		lblZvanje.setBounds(21, 138, 118, 15);
		lblZvanje.setText("Zvanje:");

		lblPozicija = new Label(this, SWT.NONE);
		lblPozicija.setBounds(21, 173, 118, 15);
		lblPozicija.setText("Pozicija:");

		lblIme = new Label(this, SWT.NONE);
		lblIme.setBounds(21, 205, 118, 15);
		lblIme.setText("Ime:");

		lblPrezime = new Label(this, SWT.NONE);
		lblPrezime.setBounds(21, 237, 118, 15);
		lblPrezime.setText("Prezime:");

		lblGrad = new Label(this, SWT.NONE);
		lblGrad.setBounds(21, 274, 118, 15);
		lblGrad.setText("Grad:");

		cmbZvanje = new MojComboBox(this, SWT.READ_ONLY);
		cmbZvanje.setBounds(145, 135, 156, 23);

		txtPozicija = new Text(this, SWT.BORDER);
		txtPozicija.setBounds(145, 170, 156, 21);

		txtIme = new Text(this, SWT.BORDER);
		txtIme.setBounds(145, 202, 156, 21);

		txtPrezime = new Text(this, SWT.BORDER);
		txtPrezime.setBounds(145, 234, 156, 21);

		cmbGradovi = new MojComboBox(this, SWT.READ_ONLY);
		cmbGradovi.setBounds(145, 266, 156, 23);

		btnSacuvaj = new Button(this, SWT.NONE);
		btnSacuvaj.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				if (cmbUsername.getText() == "")
				{
					MessageDialog.openError(null, "Greška", "Morate izabrati korisnièki nalog za izmjenu!");
					return;
				}

				Doktori doktor = cmbUsername.uzmiOznacenuStavku(Doktori.class);
				doktor.setZvanje(cmbZvanje.uzmiOznacenuStavku(Zvanje.class));
				String Pozicija = txtPozicija.getText();
				doktor.setPozicija(Pozicija);
				String Ime = txtIme.getText();
				doktor.setIme(Ime);
				String Prezime = txtPrezime.getText();
				doktor.setPrezime(Prezime);
				doktor.setGrad(cmbGradovi.uzmiOznacenuStavku(Gradovi.class));

				if (Ime.isEmpty() || Prezime.isEmpty() || Pozicija.isEmpty() || cmbZvanje.getText() == "" || cmbGradovi.getText() == "")
				{
					MessageDialog.openError(null, "Greška", "Sva polja su obavezna za unos !");
					return;
				}

				Dodavanje.IzmijeniDoktora(doktor);
				MessageDialog.openInformation(null, "Informacija", "Podaci o doktoru uspješno izmjenjeni!");
				close();
			}
		});
		btnSacuvaj.setBounds(145, 316, 75, 25);
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
		btnOdustani.setBounds(226, 316, 75, 25);
		btnOdustani.setText("Odustani");

		cmbUsername = new MojComboBox(this, SWT.READ_ONLY);
		cmbUsername.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				do_cmbUsername_widgetSelected(arg0);
			}
		});
		cmbUsername.setBounds(145, 101, 156, 23);

		lblUsername = new Label(this, SWT.NONE);
		lblUsername.setBounds(21, 104, 118, 15);
		lblUsername.setText("Username:");

		lblIzmijeniDoktora = new Label(this, SWT.NONE);
		lblIzmijeniDoktora.setText("Izmjena podataka");
		lblIzmijeniDoktora.setFont(SWTResourceManager.getFont("Arial", 10, SWT.BOLD));
		lblIzmijeniDoktora.setBounds(165, 41, 118, 23);

		lblAddDoktora = new Label(this, SWT.NONE);
		lblAddDoktora.setImage(SWTResourceManager.getImage(frmIzmijeniDoktora.class, "/ui/slike/doktorIzmjena.png"));
		lblAddDoktora.setBounds(21, 21, 55, 58);

		lblODoktoru = new Label(this, SWT.NONE);
		lblODoktoru.setFont(SWTResourceManager.getFont("Arial", 10, SWT.BOLD));
		lblODoktoru.setBounds(165, 64, 93, 15);
		lblODoktoru.setText("o doktoru:");
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

		List<Doktori> lista3 = DAO.getAll(Doktori.class);
		for (Doktori k : lista3)
		{
			cmbUsername.dodajStavku(k, k.getNalog().getUsername());

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
		setText("Izmjena podataka - doktor");
		setSize(324, 378);

	}

	protected void do_cmbUsername_widgetSelected(SelectionEvent arg0)
	{
		Doktori doktor = cmbUsername.uzmiOznacenuStavku(Doktori.class);
		txtIme.setText(doktor.getIme());
		txtPrezime.setText(doktor.getPrezime());
		txtPozicija.setText(doktor.getPozicija());
		cmbZvanje.setText(doktor.getZvanje().getNaziv());
		cmbGradovi.setText(doktor.getGrad().getNaziv());
	}
}
