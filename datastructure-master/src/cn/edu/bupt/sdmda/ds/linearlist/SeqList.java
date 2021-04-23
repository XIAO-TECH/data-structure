package cn.edu.bupt.sdmda.ds.linearlist;

public class SeqList<T> implements LinearList<T>{

	private Object[] _data;
	private int _size;

	public SeqList(int s, T init){
		init(s,init);  
	}

	public SeqList(){
		init(0,null); 
	}

	@Override
	public void init(int s, T init) {
		// TODO Auto-generated method stub
		_size=s;
		_data=new Object[s];
		for(int i=0;i<_data.length;i++) {
			_data[i]=init;
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return(getSize()==0);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return _size;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		_size=0;
	}

	@Override
	public void insert(int i, T t) {
		// TODO Auto-generated method stub
		// TODO check i
		if (!checkWritableRange(i)) {
			throw new IndexOutOfBoundsException();
		}
		if (_size==_data.length) {
			Object[] newdata= new Object[_size+1];
			System.arraycopy(_data, 0, newdata, 0, i);
			System.arraycopy(_data, i, newdata, i+1, _data.length-i);
			_data=newdata;
		}
		_data[i]=t;
		_size++;
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		int i=find(t);
		deleteAt(i);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T deleteAt(int i) {
		// TODO Auto-generated method stub
		if (!checkReadableRange(i)) {
			throw new IndexOutOfBoundsException();
			
		}
		_size--;
		T t=(T)_data[i];
		if(i<_data.length-1) {
			System.arraycopy(_data, i+1, _data, i, getSize()-i);
			
		}
		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int i) {
		// TODO Auto-generated method stub
		return (T) _data[i];
		
	}

	@Override
	public void set(int i, T t) {
		// TODO Auto-generated method stub
		_data[i]=t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int find(T t) {
		// TODO Auto-generated method stub
		
		for (int i=0; i < _data.length; i++) {
			T cur =(T)_data[i];
			if (cur.equals(t)) {
				return i;
			}
		}
		return -1;
		
	}

	@Override
	public LinearList<T> sort() {
		// TODO Auto-generated method stub
		return null;
	}

	private boolean checkReadableRange(int i){
		if (i<=_size) {
			return true;
		} else {
			return false;
		}
	}

	private boolean checkWritableRange(int i){
		
		return true;

	}
}
