package ui;

import helper.Konekcija;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Gradovi;

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

public class frmGradovi extends Shell
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
			frmGradovi shell = new frmGradovi(display);
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

	private Label lblNazivGrada;
	private Text txtGrad;
	private Button btnSacuvaj;

	private Button btnOdustani;
	private Label lblDodajNoviGrad;
	private Label lblDodajGrad;

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public frmGradovi(Display display)
	{
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setImage(SWTResourceManager.getImage(frmGradovi.class, "/ui/slike/Button-Add-icon.png"));

		lblNazivGrada = new Label(this, SWT.NONE);
		lblNazivGrada.setBounds(10, 80, 93, 15);
		lblNazivGrada.setText("Naziv grada:");

		txtGrad = new Text(this, SWT.BORDER);
		txtGrad.setBounds(119, 77, 166, 21);

		btnSacuvaj = new Button(this, SWT.NONE);
		btnSacuvaj.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				Gradovi grad = new Gradovi();
				String Grad = txtGrad.getText();
				grad.setNaziv(Grad);

				EntityManager em = Konekcija.getEmf().createEntityManager();
				TypedQuery<Gradovi> q = em.createQuery("select k from Gradovi k  where k.Naziv = ?", Gradovi.class);
				q.setParameter(1, Grad);
				List<Gradovi> lista = q.getResultList();
				em.close();

				if (Grad.isEmpty())
				{
					MessageDialog.openError(null, "Greška", "Polje naziv je obavezno za unos !");
					return;
				}
				if (lista.size() == 0)
				{
					Dodavanje.DodajGrad(grad);
					MessageDialog.openInformation(null, "Informacija", "Grad uspješno dodat!");
					close();
				} else
				{
					MessageDialog.openError(null, "Greška", "Taj grad je veæ unešen u bazu podataka!");
					return;
				}
			}
		});
		btnSacuvaj.setBounds(119, 115, 75, 25);
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
		btnOdustani.setBounds(210, 115, 75, 25);
		btnOdustani.setText("Odustani");

		lblDodajNoviGrad = new Label(this, SWT.NONE);
		lblDodajNoviGrad.setText("Dodaj novi grad:");
		lblDodajNoviGrad.setFont(SWTResourceManager.getFont("Arial", 10, SWT.BOLD));
		lblDodajNoviGrad.setBounds(119, 36, 179, 38);

		lblDodajGrad = new Label(this, SWT.NONE);
		lblDodajGrad.setImage(SWTResourceManager.getImage(frmGradovi.class, "/ui/slike/Addfrm.png"));
		lblDodajGrad.setBounds(10, 16, 55, 58);
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
		setText("Unos gradova");
		setSize(303, 182);

	}
}
