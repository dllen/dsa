package das.list;

import das.linkedlist.Position;

public class IteratorPosition implements Iterator {

	private List list;

	private Position nextPosition;

	public IteratorPosition() {

	}

	public IteratorPosition(List l) {
		list = l;
		if (list.isEmpty())
			nextPosition = null;
		else
			nextPosition = l.first();
	}

	@Override
	public boolean hasNext() {
		return nextPosition != null;
	}

	@Override
	public Object getNext() {
		if (!hasNext())
			throw new ExceptionNoSuchElement("error");
		Position position = nextPosition;
		if (position == list.last())
			nextPosition = null;
		else
			nextPosition = list.getNext(position);
		return position;
	}

}
