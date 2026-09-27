package ui;

import model.KorisnickiNalog;
import model.KorisnickiNalog.TipKorisnika;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import servis.LoginServis;

public class frmLogin extends Shell
{
	private final Text txtUsername;
	private final Text txtLozinka;

	private static KorisnickiNalog nalog;

	public static void SetNalog(KorisnickiNalog k)
	{
		nalog = k;
	}

	public static KorisnickiNalog VratiNalog()
	{
		return nalog;
	}

	public frmLogin(Display display)
	{
		super(display, SWT.TITLE);
		setImage(SWTResourceManager.getImage(frmLogin.class, "/ui/slike/staroflife.png"));

		Label lblKorisnikoIme = new Label(this, SWT.NONE);
		lblKorisnikoIme.setBounds(57, 161, 91, 15);
		lblKorisnikoIme.setText("Korisni\u010Dko ime :");

		Label lblLozinka = new Label(this, SWT.NONE);
		lblLozinka.setBounds(57, 224, 55, 15);
		lblLozinka.setText("Lozinka :");

		txtUsername = new Text(this, SWT.BORDER);
		txtUsername.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent arg0)
			{
				do_txtUsername_keyPressed(arg0);
			}
		});
		txtUsername.setBounds(57, 182, 197, 21);

		txtLozinka = new Text(this, SWT.BORDER | SWT.PASSWORD);
		txtLozinka.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent arg0)
			{
				do_txtLozinka_keyPressed(arg0);
			}
		});
		txtLozinka.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		txtLozinka.setToolTipText("");
		txtLozinka.setBounds(57, 245, 197, 21);

		Button btnLogin = new Button(this, SWT.NONE);
		btnLogin.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				do_btnLogin_widgetSelected(arg0);
			}
		});

		btnLogin.setBounds(57, 284, 91, 21);
		btnLogin.setText("Login");

		Button btnOdustani = new Button(this, SWT.NONE);
		btnOdustani.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				close();
			}
		});
		btnOdustani.setBounds(163, 284, 91, 21);
		btnOdustani.setText("Odustani");

		Label label = new Label(this, SWT.NONE);
		label.setImage(SWTResourceManager.getImage(frmLogin.class, "/ui/slike/staroflife.png"));
		label.setBounds(81, 13, 149, 142);
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
		setText("Veterinarska stanica::Login");
		setSize(316, 361);
	}

	protected void do_btnLogin_widgetSelected(SelectionEvent arg0)
	{
		String Username = txtUsername.getText().trim();
		String Password = txtLozinka.getText().trim();
		if (Username == "" || Password == "")
		{
			MessageDialog.openError(null, "Greška", "Polje korisničko ime i/ili lozinka je prazno!");
			return;
		} else if (txtUsername.getText().length() < 3 || txtLozinka.getText().length() < 3)
		{
			MessageDialog.openError(null, "Greška", "Polja korisničko ime i lozinka moraju biti minimalno dužine 3 karaktera!");
			txtUsername.setText("");
			txtLozinka.setText("");
			return;
		}
		KorisnickiNalog k = LoginServis.loginKorisnik(txtUsername.getText(), txtLozinka.getText());
		if (k == null)
		{
			MessageDialog.openError(null, "Greška", "Login podaci koje ste unijeli nisu validni!");
			txtUsername.setText("");
			txtLozinka.setText("");
			return;
		}
		if (k.getIsAktivan() == false)
		{
			MessageDialog.openError(null, "Greška", "Vaš account" + " " + k.getUsername() + " " + "je deaktiviran!");
			txtUsername.setText("");
			txtLozinka.setText("");
			return;
		}
		Sesija.logiraniKorisnik = k;
		KorisnickiNalog k2 = new KorisnickiNalog();
		if (k != null)
		{
			k2 = k;
			SetNalog(k2);
		}
		close();
		if (k.getTipK() == TipKorisnika.administrator)
		{
			frmGlavnaAdministrator.otvori();
		}
		if (k.getTipK() == TipKorisnika.doktor)
		{
			frmGlavnaDoktor.otvori();
		}
		if (k.getTipK() == TipKorisnika.tehnickoOsoblje)
		{
			frmGlavnaTehnickoOsoblje.otvori();
		}
	}

	protected void do_txtLozinka_keyPressed(org.eclipse.swt.events.KeyEvent enter)
	{
		if (enter.keyCode == SWT.CR || enter.keyCode == SWT.LF)
			do_btnLogin_widgetSelected(null);
	}

	protected void do_txtUsername_keyPressed(org.eclipse.swt.events.KeyEvent enter)
	{
		if (enter.keyCode == SWT.CR || enter.keyCode == SWT.LF)
			do_btnLogin_widgetSelected(null);
	}

}
