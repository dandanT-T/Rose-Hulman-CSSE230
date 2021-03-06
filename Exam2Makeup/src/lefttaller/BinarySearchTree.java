package lefttaller;

/**
 * Exam 2. Tree methods.
 * 
 * @author You!
 */

/*
 * Directions: Implement the given method. See the paper for details.
 */
public class BinarySearchTree {

	BinaryNode root;

	private final BinaryNode NULL_NODE = new BinaryNode(null);

	public BinarySearchTree() {
		root = NULL_NODE;
	}

	public boolean isLeftAlwaysTaller() {
		if (this.root != NULL_NODE) {
			return this.root.isLeftAlwaysTaller();
		}
		return true;
	}

	/**
	 * Feel free to call from tests to use to verify the shapes of your trees
	 * while debugging. Just remove the calls you are done so the output isn't
	 * cluttered.
	 * 
	 * @return A string showing a traversal of the nodes where children are
	 *         indented so that the structure of the tree can be determined.
	 * 
	 */
	public String toIndentString() {
		return root.toIndentString("");
	}

	// The next methods are used by the unit tests
	public void insert(Character e) {
		root = root.insert(e);
	}

	@Override
	public String toString() {
		return root.toString();
	}

	// /////////////// BinaryNode
	public class BinaryNode {
		public Character data;
		public BinaryNode left;
		public BinaryNode right;

		// public int leftSum;
		// public int rightSum;

		public BinaryNode(Character element) {
			this.data = element;
			this.left = NULL_NODE;
			this.right = NULL_NODE;
			// this.leftSum = 0;
			// this.rightSum = 0;
		}

		// public BinaryNode(Character element){
		// this.data = element;
		// this.left = NULL_NODE;
		// this.right = NULL_NODE;
		// this.leftSum = 0;
		// this.rightSum = 0;
		// }

		public boolean isLeftAlwaysTaller() {
			int leftSum = this.left.sum();
			int rightSum = this.right.sum();
			if (leftSum == rightSum) {
				if (leftSum != 0)
					return false;
				return true;
			}
			if (leftSum > rightSum) {
				return this.left.isLeftAlwaysTaller();
			}

			return false;
		}

		public int sum() {
			if (this == NULL_NODE) {
				return 0;
			}
			if (this.left == NULL_NODE && this.right == NULL_NODE) {
				return 1;
			}
			if (this.left != NULL_NODE && this.right == NULL_NODE) {
				return 1 + this.left.sum();
			}
			if (this.right != NULL_NODE && this.left == NULL_NODE) {
				return 1 + this.right.sum();
			}
			return 2 + this.left.sum() + this.right.sum();
		}

		// The next 2 methods are used by the unit tests
		public BinaryNode insert(Character e) {
			if (this == NULL_NODE) {
				return new BinaryNode(e);
			} else if (e.compareTo(data) < 0) {
				left = left.insert(e);
			} else if (e.compareTo(data) > 0) {
				right = right.insert(e);
			} else {
				// do nothing
			}
			return this;
		}

		@Override
		public String toString() {
			if (this == NULL_NODE) {
				return "";
			}
			return left.toString() + this.data.toString() + right.toString();
		}

		public String toIndentString(String indent) {
			if (this == NULL_NODE) {
				return indent + "NULL\n";
			}

			String myInfo = indent + String.format("%c\n", this.data);

			return myInfo + this.left.toIndentString(indent + "  ")
					+ this.right.toIndentString(indent + "  ");
		}
	}
}