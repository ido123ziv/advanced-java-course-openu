import java.util.ArrayList;
import java.util.Map;

public class BigInt implements Comparable{
    private ArrayList<Integer> bigIntList = new ArrayList<Integer>();
    private boolean isPositive;

    /**
     * Builds a list of bigint from input string
     * @param num -> string represent the BigInt
     * @throws IllegalArgumentException -> exception if string is invalid
     */
    public BigInt(String num) throws IllegalArgumentException{
        if(num.length() == 0 ) { // edge case for empty number
            isPositive = true;
            bigIntList.add(0);
        }
        else {
            char workingChar = num.charAt(0); // available if not empty
            if ((workingChar != '+') && (workingChar != '-')){
                if ((workingChar < '0') || (workingChar > '9')) { // first char is not sign or digit
                    throw new IllegalArgumentException("Invalid Number");
                } else {
                    isPositive = true; // default for numbers without sign will be positive
                }
            }
            else {
                isPositive = workingChar == '+'; // the first char is a sign, so it will determine the sign var
            }
            // removing 0 from the left of the string
            boolean notZero = false;
            int workingCharIndex = 0;
            while (!notZero && workingCharIndex < num.length()){
                if (workingChar != '0')
                    notZero = true;
                else {
                    workingCharIndex++;
                    workingChar = num.charAt(workingCharIndex);
                }
            }
//            parse the string to int from end to beginning
            for (int i = num.length() -1; i > 0; i --){
                if (!Character.isDigit(num.charAt(i)))
                    throw new IllegalArgumentException("Input Must be Digit");
                else
                    bigIntList.add(Character.getNumericValue(num.charAt(i)));
            }
        }
    }

    /**
     * builds a new BigInt from parsed inputs
     * @param newList -> list of numbers
     * @param sign -> sign of bigint
     */
    public BigInt(ArrayList<Integer> newList, boolean sign){
        this.bigIntList = newList;
        isPositive = sign;
    }

    /**
     * Builder for an empty Bigint
     */
    public BigInt(){
        this.bigIntList.add(0);
        this.isPositive=true;
    }

    /**
     * adds another big int to current
     * @param b -> BigInt to add
     * @return -> the sum result
     */
    public BigInt plus(BigInt b){
        if (this.isPositive == b.isPositive) // if they share a sign
            return add(this,b);
        if (this.isPositive)
            return sub(this, b);
        return sub(b, this);
    }

    /**
     * adds two big ints
     * @param b1 -> first big int
     * @param b2 -> second big int
     * @return -> the result of the sum of the two
     */
    private BigInt add(BigInt b1, BigInt b2){
        ArrayList<Integer> newBigIntList = new ArrayList<Integer>();
        int sum = 0, carry = 0;
        int jointLength = Math.max(b1.bigIntList.size(), b2.bigIntList.size()); // go for the larger big int
        for (int i = 0; i < jointLength; i ++){
            int x1 = 0, x2 = 0;
            if (b1.bigIntList.size() >= i) // if didn't finish b1
                x1 = b1.bigIntList.get(i);
            if (b2.bigIntList.size() >= i) // if didn't finish b2
                x2 = b2.bigIntList.get(i);
            sum = x1 + x2 + carry;
            carry = sum / 10;  // this will set carry to 0 if sum is less than 10 otherwise will carry it
            if (sum > 9){ // if sum is two or more digits we need to take just the units digit
                sum = sum % 10;
            }
            newBigIntList.add(sum);
        }
        while (carry != 0){ // if carry remains
            newBigIntList.add(carry % 10);
            carry = carry / 10;
        }
        return new BigInt(newBigIntList, b1.isPositive);
    }

