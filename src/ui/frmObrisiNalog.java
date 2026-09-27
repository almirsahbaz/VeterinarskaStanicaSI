package ui;

import helper.DAO;
import helper.Konekcija;
import helper.MojComboBox;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Administrator;
import model.Doktori;
import model.KorisnickiNalog;
import model.Tehnicko_osoblje;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

public class frmObrisiNalog extends Shell
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
			frmObrisiNalog shell = new frmObrisiNalog(display);
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

	private final Label lblKorisnikoIme;
	private final MojComboBox cmbKorisnickiNalog;
	private final Button btnObrisi;

	private final Button btnOdustani;
	private final Label lblObriiNalog;
	private final Label lblObrisi;
	private final Label lblKorisnikiNalog;

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public frmObrisiNalog(Display display)
	{
		super(display, SWT.MIN | SWT.TITLE);
		setImage(SWTResourceManager.getImage(frmObrisiNalog.class, "/ui/slike/data-delete-icon.png"));

		lblKorisnikoIme = new Label(this, SWT.NONE);
		lblKorisnikoIme.setBounds(10, 82, 111, 15);
		lblKorisnikoIme.setText("Korisni\u010Dko ime:");

		cmbKorisnickiNalog = new MojComboBox(this, SWT.READ_ONLY);
		cmbKorisnickiNalog.setBounds(121, 79, 173, 23);

		btnObrisi = new Button(this, SWT.NONE);
		btnObrisi.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				do_btnObrisi_widgetSelected(arg0);
			}
		});
		btnObrisi.setBounds(121, 122, 75, 25);
		btnObrisi.setText("Obri\u0161i");

		btnOdustani = new Button(this, SWT.NONE);
		btnOdustani.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				do_btnOdustani_widgetSelected(arg0);
			}
		});
		btnOdustani.setBounds(219, 122, 75, 25);
		btnOdustani.setText("Odustani");

		lblObriiNalog = new Label(this, SWT.NONE);
		lblObriiNalog.setText("Obri\u0161i master");
		lblObriiNalog.setFont(SWTResourceManager.getFont("Arial", 10, SWT.BOLD));
		lblObriiNalog.setBounds(158, 33, 111, 15);

		lblObrisi = new Label(this, SWT.NONE);
		lblObrisi.setImage(SWTResourceManager.getImage(frmObrisiNalog.class, "/ui/slike/deletefrm.png"));
		lblObrisi.setBounds(10, 10, 55, 58);

		lblKorisnikiNalog = new Label(this, SWT.NONE);
		lblKorisnikiNalog.setFont(SWTResourceManager.getFont("Arial", 10, SWT.BOLD));
		lblKorisnikiNalog.setBounds(150, 49, 119, 22);
		lblKorisnikiNalog.setText("korisni\u010Dki nalog:");
		createContents();
		EntityManager em = Konekcija.getEmf().createEntityManager();
		TypedQuery<KorisnickiNalog> q = em.createQuery(
				"select k from KorisnickiNalog k  where k.username !=? and k.username !=? and k.username !=? ", KorisnickiNalog.class);
		q.setParameter(1, "administrator");
		q.setParameter(2, "doktor");
		q.setParameter(3, "tehnicko");
		List<KorisnickiNalog> lista3 = q.getResultList();
		for (KorisnickiNalog k : lista3)
		{
			Integer username = k.getKorisnickiNalogID();
			Integer username2 = k.getKorisnickiNalogID();
			Integer username3 = k.getKorisnickiNalogID();
			EntityManager em2 = Konekcija.getEmf().createEntityManager();
			TypedQuery<Administrator> q2 = em2
					.createQuery("select a from Administrator a  where a._nalog.KorisnickiNalogID =? ", Administrator.class);
			q2.setParameter(1, username);
			List<Administrator> lista = q2.getResultList();
			em2.close();

			EntityManager em3 = Konekcija.getEmf().createEntityManager();
			TypedQuery<Doktori> q3 = em3.createQuery("select d from Doktori d  where d._nalog.KorisnickiNalogID =? ", Doktori.class);
			q3.setParameter(1, username2);
			List<Doktori> lista2 = q3.getResultList();
			em3.close();

			EntityManager em5 = Konekcija.getEmf().createEntityManager();
			TypedQuery<Tehnicko_osoblje> q5 = em5.createQuery("select t from Tehnicko_osoblje t  where t._nalog.KorisnickiNalogID =? ",
					Tehnicko_osoblje.class);
			q5.setParameter(1, username3);
			List<Tehnicko_osoblje> lista5 = q5.getResultList();
			em5.close();

			if (lista.size() == 0 && lista2.size() == 0 && lista5.size() == 0)
				cmbKorisnickiNalog.dodajStavku(k, k.getUsername());

		}
		em.close();
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
		setText("Brisanje master naloga");
		setSize(306, 185);

	}

	protected void do_btnObrisi_widgetSelected(SelectionEvent arg0)
	{
		if (cmbKorisnickiNalog.getText() == "")
		{
			MessageDialog.openError(null, "Greška", "Morate odabrati korisnièki nalog koji želite obrisati!");
			return;
		}
		KorisnickiNalog k = cmbKorisnickiNalog.uzmiOznacenuStavku(KorisnickiNalog.class);
		DAO.brisi(k);
		MessageDialog.openInformation(null, "Informacija", "Korisnièki podaci uspješno obrisani!");
		close();
	}

	protected void do_btnOdustani_widgetSelected(SelectionEvent arg0)
	{
		close();
	}
}
