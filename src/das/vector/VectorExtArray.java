package das.vector;

public class VectorExtArray implements Vector {

	private int N = 8;

	private int n;

	private Object[] v;

	public VectorExtArray() {
		n = 0;
		v = new Object[N];
	}

	@Override
	public int getSize() {
		return n;
	}

	@Override
	public boolean isEmpty() {
		return 0 == n;
	}

	@Override
	public Object getAtRank(int r) throws ExceptionBoundaryViolation {
		if (0 > r || r > n)
			throw new ExceptionBoundaryViolation("index error");
		return v[r];
	}

	@Override
	public Object replaceAtRank(int r, Object o) throws ExceptionBoundaryViolation {
		if (0 > r || r > n)
			throw new ExceptionBoundaryViolation("index error");
		Object old = v[r];
		v[r] = o;
		return old;
	}

	@Override
	public Object insertAtRank(int r, Object o) throws ExceptionBoundaryViolation {
		if (0 > r || r > n)
			throw new ExceptionBoundaryViolation("index error");
		if (N <= n) {
			N *= 2;
			Object[] temp = new Object[N];
			for (int i = 0; i < v.length; i++) {
				temp[i] = v[i];
			}
			v = temp;
		}
		for (int i = n; i > r; i--) {
			v[i] = v[i - 1];
		}
		v[r] = o;
		n++;
		return o;
	}

	@Override
	public Object removeAtRank(int r) throws ExceptionBoundaryViolation {
		if (0 > r || r > n) {
			throw new ExceptionBoundaryViolation("index error");
		}
		Object remove = v[r];
		for (int i = r; i < n; i++) {
			v[i] = v[i + 1];
		}
		n--;
		return remove;
	}

}
