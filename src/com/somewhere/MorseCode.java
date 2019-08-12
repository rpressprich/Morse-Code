package com.somewhere;

import java.util.Scanner;

public class MorseCode
{
  private static String alphaNumerals = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ.,:;?!'\"() ";
  private static String[] morseAlphaNumerals = new String[]
  {"-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", ".-", "-...", "-.-.",
      "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...",
      "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
      ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
      "--..", "--..--", ".-.-.-", "---...", "-.-.-.", "..--..", "-.-.--", ".----.", ".-..-.", "-.--.", "-.--.-", "/"};

  public static String inputSentence;
  private static String morseOutput;
  public static String morseInput;
  private static String outputSentence;

  public static void main(String[] args)
  {
    Scanner scanner = new Scanner(System.in);
    String choice;

    System.out.print("1 for alphanumerals to morse, 2 for morse to alphanumerals: ");
    choice = scanner.nextLine();

    if (choice.equals("1"))
    {
      inputSentence = scanner.nextLine();
      morseOutput = convertToMorse(inputSentence);
      System.out.println(morseOutput);
    }
    if (choice.equals("2"))
    {
      morseInput = scanner.nextLine();
      outputSentence = convertToAlphaNumerals(morseInput);
      System.out.println(outputSentence);
    }

    scanner.close();
  }

  public static String convertToMorse(String inputSentence)
  {
    String morseOutput = "";

    for (int i = 0; i < inputSentence.length(); i++)
    {
      morseOutput += charToMorse(inputSentence.charAt(i)) + " ";
    }
    return morseOutput;
  }

  private static String charToMorse(char letter)
  {
    String letterString = "" + letter;
    if (alphaNumerals.contains(letterString))
    {
      return morseAlphaNumerals[alphaNumerals.indexOf(letter)];
    }
    return "Invalid character";
  }

  public static String convertToAlphaNumerals(String morseInput)
  {
    String morseLetter;
    outputSentence = "";

    while (morseInput.length() > 0)
    {
      morseLetter = morseInput.substring(0, morseInput.indexOf(" "));
      morseInput = morseInput.substring(morseInput.indexOf(" ") + 1);
      outputSentence += morseToChar(morseLetter);
    }

    return outputSentence;
  }

  private static char morseToChar(String morseLetter)
  {

    for (int i = 0; i < morseAlphaNumerals.length; i++)
    {
      if (morseLetter.equals(morseAlphaNumerals[i])) // Looks up the morse's location
      {
        return alphaNumerals.charAt(i); // Adds the matching character for the morse
      }
    }
    return '*';
  }
}
