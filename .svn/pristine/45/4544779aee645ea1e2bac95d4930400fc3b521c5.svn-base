package ui;

import helper.DAO;
import helper.MojComboBox;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

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

public class frmIzmjeniPacijenta extends Shell
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
			frmIzmjeniPacijenta shell = new frmIzmjeniPacijenta(display);
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

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	private final MojComboBox cmbImePacijenta;
	private final MojComboBox cmbVlasnik;
	private final MojComboBox cmbVrsta;
	private final Text txtGodiste;
	private final Text txtDatumPrijema;

	public frmIzmjeniPacijenta(Display display)
	{
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setImage(SWTResourceManager.getImage(frmIzmjeniPacijenta.class, "/ui/slike/EditThumb.png"));

		Label label = new Label(this, SWT.NONE);
		label.setImage(SWTResourceManager.getImage(frmIzmjeniPacijenta.class, "/ui/slike/Editing.png"));
		label.setBounds(10, 10, 48, 62);

		Label lblImePacijenta = new Label(this, SWT.NONE);
		lblImePacijenta.setBounds(79, 21, 84, 15);
		lblImePacijenta.setText("Ime pacijenta: ");

		cmbImePacijenta = new MojComboBox(this, SWT.READ_ONLY);
		cmbImePacijenta.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				do_cmbImePacijenta_widgetSelected(arg0);
			}
		});
		cmbImePacijenta.setBounds(179, 21, 162, 23);

		Label lblVlasnik = new Label(this, SWT.NONE);
		lblVlasnik.setBounds(79, 61, 55, 15);
		lblVlasnik.setText("Vlasnik:");

		cmbVlasnik = new MojComboBox(this, SWT.READ_ONLY);
		cmbVlasnik.setBounds(179, 61, 162, 23);

		cmbVrsta = new MojComboBox(this, SWT.READ_ONLY);
		cmbVrsta.setBounds(179, 103, 162, 23);

		Label lblVrsta = new Label(this, SWT.NONE);
		lblVrsta.setBounds(79, 103, 55, 15);
		lblVrsta.setText("Vrsta:");

		Label lblGodite = new Label(this, SWT.NONE);
		lblGodite.setBounds(79, 144, 55, 15);
		lblGodite.setText("Godi\u0161te:");

		Label lblDatumPrijema = new Label(this, SWT.NONE);
		lblDatumPrijema.setBounds(79, 184, 84, 15);
		lblDatumPrijema.setText("Datum prijema:");

		Button btnSpasi = new Button(this, SWT.NONE);
		btnSpasi.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				do_btnSpasi_widgetSelected(arg0);
			}
		});
		btnSpasi.setBounds(179, 226, 75, 25);
		btnSpasi.setText("Spasi");

		Button btnOdustani = new Button(this, SWT.NONE);
		btnOdustani.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				do_btnOdustani_widgetSelected(arg0);
			}
		});
		btnOdustani.setBounds(266, 226, 75, 25);
		btnOdustani.setText("Odustani");

		txtGodiste = new Text(this, SWT.BORDER);
		txtGodiste.setBounds(179, 144, 162, 21);

		txtDatumPrijema = new Text(this, SWT.BORDER);
		txtDatumPrijema.setBounds(179, 184, 162, 21);
		createContents();
		List<Pacijent> lista = DAO.getAll(Pacijent.class);
		for (Pacijent p : lista)
		{
			cmbImePacijenta.dodajStavku(p, p.getIme());
		}
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
		// Disable the check that prevents subclassing of SWT components
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents()
	{
		setText("Izmjena pacijenta");
		setSize(369, 294);
		txtGodiste.setEditable(false);
		txtDatumPrijema.setEditable(false);
	}

	protected void do_btnOdustani_widgetSelected(SelectionEvent arg0)
	{
		this.close();
	}

	protected void do_btnSpasi_widgetSelected(SelectionEvent arg0)
	{
		Pacijent p = cmbImePacijenta.uzmiOznacenuStavku(Pacijent.class);
		if (cmbImePacijenta.getText() == "")
		{
			MessageDialog.openError(null, "Greška", "Morate izabrati pacijenta kojeg želite izmijeniti!");
			return;
		}
		p.setVlasnik(cmbVlasnik.uzmiOznacenuStavku(Vlasnik.class));
		p.setVrsta(cmbVrsta.uzmiOznacenuStavku(Vrsta.class));
		DAO.update(p);
		MessageDialog.openInformation(null, "Informacija", "Podaci o pacijentu uspješno izmjenjeni!");
		this.close();
	}

	protected void do_cmbImePacijenta_widgetSelected(SelectionEvent arg0)
	{
		Pacijent p = cmbImePacijenta.uzmiOznacenuStavku(Pacijent.class);
		cmbVlasnik.setText(p.getVlasnik().getIme());
		cmbVrsta.setText(p.getVrsta().getImeVrste());
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		txtGodiste.setText(dateFormat.format(p.getGodiste()));
		Calendar cal2 = Calendar.getInstance();
		DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
		txtDatumPrijema.setText(dateFormat2.format(p.getDatumPrijema()));
	}
}
