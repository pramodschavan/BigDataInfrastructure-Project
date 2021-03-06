package INST767.GirvanNewman;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

/***
 *
 * Data Structure of the graph node used for creating the graph.
 *
 * @author Namesh Kher, Sarika Hegde, Pramod Chavan
 *
 */

public class GraphNode implements WritableComparable<GraphNode> {

  private int left, right;

  // Default Constructor
  public GraphNode() {
  }

  // Parameterized constructor
  public GraphNode(int leftElem, int rightElem) {
    set(leftElem, rightElem);
  }

  public void set(int l, int r) {
    left = l;
    right = r;
  }

  public int getLeftElement() {
    return left;
  }

  public int getRightElement() {
    return right;
  }

  @Override
  public int compareTo(GraphNode pair) {
    int pl = pair.getLeftElement();
    int pr = pair.getRightElement();

    if (left == pl) {
      if (right < pr)
        return -1;
      if (left > pr)
        return 1;
      return 0;
    }

    if (left < pl)
      return -1;

    return 1;
  }

  @Override
  public IntsPair clone() {
    return new IntsPair(this.left, this.right);
  }

  @Override
  public boolean equals(Object obj) {
    IntsPair pair = (IntsPair) obj;
    return left == pair.getLeftElement() && right == pair.getRightElement();
  }

  @Override
  public void write(DataOutput out) throws IOException {
    out.write(left);
    out.write(right);
  }

  @Override
  public void readFields(DataInput in) throws IOException {
    left = in.readInt();
    right = in.readInt();
  }

  @Override
  public String toString() {
    return "[" + left + "," + right + "]";
  }

}
