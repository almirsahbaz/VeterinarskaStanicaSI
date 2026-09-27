package ui;

import helper.Konekcija;
import helper.MojKalendar;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Lijekovi;

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

public class frmDodajLijek extends Shell
{
	public static void main(String args[])
	{
		try
		{
			Display display = Display.getDefault();
			frmDodajLijek shell = new frmDodajLijek(display);
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

	private final Text txtNaziv;
	private final Text txtVrsta;

	public frmDodajLijek(Display display)
	{
		super(display, SWT.MIN | SWT.TITLE);
		setImage(SWTResourceManager.getImage(frmDodajLijek.class, "/ui/slike/Button-Add-icon.png"));

		Label lblNaziv = new Label(this, SWT.NONE);
		lblNaziv.setBounds(107, 65, 55, 18);
		lblNaziv.setText("Naziv : ");

		txtNaziv = new Text(this, SWT.BORDER);
		txtNaziv.setBounds(182, 62, 123, 21);

		txtVrsta = new Text(this, SWT.BORDER);
		txtVrsta.setBounds(182, 93, 123, 21);

		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setBounds(107, 96, 47, 15);
		lblNewLabel.setText("Vrsta : ");

		Label lblRokTrajanja = new Label(this, SWT.NONE);
		lblRokTrajanja.setBounds(107, 134, 68, 15);
		lblRokTrajanja.setText("Rok trajanja: ");

		final MojKalendar dtRokTrajanja = new MojKalendar(this, SWT.BORDER);
		dtRokTrajanja.setBounds(182, 134, 80, 24);

		Button btnSauvaj = new Button(this, SWT.NONE);
		btnSauvaj.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				Lijekovi lijek = new Lijekovi();
				lijek.setNaziv(txtNaziv.getText());
				lijek.setVrsta(txtVrsta.getText());

				EntityManager em = Konekcija.getEmf().createEntityManager();
				TypedQuery<Lijekovi> q = em.createQuery("select k from Lijekovi k  where k.Naziv = ?", Lijekovi.class);
				q.setParameter(1, txtNaziv.getText());
				List<Lijekovi> lista = q.getResultList();
				em.close();

				lijek.setRok_trajanja(dtRokTrajanja.getDatum());
				if (txtNaziv.getText() == "" || txtVrsta.getText() == "")
				{
					MessageDialog.openError(null, "Greška", "Sva polja su obavezna za unos!");
					return;
				}
				if (lista.size() == 0)
				{
					Dodavanje.DodajLijek(lijek);
					MessageDialog.openInformation(null, "Informacija", "Lijek uspješno dodat!");
					close();
				} else
				{
					MessageDialog.openError(null, "Greška", "Taj lijek je veæ unešen u bazu podataka!");
					return;
				}
			}
		});
		btnSauvaj.setBounds(107, 170, 86, 25);
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
		btnOdustani.setBounds(219, 170, 86, 25);
		btnOdustani.setText("Odustani");

		Label lblDodajLijek = new Label(this, SWT.NONE);
		lblDodajLijek.setFont(SWTResourceManager.getFont("Arial", 14, SWT.BOLD));
		lblDodajLijek.setBounds(107, 26, 198, 24);
		lblDodajLijek.setText("DODAVANJE LIJEKA");

		Label lblNewLabel_1 = new Label(this, SWT.NONE);
		lblNewLabel_1.setImage(SWTResourceManager.getImage(frmDodajLijek.class, "/ui/slike/1389382375_first_aid_kit.png"));
		lblNewLabel_1.setBounds(10, 32, 80, 72);
		createContents();
	}

	@Override
	protected void checkSubclass()
	{
	}

	protected void createContents()
	{
		setText("Dodavanje lijeka");
		setSize(321, 233);
	}
}
