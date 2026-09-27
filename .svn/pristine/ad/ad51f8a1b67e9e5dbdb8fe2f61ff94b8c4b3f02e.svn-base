package helper;

import java.util.Date;

import com.ibm.icu.text.SimpleDateFormat;

public class Datum
{
	public static String Parsiraj(Date datum)
	{
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat("d.m.yyyy");
			return sdf.format(datum);
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static Date Parsiraj(String string)
	{
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat("d.m.yyyy");
			return sdf.parse(string);
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
