package cn.edu.bupt.sdmda.ds.tree;

import java.util.LinkedList;

public class BiTree<T> {
	BiTreeNode<T> _root;
	// a queue to store the order of traverse
	LinkedList<BiTreeNode<T>> _queue = new LinkedList<>();

	// Create a tree whose root is root and data is data[loc]
	private void createTree(BiTreeNode<T> root, T[] data, int loc) {
		// if the left child of root is valid,
		// create a tree whose root is it

		// if the right child of root is valid,
		// create1 a tree whose root is it
		if ((2 * loc) <= (data.length - 1)) {
			if (data[2 * loc] != null) {
				root.addLeft(new BiTreeNode<T>(data[2 * loc]));
				createTree(root._leftChild, data, 2 * loc);
			}
		}
		if ((2 * loc + 1) <= (data.length - 1)) {
			if (data[2 * loc + 1] != null) {
				root.addRight(new BiTreeNode<T>(data[2 * loc + 1]));
				createTree(root._rightChild, data, 2 * loc + 1);
			}
		}
	}

	public BiTreeNode<T> getRoot() {
		return _root;
	}

	public BiTree(T[] data) {
		// TODO Auto-generated constructor stub
		// note that the loc starts from 1 not 0
		_root = new BiTreeNode<T>(data[1]);
		createTree(_root, data, 1);
	}

	public BiTree(BiTreeNode<T> root) {
		// TODO Auto-generated constructor stub
		_root = root;
	}

	public int getDepth(BiTreeNode<T> node) {
		// if node is null return 0
		// return MAX(depth of left, depth of right)+1
		if (node == null)
			return 0;
		return 1 + Math.max(getDepth(node._leftChild), getDepth(node._rightChild));
	}

	public void preOrder(BiTreeNode<T> _node) {
		// note offer the correct note to _queue
		if (_node != null) {
			_queue.offer(_node);
			preOrder(_node._leftChild);
			preOrder(_node._rightChild);
		}
	}

	public void inOrder(BiTreeNode<T> _node) {
		// note offer the correct note to _queue
		if (_node != null) {
			inOrder(_node._leftChild);
			_queue.offer(_node);
			inOrder(_node._rightChild);
		}
	}

	public void postOrder(BiTreeNode<T> _node) {
		// note offer the correct note to _queue
		if (_node != null) {
			postOrder(_node._leftChild);
			postOrder(_node._rightChild);
			_queue.offer(_node);
		}
	}

	public void levelOrder() {
		// note offer the correct note to _queue
		clearQueue();
		_queue.offer(_root);
		_queue.offer(_root._leftChild);
		_queue.offer(_root._rightChild);
		BiTreeNode<T> left = _root._leftChild;
		BiTreeNode<T> right = _root._rightChild;
		while (!left.isLeaf()) {
			// System.out.println(_queue.size());
			if (!left.isLeaf()) {
				if (left._leftChild != null)
					_queue.offer(left._leftChild);
				if (left._rightChild != null)
					_queue.offer(left._rightChild);
				left = left._leftChild;
			}
			if (!right.isLeaf()) {
				if (right._leftChild != null)
					_queue.offer(right._leftChild);
				if (right._rightChild != null)
					_queue.offer(right._rightChild);
				right = right._rightChild;
			}
		}
	}

	public LinkedList<BiTreeNode<T>> getQueue() {
		return _queue;
	}

	// make queue empty
	public void clearQueue() {
		_queue.clear();
	}

	// search item in the tree whose root is _node in preOrder
	public BiTreeNode<T> searchPreOrder(BiTreeNode<T> _node, T item) {
		// if current node is item, return
		// search the next element in the treeld, item);
		if (_node == null)
			return null;
		if (_node.getData().equals(item))
			return _node;
		BiTreeNode<T> tmp = searchPreOrder(_node._leftChild, item);
		if (tmp != null)
			return tmp;
		tmp = searchPreOrder(_node._rightChild, item);
		if (tmp != null)
			return tmp;
		return null;
	}

	// search item in the tree whose root is _node in inOrder
	public BiTreeNode<T> searchInOrder(BiTreeNode<T> _node, T item) {
		// if current node is item, return
		// search the next element in the treeld, item);
		if (_node == null)
			return null;
		BiTreeNode<T> tmp = null;
		tmp = searchInOrder(_node._leftChild, item);
		if (tmp != null)
			return tmp;
		if (_node.getData().equals(item))
			return _node;
		tmp = searchInOrder(_node._rightChild, item);
		if (tmp != null)
			return tmp;
		return null;
	}

	// search item in the tree whose root is _node in postOrder
	public BiTreeNode<T> searchPostOrder(BiTreeNode<T> _node, T item) {
		// if current node is item, return
		// search the next element in the treeld, item);
		if (_node == null)
			return null;
		BiTreeNode<T> tmp = null;
		tmp = searchPostOrder(_node._leftChild, item);
		if (tmp != null)
			return tmp;
		tmp = searchPostOrder(_node._rightChild, item);
		if (tmp != null)
			return tmp;
		if (_node.getData().equals(item))
			return _node;
		return null;
	}

	// search item in this tree in levelOrder
	public BiTreeNode<T> SearchLevelOrder(T item) {
		// if current node is item, return
		// search the next element in the treeld, item);
		clearQueue();
		_queue.offer(_root._leftChild);
		_queue.offer(_root._rightChild);
		while (_queue != null) {
			BiTreeNode<T> left = _queue.poll();
			if (left.getData().equals(item))
				return left;
			_queue.offer(left._leftChild);
			_queue.offer(left._rightChild);

			BiTreeNode<T> right = _queue.poll();
			if (right.getData().equals(item))
				return right;
			_queue.offer(right._leftChild);
			_queue.offer(right._rightChild);
		}
		return null;
	}

}
