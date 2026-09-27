package ui;

import helper.DAO;
import helper.Konekcija;
import helper.MojComboBox;
import helper.MojKalendar;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Pacijent;
import model.Vlasnik;
import model.Vrsta;

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

public class frmAddPacijenta extends Shell
{

	public static void main(String args[])
	{
		try
		{
			Display display = Display.getDefault();
			frmAddPacijenta shell = new frmAddPacijenta(display);
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

	private final Text txtImePacijenta;
	private final MojComboBox cmbVlasnik;
	private final MojComboBox cmbVrsta;

	public frmAddPacijenta(Display display)
	{
		super(display, SWT.MIN | SWT.TITLE);
		setImage(SWTResourceManager.getImage(frmAddPacijenta.class, "/ui/slike/Button-Add-icon.png"));
		setLayout(null);

		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setBounds(113, 245, 88, 15);
		lblNewLabel.setText("Datum prijema : ");

		final MojKalendar dtDatumPrijema = new MojKalendar(this, SWT.BORDER);
		dtDatumPrijema.setBounds(218, 245, 80, 24);

		Label lblNewLabel_1 = new Label(this, SWT.NONE);
		lblNewLabel_1.setBounds(113, 82, 80, 15);
		lblNewLabel_1.setText("Ime pacijenta : ");

		txtImePacijenta = new Text(this, SWT.BORDER);
		txtImePacijenta.setBounds(218, 79, 116, 21);

		Label lblGodite = new Label(this, SWT.NONE);
		lblGodite.setBounds(113, 199, 49, 15);
		lblGodite.setText("Godi\u0161te : ");

		final MojKalendar dtGodiste = new MojKalendar(this, SWT.BORDER);
		dtGodiste.setBounds(218, 199, 80, 24);

		Label lblVlasnik = new Label(this, SWT.NONE);
		lblVlasnik.setBounds(113, 121, 46, 15);
		lblVlasnik.setText("Vlasnik : ");

		cmbVlasnik = new MojComboBox(this, SWT.READ_ONLY);
		cmbVlasnik.setBounds(218, 118, 116, 23);

		Button btnSacuvaj = new Button(this, SWT.NONE);
		btnSacuvaj.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				Pacijent pacijent = new Pacijent();
				String Ime = txtImePacijenta.getText();

				pacijent.setIme(Ime);
				pacijent.setVlasnik(cmbVlasnik.uzmiOznacenuStavku(Vlasnik.class));

				pacijent.setVrsta(cmbVrsta.uzmiOznacenuStavku(Vrsta.class));
				pacijent.setGodiste(dtGodiste.getDatum());

				EntityManager em = Konekcija.getEmf().createEntityManager();
				TypedQuery<Pacijent> q = em.createQuery("select k from Pacijent k  where k.ime = ?", Pacijent.class);
				q.setParameter(1, Ime);
				List<Pacijent> lista = q.getResultList();
				em.close();

				pacijent.setDatumPrijema(dtDatumPrijema.getDatum());
				if (Ime.isEmpty() || cmbVlasnik.getText() == "" || cmbVrsta.getText() == "")
				{
					MessageDialog.openError(null, "Greška", "Sva polja su obavezna za unos !");
					return;
				}
				if (lista.size() == 0)
				{
					Dodavanje.DodajPacijenta(pacijent);
					MessageDialog.openInformation(null, "Informacija", "Pacijent uspješno dodat!");
					close();
				} else
				{
					MessageDialog.openError(null, "Greška", "Taj pacijent je veæ unešen u bazu podataka!");
					return;
				}
			}
		});
		btnSacuvaj.setBounds(118, 296, 99, 25);
		btnSacuvaj.setText("Sa\u010Duvaj");

		Button btnOdustani = new Button(this, SWT.NONE);
		btnOdustani.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				close();
			}
		});
		btnOdustani.setBounds(235, 296, 99, 25);
		btnOdustani.setText("Odustani");

		Label lblVrsta = new Label(this, SWT.NONE);
		lblVrsta.setBounds(113, 158, 55, 15);
		lblVrsta.setText("Vrsta :");

		cmbVrsta = new MojComboBox(this, SWT.READ_ONLY);
		cmbVrsta.setBounds(218, 158, 116, 23);

		Label lblDodajPacijenta = new Label(this, SWT.NONE);
		lblDodajPacijenta.setFont(SWTResourceManager.getFont("Arial", 14, SWT.BOLD));
		lblDodajPacijenta.setBounds(107, 33, 227, 24);
		lblDodajPacijenta.setText("DODAJ PACIJENTA");

		Label label = new Label(this, SWT.NONE);
		label.setImage(SWTResourceManager.getImage(frmAddPacijenta.class, "/ui/slike/1389306817_Add-Male-User.png"));
		label.setBounds(10, 33, 60, 64);
		createContents();
		List<Vlasnik> lista2 = DAO.getAll(Vlasnik.class);
		for (Vlasnik v : lista2)
		{
			cmbVlasnik.dodajStavku(v, v.getIme());
		}
		List<Vrsta> lista3 = DAO.getAll(Vrsta.class);
		for (Vrsta v : lista3)
		{
			cmbVrsta.dodajStavku(v, v.getImeVrste());
		}
	}

	@Override
	protected void checkSubclass()
	{
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents()
	{
		setText("Dodavanje pacijenta");
		setSize(358, 362);
	}
}
