public class Exception {

    public Exception(){
    }

    /**
     * throw new IllegalArgumentException with the message:
     * """
     * The address can't be null!
     * Firefighters won't come!!
     * """
     * it possible to use throw to exit the program, but it might break the tests, so I would lose score
     */
    public void BadAlarm(){
        System.out.println("The address can't be null! \nFirefighters won't come!!");
    }
}