    /**
     * subs a big int  form a big int
     * @param b1 -> first big int
     * @param b2 -> second big int
     * @return -> the result of the subtraction
     */
    private BigInt sub(BigInt b1, BigInt b2){
        int cmp = compareWithoutSign(b1, b2);
        if (cmp == 0 && b1.isPositive == b2.isPositive)
            return new BigInt(); // edge case, both BigInts are equal
        BigInt bigger, smaller;
        ArrayList<Integer> newBigIntList = new ArrayList<Integer>();
        boolean newBigIntPositive;
        int tmp = 0, sum;
        if (cmp > 0){ // b1 > b2
            bigger = b1;
            smaller = b2;
            newBigIntPositive= b1.isPositive;
            // if b1 is positive and b2 is positive and smaller result will be positive
            // if b1 is positive and b2 is negative result will be positive
            // if b1 is negative and b2 is positive and smaller result will be negative
            // if b1 is negative and b2 is negative, we know that b1 is bigger so the result will be negative
        }
        else { // b1 < b2 || |b2| == |b1|
            bigger = b2;
            smaller = b1;
            // if b1 is positive and b2 is positive and bigger result will be negative
            // if b1 is positive and b2 is negative result will be positive
            // if b1 is negative and b2 is positive and smaller result will be negative
            // if b1 is negative and b2 is negative, we know that b2 is bigger so the result will be positive
            newBigIntPositive = !b2.isPositive;
        }
        int x1=0,x2=0;
        for (int i = 0; i < b1.bigIntList.size() ;i++) {
            x1 = bigger.bigIntList.get(i);
            x2=0;
            if (b2.bigIntList.size() >= i)
                x2 = smaller.bigIntList.get(i);
            sum = x1 - x2 + tmp;
            tmp = 0;
            while (sum + ((-tmp) * 10 ) < 0) {
                tmp -= 1;
            }
            sum += ((-tmp) * 10);
            newBigIntList.add(sum);
        }
        // removes 0's from beginning
        while (newBigIntList.size() > 0 && newBigIntList.get(newBigIntList.size() - 1) == 0)
            newBigIntList.remove(newBigIntList.size() -1 );
        return new BigInt(newBigIntList,newBigIntPositive);
    }

    /**
     * subtract a big int from current
     * @param b -> big int to subtract
     * @return -> Big int of the current minus input
     */
    public BigInt minus(BigInt b){
        return this.plus(new BigInt(b.bigIntList,!b.isPositive));
    }

    public BigInt multiply(BigInt b){
        BigInt res = new BigInt();
        int tmp;
        for (int i = 0; i < b.bigIntList.size(); i ++){
            tmp = b.bigIntList.get(i);
            res = res.plus(this.mul(tmp, i));
        }
        res.isPositive = this.isPositive == b.isPositive;
        return res;
    }
    private BigInt mul(int x, int indexInBigInt){
        ArrayList<Integer> newBigIntList = new ArrayList<Integer>();
        int sum, tmp = 0;
        for (int i = 0; i < indexInBigInt; i ++)
            newBigIntList.add(0);
        for (int i = 0; i < this.bigIntList.size(); i++){
            sum = x * this.bigIntList.get(i);
            sum += tmp;
            tmp = 0;
            while (sum - (tmp * 10) >= 10)
                tmp += 1;
            sum -= tmp * 10;
            newBigIntList.add(sum);
        }
        while (tmp != 0){
            newBigIntList.add(tmp % 10);
            tmp = tmp / 10;
        }
        return new BigInt(newBigIntList, true);

    }

    /**
     *
     * @return a string representing BitInt
     */
    @Override
    public String toString() {
        String s = "";
        if (this.isPositive)
            s += '+';
        else
            s += '-';
        for (int i = bigIntList.size() -1 ; i >= 0; i--){
            s += bigIntList.get(i).toString();
        }
        if (bigIntList.size() == 0)
            return "0";
        return  s;
    }

    /**
     * determines if input BigInt is equal by value to current bigInt
     * @param b1 -> BigInt to compare
     * @return -> if the values are equal
     */
    public int compareWithoutSign(BigInt b1){
        return compareWithoutSign(this,b1);
    }

    /**
     * determines which input BigInt is bigger by value to current bigInt
     * @param b1 -> first big int
     * @param b2 -> second big int
     * @return -> who is bigger b1 is 1, b2 is -1, 0 is equal
     */
    public int compareWithoutSign(BigInt b1, BigInt b2){
 // numbers not same length are not equal
        if (b1.bigIntList.size() > b2.bigIntList.size())
            return -1;
        if (b1.bigIntList.size() < b2.bigIntList.size())
            return 1;
        for (int i = b2.bigIntList.size() -1; i >= 0; i --){
            if (b1.bigIntList.get(i) > b2.bigIntList.get(i))
                return -1;
            if (b1.bigIntList.get(i) < b2.bigIntList.get(i))
                return 1;
        }
        return 0;
    }

    /**
     * implementing equals, only if two numbers are exact with same sign
     * @param b -> BigInt to compare
     * @return -> if BigInts are equal
     */
    public boolean equals(BigInt b) {
        return this.isPositive == b.isPositive && compareWithoutSign(b) == 0;
    }

    /**
     * Implementing compareTo
     * @param o the object to be compared.
     * @return -> who is bigger me is 1, o is -1, 0 is equal
     */
    @Override
    public int compareTo(Object o) {
        BigInt big = (BigInt)o;
        if (big.isPositive != this.isPositive){ //signs are not equal
            if (this.isPositive) return 1;
            return -1;
        }
        int sign = 1;
        if (!this.isPositive)//if the numbers are negative so the larger number is the one with the smaller by value
            sign = -1;
        return compareWithoutSign(big) * sign;
    }
}
