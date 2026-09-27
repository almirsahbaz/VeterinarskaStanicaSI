package ui;

import java.util.List;

import model.Dijagnoze;

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

public class frmPretragaDijagnoza extends Shell
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
			frmPretragaDijagnoza shell = new frmPretragaDijagnoza(display);
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

	private final Text argument;
	private final Table tblDijagnoze;

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public frmPretragaDijagnoza(Display display)
	{
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setImage(SWTResourceManager.getImage(frmPretragaDijagnoza.class, "/ui/slike/search-b-icon.png"));
		setLayout(null);

		argument = new Text(this, SWT.BORDER);
		argument.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent arg0)
			{
				do_argument_keyPressed(arg0);
			}
		});

		argument.setBounds(10, 10, 204, 21);

		tblDijagnoze = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		tblDijagnoze.setBounds(10, 37, 204, 213);
		tblDijagnoze.setHeaderVisible(true);
		tblDijagnoze.setLinesVisible(true);

		TableColumn tblclmnNazivDijagnoze = new TableColumn(tblDijagnoze, SWT.NONE);
		tblclmnNazivDijagnoze.setWidth(100);
		tblclmnNazivDijagnoze.setText("Naziv dijagnoze");

		TableColumn tblclmnSifraDijagnoze = new TableColumn(tblDijagnoze, SWT.NONE);
		tblclmnSifraDijagnoze.setWidth(100);
		tblclmnSifraDijagnoze.setText("\u0160ifra dijagnoze");
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
		setText("Pretraga dijagnoza");
		setSize(232, 286);

	}

	protected void do_argument_keyPressed(KeyEvent arg0)
	{
		tblDijagnoze.removeAll();
		List<Dijagnoze> result = Pretraga.PretragaDijagnoza(argument.getText());
		for (Dijagnoze dijagnoze : result)
		{
			final TableItem tblI = new TableItem(tblDijagnoze, SWT.None);
			tblI.setText(0, dijagnoze.getNaziv_bolesti());
			tblI.setText(1, dijagnoze.getSifra_dijagnoze());

		}
	}
}
