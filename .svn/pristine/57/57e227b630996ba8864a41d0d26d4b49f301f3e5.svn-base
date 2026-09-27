package ui;

import helper.DAO;
import helper.MojComboBox;

import java.util.List;

import model.Gradovi;
import model.Odjeli;
import model.Tehnicko_osoblje;

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

public class frmIzmijeniTehnicko extends Shell
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
			frmIzmijeniTehnicko shell = new frmIzmijeniTehnicko(display);
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

	private final Label lblVrstaPosla;
	private final Label lblOdjel;
	private final Label lblIme;
	private final Label lblPrezime;
	private final Label lblGrad;
	private final Text txtVrstaPosla;
	private final Button btnSacuvaj;
	private final Button btnOdustani;
	private final MojComboBox cmbOdjel;
	private final Text txtIme;
	private final Text txtPrezime;

	private final MojComboBox cmbGradovi;
	private Label lblUsername;
	private MojComboBox cmbUsername;
	private Label lblIzmijeniTehnicko;
	private Label lblDodajTehnicko;
	private Label lblOTehnikomOsoblju;

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public frmIzmijeniTehnicko(Display display)
	{
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setImage(SWTResourceManager.getImage(frmIzmijeniTehnicko.class, "/ui/slike/Tehnicko-icon.png"));

		lblVrstaPosla = new Label(this, SWT.NONE);
		lblVrstaPosla.setBounds(10, 130, 108, 15);
		lblVrstaPosla.setText("Vrsta posla:");

		lblOdjel = new Label(this, SWT.NONE);
		lblOdjel.setBounds(10, 157, 108, 15);
		lblOdjel.setText("Odjel:");

		lblIme = new Label(this, SWT.NONE);
		lblIme.setBounds(10, 185, 108, 15);
		lblIme.setText("Ime:");

		lblPrezime = new Label(this, SWT.NONE);
		lblPrezime.setBounds(10, 211, 108, 15);
		lblPrezime.setText("Prezime:");

		lblGrad = new Label(this, SWT.NONE);
		lblGrad.setBounds(10, 238, 108, 15);
		lblGrad.setText("Grad:");

		txtVrstaPosla = new Text(this, SWT.BORDER);
		txtVrstaPosla.setBounds(124, 127, 156, 21);

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

				Tehnicko_osoblje tehnicko = cmbUsername.uzmiOznacenuStavku(Tehnicko_osoblje.class);
				tehnicko.setOdjel(cmbOdjel.uzmiOznacenuStavku(Odjeli.class));
				String Vrsta = txtVrstaPosla.getText();
				tehnicko.setVrsta_posla(Vrsta);
				String Ime = txtIme.getText();
				tehnicko.setIme(Ime);
				String Prezime = txtPrezime.getText();
				tehnicko.setPrezime(Prezime);
				tehnicko.setGrad(cmbGradovi.uzmiOznacenuStavku(Gradovi.class));

				if (Ime.isEmpty() || Prezime.isEmpty() || cmbUsername.getText() == "" || cmbGradovi.getText() == "" || cmbOdjel.getText() == ""
						|| Vrsta.isEmpty())
				{
					MessageDialog.openError(null, "Greška", "Sva polja su obavezna za unos !");
					return;
				}

				Dodavanje.IzmijeniTehnicko(tehnicko);
				MessageDialog.openInformation(null, "Informacija", "Podaci o tehnièkom osoblju uspješno izmjenjeni!");
				close();
			}
		});
		btnSacuvaj.setBounds(124, 276, 75, 25);
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
		btnOdustani.setBounds(205, 276, 75, 25);
		btnOdustani.setText("Odustani");

		cmbOdjel = new MojComboBox(this, SWT.READ_ONLY);
		cmbOdjel.setBounds(124, 154, 156, 23);

		txtIme = new Text(this, SWT.BORDER);
		txtIme.setBounds(124, 182, 156, 21);

		txtPrezime = new Text(this, SWT.BORDER);
		txtPrezime.setBounds(124, 208, 156, 21);

		cmbGradovi = new MojComboBox(this, SWT.READ_ONLY);
		cmbGradovi.setBounds(124, 235, 156, 23);

		lblUsername = new Label(this, SWT.NONE);
		lblUsername.setBounds(10, 101, 108, 15);
		lblUsername.setText("Username:");

		cmbUsername = new MojComboBox(this, SWT.READ_ONLY);
		cmbUsername.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				do_cmbUsername_widgetSelected(arg0);
			}
		});
		cmbUsername.setBounds(124, 98, 156, 23);

		lblIzmijeniTehnicko = new Label(this, SWT.NONE);
		lblIzmijeniTehnicko.setText("Izmjena podataka");
		lblIzmijeniTehnicko.setFont(SWTResourceManager.getFont("Arial", 10, SWT.BOLD));
		lblIzmijeniTehnicko.setBounds(124, 37, 128, 21);

		lblDodajTehnicko = new Label(this, SWT.NONE);
		lblDodajTehnicko.setImage(SWTResourceManager.getImage(frmIzmijeniTehnicko.class, "/ui/slike/TehnickoIzmjena.png"));
		lblDodajTehnicko.setBounds(10, 23, 55, 58);

		lblOTehnikomOsoblju = new Label(this, SWT.NONE);
		lblOTehnikomOsoblju.setFont(SWTResourceManager.getFont("Arial", 10, SWT.BOLD));
		lblOTehnikomOsoblju.setBounds(124, 55, 135, 15);
		lblOTehnikomOsoblju.setText("o tehni\u010Dkom osoblju:");
		createContents();

		List<Odjeli> lista = DAO.getAll(Odjeli.class);
		for (Odjeli d : lista)
		{
			cmbOdjel.dodajStavku(d, d.getNaziv());
		}

		List<Gradovi> lista2 = DAO.getAll(Gradovi.class);
		for (Gradovi g : lista2)
		{
			cmbGradovi.dodajStavku(g, g.getNaziv());
		}

		List<Tehnicko_osoblje> lista3 = DAO.getAll(Tehnicko_osoblje.class);
		for (Tehnicko_osoblje k : lista3)
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
		setText("Izmjena podataka - tehnièko osoblje");
		setSize(295, 342);

	}

	protected void do_cmbUsername_widgetSelected(SelectionEvent arg0)
	{
		Tehnicko_osoblje tehnicko = cmbUsername.uzmiOznacenuStavku(Tehnicko_osoblje.class);
		txtIme.setText(tehnicko.getIme());
		txtPrezime.setText(tehnicko.getPrezime());
		txtVrstaPosla.setText(tehnicko.getVrsta_posla());
		cmbOdjel.setText(tehnicko.getOdjel().getNaziv());
		cmbGradovi.setText(tehnicko.getGrad().getNaziv());
	}
}
