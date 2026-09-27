package ui;

import model.KorisnickiNalog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

public class frmGlavnaDoktor extends Shell
{

	protected static void do_mntmMojiPodaci_widgetSelected(SelectionEvent arg0)
	{
		KorisnickiNalog k = frmLogin.VratiNalog();
		if (k != null)
		{
			frmMojiPodaci frm = new frmMojiPodaci(k);
			frm.open();
		}

	}

	public static void otvori()
	{
		try
		{
			Display display = Display.getDefault();
			frmGlavnaDoktor shell = new frmGlavnaDoktor(display);
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

	private final Label lblTrenutnoLogiraniKorisnik;

	private final Button button_8;

	public frmGlavnaDoktor(Display display)
	{
		super(display, SWT.MIN | SWT.TITLE);
		setToolTipText("");
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		setImage(SWTResourceManager.getImage(frmGlavnaDoktor.class, "/ui/slike/Doctor-icon.png"));
		setLayout(null);

		lblTrenutnoLogiraniKorisnik = new Label(this, SWT.NONE);
		lblTrenutnoLogiraniKorisnik.setForeground(SWTResourceManager.getColor(65, 105, 225));
		lblTrenutnoLogiraniKorisnik.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblTrenutnoLogiraniKorisnik.setBounds(10, 177, 129, 15);
		lblTrenutnoLogiraniKorisnik.setText("Dobrodo\u0161li : ");

		Menu menu = new Menu(this, SWT.BAR);
		setMenuBar(menu);

		MenuItem mntmKorisnik = new MenuItem(menu, SWT.CASCADE);
		mntmKorisnik.setText("Korisnik");

		Menu menu_4 = new Menu(mntmKorisnik);
		mntmKorisnik.setMenu(menu_4);

		MenuItem mntmMojiPodaci = new MenuItem(menu_4, SWT.NONE);
		mntmMojiPodaci.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				do_mntmMojiPodaci_widgetSelected(arg0);
			}
		});
		mntmMojiPodaci.setText("Moji podaci");

		new MenuItem(menu_4, SWT.SEPARATOR);

