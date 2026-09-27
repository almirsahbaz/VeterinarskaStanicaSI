package ui;

import java.util.List;

import model.Vlasnik;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import servis.Pretraga;

public class frmPretragavlasnika extends Shell
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
			frmPretragavlasnika shell = new frmPretragavlasnika(display);
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

	private final Text txtargument;

	private final Table tblvlasnici;

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public frmPretragavlasnika(Display display)
	{
		super(display, SWT.CLOSE | SWT.MIN | SWT.MAX | SWT.TITLE);
		setImage(SWTResourceManager.getImage(frmPretragavlasnika.class, "/ui/slike/search-b-icon.png"));

		txtargument = new Text(this, SWT.BORDER);
		txtargument.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent arg0)
			{
				tblvlasnici.removeAll();
				List<Vlasnik> Lista = Pretraga.Pretragavlasnika(txtargument.getText());
				for (Vlasnik v : Lista)
				{
					final TableItem tabela = new TableItem(tblvlasnici, SWT.None);
					tabela.setText(0, v.getIme());
					tabela.setText(1, v.getPrezime());

				}
			}
		});
		txtargument.setBounds(20, 20, 213, 21);

		tblvlasnici = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		tblvlasnici.setBounds(20, 49, 213, 191);
		tblvlasnici.setHeaderVisible(true);
		tblvlasnici.setLinesVisible(true);

		TableColumn tblclmnIme = new TableColumn(tblvlasnici, SWT.NONE);
		tblclmnIme.setWidth(92);
		tblclmnIme.setText("Ime");

		TableColumn tblclmnPrezime = new TableColumn(tblvlasnici, SWT.NONE);
		tblclmnPrezime.setWidth(117);
		tblclmnPrezime.setText("Prezime");
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
		setText("Pretraga vlasnika");
		setSize(259, 288);

	}
}
