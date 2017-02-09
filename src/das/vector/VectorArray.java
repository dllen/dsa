package das.vector;

/**
 * 
 * @author shichaopeng 有个很大的缺陷⎯⎯数组容量N固定。一方面，在向量规模很小时，
 *         预留这么多的空间实属浪费;反过来，当向量规模超过N时，即使系统有足够的空间资源，也会因 意外错而崩溃。
 */
public class VectorArray implements Vector {

	private final int N = 1024;

	private int n = 0;

	private Object[] v;

	public VectorArray() {
		v = new Object[N];
	}

	@Override
	public int getSize() {
		return n;
	}

	@Override
	public boolean isEmpty() {
		return n == 0;
	}

	@Override
	public Object getAtRank(int r) throws ExceptionBoundaryViolation {
		if (0 > r || r > n) {
			throw new ExceptionBoundaryViolation("index error");
		}
		return v[r];
	}

	@Override
	public Object replaceAtRank(int r, Object o) throws ExceptionBoundaryViolation {
		if (0 > r || r > n) {
			throw new ExceptionBoundaryViolation("index error");
		}
		Object old = v[r];
		v[r] = o;
		return old;
	}

	@Override
	public Object insertAtRank(int r, Object o) throws ExceptionBoundaryViolation {
		if (0 > r || r > n) {
			throw new ExceptionBoundaryViolation("index error");
		}
		if (n >= N) {
			throw new ExceptionBoundaryViolation("array out range");
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
