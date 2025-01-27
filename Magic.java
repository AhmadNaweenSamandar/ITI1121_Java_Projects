public class Magic {
	public static void main(String[] args) {
    //original number
    int myNumber = 90;
    int stepOne = myNumber * myNumber;
    int stepTwo = myNumber + stepOne;
    int stepThree = stepTwo / myNumber;
    int stepFour = stepThree + 17;
    int stepFive = stepFour - myNumber;
    int stepSix = stepFive / 5;
    System.out.println(stepSix);

	}
}