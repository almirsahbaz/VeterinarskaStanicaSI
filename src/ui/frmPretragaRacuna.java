package ui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import model.Racuni;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import servis.Pretraga;

public class frmPretragaRacuna extends Shell
{
	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	private Racuni odabraniRacun = null;
	private final Text txtArgument;

	private final Table tblRacuni;

	public frmPretragaRacuna(Display display)
	{
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setImage(SWTResourceManager.getImage(frmPretragaRacuna.class, "/ui/slike/search-b-icon.png"));

		txtArgument = new Text(this, SWT.BORDER);
		txtArgument.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent arg0)
			{
				do_txtArgument_keyPressed(arg0);
			}
		});
		txtArgument.setBounds(10, 10, 302, 21);

		tblRacuni = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		tblRacuni.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseDoubleClick(MouseEvent arg0)
			{
				do_tblRacuni_mouseDoubleClick(arg0);
			}
		});
		tblRacuni.setBounds(10, 37, 302, 225);
		tblRacuni.setHeaderVisible(true);
		tblRacuni.setLinesVisible(true);

		TableColumn tblclmnNewColumn = new TableColumn(tblRacuni, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("Naziv");

		TableColumn tblclmnIznosZaPlatit = new TableColumn(tblRacuni, SWT.NONE);
		tblclmnIznosZaPlatit.setWidth(100);
		tblclmnIznosZaPlatit.setText("Datum");

		TableColumn tblclmnNaziv = new TableColumn(tblRacuni, SWT.NONE);
		tblclmnNaziv.setText("Iznos");
		tblclmnNaziv.setWidth(97);
		createContents();
	}

	@Override
	protected void checkSubclass()
	{
		// Disable the check that prevents subclassing of SWT components
	}

	protected void createContents()
	{
		setText("Pretraga ra\u010Duna");
		setSize(327, 300);

	}

	protected void do_tblRacuni_mouseDoubleClick(MouseEvent arg0)
	{
		odaberi();
	}

	protected void do_txtArgument_keyPressed(KeyEvent arg0)
	{
		tblRacuni.removeAll();
		List<Racuni> result = Pretraga.PretragaRacuna(txtArgument.getText());
		for (Racuni r : result)
		{
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Calendar cal = Calendar.getInstance();
			TableItem tblI = new TableItem(tblRacuni, 0);
			tblI.setData(r);
			tblI.setText(0, r.getNaziv());
			tblI.setText(1, dateFormat.format(r.getDatum()));
			tblI.setText(2, r.getIznosZaPlatiti());
			tblI.setText(3, "?");
		}
	}

	private void odaberi()
	{
		TableItem[] x = tblRacuni.getSelection();
		if (x.length > 0)
		{
			TableItem item = x[0];
			odabraniRacun = (Racuni) item.getData();
			close();
		}
	}

	public Racuni otvoriDialog()
	{
		super.open();

		Display display = Display.getDefault();

		while (!super.isDisposed())
		{
			if (!display.readAndDispatch())
			{
				display.sleep();
			}
		}
		return odabraniRacun;
	}
}
