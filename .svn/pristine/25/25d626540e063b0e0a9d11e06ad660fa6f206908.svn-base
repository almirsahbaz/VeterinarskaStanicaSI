package helper;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

public class MojComboBox extends Combo
{

	private final List<Object> idovi = new ArrayList<>();

	public MojComboBox(Composite parent, int styleBit)
	{
		super(parent, styleBit);
	}

	@Deprecated
	@Override
	public void add(String arg0)
	{
		throw new RuntimeException("Nije moguce koristiti ovu metodu");
	}

	@Override
	protected void checkSubclass()
	{
	}

	public void dodajStavku(Object id, String opis)
	{
		idovi.add(id);
		super.add(opis);
	}

	public <T> List<T> getIds(Class<T> type)
	{
		List<T> t = new ArrayList<T>((ArrayList<T>) idovi);
		return t;
	}

	public void ocistiSve()
	{
		idovi.clear();
		super.removeAll();
	}

	public void OznaciStavku(Object id)
	{
		int indexOf = idovi.indexOf(id);
		super.select(indexOf);
	}

	public <T> T uzmiOznacenuStavku(Class<T> type)
	{
		int i = super.getSelectionIndex();
		if (i == -1)
			return null;
		T id = (T) idovi.get(i);
		return id;
	}

	public Integer uzmiOznacenuStavkuInt()
	{
		int i = super.getSelectionIndex();
		if (i == -1)
			return null;
		Integer id = (Integer) idovi.get(i);
		return id;
	}

	public String uzmiOznacenuStavkuString()
	{
		int i = super.getSelectionIndex();
		if (i == -1)
			return null;
		String id = (String) idovi.get(i);
		return id;
	}

}
