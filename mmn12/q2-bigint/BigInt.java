import java.util.ArrayList;

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
        return  s;
    }

    /**
     * determines if input BigInt is equal by value to current bigInt
     * @param b1 -> BigInt to compare
     * @return -> if the values are equal
     */
    public boolean compareWithoutSign(BigInt b1){
        if (b1.bigIntList.size() != this.bigIntList.size())
            return false; // numbers not same length are not equal
        for (int i = this.bigIntList.size() -1; i >= 0; i --)
            if (b1.bigIntList.get(i) != this.bigIntList.get(i))
                return false;
        return true;
    }

    /**
     * implementing equals, only if two numbers are exact with same sign
     * @param b -> BigInt to compare
     * @return -> if BigInts are equal
     */
    public boolean equals(BigInt b) {
        return this.isPositive == b.isPositive && compareWithoutSign(b);
    }
}
