package cd;
import java.util.Objects;
import java.util.Arrays;
public class LR0Item extends Rule {
    protected int dotPointer;
    public LR0Item(Rule r) {
        super(r.getLeftSide(), r.getRightSide());
        int finished = 0;
        if (r.getRightSide().length == 1 && r.getRightSide()[0].equals("epsilon")) {
            finished = 1;
        }
        this.dotPointer = finished;
    }
    public LR0Item(String leftSide, String[] rightSide, int dotPointer) {
        super(leftSide, rightSide);
        this.dotPointer = dotPointer;
    }
    public LR0Item(LR0Item item) {
        super(item);
        dotPointer = item.getDotPointer();
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.dotPointer;
        hash = 89 * hash + Objects.hashCode(this.leftSide);
        hash = 89 * hash + Arrays.deepHashCode(this.rightSide);
        return hash;
    }
    @Override
    public String toString() {
        String str = leftSide + " -> ";
        for (int i = 0; i < rightSide.length; i++) {
            if (i == dotPointer) {
                str += ".";
            }
            str += rightSide[i];
            if(i != rightSide.length - 1){
                str+= " ";
            }
        }
        if (rightSide.length == dotPointer) {
                str += ".";
        }
        return str;
    }
    public int getDotPointer() {
        return dotPointer;
    }
    boolean goTo() {
        if (dotPointer >= rightSide.length) {
            return false;
        }
        dotPointer++;
        return true;
    }
    String getCurrentTerminal() {
        if(dotPointer == rightSide.length){
            return null;
        }
        return rightSide[dotPointer];
    }
}