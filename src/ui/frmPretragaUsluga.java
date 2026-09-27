package ui;

import helper.Datum;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import model.Usluge;

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

public class frmPretragaUsluga extends Shell
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
			frmPretragaUsluga shell = new frmPretragaUsluga(display);
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

	private final Table tblUsluge;

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public frmPretragaUsluga(Display display)
	{
		super(display, SWT.CLOSE | SWT.MIN | SWT.MAX | SWT.TITLE);
		setImage(SWTResourceManager.getImage(frmPretragaUsluga.class, "/ui/slike/search-b-icon.png"));

		txtargument = new Text(this, SWT.BORDER);
		txtargument.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent arg0)
			{
				Datum datum = new Datum();
				tblUsluge.removeAll();
				List<Usluge> lista = Pretraga.Pretragausluga(txtargument.getText());
				for (Usluge u : lista)
				{
					DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					Calendar cal = Calendar.getInstance();
					final TableItem tbl = new TableItem(tblUsluge, SWT.None);
					tbl.setText(0, u.getNaziv());
					tbl.setText(1, dateFormat.format(u.getDatumUsluge()));
				}
			}
		});
		txtargument.setBounds(10, 24, 264, 21);

		tblUsluge = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		tblUsluge.setBounds(10, 60, 264, 192);
		tblUsluge.setHeaderVisible(true);
		tblUsluge.setLinesVisible(true);

		TableColumn tblclmnNaziv = new TableColumn(tblUsluge, SWT.NONE);
		tblclmnNaziv.setWidth(159);
		tblclmnNaziv.setText("Naziv");

		TableColumn tblclmnDatum = new TableColumn(tblUsluge, SWT.NONE);
		tblclmnDatum.setWidth(100);
		tblclmnDatum.setText("Datum");
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
		setText("Pretraga usluga");
		setSize(290, 300);

	}

}
