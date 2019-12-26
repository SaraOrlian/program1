package dspa2;

import java.io.*;
import java.util.*;

/**
 * DSPA2 takes a file as an argument and reads each character as an int, converts it to a char,
 * and then pushes the parenthesis to a stack and pops them if matching
 * @author Sara O
 */
public class DSPA2
{
    public static void main(String[] args)
    {
        String fileName = args[0];
        File file = new File(fileName);

        Stack<Character> parenthesisParser = new Stack<>();

        try
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            int character;
            while ((character = br.read()) != -1)
            {
                char chara = (char) character;
                if (chara == '(' || chara == '{' || chara == '[')
                {
                    parenthesisParser.push(chara);

                } else if (chara == ')' || chara == '}' || chara == ']')
                {
                    if (parenthesisParser.empty())
                    {
                        System.out.println("Not well-formed.");
                        System.exit(-1);
                    } else
                    {
                        char pointer = parenthesisParser.peek();

                        if ((pointer == '(' && chara == ')')
                                || (pointer == '{' && chara == '}')
                                || (pointer == '[' && chara == ']'))
                        {
                            parenthesisParser.pop();
                        }
                    }

                }
            }
        } catch (Exception ex)
        {
            System.out.println("File error: " + ex);
            System.exit(1);
        }
        if (parenthesisParser.empty())
        {
            System.out.println("Well-formed.");
        } else
        {
            System.out.println("Not Well-formed.");
        }

    }
}
