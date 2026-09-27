package ui;

import helper.Konekcija;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Vlasnik;

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

public class frmDodajVlasnika extends Shell
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
			frmDodajVlasnika shell = new frmDodajVlasnika(display);
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

	private final Text txtIme;

	private final Text txtPrezime;

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public frmDodajVlasnika(Display display)
	{
		super(display, SWT.CLOSE | SWT.MIN | SWT.MAX | SWT.TITLE);
		setImage(SWTResourceManager.getImage(frmDodajVlasnika.class, "/ui/slike/1389306817_Add-Male-User.png"));
		setLayout(null);

		Button btnSauvaj = new Button(this, SWT.NONE);
		btnSauvaj.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				Vlasnik v = new Vlasnik();
				v.setIme(txtIme.getText());
				v.setPrezime(txtPrezime.getText());

				EntityManager em = Konekcija.getEmf().createEntityManager();
				TypedQuery<Vlasnik> q = em.createQuery("select k from Vlasnik k  where k.ime = ?", Vlasnik.class);
				q.setParameter(1, txtIme.getText());
				List<Vlasnik> lista = q.getResultList();
				em.close();

				EntityManager em2 = Konekcija.getEmf().createEntityManager();
				TypedQuery<Vlasnik> q2 = em2.createQuery("select k from Vlasnik k  where k.prezime = ?", Vlasnik.class);
				q2.setParameter(1, txtPrezime.getText());
				List<Vlasnik> lista2 = q2.getResultList();
				em2.close();

				if (txtIme.getText() == "" || txtPrezime.getText() == "")
				{
					MessageDialog.openError(null, "Greška", "Sva polja su obavezna za unos!");
					return;
				}
				if (lista.size() == 0 || lista2.size() == 0)
				{
					Dodavanje.dodajvlasnika(v);
					MessageDialog.openInformation(null, "Informacija", "Vlasnik uspješno dodat!");
					close();
				} else
				{
					MessageDialog.openError(null, "Greška", "Taj vlasnik je veæ unešen u bazu podataka!");
					return;
				}

			}
		});
		btnSauvaj.setBounds(97, 168, 75, 25);
		btnSauvaj.setText("Sa\u010Duvaj");

		Button btnOdustani = new Button(this, SWT.NONE);
		btnOdustani.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				close();
			}
		});
		btnOdustani.setBounds(190, 168, 75, 25);
		btnOdustani.setText("Odustani");

		Label lblIme = new Label(this, SWT.NONE);
		lblIme.setBounds(10, 74, 55, 15);
		lblIme.setText("Ime :");

		Label lblPrezime = new Label(this, SWT.NONE);
		lblPrezime.setBounds(10, 118, 55, 15);
		lblPrezime.setText("Prezime :");

		txtIme = new Text(this, SWT.BORDER);
		txtIme.setBounds(97, 71, 168, 21);

		txtPrezime = new Text(this, SWT.BORDER);
		txtPrezime.setBounds(97, 115, 168, 21);

		Label label = new Label(this, SWT.NONE);
		label.setImage(SWTResourceManager.getImage(frmDodajVlasnika.class, "/ui/slike/1389306817_Add-Male-User.png"));
		label.setBounds(10, 10, 55, 58);

		Label lblDodajVlasnika = new Label(this, SWT.NONE);
		lblDodajVlasnika.setFont(SWTResourceManager.getFont("Arial", 14, SWT.BOLD));
		lblDodajVlasnika.setBounds(97, 27, 168, 38);
		lblDodajVlasnika.setText("DODAJ VLASNIKA");
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
		setText("Dodaj vlasnika");
		setSize(281, 229);

	}
}
