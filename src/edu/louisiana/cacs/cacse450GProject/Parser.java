package edu.louisiana.cacs.cacse450GProject;

import java.io.*;
import java.util.*;

public class Parser {
	public Parser()
    {
        data = new ArrayList();
        dataInner = null;
    }

    public void parse()throws IOException{
    	String inputToken = getInputToken();
    	getLRParseTree(inputToken);
    }

    public String getInputToken () throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("sample.txt"));
            StringBuilder sb = new StringBuilder();
            String inputToken = br.readLine();
            return inputToken;
            
    }

    public void printlnSpace1(int i)
    {
        for(; i < 40; i++)
            System.out.println(" ");

    }

    public void getLRParseTree(String inputToken)
    {
        Stack stack = new Stack();
        stack.push("0");
        String rule1 = "E-->>E+T";
        String rule2 = "E-->>T";
        String rule3 = "T-->>T*F";
        String rule4 = "T-->>F";
        String rule5 = "F-->>(E)";
        String rule6 = "F-->>id";
        String parseTreeStack = "";
        String actionValue = "";
        String action[][] = new String[13][10];
        action[0][0] = "State";
        action[0][1] = "id";
        action[0][2] = "+";
        action[0][3] = "*";
        action[0][4] = "(";
        action[0][5] = ")";
        action[0][6] = "$";
        action[0][7] = "E";
        action[0][8] = "T";
        action[0][9] = "F";
        action[1][0] = "0";
        action[1][1] = "S5";
        action[1][2] = "";
        action[1][3] = "";
        action[1][4] = "S4";
        action[1][5] = "";
        action[1][6] = "";
        action[1][7] = "1";
        action[1][8] = "2";
        action[1][9] = "3";
        action[2][0] = "1";
        action[2][1] = "";
        action[2][2] = "S6";
        action[2][3] = "";
        action[2][4] = "";
        action[2][5] = "";
        action[2][6] = "accept";
        action[2][7] = "";
        action[2][8] = "";
        action[2][9] = "";
        action[3][0] = "2";
        action[3][1] = "";
        action[3][2] = "R2";
        action[3][3] = "S7";
        action[3][4] = "";
        action[3][5] = "R2";
        action[3][6] = "R2";
        action[3][7] = "";
        action[3][8] = "";
        action[3][9] = "";
        action[4][0] = "3";
        action[4][1] = "";
        action[4][2] = "R4";
        action[4][3] = "R4";
        action[4][4] = "";
        action[4][5] = "R4";
        action[4][6] = "R4";
        action[4][7] = "";
        action[4][8] = "";
        action[4][9] = "";
        action[5][0] = "4";
        action[5][1] = "S5";
        action[5][2] = "";
        action[5][3] = "";
        action[5][4] = "S4";
        action[5][5] = "";
        action[5][6] = "";
        action[5][7] = "8";
        action[5][8] = "2";
        action[5][9] = "3";
        action[6][0] = "5";
        action[6][1] = "";
        action[6][2] = "R6";
        action[6][3] = "R6";
        action[6][4] = "";
        action[6][5] = "R6";
        action[6][6] = "R6";
        action[6][7] = "";
        action[6][8] = "";
        action[6][9] = "";
        action[7][0] = "6";
        action[7][1] = "S5";
        action[7][2] = "";
        action[7][3] = "";
        action[7][4] = "S4";
        action[7][5] = "";
        action[7][6] = "";
        action[7][7] = "";
        action[7][8] = "9";
        action[7][9] = "3";
        action[8][0] = "7";
        action[8][1] = "S5";
        action[8][2] = "";
        action[8][3] = "";
        action[8][4] = "S4";
        action[8][5] = "";
        action[8][6] = "";
        action[8][7] = "";
        action[8][8] = "";
        action[8][9] = "10";
        action[9][0] = "8";
        action[9][1] = "";
        action[9][2] = "S6";
        action[9][3] = "";
        action[9][4] = "";
        action[9][5] = "S11";
        action[9][6] = "";
        action[9][7] = "";
        action[9][8] = "";
        action[9][9] = "";
        action[10][0] = "9";
        action[10][1] = "";
        action[10][2] = "R1";
        action[10][3] = "S7";
        action[10][4] = "";
        action[10][5] = "R1";
        action[10][6] = "R1";
        action[10][7] = "";
        action[10][8] = "";
        action[10][9] = "";
        action[11][0] = "10";
        action[11][1] = "";
        action[11][2] = "R3";
        action[11][3] = "R3";
        action[11][4] = "";
        action[11][5] = "R3";
        action[11][6] = "R3";
        action[11][7] = "";
        action[11][8] = "";
        action[11][9] = "";
        action[12][0] = "11";
        action[12][1] = "";
        action[12][2] = "R5";
        action[12][3] = "R5";
        action[12][4] = "";
        action[12][5] = "R5";
        action[12][6] = "R5";
        action[12][7] = "";
        action[12][8] = "";
        action[12][9] = "";
        int count = 0;
        String previousLookup = "";
        String previousInput = "";
        do
        {
            String state = ((String)stack.lastElement()).replaceAll("id", "").replaceAll("E", "").replaceAll("F", "").replaceAll("T", "").replaceAll("\\+", "").replaceAll("\\*", "").replaceAll("\\(", "").replaceAll("\\)", "");
            String inputVar = "";
            if(inputToken.startsWith("id"))
                inputVar = inputToken.substring(0, 2);
            else
                inputVar = inputToken.substring(0, 1);
            actionValue = "";
            int stateIndex = 0;
            int varIndex = 0;
            for(int i = 0; i < 13; i++)
                if(action[i][0].equals(state))
                    stateIndex = i;

            for(int i = 0; i < 10; i++)
                if(action[0][i].equals(inputVar))
                    varIndex = i;

            actionValue = action[stateIndex][varIndex].toUpperCase();
            dataInner = new ArrayList();
            dataInner.add(stack.toString());
            dataInner.add(inputToken);
            dataInner.add((new StringBuilder("[ ")).append(state).append(" , ").append(inputVar).append(" ]").toString());
            dataInner.add(action[stateIndex][varIndex]);
            previousLookup = (new StringBuilder("[ ")).append(state).append(" , ").append(inputVar).append(" ]").toString();
            previousInput = inputToken;
            if(actionValue.equals(""))
                break;
            if(actionValue.toUpperCase().startsWith("S"))
            {
                stack.push((new StringBuilder(String.valueOf(inputVar))).append(actionValue.split("S")[1]).toString());
                if(inputVar.equals("+") || inputVar.equals("*") || inputVar.equals("(") || inputVar.equals(")"))
                    inputVar = (new StringBuilder("\\")).append(inputVar).toString();
                inputToken = inputToken.replaceFirst(inputVar, "");
                if(inputVar.equalsIgnoreCase("id"))
                {
                    parseTreeStack = (new StringBuilder("id:")).append(parseTreeStack).toString();
                    if(parseTreeStack.length() == 3)
                        parseTreeStack = parseTreeStack.substring(0, 2);
                }
                dataInner.add("");
                dataInner.add("");
                dataInner.add("");
                dataInner.add("");
                inputVar = inputVar.replace("\\", "");
                dataInner.add((new StringBuilder("push ")).append(inputVar).append(actionValue.split("S")[1]).toString());
                dataInner.add(parseTreeStack);
            } else
            {
                if(!actionValue.toUpperCase().startsWith("R"))
                    break;
                String ruleNo = actionValue.replace("R", "");
                String LHS = "";
                String RHS = "";
                String goTo = "";
                String tempState = "";
                if(ruleNo.equals("1"))
                {
                    LHS = rule1.split("-->>")[0];
                    RHS = rule1.split("-->>")[1];
                } else
                if(ruleNo.equals("2"))
                {
                    LHS = rule2.split("-->>")[0];
                    RHS = rule2.split("-->>")[1];
                } else
                if(ruleNo.equals("3"))
                {
                    LHS = rule3.split("-->>")[0];
                    RHS = rule3.split("-->>")[1];
                } else
                if(ruleNo.equals("4"))
                {
                    LHS = rule4.split("-->>")[0];
                    RHS = rule4.split("-->>")[1];
                } else
                if(ruleNo.equals("5"))
                {
                    LHS = rule5.split("-->>")[0];
                    RHS = rule5.split("-->>")[1];
                } else
                if(ruleNo.equals("6"))
                {
                    LHS = rule6.split("-->>")[0];
                    RHS = rule6.split("-->>")[1];
                }
                int l = RHS.length() != 2 ? RHS.length() : 1;
                dataInner.add(LHS);
                dataInner.add(Integer.valueOf(l));
                if(RHS.length() == 3)
                {
                    stack.pop();
                    stack.pop();
                    stack.pop();
                } else
                {
                    stack.pop();
                }
                tempState = (String)stack.lastElement();
                tempState = tempState.replaceAll("\\+", "").replaceAll("\\*", "").replaceAll("id", "").replaceAll("E", "").replaceAll("T", "").replaceAll("F", "").replaceAll("\\(", "").replaceAll("\\)", "");
                int stackInt = Integer.parseInt(tempState) + 1;
                if(LHS.equals("E"))
                {
                    goTo = action[stackInt][7];
                    dataInner.add((new StringBuilder("[")).append(stackInt - 1).append(" , E ]").toString());
                } else
                if(LHS.equals("T"))
                {
                    goTo = action[stackInt][8];
                    dataInner.add((new StringBuilder("[")).append(stackInt - 1).append(" , T ]").toString());
                } else
                if(LHS.equals("F"))
                {
                    goTo = action[stackInt][9];
                    dataInner.add((new StringBuilder("[")).append(stackInt - 1).append(" , F]").toString());
                }
                stack.push((new StringBuilder(String.valueOf(LHS))).append(goTo).toString());
                if(!inputVar.equalsIgnoreCase("id") && parseTreeStack.startsWith("id"))
                    parseTreeStack = (new StringBuilder("[ ")).append(LHS).append(" id ]").append(parseTreeStack.substring(2, parseTreeStack.length())).toString();
                else
                if(parseTreeStack.contains((new StringBuilder(":[ ")).append(LHS).toString()))
                {
                    String parseTreeStackArray[] = parseTreeStack.split(":");
                    int matched = 0;
                    if(RHS.length() == 3)
                    {
                        for(int i = 1; i < parseTreeStackArray.length; i++)
                        {
                            if(!parseTreeStackArray[i].startsWith((new StringBuilder("[ ")).append(LHS).toString()))
                                continue;
                            matched = i;
                            break;
                        }

                        parseTreeStack = (new StringBuilder("[ ")).append(LHS).append(" ").append(parseTreeStackArray[matched]).append(" ").append(RHS.charAt(1)).toString();
                        for(int i = 0; i < parseTreeStackArray.length; i++)
                            if(i < matched)
                                parseTreeStack = (new StringBuilder(String.valueOf(parseTreeStack))).append(parseTreeStackArray[i]).toString();

                        parseTreeStack = (new StringBuilder(String.valueOf(parseTreeStack))).append(" ]").toString();
                        for(int i = matched + 1; i < parseTreeStackArray.length; i++)
                            parseTreeStack = (new StringBuilder(String.valueOf(parseTreeStack))).append(":").append(parseTreeStackArray[i]).toString();

                    } else
                    {
                        for(int i = 1; i < parseTreeStackArray.length; i++)
                        {
                            if(!parseTreeStackArray[i].startsWith((new StringBuilder("[ ")).append(LHS).toString()))
                                continue;
                            matched = i;
                            break;
                        }

                        parseTreeStack = (new StringBuilder("[ ")).append(LHS).append(" ").append(parseTreeStackArray[matched]).append(" ]").toString();
                        for(int i = 0; i < parseTreeStackArray.length; i++)
                            if(i != matched)
                                parseTreeStack = (new StringBuilder(String.valueOf(parseTreeStack))).append(":").append(parseTreeStackArray[i]).toString();

                    }
                } else
                {
                    String parseTreeStackTemp = (new StringBuilder("[ ")).append(LHS).append(" ").append(parseTreeStack.split(":")[0]).append(" ]").toString();
                    String parseTreeStackArray[] = parseTreeStack.split(":");
                    parseTreeStack = parseTreeStackTemp;
                    for(int i = 1; i < parseTreeStackArray.length; i++)
                        parseTreeStack = (new StringBuilder(String.valueOf(parseTreeStack))).append(":").append(parseTreeStackArray[i]).toString();

                }
                dataInner.add(goTo);
                dataInner.add((new StringBuilder("push ")).append(LHS).append(goTo).toString());
                dataInner.add(parseTreeStack);
            }
            count++;
            data.add(dataInner);
        } while(!actionValue.equalsIgnoreCase("accept"));
        if(actionValue.equalsIgnoreCase("accept"))
        {
            ArrayList str = new ArrayList();
            str.add(stack.toString());
            str.add(previousInput);
            str.add(previousLookup);
            str.add("accept");
            str.add("");
            str.add("");
            str.add("");
            str.add("");
            str.add("");
            str.add(parseTreeStack);
            data.add(str);
            String columnName[] = {
                "Stack", "Input Tokens", "Action Lookup", "Action Value", "value of LHS", "Length of RHS", "Goto Lookup", "Goto Value", "Stack Action", "Parse Tree Stack"
            };
            Object output[][] = new Object[data.size()][10];
            int k1 = 0;
            for(Iterator iterator = data.iterator(); iterator.hasNext();)
            {
                ArrayList data1 = (ArrayList)iterator.next();
                int j = 0;
                for(Iterator iterator1 = data1.iterator(); iterator1.hasNext();)
                {
                    Object data2 = iterator1.next();
                    output[k1][j] = data2;
                    j++;
                }

                k1++;
            }

            TextTable tt = new TextTable(columnName, output);
            System.out.println("\n\nPATTERN IS ACCEPTED");
            System.out.println((new StringBuilder(String.valueOf(previousInput))).append(" ").append(previousLookup).toString());
            tt.printTable();
            System.out.println("********* PARSE TREE ***********");
            try
            {
                saveToFile(tt, parseTreeStack);
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        } else
        {
            System.out.println("------>>>>>> PATTERN IS NOT ACCEPTED <<<<<-----");
        }
    }

    private void saveToFile(TextTable tt, String parseTreeStack)
        throws IOException
    {
        File file = new File("Output.txt");
        try
        {
            tt.printTable(new PrintStream(file), 0);
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        FileWriter fileWritter = new FileWriter(file.getName(), true);
        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        char ch[] = parseTreeStack.toCharArray();
        int countSpace = 0;
        int flag = 1;
        for(int i = 0; i < ch.length; i++)
            if(ch[i] != '[' && ch[i] != ']' && ch[i] != ' ')
            {
                if(ch[i] == '+' || ch[i] == '*')
                    countSpace = 3 * flag++;
                for(int x = 0; x < countSpace; x++)
                {
                    bufferWritter.write(" ");
                    System.out.print(" ");
                }

                if(ch[i] != '+' && ch[i] != '*')
                    countSpace += 3;
                if(ch[i] == 'i')
                {
                    System.out.println((new StringBuilder(String.valueOf(ch[i]))).append(ch[++i]).toString());
                    bufferWritter.write((new StringBuilder(String.valueOf(ch[i]))).append(ch[++i]).append("\n").toString());
                } else
                if(ch[i] != ' ')
                {
                    bufferWritter.write((new StringBuilder(String.valueOf(ch[i]))).append("\n").toString());
                    System.out.println(ch[i]);
                }
            }

        bufferWritter.close();
    }

    ArrayList data;
    ArrayList dataInner;
	
	
}
