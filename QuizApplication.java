import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication 
{
    private static int QUESTION_COUNT = 5;
    private static int QUESTION_TIME_LIMIT = 5;
    private static int count = 0;
    private static int currentQuestionIndex = 0;

    private static String[] questions = 
    {
        "Number of primitive data types in java?",
        "What is the size of float and double in java?",
        "Arrays in java are?",
        "When is the object created with new keyword?",
        "compareTo() returns?"
    };

    private static String[][] options = {
        {"A. 6", "B. 7", "C. 8", "D. 5"},
        {"A. 32 and 64", "B. 32 and 32", "C. 64 and 64", "D. 64 and 32"},
        {"A. Object references", "B. objects", "C. Primitive data type", "D. None"},
        {"A. At run time", "B. At compile time", "C. Depends on the code", "D. None"},
        {"A. True", "B. False", "C. An int value", "D. None"}
    };

    private static char[] answers = {'C', 'A', 'B', 'A', 'C'};

    public static void main(String[] args) 
    {
    	System.out.println("Welcome rTo Quiz Application");
        displayNextQuestion();
    }

    private static void displayNextQuestion() 
    {
        if (currentQuestionIndex < QUESTION_COUNT) 
        {
        	System.out.println();
            System.out.println("Question " + (currentQuestionIndex + 1) + ": " + questions[currentQuestionIndex]);
            for (String option : options[currentQuestionIndex]) 
            {
                System.out.println(option);
            }
            startTimer();
            getUserAnswer();
        } 
        else 
        {
            displayResult();
        }
    }

    private static void startTimer() 
    {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() 
        {
            @Override
            public void run() 
            {
                System.out.println("\nTime's up!");
                currentQuestionIndex++;
                displayNextQuestion();
            }
        }, QUESTION_TIME_LIMIT * 1000);
    }

    private static void getUserAnswer() 
    {
        System.out.print("Your answer: ");
        Scanner scanner = new Scanner(System.in);
        char userAnswer = scanner.next().toUpperCase().charAt(0);

        if (userAnswer == answers[currentQuestionIndex]) 
        {
            count++;
        } 
        else 
        {
        	currentQuestionIndex++;
            displayNextQuestion();
        }
    }

    private static void displayResult() 
    {
        System.out.println("Quiz Ended!");
        System.out.println("Your Score: " + count + "/" + QUESTION_COUNT);
    }
}
