package helper;

import java.util.Date;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;

import com.ibm.icu.util.Calendar;

public class MojKalendar extends DateTime
{

	public MojKalendar(Composite parent, int style)
	{
		super(parent, style);

	}

	@Override
	protected void checkSubclass()
	{
	}

	public Date getDatum()
	{
		Calendar instance = Calendar.getInstance();
		instance.set(Calendar.DAY_OF_MONTH, this.getDay());
		instance.set(Calendar.MONTH, this.getMonth());
		instance.set(Calendar.YEAR, this.getYear());
		return instance.getTime();
	}

}