		MenuItem mntmLogOut = new MenuItem(menu_4, SWT.NONE);
		mntmLogOut.addSelectionListener(new SelectionAdapter()
		{
			@SuppressWarnings("static-access")
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				_Starter login = new _Starter();
				close();
				login.main(null);

			}
		});
		mntmLogOut.setText("Log out");

		new MenuItem(menu_4, SWT.SEPARATOR);

		MenuItem mntmExit = new MenuItem(menu_4, SWT.NONE);
		mntmExit.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				close();
			}
		});
		mntmExit.setText("Exit");

		new MenuItem(menu_4, SWT.SEPARATOR);

		new MenuItem(menu, SWT.SEPARATOR);

		MenuItem mntmNewSubmenu = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu.setText("Lijekovi");

		Menu menu_1 = new Menu(mntmNewSubmenu);
		mntmNewSubmenu.setMenu(menu_1);

		MenuItem mntmDodajLijek = new MenuItem(menu_1, SWT.NONE);
		mntmDodajLijek.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				frmDodajLijek frm = new frmDodajLijek(null);
				frm.open();
			}
		});
		mntmDodajLijek.setText("Dodaj lijek");

		new MenuItem(menu_1, SWT.SEPARATOR);

		MenuItem mntmPregled = new MenuItem(menu_1, SWT.NONE);
		mntmPregled.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				frmPregledLijekova frm = new frmPregledLijekova(null);
				frm.open();
			}
		});
		mntmPregled.setText("Pregled lijekova");

		new MenuItem(menu_1, SWT.SEPARATOR);

		MenuItem mntmPretragaLijekova = new MenuItem(menu_1, SWT.NONE);
		mntmPretragaLijekova.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				frmPretragaLijekova frm = new frmPretragaLijekova(null);
				frm.open();
			}
		});
		mntmPretragaLijekova.setText("Pretraga lijekova");

		new MenuItem(menu_1, SWT.SEPARATOR);

		MenuItem mntmBrisanjeLijekova = new MenuItem(menu_1, SWT.NONE);
		mntmBrisanjeLijekova.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				do_mntmBrisanjeLijekova_widgetSelected(arg0);
			}
		});
		mntmBrisanjeLijekova.setText("Brisanje lijekova");

		new MenuItem(menu_1, SWT.SEPARATOR);

		MenuItem mntmIzmjeniLijekove = new MenuItem(menu_1, SWT.NONE);
		mntmIzmjeniLijekove.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				do_mntmIzmjeniLijekove_widgetSelected(arg0);
			}
		});
		mntmIzmjeniLijekove.setText("Izmjeni lijekove");

		new MenuItem(menu_1, SWT.SEPARATOR);

		new MenuItem(menu, SWT.SEPARATOR);

		MenuItem mntmPacijenti = new MenuItem(menu, SWT.CASCADE);
		mntmPacijenti.setText("Pacijenti");

		Menu menu_2 = new Menu(mntmPacijenti);
		mntmPacijenti.setMenu(menu_2);

		MenuItem mntmDodajPacijenta = new MenuItem(menu_2, SWT.NONE);
		mntmDodajPacijenta.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				frmAddPacijenta frm = new frmAddPacijenta(null);
				frm.open();
			}
		});
		mntmDodajPacijenta.setText("Dodaj pacijenta");

		new MenuItem(menu_2, SWT.SEPARATOR);

		MenuItem mntmPretraga = new MenuItem(menu_2, SWT.NONE);
		mntmPretraga.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				frmPregledPacijenata frm = new frmPregledPacijenata(null);
				frm.open();
			}
		});
		mntmPretraga.setText("Pregled pacijenata");

		new MenuItem(menu_2, SWT.SEPARATOR);

		MenuItem mntmPretragaPacijenata = new MenuItem(menu_2, SWT.NONE);
		mntmPretragaPacijenata.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				frmPretragaPacijenata frm = new frmPretragaPacijenata(null);
				frm.open();
			}
		});
		mntmPretragaPacijenata.setText("Pretraga pacijenata");

		new MenuItem(menu_2, SWT.SEPARATOR);

		MenuItem mntmBrisanjePacijenata = new MenuItem(menu_2, SWT.NONE);
		mntmBrisanjePacijenata.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				do_mntmBrisanjePacijenata_widgetSelected(arg0);
			}
		});
		mntmBrisanjePacijenata.setText("Brisanje pacijenata");

		new MenuItem(menu_2, SWT.SEPARATOR);

		MenuItem mntmIzmjenaPacijenata = new MenuItem(menu_2, SWT.NONE);
		mntmIzmjenaPacijenata.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				do_mntmIzmjenaPacijenata_widgetSelected(arg0);
			}
		});
		mntmIzmjenaPacijenata.setText("Izmjena pacijenata");

		new MenuItem(menu_2, SWT.SEPARATOR);

		new MenuItem(menu, SWT.SEPARATOR);

		MenuItem mntmDijagnoze = new MenuItem(menu, SWT.CASCADE);
		mntmDijagnoze.setText("Dijagnoze");

		Menu menu_3 = new Menu(mntmDijagnoze);
		mntmDijagnoze.setMenu(menu_3);

		MenuItem mntmDodajDijagnozu = new MenuItem(menu_3, SWT.NONE);
		mntmDodajDijagnozu.addSelectionListener(new SelectionAdapter()
		{
			@SuppressWarnings("static-access")
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				frmDodajDijagnozu frm1 = null;
				frm1.otvori();
			}
		});
		mntmDodajDijagnozu.setText("Dodaj dijagnozu");

		new MenuItem(menu_3, SWT.SEPARATOR);

		MenuItem mntmObriiDijagnoz = new MenuItem(menu_3, SWT.NONE);
		mntmObriiDijagnoz.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				frmPregledDijagnoza frm = new frmPregledDijagnoza(null);
				frm.open();
			}
		});
		mntmObriiDijagnoz.setText("Pregled dijagnoza");

		new MenuItem(menu_3, SWT.SEPARATOR);

		MenuItem mntmPretragaDijagnoza = new MenuItem(menu_3, SWT.NONE);
		mntmPretragaDijagnoza.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				frmPretragaDijagnoza frm = new frmPretragaDijagnoza(null);
				frm.open();
			}
		});
		mntmPretragaDijagnoza.setText("Pretraga dijagnoza");

		new MenuItem(menu_3, SWT.SEPARATOR);

		MenuItem mntmBrisanjeDijagnoza = new MenuItem(menu_3, SWT.NONE);
		mntmBrisanjeDijagnoza.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				do_mntmBrisanjeDijagnoza_widgetSelected(arg0);
			}
		});
		mntmBrisanjeDijagnoza.setText("Brisanje dijagnoza");

		new MenuItem(menu_3, SWT.SEPARATOR);

		MenuItem mntmIzmjenaDijagnoza = new MenuItem(menu_3, SWT.NONE);
		mntmIzmjenaDijagnoza.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				do_mntmIzmjenaDijagnoza_widgetSelected(arg0);
			}
		});
		mntmIzmjenaDijagnoza.setText("Izmjena dijagnoza");

		new MenuItem(menu_3, SWT.SEPARATOR);

		new MenuItem(menu, SWT.SEPARATOR);

		Label lblLijekovi = new Label(this, SWT.NONE);
		lblLijekovi.setText("Lijekovi :");
		lblLijekovi.setFont(SWTResourceManager.getFont("Arial", 12, SWT.BOLD));
		lblLijekovi.setBounds(166, 10, 77, 25);

		Label lblPacijenti = new Label(this, SWT.NONE);
		lblPacijenti.setText("Pacijenti :");
		lblPacijenti.setFont(SWTResourceManager.getFont("Arial", 12, SWT.BOLD));
		lblPacijenti.setBounds(166, 103, 77, 25);

		Label label = new Label(this, SWT.NONE);
		label.setImage(SWTResourceManager.getImage(frmGlavnaDoktor.class, "/ui/slike/1389310981_doctor.png"));
		label.setBounds(10, 13, 137, 128);

		Button button = new Button(this, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				do_button_widgetSelected(arg0);
			}
		});
		button.setImage(SWTResourceManager.getImage(frmGlavnaDoktor.class, "/ui/slike/dodavanjeLijeka.png"));
		button.setBounds(166, 134, 62, 58);

		Button button_1 = new Button(this, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				do_button_1_widgetSelected(arg0);
			}
		});
		button_1.setImage(SWTResourceManager.getImage(frmGlavnaDoktor.class, "/ui/slike/searchLijekovi.png"));
		button_1.setBounds(234, 134, 62, 58);

		Button button_2 = new Button(this, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				do_button_2_widgetSelected(arg0);
			}
		});
		button_2.setImage(SWTResourceManager.getImage(frmGlavnaDoktor.class, "/ui/slike/brisanjePacijenta.png"));
		button_2.setBounds(302, 134, 62, 58);

		Button button_3 = new Button(this, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				do_button_3_widgetSelected(arg0);
			}
		});
		button_3.setImage(SWTResourceManager.getImage(frmGlavnaDoktor.class, "/ui/slike/1389307157_040.png"));
		button_3.setBounds(166, 43, 62, 58);

		Button button_4 = new Button(this, SWT.NONE);
		button_4.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				do_button_4_widgetSelected(arg0);
			}
		});
		button_4.setImage(SWTResourceManager.getImage(frmGlavnaDoktor.class, "/ui/slike/1389307178_033.png"));
		button_4.setBounds(234, 43, 62, 58);

		Button button_5 = new Button(this, SWT.NONE);
		button_5.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				do_button_5_widgetSelected(arg0);
			}
		});
		button_5.setImage(SWTResourceManager.getImage(frmGlavnaDoktor.class, "/ui/slike/1389307239_032.png"));
		button_5.setBounds(302, 43, 62, 58);

		Label lblDijagnoze = new Label(this, SWT.NONE);
		lblDijagnoze.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblDijagnoze.setText("Dijagnoze :");
		lblDijagnoze.setFont(SWTResourceManager.getFont("Arial", 12, SWT.BOLD));
		lblDijagnoze.setBounds(166, 196, 92, 25);

		button_8 = new Button(this, SWT.NONE);
		button_8.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				do_button_8_widgetSelected(arg0);
			}
		});
		button_8.setImage(SWTResourceManager.getImage(frmGlavnaDoktor.class, "/ui/slike/1389307157_040.png"));
		button_8.setBounds(166, 227, 62, 58);

		Button button_9 = new Button(this, SWT.NONE);
		button_9.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				do_button_9_widgetSelected(arg0);
			}
		});
		button_9.setImage(SWTResourceManager.getImage(frmGlavnaDoktor.class, "/ui/slike/1389307178_033.png"));
		button_9.setBounds(234, 227, 62, 58);

		Button button_10 = new Button(this, SWT.NONE);
		button_10.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				do_button_10_widgetSelected(arg0);
			}
		});
		button_10.setImage(SWTResourceManager.getImage(frmGlavnaDoktor.class, "/ui/slike/1389307239_032.png"));
		button_10.setBounds(302, 227, 62, 58);
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
		setText("Doktor::Glavna forma");
		setSize(387, 343);
		lblTrenutnoLogiraniKorisnik.setText(lblTrenutnoLogiraniKorisnik.getText() + " " + Sesija.logiraniKorisnik.getUsername());
	}

	protected void do_button_1_widgetSelected(SelectionEvent arg0)
	{
		frmPretragaPacijenata frm = new frmPretragaPacijenata(null);
		frm.open();
	}

	protected void do_button_10_widgetSelected(SelectionEvent arg0)
	{
		frmObrisiDijagnozu frm = new frmObrisiDijagnozu(null);
		frm.open();
	}

	protected void do_button_2_widgetSelected(SelectionEvent arg0)
	{
		frmObrisiPacijenta forma = new frmObrisiPacijenta(null);
		forma.open();
	}

	protected void do_button_3_widgetSelected(SelectionEvent arg0)
	{
		frmDodajLijek frm = new frmDodajLijek(null);
		frm.open();
	}

	protected void do_button_4_widgetSelected(SelectionEvent arg0)
	{
		frmPretragaLijekova frm = new frmPretragaLijekova(null);
		frm.open();
	}

	protected void do_button_5_widgetSelected(SelectionEvent arg0)
	{
		frmObrisiLijek frm = new frmObrisiLijek(null);
		frm.open();
	}

	protected void do_button_8_widgetSelected(SelectionEvent arg0)
	{
		frmDodajDijagnozu frm = new frmDodajDijagnozu(null);
		frm.open();
	}

	protected void do_button_9_widgetSelected(SelectionEvent arg0)
	{
		frmPretragaDijagnoza frm = new frmPretragaDijagnoza(null);
		frm.open();
	}

	protected void do_button_widgetSelected(SelectionEvent arg0)
	{
		frmAddPacijenta frm = new frmAddPacijenta(null);
		frm.open();
	}

	protected void do_mntmBrisanjeDijagnoza_widgetSelected(SelectionEvent arg0)
	{
		frmObrisiDijagnozu frm = new frmObrisiDijagnozu(null);
		frm.open();
	}

	protected void do_mntmBrisanjeLijekova_widgetSelected(SelectionEvent arg0)
	{
		frmObrisiLijek frm = new frmObrisiLijek(null);
		frm.open();
	}

	protected void do_mntmBrisanjePacijenata_widgetSelected(SelectionEvent arg0)
	{
		frmObrisiPacijenta forma = new frmObrisiPacijenta(null);
		forma.open();
	}

	protected void do_mntmIzmjenaDijagnoza_widgetSelected(SelectionEvent arg0)
	{
		frmIzmjeniDijagnozu frm = new frmIzmjeniDijagnozu(null);
		frm.open();
	}

	protected void do_mntmIzmjenaPacijenata_widgetSelected(SelectionEvent arg0)
	{
		frmIzmjeniPacijenta frm = new frmIzmjeniPacijenta(null);
		frm.open();
	}

	protected void do_mntmIzmjeniLijekove_widgetSelected(SelectionEvent arg0)
	{
		frmIzmjeniLijek frm = new frmIzmjeniLijek(null);
		frm.open();
	}
}
