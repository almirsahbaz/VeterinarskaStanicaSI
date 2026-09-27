package ui;

import helper.DAO;
import helper.MojComboBox;

import java.util.List;

import model.Terapija;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

public class FrmObrisiTerapije extends Shell
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
			FrmObrisiTerapije shell = new FrmObrisiTerapije(display);
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
	public FrmObrisiTerapije(Display display)
	{
		super(display, SWT.CLOSE | SWT.MIN | SWT.MAX | SWT.TITLE);
		setImage(SWTResourceManager.getImage(FrmObrisiTerapije.class, "/ui/slike/1389302842_edit-delete.png"));
		setText("Brisanje terapija");
		setSize(303, 234);

		Label label = new Label(this, SWT.SHADOW_NONE);
		label.setText("BRISANJE VLASNIKA");
		label.setImage(SWTResourceManager.getImage(FrmObrisiTerapije.class, "/ui/slike/delete72.png"));
		label.setFont(SWTResourceManager.getFont("Arial", 14, SWT.BOLD));
		label.setAlignment(SWT.RIGHT);
		label.setBounds(0, 0, 72, 95);

		final MojComboBox cmbTerapija = new MojComboBox(this, SWT.READ_ONLY);
		cmbTerapija.setBounds(82, 94, 196, 23);

		Label lblusluga = new Label(this, SWT.NONE);
		lblusluga.setText("Vrsta : ");
		lblusluga.setBounds(10, 97, 55, 15);

		Button btnObrisi = new Button(this, SWT.NONE);
		btnObrisi.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				Terapija u = cmbTerapija.uzmiOznacenuStavku(Terapija.class);
				if (cmbTerapija.getText() == "")
				{
					MessageDialog.openError(null, "Greška", "Morate odabrati terapiju koju želite obrisati!");
					return;
				}
				DAO.brisi(u);
				MessageDialog.openInformation(null, "Informacija", "Terapija uspješno obrisana!");
				close();
			}
		});
		btnObrisi.setText("Obri\u0161i");
		btnObrisi.setBounds(83, 149, 85, 25);

		Button button_1 = new Button(this, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				close();
			}
		});
		button_1.setText("Odustani");
		button_1.setBounds(194, 149, 85, 25);

		Label lblBrisanjeUsluga = new Label(this, SWT.NONE);
		lblBrisanjeUsluga.setAlignment(SWT.CENTER);
		lblBrisanjeUsluga.setFont(SWTResourceManager.getFont("Arial", 15, SWT.BOLD));
		lblBrisanjeUsluga.setBounds(78, 40, 200, 48);
		lblBrisanjeUsluga.setText("BRISANJE TERAPIJA");
		createContents();
		List<Terapija> lista = DAO.getAll(Terapija.class);
		for (Terapija u : lista)
		{
			cmbTerapija.dodajStavku(u, u.getVrsta());
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

	}

}
