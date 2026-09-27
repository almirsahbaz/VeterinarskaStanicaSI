package ui;

import helper.DAO;
import helper.MojComboBox;

import java.util.List;

import model.Dijagnoze;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

public class frmObrisiDijagnozu extends Shell
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
			frmObrisiDijagnozu shell = new frmObrisiDijagnozu(display);
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

	private final MojComboBox cmbDijagnoze;

	public frmObrisiDijagnozu(Display display)
	{
		super(display, SWT.MIN | SWT.TITLE);
		setImage(SWTResourceManager.getImage(frmObrisiDijagnozu.class, "/ui/slike/data-delete-icon.png"));
		setLayout(null);

		Label lblDijagnoza = new Label(this, SWT.NONE);
		lblDijagnoza.setBounds(10, 79, 71, 15);
		lblDijagnoza.setText("Dijagnoza : ");

		cmbDijagnoze = new MojComboBox(this, SWT.READ_ONLY);
		cmbDijagnoze.setBounds(111, 76, 144, 23);

		Button btnObrisi = new Button(this, SWT.NONE);
		btnObrisi.setBounds(111, 118, 67, 25);
		btnObrisi.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				do_btnObrisi_widgetSelected(arg0);
			}
		});
		btnObrisi.setText("Obri\u0161i");

		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				do_btnNewButton_widgetSelected(arg0);
			}
		});
		btnNewButton.setBounds(188, 118, 67, 25);
		btnNewButton.setText("Odustani");

		Label lblObriiDijagnozu = new Label(this, SWT.NONE);
		lblObriiDijagnozu.setFont(SWTResourceManager.getFont("Arial", 14, SWT.BOLD));
		lblObriiDijagnozu.setBounds(75, 28, 180, 23);
		lblObriiDijagnozu.setText("OBRI\u0160I DIJAGNOZU");

		Label label = new Label(this, SWT.NONE);
		label.setImage(SWTResourceManager.getImage(frmObrisiDijagnozu.class, "/ui/slike/deletefrm.png"));
		label.setBounds(10, 28, 55, 48);
		createContents();
		List<Dijagnoze> lista = DAO.getAll(Dijagnoze.class);
		for (Dijagnoze d : lista)
		{
			cmbDijagnoze.dodajStavku(d, d.getNaziv_bolesti());
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
		setText("Brisanje dijagnoze");
		setSize(269, 181);

	}

	protected void do_btnNewButton_widgetSelected(SelectionEvent arg0)
	{
		close();
	}

	protected void do_btnObrisi_widgetSelected(SelectionEvent arg0)
	{
		Dijagnoze d = cmbDijagnoze.uzmiOznacenuStavku(Dijagnoze.class);
		if (cmbDijagnoze.getText() == "")
		{
			MessageDialog.openError(null, "Greška", "Morate odabrati dijagnozu koju želite obrisati!");
			return;
		}
		DAO.brisi(d);
		MessageDialog.openInformation(null, "Informacija", "Dijagnoza uspješno obrisana!");
		close();
	}
}
