package cn.edu.bupt.sdmda.ds.linearlist;

public class SeqStack<T> extends SeqList<T> implements MyStack<T>{

	public SeqStack(){
		super();
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		int size =super.getSize();
		T t=super.get(size-1);
		super.deleteAt(size-1);
		return t;
	}

	@Override
	public void push(T t) {
		// TODO Auto-generated method stub
		int size=super.getSize();
		super.insert(size, t);
	}

	@Override
	public T getTop(){
		return super.get(super.getSize());
	}


	@Override
	public void insert(int i, T t) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public T deleteAt(int i) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	@Override
	public T get(int i) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	@Override
	public void set(int i, T t) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public int find(T t) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public LinearList<T> sort() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

}
