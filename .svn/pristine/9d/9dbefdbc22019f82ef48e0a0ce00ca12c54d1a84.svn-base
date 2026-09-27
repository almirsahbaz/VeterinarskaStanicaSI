package ui;

import helper.DAO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import model.KupljeniLijekovi;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

public class frmPregledRacuna extends Shell
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
			frmPregledRacuna shell = new frmPregledRacuna(display);
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

	private final Table tblTerapije;

	public frmPregledRacuna(Display display)
	{
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setImage(SWTResourceManager.getImage(frmPregledRacuna.class, "/ui/slike/search-b-icon.png"));

		tblTerapije = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		tblTerapije.setBounds(0, 10, 598, 252);
		tblTerapije.setHeaderVisible(true);
		tblTerapije.setLinesVisible(true);

		TableColumn tblclmnVrsta = new TableColumn(tblTerapije, SWT.NONE);
		tblclmnVrsta.setWidth(112);
		tblclmnVrsta.setText("Naziv");

		TableColumn tblclmnDatum = new TableColumn(tblTerapije, SWT.NONE);
		tblclmnDatum.setWidth(122);
		tblclmnDatum.setText("Datum");

		TableColumn tblclmnIznos = new TableColumn(tblTerapije, SWT.NONE);
		tblclmnIznos.setWidth(126);
		tblclmnIznos.setText("Iznos");

		TableColumn tblclmnKoliina = new TableColumn(tblTerapije, SWT.NONE);
		tblclmnKoliina.setWidth(113);
		tblclmnKoliina.setText("Koli\u010Dina");

		TableColumn tblclmnLijek = new TableColumn(tblTerapije, SWT.NONE);
		tblclmnLijek.setWidth(120);
		tblclmnLijek.setText("Lijek");
		createContents();

		for (KupljeniLijekovi k : DAO.getAll(KupljeniLijekovi.class))
		{
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Calendar cal = Calendar.getInstance();

			TableItem tableItem = new TableItem(tblTerapije, SWT.NONE);
			tableItem.setText(0, k.getRacuni().getNaziv());
			tableItem.setText(1, dateFormat.format(k.getRacuni().getDatum()));
			tableItem.setText(2, k.getRacuni().getIznosZaPlatiti());
			tableItem.setText(3, IntToString(k.getKolicina()));
			tableItem.setText(4, k.lijekovi.getNaziv());
		}
	}

	@Override
	protected void checkSubclass()
	{
		// Disable the check that prevents subclassing of SWT components
	}

	protected void createContents()
	{
		setText("Pregled ra\u010Duna");
		setSize(608, 300);

	}

	public String IntToString(Integer i)
	{
		return i.toString();
	}

}
